package tp6.algorithms;

import tp6.*;

public abstract class PageReplacementAlgorithm {

    VirtualMemory virtualMemory;
    Memory memory;

    public PageReplacementAlgorithm(Memory mem, VirtualMemory vMem){
        memory=mem;
        virtualMemory=vMem;
    }

    public Result getPage(Access a){
       Page p = memory.getPage(a.page.id);
        if (p!=null){
            onSuccess(a);
            return new Result(memory.accessTime, false, p, a.process);
        }else{
            p = virtualMemory.getPage(a.page.id);
            if (p!=null){
                onFault(a);
                return new Result(memory.accessTime+ virtualMemory.accessTime, true, p, a.process);
            }
        }
       return new Result(0,false, p, 0);
    }
    public abstract void onSuccess(Access a);
    public abstract void onFault(Access a);

    public abstract String getName();
}
