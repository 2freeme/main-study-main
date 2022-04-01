package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/3/31 16:42
 */
class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    int size;
    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size || head == null) {
            return -1;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head;
        this.head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            this.head = new Node(val);
            head.next = null;
            size++;
        }else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node tail = new Node(val);
            tail.next = null;
            temp.next = tail;
            size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == this.size) {
            addAtTail(val);
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node insertNode = new Node(val);
        insertNode.next = temp.next;
        temp.next = insertNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index == 0) {
            if (size != 1) {
                Node temp = this.head.next;
                this.head =temp;
                size--;
                return;
            }else {
                this.head = null;
                size--;
                return;
            }
        }
        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node deleteNode = temp.next;
        temp.next = deleteNode.next;
        size--;
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

