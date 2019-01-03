package cl.ejercicios.java.generics;

import java.util.ArrayList;
import java.util.Iterator;
import cl.ejercicios.java.generics.Chocolatina; 

public class Bolsa<T> implements Iterable<T>{
 
    private ArrayList<T> lista= new ArrayList<T>();
    private int tope;
     
     
    public Bolsa(int tope) {
        super();
        this.tope = tope;
    }
    
    public void add(T objeto ) {
        if (lista.size()<=tope) {
         
        lista.add(objeto);
        }else {
         
        throw new RuntimeException("no caben mas");
        }
    }
 
    public Iterator<T> iterator() {
        return lista.iterator();
    }
 
    
    public static void main(String[] args) {
        
        Bolsa<Chocolatina> bolsa= new Bolsa<Chocolatina>(3);
        Chocolatina c= new Chocolatina("milka");
        Chocolatina c1= new Chocolatina("milka");
        Chocolatina c2= new Chocolatina("ferrero");
         
        bolsa.add(c);
        bolsa.add(c1);
        bolsa.add(c2);
         
        for (Chocolatina chocolatina:bolsa) {
         
        System.out.println(chocolatina.getMarca());
        }
    }
        
}
