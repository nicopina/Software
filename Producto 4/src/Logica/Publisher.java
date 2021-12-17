package Logica;

import java.util.ArrayList;
import Dominio.Canal;
import Dominio.Noticia;

public class Publisher {
	
	private Canal canal;
	
	public Publisher(Canal c) {
		this.canal = c;
	}
	
	public void publish(Noticia n, ArrayList<Noticia> noticiasSistema) {
		noticiasSistema.add(n);
	}
}
