package Logica;

import java.util.ArrayList;

import Dominio.*;

public class Subscriptor {
	
	private Usuario user;
	
	public Subscriptor(Usuario u){
		this.user = u;
	}
	
	public void recibirNoticia(Noticia n) {
		ListaNoticias noticiasAux = user.getNoticiasNoVistas();
		ArrayList<Noticia> noticiasEnCola = noticiasAux.getNoticias();
		noticiasEnCola.add(n);
	}
	
	public Usuario getUsuario() {
		return this.user;
	}
	
}
