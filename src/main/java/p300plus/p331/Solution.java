package p300plus.p331;

public class Solution {
    // 遍历到的位置
    int idx = 0;
    String[] nodes;
    public boolean isValidSerialization(String preorder) {
        this.nodes = preorder.split(",");
        if(isValid()){
            // 从根开始是合法二叉树，看看后面还有没有元素了，还有说明是多余的
            return idx == nodes.length;
        }else{
            return false;
        }
    }

    // 验证从idx位置开始往后是不是合法二叉树
    public boolean isValid(){
        // 索引越界了
        if(idx >= nodes.length){
            return false;
        }
        // 如果是#，就算是一个空树
        if(nodes[idx].equals("#")){
            idx++; // 注意索引要加一
            return true;
        }
        // 不是#，把当前字符跳过
        idx++;
        // 分别验证左右子树是否合法
        return isValid() && isValid();
    }
}
