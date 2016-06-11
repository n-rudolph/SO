package tp4.philosophers;

public class Main {
    public static void main(String[] args) {
        final Fork f1 = new Fork(1);
        final Fork f2 = new Fork(2);
        final Fork f3 = new Fork(3);
        final Fork f4 = new Fork(4);
        final Fork f5 = new Fork(5);

        final Philosopher p1 = new Philosopher("1", f1, f2);
        final Philosopher p2 = new Philosopher("2", f2, f3);
        final Philosopher p3 = new Philosopher("3", f3, f4);
        final Philosopher p4 = new Philosopher("4", f4, f5);
        final Philosopher p5 = new Philosopher("5", f5, f1);

    }
}
