package edu.nyu.cs9053.homework8;

import java.util.*;

public abstract class SchedulerAlgorithm {

    /* Solved with greedy algorithm */
    public static ArrayList<LambdaJob> findMaxJobSubset(ArrayList<? extends LambdaJob> jobs){

        ArrayList<LambdaJob> scheduledJob = new ArrayList<LambdaJob>();

        int i = 0;
        scheduledJob.add(jobs.get(0));
        for(int j = 1; j < jobs.size(); j++){
            if (jobs.get(j).getStartTime() >= jobs.get(i).getFinishTime())
            {
              scheduledJob.add(jobs.get(j));
              i = j;
            }
        }

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
    public static ArrayList<LambdaWeightedJob> findMaxProfit(ArrayList<LambdaWeightedJob> jobs){

        //Store the jobs selected at each state
        ArrayList<ArrayList<LambdaWeightedJob>> scheduledJob = new ArrayList<ArrayList<LambdaWeightedJob>>(jobs.size());

        for(int i = 0; i < jobs.size(); i++)  {
            scheduledJob.add(new ArrayList<LambdaWeightedJob>());
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
                ArrayList<LambdaWeightedJob> currentJob = new ArrayList<LambdaWeightedJob>();
                if(idx != -1){
                    currentJob = new ArrayList<LambdaWeightedJob>(scheduledJob.get(idx));
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


    private static int latestNonConflict(ArrayList<LambdaWeightedJob> jobs, int i){

        for (int j = i - 1; j >= 0; j--){
            if (jobs.get(j).getFinishTime() <= jobs.get(i).getStartTime()){
               return j;
           }
        }
        return -1;
    }
    
}