package tp4.philosophers;


public class Philosopher extends Thread {

    private Fork leftFork;
    private Fork rightFork;

    private String name;

    public Philosopher(String name, Fork left, Fork right){
        this.name=name;
        leftFork=left;
        rightFork=right;
        start();
    }

    public void eat(){
        int idL = leftFork.getId();
        int idR = rightFork.getId();
        try {
            if (idL>idR){
                System.out.println(name+" trata de agarrar tenedor " + rightFork.getId());
                rightFork.use();
                System.out.println(name + " agarro tenedor " + rightFork.getId());

                System.out.println(name+" trata de agarrar tenedor " + leftFork.getId());
                leftFork.use();
                System.out.println(name + " agarro tenedor " + leftFork.getId());
            }else {
                System.out.println(name+" trata de agarrar tenedor " + leftFork.getId());
                leftFork.use();
                System.out.println(name + " agarro tenedor " + leftFork.getId());

                System.out.println(name+" trata de agarrar tenedor " + rightFork.getId());
                rightFork.use();
                System.out.println(name + " agarro tenedor " + rightFork.getId());
            }

            sleep(2000);
            leftFork.release();
            System.out.println(name + " solto tenedor " + leftFork.getId());
            rightFork.release();
            System.out.println(name + " solto tenedor " + rightFork.getId());


            System.out.println(name+" remino de comer");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        eat();
    }

}
