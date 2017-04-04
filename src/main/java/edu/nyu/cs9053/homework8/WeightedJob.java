package edu.nyu.cs9053.homework8;

//change to weightedLambdaJob extends LambdaJob
public class WeightedJob extends AbstractJob{

    private final Double weight;

    WeightedJob(Double startTime, Double finishTime, Double weight, int label){
        super(startTime, finishTime, label);
        this.weight = weight;
    }

    public Double getWeight(){
        return weight;
    }

}