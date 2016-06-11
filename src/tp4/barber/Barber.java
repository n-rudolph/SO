package tp4.barber;


public class Barber extends Thread{
    private BarberShop barberShop;

    public Barber (BarberShop barberShop){
        this.barberShop=barberShop;
    }

    @Override
    public void run() {
        barberShop.attendClient();
        run();
    }
}
