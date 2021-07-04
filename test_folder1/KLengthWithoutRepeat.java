import java.util.*;
public class KLengthWithoutRepeat{
	public static void main(String[] args){
		List<String> result = new ArrayList<>();
		String s = "havefunonleetcode";
		int k = 5;
		findSubstrings(s,k,result);
		System.out.println(result);
	}
	private static void findSubstrings(String s,int k,List<String> result){
		int right = 0;
		int left = 0;
		int[] count = new int[26];
		while(right < s.length()){
			// implement the pre requisite conditions for shrinking if any
			count[s.charAt(right)-'a']++;

			//Shrink window
			if(right-left+1 > k){
				count[s.charAt(left)-'a']--;
				left++;
			}
			//Conditions for adding to result
			if(!repeatedFound(count) && right-left+1 == k){
				result.add(s.substring(left,right+1));
			}
			right++;
		}
	}
	/* To check if there are any repeated characters within the window
	*/
	private static boolean repeatedFound(int[] count){
		for(int i=0;i<count.length;i++){
			if(count[i] > 1) return true;
		}
		return false;
	}	
}