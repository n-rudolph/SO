package tp6.algorithms;

import tp6.Access;
import tp6.Memory;
import tp6.Page;
import tp6.VirtualMemory;

;import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudy on 12/06/16.
 */
public class NRU extends PageReplacementAlgorithm {

    public int accesses = 0;





    public NRU(Memory mem, VirtualMemory vMem){
        super(mem, vMem);
        //pageTable = new ArrayList<Category>();
    }

    @Override
    public void onSuccess(Access a) {

    }

    @Override
    public void onFault(Access a) {

    }

    private class Category {
    }
}
