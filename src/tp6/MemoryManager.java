package tp6;

import tp6.algorithms.PageReplacementAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    VirtualMemory vMem;
    List<Process> processes;
    List<Access> accesses;


    public MemoryManager(VirtualMemory vMem, List<Process> processList){

        this.vMem=vMem;
        processes=processList;
        accesses=new ArrayList<Access>();

    }

    public void generateAccesses() {

        double random = Math.random();

        int pageNumber = 0 ;
        int p1Number=0;
        int p2Number=0;
        int process = 0;
        while (pageNumber < 8){
            if (process==0) {
                process = 1;
                do{
                    Access.AccessType type;
                    if (Math.random()>0.5)
                        type = Access.AccessType.WRITE;
                    else
                        type = Access.AccessType.READ;
                    accesses.add(new Access(processes.get(process).virtualAddressScace.get(p2Number), type, process));
                    random= Math.random();
                }while (random<0.99);
                p2Number++;
                pageNumber++;
            }else {
                process = 0;
                do{
                    Access.AccessType type;
                    if (Math.random()>0.5)
                        type = Access.AccessType.WRITE;
                    else
                        type = Access.AccessType.READ;
                    accesses.add(new Access(processes.get(process).virtualAddressScace.get(p1Number), type, process));
                    random= Math.random();

                }while(random<0.99);
                p1Number++;
                pageNumber++;
            }
        }


    }

    public void simulate(PageReplacementAlgorithm pra){
        int pageFaultTot=0;
        double accessTimeTot=0;
        int pageFaultP0=0;
        int pageFaultP1=0;

        for (Access access : accesses) {
            final Result page = pra.getPage(access);
            accessTimeTot+=page.duration;
            if (page.fault) {
                pageFaultTot++;
                if (page.process == 0) {
                    pageFaultP0++;
                } else {
                    pageFaultP1++;
                }
            }
        }
        System.out.println(pra.getName());
        System.out.println("Total time:"+ accessTimeTot);
        System.out.println("Total Page fault: "+ pageFaultTot);
        System.out.println("Process 0 total page fault: " + pageFaultP0);
        System.out.println("Process 1 total page fault: " + pageFaultP1+"\n");
    }
}
