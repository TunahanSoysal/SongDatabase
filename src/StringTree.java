public class StringTree {

    AVLStringNode root;
    int size;

    public StringTree(){
        root = null;
        size = 0;
    }
    public void insert (String key,int index){
        root = insert(key, root,index);
    }
    private AVLStringNode insert (String key, AVLStringNode node, int index){
        if (node == null){
            node = new AVLStringNode(key,index);
            size++;
            return node;
        }
        else{
            if (key.compareTo(node.key)<0 ){
                node.setLeftChild (insert (key, node.leftChild,index));

            }
            else{
                if (key.compareTo (node.key) > 0){
                    node.setRightChild (insert (key, node.rightChild,index));

                }
            }
        }

        return node;
    }
    public boolean isInTree (String key){
        return isInTree (key.toLowerCase(), root);
    }
    private boolean isInTree (String key, AVLStringNode node){
        if (node == null)
            return false;

        if (key.compareTo (node.key.toLowerCase()) < 0)
            return isInTree (key, node.leftChild);

        if (key.compareTo (node.key.toLowerCase()) > 0)
            return isInTree (key, node.rightChild);
        return true;


    }
    public AVLStringNode search(AVLStringNode root, String key) {
        if (root==null || root.key.toLowerCase().equals(key))
            return root;

        if (key.compareTo(root.key.toLowerCase()) > 0)
            return search(root.rightChild, key);

        return search(root.leftChild, key);
    }
}
class AVLStringNode {

    String key;
    int index;

    AVLStringNode leftChild=null;
    AVLStringNode rightChild=null;

    public AVLStringNode(String key, int index){
        this.key = key;
        this.index = index;
    }







    public void setLeftChild (AVLStringNode n)
    {
        leftChild = n;
    }



    public void setRightChild (AVLStringNode n){
        rightChild = n;
    }


}