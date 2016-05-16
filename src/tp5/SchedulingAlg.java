package tp5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudy on 02/05/16.
 */
public interface SchedulingAlg {
    void addProcess(Process p);
    Run nextProcess();
    void updateTime();
}
