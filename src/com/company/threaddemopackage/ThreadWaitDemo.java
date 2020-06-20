package com.company.threaddemopackage;

/**
 * wait方法会释放当前锁
 * wait()方法是Object类里的方法。
 * 当一个线程执行wait()方法时，它就进入到一个和该对象相关的等待池中（进入等待队列，也就是阻塞的一种，叫等待阻塞），
 * 同时释放对象锁，并让出CPU资源，待指定时间结束后返还得到对象锁。
 * wait()使用notify()方法、notiftAll()方法或者等待指定时间来唤醒当前等待池中的线程。
 * 等待的线程只是被激活，但是必须得再次获得锁才能继续往下执行，也就是说只要锁没被释放，原等待线程因为为获取锁仍然无法继续执行。
 * notify的作用只负责唤醒线程，线程被唤醒后有权利重新参与线程的调度。
 * wait()方法、notify()方法和notiftAll()方法用于协调多线程对共享数据的存取，所以只能在同步方法或者同步块中使用，
 * 否则抛出IllegalMonitorStateException。
 *
 *
 */
public class ThreadWaitDemo {

    private static final int PRINT_A = 0;
    private static final int PRINT_B = 1;
    private static final int PRINT_C = 2;

    private static class MyThread extends Thread {
        int which; // 0：打印A；1：打印B；2：打印C
        static volatile int state; // 线程共有，判断所有的打印状态
        static final Object t = new Object();

        public MyThread(int which) {
            this.which = which;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (t) {
                    while (state % 3 != which) {
                        try {
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(this.getName());
                    System.out.println(toABC(which)); // 执行到这里，表明满足条件，打印
                    state++;
                    t.notifyAll(); // 调用notifyAll方法
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyThread(PRINT_A).start();
        new MyThread(PRINT_B).start();
        new MyThread(PRINT_C).start();
    }
    private static char toABC(int which) {
        return (char) ('A' + which);
    }
}

