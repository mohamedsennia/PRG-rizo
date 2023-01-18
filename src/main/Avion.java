	package main;

public class Avion  {
String name;
int Capacite;
int restant;
Etat etat;
int vitesse;
Point position;
public Avion(String name, int Capacite, Etat etat, int vitesse,Point position) {
	super();
	this.name = name;
	this.Capacite = Capacite;
	this.etat = etat;
	this.vitesse = vitesse;
	restant=this.Capacite;
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

}
