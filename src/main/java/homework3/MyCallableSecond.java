package homework3;

import java.util.*;
import java.util.concurrent.*;

public class MyCallableSecond extends RecursiveTask<Integer> {
    private int [] array;

    public MyCallableSecond (int[] array){
        this.array = array;
    }

    @Override
    protected Integer compute() {
         if(array.length <= 2){
             try {
                 Thread.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             return Arrays.stream(array).sum();
         }else{
             MyCallableSecond firstHalfArrayValueSumCounter = new MyCallableSecond(Arrays.copyOfRange(array, 0, array.length/2));
             MyCallableSecond secondHalfArrayValueSumCounter = new MyCallableSecond(Arrays.copyOfRange(array, array.length/2, array.length));
             firstHalfArrayValueSumCounter.fork();
             secondHalfArrayValueSumCounter.fork();
             return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
         }
    }
}
