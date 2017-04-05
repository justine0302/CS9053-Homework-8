package edu.nyu.cs9053.homework8;

public abstract class AbstractJob implements Job{

    private final Double startTime;
    private final Double finishTime;

    protected AbstractJob(Double startTime, Double finishTime){
        if(startTime == null || finishTime == null || startTime >= finishTime){
            throw new IllegalArgumentException();
        }
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override public Double getFinishTime(){
        return finishTime;
    }

    @Override public Double getStartTime(){
        return startTime;
    }

}