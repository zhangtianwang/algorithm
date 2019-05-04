package com.data.structure.dfs;


/**
 * @author zzl
 * @date 2019/5/4 20:10
 * @description
 */

public class DFSDemo {

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right= depth(root.right);
        int maxVal = Math.max(left,right);
        maxVal++;
        return maxVal;
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }
}
