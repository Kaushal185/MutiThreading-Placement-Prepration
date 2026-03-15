package Oops;

class Node{
    int data;
    Node next;
    Node(){
        this.data = 0;
        next = null;
    }
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    Node tail;
    void createList(int[] arr){
        if(arr == null || arr.length == 0) return;
        if(this.head == null) this.head = new Node(arr[0]);
        Node p = head;
        while(p.next != null) p = p.next;
        for(int i=1;i<arr.length;i++){
            p.next = new Node(arr[i]);
            p = p.next;
        }
    }
    void createList2(int[] arr){
        if(arr == null || arr.length == 0) return;
        for (int element: arr){
            addElement(element);
        }
    }
    void addElement(int data){
        if(head == null){
            this.head = new Node(data);
            return;
        }
        Node p = this.head;
        while(p.next != null){
            p = p.next;// stop at last node
        }
        p.next = new Node(data);
    }

    void removeElement(int data){
        Node p;
        for(p = this.head;p.next != null;p = p.next){
            if(p.next.data == head.data) break;// stop at prev node of the node which is going to be deleted
        }
        if(p.data == this.head.data){
            this.head = p;
            p = null;
        }else{

        }
    }
    void printList(){
        Node p = this.head;
        while(p != null){
            System.out.print(p.data+"->");
            p = p.next;
        }
    }
    LinkedList reverseList(){
        LinkedList newList = null;
        return  newList;
    }
}
public class LinkedListImpl {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = {1,2,3,4,5,6,7};
        list.createList(arr);
        list.printList();
    }
}
