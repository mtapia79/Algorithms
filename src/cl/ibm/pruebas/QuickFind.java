package cl.ibm.pruebas;

import cl.librerias.StdIn;
import cl.librerias.StdOut;

public class QuickFind {
	private int[] id;
	
	public QuickFind(int N) {
		id = new int[N];
		 for (int i = 0; i < N; i++)
		 id[i] = i;
	}
	public static void main(String args[]){
	
		int N = StdIn.readInt();
		StdOut.println("hola" + N);
		/*QuickFind uf = new QuickFind(N);
		 while (!StdIn.isEmpty())
		 {
		 int p = StdIn.readInt();
		 int q = StdIn.readInt();
		 if (!uf.connected(p, q))
		 {
		 uf.union(p, q);
		 StdOut.println(p + " " + q);
		 }
		 }*/
		 
	}
	
	public void union(int p, int q){
		//add connection between p and q
		int pid = id[p];
		 int qid = id[q];
		 for (int i = 0; i < id.length; i++)
		 if (id[i] == pid) id[i] = qid;
	}
	public boolean connected(int p, int q) {
		//are p and q in the same component?
		return id[p] == id[q]; 
	}
	/*public int find(int p) {
		//component identifier for p (0 to N – 1)
	}
	public int count() {
		
	}*/
}
