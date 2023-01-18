package main;


import java.time.LocalTime;
import java.util.ArrayList;

public class Vol extends Thread {
String id;
String avion;
Aeroport aeroportDpr;
ArrayList<Aeroport>aeroportVisite;
LocalTime heureDpt;
TypeVol type;

public Vol(String id, String avion, Aeroport aeroportDpr, ArrayList<Aeroport> aeroportVisite, LocalTime heureDpt,
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
	String av =this.avion;
	aeroportDpr.removeAvion(avion);
	
	/*while(f==false) {
		now=LocalTime.now();
		if(now.getHour()==heureDpt.getHour()&&now.getMinute()==heureDpt.getMinute()) {
			f=true;
			
		}else {
			try {
				
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	while(aeroportVisite.size()>0) {
		
			
		for(int j=0;j<MainR.avions.size();j++) {
			if(MainR.avions.get(j).name.equals(av)) {
				MainR.avions.get(j).etat=Etat.Active;
			}
		
		}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
}

public float[] launch(Point position) {
	// TODO Auto-generated method stub
	float[] h=new float[4];
	float a;
	float b;
	if(position.x!=aeroportVisite.get(0).localisation.x) {
		 a=((float)(aeroportVisite.get(0).localisation.y-position.y)/(float)(aeroportVisite.get(0).localisation.x-position.x));
		 b=((float)(-1*position.x)*(aeroportVisite.get(0).localisation.y-position.y)+position.y*(aeroportVisite.get(0).localisation.x-position.x))/(float)(aeroportVisite.get(0).localisation.x-position.x);
	}else {
		 a=0;
		 b=0;
	}
	
	int i;
	for(i=0;i<MainR.vols.size();i++) {
		
		if(MainR.getVols(i).id.equals(this.id)){
			
			if(position.x<aeroportVisite.get(0).localisation.x) {
			
		
			h[0]=a;
			h[1]=b;
			h[2]=1;
			h[3]=i;
	
			}else {
				if(position.x>aeroportVisite.get(0).localisation.x) {
					
				
					h[0]=a;
					h[1]=b;
					h[2]=-1;
					h[3]=i;
				}else {
					if(position.y<aeroportVisite.get(0).localisation.y) {
						
						
						h[0]=a;
						h[1]=b;
						h[2]=1;
						h[3]=i;
						
					}else {
						h[0]=a;
						h[1]=b;
						h[2]=-1;
						h[3]=i;
					
					}
				}
			}
		}
	}
	return h;
}

}
