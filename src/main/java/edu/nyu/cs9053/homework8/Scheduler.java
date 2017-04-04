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
}