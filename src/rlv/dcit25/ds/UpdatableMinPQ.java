package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public interface UpdatableMinPQ<E,P>{
    
    abstract class PQHandle{
        protected abstract Object getElementReference();
    }

    public PQHandle add(E element, P priority);

    public void decreasePriority(PQHandle elementHandle, P priority);
    
    public E getMin();
    
    public E removeMin();

    public int size();
    
    public void clear();
    
    public boolean isEmpty();
    
}
