package homework1;

public class MyThread extends Thread {


    public MyThread(String name, ThreadGroup tr) {
        super(tr, name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.printf("привет из № %s \n", getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("меня завершили");
                return;
            }
        }
    }


}
