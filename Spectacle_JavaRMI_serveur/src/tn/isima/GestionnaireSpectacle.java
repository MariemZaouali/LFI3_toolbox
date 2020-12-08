package tn.isima;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GestionnaireSpectacle extends UnicastRemoteObject implements InterfaceSpectacle {
	
	public ArrayList<Spectacle> spec=new ArrayList<Spectacle>();

	protected GestionnaireSpectacle() throws RemoteException {
		super();
		Spectacle s= new Spectacle();
		s.intitule="La bête et la belle";
		s.nb_place=10;
		s.id=1;
		this.spec.add(s);
		Spectacle s1= new Spectacle();
		s1.intitule="Blanche Neige";
		s1.nb_place=12;
		s.id=2;
		this.spec.add(s1);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String consulter() throws RemoteException {
		String s="";
		 for(int i=0;i<this.spec.size();i++) 
			 s=s+"Id"+this.spec.get(i).id+"\t le nom du spectacle : "+this.spec.get(i).intitule+"\t nb places\n"+this.spec.get(i).nb_place+"\n";
		 return "La liste des spectacles\n"+s+"\n Mettre le numéro de spectacle \n";
		
	}

	@Override
	public String reserver(int p) throws RemoteException {
		boolean drap=false;
		 for(int i=0;i<this.spec.size();i++) {
			 if (spec.get(i).id== p)
				 if (spec.get(i).nb_place > 0)
					 {
					 	spec.get(i).nb_place--;
					 	drap=true;
					 	break;
					 }
				 else {
					 return "Pas de places !";
				 }
			 }
		 if(drap)
			 return "réservé avec succés";
		 else
			 return "échec de réservation";
	}

}
