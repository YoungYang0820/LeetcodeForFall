class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                if (mid > 0 && matrix[mid-1][n-1] > target) {
                    right = mid - 1;
                }
                else if (mid < m - 1) {
                    if (matrix[mid+1][0] < target) {
                        left = mid + 1;
                    } else if (matrix[mid+1][0] == target) {
                        return true;
                    } else {
                        break;
                    }
                }
                else {
                    break;
                }
            }
        }

        left = 1;
        right = n - 1;
        while (left <= right) {
            int mid2 = left + (right - left) / 2;
            if (matrix[mid][mid2] == target) return true;
            if (matrix[mid][mid2] < target) {
                left = mid2 + 1;
            } else {
                right = mid2 - 1;
            }
        }
        return false;
    }
}
