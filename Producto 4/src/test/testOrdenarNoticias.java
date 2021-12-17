package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Dominio.Noticia;
import Logica.SistemaNoticiasImpl;

class testOrdenarNoticias {

	@Test
	void test() {
		Noticia n1 = new Noticia("n1", "blabla", new Date(2021-01-01),null);
		Noticia n2 = new Noticia("n2", "blabla", new Date(2021-01-02),null);
		Noticia n3 = new Noticia("n3", "blabla", new Date(2021-01-03),null);
	
		
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		listaNoticias.add(n3);
		listaNoticias.add(n1);
		listaNoticias.add(n2);
				
		SistemaNoticiasImpl sn = new SistemaNoticiasImpl();
		
		ArrayList<Noticia> listaNoticiasOrdenada = sn.OrdenarNoticias(listaNoticias);
		
		String nombrePrimeraNoticiaEsperada = n3.getTitulo();
		String nombrePrimeraNoticiaOrdenada = listaNoticiasOrdenada.get(0).getTitulo();
		
		
		assertEquals(nombrePrimeraNoticiaEsperada, nombrePrimeraNoticiaOrdenada);
		
	}

}
