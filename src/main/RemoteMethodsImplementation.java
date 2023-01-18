package main;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JLabel;

public class RemoteMethodsImplementation extends UnicastRemoteObject  implements RemoteMethods {
protected RemoteMethodsImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Point[] listA() {
		// TODO Auto-generated method stub
		Point [] A= new Point[MainR.aeroports.size()];
		for(int i=0;i<MainR.aeroports.size();i++) {
			A[i]=MainR.aeroports.get(i).localisation;
		}
		return A;
	}

	@Override
	public int newAvion(String name,int capacite,Etat etat,int vitesse,Point position) {
		// TODO Auto-generated method stub
		for(int i=0;i<MainR.avions.size();i++) {
			if(MainR.avions.get(i).name.equals(name)) {
				return 0;
			}
		}
		for(int i=0;i<MainR.aeroports.size();i++) {
			if(position.equals(MainR.aeroports.get(i).localisation)) {
				MainR.aeroports.get(i).addAvion(name);
			}
		}
		MainR.avions.add(new Avion(name,capacite,etat,vitesse,position));
		MainR.m.repaint();
		return 1;
		
	}

	@Override
	public Etat waiting(String name) {
		// TODO Auto-generated method stub
		for(int i=0;i<MainR.avions.size();i++) {
			if(MainR.avions.get(i).name.equals(name)) {
				return MainR.avions.get(i).etat;
			}
		}
		
		return null;
	}

	@Override
	public float[] request(String name,Point position) {
		// TODO Auto-generated method stub
		for(int i=0;i<MainR.vols.size();i++) {
			if(MainR.vols.get(i).avion.equals(name)) {
				return MainR.vols.get(i).launch(position);
			}
		}
		return null;
	}
	public int update(Point position,String name,int i,int capacite)throws RemoteException{
		return  MainR.update(position, name, i,capacite);
		 
		 
	}


	@Override
	public int getR(String name) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i=0;i<MainR.avions.size();i++) {
			if(MainR.avions.get(i).name.equals(name)) {
				return MainR.avions.get(i).restant;
			}
		}
		return 0;
	}
}
