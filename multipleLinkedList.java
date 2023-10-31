/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LinkedList;

public class multipleLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertAfter(list.find(3), 88);
//        list.deleteNode(list.find(3));
//        list.printList();
        list.insertBefore(list.find(2), 1000);
                list.printList();

    }

}

class Node {

    public int data;
    public Node next;
    public Node Back;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.Back = null;
    }
}

class LinkedList {

    public Node head = null;
    public Node tail = null;

    linkedListIterator begin() {
        linkedListIterator itr = new linkedListIterator(this.head);
        return itr;
    }

    void printList() {
        for (linkedListIterator itr = this.begin(); itr.current() != null; itr.next()) {
            System.out.println(itr.data() + " ");
        }

    }

    Node find(int _data) {
        for (linkedListIterator itr = this.begin(); itr.current() != null; itr.next()) {
            if (itr.data() == _data) {
                return itr.current();
            }
        }
        return null;
    }

    void insertAfter(Node oldNode, int data) {
        Node newNode = new Node(data);
        newNode.next = oldNode.next;
        newNode.Back = oldNode;
        oldNode.next = newNode;

        if (newNode.next == null) {
            this.tail = newNode;
        } else {
            newNode.next.Back = newNode;
        }
    }

    void insertLast(int data) {
        Node newNode = new Node(data);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.Back = this.tail;
            newNode.Back.next = newNode;
            this.tail = newNode;
        }
    }

    void insertBefore(Node oldNode, int data) {
        Node newNode = new Node(data);
        newNode.next=oldNode;
        if(oldNode==this.head){
            this.head=newNode;
        }else{
            oldNode.Back.next = newNode;
            
        }
        oldNode.Back=newNode;
    }

    void deleteNode(Node node) {
        if (this.head == this.tail) {
            this.tail = null;
            this.head = null;

        }else if(node.Back==null){
            this.head=node.next;
            node.next.Back=null;
        }else if(this.tail==node){
            this.tail=node.Back;
            node.Back.next=null;
        }else{
            node.Back.next=node.next;
            node.next.Back=node.Back;
        }
    }
}

class linkedListIterator {

    private Node current;

    public linkedListIterator() {
        this.current = null;
    }

    public linkedListIterator(Node node) {
        this.current = node;
    }

    int data() {
        return this.current.data;
    }

    linkedListIterator next() {
        this.current = this.current.next;
        return this;
    }

    Node current() {
        return this.current;
    }

}
