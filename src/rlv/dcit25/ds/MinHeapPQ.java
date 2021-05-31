package rlv.dcit25.ds;

import java.util.Iterator;

/**
 *
 * @author russel
 */
public class MinHeapPQ<E, P extends Comparable<P>> implements MinPQ<E,P> {
    
    private final List<P> heap;
    private final List<E> elements;
    
    public MinHeapPQ() {
        heap = new ArrayList<>();
        elements = new ArrayList<>();
        
        heap.add(null);
        elements.add(null);
    }
    
    //Build-Heap
    public MinHeapPQ(E[] elements, P[] priorities) {
        this();
        
        for(P p:priorities){
            this.heap.add(p);
        }

        for(E e:elements){
            this.elements.add(e);
        }
        
        int size = heap.size() - 1;
        
        for(int i = size/2;i>=1;i--){
            demote(i);
        }
        
    }
    
    @Override
    public void add(E element, P priority) {        
        elements.add(element);
        heap.add(priority);
        
        if(size()>1){
            promote(size());
        }
        
    }

    @Override
    public E getMin() {
        return elements.get(1);
    }
    
    
    @Override
    public E removeMin() {        
        swap(1, size());
        
        E toRemove = elements.remove(size());
        
        heap.remove(size());
        
        if(size()>1){
            demote(1);
        }
        
        return toRemove;
    }
  
    @Override
    public int size() {
        return heap.size() - 1;
    }

    @Override
    public void clear() {
        heap.clear();
        heap.add(null);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("[");
        for(E e:elements){
            tmp.append(e).append(", ");
        }
        if(tmp.length()>1){
            tmp.delete(tmp.length()-2, tmp.length());
        }
        return tmp.append("]").toString();
    }    
    
    private void promote(int i){
        P cur = heap.get(i);
        
        while(i != 1){
            int p = i/2;
            
            P parent = heap.get(p);
            
            if(cur.compareTo(parent) < 0){
                swap(i,p);
                i = p;
            }else{
                break;
            }
        }
    }
    
    private void demote(int i){
        P cur = heap.get(i);

        while(i <= size()/2){
            int m = i*2;
            int r = m + 1;
            
            P min = heap.get(m);
            
            if(r <= size()){
                P right = heap.get(r);

                if(right.compareTo(min)<0){
                    min = right;
                    m = r;
                }
            }
            
            if(min.compareTo(cur) < 0){
                swap(i,m);
                i = m;
            }else{
                break;
            }
        }
    }
    
    private void swap(int i,int j){
        P tmpPriority = heap.get(i);
        E tmpElement = elements.get(i);
        
        heap.set(i, heap.get(j));
        heap.set(j, tmpPriority);

        elements.set(i, elements.get(j));
        elements.set(j, tmpElement);
    }
    
    public static void main(String[] args) {
        MinHeapPQ<String, Integer> tardiness = new MinHeapPQ<>();
        
        tardiness.add("Mark", 10);
        tardiness.add("John", 12);
        tardiness.add("Sarah", 20);
        tardiness.add("Anna", 12);
        tardiness.add("James", 8);
        tardiness.add("Maria", 9);
        tardiness.add("Richard", 13);
        tardiness.add("May", 18);
        
        while(!tardiness.isEmpty()){
            System.out.println(tardiness.removeMin());
        }
    }
}
