package p200.p152;

/**
 */
public class Solution2 {

    public int maxProduct(int[] nums) {
        int l = nums.length;
        int start = 0;
        int end = 0;
        int neNum = 0;
        int fristNe = -1;
        int endNE = 0;

        int max = -11;
        int p = 0;

        boolean lastZero = true;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] == 0) {

                if (i == 0) {
                    p = 0;
                    continue;
                }
                lastZero = true;
                // todo
                if (neNum % 2 == 0) {
                    max = Math.max(p, max);
                } else {

                    if (start != end) {
                        int left = 1;
                        for (int j = start; j < fristNe; j++) {
                            left *= nums[j];
                        }
                        max = Math.max(left, max);

                        int right = 1;
                        for (int j = fristNe + 1; j <= end; j++) {
                            right *= nums[j];
                        }
                        max = Math.max(right, max);

                        left = 1;
                        for (int j = endNE + 1; j <= end; j++) {
                            left *= nums[j];
                        }
                        max = Math.max(left, max);

                        right = 1;
                        for (int j = start; j < endNE; j++) {
                            right *= nums[j];
                        }
                        max = Math.max(right, max);
                    }
                }
                p = 0;
                fristNe = -1;
                neNum = 0;
            } else {
                if(p == 0){
                    p = nums[i];
                }else{
                    p *= nums[i];
                }

                if (lastZero) {
                    start = i;
                }
                lastZero = false;
                if (nums[i] < 0) {
                    if (fristNe == -1) {
                        fristNe = i;
                    }
                    neNum++;
                    endNE = i;
                }
                end = i;
            }
        }
        if (neNum % 2 == 0) {
            max = Math.max(p, max);
        } else {
            if (start != end) {
                int left = 1;
                for (int j = start; j < fristNe; j++) {
                    left *= nums[j];
                }
                max = Math.max(left, max);

                int right = 1;
                for (int j = fristNe + 1; j <= end; j++) {
                    right *= nums[j];
                }
                max = Math.max(right, max);

                left = 1;
                for (int j = endNE + 1; j <= end; j++) {
                    left *= nums[j];
                }
                max = Math.max(left, max);

                right = 1;
                for (int j = start; j < endNE; j++) {
                    right *= nums[j];
                }
                max = Math.max(right, max);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] ns = new int[]{-2,0};
        System.out.println(new Solution2().maxProduct(ns));
    }

}
