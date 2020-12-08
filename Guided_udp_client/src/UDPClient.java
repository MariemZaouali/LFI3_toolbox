import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {




	public static void main(String[] args)  {
		InetAddress	serverAddr ;
		int			recvPort=8081;
		String m;
		DatagramPacket		pkt;
		ByteArrayOutputStream byteStream;
		ObjectOutputStream os;
		DatagramSocket sendSoc;

		try {
			//Done récupérer l'adresse du serveur par son nom
			serverAddr = InetAddress.getByName("localhost");
			System.out.println("Constructing udp client");
			//Done Créer le datagramme socket
			sendSoc = new DatagramSocket();
			System.out.println("Sending messages");
			m = " Bonjour LFI envoyé du client !"; 
			byteStream = new ByteArrayOutputStream(5000);
			try {
				//Done Créer un flux là où on peut mettre des objets. Il faut créer d'abord le buffer là on va mettre l'objet
				os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
				os.flush();
				//Done Ecrire l'objet
				os.writeObject(m);
				//Done transférer l'objet du buffer vers le ObjectOuputStream
				os.flush();
				
			} catch (IOException e) {
				System.out.println("Error serializing object for transmition.");
				System.exit(-1);
			}
			//retrieves byte array
			byte[] sendBuf = byteStream.toByteArray();    
			pkt = new DatagramPacket(sendBuf,sendBuf.length, serverAddr, recvPort);//(data, data.length, destAddr, destPort);
			try {
				//Done envoyer le datagramme au serveur
				sendSoc.send(pkt);
			} catch (IOException e) {
				System.out.println("Error transmitting packet over network.");
				System.exit(-1);
			}

		} catch (SocketException e) {
			System.out.println("Error creating socket for sending data.");

		} catch (UnknownHostException e) {
			System.out.println("Bad server address in UDPClient, " + args[0] + " caused an unknown host exception " + e);
			System.exit(-1);
		}
	}


}