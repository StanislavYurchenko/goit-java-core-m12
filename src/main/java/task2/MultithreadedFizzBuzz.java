package task2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MultithreadedFizzBuzz {
    private final int n;
    private int current = 1;
    private final Queue<String> queue = new ConcurrentLinkedQueue<>();

    public MultithreadedFizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (current <= n) {
            while (current <= n && (!queue.isEmpty() || current % 3 != 0 || current % 5 == 0)) {
                wait();
            }

            if (current > n) {
                return;
            }

            queue.add("fizz");
            notifyAll();
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (current <= n) {
            while (current <= n && (!queue.isEmpty() || current % 3 == 0 || current % 5 != 0)) {
                wait();
            }

            if (current > n) {
                return;
            }

            queue.add("buzz");
            notifyAll();
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (current <= n) {
            while (current <= n && (!queue.isEmpty() || current % 3 != 0 || current % 5 != 0)) {
                wait();
            }

            if (current > n) {
                return;
            }

            queue.add("fizzbuzz");
            notifyAll();
        }
    }

    public synchronized void number() throws InterruptedException {
        while (current <= n) {
            while (current <= n && queue.isEmpty() && (current % 3 == 0 || current % 5 == 0)) {
                wait();
            }

            if (current > n) {
                return;
            }

            String output = queue.isEmpty() ? String.valueOf(current) : queue.poll();
            System.out.print(current < n ? output + ", " : output);

            current++;
            notifyAll();
        }
    }
}
