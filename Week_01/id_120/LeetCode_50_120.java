package com.data.structure.recursion;


/**
 * @author zzl
 * @date 2019/4/19 15:05
 * @description 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */

public class RecursionSolution {


    public double myPow(double x, int n) {
        //如果是特殊值，直接返回，不用进行计算。
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return 1;
        }

        //用二分法结合递归，将n次幂每次折半，对2取余，取余为0，继续递归，递归到n=0,
        // 余数为1，则把递归之后返回的值乘以x,递归之后取的值直接相乘，减少了重复计算
        // 将计算的时间负责度降O(n2)降为O(n)
        double val = recursion(x, n);
        if (n < 0) {
            val = 1 / val;
        }
        return val;
    }

    public double recursion(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //如果能被2整除，则不需要处理
        double temp = 1;
        if (n % 2 != 0) {
            temp = x;
        }
        n = n / 2;
        double val = recursion(x, n);
        val = temp * val * val;
        return val;
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
