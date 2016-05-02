package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudy on 04/04/16.
 */
public class Buffer <T> {
    private int size;
    private List<T> buffer=new ArrayList<T>();

    public Buffer(int size){
        this.size=size;
    }

    public synchronized void add (T item) throws InterruptedException {
        while (buffer.size()+1==size){
            this.wait();
        }
        buffer.add(item);
        notifyAll();
    }
    public synchronized T remove() throws InterruptedException {
        while (buffer.size()==0){
            this.wait();
        }

        T aux=buffer.remove(0);
        notifyAll();
       return aux;
    }
}
