
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// Client for Server1, Server2, Server3
public class Client {
	//Done Ajouter le nom du serveur
	private String serverName="localhost";
    private int serverPort = 8081;
    private Socket socket = null;
    private DataOutputStream dos = null;

    public Client() {
        try {
        	//Done créer une nouvelle socket
        	socket = new Socket(serverName,serverPort);
            //Done récupérer le numéro de port du socket côté client
        	System.out.println("Client démarré sur le port "+socket.getLocalPort());
            //Done récupérer le numéro de port du socket côté serveur
        	System.out.println("Connecté au serveur"+socket.getRemoteSocketAddress());
                
            //Done obtenir le flux d'écriture pour envoyer le message
        	dos= new DataOutputStream(socket.getOutputStream());
        	
            Scanner scan=new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("Message to server : ");
                    String messageToServer = scan.nextLine();
                    if(messageToServer.equals("exit")){
                        break;
                    }
                  //Done écrire le message à envoyer au serveur
                   dos.writeUTF(messageToServer);
                   dos.flush();
                } catch (IOException e) {
                    break;
                }
            }
          //Done fermer le flux d'écriture et le socket
           dos.close();
           socket.close();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        Client client = new Client();
    }
}