package Logica;

import java.util.ArrayList;

import Dominio.*;

public class Servidor {
	
	private ArrayList<Topic> topics;
 
	public Servidor(ArrayList<Canal> canalesSistema, ArrayList<Usuario> usuariosSistema) {
		for (int i = 0; i < canalesSistema.size(); i++) {
			Topic topic = new Topic(canalesSistema.get(i));
			topics.add(topic);
		}
		
		for (int i = 0; i < usuariosSistema.size(); i++) {
			Usuario u = usuariosSistema.get(i);
			Subscriptor sub = new Subscriptor(u);
			
			ListaCanales canalesSuscritosUsuarioAux = u.getSuscripciones();
			ArrayList<Canal> canalesSuscritosUsuario = canalesSuscritosUsuarioAux.getCanales();
			
			for (int j = 0; j < canalesSuscritosUsuario.size(); j++) {
				Canal canal = canalesSuscritosUsuario.get(j);
				
				//Buscamos su topic
				
				for (int k = 0; k < topics.size(); k++) {
					Topic t = topics.get(k);
					if (t.getCanal().equals(canal)) {
						t.addSubscriptor(sub);
					}
				}
			}
		}
	}
	
	public void enviarNoticias(Noticia n, ListaCanales c) {
		
		ArrayList<Canal> canales = c.getCanales();
		for (int i = 0; i < canales.size(); i++) {
			Canal canal = canales.get(i);
			//Buscamos el topic de cada canal de la noticia
			for (int j = 0; j < topics.size(); j++) {
				Topic t = topics.get(j);
				if (t.getCanal().equals(canal)) {
					//Una vez encontrado el topic, le mandamos la noticia a cada sub.
					ArrayList<Subscriptor> subscriptores = t.getSubscriptores();
					for (int s = 0; s < subscriptores.size(); s++) {
						Subscriptor sub = subscriptores.get(s);
						sub.recibirNoticia(n);
					}
					break;
				}
			}
		}	
	}
	
	public void agregarSubscriptor(Canal canal, Usuario usuario) {
		
		for (int i = 0; i < topics.size(); i++) {
			Topic topic = topics.get(i);
			if (topic.getCanal().equals(canal)) {
				
				
				for (int j = 0; j < topic.getSubscriptores().size(); j++) {
					Subscriptor sub = topic.getSubscriptores().get(j);
					if (sub.getUsuario().equals(usuario)) {
						topic.addSubscriptor(sub);
						break;
					}
				}
			}
			break;
		}
	}
}
