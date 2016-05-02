package tp3;

import java.util.Random;

/**
 * Created by rudy on 04/04/16.
 */
public class Producer extends Thread {
    private Buffer b;
    private String name;
    public Producer(Buffer b, String name){
        this.b=b;
        this.name=name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Random random = new Random(System.currentTimeMillis());
                int item=random.nextInt();
                b.add(item);
                System.out.println(name+" produced " + item);
                sleep(random.nextInt(8) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
