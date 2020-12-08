import java.io.Serializable;
import java.util.ArrayList;

public class Spectacle implements Serializable {

	public static final long serialVersionUID = 52L;

	int nb_place;
	String intitule;
	public ArrayList<Spectacle> spec=new ArrayList<Spectacle>();

	public void init() {
		
		Spectacle s= new Spectacle();
		s.intitule="La bête et la belle";
		s.nb_place=10;
		this.spec.add(s);
		Spectacle s1= new Spectacle();
		s1.intitule="Blanche Neige";
		s1.nb_place=12;
		this.spec.add(s1);
	}

	
	public String toString(){
		String s="";
		 for(int i=0;i<this.spec.size();i++) 
			 s=s+"le nom du spectacle : "+this.spec.get(i).intitule+" ------- le nombre de places\n"+this.spec.get(i).nb_place+"\n";
		 return s;
	}


}