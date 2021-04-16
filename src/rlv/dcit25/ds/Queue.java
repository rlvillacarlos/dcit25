package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public interface Queue<E> {
    void enqueue(E e);
    
    E dequeue();
    
    E peek();
    
    int size();
    
    void clear();
    
    boolean isEmpty();
}
