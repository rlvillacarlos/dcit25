package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public class LinkedListQueue<E> implements Queue<E>{
    private class Node{
        E item;
        Node next;
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    
    public LinkedListQueue(){
        this.head = new Node();
        this.tail = this.head;
    }
    
    @Override
    public E dequeue(){
        
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        
        Node toRemove = head.next;
        head.next = toRemove.next;
        toRemove.next = null;
        
        if(tail == toRemove){
            tail = head;
        }
        
        size--;
        
        return toRemove.item; 
    }
    
    @Override
    public void enqueue(E e){
        Node newNode = new Node();
        newNode.item = e;
        
        newNode.next = tail.next;
        tail.next = newNode;
        
        tail = newNode;
        
        size++;
    }
    
    @Override
    public E peek(){
        
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        
        return head.next.item;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public void clear(){
        this.head.next = null;
        size = 0;
    }
}
