package yayyy;
import java.util.*;
public class WavePrint {
	public static void waveprint(int input[][]) {
		int r=input.length;
		int c=input[0].length;
		for(int j=0;j<c;j++) {
			if(j%2 ==0) {
				for(int i=0;i<r;i++) {
					System.out.print(input[i][j]+" ");
				}
			}
			else {
				for(int k=r-1;k>=0;k--) {
					System.out.print(input[k][j]+" ");
				}
			}
		}
	}
static Scanner s = new Scanner(System.in);
	
	
	public static int[][] takeInput2D(){
		
		int numRows = s.nextInt();
		int numCols = s.nextInt();
		int[][] input = new int[numRows][numCols];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				input[i][j] = s.nextInt();
			}
		}
		return input;
	}
	
	
	public static void main(String[] args) {
	
		int input[][] = takeInput2D();
		waveprint(input);
		
	}

}
