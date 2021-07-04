public class Island{
public static void main(String[] args){
	//char input[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
	char input[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
	if(input == null || input.length == 0){
		return;
	}
	int count = 0;
	for(int i=0;i<input.length;i++){
		for(int j =0;j<input[i].length;j++){
			if(input[i][j] == '1'){
				count++;
				dfs(input,i,j);
			}
		}
	}
	System.out.println(count);
}
public static void dfs(char[][] input,int i,int j){
	if(i<0 || i>=input.length || j< 0 || j>=input[i].length || input[i][j] == '0'){
		return;
	}
	input[i][j] = '0';
	dfs(input,i+1,j);
	dfs(input,i-1,j);
	dfs(input,i,j+1);
	dfs(input,i,j-1);
}
}