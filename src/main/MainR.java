package main;

import java.awt.Color;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class MainR {
	static Main  m;
	static AjouterVol aj;
	static boolean b=false;
	static ArrayList<Aeroport> aeroports;
	static ArrayList<Vol> vols;
	static ArrayList<Avion> avions;
	static ArrayList<JLabel> avionR;
	static JLabel BackgroundImage;
	public static void main(String[] args)throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1126);
		RemoteMethodsImplementation rmi =new RemoteMethodsImplementation() ;
		Naming.rebind("rmi://localhost:1126/RMI",  rmi);
		
		aeroports=new ArrayList<Aeroport>();
		vols=new ArrayList<Vol>();
		avions=new ArrayList<Avion>();
		// TODO Auto-generated method stub
		
		 m=new Main();
			Point p1=new Point(73,177);
			Point p3=new Point(322,176);
			
			Point p2=new Point(220,27);
			Point p4=new Point(250,280);
			aeroports.add(new Aeroport("a1",p1,30));
			aeroports.add(new Aeroport("a2",p2,30));
			aeroports.add(new Aeroport("a3",p3,30));
			
			aeroports.add(new Aeroport("a4",p4,30));
			JLabel j;
			for(int i=0;i<aeroports.size();i++) {
				j=new JLabel("X");
				j.setForeground(Color.blue);
				j.setBounds(aeroports.get(i).localisation.x, aeroports.get(i).localisation.y, 46, 14);
				m.panel.add(j);
			}
			
		 BackgroundImage = new JLabel("");
		 BackgroundImage.setIcon(new ImageIcon(Main.class.getResource("/main/radar.png")));
		 BackgroundImage.setBounds(0, 0, 438, 461);
		m.panel.add(BackgroundImage);
		m.setVisible(true);
		 
	
		
	
	   avionR=new ArrayList<JLabel>();
		
		
		
	}

	
	public static int update(Point current,String avion,int vol,int restant) {
		 int B=0;
		int a=0;
		
			for(int i=0;i<avions.size();i++) {
			
				
				if(avions.get(i).name.equals(avion)) {
					
					avionR.get(i).setBounds(current.x, current.y, 46, 14);
					a=i;
					
					avions.get(a).setPosition(current);
					avions.get(a).restant=restant;
					if(vols.get(vol).aeroportVisite.get(0).localisation.distance(current)<5) {
					
						vols.get(vol).aeroportVisite.get(0).addAvion(avions.get(i).name);
						int needed=(avions.get(i).Capacite-restant);
						if(vols.get(vol).aeroportVisite.get(0).KeroR>needed) {
							vols.get(vol).aeroportVisite.get(0).KeroR=vols.get(vol).aeroportVisite.get(0).KeroR-(avions.get(i).Capacite-restant);
							avions.get(i).restant=avions.get(i).Capacite;
							if(avions.get(i).restant>800) {
								avionR.get(i).setForeground(Color.green);
							}
						}else {
							avions.get(i).restant=avions.get(i).restant+vols.get(vol).aeroportVisite.get(0).KeroR;
							vols.get(vol).aeroportVisite.get(0).KeroR=0;
							if(avions.get(i).restant>800) {
								avionR.get(i).setForeground(Color.green);
							}
							
						}
						
						if(vols.get(vol).aeroportVisite.size()>1) {
							vols.get(vol).aeroportVisite.get(0).removeAvion(avion);
						}
						vols.get(vol).aeroportVisite.remove(0);
							if(vols.get(vol).aeroportVisite.size()==0) {
								vols.remove(vol);
								return 1;
							}else {
								return 2;
							}
						
						
					}
					
				}else {
				if(avions.get(i).getEtat()==Etat.Active||avions.get(i).getEtat()==Etat.Broken) {
				double distance=current.distance(avions.get(i).getPosition());
				if(distance<10) {
				
					
					B=2;
				}else {
					if(distance<60) {
						
						B=1;
					}else {
						B=0;
}
				}
				}
				}
			}
			
			if(B==1||(avions.get(a).restant<800&&avions.get(a).restant>0)) {
				
				avionR.get(a).setForeground(Color.yellow);
			}else{
				if(B==2||avions.get(a).restant==0) {
					avionR.get(a).setForeground(Color.red);
					
					vols.get(vol).aeroportVisite.removeAll(vols.get(vol).aeroportVisite);
					avions.get(a).setEtat(Etat.Broken);
					return 3;
				}else {
				avionR.get(a).setForeground(Color.green);}
			}
			if(avions.get(a).etat.equals(Etat.Standby)) {
				return 2;
			}
			return 0;
	}
	public static void addAvion(Avion a) {
		avions.add(a);
	}
	public static void addAeroport(Aeroport aer) {
		aeroports.add(aer);
	}
	public static void addVol(Vol v) {
		vols.add(v);
		
		MainR.aj.dispose();
		
		v.start();
		
	}
	public static void addAvionR(Point position,String name) {
		
		avionR.add(new JLabel(name));
		avionR.get(avionR.size()-1).setForeground(Color.GREEN);
		
		avionR.get(avionR.size()-1).setBounds(position.x, position.y, 46, 14);
		JLabel j;
		for(int i=0;i<aeroports.size();i++) {
			j=new JLabel("X");
			j.setForeground(Color.blue);
			j.setBounds(aeroports.get(i).localisation.x, aeroports.get(i).localisation.y, 46, 14);
			m.panel.add(j);
		}
		
		m.panel.remove(BackgroundImage);
		m.panel.add(avionR.get(avionR.size()-1));
		m.panel.add(BackgroundImage);
		m.repaint();
		
		
	}

	public static Aeroport getAeroports(int i) {
		return aeroports.get(i);
	}
	
	public static Vol getVols(int i) {
		return vols.get(i);
	}
	

	
}
