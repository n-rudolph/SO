package tp6.algorithms;

import tp6.*;

/**
 * Created by rudy on 12/06/16.
 */
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
            return new Result(memory.accessTime, false, p);
        }else{
            p = virtualMemory.getPage(a.page.id);
            if (p!=null){
                onFault(a);
                return new Result(memory.accessTime+ virtualMemory.accessTime, true, p);
            }
        }
       return new Result(0,false, p);
    }
    public abstract void onSuccess(Access a);
    public abstract void onFault(Access a);

}
