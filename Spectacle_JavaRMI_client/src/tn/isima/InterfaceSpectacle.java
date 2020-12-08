package tn.isima;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceSpectacle extends Remote {
	public String consulter()throws RemoteException;
	public String reserver(int p) throws RemoteException;
}