package tp4.barber;


public class BarberShop {

    private int maxAmount;
    private int clientsWaiting;
    private Client ready;

    public BarberShop(int max){
        maxAmount = max;
        clientsWaiting=0;
        ready=null;
    }

    public synchronized void enterClient(Client c){
        if (clientsWaiting < maxAmount){
            clientsWaiting++;
            if (ready==null){
                ready=c;
                notifyAll();
            }else{
                try {
                    System.out.println(c+" esta esperando que lo atiendan");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println(c + " vio la fila y se fue");
        }
    }
    public synchronized void attendClient() {
        if (ready!=null){
            System.out.println(ready+" fue atendido");
            ready=null;
            if (clientsWaiting>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clientsWaiting--;
                notifyAll();
            }else{
                try {
                    System.out.println("No hay nadie para atender, el barbero espera");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                System.out.println("No hay nadie para atender, el barbero espera");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
