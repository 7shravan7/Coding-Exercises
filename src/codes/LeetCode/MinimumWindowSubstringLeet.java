package codes.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;
/*
 *https://leetcode.com/problems/minimum-window-substring/submissions/
 * 
 *Given a string S and a string T, find the minimum window in S which will contain all the characters in T 
 * in complexity O(n).
 *
 *Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *Note:
 *  If there is no such window in S that covers all characters in T, return the empty string "".
 *  If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 */

class MinimumWindowSubstringLeet {
	// using sliding window technique
	// Leetcode Time:57ms	Memory:38.3 MB
    public String minWindow(String s, String t) {
    	// base condition if s or t is empty, should return empty string
    	if(s.isEmpty() || t.isEmpty()) {
    		return "";
    	}
    	Map<Character,Integer> patternCountMap = new HashMap<>();
    	t.chars().forEach(ch->{
    		Character charVal = (char) ch;
    		int count = patternCountMap.getOrDefault(charVal, 0);
    		patternCountMap.put(charVal,count+1);
    	});
    	int left=0;
    	int right=0;
    	int minWindowLength = -1;
    	int minLeftIndex = 0;
    	int minRightIndex = 0;
    	int stringLength = s.length();
    	Map<Character,Integer> windowCountMap = new HashMap<>();
    	int matched = patternCountMap.size(); // unique characters in pattern string 
    	int found = 0;
    	while(right<stringLength) {
    		Character charVal = s.charAt(right);
    		windowCountMap.put(charVal, windowCountMap.getOrDefault(charVal, 0)+1);
    		if(patternCountMap.containsKey(charVal) && // here .intValue() is used because primitive int 
    												   // works compare till -127 to 127 
    												   // https://stackoverflow.com/questions/3130311/weird-integer-boxing-in-java
    				patternCountMap.get(charVal).intValue() == windowCountMap.get(charVal).intValue()) {
    			found++;
    		}
    		while(left<stringLength && matched == found) {
    			if(minWindowLength == -1 || minWindowLength > (right-left+1)) {
    				minWindowLength = right-left+1;
    				minLeftIndex = left;
    				minRightIndex = right;
    			}
    			Character leftChar = s.charAt(left);
    			windowCountMap.put(leftChar, windowCountMap.get(leftChar)-1);
    			if(patternCountMap.containsKey(leftChar) && 
    					patternCountMap.get(leftChar).intValue() > windowCountMap.get(leftChar).intValue()) {
    				found--;
    			}
    			left++;
    		}
    		right++;
    	}
        return minWindowLength == -1 ? "" : s.substring(minLeftIndex, minRightIndex+1);
    }
    
	// When t has much smaller size than s, we need only t characters in s to compare so we build list of that
    //                                                           index and characters in a pair
    // Approach 2 in https://leetcode.com/articles/minimum-window-substring/ 
    // Leetcode Time:57ms	Memory:43.1 MB
    public String minWindowOptimized(String s, String t) {
    	if(s.isEmpty() || t.isEmpty()) {
    		return "";
    	}
    	Map<Character,Integer> patternCountMap = new HashMap<>();
    	t.chars().forEach(ch->{
    		Character charVal = (char) ch;
    		int count = patternCountMap.getOrDefault(charVal, 0);
    		patternCountMap.put(charVal,count+1);
    	});
    	int left=0;
    	int right=0;
    	int minWindowLength = -1;
    	int minLeftIndex = 0;
    	int minRightIndex = 0;
    	int stringLength = s.length();
    	Map<Character,Integer> windowCountMap = new HashMap<>();
    	int matched = patternCountMap.size(); // unique characters in pattern string 
    	int found = 0;
    	List<Pair<Integer, Character>> indexCharacterFilteredList = new ArrayList<>();
    	for(int i=0;i<stringLength;i++) {
    		if(patternCountMap.containsKey(s.charAt(i))) {
    			indexCharacterFilteredList.add(new Pair<Integer, Character>(i, s.charAt(i)));
    		}
    	}
    	int filteredLength = indexCharacterFilteredList.size();
    	while(right<filteredLength) {
    		Character rightChar = indexCharacterFilteredList.get(right).getValue();
    		windowCountMap.put(rightChar, windowCountMap.getOrDefault(rightChar, 0)+1);
    		if(patternCountMap.get(rightChar).intValue() == windowCountMap.get(rightChar).intValue()) {
    			found++;
    		}
    		while(left<=right && found==matched) {
    			Character leftChar = indexCharacterFilteredList.get(left).getValue();
    			int start = indexCharacterFilteredList.get(left).getKey();
    			int end = indexCharacterFilteredList.get(right).getKey();
    			if(minWindowLength == -1 || (minWindowLength >(end-start+1))) {
    				minWindowLength = end-start+1;
    				minLeftIndex = start;
    				minRightIndex = end;
    			}
    			windowCountMap.put(leftChar, windowCountMap.get(leftChar)-1);
    			if(patternCountMap.get(leftChar).intValue() > windowCountMap.get(leftChar).intValue()) {
        			found--;
        		}
    			left++;
    		}
    		right++;
    	}
    	return minWindowLength == -1 ? "" : s.substring(minLeftIndex, minRightIndex+1);
    }
	public static void main(String[] args) {
		MinimumWindowSubstringLeet	m = new MinimumWindowSubstringLeet();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(m.minWindowOptimized("ADOBECODEBANC", "CF"));
	}
}
