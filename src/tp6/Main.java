package tp6;

import tp6.algorithms.FIFO;
import tp6.algorithms.NRU;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Page p0 = new Page(0,1);
        Page p1 = new Page(1,1);
        Page p2 = new Page(2,1);
        Page p3 = new Page(3,1);
        Page p4 = new Page(4,1);
        Page p5 = new Page(5,1);
        Page p6 = new Page(6,1);
        Page p7 = new Page(7,1);

        List<Page> addSpace1 = new ArrayList<Page>();
        addSpace1.add(p1);
        addSpace1.add(p3);
        addSpace1.add(p4);
        addSpace1.add(p6);

        List<Page> addSpace2 = new ArrayList<Page>();
        addSpace2.add(p0);
        addSpace2.add(p2);
        addSpace2.add(p5);
        addSpace2.add(p7);

        List<Page> pages = new ArrayList<Page>();
        pages.add(p0);
        pages.add(p1);
        pages.add(p2);
        pages.add(p3);
        pages.add(p4);
        pages.add(p5);
        pages.add(p6);
        pages.add(p7);

        List<Process> processes= new ArrayList<Process>();
        processes.add(new Process(0, addSpace1));
        processes.add(new Process(1, addSpace2));

        VirtualMemory vMem = new VirtualMemory(8, 1, 200, pages);

        MemoryManager mm = new MemoryManager(vMem, processes);
        mm.generateAccesses();
        mm.simulate(new FIFO(new Memory(5, 100, new ArrayList<Page>()), vMem));
        mm.simulate(new NRU(new Memory(5, 100, new ArrayList<Page>()), vMem));
    }
}
