package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudy on 04/04/16.
 */
public class Test {
    public static void main(String[] args) {
        Buffer b= new Buffer(100);
        List<Consumer> consumers= new ArrayList<Consumer>();
        List<Producer> producers= new ArrayList<Producer>();

        for (int i = 0; i < 10; i++) {
            consumers.add(new Consumer(b,"#"+i));
        }
        for (int i = 0; i < 10; i++) {
            producers.add(new Producer(b, "#" + i));
        }

        for (Producer producer : producers) {
            producer.start();
        }
        for (Consumer consumer : consumers) {
            consumer.start();
        }
    }
}
