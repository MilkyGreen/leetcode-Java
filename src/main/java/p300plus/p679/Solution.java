package p300plus.p679;

public class Solution {
    double EPSILON = 1e-6;
    double target = 24;
    int add = 0;
    int multi = 1;
    int sub = 2;
    int divide = 3;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int c : cards){
            list.add((double)c);
        }
        return solve(list);
    }

    boolean solve(List<Double> list){
        int size = list.size();
        if(size == 0){
            return false;
        }
        if(list.size() == 1){
            return Math.abs(list.get(0) - target) < EPSILON;
        }
        // 按顺序挑选两个数出来运算
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size;j++){
                if(i != j){
                    // 新的列表，最终会比list少一个
                    List<Double> list2 = new ArrayList<>();
                    // 先把没被选中运算的数字放入新列表
                    for(int k = 0;k < size;k ++){
                        if(k != i && k != j){
                            list2.add(list.get(k));
                        }
                    }
                    
                    // 四种操作符
                    for(int k = 0;k < 4;k++){
                        // 加或者乘操作不要求顺序，只计算一次就行了
                        if(i > j && k < 2){
                            continue;
                        }
                        // 进行计算，把结果放入新列表
                        if(k == add){
                            list2.add(list.get(i) + list.get(j));
                        }else if(k == multi){
                            list2.add(list.get(i) * list.get(j));
                        }else if(k == sub){
                            list2.add(list.get(i) - list.get(j));
                        }else{
                            if(Math.abs(list.get(j)) < EPSILON){
                                continue;
                            }
                            list2.add(list.get(i) / list.get(j));
                        }
                        // 递归使用新列表运算
                        if(solve(list2)){
                            return true;
                        }
                        // 这一轮没有符合的，把结果移除，尝试下一种运算符
                        list2.remove(list2.size()-1);
                    }
                    
                }
            }
        }
        return false;
    }
}
