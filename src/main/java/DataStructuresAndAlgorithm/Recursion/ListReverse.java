package DataStructuresAndAlgorithm.Recursion;

import java.net.InetSocketAddress;

public class ListReverse {

    private static class Node{

        private int data;

        private Node prev;
        private Node next;

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node head = node1;
        while(head != null) {
            System.out.println("节点"+head.getData());
            head = head.getNext();
        }

        // 给定一个节点，把该节点起后方的链表反转，返回的是节点尾
        Node tail = reverseNodeListV2(node1);
        System.out.println("节点" + tail.getData());

        head = tail;

        while(head != null) {
            System.out.println("节点"+head.getData());
            head = head.getNext();
        }


    }

    // 返回反转完的节点尾
    private static Node reverseNodeList(Node head) {
        if (head.getNext() == null) {
            return head;
        }
        Node head1 = reverseNodeList(head.getNext());
        head1.setNext(head);
        head.setNext(null);
        return head;
    }

    // 返回反转完成的节点头
    private static Node reverseNodeListV2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node newHead = reverseNodeListV2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;

    }

    }
