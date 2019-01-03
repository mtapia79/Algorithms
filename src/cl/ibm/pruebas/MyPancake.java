package cl.ibm.pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MyPancake  implements Pancake{

    public static void main(String args[]){
       List<String> x = new  ArrayList<String>();
        x.add("3"); x.add("7"); x.add("5");
        
        List<String> y = new MyPancake().doStuff(x);
        y.add("1");
        System.out.println(x);
       /* List<String> lista = findSchedules(24,4,"08??840");
        
        for(String s : lista) {
            System.out.println(s);
        }*/
    }
    
    @Override
    public List<String> doStuff(List<String> s) {
        s.add("9");
        return s;
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
        
    
         
}

interface Pancake{
    List<String> doStuff(List<String> s);
}



