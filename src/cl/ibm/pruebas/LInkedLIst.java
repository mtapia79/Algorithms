package cl.ibm.pruebas;

public class LInkedLIst {

	public static void main(String args[]){
		ListaEnlazada lista = new ListaEnlazada();
		
		Nodo nodo = new Nodo(null);
		nodo.setDato(123);
		lista.insert(nodo);
		
		Nodo nodo2 = new Nodo(null);
		nodo2.setDato(543);
		lista.insert(nodo2);
		
		Nodo nodo3 = new Nodo(null);
		nodo3.setDato(889);
		lista.insert(nodo3);
		
		//lista.print();
		lista.print(1);
		//System.out.println("valor eliminado:" + lista.extract());
		//lista.print();
		
		
	}
}



class ListaEnlazada{
	private Nodo first;
	private int total;
	
	public ListaEnlazada(){
		first = null;
		total = 0;
	}
	
	public boolean isEmpty(){
		if(first == null){
			return true;
		}else{
			return false;
		}
	}
	
		
	public void insert(Nodo nodo){
		if(first == null){
			first = nodo;
		}else{
			nodo.setSiguiente(first);
			first = nodo;					
		}
	}
	
	public int extract(){
		
		int dato = 0;
		
		if(!isEmpty()){
			Nodo borrar = first;
			dato = borrar.getDato();
			Nodo siguiente = borrar.getSiguiente();			
			first = siguiente; 
			borrar = null;
		}
				
		return dato;
	}
	
	public Nodo extractNodo(){
		
		Nodo dato = null;
		
		if(!isEmpty()){
			Nodo borrar = first;
			dato = borrar;
			Nodo siguiente = borrar.getSiguiente();			
			first = siguiente; 
			borrar = null;
		}
				
		return dato;
	}
	
	public void print(int n){
		if(isEmpty()){
			System.out.println("Lista Vacia N:");
			return;
		}else{
			
			Nodo current = first;
			
			for(int i=0; i< n ; i++){				
				current = current.getSiguiente();	
				if(current == null){
					return;
				}
			}			
			
			System.out.println("valor encontrado:" + current.getDato());
		}
	}
	
	public void print(){
		if(isEmpty()){
			System.out.println("Lista Vacia");
			return;
		}
		Nodo current = first;
		while(current != null){
			System.out.println("datos:" + current.getDato());
			current = current.getSiguiente();
		}
	}
	
	
}

class Nodo{
	private int dato;
	private Nodo siguiente;
	
	public Nodo(Nodo siguiente) {
		this.siguiente = siguiente;
	}
	
	public Nodo getSiguiente(){
		return siguiente;
	}
	
	public void setSiguiente(Nodo siguiente){
		this.siguiente = siguiente;
	}
	
	public int getDato(){
		return dato;
	}
	
	public void setDato(int dato){
		this.dato = dato;
	}
	
	
}
