package codes.DailyCodingProblems.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a list of integers and a number K, return which contiguous elements of the list sum to K.
 * For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.
 * 
 * add up: Should handle negative numbers and negative sum too
 * 
 * Time : O(n)
 * Space: O(n)
 * 
 * 26.08.19
 */

public class ContinguousSumSubarray {
	
	public static void printContinguousSumSubarray(List<Integer> inputList, int targetSum) {
		int listLength = inputList.size();
		int currSum = 0;
		int remainingSum = 0;
		int initialStartIndex = 0;
		Map<Integer,Integer> numberIndexMap = new HashMap<>();
		int i=0;
		for(;i<listLength;i++) {
			currSum += inputList.get(i);
			if(currSum == targetSum) {
				printList(inputList,initialStartIndex,i);
				break;
			} else {
				remainingSum = currSum - targetSum;
				if(numberIndexMap.containsKey(remainingSum)) {
					printList(inputList,numberIndexMap.get(remainingSum)+1,i);
					break;
				}
			}
			numberIndexMap.put(currSum, i);
		}
		if(i==listLength) { //base case
			System.out.println("No contiguous elements that add upto given sum "+targetSum);
		}
	}
	
	public static void printList(List<Integer> inputList, int startIndex,int endIndex) {
		for(int i=startIndex;i<=endIndex;i++) {
			System.out.print(inputList.get(i)+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List<Integer> inputList1 = Arrays.asList(1,2,3,4,5);
		printContinguousSumSubarray(inputList1,6);
		List<Integer> inputList2 = Arrays.asList(1,2,3,4,5);
		printContinguousSumSubarray(inputList2,16);
		List<Integer> inputList3 = Arrays.asList(10,2,-2,-20,10); // handle negative too
		printContinguousSumSubarray(inputList3,-10);
	}

}
