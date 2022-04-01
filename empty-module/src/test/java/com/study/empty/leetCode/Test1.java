package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Stack;


class MyLinkedList2 {
    @ToString
    class Node implements Serializable{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node() {
        }
    }

    int size;
    Node head;

    public MyLinkedList2() {
        Stack
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (size == 0 || index >= size) {
            return -1;
        }
        int i = 0;
        Node temp = head;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.val;

    }

    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
        System.out.println(JSONObject.toJSONString(head));

    }

    public void addAtTail(int val) {
        Node temp = head;
        Node last = new Node(val);
        for (int j = 0; j<size;j++){
            temp = temp.next;
        }
        temp= last;
        head= temp;
        size++;
    }

    public void addAtIndex(int index, int val) {
        Node last = new Node();
        last.val = val;
        Node temp = head;
        for (int i = 0; i<index-1; i++){
            temp = temp.next;
        }
        Node indexNode = temp.next;
        temp.next = last;
        last.next = indexNode;
        size++;
    }

    public void deleteAtIndex(int index) {

        Node temp = head;
        for (int m = 0; m<index-1; m++){
            temp = temp.next;
        }
        Node indexNode = temp.next.next;
        temp.next = indexNode;

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(JSONObject.toJSONString(linkedList.head));
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(JSONObject.toJSONString(linkedList));

        linkedList.get(1);            //返回2
        System.out.println(JSONObject.toJSONString(linkedList));

        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
        System.out.println(JSONObject.toJSONString(linkedList));



    }
}

