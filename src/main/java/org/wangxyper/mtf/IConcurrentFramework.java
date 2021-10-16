package org.wangxyper.mtf;

public interface IConcurrentFramework {
    /*
     初始化，需要实现该方法
    * */
    public void init(int coreCount, int maxPoolSize);
    /*
    *投递Runnable，还是需要实现该方法
    * */
    public void post(Runnable target, int threadCount);
}
