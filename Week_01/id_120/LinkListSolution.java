package com.data.structure.linklist.singlelinkedlist;


/**
 * @author zzl
 * @date 2019/4/18 13:51
 * @description 单链表数据两两交换
 */

public class LinkListSolution {

    public ListNode swap(ListNode head){

        //头指针作为临界点
        if(head==null||head.next==null){
            return head;
        }
        //需要进行交换的数据，2个分成1组，节点总数有可能节点是偶数，有可能是奇数
        //偶数的话，一组的2个节点互换。奇数的话，最后一组是1个节点，不需要交换。
        //每一组有2个节点，称为节点1和节点2，一组交换之后，
        // 会重新到下一组，下一组的2个数据称为新的节点1和节点2
        //节点1和节点2，是自己定义的一个称谓，方便理解。
        //节点3是指下一组的第一个节点。

        //构造虚拟指针
        ListNode virtualNode=new ListNode(-1);
        virtualNode.next=head;


        //2个一组的第一个节点
        ListNode node1=head;

        ListNode node2=null;

        //当前节点的上一个节点
        ListNode lastNode=virtualNode;

        // 1 ,2 ,3,4

        //如果节点的个数是奇数，则最后一个不需要反转。如果是偶数，则
        while(node1!=null&&node1.next!=null){
            //第一步：暂存节点2
             node2 =node1.next;

            //第二步：修改节点1的next指向节点3   head, 1,3,4
            node1.next=node1.next.next;


            //第三步：将上一个节点指向节点2     head,2
            lastNode.next=node2;

            //第四步：将第二个节点的下一个节点指向第一个节点
            node2.next=node1;

            //第五步: 重置上一个节点
            lastNode=node1;

            //重置节点1为下一组的第一个节点
            node1=node1.next;
        }

        return virtualNode.next;
    }
}
