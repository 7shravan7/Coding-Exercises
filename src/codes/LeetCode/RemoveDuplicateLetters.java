package codes.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * Given a string which contains only lower case letters, remove duplicate letters so that every letter appears 
 * once and only once. You must make sure your result is the smallest in lexicographical order among all possible 
 * results.
 * 
 * Input: "bcabc"
 * Output: "abc"
 * 
 * Input: "cbacdcbc"
 * Output: "acdb"
 * 
 * Time : O(n)
 * Space: O(1)
 * 
 * 26.08.19
 */
public class RemoveDuplicateLetters {
	
	public static String removeDuplicateLetters(String inputString) {
		Stack<Character> resultStack = new Stack<>();
		Map<Character,Integer> lastSeenIndexMap = new HashMap<>();
		Set<Character> seenSet = new HashSet<>();
		int stringLength = inputString.length();
		for(int i=0;i<stringLength;i++) {
			lastSeenIndexMap.put(inputString.charAt(i), i);
		}
		for(int i=0;i<stringLength;i++) {
			char currChar = inputString.charAt(i);
			if(!seenSet.contains(currChar)) {
				while(!resultStack.isEmpty() && currChar<resultStack.peek() 
						&& lastSeenIndexMap.get(resultStack.peek())>i) {
					seenSet.remove(resultStack.pop());
				}
				resultStack.push(currChar);
				seenSet.add(currChar);
			}
		}
		StringBuilder sb = new StringBuilder();
		resultStack.stream().forEach(ch->sb.append(ch));
		return sb.toString();
	}

	public static void main(String[] args) {
		String str1 = "bcabc";
		System.out.println(removeDuplicateLetters(str1));
		String str2 = "cbacdcbc";
		System.out.println(removeDuplicateLetters(str2));
	}

}
