package rlv.dcit25.ds;

/**
 *
 * @author Russel L. Villacarlos
 */
public interface Map<K,V> {
    public V put(K key,V value);
    
    public boolean remove(K key);
    
    public boolean contains(K key);
    
    public V get(K key);
    
    public int size();
    
    public void clear();    
    
    public boolean isEmpty();
}
