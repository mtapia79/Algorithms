package cl.ibm.pruebas;

public class Array2D {

	private static final int ROW = 100;
	private static final int COLUMN = 100;
	
	public static void main(String args[]){
		
		/*String[][] menu = Array2D.loadMenu();
		String[][] preferences = Array2D.loadPreferences();
		Array2D.compare(menu, preferences);*/
	    
	   /* int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
                 };
	    Array2D.rotateMejorado(matrix);*/
	    
	    int totalWays = Array2D.totalWays(4, 4);
	    System.out.println("total ways:" + totalWays);
	}
	
	public static String[][] loadMenu(){
		
		String[][] menu = {{"pizza","italian"},
						   {"enchilada","mexican"},
						   {"porotos","chilean"}
							};
		
		return menu;
	}
	
	public static String[][] loadPreferences(){
		
		String[][] preference = {{"Manuel","mexican"},{"Manuel","chilean"},
								 {"Juan","*"}};
		
		return preference;
	}
	
	public static String[] matrixToArray(String[][] arr){
		String[] pais = new String[arr.length];
		
		for(int i=0 ; i< arr.length; i++){
				pais[i] = arr[i][1];
		}

		return pais;
	}
	
	public static void compare(String[][] menu, String[][] preference){
		
		String[] pais = matrixToArray(menu);
		
		for(int i=0; i < preference.length; i++){
			for(int j=0; j < preference[i].length; j++){
				
				for(int k=0; k < pais.length; k++){
					
					if(pais[k] == preference[i][j])
					{					
						System.out.println(preference[i][0] + "=" + pais[k]);			
					}	
				}					
				
				if(preference[i][j] == "*"){					
					for(int k=0; k < pais.length; k++){						
						System.out.println(preference[i][0] + "=" + pais[k]);
					}
				}
			}
		}
	}
	
	
	// An Inplace function to rotate a N x N matrix
    // by 90 degrees in anti-clockwise direction
    static void rotateMejorado(int mat[][])
    {
        System.out.println("Inicial");
        printMatrix(mat);
        
        int N = mat.length;
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in 
            // current square
            for (int y = x; y < N-x-1; y++)
            {
                // store current cell in temp variable
                int temp = mat[x][y];
      
                // move values from right to top
                mat[x][y] = mat[y][N-1-x];
      
                // move values from bottom to right
                mat[y][N-1-x] = mat[N-1-x][N-1-y];
      
                // move values from left to bottom
                mat[N-1-x][N-1-y] = mat[N-1-y][x];
      
                // assign temp to left
                mat[N-1-y][x] = temp;
            }
        }
        
        System.out.println();
        System.out.println("Final");
        printMatrix(mat);
    }
	/*
	 * Input:
         1  2  3  4 
         5  6  7  8 
         9 10 11 12 
        13 14 15 16 
        
        Output:
         4  8 12 16 
         3  7 11 15 
         2  6 10 14 
         1  5  9 13
	 */
	public static void rotate(int[][] matrix) {
	    
	    System.out.println("Inicial");
	    printMatrix(matrix);
	    
	    int uno = matrix[0][0];
        int tres = matrix[(matrix.length - 1)][0];
        
	    matrix[0][0] = matrix[0][(matrix.length - 1 )];
        matrix[0][(matrix.length -1 )] = matrix[(matrix.length - 1)][(matrix.length -1 )];
        matrix[(matrix.length - 1)][0] = uno;
        matrix[(matrix.length - 1)][(matrix.length -1 )] = tres;
        
	    int idxC = 0;
	    int firstRow = 0;
	    int lastRow = matrix.length -1 ;
	    int lastColumn = matrix.length -1 ;
	    
	    //Ciclo 1
	    for(int r=1; r < matrix.length; r++){
            for(int c=r; c < matrix[r].length; c++){
               
                uno        = matrix[firstRow][c]; // avanza primera fila de izquierda a derecha
                int dos    = matrix[lastRow - r][idxC]; // avanza primera columna de abajo a arriba
                tres       = matrix[r][lastColumn]; // avanza ultima columna de arriba a abajo
                int cuatro = matrix[lastRow][lastColumn - c];// avanza ultima fila de derecha a izquierda
               
                matrix[firstRow][c]             = tres;
                matrix[lastRow - r][idxC]       = uno;
                matrix[r][lastColumn]           = cuatro;
                matrix[lastRow][lastColumn - c] = dos;
                
                break;
            }
            
            if(r == (matrix.length) / 2 ) {
                break;
            }
       
          } 
	    
	    
	    int sizeM = matrix.length/2;
	    //Ciclo2
	    for(int r=1; r < sizeM; r++){
            for(int c=r; c < sizeM; c++){
                uno        = matrix[r][c]; 
                int dos    = matrix[r][sizeM]; // avanza primera columna de abajo a arriba
                tres       = matrix[r + 1][c]; // avanza ultima columna de arriba a abajo
                int cuatro = matrix[r + 1][sizeM];// avanza ultima fila de derecha a izquierda
               
                matrix[r][c]         = dos;
                matrix[r][sizeM]     = cuatro;
                matrix[r + 1][c] = uno;
                matrix[r + 1][sizeM] = tres;
            }
	    }
	    
	    System.out.println();
	    System.out.println("Final");
	    printMatrix(matrix);
	}
	
	public static void printMatrix(int[][] matrix) {
	    for(int r=0; r < matrix.length; r++){
            for(int c=0; c < matrix[r].length; c++){
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
	}
	
	public static int totalWays(int n , int m) {
	    int T[][] = new int[n][m];
	    
	    for(int i = 0 ; i<n ; i++) {
	        T[i][0] = 1;
	    }
	    
	    for(int i = 0 ; i<m ; i++) {
            T[0][i] = 1;
        }
	    
	    for(int i=1; i<n ; i++) {
	        for(int j=1; j<m ; j++) {
	            T[i][j] = T[i-1][j] + T[i][j-1];
	        }
	    }
	    
	    return T[n-1][m-1];
	}
	
}
