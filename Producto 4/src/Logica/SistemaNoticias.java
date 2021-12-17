package Logica;

import java.util.Date;

import Dominio.*;

public interface SistemaNoticias {
	
	public String ordenarNoticia(String [] lista,Date fecha,String tematica);
	
	public void verNoticias(ListaNoticias noticias);
	
	public void enviarNoticia(String titulo, String texto, ListaCanales canales);

}
