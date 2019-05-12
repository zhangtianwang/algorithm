package com.data.structure.dynamicprogramming;


/**
 * @author zzl
 * @date 2019/5/12 11:44
 * @description
 */

public class DynamicProgrammingSolution {

    public int minCostClimbingStairs(int[] cost) {
        //一个新数组
        int[] p=new int[cost.length];
        p[0]=cost[0];
        p[1]=cost[1];
        //斐波那契数列的变种。
        for(int i=2;i<cost.length;i++){
            p[i]=Math.min(p[i-1],p[i-2])+cost[i];
        }
        //找最后2位的最小值
        return Math.min(p[cost.length-2],p[cost.length-1]);
    }


}
