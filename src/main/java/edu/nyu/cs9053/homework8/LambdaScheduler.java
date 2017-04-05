package edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaScheduler {

    private static final Comparator<LambdaJob> FINISHTIME_ORDER = 
                                        new Comparator<LambdaJob>() {
            public int compare(LambdaJob j1, LambdaJob j2) {
                return j1.getFinishTime().compareTo(j2.getFinishTime());
            }
    };

    private final ArrayList<LambdaJob> jobs;

    public LambdaScheduler(LambdaJob[] jobs){
        if(jobs.length == 0){
            throw new IllegalArgumentException();
        }
        this.jobs = new ArrayList<LambdaJob>(Arrays.asList(jobs));
    }

    public LambdaScheduler(Collection<LambdaJob> jobs){
        if(jobs == null){
            throw new IllegalArgumentException();
        }
        this.jobs = new ArrayList<LambdaJob>(jobs);
    }
    
    private void sortJobs(){
        Collections.sort(jobs, FINISHTIME_ORDER);
    }

    public ArrayList<LambdaJob> schedule(){
        sortJobs();
        ArrayList<LambdaJob> scheduledJob = Scheduler.findMaxJobSubset(jobs);
        return scheduledJob;
    }

}