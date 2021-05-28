package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public interface MinPQ<E, P> {

    public void add(E value, P priority);
    
    public E getMin();
    
    public E removeMin();

    public int size();
    
    public void clear();
    
    public boolean isEmpty();

}
