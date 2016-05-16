package tp5.schedulingAlg;

import tp5.*;
import tp5.Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rudy on 16/05/16.
 */
public class FCFS implements SchedulingAlg {

    private List<Process> ready= new ArrayList<Process>();
    private List<Process> blocked = new ArrayList<Process>();

    @Override
    public void addProcess(Process p) {
        ready.add(p);
    }

    @Override
    public Run nextProcess() {
        if (!blocked.isEmpty()){
            for (Process p : blocked) {
                if (!p.isBlocked()){
                    ready.add(p);
                    blocked.remove(p);
                }
            }
        }
        if (!ready.isEmpty()){
            for (Process process : ready) {
                if (process.getState().equals(Process.State.BLOCKED)){
                    ready.remove(process);
                    blocked.add(process);
                }
            }
        }
        if (!ready.isEmpty()){
            Process p = ready.get(0);
            int runDuration = p.getRunDuration();
            return new Run(p, runDuration);
        }
        return null;
    }

    @Override
    public void updateTime() {

    }
}
