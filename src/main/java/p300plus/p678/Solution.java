package p300plus.p678;

public class Solution {
    public boolean checkValidString(String s) {
        int len = s.length();
        if(len == 0){
            return true;
        }
        Stack<Integer> lefts = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                lefts.push(i);
            }else if(c == '*'){
                stars.push(i);
            }else{
                if(lefts.size() > 0){
                    lefts.pop();
                }else if(stars.size() > 0){
                    stars.pop();
                }else{
                    return false;
                }
            }
        }
        if(lefts.size() == 0){
            return true;
        }else{
            if(stars.size() == 0 || stars.size() < lefts.size()){
                return false;
            }
            while(lefts.size() > 0){
                if(lefts.pop() > stars.pop()){
                    return false;
                }
            }
            return true;
        }
    }
}
