package org.bear;

/**
 * [becomBetter]
 * [org.bear]
 * [2023/05/08 15:48]
 *
 * @author [willson.xiong]
 * @version 1.0.0
 */
public class NewObj {


    /**
     * 检验对象是否被回收，重写finalize方法
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("IM BE GC =" + System.currentTimeMillis());
        super.finalize();
    }
}
