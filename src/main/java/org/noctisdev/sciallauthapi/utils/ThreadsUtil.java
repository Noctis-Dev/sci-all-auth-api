package org.noctisdev.sciallauthapi.utils;

public class ThreadsUtil {

    public static void runTask(Runnable task) {
        new Thread(task).start();
    }

}
