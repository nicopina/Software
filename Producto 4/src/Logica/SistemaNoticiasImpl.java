package Logica;
import Dominio.*;
import java.util.ArrayList;
import java.util.Date;
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

	public void verNoticias(ListaNoticias noticias) {
		ArrayList<Noticia> listaNoticias = noticias.getNoticias();
		System.out.println("------Ver noticias-----");
		for (int i = 0; i < listaNoticias.size(); i++) {
			Noticia noticiaI = listaNoticias.get(i);
			System.out.println(i + " "+ noticiaI.getTitulo());
		}
		
		System.out.println("Ingrese la opciï¿½n de la operaciï¿½n que desee realizar:\n");
		System.out.println("X. Ordenar cronolï¿½gicamente\nY. Filtrar por tema");
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
				//Vemos si es que la entrada es un ï¿½ndice vï¿½lido de alguna noticia.
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
						System.out.println("Opciï¿½n invï¿½lida"); 
					}
				}
				
				catch(Exception e){
					System.out.println("Opciï¿½n invï¿½lida"); 
				}
			}
		}
	}
	
	public void enviarNoticia() {
		Date fecha = new Date(); //Obtiene la fecha de ahora.
		
		Scanner escanerDos = new Scanner(System.in);
		
		System.out.println("-----Creador de noticias-----\nIngrese el titulo: ");
		String titulo = escanerDos.next();
		System.out.println("Ingrese el texto de la noticia: ");
		String texto = escanerDos.next();
		System.out.println("Seleccione los canales de la noticia: ");
		
		for (int i = 0; i < listaCanales.size(); i++) {
			Canal canalI = listaCanales.get(i);
			System.out.println(i+".- "+ canalI.getNombre());
		}
		
		ListaCanales canales = new ListaCanales();
		ArrayList<Integer> canalesAnadir = new ArrayList<Integer>();
		ArrayList<Canal> nombresCanales = canales.getCanales();
		
		
		while(true) {
			System.out.println("Ingrese el número de 1 canal para aniadir o -1 para dejar de aniadir canales: ");
			String entradaCanal = escanerDos.next();
			try {
				int canalAnadido = Integer.parseInt(entradaCanal);
				
				if (canalAnadido >= 0 && canalAnadido < listaCanales.size() && !canalesAnadir.contains(canalAnadido)) {
					canalesAnadir.add(canalAnadido);
					nombresCanales.add(listaCanales.get(canalAnadido));
				}
				else {
					if (canalAnadido == -1) {
						break;
					}
					else{
						System.out.println("Error: Opcion invalida.");
					}
				}
			}
			catch(Exception e) {
				System.out.println("Error: Opcion invalida.");
			}
		}

		Noticia noticia = new Noticia(titulo,texto,fecha,canales);
		
		listaNoticias.add(noticia); //Se supone que esto lo "ve" el observador
	}
}
