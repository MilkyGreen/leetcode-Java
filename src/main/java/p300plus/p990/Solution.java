package p300plus.p990;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i = 0;i < 26;i++){
            parent[i] = i;
        }

        for(String s : equations){
            char a = s.charAt(0);
            char equal = s.charAt(1);
            char b = s.charAt(3);
            if('=' == equal){
                union(parent, a - 'a', b - 'a');
            }
        }

        for(String s : equations){
            char a = s.charAt(0);
            char equal = s.charAt(1);
            char b = s.charAt(3);
            if('!' == equal){
               if(find(parent, a - 'a') == find(parent, b - 'a')){
                  return false;
               }
            }
        }
        return true;
    }

    public void union(int[] parent,int index1,int index2){
        parent[find(parent,index1)] = find(parent,index2);
    }

    public int find(int[] parent,int index){
        if(parent[index] == index){
            return index;
        }else{
            int ret = find(parent, parent[index]);
            parent[index] = ret;
            return ret;
        }
    }
}
