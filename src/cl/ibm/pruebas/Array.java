package cl.ibm.pruebas;

import java.util.ArrayList;
import java.util.List;

public class Array {
	
			
	public static void main(String args[]){
		/*String text = "{Thís {- text ! has \\ /allot # of % special % characters}"; 
		text = text.replaceAll("[^a-zA-Z0-9]", ""); 
		System.out.println(text);
		Array.initAnagram();*/
	   // Array.finIndexByKey(33);
	    System.out.println("indiceBS:" + Array.binarySearch(33));

	}
	
	public static void finIndexByKey(int n) {
	    int[] lista = { 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
	    
	    for(int i=0; i< lista.length; i++){
	        if(lista[i] == n)
	            System.out.println("indice:" + i);
        }
	    
	}
	
	public static int binarySearch(int key)
	 {
	 
	    int[] a = { 6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
	    
        	 int lo = 0, hi = a.length-1;
        
        	 while (lo <= hi)
        	 {   
            	 int mid = lo + (hi - lo) / 2;

            	 if (key < a[mid]) 
            	         hi = mid - 1;
            	 else if (key > a[mid])
            	         lo = mid + 1;
            	 else 
            	     return mid;
        	 }
        	 return -1;
	 }
	
	public static void initRotate(){

		int[] lista = {3,2,4,8,6,9,7};
		int[] fin = Array.rotate(lista, 3, lista.length);
		
		for(int i=0; i< fin.length; i++){
			System.out.println(fin[i]);
		}
	}
	
	public static int[] rotate(int [] arr, int divisor, int largo){
		int [] tmp = new int[divisor + 1];
		
		for(int i = 0; i< largo; i++){
			if(i == divisor){
				tmp[i] = arr[i];
				break;
			}
			tmp[i] = arr[i];
		}
		int [] total = new int[largo];
		
		for(int j = 0; j < largo; j++){
			int pos = divisor + j;			
			if(pos == largo){
				for(int k=0; k< tmp.length; k++){
					int l = j + k; 
					if(l == largo){
						break;
					}
					total[l] = tmp[k];
				}
				return total;
			}
			total[j] = arr[pos];			
		}

		return total;
	}
	
	public static void initAnagram(){
		String dato = "AAABABAA";
		String buscar = "AABA";
		
		List<Integer> indices  = anagram(dato, buscar);
		
		for(int i = 0;i < indices.size(); i++){
			System.out.println("indices:" + indices.get(i));
		}
	
	}
	
	public static List<Integer> anagram(String hayStack, String needle){
		
		List<String> anagramas  = permutation("", needle,new ArrayList<String>());
		List<Integer> indices = geListaIndices(hayStack, anagramas);
		
		return indices;
	}
	
	public static List<Integer> geListaIndices(String hayStack, List<String> anagramas){
		
		List<Integer> indices = new ArrayList<Integer>();
				
		
		for(int i = 0;i < anagramas.size(); i++){
			String permutacion = anagramas.get(i);
			
			System.out.println(permutacion);
					
			String stack = "";

					for(int j = 0;j < hayStack.length(); j++){	
						//valida que no se salga del rango
						if((4+j) > hayStack.length()){
							break;
						}
						//obtiene string de 4 en 4
						stack = hayStack.substring(j,  (4+j)) ;

						if(stack.equals(permutacion)){					
														
							//valida elementos repetidos
							if(indices.size() == 0){
								indices.add(j);
							}else if (!indices.contains(j)){
								indices.add(j);
							}
							
						}					
					}					
				}
	
		return indices;
	}
	
	public static List<String> permutation(String prefijo , String str,List<String> lista){
		int n = str.length();		

		if(n==0){
			lista.add(prefijo);
		}else{
			//ABCD
			for(int i = 0;i < n; i++){
				permutation(prefijo+ str.charAt(i), str.substring(0,i) + str.substring(i+1,n), lista);
			}
		}

		return lista;
	}
}

