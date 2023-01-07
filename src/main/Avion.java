package main;

public class Avion extends Thread {
String name;
int Capacité;
Etat etat;
int vitesse;
Point position;
public Avion(String name, int capacité, Etat etat, int vitesse,Point position) {
	super();
	this.name = name;
	Capacité = capacité;
	this.etat = etat;
	this.vitesse = vitesse;
	this.position=position;
	MainR.addAvionR(position,name);
}
public void start(float a,float b,int o,int index) {
	int distance;
	int time;
	
	int newX;
	int newY;
	
	etat=Etat.Active;
	try {
		
		do {
			
			if(a!=0||b!=0){
	  newX= (position.x+o);
		newY=(int)(a*newX+b);
		
			}else {
				newX=position.x;
				newY=(position.y+o);
			}
		
		
		distance=(int) ( Math.sqrt(Math.pow((newX-position.x),2)+Math.pow((newY-position.y),2)));
		
		time=(distance * 1000)/this.vitesse;
	
		Thread.sleep(time);
		
		position.x=newX;
		position.y=newY;
		
		
		MainR.update(position, name, index);
		
		}while(etat.equals(Etat.Active));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void end() {
	System.out.println(position);
	this.etat=Etat.Standby;
}

}
