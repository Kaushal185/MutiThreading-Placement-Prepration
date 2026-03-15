package SystemDesign.lldPractice;

import java.util.HashMap;

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key,int value){
        this.key = key;
        this.value = value;
        prev = next = null;
    }
}
class LRUCache{
    HashMap<Integer,Node>map = new HashMap<>();
    Node head;
    Node tail;
    int limit;
    void addNode(Node newNode){
        Node oldNext = head.next;
        head.next = newNode;
        oldNext.prev = newNode;
        newNode.next = oldNext;
        newNode.prev = head;
    }

    void deleteNode(Node oldNode){
        Node oldPrev = oldNode.prev;// address of prev node of currentNode
        Node oldNext = oldNode.next;// address of next node of currentNode

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;

        oldNode.next = null;
        oldNode.prev = null;

    }
    LRUCache(int capacity){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        limit = capacity;
    }
    int get(int key){
        if(!map.containsKey(key)) return -1;
        Node ansNode = map.get(key);
        int ans = ansNode.value;
        map.remove(ansNode.key);
        deleteNode(ansNode);
        addNode(ansNode);
        map.put(key,ansNode);
        return ans;
    }
    void put(int key,int value) {
       if(map.containsKey(key)){
           Node node = map.get(key);
           deleteNode(node);
           map.remove(key);
       }
       if(map.size() == this.limit){
           map.remove(tail.prev.key);
           deleteNode(this.tail.prev);
       }

       Node newNode = new Node(key,value);
       addNode(newNode);
       map.put(key,newNode);
    }
}
public class LRUCacheImpl {
    public static void main(String[] args) {

    }
}
