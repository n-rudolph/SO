package tp5;

import java.util.List;

/**
 * Created by rudy on 02/05/16.
 */
public class Process{
    private List<RunInterval> runIntervals;
    private int id;
    private int priority;
    private int arrivalTime;
    private List<Resource> resources;
    private State state;

    public Process(int id, int priority, int arrivalTime, List<Resource> resources) {
        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.resources = resources;
    }

    public List<RunInterval> getRunIntervals() {
        return runIntervals;
    }

    public void setRunIntervals(List<RunInterval> runIntervals) {
        this.runIntervals = runIntervals;
    }

    public void updateArrivalTime(int time){
        if (arrivalTime<=0){
            return;
        }
        arrivalTime-=time;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public boolean changeStateToReady() {
        if (state == State.PENDING && arrivalTime == 0){
            state= State.READY;
            return true;
        }
        return false;
    }


    public enum State{
        PENDING, BLOCKED, READY, COMPLETED;
    }
}
