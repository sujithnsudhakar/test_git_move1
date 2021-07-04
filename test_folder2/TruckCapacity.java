import java.util.*;
public class TruckCapacity{
	public static void main(String[] args){
		int n=2;
		int[] boxes = {2,4,3};
		int[] noOfUnits = {3,1,4};
		int maxCapacity = 4;
		System.out.println(calculateMax(n,boxes,noOfUnits,maxCapacity));
	}
	private static int calculateMax(int n,int[] boxes,int[] noOfUnits,int maxCapacity){
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<boxes.length;i++){
			int t =boxes[i];
			int unitsInCurrentBox = noOfUnits[i];
			for(int j=0;j<t;j++){
				pq.add(unitsInCurrentBox);
				if(pq.size() > maxCapacity){
					pq.remove();
				}
			}
		}
		int sum=0;
		
		while(pq.size()!=0){
			sum += pq.remove();
		}
		return sum;
	} 
	
}