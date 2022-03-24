package homework1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static final int DEF = 3;

    public static void main(String[] args) throws InterruptedException {

        System.out.print("Создаю поток");
        for (int i = 0; i < DEF; i++) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println("\n");
        ThreadGroup mainGroup = new ThreadGroup("main group");

        Collection<Thread> threads = new ArrayList<>();
        for (int i = 0; i < DEF; i++) {
            threads.add(new MyThread(Integer.toString(i + 1), mainGroup));
        }

        for (Thread t : threads) {
            t.start();
        }
        Thread.sleep(3000);
        System.out.println(mainGroup.activeCount());//чекнуть количество активных потоков
        //mainGroup.list();
        System.out.println(mainGroup.activeGroupCount());
        mainGroup.interrupt();
    }


}
