package tp3;

import java.util.Random;

/**
 * Created by rudy on 04/04/16.
 */
public class Consumer extends Thread {
    private Buffer b;
    private String name;

    public Consumer(Buffer b, String name){
        this.b=b;
        this.name=name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item=(Integer)b.remove();
                System.out.println(name + " consumed " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
