package tp5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rudy on 02/05/16.
 */
public class Scheduler {
    private List<Process> all;
    private List<Process> completed;
    private Process running;

    private SchedulingAlg alg;
    private int clock = 0;

    public Scheduler(SchedulingAlg alg, List<Process> all){
        this.alg=alg;
        this.all=all;
    }

    public void run(){
        startSimulation();
        while(all.size()>0){
            changeToReady();
            Run next = alg.nextProcess();
            updateTime(next.duration);
            changeToCompleted();
            clock += next.duration;
        }
    }

    private void changeToCompleted() {
        for (Process process : all) {
            if (process.isCompleted()){
                process.setState(Process.State.COMPLETED);
                completed.add(process);
                all.remove(process);
            }
        }
    }

    public void startSimulation(){
        Process minTimeProcess = getFirstProcess();
        clock = clock + minTimeProcess.getArrivalTime();
        updateTime(clock);
    }

    private void changeToReady() {
        for (Process process : all) {
            if (process.changeStateToReady()){
                alg.addProcess(process);
            }
        }
    }

    private Process getFirstProcess(){
        Process aux = new Process(0, 0, 10000, null);
        for (Process process : all) {
            if (process.getArrivalTime()<aux.getArrivalTime()){
                aux=process;
            }
        }
        return aux;
    }

    private void updateTime(int time) {
        for (Process process : all) {
            process.updateTime(time);
        }
    }

}
