package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public class TreeMap<K extends Comparable<K>,V> implements Map<K, V>{
    
    protected class Node{
        K key;
        V value;
        int size;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.size = 1;
        }
    }
    
    Node root = null;
    
    @Override
    public V put(K key, V value) {
        Node cur = search(root, key);
        
        V oldValue = null;
        
        if(cur == null){
            root = add(root, key, value);
        }else{
            oldValue = cur.value;
            cur.value = value;
        }
        return oldValue;
    }

    @Override
    public boolean remove(K key) {
        int size = size(root);
        
        root = delete(root, key);
                
        return size > size(root);
    }

    @Override
    public boolean contains(K key) {
        return search(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node cur = search(root,key);
        
        if(cur != null){
            return cur.value;
        }
        
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return "{" + inOrderVisit(root) + "}";
    }
    
    
    protected Node add(Node r, K k, V v){
        if(r == null){
            return new Node(k,v);
        }
        
        int result  = r.key.compareTo(k);
        
        if(result > 0){//New key is less than root's key
            r.left = add(r.left,k,v);
        }else if(result < 0){//New key is greater than root's key
            r.right = add(r.right,k,v);
        }
        
        setSize(r);
        
        return r;
    }
    
    protected Node delete(Node r,K k){
        if(r == null){//Key to delete is not found
            return null;
        }
        
        int result  = r.key.compareTo(k);

        if(result == 0) {//Node to be deleted is found
            if(r.left == null){
                Node right = r.right;
                r.right = null;
                
                return right;
                
            }else if(r.right == null){
                Node left = r.left;
                r.left = null;
                
                return left;
                
            }else{
                Node pred = max(r.left);
                
                r.key = pred.key;
                r.value = pred.value;
                r.left = delete(r.left,pred.key);                
            }
        }else if(result > 0){//Key of node to be deleted is less than root's key
            r.left = delete(r.left,k);
        }else {//Key of node to be deleted is greater than root's key
            r.right = delete(r.right,k);
        }
        
        setSize(r);
        
        return r;
    }
    
    protected Node search(Node r, K k){
        if(r == null){
            return null;
        }
        
        int result  = r.key.compareTo(k);

        if(result == 0) {
            return r;
        }else if(result > 0){
            return search(r.left,k);
        }else {
            return search(r.right,k);
        }
        
    }
    
    protected Node min(Node r){
        if(r != null && r.left != null){
            return min(r.left);
        }
        return r;
    }
    
    protected Node max(Node r){
        if(r != null && r.right != null){
            return max(r.right);
        }
        return r;
    }
    
    protected int size(Node r){
        if(r == null){
            return 0;
        }
        return r.size;
    }
    
    protected void setSize(Node r){
        r.size = size(r.left) + size(r.right) + 1;
    }
    
    protected String inOrderVisit(Node r){
        if(r == null){
            return "";
        }
        
        String left = inOrderVisit(r.left);
        String right = inOrderVisit(r.right);
        StringBuilder tmp = new StringBuilder("");
        
        if(left.length() > 0){
            tmp.append(left).append(", ");
        }
        
        tmp.append(r.key).append(": ").append(r.value);
        
        if(right.length() > 0){
            tmp.append(", ").append(right);
        }
        
        return tmp.append("").toString();
    }
    
    protected String preOrderVisit(Node r){
        if(r == null){
            return "";
        }
        
        String left = preOrderVisit(r.left);
        String right = preOrderVisit(r.right);
        StringBuilder tmp = new StringBuilder("");
        
        tmp.append(r.key).append(": ").append(r.value);
        
        if(left.length() > 0){
            tmp.append(", ").append(left);
        }
        
        
        if(right.length() > 0){
            tmp.append(", ").append(right);
        }
        
        return tmp.append("").toString();
    }
    
    protected String postOrderVisit(Node r){
        if(r == null){
            return "";
        }
        
        String left = postOrderVisit(r.left);
        String right = postOrderVisit(r.right);
        StringBuilder tmp = new StringBuilder("");
                
        if(left.length() > 0){
            tmp.append(left).append(", ");
        }
        
        
        if(right.length() > 0){
            tmp.append(right).append(", ");
        }
        
        tmp.append(r.key).append(": ").append(r.value);

        
        return tmp.append("").toString();
    }
    
    public static void main(String[] args) {
        Map<String, Integer> scores = new TreeMap<>();
        
        scores.put("Mark", 20);
        scores.put("John", 22);
        scores.put("Anna", 23);
        
        System.out.println(scores);
        
        scores.put("Anna", 35);
        
        System.out.println(scores);
        
        scores.remove("John");
        
        System.out.println(scores);
    }
    
}
