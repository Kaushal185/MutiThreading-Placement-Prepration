package dsa.implementations;

class Node<K,V>{
    K key;
    V value;
    Node<K,V> next;
    Node(K key,V value){
        this.key = key;
        this.value = value;
    }
}
class MyHashMap<K,V>{
  private int capacity = 16;
  private Node<K,V> [] bucket;
    @SuppressWarnings("unchecked")
    MyHashMap(){
      bucket = new Node[capacity];
  }
}
public class HashTableImpl {

}
