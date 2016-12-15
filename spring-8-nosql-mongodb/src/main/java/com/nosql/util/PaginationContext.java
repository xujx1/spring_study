package com.nosql.util;

/**
 * ThreadLocal不是用来解决对象共享访问问题的，而主要是提供了保持对象的方法和避免参数传递的方便的对象访问方式。
 * 归纳了两点：
 * 1。每个线程中都有一个自己的ThreadLocalMap类对象，可以将线程自己的对象保持到其中，各管各的，线程可以正确的访问到自己的对象。
 * 2。将一个共用的ThreadLocal静态实例作为key，将不同对象的引用保存到不同线程的ThreadLocalMap中，
 * 然后在线程执行的各处通过这个静态ThreadLocal实例的get()方法取得自己线程保存的那个对象，避免了将这个对象作为参数传递的麻烦。
 * ThreadLocal的应用场合，我觉得最适合的是按线程多实例（每个线程对应一个实例）的对象的访问，并且这个对象很多地方都要用到。
 */
public class PaginationContext {


    private PaginationContext() {

    }

    private static ThreadLocal<Integer> offset = new ThreadLocal<>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();


    public static int getPageSize() {
        Integer _pageSize = pageSize.get();
        if (null == _pageSize) {
            _pageSize = Integer.MAX_VALUE;
        }
        return _pageSize;
    }

    public static void setPageSize(Integer _pageSize) {
        pageSize.set(_pageSize);
    }

    public static int getOffset() {
        Integer _offset = offset.get();
        if (null == _offset) {
            _offset = 0;
        }
        return _offset;
    }

    public static void setOffset(Integer _offset) {
        offset.set(_offset);
    }
}
