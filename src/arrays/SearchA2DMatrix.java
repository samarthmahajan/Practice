package arrays;

/**
 * LeetCode #74 - Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Each row is sorted ascending; the first integer of each row is greater than
 * the last integer of the previous row. Return true if target is in the matrix.
 * Required: O(log(m*n)).
 *
 * Time:  O(?)
 * Space: O(?)
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println("row "+ row +" col "+ col);
        int left = 0, right = row * col - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int mid_val = matrix[mid / col][mid % col];

            System.out.println(left + " " + right + " "+ mid);


            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;

    }

    public static void main(String[] args) {
        SearchA2DMatrix sol = new SearchA2DMatrix();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(sol.searchMatrix(matrix, 3));   // expected: true
        System.out.println(sol.searchMatrix(matrix, 13));  // expected: false
        System.out.println(sol.searchMatrix(matrix, 60));  // expected: true  (last cell)
        System.out.println(sol.searchMatrix(matrix, 1));   // expected: true  (first cell)
        System.out.println(sol.searchMatrix(matrix, 0));   // expected: false (below min)
        System.out.println(sol.searchMatrix(new int[][]{{5}}, 5));  // expected: true  (1x1)
        System.out.println(sol.searchMatrix(new int[][]{{5}}, 4));  // expected: false (1x1 miss)
    }
}
