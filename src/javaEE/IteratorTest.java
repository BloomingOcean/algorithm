package javaEE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Li Yang
 * @Date 22/04/07 14:30
 * @Version 1.0
 */
public class IteratorTest {
    public static void main(String[] args) {
        // 在迭代器中用“list”的方法进行删除
        listRemove();
        // 在迭代器中用“迭代器”的方式进行删除
//        IteratorRemove();
    }

    /**
     * 在迭代器中用list的方法进行删除
     */
    public static void listRemove(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list.toString());
        // 增强for循环会生成一个迭代器进行遍历
        for (Object o : list) {
            /**
             * 报错: java.util.ConcurrentModificationException
             * 原因：ArrayList.java:907 维护了modCount进行判断
             *
             * 流程：第一次能够执行list.remove，但是会让modCount++，
             *      第二次迭代器执行next的时候会验证modCount的值，
             *      于是发现modCount和先前的不一样就报错
             */
            list.remove(o);
        }
        System.out.println(list.toString());
    }

    /**
     * 在迭代器中用“迭代器”的方式进行删除
     */
    public static void IteratorRemove(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list.toString());
        Iterator<Object> it = list.iterator();
        while(it.hasNext()) {
            // 必须要让迭代器指向下一个元素，才能删除
            it.next();
            it.remove();
        }
        System.out.println(list.toString());
    }
}
