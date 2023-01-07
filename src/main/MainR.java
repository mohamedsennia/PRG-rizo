package main;

import java.awt.Color;
import java.awt.Font;
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
	public static void main(String[] args) {
		
		aeroports=new ArrayList<Aeroport>();
		vols=new ArrayList<Vol>();
		avions=new ArrayList<Avion>();
		// TODO Auto-generated method stub
		
		 m=new Main();
		 BackgroundImage = new JLabel("");
		 BackgroundImage.setIcon(new ImageIcon(Main.class.getResource("/main/radar.png")));
		 BackgroundImage.setBounds(0, 0, 438, 461);
		m.panel.add(BackgroundImage);
		m.setVisible(true);
		 
	
		
		Point p1=new Point(73,177);
		Point p3=new Point(322,176);
		
		Point p2=new Point(220,27);
		Point p4=new Point(250,280);
	   avionR=new ArrayList<JLabel>();
		aeroports.add(new Aeroport("a1",p1));
		avions.add((new Avion("av1",5000,Etat.Standby,30,p1)));
		aeroports.add(new Aeroport("a3",p3));
		aeroports.add(new Aeroport("a2",p2));
		aeroports.add(new Aeroport("a4",p4));
		avions.add((new Avion("av2",5000,Etat.Standby,2,p2)));
	
	}

	
	public static void update(Point current,String avion,int vol) {
		
	
			for(int i=0;i<avions.size();i++) {
			
				
				if(avions.get(i).name==avion) {
					avionR.get(i).setBounds(current.x, current.y, 46, 14);
					if(vols.get(vol).aeroportVisite.get(0).localisation.x==current.x&&vols.get(vol).aeroportVisite.get(0).localisation.y==current.y) {
						avions.get(i).end();
						
						if(vols.get(vol).aeroportVisite.size()>1) {
							vols.get(vol).aeroportVisite.remove(0);
							vols.get(vol).run();
						}
						
					}
					
				}else {
				double distance=Math.sqrt(Math.pow(current.x-(avions.get(i).position.x), 2)+Math.pow(current.x-(avions.get(i).position.x), 2));
				if(distance<3) {
					avionR.get(i).setForeground(Color.red);
					
				}
				}
			}
		
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
		m.panel.remove(BackgroundImage);
		m.panel.add(avionR.get(avionR.size()-1));
		m.panel.add(BackgroundImage);
		
		
		
	}

	public static Aeroport getAeroports(int i) {
		return aeroports.get(i);
	}
	
	public static Vol getVols(int i) {
		return vols.get(i);
	}
	
	public static Avion getAvions(int i) {
		return avions.get(i);
	}
	
}
