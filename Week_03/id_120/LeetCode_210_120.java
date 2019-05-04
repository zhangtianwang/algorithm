package com.data.structure.Grap;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zzl
 * @date 2019/5/4 15:24
 * @description
 */

public class GrapSolution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //图的入度
        int[] inDegree = new int[numCourses];

        LinkedList<Integer> list[] = new LinkedList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] arr = prerequisites[i];
            int firstVal = arr[0];
            int senondVal = arr[1];
            //入度
            inDegree[firstVal]++;
            if (list[senondVal] == null) {
                list[senondVal] = new LinkedList();
            }
            //设置链表
            list[senondVal].add(firstVal);
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return new int[0];
        }
        //返回的数组
        int[] newArr = new int[numCourses];
        int head = 0;
        Map<Integer,Boolean> map=new HashMap();
        //判断是不是环
        boolean isHoop=false;
        while (!queue.isEmpty()) {
            int val = queue.remove();
            if(map.containsKey(val)){
                isHoop=true;
                break;
            }
            //插入新数组
            newArr[head] = val;
            LinkedList<Integer> linkedList = list[val];

            //最后一个节点，不会指向下一个节点，略过此处操作
            if(linkedList!=null){
                for (int i = 0; i < linkedList.size(); i++) {
                    int m = linkedList.get(i);
                    inDegree[m]--;
                    if (inDegree[m] == 0) {
                        queue.add(m);
                    }
                }
            }
            map.put(val,true);
            head++;
            //如果遍历完每一个链表就跳出，说明中间断开了，直接返回
            if(head<numCourses&&queue.isEmpty()){
                return new int[0];
            }
        }
        if(isHoop){
            return new int[0];
        }
        return newArr;
    }
}
