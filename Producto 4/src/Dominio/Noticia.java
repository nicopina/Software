package Dominio;
import java.util.Date;

public class Noticia {
	
	private String titulo;
	private String texto;
	private Date fecha;
	
	public Noticia(String titulo, String texto, Date fecha) {
		this.titulo = titulo;
		this.texto = texto;
		this.fecha = fecha;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	
	
	
}
