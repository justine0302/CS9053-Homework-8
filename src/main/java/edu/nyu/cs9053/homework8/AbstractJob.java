package edu.nyu.cs9053.homework8;

public abstract class AbstractJob implements Job{

    private final Double startTime;
    private final Double finishTime;
    private final int label;

    public AbstractJob(Double startTime, Double finishTime, int label){
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.label = label;
    }

    public Double getFinishTime(){
        return finishTime;
    }

    public Double getStartTime(){
        return startTime;
    }

    public int getLabel(){
        return label;
    }

}