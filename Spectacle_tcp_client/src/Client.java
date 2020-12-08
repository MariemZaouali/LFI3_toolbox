
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// Client for Server1, Server2, Server3
public class Client {
	//Done Ajouter le nom du serveur
    private String serverName = "localhost";
    private int serverPort = 8081;
    private Socket socket = null;
    private DataOutputStream dos = null;
    private BufferedInputStream bis=null;
    private DataInputStream dis=null;
    public Client() {
        try {
        	//Done créer une nouvelle socket
            socket = new Socket(serverName, serverPort);
            //Done récupérer le numéro de port du socket côté client
            System.out.println("Client started on port " + socket.getLocalPort()+"...");
            //Done récupérer le numéro de port du socket côté serveur
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());
                
            //Done obtenir le flux d'écriture pour envoyer le message
            dos = new DataOutputStream(socket.getOutputStream());
            
            Scanner scan=new Scanner(System.in);
            while (true) {
                try {
                    System.out.print("Message to server : ");
                    String messageToServer = scan.nextLine();
                    if(messageToServer.equals("exit")){
                        break;
                    }
                  //Done écrire le message à envoyer au serveur
                    dos.writeUTF(messageToServer);
                    dos.flush();
                    //Done Obtenir le flux d'entrée pour obtenir les informations parvenues de la socket
                    bis = new BufferedInputStream(socket.getInputStream());
                    //Done Lire le data input stream
                    dis = new DataInputStream(bis);

                    System.out.println('J'+"affiche les données sur les spectacles reçus du serveur :"+"***********************************\n"+dis.readUTF());
                  
                } catch (IOException e) {
                    break;
                }
            }
         
            dis.close();
            bis.close();
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