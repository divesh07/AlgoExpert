package algoExpert.tree;
/*
BST - value , left , right child node where
value > left & value < right
*/
public class BSTConstruction {
    static class BST{
        public int value;
        public BST left;
        public BST right;

        public BST(int value){
            this.value = value;
        }

        public BST insert(int value){
            if ( value < this.value) {
                if (left == null) {
                    BST newBST = new BST(value);
                    left = newBST;
                } else {
                    left.insert(value);
                }
            }else{
                if ( right == null){
                    BST newBST = new BST(value);
                    right = newBST;
                }else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value){
            if ( value < this.value){
                if (left == null){
                    return false;
                }else {
                    return left.contains(value);
                }
            }else if ( value > this.value){
                if (right == null){
                    return false;
                }else {
                    return right.contains(value);
                }
            }else {
                return true;
            }
        }

        public BST remove(int value){
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent){
            if ( value < this.value){
                if ( left != null){
                    left.remove(value,this);
                }
            }else if ( value > this.value){
                if (right != null){
                    right.remove(value,this);
                }
            }else {
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                }
            }


        }

        public int getMinValue(){
            if ( left == null){
                return this.value;
            }else{
                return left.getMinValue();
            }
        }
    }
}
