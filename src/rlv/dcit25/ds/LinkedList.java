package rlv.dcit25.ds;

import java.util.Iterator;

/**
 *
 * @author Russel L. Villacarlos
 */
public class LinkedList<E> implements List<E> {
    
    private class Node{
        E value;
        Node next;
    }

    Node head;
    Node tail;
    int size;
    
    public LinkedList() {
        this.head = new Node();//Head Node (Dummy Node)
        this.tail = head;
    }
    
    @Override
    public void add(int i, E e) {
        Node nodeBefore = getNodeBefore(i);
        
        Node newNode = new Node();
        newNode.value = e;
        
        newNode.next = nodeBefore.next;
        nodeBefore.next = newNode;
        
        if(i == size){
            tail = newNode;
        }
        
        size++;
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public E remove(int i) {
        Node nodeBefore = getNodeBefore(i);
        Node nodeToRemove = nodeBefore.next;
        
        nodeBefore.next = nodeToRemove.next;
        nodeToRemove.next = null;
        
        if(i == size - 1){
            tail = nodeBefore;
        }
        
        size--;
        
        return nodeToRemove.value;
    }

    @Override
    public boolean remove(E e) {
        
        int i = indexOf(e);
        
        if(i == -1){
            return false;
        }
        
        remove(i);
        
        return true;
    }

    @Override
    public E get(int i) {
        Node cur = getNodeAt(i);
        return cur.value;
    }

    @Override
    public E set(int i, E e) {
        Node cur = getNodeAt(i);
        E oldValue = cur.value;
        cur.value = e;
        
        return oldValue;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(E e) {

        Node cur = head.next;
        int pos = 0;
        
        while(cur != null){
            if(cur.value.equals(e)){
                return pos;
            }
            cur = cur.next;
            pos++;
        }
        
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head.next = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    private Node getNodeBefore(int index){
        return index == 0 ? head : getNodeAt(index - 1);
    }
    
    private Node getNodeAt(int index){
        
        if (index < 0 || index > size -1 ){
            throw new IndexOutOfBoundsException();
        }
        
        if(index == size - 1){
            return tail;
        }
        
        Node cur = head.next;
        int pos = 0;
        
        while(pos < index){
            cur = cur.next;
            pos++;
        }
        
        return cur;
    }
    
    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("[");
        
        for(Node cur = head.next; cur != null; cur = cur.next){
            tmp.append(cur.value).append(", ");
        }
        
        if(tmp.length() > 1){
            tmp = tmp.delete(tmp.length()-2, tmp.length());
        }
        
        return tmp.append("]").toString();
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node cur = head;
            
            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public E next() {
                
                if(!hasNext()){
                    throw new IndexOutOfBoundsException();                
                }
                
                cur = cur.next;
                
                return cur.value;
            }
        };
    }
}
