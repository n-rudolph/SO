package tp5;

import java.util.List;

/**
 * Created by rudy on 02/05/16.
 */
public class Process {
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

    public void updateTime(int time) {
        switch (state) {
            case PENDING:
                if (arrivalTime <= 0)
                    arrivalTime -= time;
                break;
            case BLOCKED:
                for (Resource resource : resources) {
                    if (resource == Resource.IO && resource.time > 0) {
                        resource.updateTime(time);
                        return;
                    }
                }
                break;
            case RUNNING:
                for (Resource resource : resources) {
                    if (resource == Resource.CPU && resource.time > 0) {
                        resource.updateTime(time);
                        return;
                    }
                }
        }
    }

    public boolean changeStateToReady() {
        if (state == State.PENDING && arrivalTime == 0) {
            state = State.READY;
            return true;
        }
        return false;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public boolean isCompleted() {
        boolean completed = true;
        if (state != State.COMPLETED){
            if (arrivalTime > 0){
                completed=false;
            } else {
                for (Resource resource : resources) {
                    if (resource.time > 0)
                        completed = false;
                }
            }
        }
        return completed;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        PENDING, BLOCKED, READY, COMPLETED, RUNNING
    }
}
