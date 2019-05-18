package com.data.structure.tree;


/**
 * @author zzl
 * @date 2019/5/18 13:59
 * @description
 */

public class BinaryTreeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root||q==root){
            return root;
        }
        RelationNode newRoot=new RelationNode(root,null,0);
        RelationNode pNode=findNode(newRoot,p);
        RelationNode qNode=findNode(newRoot,q);
        //上升到同一个节点
        while (pNode.depth!=qNode.depth){
            if(pNode.depth>qNode.depth){
                pNode=pNode.parent;
            }else{
                qNode=qNode.parent;
            }
        }
        while (pNode.curren!=qNode.curren){
            pNode=pNode.parent;
            qNode=qNode.parent;
        }
        return pNode.curren;
    }

    private RelationNode findNode(RelationNode parent,TreeNode dest){
        TreeNode node=parent.curren;
        TreeNode leftSon=node.left;
        TreeNode rightSon=node.right;
        if(dest.equals(leftSon)){
            return new RelationNode(leftSon,parent,parent.depth+1);
        }
        if(dest.equals(rightSon)){
            return new RelationNode(rightSon,parent,parent.depth+1);
        }
        if(leftSon!=null){
            RelationNode leftSonNode = new RelationNode(leftSon,parent,parent.depth+1);
            RelationNode  leftResult = findNode(leftSonNode,dest);
            if(leftResult!=null){
                return leftResult;
            }
        }
        if(rightSon!=null){
            RelationNode rightSonNode = new RelationNode(rightSon,parent,parent.depth+1);
            RelationNode  rightResult = findNode(rightSonNode,dest);
            if(rightResult!=null){
                return rightResult;
            }
        }
        return null;

    }

    public class RelationNode{
        public RelationNode(TreeNode curren,RelationNode parent,int depth){
            this.curren=curren;
            this.parent=parent;
            this.depth=depth;
        }
        public TreeNode curren;
        public RelationNode parent;
        public int depth;
    }


    /**
     * 其他人的Demo
     * @param root
     * @param p
     * @param q
     * @return
     */
//    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
//        if(root==null||root==p||root==q){
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor2(root.left,p,q);
//        TreeNode right=lowestCommonAncestor2(root.right,p,q);
//        if(left!=null){
//            System.out.println("当前值是："+left.val);
//        }
//        if(right!=null){
//            System.out.println("当前值是："+right.val);
//        }
//        if(left==null){
//            return right;
//        }else if(right==null){
//            return left;
//        }
//        return root;
//    }




}
