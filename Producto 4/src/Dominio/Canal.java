package Dominio;


import java.util.ArrayList;



public class Canal {
	private String nombre;
	private ArrayList<Noticia> noticias;
	
	
	public Canal (String name) {
        this.nombre = name;

        this.noticias = new ArrayList<Noticia>();
	}
	public String getNombre() {
		return this.nombre;
	}

	
	public ArrayList<Noticia> getNoticias(){
		return this.noticias;
	}
	
	
	

}
