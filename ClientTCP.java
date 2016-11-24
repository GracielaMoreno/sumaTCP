package ec.edu.epn.redes.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientTCP {
	
	private static int SERVER_PORT = 9090;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String serverAddress = JOptionPane.showInputDialog("Ingrese dirección IP de la máquina que está\n"
				+ "corriendo el servicio en el puerto 9090");
		
		Socket clientSocket = new Socket(serverAddress, SERVER_PORT); 
		
		//Enviar un mensaje al servidor
		String a = JOptionPane.showInputDialog("Ingrese el primer numero a sumar");
		String b = JOptionPane.showInputDialog("Ingrese el segundo numero a sumar");
		PrintWriter msj = new PrintWriter(clientSocket.getOutputStream(), true);
		msj.println(a);
		msj.println(b);
		
		//Obtener el paquete que envia el servidor
		InputStreamReader inpuStream = new InputStreamReader(clientSocket.getInputStream()); //En esta variable guarda el paquete
		BufferedReader input = new BufferedReader(inpuStream); // se lee la variable
		String answer = input.readLine(); //Guarda en un String
				
		JOptionPane.showMessageDialog(null, answer);
		System.exit(0);
	}

}
