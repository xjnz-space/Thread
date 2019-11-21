package com.quge.thread;

/**
 * 一个计数器，计数到100，在每个数字之间暂停一秒，每隔10个数字输出一个字符串
 */
public class CalcThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%10==0){
                System.out.println("----------"+i);
            }
            System.out.print(i);
            try {
                Thread.sleep(1000);
                System.out.println("线程休眠1秒！\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CalcThread().start();
    }
}
