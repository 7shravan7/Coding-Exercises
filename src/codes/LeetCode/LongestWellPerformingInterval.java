package codes.LeetCode;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/longest-well-performing-interval/
 * 1124. Longest Well-Performing Interval
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than 
 * the number of non-tiring days.
 * Return the length of the longest well-performing interval. 
 * 
 * Example 1:
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 *
 * Constraints:
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 * 
 * Time : O(n)
 * Space: O(n)
 */

public class LongestWellPerformingInterval {
	
	public static int getLongestWellPerformingInterval(int[] inputArr) {
		int result = 0;
		int arrLength = inputArr.length;
		int sum = 0;
		Map<Integer,Integer> sumIndexMap = new HashMap<>();
		for(int i=0;i<arrLength;i++) {
			sum += inputArr[i]>8 ? 1: -1;
			if(sum > 0) {
				result = i+1;
			} else {
				sumIndexMap.putIfAbsent(sum, i);
				if(sumIndexMap.containsKey(sum-1)) {
					result = Math.max(result, i - sumIndexMap.get(sum-1));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {7,7,6,6,6,9};
		System.out.println(getLongestWellPerformingInterval(arr));
	}
}
