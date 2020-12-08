package tn.isima;
import java.io.Serializable;

public class MessageInfo implements Serializable {

	public static final long serialVersionUID = 52L;

	public int totalMessages;
	public int messageNum;

	public MessageInfo(int total, int msgNum) {
		totalMessages = total;
		messageNum = msgNum;
	}



}