package com.itheima.demo01_Day12LianXi;

public class A {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(mr,"线程"+i).start();
        }
    }

}
class MyRunnable implements Runnable {
    private int count = 1;
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"通过山洞,他是第"+count+"个");
            count++;
        }
    }
}