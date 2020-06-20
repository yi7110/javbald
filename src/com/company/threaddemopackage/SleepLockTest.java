package com.company.threaddemopackage;

// SleepLockTest.java的源码

/**
 * 线程会进入阻塞状态，不会释放当前锁
 * sleep()方法
 * sleep是线程类（Thread）的静态方法。
 * sleep的作用是让线程休眠制定的时间，在时间到达时恢复，也就是说sleep将在接到时间到达事件事恢复线程执行。
 *
 * 让调用的线程进入指定时间睡眠状态，使得当前线程进入阻塞状态，告诉系统至少在指定时间内不需要为线程调度器为该线程分配执行时间片，
 * 给执行机会给其他线程（实际上，调用sleep()方法时并不要求持有任何锁，即sleep()可在任何地方使用。），
 * 但是监控状态依然保持，到时后会自动恢复。
 * sleep()休眠时间满后，该线程不一定会立即执行，这是因为其他线程可能正在运行而起没有被调度为放弃执行，
 * 除非此线程具有更高的优先级。
 * sleep()必须捕获异常。
 * 在sleep的过程中过程中有可能被其他对象调用它的interrupt(),产生InterruptedException异常，
 * 如果你的程序不捕获这个异常，线程就会异常终止，
 * 进入TERMINATED状态，如果你的程序捕获了这个异常，
 * 那么程序就会继续执行catch语句块(可能还有finally语句块)以及以后的代码。
 * 在没有锁的情况下，sleep()可以使低优先级的线程得到执行的机会，
 * 当然也可以让同优先级、高优先级的线程有执行的机会。
 */
public class SleepLockTest{
    private static Object obj = new Object();
    public static void main(String[] args){
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }
    static class ThreadA extends Thread{
        public ThreadA(String name){
            super(name);
        }
        @Override
        public void run(){
            // 获取obj对象的同步锁
            synchronized (obj) {
                try {
                    for(int i=0; i <10; i++){
                        System.out.printf("%s: %d\n", this.getName(), i);
                        // i能被4整除时，休眠100毫秒
                        if (i%4 == 0) {
                            Thread.sleep(1000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
