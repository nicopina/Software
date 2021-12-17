package Logica;
import Dominio.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class SistemaNoticiasImpl {
	private ArrayList<Canal> listaCanales;
	private ArrayList<Noticia> listaNoticias;
	private ArrayList<String> listafechas;
	
	public SistemaNoticiasImpl() {
		listaCanales = new ArrayList<Canal>();
		listaNoticias = new ArrayList<Noticia>();
		
	}
	public void OrdenarNoticias() {
		for (int i = 0; i < listaNoticias.size(); i++) {
			Noticia noticiaI = listaNoticias.get(i);
			listafechas.add(noticiaI.getFecha2());
			listaNoticias.sort(noticiaI.getFecha());
		}
	}

	public void verNoticias(ListaNoticias noticias) {
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
}
