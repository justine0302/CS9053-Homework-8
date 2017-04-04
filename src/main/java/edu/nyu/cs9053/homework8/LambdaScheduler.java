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

    public LambdaScheduler(Job[] jobs){
        this.jobs = new ArrayList(Arrays.asList(jobs));
    }

    public LambdaScheduler(ArrayList<LambdaJob> jobs){
        this.jobs = jobs;
    }
    
    public void sortJobs(){
        Collections.sort(jobs, FINISHTIME_ORDER);
    }

    public ArrayList<LambdaJob> schedule(){
        ArrayList<LambdaJob> scheduledJob = Scheduler.findMaxJobSubset(jobs);
        return scheduledJob;
    }



    public static void main(String args[]){
        
        Job jobArray[] = { new LambdaJob(3.0,4.0,2), new LambdaJob(0.0,6.0,3),  new LambdaJob(1.0,2.0,1),
            new LambdaJob(5.0,7.0,4), new LambdaJob(8.0,9.0,5), new LambdaJob(5.0,9.0,6)};
        
        // new ArrayList(Arrays.asList(jobArray));

        // JobSet<LambdaJob> jobs = new JobSet<LambdaJob>();
        // for(int i = 0; i < jobArray.length; i++){
        //     jobs.add(jobArray[i]);
        // }

        // jobs.sort(FINISHTIME_ORDER);

        // // for(LambdaJob j : jobs){
        // //     System.out.println(j.getFinishTime());
        // // }

        // JobSet<LambdaJob> scheduledJob = jobs.findMaxJobSubset();
        
        // for(LambdaJob j : scheduledJob){
        //     System.out.println(j.getLabel());
        // }

    }

    
}
