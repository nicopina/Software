package Dominio;


import java.util.Scanner;


public class Canal {
	private String nombre;
	private String categoria;
	
	
	public Canal (String name,String categoria) {
        this.nombre = name;
        this.categoria=categoria;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getCategoria() {
		return this.categoria;
	}
	
	
	

}
