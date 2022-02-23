package com.jl;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @program: demo
 * @description:
 * @author: LIN
 * @create: 2021~09~25 23:41
 */
public class HeapTest {

    public static void main(String[] args) {
        Random rd=new Random();
        int temp=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );
        for (int i=1;i<=5;i++){
            temp=rd.nextInt(10);
            System.out.println(temp);
            queue.add(temp);
        }
        System.out.println("--------------");
        for (int i=1;i<=5;i++){
            System.out.println(queue.poll());
        }
    }
}
