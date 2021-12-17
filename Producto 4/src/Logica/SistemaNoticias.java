package Logica;

import java.util.ArrayList;
import java.util.Date;

import Dominio.*;

public interface SistemaNoticias {
	

	public String ordenarNoticia(String [] lista,Date fecha,String tematica);
	
	public void verNoticias(ListaNoticias noticias);
	
	public void enviarNoticia(String titulo, String texto, ListaCanales canales);
	
	public ArrayList<Noticia> filtrarNoticia(ArrayList<Noticia> listaNoticias, ListaCanales canales);
	
	public ArrayList<Canal> mostrarCanales();
	
	public void suscribirseCanal(String nombre);
	
	public boolean agregarUsuario(String name, String pass);


}
