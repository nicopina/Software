package test;
import Dominio.Canal;
import Dominio.ListaCanales;
import Dominio.ListaNoticias;
import Dominio.Noticia;
import Logica.SistemaNoticias;
import Logica.SistemaNoticiasImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class test_filtrar_noticias {
	
	@Test
	void test() {
		
		//canales
		Canal c1 = new Canal("canal1");
		Canal c2 = new Canal("canal2");
		//listas de canales para comparar
		ListaCanales lc1 = new ListaCanales();
		ListaCanales lc2 = new ListaCanales();
		
		//canales del usuario
		ListaCanales canalesUsuario = new ListaCanales();
		
		canalesUsuario.getCanales().add(c1);
		canalesUsuario.getCanales().add(c2);
		
		//listas para cada noticia
		lc1.getCanales().add(c1);
		lc2.getCanales().add(c2);

		Noticia n1 = new Noticia("N1","blabla1",new Date(),lc1);
		Noticia n2 = new Noticia("N2","blabla2",new Date(),lc2);
		
		// lista de noticias del usuario
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();

		listaNoticias.add(n1);
		listaNoticias.add(n2);
		
		// lista de noticias esperada despues del filtro
		ArrayList<Noticia> noticiasFiltradasEsperadas= new ArrayList<Noticia>();
		noticiasFiltradasEsperadas.add(n2);

		SistemaNoticiasImpl sn = new SistemaNoticiasImpl();
		
		ArrayList<Noticia> noticiasFiltradasOriginal = sn.filtrarNoticia(listaNoticias, canalesUsuario);
		
		// titulos esperados de la primera noticia
		
		String tituloNoticia1esperada = noticiasFiltradasEsperadas.get(0).getTitulo();
		String tituloNoticia1filtrada = noticiasFiltradasOriginal.get(0).getTitulo();

		assertEquals(tituloNoticia1esperada,tituloNoticia1filtrada);
		
	}

}
