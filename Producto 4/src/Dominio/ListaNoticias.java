package Dominio;

import java.util.ArrayList;

public class ListaNoticias {
	private ArrayList<Noticia> noticias;
	
	public ListaNoticias() {
		noticias = new ArrayList<Noticia>();
	}
	
	public ArrayList<Noticia> getNoticias(){
		return noticias;
	}
	
}
