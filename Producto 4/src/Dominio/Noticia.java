package Dominio;
import java.util.Date;

public class Noticia {
	
	private String titulo;
	private String texto;
	private Date fecha;
	private ListaCanales lc;
	
	public Noticia(String titulo, String texto, Date fecha, ListaCanales canales) {
		this.titulo = titulo;
		this.texto = texto;
		this.fecha = fecha;
		this.lc = canales;

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

	/**
	 * @return the canales
	 */
	public ListaCanales getCanales() {
		return lc;
	}




}
