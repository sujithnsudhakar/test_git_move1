import java.util.*;
public class ZombiMatrix{
public static void main(String[] args){
	int[][] matrix = {{0,1,1,0,1},{0,1,0,1,0},{0,0,0,0,1},{0,1,0,0,0}};
	Set<String> zombieSet = new HashSet<>();
	Set<String> humanSet = new HashSet<>();
	int count = 0;
	for(int i=0;i<matrix.length;i++){
		for(int j=0;j<matrix[i].length;j++){
			// for all zombies,add the indices into zombie set
			if(matrix[i][j] == 1){
				zombieSet.add(""+i+j);
			}
			else{
				humanSet.add(""+i+j);
			}
		}
	}
	int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
	while(humanSet.size()>0){
		Set<String> infectedSet = new HashSet<>();
		for(String zombieIndex:zombieSet){
			int zombieX = zombieIndex.charAt(0)-'0';
			int zombieY = zombieIndex.charAt(1)-'0';
			
			for(int[] direction:directions){
				int neighbourX = direction[0]+zombieX;
				int neighbourY = direction[1]+zombieY;
				
				String neighbour = ""+neighbourX+neighbourY;
				if(humanSet.contains(neighbour)){
					infectedSet.add(neighbour);
					humanSet.remove(neighbour);
				}
			}		
		}
		if(infectedSet.size()==0) break;
		zombieSet = infectedSet;
		count++;
	}
	System.out.println(count);
}
}