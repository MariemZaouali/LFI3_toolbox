package tn.isima;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Enregistrement {
	public static void main(String args[]) throws Exception {

        System.out.println("RMI server started");
        
        //Instantiate RmiServer
        GestionnaireSpectacle obj = new GestionnaireSpectacle();
 
        try { //special exception handler for registry creation
        	
        	//Done exporter l'objet à manipuler à distance
            //InterfaceSpectacle stub = (InterfaceSpectacle) UnicastRemoteObject.exportObject(obj,0);
            Registry reg;
            try {
            	//Done création du registry sur le port 1099
            	reg = LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created.");

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	reg = LocateRegistry.getRegistry();
            }
          //Done nommer l'instance de l'objet distant avec sa nommination
        	reg.rebind("RMIServer", obj);

        } catch (RemoteException e) {
        	e.printStackTrace();
        }
    }
}
