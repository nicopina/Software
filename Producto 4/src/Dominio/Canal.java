package Dominio;


import java.util.ArrayList;



public class Canal {
	private String nombre;
	private ArrayList<Noticia> noticias;
	
	
	public Canal (String name,String categoria) {
        this.nombre = name;
        this.categoria=categoria;
        this.noticias = new ArrayList<Noticia>();
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getCategoria() {
		return this.categoria;
	}
	
	public ArrayList<Noticia> getNoticias(){
		return this.noticias;
	}
	
	
	

}
