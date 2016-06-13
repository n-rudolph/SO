package tp6;

/**
 * Created by rudy on 12/06/16.
 */
public class Result {
    int duration;
    boolean fault;
    Page page;
    int process;

    public Result(int duration, boolean fault, Page p, int process){
        this.duration=duration;
        this.fault=fault;
        page=p;
        this.process=process;
    }
}
