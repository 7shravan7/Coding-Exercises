package codes.LeetCode;

/*
 * Given an array of numbers, in which exactly two elements appear only once and all the other elements 
 * appear exactly twice. Find the two elements that appear only once.
 * 
 * Note: The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant 
 * space complexity?
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Time	: O(n)
 * Space: O(1)
 * 
 * 27/08/19
 */

public class SingleNumber3 {
	
	/*
	 * x & (-x) is a way to isolate the rightmost 1-bit, i.e. to keep the rightmost 1-bit and to set all 
	 * the others bits to zero.
	 * 
	 * -x = ~x + 1;
	 * https://leetcode.com/articles/single-number-iii/
	 */
	public static void printSingleNumbers(int[] inputArray) {
		int bitMask = 0;
		for(Integer num:inputArray) {
			bitMask ^= num;
		}
		int diff = bitMask & (-bitMask); // x & (-x) -> num with rightmostbit set and rest are zero
		int xVal = 0;
		int yVal = 0;
		for(Integer num:inputArray) {
			if((num & diff) !=0) {
				xVal ^= num;
			}
		}
		yVal = bitMask ^ xVal;
		System.out.println("The two numbers which appears once are "+xVal+","+yVal);
	}

	public static void main(String[] args) {
		int[] inputArr1 = {1,2,1,3,2,5};
		printSingleNumbers(inputArr1);
		int[] inputArr2 = {2,4,6,2,4,10};
		printSingleNumbers(inputArr2);
	}

}

