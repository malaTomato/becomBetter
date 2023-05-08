package org.bear;

/**
 * [${PROJECT_NAME}]
 * [org.bear]
 * [${YEAR}/${MONTH}/${DAY} ${HOUR}:${MINUTE}]
 *
 * @author [willson.xiong]
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) throws Throwable {

        // 手动执行cg ，但不保证立即执行,取决于垃圾回收算法
        System.out.println(System.currentTimeMillis());

        for (int i = 0; i < 10000; i++) {
            NewObj obj = new NewObj();

        }
        System.out.println(System.currentTimeMillis());
        System.gc();

        while (true) {

        }

    }
}