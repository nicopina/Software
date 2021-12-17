package Dominio;
import java.util.Comparator;
import java.util.Date;

public class Noticia {
	
	private String titulo;
	private String texto;
	private Date fecha;
	private String fecha2;
	private Canal[] canales;
	
	public Noticia(String titulo, String texto, Date fecha, Canal[] canales,String fecha2) {
		this.titulo = titulo;
		this.texto = texto;
		this.fecha = fecha;
		this.canales = canales;
		this.fecha2 = fecha2;
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
	public Canal[] getCanales() {
		return canales;
	}

	public String getFecha2() {
		return fecha2;
	}

	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}
}
