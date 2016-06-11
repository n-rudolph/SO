package tp4.barber;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final BarberShop barberShop = new BarberShop(10);
        final long maxTime = System.currentTimeMillis() + 40000l;
        final Barber barber = new Barber(barberShop);
        barber.start();
        while (System.currentTimeMillis() < maxTime) {
            final Client c = new Client(barberShop);
            c.start();
            final Random random = new Random(System.currentTimeMillis());
            try {
                Thread.sleep(random.nextInt(800));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
