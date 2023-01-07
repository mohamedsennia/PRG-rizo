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

	boolean f=false;
	LocalTime now;
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
	System.out.println("okeeeeeeey lesgo");
	float a;
	float b;
	if(avion.position.x!=aeroportVisite.get(0).localisation.x) {
		 a=((float)(aeroportVisite.get(0).localisation.y-avion.position.y)/(float)(aeroportVisite.get(0).localisation.x-avion.position.x));
		 b=((float)(-1*avion.position.x)*(aeroportVisite.get(0).localisation.y-avion.position.y)+avion.position.y*(aeroportVisite.get(0).localisation.x-avion.position.x))/(float)(aeroportVisite.get(0).localisation.x-avion.position.x);
	}else {
		 a=0;
		 b=0;
	}
	
	int i;
	for(i=0;i<MainR.vols.size();i++) {
		if(MainR.getVols(i).id.equals(this.id)){
			
			if(avion.position.x<aeroportVisite.get(0).localisation.x) {
			avion.start(a,b,1,i);
			}else {
				if(avion.position.x>aeroportVisite.get(0).localisation.x) {
					avion.start(a,b,-1,i);
				}else {
					if(avion.position.y<aeroportVisite.get(0).localisation.y) {
						avion.start(a,b,1,i);
					}else {
						avion.start(a,b,-1,i);
					}
				}
			}
		}
	}
	
	
}
}
