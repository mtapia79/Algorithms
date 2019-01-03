package cl.ibm.pruebas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo {
    private final int MAX_VERTS = 20;
    private Vertice[] listaVertice;
    private int[][] matrizAdjacencia;
    private int cantidadVertices;
    
    public Grafo() {
        listaVertice =  new Vertice[MAX_VERTS];
        matrizAdjacencia = new int[MAX_VERTS][MAX_VERTS];
        cantidadVertices = 0;
        
        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                matrizAdjacencia[j][k] = 0;
        
    }
    
    public void insertarVertice(char valor) {
        listaVertice[cantidadVertices++] = new Vertice(valor);
    }
    
    public void insertarEdge(int inicio , int fin) {
        matrizAdjacencia[inicio][fin] = 1;
        matrizAdjacencia[fin][inicio] = 1;
    }
    
    public void desplegarVertice(int posicion) {
         System.out.println(listaVertice[posicion].valor);
    }
    
    public Vertice getNoVisitado(Vertice v) {
    
        for(int j=0; j<cantidadVertices; j++) {
           
            if(listaVertice[j].valor == v.valor) {
              
                for(int k=0; k<cantidadVertices; k++) {
                    if(matrizAdjacencia[j][k]==1 && listaVertice[k].visitado==false) 
                        return listaVertice[k];
                } 
            }
        }  
        
        return null;
    }
    
    
    public void BSF() {
        Queue queue = new LinkedList();
        listaVertice[0].visitado = true;
        queue.add(listaVertice[0]);
        desplegarVertice(0);
 
        while(!queue.isEmpty()) {
            Vertice v = (Vertice)queue.remove();
            Vertice nivel = null;
            
            while((nivel=getNoVisitado(v)) != null) {
                nivel.visitado = true;
                queue.add(nivel);
                System.out.println(nivel.valor);
            }
        }
        queue.clear();
        
        for(int k=0; k<cantidadVertices; k++) 
            listaVertice[k].visitado = false;
    }
    
    public void DSF() {
        Stack stack = new Stack();
        listaVertice[0].visitado = true;
        stack.push(listaVertice[0]);
        desplegarVertice(0);
        
        while(!stack.isEmpty()) {
            
            Vertice v = (Vertice)stack.peek();
            Vertice nivel = getNoVisitado(v);
            
            if(nivel != null) {
                nivel.visitado = true;
                stack.push(nivel);
                System.out.println(nivel.valor);
            }else {
              stack.pop();
            }
        }
        stack.clear();
        
        for(int k=0; k<cantidadVertices; k++) 
            listaVertice[k].visitado = false;
    }
    
    
    public static void iniciarGrafo() {
        
        Grafo g = new Grafo();
        g.insertarVertice('A'); //0
        g.insertarVertice('B'); //1
        g.insertarVertice('C'); //2
        g.insertarVertice('D'); //3
        g.insertarVertice('E'); //4
        
        g.insertarEdge(0, 1); //AB
        g.insertarEdge(1, 2); //BC
        g.insertarEdge(0, 3); //AD
        g.insertarEdge(3, 4); //DE
        
        System.out.println("<BFS>");
        g.BSF();
        System.out.println("<DFS>");
        g.DSF();
        
    }
    
    public static void main(String args[]){
        
        Grafo.iniciarGrafo();
    }
    
}



class Vertice{
    public char valor;
    public boolean visitado;
    public Vertice(char valor) {
        this.valor = valor;
        visitado = false;
    }
} 

class Edge{
    public Edge() {
        
    }
}

