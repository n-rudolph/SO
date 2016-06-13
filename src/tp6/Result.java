package tp6;

/**
 * Created by rudy on 12/06/16.
 */
public class Result {
    int duration;
    boolean fault;
    Page page;

    public Result(int duration, boolean fault, Page p){
        this.duration=duration;
        this.fault=fault;
        page=p;
    }
}
