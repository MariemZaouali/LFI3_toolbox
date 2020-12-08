package tn.isima;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient { 
    public static void main(String args[]) throws Exception {
    	//Done créer un registry pour localiser le serveur localhost qui propose le service
        Registry registry = LocateRegistry.getRegistry("localhost");
        //Done récupérer l'objet du registry
       RMIServerIntf obj= (RMIServerIntf) registry.lookup("RMIServer");
        MessageInfo v= new MessageInfo(1,10);
        //Done Lancer le traitement distant
        System.out.println(obj.getMessage(v));
    }
}