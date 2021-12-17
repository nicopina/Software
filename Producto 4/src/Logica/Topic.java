package Logica;

import java.util.ArrayList;

import Dominio.Canal;

public class Topic {
	private Canal canal;
	private ArrayList<Subscriptor> subscriptores;
	
	public Topic(Canal c) {
		this.canal = c;
		subscriptores = new ArrayList<Subscriptor>();
	}

	/**
	 * @return the canal
	 */
	public Canal getCanal() {
		return canal;
	}

	/**
	 * @return the subscriptores
	 */
	public ArrayList<Subscriptor> getSubscriptores() {
		return subscriptores;
	}

	/**
	 * @param canal the canal to set
	 */
	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	/**
	 * @param subscriptores the subscriptores to set
	 */
	public void addSubscriptor(Subscriptor sub) {
		subscriptores.add(sub);
	}
	
	
}
