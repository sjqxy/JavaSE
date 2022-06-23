package com.itheima.demo02_Day13LianXi;
/*
    用两个线程按从小到大的规则,打印1--100的数字
    一个线程负责打印奇数
    另一个线程负责打印偶数
 */
public class Test01 {
    public static void main(String[] args) {
        MyR r = new MyR();
        new Thread(r,"A").start();
        new Thread(r,"B").start();
    }
}
// 任务类
class MyR implements Runnable{
    private int i=1;
    @Override
    public void run() {
        /*
            思路:
            1: 线程执行任务的时候,先获取线程的名称,判断当前数字是否应该由该线程打印,如果是,则打印,如果不是,则等待
         */
        while (true){
            synchronized (this){

                if(i>100){
                    System.exit(0);
                }

                //先获取线程的名称
                String name = Thread.currentThread().getName();
                //判断当前数字是否应该由该线程打印
                if(i%2==1){
                    // 奇数, 判断当前线程是否是A线程,如果是,则打印,如果不是,则等待
                    if("A".equals(name)){
                        System.out.println(name+":------"+i);
                        i++;
                    }else {
                        this.notifyAll();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    // 偶数
                    if("B".equals(name)){
                        System.out.println(name+":------"+i);
                        i++;
                    }else {
                        this.notifyAll();
                        try {
                            this.wait();// 当前数字是偶数,但是不是B线程,A等
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
