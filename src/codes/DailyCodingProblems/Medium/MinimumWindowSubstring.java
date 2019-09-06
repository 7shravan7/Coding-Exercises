package codes.DailyCodingProblems.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * This problem was asked by Square.
 *
 * Given a string and a set of characters, return the shortest substring containing all the characters in the set.
 *
 * For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".
 *
 * If there is no substring containing all the characters in the set, return null.
 * 
 * 
 */
public class MinimumWindowSubstring {
	
	public static boolean isContains(String inputStr, Set<Character> charSet) {
		Set<Character> resultSet = new HashSet<>(charSet);
		inputStr.chars().filter(ch->charSet.contains((char)ch)).forEach(ch->{
			resultSet.remove((char)ch);
		});
		return resultSet.isEmpty();
	}
	
	public static void getMinimumWindowSubstring(String inputString,Set<Character> charSet) {
		int leftPtr=0;
		int rightPtr = 0;
		int stringLength = inputString.length();
		int charSetLength = charSet.size();
		int minimumLength = 0;
		int minLeftIndex = 0;
		int minRightIndex = 0;
		while(leftPtr != stringLength-1) {
			if(rightPtr+1 > stringLength) {
				break;
			}
			if(isContains(inputString.substring(leftPtr, rightPtr+1), charSet)) {
				if(minimumLength ==0 || minimumLength > (rightPtr+1 - leftPtr)) {
					minimumLength = rightPtr+1 - leftPtr;
					minLeftIndex = leftPtr;
					minRightIndex = rightPtr;
					leftPtr += 1;
				} else {
					leftPtr += 1; 
				}
			} else {
				rightPtr += 1; 
			}
		}
		if(minimumLength == 0) {
			System.out.print("No Solution");
		} else {
			for(int i=minLeftIndex;i<=minRightIndex;i++) {
				System.out.print(inputString.charAt(i));
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		getMinimumWindowSubstring("figehaeci",new HashSet<Character>(Arrays.asList('a', 'e', 'i')));
		getMinimumWindowSubstring("geeksforgeeks",new HashSet<Character>(Arrays.asList('k','o','r')));
		getMinimumWindowSubstring("geeksforgeeks",new HashSet<Character>(Arrays.asList('k','o','y')));
	}

}
