import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        pc p = new pc();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }

}

class pc{

    int capacity =2;
    LinkedList<Integer> a = new LinkedList<>();
    void producer() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this) {

                if (a.size() == capacity)
                    wait();

                System.out.print("producer produces:" + value);
                a.add(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }
    void consumer() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this) {

                if (a.size() == 0)
                    wait();
                int val= a.removeFirst();
                System.out.print("consumer consume:" + value);

                notify();
                Thread.sleep(1000);
            }
        }

    }
}