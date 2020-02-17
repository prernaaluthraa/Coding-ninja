package yayyy;

import java.util.Scanner;

public class SpiralPrint {
	public static void spiralPrint(int matrix[][]){
	  
    int startRow = 0;
    int endRow = matrix.length;
    int startCol = 0;
    int endCol = matrix[0].length;
    int i;
    
    while( startRow < endRow && startCol < endCol)
    {
        for(i = startCol ; i < endCol ; i++)
        {
            System.out.print(matrix[startRow][i]+" ");
        }
        startRow++;
        
        for(i = startRow; i < endRow; i++)
        {
            System.out.print(matrix[i][endCol]+" ");
        }
        endCol--;
        
        if(startRow < endRow)
        {
            for(i = endCol - 1; i >= startCol ;i--)
            {
                System.out.print(matrix[endRow - 1][i]+" ");
            }
            endRow--;
        }
        if( startCol < endCol)
        {
            for(i = endRow - 1; i >= startRow; i--)
            {
                System.out.print(matrix[i][startCol]+" ");
            }
            startCol++;
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
		int a[][] = takeInput2D();
		spiralPrint(a);
	}

}
