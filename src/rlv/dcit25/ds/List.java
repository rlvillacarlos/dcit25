package rlv.dcit25.ds;

/**
 *
 * @author Russel L. Villacarlos
 * @param <E> element type
 */
public interface List<E> extends Iterable<E>{
    void add(int i, E e);
    
    void add(E e);
 
    E remove(int i);
    
    boolean remove(E e);
    
    E get(int i);
    
    E set(int i,E e) ;
    
    boolean contains(E e);
    
    int indexOf(E e);
    
    int size();
    
    void clear();
    
    boolean isEmpty();
}

