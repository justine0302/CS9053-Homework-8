package edu.nyu.cs9053.homework8;

import java.util.*;

public class LambdaScheduler<T extends LambdaJob> extends AbstractScheduler<T>{

    private static final Comparator<LambdaJob> FINISHTIME_ORDER = 
                                        new Comparator<LambdaJob>() {
            public int compare(LambdaJob j1, LambdaJob j2) {
                return j1.getFinishTime().compareTo(j2.getFinishTime());
            }
    };
    
    private void sortJobs(){
        Collections.sort(super.getJobs(), FINISHTIME_ORDER);
    }
    
    public LambdaScheduler(Collection<T> jobs){
        super(jobs);
    }

    public LambdaScheduler(T[] jobs){
        super(jobs);
    }

    @Override public ArrayList<T> schedule(){
        sortJobs();
        ArrayList<T> scheduledJob = findMaxJobSubset(super.getJobs());
        return scheduledJob;
    }

    /* Solved with greedy algorithm */
    public ArrayList<T> findMaxJobSubset(ArrayList<T> jobs){

        ArrayList<T> scheduledJob = new ArrayList<T>();

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