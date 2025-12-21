package leetcode.editor;

import java.util.*;
import java.util.concurrent.Callable;

public class Test {
    private static int i = 1;

    public static void main(String[] args) throws Exception {
        System.out.println("hello".repeat(2));
    }

    private static class Print implements Runnable {

        private final int index;

        public Print(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (Print.class) {
                    if (i >= 101) {
                        return;
                    }
                    System.out.println("Thread-" + index + " " + i++);
                }
            }
        }
    }
}



