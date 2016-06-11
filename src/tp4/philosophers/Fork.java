package tp4.philosophers;


import java.util.concurrent.Semaphore;

public class Fork {

    private Semaphore s;

    private int id;

    public Fork(int id){
        this.id=id;
        s=new Semaphore(1);
    }

    public void use() throws InterruptedException {
        s.acquire();
    }

    public void release(){
        s.release();
    }

    public int getId(){
        return id;
    }
}
