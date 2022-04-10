package p300plus.p2223;

/**
 * <p>
 */
public class Solution {

    public int convertTime(String current, String correct) {
        String[] currs = current.split(":");
        int curH = Integer.parseInt(currs[0]);
        int curM = Integer.parseInt(currs[1]);

        String[] cors = correct.split(":");
        int corH = Integer.parseInt(cors[0]);
        int corM = Integer.parseInt(cors[1]);

        int step = 0;
        if(curM > corM){
            corM += 60;
            curH += 1;
        }
        int m = corM - curM;
        if(m > 15){
            step += m / 15;
            m -= 15 * (m / 15);
        }
        if(m > 5){
            step += m / 5;
            m -= 5 * (m / 5);
        }
        if(m > 1){
            step += m;
        }

        if(curH > corH){
            corH += 24;
            step++;
        }
        int h = corH - curH;
        step += h;

        return step;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertTime("02:30","04:35"));
    }
}
