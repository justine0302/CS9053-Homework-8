package edu.nyu.cs9053.homework8;

import java.util.*;

public abstract class Scheduler {

    public static ArrayList<LambdaJob> findMaxJobSubset(ArrayList<LambdaJob> jobs){

        ArrayList<LambdaJob> scheduledJob = new ArrayList<>();

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
                    currentJob = (ArrayList<LambdaWeightedJob>) scheduledJob.get(idx).clone();
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

    private static void printJob(ArrayList<ArrayList<LambdaWeightedJob>> jobsList){
        for(ArrayList<LambdaWeightedJob> jobs : jobsList){
        for(LambdaWeightedJob j : jobs){
            System.out.print(j.getWeight()+" ");
        }
        System.out.println();
    }
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