package edu.nyu.cs9053.homework8;

import java.util.*;

public class Test{
    public static void main(String args[]){
        Job jobArray[] = { new LambdaWeightedJob(3.0,5.0,20.0),  new LambdaWeightedJob(1.0,2.0,50.0),
            new LambdaWeightedJob(6.0,19.0,100.0), new LambdaWeightedJob(2.0,100.0,200.0)};

        LambdaWeightedScheduler s = new LambdaWeightedScheduler(jobArray);
        ArrayList<LambdaWeightedJob> result = s.schedule();

        for(LambdaWeightedJob r : result){
            System.out.println(r.getStartTime() + " " + r.getFinishTime() + " " + r.getWeight());
        }

    }
}