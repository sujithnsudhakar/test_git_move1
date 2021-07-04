import java.util.*;
public class SplitIntoPrime{
	public static void main(String[] args){
		List<List<Integer>> result = new ArrayList<>();
		//String str = "11373";
		String str = "3175";
		backtrack(str,new ArrayList<>(),result);
		System.out.println(result.size());
	}
	public static void backtrack(String str,List<Integer> currentList,List<List<Integer>> result){
		// We are updating string inside for loop wo get the remaining string
		// Base condition is when it gets empty
		if(str.length()==0){
			result.add(new ArrayList<>(currentList));
			System.out.println(currentList);
			return;
		}
		// Iterate from 1 as we take current from 0 inside loop
		// i <= str.length() and not < as we are taking substring at every step,str.length decreases
		// At one point it becomes 1(for the last character of string), we must include that as well
		for(int i=1;i<=str.length();i++){
			String curr = str.substring(0,i);
			int num = Integer.parseInt(curr);
			if(isPrime(num)){
				currentList.add(num);
				String s = str.substring(i);
				backtrack(s,currentList,result);
				currentList.remove(currentList.size()-1);
			}
		}
	}
	public static boolean isPrime(int num){
		if(num == 1) return false;
		for(int i=2;i<=num/2;i++){
			if(num%i==0) return false;
		}
	return true;
	}
}