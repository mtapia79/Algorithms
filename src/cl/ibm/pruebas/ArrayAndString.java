package cl.ibm.pruebas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.time.format.DateTimeFormatter;



public class ArrayAndString implements Serializable {

    public static boolean binarySearch(int key , int[] a)
    {
            int left = 0; 
            int rigth = a.length-1;
 
            while (left <= rigth)
            {   
                 int mid = left  + ((rigth - left) / 2) ; 
                if (a[mid] == key ) {
                     return true;
                }else if (key < a[mid]) {
                    rigth = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return false;
    }
    
    public static List<String> reformatDate(List<String> dates) {
        List<String> lista = new ArrayList<String>();
        Map<String,String> mesesHM = new HashMap<String,String>();
       // String[] meses = {"Jan","Feb","Mar" ,"Apr" ,"May" , "Jun" ,"Jul" ,"Aug" ,"Sep" ,"Oct" ,"Nov" ,"Dec" };
        
        mesesHM.put("Jan", "01");
        mesesHM.put("Feb", "02");
        mesesHM.put("Mar", "03");
        mesesHM.put("Apr", "04");
        mesesHM.put("May", "05");
        mesesHM.put("Jun", "06");
        mesesHM.put("Jul", "07");
        mesesHM.put("Aug", "08");
        mesesHM.put("Sep", "09");
        mesesHM.put("Oct", "10");
        mesesHM.put("Nov", "11");
        mesesHM.put("Dec", "12");
        
        for(String date : dates) {
           
            String[] l = date.split(" ");
            String dia = l[0];
            String mes = l[1];
            String ano = l[2];
            
            String d = "";
            
            for(char c : dia.toCharArray()) {
               
                if(dia.length() == 3) {
                    if(Character.isDigit(c)) {
                        d = "0" + Character.toString(c); 
                        break;
                    }
                }else {
                    if(Character.isDigit(c)) {
                        d = d + Character.toString(c);
                    }
                }
            }
            
            String fecha = ano.concat("-").concat(mesesHM.get(mes)).concat("-").concat(d);
            lista.add(fecha);
            
        }
     
        return lista;
    }
    
    public static void main(String args[]){
        
        List<String> lista = new ArrayList<String>();
        lista.add("1st Mar 1984");
        lista.add("30th Apr 1979");
        List<String> listaFechas =  ArrayAndString.reformatDate(lista);
        
        for(String s : listaFechas) {
            System.out.println(s);
        }
        
        
        //ArrayAndString.subStringKdist("awaglknagawunagwkwagl" , 4);
        
       // int[] a = {5,6,3,1,2,4};
        //int[] a = {};
        //int distancia = ArrayAndString.bstDistance(a , a.length, 2 ,4);
        //int[] a = {9,7,5,3,1};
        //int distancia = ArrayAndString.bstDistance(a , a.length, 7 ,20);
       // System.out.println(distancia);
        
         /*  int[] a = { 6, 13, 14, 25, 33, 43, 51, 53, 64, 72, 84, 93, 95, 96, 97};
          System.out.println(ArrayAndString.binarySearch(33,a));*/
      
          
          // boolean b = ArrayAndString.isUnique("zsdfghjklqwertuz");
       //System.out.println(b);
        
       // boolean b = ArrayAndString.checkPermutation("acdb" , "abcd");
       // System.out.println(b);
        
       // String salida =ArrayAndString.replaceSpace("Mr John Smith ", 13);
       // System.out.println(salida);
        
        //ArrayAndString.oddNumbers(3, 9);
        
       /* List<String> wordsToExclude = new ArrayList<String>();
        wordsToExclude.add("soy");
        wordsToExclude.add("de");

        
        List<String> lista = ArrayAndString.retrieveMostFrequentlyUsedWords("Welcome to the world of Geeks \n" + 
                "This portal has been created to provide well written well thought and well explained \n" + 
                "solutions for selected questions If you like Geeks for Geeks and would like to contribute \n" + 
                "here is your chance You can write article and mail your article to contribute at \n" + 
                "geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help \n" + 
                "thousands of other Geeks" , wordsToExclude);
     
        for(String l : lista) {
            System.out.println("final:" + l);
        }*/
        
        
       /*List<String> list = new ArrayList<String>();
        list.add("[a1 9 2 3 1]");
        list.add("[g1 Act car]");
        list.add("[zo4 4 7]");
        list.add("[ab1 off KEY dog]");
        list.add("[a8 act zoo]");
        
        List<String> lista = ArrayAndString.logProcessor(list);
        
        for(String l : lista) {
            System.out.println(l);
        }*/
        
        //System.out.println(ArrayAndString.IsCasiPalindromo("anas"));
       // int[] arr2 = new int{1,2,2,3} ;
       // int[] origin = {22,101,102,101,102};
      //System.out.println(ArrayAndString.NumMasPopular(origin , 5));
        
        //System.out.println(ArrayAndString.isBalancedBrackets("{[()]}"));
        
    }
    
    /**
     * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
        cannot use additional data structures?
        Hints: #44, #7 7 7, #732 
        
        nota: tiene un bug con la ñ porque es un caracter unicode
     */
    
    public static boolean isUnique(String str) {
      /** my version **/
      /*  Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if(!ht.containsKey(c)) {
                ht.put(c, 0);
            } else {
                ht.put(c, ht.get(c) + 1);
                return false;
            }
        }
       return true; */
       
       /** book version 1**/
       
       /* boolean[] b = new boolean[128];
        
        for(int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
      
            if(b[val]) { 
                return false;
            }
            
            b[val] = true;
        }
        
        return true;*/
        
        
        /** book version 2, We can reduce our space usage by a factor of eight by using a bit vector. We will assume, in the below code,
that the string only uses the lowercase letters a through z. This will allow us to use just a single int
     << val = toma la representacion binaria del la variable val
**/
        int checker= 0;
        
        for (int i= 0; i < str.length(); i++) {
             int val= str.charAt(i) - 'a';

             if ((checker & (1 << val)) > 0) {
                 return false;
             }
      
             checker |= (1 << val);
         }
         return true;
        
    } 
    
    
    
    /**
    1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    other. ABCD
    Hints: #7, #84, #722, #737 */
    
    public static boolean checkPermutation(String str1, String str2){
        
        
        /*solution 1
        if (str1.length() != str2.length()) {
            return false;
         } 
        
        if(sort(str1).equals(sort(str2))) {
            return true;
        }
        
            return false;
        */
        
        //solution 2
        return permutation(str1, str2);
    
        
    }
    
    public static String sort(String str) {
        
        /*Solution #1: Sort the strings.
        If two strings are permutations, then we know they have the same characters, but in different orders. Therefore,
        sorting the strings will put the characters from two permutations in the same order. We just need to
        compare the sorted versions of the strings. */
        
        char[] c = str.toCharArray();
        java.util.Arrays.sort(c);
        
        return new String(c);
    }
    
    public static boolean permutation(String s, String t){
        /*Solution #2: Check if the two strings have identical character counts.
        We can also use the definition of a permutation-two words with the same character counts-to implement
        this algorithm. We simply iterate through this code, counting how many times each character appears.
        Then, afterwards, we compare the two arrays. */
        
        if (s.length() != t.length()) {
             return false;
        }
        
        int[] letters = new int[128];//  Assumption
        char[] s_array = s.toCharArray();
       
        for (char c : s_array) { // count number of each char in s.
           letters[c]++ ;
        }
       
        for (int i= 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        
       return true; 
        
    }
    
    
    /**
     * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
        has sufficient space at the end to hold the additional characters, and that you are given the "true"
        length of the string. (Note: if implementing in Java, please use a character array so that you can
        perform this operation in place.)
        EXAMPLE
        Input: "Mr John Smith ", 13
        Output: "Mr%20John%20Smith" 
     * */
    public static String replaceSpace(String in , int size) {
       
        //my solution
        /*char[] lista = in.toCharArray();
        
        String str = "";
        
        for(int i=0 ; i< lista.length; i++) {
            char c = lista[i];
            
            if(c==' ' && str.length()<=size) {
                str=str+"%20";
            }else {
                str=str+c;
            }
        }
        return str;*/
        
        // version oficial
        char[] str = in.toCharArray();
        int spaceCount = 0, index, i = 0;
        
        for (i = 0; i < size; i++) {
             if (str[i] == ' ') {
                 spaceCount++;
             }
         }
        
        System.out.println("spaceCount:" + spaceCount);
        index = size + spaceCount * 2;
        System.out.println("index:" + index);
        System.out.println("size:" + size);
        System.out.println("str.length:" + str.length);
        if (size < str.length) 
            str[size] = '\0'; // End array 
        
        System.out.println("a:" + str[size]);
        
        for (i = size - 1; i >= 0; i-- ) {
            System.out.println("str[" + i +"]:" + str[i]);
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
             } else {
                 str[index - 1] = str[i];
                 index--;
             } 
        }
        
        return str.toString();
    }
    
    
    static int[] oddNumbers(int r, int l) {
        /*
         * Write your code here.
         */
      
        int[] salida = new int[(l-r)-1];
        int i=0;
        
        int tot = l;
       
        while(tot >= r){
          
            if(tot%2 != 0) {
                salida[i++] = tot;
            }
            tot--;
            
        }
        
        for(int j=0; j< salida.length; j++) {
            System.out.println(salida[j]);
        }
        return salida;

    }
    
    
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
   public static List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
                                                 List<String> wordsToExclude)
    {
        List<String> l = new ArrayList<String>();
        // WRITE YOUR CODE HERE
        String str = literatureText.replace('.' ,' '); 
        str = str.replace("'" ," "); 
        
        String[] lista = str.split(" ");
        
        Hashtable<String,Integer> ht = new  Hashtable<String,Integer>();
        
        for(int i=0; i< lista.length; i++){
            String word = lista[i];
            word = word.toLowerCase();

            if(word.length() > 0) {
                Integer count = ht.get(word);
               
                if(count == null) {
                    count = 0;
                }
                ht.put(word, count + 1);
            }
        }
   
             for(int i=0; i< wordsToExclude.size(); i++){
            
                 String word = wordsToExclude.get(i);
                
                    if(ht.get(word) != null){
                        ht.remove(word);
                    }
             }    
        
             
       Enumeration<String> num =  ht.keys();
       
       while(num.hasMoreElements()){
            String str3 = num.nextElement();
               
                if( ht.get(str3) > 2){
                    l.add(str3);
                }   
             
         }    
         
        
        return l;
    }
   
   /**
    * 
    * 1. discrimina numericos de letras insertandolos en listas separadas
    * 2. se ordenan las letras
    * 3. recorre lista ordenada invirtiendo la key primero y luego el resto de los datos insertandolo en una nueva lista
    * 4. se apendiza numeros a la lista anterior
    * lasIndexOf obtiene el texto hasta la ultima ocurrencia de un caracter especifico.
    * addAll apendisa un arreglo a a otro existente
    */
   public static List<String> logProcessor(List<String> list){
       List<String> strAlp = new ArrayList<String>();
       List<String> strNum = new ArrayList<String>();
       List<String> AlpNum = new ArrayList<String>();

       for( String sl :  list){
           String[] slPart = sl.split(" ", 2);
           if(Character.isDigit(slPart[1].charAt(0))){
               strNum.add(sl);
           }
           else {
               strAlp.add(slPart[1].concat(" " + slPart[0]));
           }
       }
       Collections.sort(strAlp);
       for(String sl2 : strAlp){
           String[] part = {sl2.substring(0,sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
           AlpNum.add(part[1].concat(" " + part[0]));
       }
       AlpNum.addAll(strNum);
       return AlpNum;
   }
   
   /**
    Example: 
        Input: 
        logFileSize = 5 
        logLines = 
        [al 9 2 3 1] 
        [g1 Act car] 
        [zo4 4 7] 
        [abl off KEY dog] 
        [a8 act zoo] 
        
        Output: 
        [gl Act car] 
        [a8 act zoo] 
        [ab1 off KEY dog] 
        [al 9 2 3 1] 
        [zo4 4 7] 
    */
   public static List<String> orderList(int total , List<String> lista){
       List<String> resultado = new ArrayList<String>();
       
       boolean isString = false;
       String anterior = "";
       
       for(int i=0 ; i< total ; i++) {
          
           String item = lista.get(i);
           item = item.replace("[", "");
           item = item.replace("]", "");
           
           String[] listaItem = item.split(" ");
               
               for(String c : listaItem) {
                   if(c.length() == 1 ) {
                       isString = true;
                       break;
                   }
               } 
                       
               if(isString == false){
 
                   String tmp = "";
                   if(item.length() > anterior.length()){
                       tmp = anterior;
                       anterior = item;
                       resultado.add("[" + anterior + "]"); 
                   } else {
                  
                       tmp = anterior;
                       resultado.remove("[" +tmp+ "]");
                       
                       resultado.add("[" +item+ "]");
                       resultado.add("[" +tmp+ "]");
                   }
               }
               
               isString = false;
       }
       
       for(int i=0 ; i< total ; i++) {
           
           String item = lista.get(i);
           item = item.replace("[", "");
           item = item.replace("]", "");
           
           String[] listaItem = item.split(" ");
               
              for(String c : listaItem) {
                   
                   if(c.length() == 1 ) {
                       resultado.add("[" +item+ "]");
                       break;
                   }
               }
       }
       
       return resultado;
   }
   
   
   public static boolean IsCasiPalindromo(String palabra){
       
       char[] word = palabra.toCharArray();
       int i1 = 0;
       int i2 = word.length - 1;
       while (i2 > i1) {
           if (word[i1] != word[i2]) {
               return false;
           }
           ++i1;
           --i2;
       }
       return true;
   }
   
  
   
   public static int NumMasPopular(int[] a , int largo )
   {
     int count = 1, tempCount;
     int popular = a[0];
     int temp = 0;
     for (int i = 0; i < (largo - 1); i++)
     {
       temp = a[i];
       tempCount = 0;
       for (int j = 1; j < largo; j++)
       {
         if (temp == a[j])
           tempCount++;
       }
       if (tempCount > count)
       {
         popular = temp;
         count = tempCount;
       }
     }
     return popular;
   }
   
   
   public static boolean isBalancedBrackets(String str) {
 
       Stack<Character> st = new Stack<Character>();
       
       for(int i=0; i<str.length(); i++) {
          char a= str.charAt(i);
          if(a=='{' || a=='[' || a=='(') {
              st.push(a);
          }else {
              char b = st.pop();
              if(b=='{' && a !='}') {
                  return false;
              }
              
            if(b=='[' && a !=']') {
                return false;
            }
            
            if(b=='(' && a !=')') {
                return false;
            }
              
          }
          
       }
       
       if(st.isEmpty()) {
           return true;
       }else {
           return false;
       }

   }
   
   /*
      values=[5,6,3,1,2,4] , n=6 , node1=2 , node2=4 , output=3
       5
      / \
      3  6
     / \
    1   4
     \
      2
  */
  public static int bstDistance(int[] values , int n, int node1, int node2) {
       int distancia = -1;
       
       if(values.length <= 0){
           return distancia;
       }
       
       NodoArbol arbol = createBST(values);
       
       NodoArbol padreComun = lca(arbol, node1, node2);
       
       // Lie in opposite directions (Root is
       // LCA of two nodes)
       if (padreComun.getDato() >= node1 && padreComun.getDato() <= node2)
           distancia =  distanceFromRoot(padreComun, node1) + distanceFromRoot(padreComun, node2);
       
       return distancia;
   }
  
  public static int distanceFromRoot(NodoArbol root, int x)
  {
      
      if (root == null)
          return -3;
  
      
      if (root.getDato() == x)
          return 0;
      else if (root.getDato() > x)
          return 1 + distanceFromRoot(root.getIzquierdo(), x);
     
      return 1 + distanceFromRoot(root.getDerecho(), x);
 
  }
  
  public static NodoArbol lca(NodoArbol node , int n1 , int n2) {
     
      if (node == null)
          return null;

      // If both n1 and n2 are smaller than root, then LCA lies in left
      if (node.getDato() > n1 && node.getDato() > n2)
          return lca(node.getIzquierdo(), n1, n2);

      // If both n1 and n2 are greater than root, then LCA lies in right
      if (node.getDato() < n1 && node.getDato() < n2) 
          return lca(node.getDerecho(), n1, n2);

      return node;
  }
   
  public static NodoArbol createBST(int[] values) {
    
      NodoArbol root = new NodoArbol(values[0]);
      
      for(int i=1; i< values.length; i++) {
       
          int valor = values[i];
          NodoArbol insert = new NodoArbol(valor);
         
          NodoArbol actual = root;
                  
          while(actual != null) {
             
              if(valor > actual.getDato()) {
                 if(actual.getDerecho() == null) {
                     actual.setDerecho(insert);
                     break;
                 }
                 actual = actual.getDerecho();
                 
             }else if(valor < actual.getDato()){
                 if(actual.getIzquierdo() == null) {
                     actual.setIzquierdo(insert);
                     break;
                 }
                 actual = actual.getIzquierdo();
             }
          } 
      }
      
      return root;
  }
  
  /*
   * inputString = awaglknagawunagwkwagl
   * num= 4
   * output={wagl,aglk,glkn,lkna,knag,gawu,awun,wuna,unag,nagw,agwk,kwag}
   * 
   */
  public static List<String> subStringKdist(String inputStr , int k){
     
      Hashtable<String, String> ht = new Hashtable<String, String>();
      
      char[] lista = inputStr.toCharArray();
     
      for(int i=0 ; i<lista.length; i++) {
          
          String dato = "";
          
          for(int j = i, n = i + k; j < n ; j++ ) {
            
              if(j == lista.length){
                  break;
              }else {
                  dato = dato + lista[j];
              } 
          }
          
          if(validaLetrasRepetidas(dato)) {
              if(!ht.contains(dato) && dato.length() == k ) {
                  ht.put(dato, dato);
              }
          } 
      }
      
      ArrayList<String> salida = new ArrayList<String>(ht.values());
      
      return salida;
   }
  
   public static boolean validaLetrasRepetidas(String str) {
       boolean[] b = new boolean[128];
       
       for(int i=0; i<str.length(); i++) {
           int val = str.charAt(i);
     
           if(b[val]) { 
               return false;
           }
           
           b[val] = true;
       }
       
       return true;
   }
   
}
