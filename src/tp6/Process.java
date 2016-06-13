package tp6;

import java.util.List;

/**
 * Created by rudy on 12/06/16.
 */
public class Process {

    public int id;
    public List<Page> virtualAddressScace;

    public Process(int id, List<Page> as){
        this.id=id;
        virtualAddressScace=as;
    }
}
