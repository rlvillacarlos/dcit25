package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public class LinkedListStack<E> implements Stack<E>{
    private class Node{
        E item;
        Node next;
    }
    
    private Node head;
    private int size;
    
    
    public LinkedListStack(){
        this.head = new Node();
    }
    
    @Override
    public E pop(){
        
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        
        Node toRemove = head.next;
        head.next = toRemove.next;
        toRemove.next = null;
        
        size--;
        
        return toRemove.item; 
    }
    
    @Override
    public void push(E e){
        Node newNode = new Node();
        newNode.item = e;
        
        newNode.next = head.next;
        head.next = newNode;
        
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
