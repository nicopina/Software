package Dominio;

import java.util.ArrayList;

public class ListaCanales {
	private ArrayList<Canal> canales;
	
	public ListaCanales() {
		canales = new ArrayList<Canal>();
	}

	public ArrayList<Canal> getCanales() {
		return canales;
	}

	public void setCanales(ArrayList<Canal> canales) {
		this.canales = canales;
	}
	
}