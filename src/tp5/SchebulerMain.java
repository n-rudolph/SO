package tp5;

import tp5.schedulingAlg.FCFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudy on 16/05/16.
 */
public class SchebulerMain {
    public static void main(String[] args) {
        FCFS fcfs = new FCFS();
        List<Resource> r1= new ArrayList<Resource>();

        Resource cpu1 = Resource.CPU;
        cpu1.time=50;

        r1.add(cpu1);
        Process p1 = new Process(1, 1, 50, r1);
        Process p2 = new Process(1, 1, 30, r1);

        ArrayList<Process> processes = new ArrayList<Process>();
        processes.add(p1);
        processes.add(p2);

        Scheduler scheduler= new Scheduler(new FCFS(), processes);

        scheduler.run();

        List<RunInterval> runIntervals = p1.getRunIntervals();
        for (RunInterval runInterval : runIntervals) {
            System.out.println("p1"+runInterval.start + "end " + runInterval.end);
        }
        List<RunInterval> runIntervals2 = p2.getRunIntervals();
        for (RunInterval runInterval : runIntervals) {
            System.out.println("p2"+runInterval.start + "end " + runInterval.end);
        }
    }
}
