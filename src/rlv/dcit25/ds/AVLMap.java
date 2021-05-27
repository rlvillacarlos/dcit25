package rlv.dcit25.ds;

/**
 *
 * @author russel
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K, V>{
    
    protected class AVLNode{
        K key;
        V value;
        int size;
        int height;
        AVLNode left;
        AVLNode right;

        public AVLNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.size = 1;
            this.height = 0;
        }
    }
    
    AVLNode root = null;
    
    @Override
    public V put(K key, V value) {
        AVLNode cur = search(root, key);
        
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
        AVLNode cur = search(root,key);
        
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
    
    
    protected AVLNode add(AVLNode r, K k, V v){
        if(r == null){
            return new AVLNode(k,v);
        }
        
        int result  = r.key.compareTo(k);
        
        if(result > 0){//New key is less than root's key
            r.left = add(r.left,k,v);
        }else if(result < 0){//New key is greater than root's key
            r.right = add(r.right,k,v);
        }
        
        setSize(r);
        
        makeAVL(r);
        
        return r;
    }
    
    protected AVLNode delete(AVLNode r,K k){
        if(r == null){//Key to delete is not found
            return null;
        }
        
        int result  = r.key.compareTo(k);

        if(result == 0) {//Node to be deleted is found
            if(r.left == null){
                AVLNode right = r.right;
                r.right = null;
                
                return right;
                
            }else if(r.right == null){
                AVLNode left = r.left;
                r.left = null;
                
                return left;
                
            }else{
                AVLNode pred = max(r.left);
                
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
        
        makeAVL(r);
        
        return r;
    }
    
    protected AVLNode search(AVLNode r, K k){
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
    
    protected AVLNode min(AVLNode r){
        if(r != null && r.left != null){
            return min(r.left);
        }
        return r;
    }
    
    protected AVLNode max(AVLNode r){
        if(r != null && r.right != null){
            return max(r.right);
        }
        return r;
    }
    
    protected int size(AVLNode r){
        if(r == null){
            return 0;
        }
        return r.size;
    }
    
    protected void setSize(AVLNode r){
        r.size = size(r.left) + size(r.right) + 1;
    }
    
    protected String inOrderVisit(AVLNode r){
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
    
    protected String preOrderVisit(AVLNode r){
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
    
    protected String postOrderVisit(AVLNode r){
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
    
    private AVLNode makeAVL(AVLNode r){    

        if(r == null){
            return null;
        }
        
        //Right subtree is taller than the left subtree by more than 1
        if(height(r.right) - height(r.left) > 1){
            
            //Height is due to left subtree (needs double rotation)
            if(height(r.right.left) > height(r.right.right)){                
                r.right = rightRotate(r.right);
            }
            
            return leftRotate(r);
        
        //Left subtree is taller than the right subtree by more than 1  
        }else if (height(r.left) - height((r.right)) > 1){ 
            
            //Height is due to right subtree (needs double rotation)
            if(height(r.left.right) > height(r.left.left)){
                r.left = rightRotate(r.left);
            }
            
            return rightRotate(r);
        }
        
        return r;
    }
    
    protected AVLNode leftRotate(AVLNode r){
        if(r.right == null){
            return r;
        }
        
        AVLNode right = r.right;
        AVLNode rightLeft = r.right.left;
        
        r.right = rightLeft;
        right.left = r;
        
        
        setSize(r);
        setSize(right);
        
        setHeight(r);
        setHeight(right);
        
        return right;
    }
    
    protected AVLNode rightRotate(AVLNode r){
        if(r.left == null){
            return r;
        }
        
        AVLNode left = r.left;
        AVLNode leftRight = r.left.right;

        r.left = leftRight;
        
        left.right = r;
        
        setSize(r);
        setSize(left);
        
        setHeight(r);
        setHeight(left);
        
        return left;
    }
    
    private int height(AVLNode r){
        return r!=null? r.height : -1;
    }
    
    private void setHeight(AVLNode r){
        if(r!=null){
            r.height =  Math.max(height(r.left),height(r.right)) + 1;
        }
    }
    
    public static void main(String[] args) {
        Map<String, Integer> scores = new AVLMap<>();
        
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
