package edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaWeightedScheduler {

    private static final Comparator<LambdaWeightedJob> FINISHTIME_ORDER = 
                                        new Comparator<LambdaWeightedJob>() {
            public int compare(LambdaWeightedJob j1, LambdaWeightedJob j2) {
                return j1.getFinishTime().compareTo(j2.getFinishTime());
            }
    };

    private final ArrayList<LambdaWeightedJob> jobs;

    public LambdaWeightedScheduler(LambdaWeightedJob[] jobs){
        this.jobs = new ArrayList<LambdaWeightedJob>(Arrays.asList(jobs));
    }

    public LambdaWeightedScheduler(Collection<LambdaWeightedJob> jobs){
        this.jobs = new ArrayList<LambdaWeightedJob>(jobs);
    }
    
    private void sortJobs(){
        Collections.sort(jobs, FINISHTIME_ORDER);
    }

    public ArrayList<LambdaWeightedJob> schedule(){
        ArrayList<LambdaWeightedJob> scheduledJob = Scheduler.findMaxProfit(jobs);
        return scheduledJob;
    }

    
}
