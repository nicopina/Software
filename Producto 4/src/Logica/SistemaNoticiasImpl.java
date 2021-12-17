package Logica;

import java.util.ArrayList;

import Dominio.ListaNoticias;
import Dominio.Noticia;

public class SistemaNoticiasImpl implements SistemaNoticias{
	
	public SistemaNoticiasImpl() {
		
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
		String opcionEntrada = ""; //Falta scanner
		
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
