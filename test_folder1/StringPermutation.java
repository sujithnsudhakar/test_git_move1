import java.util.*;
public class StringPermutation{
public static void main(String[] args){
	String input = "abcd";
	List<String> output = new ArrayList<>();
	permuteString(input.toCharArray(),0,"",output);
	System.out.println(output);
}
public static void permuteString(char[] input,int index,String current,List<String> output){
	if(input.length == index){
		output.add(current);
		return;
	}
	
	for(int i=index;i<input.length;i++){
		swap(input,i,index);
		permuteString(input,index+1,new String(input),output);
		swap(input,index,i);
	}
}
public static void swap(char[] input,int a,int b){
	char t = input[a];
	input[a] = input[b];
	input[b] = t;
}
}