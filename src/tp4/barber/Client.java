package tp4.barber;


public class Client extends Thread {
    private BarberShop barberShop;

    public Client(BarberShop barberShop){
        this.barberShop=barberShop;
    }

    @Override
    public void run() {
        barberShop.enterClient(this);
    }
}
