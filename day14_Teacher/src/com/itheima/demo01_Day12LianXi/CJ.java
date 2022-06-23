package com.itheima.demo01_Day12LianXi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
    1.现有一个集合装了10个奖品在里面,分别是:{"电视机","电冰箱","电脑","游戏机","洗衣机","空调","手机","平板电脑","电动车","电饭煲"};

    2.假如有3个人同时去抽这10个奖品.最后打印出来.三个人各自都抽到了什么奖品.

    例如:

    张三: “电视机”,”电冰箱”,”电脑”,”游戏机”,”洗衣机”

    李四: ”空调”,”手机”,”平板电脑”,

    王五: ”电动车”,”电饭煲

    **要求**:

    1:3个人同时开始抽奖,每次抽奖需要使用0.5秒才能完成抽奖;

    2:需要控制住同一个奖项不能同时被多个人抽走;

    分析:
        把张三,李四,王五三个人,设计成三个线程同时从集合中删除数据;
        所以集合就是共享数据,为了保证共享数据的安全,应该加锁;
        随机可以利用随机数
 */
public class CJ {
    public static void main(String[] args) {
//        new MrRunnable();
//        new MrRunnable();

        MrRunnable mr = new MrRunnable();
        new Thread(mr,"张三").start();
        new Thread(mr,"李四").start();
        new Thread(mr,"王五").start();
    }
}

// 任务类
class MrRunnable implements Runnable{

    public MrRunnable() {
        super();
        //System.out.println("构造方法执行了....");

    }

    ArrayList<String> list = new ArrayList<>();
    /*
        1: 构造代码块   在类中直接写的大括号就是构造代码块,在每次创建对象的时候,都是在构造方法的第一行(super())之后,第二行之前执行
        2: 静态代码块   在构造代码块的前面加一个static关键字,就是静态代码块; 仅在类加载(什么时候用那个类了,就会加载了)的时候执行一次,后面就再也不执行了!
     */
     {
         // 构造代码块在创建对象的时候,会执行
         //System.out.println("构造代码块执行了...");
         Collections.addAll(list,"电视机","电冰箱","电脑","游戏机","洗衣机","空调","手机","平板电脑","电动车","电饭煲");
         for (int i = 0; i < 100; i++) {
             list.add(""+i);
         }
    }
    static {
        //System.out.println("静态代码块执行了....");
    }
    @Override
    public void run() {
        // 循环抽奖,直到奖抽完为止
        Random random = new Random();
        while (true){
            synchronized (this){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(list.size()==0){
                    break;
                }else {
                    // 随机一个索引,抽走一个奖
                    int i = random.nextInt(list.size());
                    String s = list.remove(i);
                    System.out.println(Thread.currentThread().getName()+"抽到了:"+s);
                }
            }
        }
    }
}