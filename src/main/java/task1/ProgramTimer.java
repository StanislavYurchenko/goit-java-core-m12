package task1;

public class ProgramTimer {
    public void start() {

        Thread thread1 = new Thread(() -> {
            int count = 1;
            while (count <= 15) {
                try {
                    Thread.sleep(1000);
                    System.out.println(count + " second");
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            int count = 1;
            while (count <= 3) {
                try {
                    Thread.sleep(5000);
                    System.out.println("5 seconds have passed");
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
