package com.quge.thread;

public class TestThread extends Thread{
    public TestThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //sleep让当前抢到cpu的线程休眠，让其他线程有机会执行
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+":"+i);
            //Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
            /*yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
            因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
            但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
            结论：yield()从未导致线程转到等待/睡眠/阻塞状态。
            在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。*/
            if (i==3){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //父类指向子类直接创建对象
        Thread t1=new TestThread("jojo");
        Thread t2=new TestThread("dio");
        //开启线程
        t1.start();
        /*Thread的非静态方法join()让一个线程B“加入”到另外一个线程A的尾部。在A执行完毕之前，B不能工作。
        join()方法还有带超时限制的重载版本。例如t.join(5000);
        则让线程等待5000毫秒，如果超过这个时间，则停止等待，变为可运行状态。*/
        t1.join(100);
        t2.start();
        /*线程离开运行状态的3种方法：
            1、调用Thread.sleep()：使当前线程睡眠至少多少毫秒（尽管它可能在指定的时间之前被中断）。
            2、调用Thread.yield()：不能保障太多事情，尽管通常它会让当前运行线程回到可运行性状态，使得有相同优先级的线程有机会执行。
            3、调用join()方法：保证当前线程停止执行，直到该线程所加入的线程完成为止。然而，如果它加入的线程没有存活，则当前线程不需要停止。

        除了以上三种方式外，还有下面几种特殊情况可能使线程离开运行状态：
            1、线程的run()方法完成。
            2、在对象上调用wait()方法（不是在线程上调用）。
            3、线程不能在对象上获得锁定，它正试图运行该对象的方法代码。
            4、线程调度程序可以决定将当前运行状态移动到可运行状态，以便让另一个线程获得运行机会，而不需要任何理由。*/
    }
}
 