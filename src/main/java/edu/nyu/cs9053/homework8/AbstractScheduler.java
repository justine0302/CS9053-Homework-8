package edu.nyu.cs9053.homework8;

import java.util.*;

public abstract class AbstractScheduler<T extends Job> implements Scheduler<T>{

    private final ArrayList<T> jobs;

    public AbstractScheduler(){
        throw new IllegalArgumentException();
    }

    public AbstractScheduler(T[] jobs){
        if(jobs.length == 0){
            throw new IllegalArgumentException();
        }
        this.jobs = new ArrayList<T>(Arrays.asList(jobs));
    }

    public AbstractScheduler(Collection<T> jobs){
        if(jobs == null){
            throw new IllegalArgumentException();
        }
        this.jobs = new ArrayList<T>(jobs);
    }

    protected ArrayList<T> getJobs(){
        return jobs;
    }
 
}