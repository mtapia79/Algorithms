package cl.ibm.pruebas;

public class Array2D {

	private static final int ROW = 100;
	private static final int COLUMN = 100;
	
	public static void main(String args[]){
		
		String[][] menu = Array2D.loadMenu();
		String[][] preferences = Array2D.loadPreferences();
		Array2D.compare(menu, preferences);
	}
	
	public static String[][] loadMenu(){
		
		String[][] menu = {{"pizza","italian"},
						   {"enchilada","mexican"},
						   {"porotos","chilean"}
							};
		
		return menu;
	}
	
	public static String[][] loadPreferences(){
		
		String[][] preference = {{"Manuel","mexican"},
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
	
}
