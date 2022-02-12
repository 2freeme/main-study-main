package com.study.empty.threadLocal;



public class ThreadLocalDemo {

    //ThreadLocal会给定一个初始值，也就是initialValue()方法，而每个线程都会从ThreadLocal中获得这个初始化的值的副本，这样可以使得每个线程都拥有一个副本拷贝
    private static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0; //通过initialValue方法设置默认值
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                int num = local.get().intValue();
                num += 5;
                System.out.println(Thread.currentThread().getName() + " : " + num);
            }, "Thread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
