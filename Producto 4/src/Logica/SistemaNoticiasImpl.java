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
	private ArrayList<Usuario> listaUsuarios;
	//private Servidor server;
	//private Publisher publisher;
	
	public SistemaNoticiasImpl() {
		listaCanales = new ArrayList<Canal>();
		listaNoticias = new ArrayList<Noticia>();
		//server = new Servidor(listaCanales,listaUsuarios);
		
	}
	
	public ArrayList<Noticia> OrdenarNoticias(ArrayList<Noticia> listaNoticiass) {
	      for(int i = 2; i < listaNoticiass.size(); i++) {
	    	  for(int j = 0;j < listaNoticiass.size()-i;j++) {
		          if(listaNoticiass.get(i).getFecha().compareTo(listaNoticiass.get(j+1).getFecha())>0)
		          {
		            Noticia auxiliar = listaNoticiass.get(j);
		            listaNoticiass.add(j,listaNoticiass.get(j+1));
		            listaNoticiass.add(j+1,auxiliar);//s
		          }   
		        }
		   }
	      return listaNoticiass;

	}

	public void verNoticias(String nombre) {
		Usuario usuario = null;
		for (int i = 0; i< listaUsuarios.size(); i++) {
			if (nombre.equals(listaUsuarios.get(i).getNombre())) {
				usuario = listaUsuarios.get(i);
				break;
			}
		}
		
		ListaNoticias noticiasUsuarioAux = usuario.getNoticiasNoVistas();
		ArrayList<Noticia> listaNoticiasUsuario = noticiasUsuarioAux.getNoticias();
		for (int i = 0; i< usuario.getNoticiasVistas().getNoticias().size() ; i++) {
			Noticia noticiaVistaI = usuario.getNoticiasVistas().getNoticias().get(i);
			listaNoticiasUsuario.add(noticiaVistaI);
		}
		ListaCanales canalesUsuario = usuario.getSuscripciones();
		
		
		ArrayList<Noticia> noticiasMostrar = new ArrayList<Noticia>();
		for (int i = 0; i < listaNoticiasUsuario.size(); i++) {
			noticiasMostrar.add(listaNoticiasUsuario.get(i));
		}
		
		while (true) {
			System.out.println("------Ver noticias-----");
			for (int i = 0; i < noticiasMostrar.size(); i++) {
				Noticia noticiaI = noticiasMostrar.get(i);
				System.out.println(i + " "+ noticiaI.getTitulo());
			}
			
			System.out.println("Ingrese la opcion de la operacion que desee realizar,\nPara ver alguna noticia ingrese el n�mero asociado a ella:");
			System.out.println("X. Ordenar cronologicamente\nY. Filtrar por tema\n-1. Para salir");
			Scanner escaner = new Scanner(System.in);
			String opcionEntrada = escaner.next(); 
			
			if (opcionEntrada.equalsIgnoreCase("x")) {
				noticiasMostrar = OrdenarNoticias(noticiasMostrar);
			}
			
			else {
				if (opcionEntrada.equalsIgnoreCase("y")) {
					
					noticiasMostrar = filtrarNoticia(noticiasMostrar, canalesUsuario);
				}
				
				else {
					//Vemos si es que la entrada es un indice valido de alguna noticia.
					try {
						int indice = Integer.parseInt(opcionEntrada);
						if (indice >= 0 && indice < noticiasMostrar.size()) {
							System.out.println("Abriendo noticia...");
							System.out.println("---------------------------------");
							Noticia noticiaSeleccionada = noticiasMostrar.get(indice);
							System.out.println(noticiaSeleccionada.getTitulo()+"\n");
							System.out.println(noticiaSeleccionada.getTexto());
						}
						else {
							if (indice == -1) {
								break;
							}
							else {
								System.out.println("Opcion invalida");
							}
						}
					}
					
					catch(Exception e){
						System.out.println("Opcion invalida"); 
					}
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
			System.out.println("Ingrese el n�mero de 1 canal para aniadir o -1 para dejar de aniadir canales: ");
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
		
		//publisher.publish(noticia, canales, server);
		
	}
	
	public ArrayList<Canal> mostrarCanales() {
		System.out.println("-----------Lista canales----------");
		for (int i = 0; i < listaCanales.size(); i++) {
			Canal canalI = listaCanales.get(i);
			System.out.println(i+".- "+ canalI.getNombre());
		}
		return listaCanales;
		
	}
	
	public void suscribirseCanal(String nombre) {
		mostrarCanales();
		Scanner escanerTres = new Scanner(System.in);
		Usuario usuario = null;
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (nombre.equals(listaUsuarios.get(i).getNombre())) {
				usuario = listaUsuarios.get(i);
			}
		}

		ListaCanales canalesUsuario = usuario.getSuscripciones();
		ArrayList<Canal> canalesArray = canalesUsuario.getCanales();
		

		System.out.println("Seleccione el numero del canal para suscribirse: ");
		String entradaCanal = escanerTres.next();
		try {
			int canalAnadido = Integer.parseInt(entradaCanal);
			
			if (canalAnadido >= 0 && canalAnadido < listaCanales.size()) {
				Canal canalSeleccionado = listaCanales.get(canalAnadido);
				if (!canalesArray.contains(canalSeleccionado)) {
					canalesArray.add(canalSeleccionado);
				}
				else {
					System.out.println("Error: Opcion invalida");
				}
			}
			else {
				System.out.println("Error: Opcion invalida");
			}
		}
		catch(Exception e) {
			System.out.println("Error: Opcion invalida");
		}
	}
	
	public ArrayList<Noticia> filtrarNoticia(ArrayList<Noticia> listaNoticias, ListaCanales canales) {

		// Se obtiene la lista de canales
        ArrayList<Canal> listaCanales = canales.getCanales();

        // Muestra la lista de canales
        System.out.println("------Canales-----");
        for (int i = 0; i < listaCanales.size(); i++) {
            Canal canalI = listaCanales.get(i);
            System.out.println(i + " "+ canalI.getNombre());
        }
        
        // El usuario elige el canal
        Integer opcionEntrada;
        do {
            System.out.println("Ingrese el canal a filtrar:\n");

            Scanner leer = new Scanner(System.in);
            opcionEntrada = leer.nextInt();
        }while((opcionEntrada < 0) || (opcionEntrada >  (listaCanales.size()-1)));
        
        // Se crea la nueva lista de noticias filtradas
        ArrayList<Noticia> noticiasFiltradas = new ArrayList<Noticia>();

        // Por cada noticia, si el canal seleccionado anteriormente esta en su lista, se guarda la noticia en la lista de noticias filtradas
        
        for (int i = 0; i < listaNoticias.size(); i++) {//recorre todas las noticias
        	ListaCanales listaCanales1 = listaNoticias.get(i).getCanales();
            ArrayList<Canal> canales1 = listaCanales1.getCanales();//se obtienen los canales asociados a esa noticia
            
            for( int e = 0; e < canales1.size();e++) {// recorre los canales de la noticia
                
            	if(canales1.get(e).getNombre().equals(listaCanales.get(opcionEntrada).getNombre())){// si el nombre del 
                    noticiasFiltradas.add(listaNoticias.get(i));
                }
            }

        }
        return noticiasFiltradas;
    }
	
	public ArrayList<Canal> get_listaCanales(){
		return listaCanales;
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return this.listaUsuarios;
	}
	
	public boolean agregarUsuario(String name, String pass) {
		
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario a = listaUsuarios.get(i);
			if (a.getNombre().equals(name)) {
				return false;
			}
		}
		
		Usuario u = new Usuario(name, pass, false, false);
		return true;
		
	}

}
