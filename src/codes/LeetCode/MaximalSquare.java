package codes.LeetCode;
/* https://leetcode.com/problems/maximal-square/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and 
 * return its area.
 * 
 * Example:
 * Input: 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * 
 * Hint : Dynamic Programming ...can solve using 2D array but we can optimize it to 1D array
 * 
 * Time: O(mn) m,n =>no of rows and columns
 * Space: O(n) n=> no of columns
 */
public class MaximalSquare {
	
	public static int maximalSquare(char[][] matrix) {
       int maxLength = 0;
       int rowCount = matrix.length;
       if(rowCount == 0) {
    	   return maxLength;
       }
       int colCount = matrix[0].length;
       int[] dp = new int[colCount+1];
       int temp = 0;
       int prev = 0;
       for(int i=1;i<=rowCount;i++) {
    	   for(int j=1;j<=colCount;j++) {
    		   temp = dp[j];
    		   if(matrix[i-1][j-1]=='1') {
    			   dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
    			   maxLength = Math.max(maxLength, dp[j]);
    		   } else {
    			   dp[j] = 0;
    		   }
    		   prev = temp;
    	   }
       }
       return maxLength * maxLength;
    }

	public static void main(String[] args) {
		char[][] arr = {{'1','0','1','0','0'},
						{'1','0','1','1','1'},
						{'1','1','1','1','1'},
						{'1','0','0','1','0'}
					  };
		System.out.println(maximalSquare(arr));		
	}

}
