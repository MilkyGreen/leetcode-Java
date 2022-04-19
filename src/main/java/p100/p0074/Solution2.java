package p100.p0074;

public class Solution2 {
    // 两次二分，先找行，再找目标数字
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row - 1;
        int i = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int v = matrix[mid][0];
            if (v == target) {
                return true;
            } else if (v > target) {
                right = mid - 1;
            } else {
                if (mid == row - 1 || matrix[mid + 1][0] > target) {
                    i = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }

        left = 0;
        right = col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int v = matrix[i][mid];
            if (v == target) {
                return true;
            } else if (v > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
