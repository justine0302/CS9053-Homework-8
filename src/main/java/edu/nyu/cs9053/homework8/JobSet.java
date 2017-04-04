package edu.nyu.cs9053.homework8;

import java.util.*;
// import java.util.Collection;
// import java.util.ArrayList;
// import java.util.Iterator;

public class JobSet<T extends Job> implements Iterable<T>{

    private final List<T> jobs;

    public JobSet(){
         jobs = new ArrayList<T>();
    }

    public void add(T job){
        this.jobs.add(job);
    }

    public Iterator<T> iterator(){
        return jobs.iterator();
    }

    public void sort(Comparator cmp){
        Collections.sort(jobs, cmp);
    }

    public JobSet findMaxJobSubset(){

        JobSet scheduledJob = new JobSet();

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