package homework2;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int count = 0;
        int size = (int) Math.floor(Math.random() * 10);
        for (int i = 0; i < size; i++) {
            count++;
            Thread.sleep(1000);
        }
        return String.format("поток %s выполнил %s задач за %s ms", Thread.currentThread().getName(), count,System.currentTimeMillis());
    }
}
