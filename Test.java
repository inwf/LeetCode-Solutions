package leetcode.editor;

import java.util.*;
import java.util.concurrent.Callable;

public class Test {
    private static int i = 1;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            new Thread(new Print(i)).start();
        }
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



