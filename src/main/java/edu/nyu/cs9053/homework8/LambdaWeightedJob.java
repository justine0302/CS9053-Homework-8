package edu.nyu.cs9053.homework8;

public class LambdaWeightedJob extends LambdaJob{

    private final Double weight;

    LambdaWeightedJob(Double startTime, Double finishTime, Double weight){
        super(startTime, finishTime);
        this.weight = weight;
    }

    public Double getWeight(){
        return weight;
    }

}