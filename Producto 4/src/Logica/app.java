package Logica;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.*;

public class app {
	
	public static void main(String[] args) {
		SistemaNoticiasImpl sistema = new SistemaNoticiasImpl();
		login(sistema);
		
		
	}
	
	public static void login(SistemaNoticiasImpl sistema) {
		Scanner leer = new Scanner(System.in);
		String usuario,contrasena;
		Integer opcion = -1;
		System.out.println("Sistema de Noticias");
		do {
			System.out.println("Nombre Usuario: ");
			usuario = leer.next();
			System.out.println("Constrasena: ");
			contrasena = leer.next();
			
			if (verificarUsuario(sistema,usuario,contrasena)) {
				menuRedactor(sistema, usuario);
			}
			else {
				System.out.println("Error: Datos incorrectos.");
			}
			
			System.out.println("OK! ");


		}while(opcion != -1);
	}
	
	public static void signIn(SistemaNoticiasImpl sistema) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Ingrese su nombre: ");
			String name = scan.next();
			
			System.out.println("Ingrese su contraseña: ");
			String pass = scan.next();
			
			if (sistema.agregarUsuario(name, pass)) {
				System.out.println("Ok.");
			}
			else {
				System.out.println("Error: Este nombre ya existe.");
			}
		}
	}
	
	public static void menuRedactor(SistemaNoticiasImpl sistema, String user) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Menu Usuario redactor");
			System.out.println("1.- Escribir y enviar noticia.");
			System.out.println("2.- Leer noticias");
			System.out.println("3.- Suscribirse a un canal");
			System.out.println("-1.- Salir");
			System.out.println("Ingrese el numero de la opcion que desee: ");
			String entrada = scan.next();
			
			try {
				int entradaOk = Integer.parseInt(entrada);
				
				if (entradaOk == 1) {
					sistema.enviarNoticia();
				}
				else {
					if (entradaOk == 2){
						sistema.verNoticias(user);
					}
					else {
						if (entradaOk == 3){
							sistema.suscribirseCanal(user);
						}
						
						else {
							if (entradaOk == -1) {
								break;
							}
							else {
	
								System.out.println("Error: Opcion invalida.");
							}			
						}
					}
				}
			}
			catch(Exception e) {
				System.out.println("Error: Opcion invalida.");
			}
		}
	}
	
	public static boolean verificarUsuario(SistemaNoticiasImpl sistema, String user, String pass) {
		
		ArrayList<Usuario> usuarios = sistema.getUsuarios();
		
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario u = usuarios.get(i);
			if ((u.getNombre().equals(user)) && (u.getContrasena().equals(pass))) {
				return true;
			}
		}
		return false;
	}
	
	
	
	


}
