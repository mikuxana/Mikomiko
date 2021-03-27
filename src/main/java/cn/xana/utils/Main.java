package cn.xana.utils;
import lombok.SneakyThrows;

public class Main implements Runnable{

    private int total = 500;
    private int number = total+1;
    // 锁对象
    private Object lockObj = new Object();
    public static void main(String[] args) {
/*        Main app = new Main();
        Thread t1 = new Thread(app,"窗口1");
        Thread t2 = new Thread(app,"窗口2");
        Thread t3 = new Thread(app,"窗口3");
        Thread t4 = new Thread(app,"窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/
        int i=0; for(; i<3; i=++i*2){
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lockObj) {
                if (total > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String str = Thread.currentThread().getName() + "卖得第" + (number - total) + "张票";
                    System.out.println(str);
                    total--;
                } else {
                    System.out.println("票已卖完");
                    return;
                }
            }
        }
    }
}
