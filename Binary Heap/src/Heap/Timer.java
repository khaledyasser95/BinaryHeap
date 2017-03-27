package Heap;

/**
 * Created by ICY on 3/27/2017.
 */
public class Timer {
    long Starttime;
    long execution;

    void start() {
        long startTime = System.nanoTime();
        Starttime = startTime;
    }

    void end() {
        long stopTime = System.nanoTime();
        execution = stopTime - Starttime;
    }
}
