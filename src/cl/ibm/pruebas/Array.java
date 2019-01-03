package cl.ibm.pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class Array  {
	
    public synchronized void ma(int i ,String m) {
        System.out.println(Integer.toString(i));
        System.out.println(m);
    }
    
    public  void mb(int i ,String m) {
        synchronized(this) {
        System.out.println(Integer.toString(i));
        System.out.println(m);
        }
    }
			
	public static void main(String args[]){
	
	    PriorityQueue toDo = new PriorityQueue();
	    toDo.add("dishes");	
	    toDo.add("laundry");
	    toDo.add("bills");
	    toDo.offer("bills");
	    
	    System.out.println(toDo.size() + " " + toDo.poll());
	    System.out.println(" " + toDo.peek() + " " + toDo.poll());
	    System.out.println(" " + toDo.poll() + " " + toDo.poll());
		/*String text = "{Thís {- text ! has \\ /allot # of % special % characters}"; 
		text = text.replaceAll("[^a-zA-Z0-9]", ""); 
		System.out.println(text);
		Array.initAnagram();*/
	   // Array.finIndexByKey(33);
	   
	    /*int[] input = {9, 93, 24, 6};
	   System.out.println("indiceBS:" + Array.binarySearch(33,input));*/
	    
	    
	    /*int[] origin = {1,7,5,9,2,12,3};
	    int[] fin = Array.getArrayk2(origin);*/
	    
	    //Array.commonElements();
	   
	   /* String srt = "ABCD";
	    for (int i= 0; i < srt.length(); i++) {
	  
	        System.out.println("i:" + i + " - " + srt.substring(0, i) + ": "+ srt.substring(i + 1) );
            String rem = srt.substring(0, i) + srt.substring(i + 1);
            
            //System.out.println(rem);
	    } */
	    //Array.countPermutation("ABCD", "");
	    //Array.findPermutation();
	    
	    //Array.highestNumber();
	    

	    //int[] arr = {3, 19, 1, 14, 8, 7};
	    //Array.buildMaxHeap(arr);
	    
	   /* int[] arr = {2, 6, 3, 4, 5};
	    List<Integer> list = new ArrayList();
	    list.add(1);
	    list.add(2);
	    list.add(5);
	   // list.add(4);
	   // list.add(5);
	    Array.waitingTime(list, 1);*/
	}
	
	public static long waitingTime(List<Integer> tickets, int p) {
	    // Write your code here
	        Long count = 0L;
	        
	        int size=tickets.size();
	        boolean done= false;
	        
	       while(!done){
	            for(int j=1;j<size;j++){
	            
	                if(tickets.get(j)==0){
	                    continue;
	                }
	                if(tickets.get(p+1)==0){
	                    done=true;
	                    break;
	                }
	                tickets.set(j,tickets.get(j)-1);
	                count++;
	            }
	       }


	        System.out.println("count:" + count);
	        return count;
	    }
	
	
	
	/**Given an array, arrange the elements such that the number formed by concatenating the elements is highest.
	E.g.: input = [9, 93, 24, 6], 
	the output should be: [9,93,6,24].
	 This is because if you concatenate all the numbers, 
	993624 is the highest number that can be formed.
	*/
	
	public static void highestNumber() {
	    int[] input = {9, 93, 24, 6};
	    
	    String[] elementos = new String[input.length];
	    
	    for(int i=0; i<input.length;i++){
	        elementos[i] = input[i] + "";
	    }
	   
        int n = 4;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos

        Hashtable ht = new Hashtable();
        
        ht= Perm2(elementos, "", n, r , ht);
        
        int max = 0;
        String[] listaFinal = {};
        
        Enumeration num = ht.elements();
        
        while(num.hasMoreElements()) {
       
           String str = (String)num.nextElement();
           
           String[] lista = str.split(",");
           String sum = "";
           
           for (int j=0;j<lista.length;j++) {
                   sum = sum + lista[j].trim(); 
           }
               
           int s = Integer.parseInt(sum.trim());
           if(s > max){
               max = s;
               listaFinal = lista;
           }
        }

        System.out.println("lista:[" + listaFinal[0] + "," + listaFinal[1] + "," + listaFinal[2] + "," + listaFinal[3] +"]");
        
	    
	}

	
	private static Hashtable Perm2(String[] elem, String act, int n, int r,Hashtable ht) {
        if (n == 0) {
            ht.put(act, act);
            
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ", ", n - 1, r, ht);
                }
            }
        }
        return ht;
    }
	
	 
	
	/**
	 * s: abbc
        b: cbabadcbbabbcbabaabccbabc
        Where are the permutations of s within b?
	 */
	
	public static void findPermutation() {
	    String lista = "cbabadcbbabbcbabaabccbabc";
	    Hashtable ht = new Hashtable();
	    
	    ht = Array.countPermutation("abbc", "" ,ht);
	    
	    String prefix = "";
	    
	    for(int i=0; i<lista.length();i++) {
	     
	        if(i >= (lista.length() - 3))
	            break;
	        
	        String valor = prefix + lista.charAt(i)  + lista.charAt(i +1) + lista.charAt(i +2) + lista.charAt(i +3);
	       
	        if(ht.containsKey(valor))
	            System.out.println(ht.get(valor));
	        
	    }
	}
	
	public static Hashtable countPermutation(String str, String prefix , Hashtable ht) {
	 
	     if (str.length() == 0) {
	         ht.put(prefix, prefix);
	        // System.out.println(prefix);
         } else {
             for (int i= 0; i < str.length(); i++) {
                 String rem = str.substring(0, i) + str.substring(i + 1);
                 countPermutation(rem, prefix + str.charAt(i), ht);
             }
         }
	     
	     return ht;
     } 

	/**
	 * Question: Given two sorted arrays, find the number of elements in common. The arrays are the same length
and each has all distinct elements.
Let's start with a good example. We'll underline the elements in common.
A: 13 27 35 40 49 55 59
B: 17 35 39 40 55 58 60
	 */
	
	public static void commonElements(){
	    int[] a = {13, 27, 35, 40, 49, 55, 59};
	    int[] b = {17, 35, 39, 40, 55, 58, 60};
	    
	    Hashtable ht = new Hashtable();
	    
	    for(int i = 0 ; i< a.length; i++) {
	        ht.put(a[i], a[i]);
	       
	    }
	    System.out.println("a:" + ht);
	    
	    for(int j = 0 ; j< b.length; j++) {
	        
            if(ht.containsKey(b[j]))
                System.out.println(b[j]);
        }
	    
	}
	
	/**
	 * Example: Given an array of distinct integer values, count the number of pairs of integers that
        have difference k. For example, given the array { 1, 7, 5, 9, 2, 12, 3} and the difference
        k = 2,there are four pairs with difference2: (1, 3), (3, 5), (5, 7), (7, 9). 
	 * @param origin
	 * @return
	 */
   public static int[] getArrayk2(int[] origin) {
       
       /*Array.recQuickSort(0, origin.length-1, origin);
       
       for(int j=0; j<origin.length; j++)
       {
          //System.out.print(origin[j] + ",");
             
           int key = origin[j] + 2;
           int next = binarySearch(key,origin);
           
           if(next != -1)
               System.out.print("(" + origin[j] + "," + origin[next] + ")");
           
       }*/
       
        int[] l = new int [100];
        Hashtable ht = new Hashtable();
         int k = 2;
         
         for(int i =0; i< origin.length; i++) {
             ht.put(origin[i],origin[i]);
         }
         
         for(int i =0; i< origin.length; i++) {
             int key = origin[i] + 2;
           
             if(ht.containsKey(key))
                 System.out.print("(" + origin[i] + "," + ht.get(key) + ")");
         }
         
        
        return l; 
    }
   
   public static void recQuickSort(int left, int right, int[] theArray) {
       if(right-left <=0)
           return;
       else {
           long pivot = theArray[right];
           int partition = partitionIt(left, right , pivot,theArray);
           recQuickSort(left,partition-1,theArray);
           recQuickSort(partition+1,right,theArray);
       }
   }
   
   public static int partitionIt(int left, int right, long pivot, int[] theArray) {
       int leftPtr = left-1; // left (after ++)
       int rightPtr = right; // right-1 (after --)
       
       while(true) {
           
           while( theArray[++leftPtr] < pivot) // find bigger item
                   ; // (nop)
           
           while(rightPtr > 0 && theArray[--rightPtr] > pivot) // find smaller item
               ; // (nop)

           if(leftPtr >= rightPtr) // if pointers cross,
               break;               // partition done
           else                     // not crossed, so
               swap(leftPtr, rightPtr,theArray); // swap elements    
        }// end while(true)
           
       swap(leftPtr, right,theArray); // restore pivot
       return leftPtr;      // return pivot location
   }
   
   public static void swap(int dex1, int dex2,int[] theArray) // swap two elements 
   {
       int temp = theArray[dex1]; // A into temp
       theArray[dex1] = theArray[dex2];  // B into A
       theArray[dex2] = temp; // temp into B
   } 
   
   
   
	public static void finIndexByKey(int n) {
	    int[] lista = { 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
	    
	    for(int i=0; i< lista.length; i++){
	        if(lista[i] == n)
	            System.out.println("indice:" + i);
        }
	    
	}
	
	public static int binarySearch(int key , int[] b)
	 {
	 
	    int[] a = { 6, 13, 14, 25, 33,24, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
	    
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
	
	/*
	 Unsorted array
	 [3, 19, 1, 14, 8, 7]

	 Heapified Array
	 [19, 14, 7, 8, 3, 1]
	 */
	public static int[] buildMaxHeap(int[] arr) {
	    
	    //paso 1: transformar arreglo en un heap, mediante binary tree
	    for(int i = arr.length/2-1 ; i>=0 ; i--) {
	        maxHeapify(arr, i , arr.length - 1);
	    }
	    
	    System.out.print("[");
	    for(int i =0 ; i<arr.length ;  i++) {
            System.out.print(arr[i] + ",");
        }
	    System.out.print("]");
	    //paso 2: transformar bynary tree a max heap
	    
	    return arr;
	}
	
	public static int[] maxHeapify(int[] arr, int padre , int sizeArray) {
	    
	    int posHijoIzq = (2*padre) + 1;
	    int posHijoDer = (2*padre) + 2;
	    int largest;

	    if(posHijoIzq <= sizeArray && arr[posHijoIzq] > arr[padre]) 
	         largest = posHijoIzq;
	    else 
	         largest = padre;
	    
	    
	    if(posHijoDer <= sizeArray && arr[posHijoDer] > arr[largest]){
	        largest = posHijoDer;
        }
	    
	    if(largest != padre) {
	        int tmp = arr[padre];
	        arr[padre] =arr[largest]; 
	        arr[largest] = tmp;
	        maxHeapify(arr, largest, sizeArray);
	    }
	        
	    return arr;
	}
	
	 public static List<String> findSchedules(int workHours, int dayHours, String pattern){
         int totalHours = 0;
         List<String> result = new ArrayList<String>();
         
         for(char c : pattern.toCharArray()){
             if( c != '?')
                 totalHours = totalHours + Character.getNumericValue(c);
         }

         int diff = workHours - totalHours;
         constructResult(pattern.toCharArray(), 0, diff, dayHours, result);
         return result;
 }

     public static List<String> constructResult(char[] patternArr, int index, int diff, int dayHours, List<String> result){
         if (index == patternArr.length) {
             if (diff == 0)
                 result.add(String.copyValueOf(patternArr));
             return result;
         }

         if (patternArr[index] == '?') {
             
             for (int i = 0; i < dayHours+1 ; i++) 
             {
                         char c = patternArr[index];
                         patternArr[index] =  Integer.toString(i).charAt(0);;
                         constructResult(patternArr, index+1, diff-i, dayHours, result);
                         patternArr[index] = c;
             }
            
         }else {
             constructResult(patternArr, index+1, diff, dayHours, result);
         }
         
         return result;
     } 
	
	
	/*public static List<String> perm(char c , List<String> lista){
	    String str = "ABCD";
	    String temp = "";
	    String[] arr = new String[1000];
	    
	    for(int i=0; i< str.length(); i++) {
	        char current = str.charAt(i);
	        temp = temp + current;
	        
	        if(i==0)
	            break;
	        
	        
	        
	        for(int j=0; j<temp.length(); j++) {
	     
	            if(temp.length()==1) {
	                arr[i] = current + temp;
	                arr[i+1] = temp + current;
	                
	            }else{
	                arr[i]=
	            }

	        }
	        
	      
	        
	        
	        
	        
	        
	        if(temp.length() == str.length())
	            System.out.println(temp);
	        
	        
	    }
	    
	}*/
}

