import java.util.*;
public class SubstringKDistinct{
public static void main(String[] args){
	String s = "democracy";
	String s2 = "wawaglknagagwunagkwkwagl";
	int n = 5;
	List<String> result = new ArrayList<>();
	//solve(s,n,result);
	//optimalSolution(s,n,result);
	//System.out.println(result);
	optimalSolution(s2,4,result);
	System.out.println(result);
}
private static void solve(String word, int k,List<String> result){
	int i = 0;
	List<Character> list = new ArrayList<>();
	//length-k because i should iterate till only c in democracy
	while(i <= word.length()-k){
		// To keep track of number of repeating characters
		int count = 0;
		list.clear();
		for(int j=i;j<i+k;j++){
			if(!list.contains(word.charAt(j))){
				list.add(word.charAt(j)); 
			}
			else{
				count++;
			}
		}
		if(count == 1){
			result.add(word.substring(i,i+k));
		}
		i++;
	}	
}
public static void optimalSolution(String word,int k,List<String> result){
	int left=0,right=0;
	Map<Character,Integer> map = new HashMap<>();
	while(right < word.length()){
		if(right-left==k){ //when the char reaches more than k, get that from map and decrement its count by 1
			char c = word.charAt(left++);
			map.put(c,map.get(c)-1);
			//Say if count is 0, remove from map as we have to comapre the number of entries to add into result
			if(map.get(c) == 0) map.remove(c);	
		}
		map.put(word.charAt(right),map.getOrDefault(word.charAt(right),0)+1); // adds o,c,r,a,c
		if(map.keySet().size() == k-1 && right-left+1 == k){
			result.add(word.substring(left,right+1));
		}
		right++;
	}
}
}