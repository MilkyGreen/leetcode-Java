package p300plus.p860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int bill : bills){
            if(bill == 5){
                fives++;
            }else if(bill == 10){
                if(fives <= 0){
                    return false;
                }
                fives--;
                tens++;
            }else{
                if(fives <= 0){
                    return false;
                }
                fives--;
                if(tens > 0){
                    tens--;
                }else{
                    if(fives < 2){
                        return false;
                    }
                    fives -= 2;
                }
            }
        }
        return true;
    }
}
