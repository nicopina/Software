package Logica;
import java.util.Scanner;

public class app {
	
	public static void main(String[] args) {
		
		Scanner leer = new Scanner(System.in);
		String usuario,contrasena;
		Integer opcion = -1;
		System.out.println("Sistema de Noticias");
		do {
			System.out.println("Nombre Usuario: ");
			usuario = leer.next();
			System.out.println("Constrasena: ");
			contrasena = leer.next();
			
			System.out.println("OK! ");


		}while(opcion != -1);
		
	}


}
