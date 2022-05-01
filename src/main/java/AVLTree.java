/**
 */
public class AVLTree {

    class TreeNode{
        int height;
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        }
    }

    int getBalanceFactor(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.left.height - root.right.height;
    }

    TreeNode rightRotate(TreeNode root){
        TreeNode left = root.left;
        root.left = left.right;
        left.right = root;

        left.height = Math.max(getHeight(left.left),getHeight(left.right)) + 1;
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        return left;
    }

    TreeNode leftRotate(TreeNode root){
        TreeNode right = root.right;
        root.right = right.left;
        right.left = root;

        right.height = Math.max(getHeight(right.left),getHeight(right.right)) + 1;
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        return right;
    }

    /**
     * 分为四种情况：
     * 1、左边权重高，且多的节点在左边的左边，此时右旋
     * 2、左边权重高，且多的节点在左边的右边，此时先左旋再右旋
     * 3、右边权重高，且多的节点在右边的右边，此时左旋
     * 4、右边权重高，且多的节点在右边的左边，此时先右旋再左旋
     *
     * 总之就是要从节点多的方向向少的方向旋转
     * @param root
     * @return
     */
    TreeNode reBalance(TreeNode root){
        int bf = getBalanceFactor(root);
        if(bf > 1 && getBalanceFactor(root.left) > 0){
            return rightRotate(root);
        }else if(bf > 1 && getBalanceFactor(root.left) <= 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }else if(bf < -1 && getBalanceFactor(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }else if(bf < -1 && getBalanceFactor(root.right) <= 0){
            return leftRotate(root);
        }
        return root;
    }

    TreeNode insert(TreeNode root,int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insert(root.left,val);
        }else if(root.val < val){
            root.right = insert(root.right,val);
        }else{
            return root;
        }
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        return reBalance(root);
    }

}
