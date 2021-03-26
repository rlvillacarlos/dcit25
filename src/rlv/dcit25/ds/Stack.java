package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public interface Stack<E> {
    void push(E e);
    
    E pop();
    
    E peek();
    
    int size();
    
    void clear();
    
    boolean isEmpty();
}
