package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Dominio.Canal;
import Dominio.ListaCanales;
import Logica.SistemaNoticiasImpl;

class testListaCanales {

	@Test
	void test() {
		
		Canal c1 = new Canal("canal1");
		Canal c2 = new Canal("canal2");
		
		SistemaNoticiasImpl sn = new SistemaNoticiasImpl();
		
		ArrayList<Canal> listaCanalesImplement = sn.get_listaCanales();
		listaCanalesImplement.add(c1);
		listaCanalesImplement.add(c2);

		String nombreCanal1Esperada = c1.getNombre();
		String nombreCanal1Obtenida = sn.get_listaCanales().get(0).getNombre();
		
		assertEquals(nombreCanal1Esperada,nombreCanal1Obtenida);
	}
}
