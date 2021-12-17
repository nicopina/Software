package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Dominio.Canal;
import Logica.SistemaNoticiasImpl;

class test_mostrarCanales2 {

	@Test
	void test() {
		//lista de canales
				Canal c1 = new Canal("c1");
				Canal c2 = new Canal("c2");
				Canal c3 = new Canal("c3");
				
				//creacion de lista de canales esperada
				ArrayList<Canal> listaEsperada = new ArrayList<Canal>();
				listaEsperada.add(c1);
				listaEsperada.add(c2);
				listaEsperada.add(c3);
				
				//creacion de la lista de canales del sistema
				SistemaNoticiasImpl sis = new SistemaNoticiasImpl();
				
				sis.get_listaCanales().add(c1);
				sis.get_listaCanales().add(c2);
				sis.get_listaCanales().add(c3);
				
				ArrayList<Canal> listaResultado = sis.mostrarCanales();
				
				//check de que las listas son de igual tamaño
				assertEquals(listaResultado.size(),listaEsperada.size());
				
				//vemos que las listas tengan los mismos canales
				for(int i = 0; i < listaResultado.size(); i++) {
					
					//comparamos los nombres de los canales
					assertEquals(listaResultado.get(i).getNombre(),listaEsperada.get(i).getNombre());
					
				}
	}

}
