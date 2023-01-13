package main;

import java.util.ArrayList;

public class Aeroport {
	Point localisation;
	String name;
	int capaciteAv,KeroR;
	ArrayList<Avion> avions;
public Aeroport(String name,Point localisation,int capaciteAv) {
	this.localisation=new Point(localisation.x,localisation.y);;
	this.name=name;
	this.capaciteAv=capaciteAv;
	this.KeroR=3000;
	
	avions = new ArrayList<Avion> ();
}
public void addAvion(Avion a) {
	avions.add(a);
	
}
public void removeAvion(Avion a) {
	avions.remove(a);
}
}
