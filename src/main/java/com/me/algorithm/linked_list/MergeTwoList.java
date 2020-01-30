package com.me.algorithm.linked_list;

public class MergeTwoList {

    /**
     * 循环
     * @param n1
     * @param n2
     * @return
     */
    public static Node mergeTwoListByLoop(Node n1, Node n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }

        Node head, temp;
        if(n1.data < n2.data){
            temp = n1;
            n1 = n1.next;
        }else{
            temp = n2;
            n2 = n2.next;
        }
        head = temp;

        while(n1 != null && n2 != null){
            if(n1.data < n2.data){
                temp.next = n1;
                n1 = n1.next;
            }else{
                temp.next = n2;
                n2 = n2.next;
            }
            temp = temp.next;
        }

        if(n1 == null){
            temp.next = n2;
        }
        if(n2 == null){
            temp.next = n1;
        }

        return head;
    }

    /**
     * 递归
     * @param n1
     * @param n2
     * @return
     */
    public static Node mergeTwoListByRecursive(Node n1, Node n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }

        Node head;
        if(n1.data < n2.data){
            head = n1;
            head.next = mergeTwoListByRecursive(n1.next, n2);
        }else{
            head = n2;
            head.next = mergeTwoListByRecursive(n1, n2.next);
        }
        return head;
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}