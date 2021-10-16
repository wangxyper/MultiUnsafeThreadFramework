package org.wangxyper.mtf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/*
*该类为简单的多线程并发框架
* 会出现线程安全等问题，请谨慎使用
* */
public class SimpleConcurrent implements IConcurrentFramework {
    public static ThreadPoolExecutor poolExecutor = null;
    public static boolean init = false;
    @Override
    public void init(int coreCount,int maxPoolSize){
        System.out.println("Init Thread pool...");
        poolExecutor = new ThreadPoolExecutor(coreCount,maxPoolSize,60L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
        init = true;
        System.out.println("Completed!");
    }
    @Override
    public void post(Runnable target,int threadCount){
        if(init){for(int i=0;i<threadCount;i++){
            poolExecutor.execute(target);
        }}else {System.out.println("Thread pool not init!");}
        System.out.println("posted!");
    }
}
