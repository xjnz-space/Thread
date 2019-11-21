package com.quge.runnable;

public class TestRunnable{
    public static void main(String[] args) {
        //创建两个线程对象
        Thread t1=new Thread(new RunnableImpl("李白"));
        Thread t2=new Thread(new RunnableImpl("杜甫"));
        //设置线程优先级
        /**Thread提供了三个线程优先等级
         * The minimum priority that a thread can have.
        public final static int MIN_PRIORITY = 1;

        *//**
         * The default priority that is assigned to a thread.
         *//*
        public final static int NORM_PRIORITY = 5;

        *//**
         * The maximum priority that a thread can have.
         *//*
        public final static int MAX_PRIORITY = 10;*/
        //t1.setPriority(Thread.MAX_PRIORITY);
        //开启线程
        t1.start();
        t2.start();
    }
}
