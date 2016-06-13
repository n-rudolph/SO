package tp6.algorithms;

import tp6.Access;
import tp6.Memory;
import tp6.Page;
import tp6.VirtualMemory;

public class FIFO extends PageReplacementAlgorithm{

    public FIFO(Memory mem, VirtualMemory vMem) {
        super(mem, vMem);
    }

    @Override
    public void onSuccess(Access a) {

    }

    @Override
    public void onFault(Access a) {
        if (memory.pages.size()==memory.maxSize){
            Page p = memory.pages.get(0);
            memory.removePage(p.id);
            memory.addPage(a.page);
        }else {
            memory.addPage(a.page);
        }
    }

    @Override
    public String getName() {
        return "FIFO";
    }
}
