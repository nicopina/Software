package Logica;
import Dominio.*;
import java.util.ArrayList;
import java.util.Scanner;
public class SistemaNoticiasImpl {
	private ArrayList<Canal> listaCanales;
	private ArrayList<Noticia> listaNoticias;
	
	public SistemaNoticiasImpl() {
		listaCanales = new ArrayList<Canal>();
		listaNoticias = new ArrayList<Noticia>();
	}
	public void OrdenarNoticias() {
		for(int i =0;i< listaNoticias.size();i++) {
			
		}
	}

	public void verNoticias(ListaNoticias noticias,ListaCanales canales) {
		ArrayList<Noticia> listaNoticias = noticias.getNoticias();
		System.out.println("------Ver noticias-----");
		for (int i = 0; i < listaNoticias.size(); i++) {
			Noticia noticiaI = listaNoticias.get(i);
			System.out.println(i + " "+ noticiaI.getTitulo());
		}
		
		System.out.println("Ingrese la opci�n de la operaci�n que desee realizar:\n");
		System.out.println("X. Ordenar cronol�gicamente\nY. Filtrar por tema");
		Scanner escaner = new Scanner(System.in);
		String opcionEntrada = escaner.next(); 
		
		if (opcionEntrada.equalsIgnoreCase("x")) {
			//ordenar
		}
		
		else {
			if (opcionEntrada.equalsIgnoreCase("y")) {
				//filtrar tema
			}
			
			else {
				//Vemos si es que la entrada es un �ndice v�lido de alguna noticia.
				try {
					int indice = Integer.parseInt(opcionEntrada);
					if (indice >= 0 && indice < listaNoticias.size()) {
						System.out.println("Abriendo noticia...");
						System.out.println("---------------------------------");
						Noticia noticiaSeleccionada = listaNoticias.get(indice);
						System.out.println(noticiaSeleccionada.getTitulo()+"\n");
						System.out.println(noticiaSeleccionada.getTexto());
					}
					else {
						System.out.println("Opci�n inv�lida"); 
					}
				}
				
				catch(Exception e){
					System.out.println("Opci�n inv�lida"); 
				}
			}
		}
	}
	public ArrayList<Noticia> filtrarNoticia(ArrayList<Noticia> listaNoticias, ListaCanales canales) {
		
		
		ArrayList<Canal> listaCanales = canales.getCanales();
		
		System.out.println("------Canales-----");
		for (int i = 0; i < listaCanales.size(); i++) {
			Canal canalI = listaCanales.get(i);
			System.out.println(i + " "+ canalI.getNombre());
		}
		
		Integer opcionEntrada;
		do {
			System.out.println("Ingrese el canal a filtrar:\n");
			
			Scanner leer = new Scanner(System.in);
			opcionEntrada = leer.nextInt();
		}while((opcionEntrada < 0) | (opcionEntrada <  listaCanales.size()));
		
		ArrayList<Noticia> noticiasFiltradas = new ArrayList<>();
		
		for (int i = 0; i < listaNoticias.size(); i++) {
			ArrayList<Canal> canales = listaNoticias.get(i).getCanales();
			for( int e = 0; e < canales.size();e++) {
				if(canales.get(e).getNombre().equals(listaCanales.get(opcionEntrada))){
					noticiasFiltradas.add(listaNoticias.get(i));
				}
			}
					
		}
		return noticiasFiltradas;
		
	}
}
