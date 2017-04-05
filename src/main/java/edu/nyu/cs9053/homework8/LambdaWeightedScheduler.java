package edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaWeightedScheduler<T extends LambdaWeightedJob> extends AbstractScheduler<T>{

    private static final Comparator<LambdaWeightedJob> FINISHTIME_ORDER = 
                                        new Comparator<LambdaWeightedJob>() {
            public int compare(LambdaWeightedJob j1, LambdaWeightedJob j2) {
                return j1.getFinishTime().compareTo(j2.getFinishTime());
            }
    };

    @Override public ArrayList<T> schedule(ArrayList<T> jobs){
        if(jobs == null){
            throw new IllegalArgumentException();
        }
        Collections.sort(jobs, FINISHTIME_ORDER);
        ArrayList<T> scheduledJob = findMaxProfit(jobs);
        return scheduledJob;
    }



    /* Calculate the maximum profit by choosing the maximum profit of the two profits:
        (1) Maximum profit by excluding the job
        (2) Maximum profit by including the job

       Solved with dynamic programming:

        Assume jobs are already sorted by finish time.
        dp[i] means the maximum profit of a set of non-overlapping i jobs
        * initialize: dp[0] = jobs[0].weight
        * transit state:
            dp[i] = Math.max(dp[i - 1], dp[p[i - 1]] + jobs[i].weight), 
            where the p[i - 1] is the index with the finish time that is closest to the start time of jobs[i]
        * final state: dp[jobs.size - 1]
    */
    public ArrayList<T> findMaxProfit(ArrayList<T> jobs){

        //Store the jobs selected at each state
        ArrayList<ArrayList<T>> scheduledJob = new ArrayList<ArrayList<T>>(jobs.size());

        for(int i = 0; i < jobs.size(); i++)  {
            scheduledJob.add(new ArrayList<T>());
        }

        Double[] dp = new Double[jobs.size()];
        dp[0] = jobs.get(0).getWeight();
        scheduledJob.get(0).add(jobs.get(0));

        for (int i = 1; i < jobs.size(); i++) {
            Double noChoose = dp[i - 1]; // profit that doesn't include the job
            int idx = latestNonConflict(jobs, i);

            Double choose = jobs.get(i).getWeight();
            if(idx != -1){
                choose += dp[idx];
            }

            if(choose > noChoose){
                dp[i] = choose;
                ArrayList<T> currentJob = new ArrayList<T>();
                if(idx != -1){
                    currentJob = new ArrayList<T>(scheduledJob.get(idx));
                }
                currentJob.add(jobs.get(i));
                scheduledJob.set(i, currentJob);
            }
            else{
                dp[i] = noChoose;
                scheduledJob.set(i, scheduledJob.get(i - 1));
            }
        }

        return scheduledJob.get(jobs.size() - 1);
    }


    private int latestNonConflict(ArrayList<T> jobs, int i){

        for (int j = i - 1; j >= 0; j--){
            if (jobs.get(j).getFinishTime() <= jobs.get(i).getStartTime()){
               return j;
           }
        }
        return -1;
    }

    
}
