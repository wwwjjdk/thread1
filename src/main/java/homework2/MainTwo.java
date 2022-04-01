package homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainTwo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //List<Future<String>> futures = new ArrayList<>();
        List<MyCallable> list = new ArrayList<>();

        sleep();
        try {
            for (int i = 0; i < 3; i++) {
                list.add(new MyCallable());
            }
            String futures = executorService.invokeAny(list);
            System.out.println(futures);

            sleep();
            List<Future<String>> futuresAll = executorService.invokeAll(list);


          /*
            futures.add(executorService.submit(new MyCallable()));//можно через лямбду
            futures.add(executorService.submit(new MyCallable()));// это разные потоки
            futures.add(executorService.submit(new MyCallable()));
          */
            for (Future<String> f : futuresAll) {
                System.out.println((f.get()));
            }

        } finally {
            executorService.shutdown();
            System.out.println(executorService.isShutdown());
        }
    }

    public static void sleep() throws InterruptedException {
        System.out.print("Загрузка");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println();
    }
}
