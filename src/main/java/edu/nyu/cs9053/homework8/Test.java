package edu.nyu.cs9053.homework8;

import java.util.*;

public class Test{
    public static void main(String args[]){
        LambdaWeightedJob jobArray[] = { new LambdaWeightedJob(1.0,5.0,100.0),  new LambdaWeightedJob(1.0,2.0,50.0),
            new LambdaWeightedJob(6.0,19.0,120.0), new LambdaWeightedJob(2.0,100.0,50.0)};

        LambdaWeightedScheduler<LambdaWeightedJob> s = new LambdaWeightedScheduler<>(jobArray);
        ArrayList<LambdaWeightedJob> result = s.schedule();

        for(LambdaWeightedJob r : result){
            System.out.println(r.getStartTime() + " " + r.getFinishTime() + " " + r.getWeight());
        }

    }
}