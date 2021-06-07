package rlv.dcit25.ds;

import rlv.dcit25.ds.UpdatableMinPQ.PQHandle;

/**
 *
 * @author russel
 */
public class UpdatableMinHeapPQ<E, P extends Comparable<P>> implements UpdatableMinPQ<E,P> {
    
    public static class MinHeapPQHandle extends PQHandle{
        private Integer index = 0;

        public MinHeapPQHandle(){/*Intentionally empty*/}
        
        private MinHeapPQHandle(Integer index) {
            this.index = index;
        }
        
        @Override
        protected Object getElementReference() {
            return index;
        }
        
    }
        
    private final List<P> heap;
    private final List<E> elements;
    private final List<MinHeapPQHandle> handles;
    
    public UpdatableMinHeapPQ() {
        heap = new ArrayList<>();
        elements = new ArrayList<>();
        handles = new ArrayList<>();
        
        heap.add(null);
        elements.add(null);
        handles.add(null);
    }
    
    //Build-Heap
    public UpdatableMinHeapPQ(E[] elements, P[] priorities, MinHeapPQHandle[] handles) {
        this();
        
        for(P p:priorities){
            this.heap.add(p);
        }

        for(E e:elements){
            this.elements.add(e);
        }
        
        for(MinHeapPQHandle h:handles){
            h.index = this.handles.size();
            this.handles.add(h);
        }
        
        int size = heap.size() - 1;
        
        for(int i = size/2;i>=1;i--){
            demote(i);
        }
        
    }
    
    @Override
    public PQHandle add(E element, P priority) {        
        elements.add(element);
        heap.add(priority);
        
        MinHeapPQHandle handle = new MinHeapPQHandle(0);
        handles.add(handle);
        handle.index = handles.size() - 1 ;
        
        if(size()>1){
            promote(size());
        }
        
        return handle;
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
    public void decreasePriority(PQHandle elementHandle, P priority) {
        Integer index = (Integer) elementHandle.getElementReference();
        P curPriority = heap.get(index);
        
        if(priority.compareTo(curPriority) < 0 ){
            heap.set(index, priority);
            promote(index);
        }
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
        heap.set(i, heap.get(j));
        heap.set(j, tmpPriority);

        E tmpElement = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, tmpElement);
        
        MinHeapPQHandle tmpHandle = handles.get(i);
        handles.get(j).index = i;
        tmpHandle.index = j;        
        handles.set(i, handles.get(j));
        handles.set(j, tmpHandle);
    }
    
    public static void main(String[] args) {
        UpdatableMinHeapPQ<String, Integer> tardiness = new UpdatableMinHeapPQ<>();
        
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
