package Dominio;

public class Usuario {
	private String nombre;
	private String contrasena;
	private Boolean esAdmin;
	private Boolean puedeEscribir;
	private ListaNoticias noticiasVistas;
	private ListaNoticias noticiasNoVistas;
	private String[] notificacionCanalCerrado;
	private ListaCanales suscripciones;
	
	public Usuario(String nombre,String contrasena,Boolean esAdmin,Boolean puedeEscribir) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.esAdmin = esAdmin;
		this.puedeEscribir = puedeEscribir;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public Boolean getEsAdmin() {
		return esAdmin;
	}

	public Boolean getPuedeEscribir() {
		return puedeEscribir;
	}

	public ListaNoticias getNoticiasVistas() {
		return noticiasVistas;
	}

	public ListaNoticias getNoticiasNoVistas() {
		return noticiasNoVistas;
	}

	public String[] getNotificacionCanalCerrado() {
		return notificacionCanalCerrado;
	}

	public ListaCanales getSuscripciones() {
		return suscripciones;
	}

	/**
	 * @param esAdmin the esAdmin to set
	 */
	public void setEsAdmin(Boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	/**
	 * @param puedeEscribir the puedeEscribir to set
	 */
	public void setPuedeEscribir(Boolean puedeEscribir) {
		this.puedeEscribir = puedeEscribir;
	}
	
	
	
}
