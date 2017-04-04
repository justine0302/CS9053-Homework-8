package edu.nyu.cs9053.homework8;

import java.util.*;
// import java.util.Collection;
// import java.util.ArrayList;
// import java.util.Iterator;

public class JobCreator implements Iterable<Job>{

    private final List<Job> jobs;

    public JobCreator(){
         jobs = new ArrayList<>();
    }

    public void add(Job job){
        this.jobs.add(job);
    }

    public Iterator<Job> iterator(){
        return jobs.iterator();
    }

}