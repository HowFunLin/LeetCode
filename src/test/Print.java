package test;

/**
 * 多线程打印 1 - 100 解决方案
 */
public class Print {
    private volatile int i = 1;

    public static void main(String[] args) {
        Print obj = new Print();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (obj.i <= 100) {
                    // 上锁当前对象
                    synchronized (this) {
                        // 唤醒另一个线程，但会等到 synchronized 块不被占用后执行
                        notifyAll();

                        if (obj.i == 101) {
                            return;
                        }

                        int i = Integer.valueOf(Thread.currentThread().getName());

                        if (obj.i % 3 == i) {
                            System.out.println("Thread " + Thread.currentThread().getName() + " " + obj.i++);
                        }

                        try {
                            if (obj.i == 101) {
                                notifyAll();
                                return;
                            } else {
                                // 释放掉锁
                                wait();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        // 启动多个线程（想创建几个就创建几个）
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.setName("1");
        t2.setName("2");
        t3.setName("0");

        t1.start();
        t2.start();
        t3.start();
    }
}
