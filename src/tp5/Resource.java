package tp5;

/**
 * Created by rudy on 02/05/16.
 */
public enum Resource {
    CPU, IO;
    public int time;

    public void updateTime(int time) {
        this.time-=time;
    }
}
