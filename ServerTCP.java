package ec.edu.epn.redes.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

	private static int PORT = 9090;

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Servidor escuchando en el puerto " + PORT);
		try { 
			while (true) {

				Socket socket = serverSocket.accept();
				try {
					InputStreamReader inpuStream = new InputStreamReader(socket.getInputStream()); //En esta variable guarda el paquete
					BufferedReader input = new BufferedReader(inpuStream); // se lee la variable
					String a = input.readLine(); //Guarda en un String
					String b = input.readLine(); //Guarda en un String
					int c = Integer.parseInt(a) + Integer.parseInt(b);
					//palabra.toUpperCase();
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println("La respuesta de la suma es: " + c);
				}
				finally {
					socket.close();
				}
			}

		}
		finally {
			serverSocket.close();
		}

	}

}
