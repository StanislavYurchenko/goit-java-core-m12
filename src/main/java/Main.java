import task1.ProgramTimer;
import task2.MultithreadedFizzBuzz;

public class Main {
    public static void main(String[] args) {
        // TASK 1
        ProgramTimer programTimer = new ProgramTimer();
        programTimer.start();

        try {
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // TASK 2
        int n = 15;
        MultithreadedFizzBuzz fizzBuzz = new MultithreadedFizzBuzz(n);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
