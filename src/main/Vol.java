package main;


import java.time.LocalTime;
import java.util.ArrayList;

public class Vol extends Thread {
String id;
Avion avion;
Aeroport aeroportDpr;
ArrayList<Aeroport>aeroportVisite;
LocalTime heureDpt,heureArv;
TypeVol type;
String etat;
public Vol(String id, Avion avion, Aeroport aeroportDpr, ArrayList<Aeroport> aeroportVisite, LocalTime heureDpt,
		 TypeVol type) {
	super();
	this.id = id;
	this.avion = avion;
	this.aeroportDpr = aeroportDpr;
	this.aeroportVisite = aeroportVisite;
	this.heureDpt = heureDpt;
	
	this.type = type;
}
public void run() {
	this.etat="planned";
	boolean f=false;
	LocalTime now;
	avion.setEtat(Etat.Standby);
	/*while(f==false) {
		now=LocalTime.now();
		if(now.getHour()==heureDpt.getHour()&&now.getMinute()==heureDpt.getMinute()) {
			f=true;
			
		}else {
			try {
				System.out.println("waiting");
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	System.out.println(aeroportDpr.localisation);
	while(aeroportVisite.size()>0) {
		
		
			
			launch();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	System.out.println(aeroportDpr.localisation);
}
private void launch() {
	// TODO Auto-generated method stub
	
	float a;
	float b;
	if(avion.getPosition().x!=aeroportVisite.get(0).localisation.x) {
		 a=((float)(aeroportVisite.get(0).localisation.y-avion.getPosition().y)/(float)(aeroportVisite.get(0).localisation.x-avion.getPosition().x));
		 b=((float)(-1*avion.getPosition().x)*(aeroportVisite.get(0).localisation.y-avion.getPosition().y)+avion.getPosition().y*(aeroportVisite.get(0).localisation.x-avion.getPosition().x))/(float)(aeroportVisite.get(0).localisation.x-avion.getPosition().x);
	}else {
		 a=0;
		 b=0;
	}
	
	int i;
	for(i=0;i<MainR.vols.size();i++) {
		
		if(MainR.getVols(i).id.equals(this.id)){
			
			if(avion.position.x<aeroportVisite.get(0).localisation.x) {
			
			avion.start(a,b,1,i);
			aeroportDpr.removeAvion(avion);
			}else {
				if(avion.position.x>aeroportVisite.get(0).localisation.x) {
					
					avion.start(a,b,-1,i);
					aeroportDpr.removeAvion(avion);
				}else {
					if(avion.position.y<aeroportVisite.get(0).localisation.y) {
						
						avion.start(a,b,1,i);
						aeroportDpr.removeAvion(avion);
					}else {
						
						avion.start(a,b,-1,i);
						aeroportDpr.removeAvion(avion);
					}
				}
			}
		}
	}
	
}
public void change(Aeroport aeroportPause) {
	
	this.avion.end();
	this.aeroportVisite.add(0,aeroportPause);

	this.etat="planned";
}
}
