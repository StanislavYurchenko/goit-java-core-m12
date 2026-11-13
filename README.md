# Java Core: Module 12 - Multithreading

This repository contains practical assignments for Module 12 of the GoIT Java Core course, focusing on multithreaded programming and thread synchronization.

## Project Structure

The project consists of two main tasks, separated into the `task1` and `task2` packages:

### Task 1: Program Timer (`task1.ProgramTimer`)

Implementation of parallel execution using two independent threads:

* **Thread 1:** Prints the elapsed time (in seconds) since the program started every second.
* **Thread 2:** Prints the message `"5 seconds have passed"` every 5 seconds.
* **Technologies:** `Thread` class, `Runnable` interface, `Thread.sleep()` method.

### Task 2: Multithreaded FizzBuzz (`task2.MultithreadedFizzBuzz`)

The classic FizzBuzz problem adapted for a multithreaded environment. The program prints numbers from 1 to `n` (replacing multiples of 3 with `fizz`, multiples of 5 with `buzz`, and multiples of both with `fizzbuzz`) using four synchronized threads:

* **Thread A (fizz):** Checks if the number is a multiple of 3 and adds the string `"fizz"` to the queue.
* **Thread B (buzz):** Checks if the number is a multiple of 5 and adds the string `"buzz"` to the queue.
* **Thread C (fizzbuzz):** Checks if the number is a multiple of 15 (both 3 and 5) and adds the string `"fizzbuzz"` to the queue.
* **Thread D (number):** Acts as a dispatcher — retrieves words from the queue or outputs the numbers themselves, prints the result to the console, and increments the shared counter.
* **Technologies:** Thread monitors (`synchronized`), inter-thread communication (`wait()`, `notifyAll()`), thread-safe collections (`ConcurrentLinkedQueue`).

## Run Instructions

The entry point for testing both tasks is the `Main` class located in the root package `src/main/java`.

1. Clone the repository:
   ```bash
   git clone <your_repository_link>
   ```
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
3. Navigate to the `Main.java` file and run it. The tasks will execute sequentially (first the Timer, then the FizzBuzz logic).

## Tech Stack

* **Java 17**
* **Maven** (build and dependency management)
* **Java Concurrency** (`java.util.concurrent`, `Thread API`)