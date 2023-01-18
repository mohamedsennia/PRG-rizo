package main;

import java.util.ArrayList;

public class Aeroport {
	Point localisation;
	String name;
	int capaciteAv,KeroR,CapaciteKero;
	ArrayList<String> avions;
public Aeroport(String name,Point localisation,int capaciteAv) {
	this.localisation=new Point(localisation.x,localisation.y);;
	this.name=name;
	this.capaciteAv=capaciteAv;
	CapaciteKero=10000;
	this.KeroR=CapaciteKero;
	
	avions = new ArrayList<String> ();
}
public void addAvion(String a) {
	avions.add(a);
	
}
public void removeAvion(String a) {
	avions.remove(a);
}
}
