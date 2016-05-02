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
        Run run = startSimulation();
        while(all.size()>0){
            changeToReady();

        }
    }

    public Run startSimulation(){
        Run run = getFirstProcess();
        clock=clock+run.duration;
        updateTime(run.duration);
       return run;
    }

    private void changeToReady() {
        for (Process process : all) {
            if (process.changeStateToReady()){
                alg.addProcess(process);
            }
        }
    }

    private Run getFirstProcess(){
        Process aux = new Process(0, 0, 10000, null);
        for (Process process : all) {
            if (process.getArrivalTime()<aux.getArrivalTime()){
                aux=process;
            }
        }
        return new Run(aux, aux.getArrivalTime());
    }

    private void updateTime(int time) {
        for (Process process : all) {
            process.updateArrivalTime(time);
        }
    }

}
