package cl.ibm.pruebas;

public class Tree {
	public static void main(String args[]){
		Arbol arbol = new Arbol();
		NodoArbol nuevo1 = new NodoArbol();
		nuevo1.setDato(8);		
		arbol.insertarDato(nuevo1, arbol.raiz);
		
		NodoArbol nuevo2 = new NodoArbol();
		nuevo2.setDato(3);
		arbol.insertarDato(nuevo2, arbol.raiz);
		
		NodoArbol nuevo3 = new NodoArbol();
		nuevo3.setDato(10);
		arbol.insertarDato(nuevo3, arbol.raiz);
		
		NodoArbol nuevo4 = new NodoArbol();
		nuevo4.setDato(1);
		arbol.insertarDato(nuevo4, arbol.raiz);
		
		NodoArbol nuevo5 = new NodoArbol();
		nuevo5.setDato(6);
		arbol.insertarDato(nuevo5, arbol.raiz);
		
		NodoArbol nuevo6 = new NodoArbol();
		nuevo6.setDato(14);
		arbol.insertarDato(nuevo6, arbol.raiz);
		
		NodoArbol nuevo7 = new NodoArbol();
		nuevo7.setDato(4);
		arbol.insertarDato(nuevo7, arbol.raiz);
		
		NodoArbol nuevo8 = new NodoArbol();
		nuevo8.setDato(7);
		arbol.insertarDato(nuevo8, arbol.raiz);
		
		NodoArbol nuevo9 = new NodoArbol();
		nuevo9.setDato(13);
		arbol.insertarDato(nuevo9, arbol.raiz);
		
		
		/*System.out.println("inorden");
		arbol.inOrden(arbol.raiz);
		System.out.println("preorden");
		arbol.preOrden(arbol.raiz);
		System.out.println("postorden");
		arbol.postOrden(arbol.raiz);*/
		System.out.println("anchura");
		arbol.anchura(arbol.raiz);
	}
}

class Arbol{
	NodoArbol raiz;
	
	public Arbol(){
		raiz = new NodoArbol();
	}
	
	public boolean isEmpty(){
		if(raiz == null){
			return true;
		}else{
			return false;
		}
	}

	public void insertarDato(NodoArbol nuevo, NodoArbol r){
		
		if(isEmpty()){
			raiz = nuevo; 
		}else{
			
			if(nuevo.getDato() <= r.getDato()){
				if(r.getIzquierdo() == null){
					r.setIzquierdo(nuevo);
				}else{
					insertarDato(nuevo, r.getIzquierdo());
				}
				
			}else if(nuevo.getDato() >= r.getDato()){
				if(r.getDerecho() == null){
					r.setDerecho(nuevo);
				}else{
					insertarDato(nuevo, r.getDerecho());
				}
			}
		}
	}
	
	public void inOrden(NodoArbol arbol){
	
		if(arbol != null){			
			inOrden(arbol.getIzquierdo());
			System.out.println(arbol.getDato());
			inOrden(arbol.getDerecho());
		}
	}
	
	public void preOrden(NodoArbol arbol){
		if(arbol != null){	
			System.out.println(arbol.getDato());
			preOrden(arbol.getIzquierdo());			
			preOrden(arbol.getDerecho());
		}
	}
	
	public void postOrden(NodoArbol arbol){
		if(arbol != null){			
			postOrden(arbol.getIzquierdo());			
			postOrden(arbol.getDerecho());
			System.out.println(arbol.getDato());
		}
	}
	
	public void anchura(NodoArbol nodo){
		java.util.Queue cola = new java.util.LinkedList();
		
		cola.add(nodo);
		
		while(!cola.isEmpty()){
			nodo = (NodoArbol)cola.remove();
			
			System.out.println(nodo.getDato());
			
			if(nodo.getIzquierdo() != null){
				cola.add(nodo.getIzquierdo());
			}
			
			if(nodo.getDerecho() != null){
				cola.add(nodo.getDerecho());
			}
		}
	}
	
	public void profundidad(NodoArbol nodo){
		if(nodo != null){
			return;
		}
		
		System.out.println(nodo.getDato());
		profundidad(nodo.getIzquierdo());
		profundidad(nodo.getDerecho());
		
	}
		
}

class NodoArbol{
	private int dato;
	private NodoArbol izquierdo;
	private NodoArbol derecho;
	
	public NodoArbol() {
		this.izquierdo = null;
		this.derecho = null;
	}
	
	public NodoArbol getIzquierdo(){
		return izquierdo;
	}
	
	public void setIzquierdo(NodoArbol izquierdo){
		this.izquierdo = izquierdo;
	}
	
	public NodoArbol getDerecho(){
		return derecho;
	}
	
	public void setDerecho(NodoArbol derecho){
		this.derecho = derecho;
	}
	
	public int getDato(){
		return dato;
	}
	
	public void setDato(int dato){
		this.dato = dato;
	}
	
	
}
