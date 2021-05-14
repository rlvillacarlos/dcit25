package rlv.dcit25.ds;

import java.util.Iterator;

/**
 *
 * @author russel
 */
public class ArrayList<E> implements List<E> {
    
    private E arr[];
    private int next;

    public ArrayList() {
        arr = (E[]) new Object[1];
        next = 0;
    }

    @Override
    public void add(int i, E e) {
        if(i < 0 || i > next){
            throw new IndexOutOfBoundsException();
        }
        
        for(int j = next; j > i; j--){
            arr[j] = arr[j-1];
        }
        
        arr[i] = e;
        next++;
        
        if(next == arr.length){
            resize();
        }
        
    }

    @Override
    public void add(E e) {
        add(next,e);
    }

    @Override
    public E remove(int i) {
        if(i < 0 || i > next - 1){
            throw new IndexOutOfBoundsException();
        }
        
        E temp = arr[i];
        
        for(int j = i; j < next - 1; j++){
            arr[j] = arr[j+1];
        }
        
        next--;
        
        arr[next] = null;
        
        if(next <= arr.length/4){
            resize();
        }
        
        return temp;
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
        if(i < 0 || i > next - 1){
            throw new IndexOutOfBoundsException();
        }
        return arr[i];
    }

    @Override
    public E set(int i, E e) {
        if(i < 0 || i > next - 1){
            throw new IndexOutOfBoundsException();
        }
        
        E prev = arr[i];
        
        arr[i] = e;
        
        return prev;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    @Override
    public int indexOf(E e) {
        for(int i = 0; i < next;i++){
            if(e.equals(arr[i])){
                return i;
            }
        }
        
        return -1;
    }

    @Override
    public int size() {
        return next;
    }

    @Override
    public void clear() {
        next = 0;
        resize();
    }

    @Override
    public boolean isEmpty() {
        return next == 0;
    }
    
    private void resize(){
        E[] temp = (E[]) new Object[Math.max(1, next*2)];
        
        for(int i =0;i< next; i++){
            temp[i] = arr[i];
        }
        
        arr = temp;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("[");
        
        for(int i = 0; i < next; i++){
            tmp.append(arr[i]).append(", ");
        }
        
        if(tmp.length() > 1){
            tmp = tmp.delete(tmp.length()-2, tmp.length());
        }
        
        return tmp.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cur = -1;
            
            @Override
            public boolean hasNext() {
                return cur < next - 1;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new IndexOutOfBoundsException();
                }
                
                return arr[++cur];
                
            }
        };
    }
    
    
    
}
