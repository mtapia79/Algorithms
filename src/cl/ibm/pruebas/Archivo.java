package cl.ibm.pruebas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Archivo {

	private static final String CABECERA = "/resource/cabecera.dummy";
	
	public static void main(String args[]){
		
		Archivo arch = new Archivo();
		
		arch.cargarArchivo();
		
		
	}
	
	public void cargarArchivo(){
		
		File f = new File(getClass().getResource(CABECERA).getFile()); 
		InputStream is = getClass().getResourceAsStream(CABECERA); // funciona para buscar recursos dentro de un JAR
		
		System.out.println("IS:" +f.length());
		
		byte[] buf = new byte[(int) f.length()];
		
		try {
			System.out.println("BUF:" + is);
			is.read(buf);
			is.close();
			/*FileOutputStream fo = new FileOutputStream(new File("Salida2"));						       			
			int len;

			while((len = is.read(buf)) >0){
				fo.write(buf,0,len);
			}
						
			System.out.println("BUFFER:" + fo);
			
			fo.close();
			is.close();*/
			
			FileOutputStream fo = new FileOutputStream(new File("Salida3"));
			fo.write(buf);
			fo.close();
			System.out.println("BUF:" + buf);
			System.out.println("FO:" + fo);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
