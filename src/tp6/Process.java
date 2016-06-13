package tp6;

import java.util.List;

/**
 * Created by rudy on 12/06/16.
 */
public class Process {

    public int id;
    public List<Integer> virtualAddressScape;

    public Process(int id, List<Integer> as){
        this.id=id;
        virtualAddressScape=as;
    }
}
