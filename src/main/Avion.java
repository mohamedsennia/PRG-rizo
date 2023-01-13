package main;

public class Avion extends Thread {
String name;
int Capacite;
Etat etat;
int vitesse;
Point position;
public Avion(String name, int Capacite, Etat etat, int vitesse,Point position) {
	super();
	this.name = name;
	this.Capacite = Capacite;
	this.etat = etat;
	this.vitesse = vitesse;
	this.position=new Point(position.x,position.y);
	MainR.addAvionR(position,name);
}
public int getCapacite() {
	return Capacite;
}
public void setCapacite(int capacite) {
	Capacite = capacite;
}
public String GetName() {
	return name;
}
public void SetName(String name) {
	this.name = name;
}
public Etat getEtat() {
	return etat;
}
public void setEtat(Etat etat) {
	this.etat = etat;
}
public int getVitesse() {
	return vitesse;
}
public void setVitesse(int vitesse) {
	this.vitesse = vitesse;
}
public Point getPosition() {
	return position;
}
public void setPosition(Point position) {
	this.position = position;
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
		
		this.position.x=newX;
		this.position.y=newY;
		
		this.Capacite=this.Capacite-20;
		MainR.update(this.position, name, index);
		
		}while(etat.equals(Etat.Active));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void end() {
	
	this.etat=Etat.Idel;
}
public void crash() {
	this.etat=Etat.Broken;
}
}
