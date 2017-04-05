package edu.nyu.cs9053.homework8;

import java.util.*;

public interface Scheduler<T extends Job>{
    
    ArrayList<T> schedule(ArrayList<T> jobList);

}