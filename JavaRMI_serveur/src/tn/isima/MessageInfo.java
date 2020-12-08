package tn.isima;
import java.io.Serializable;
import java.rmi.RemoteException;

public class MessageInfo implements Serializable {

	public static final long serialVersionUID = 52L;

	public int totalMessages;
	public int messageNum;


	public MessageInfo(int total, int msgNum) {
		totalMessages = total;
		messageNum = msgNum;
	}
	public String toString(){
		return new String("C'est un traitement chez le serveur que vous croyez qu'il se fait en local chez le client "+totalMessages+";"+messageNum+"\n");
	}


}