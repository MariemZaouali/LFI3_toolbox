package tn.isima;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient { 
    public static void main(String args[]) throws Exception {
    	//Done créer un registry pour localiser le serveur qui propose le service
        Registry registry = LocateRegistry.getRegistry("localhost");
        //Done récupérer l'objet du registry
        InterfaceSpectacle obj = (InterfaceSpectacle) registry.lookup("RMIServer");
        //Done Lancer le traitement distant
        System.out.println("Liste Affichage client");
        System.out.println(obj.consulter()); 
        
        Scanner scan=new Scanner(System.in);
        while (true) {
           
                System.out.println("Entrez: ");
                String msg = scan.nextLine();
                if(msg.equals("exit")){
                    break;
                }
                System.out.println(obj.reserver(Integer.valueOf(msg)));
                System.out.println("Nouvelle liste");
                System.out.println(obj.consulter());
        }
    
}}