package rlv.dcit25.ds;

/**
 *
 * @author Russel L. Villacarlos
 */
public class ArrayStack<E> implements Stack<E> {
    List<E> stack = new ArrayList<>();
    int top = -1;
    
    @Override
    public void push(E e) {
        top++;
        stack.add(top, e);
    }

    @Override
    public E pop() {
        E toRemove = stack.remove(top);
        top--;
        
        return toRemove;
    }

    @Override
    public E peek() {
        return stack.get(top);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
}
