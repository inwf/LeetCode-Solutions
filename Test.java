package leetcode.editor;

import java.util.*;
import java.util.concurrent.Callable;

public class Test {
    public static void main(String[] args) throws Exception {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(list);
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("thread");
    }
}
