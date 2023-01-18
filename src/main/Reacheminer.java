package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Choice;
import javax.swing.JRadioButton;
import java.awt.Button;

public class Reacheminer extends JFrame {
	boolean b;
	int indexAv[],indexAero[];
	int l,k;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Reacheminer() {
		b=false;
		indexAv=new int[MainR.avions.size()];
		indexAero=new int[MainR.aeroports.size()];
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel a = new JLabel("Avion");
		a.setBounds(96, 55, 46, 14);
		contentPane.add(a);
		
		Choice Avion = new Choice();
	
		k=0;
		Avion.setBounds(162, 55, 111, 20);
		for(int i=0;i<MainR.avions.size();i++) {
			if(MainR.avions.get(i).etat==Etat.Active) {
				Avion.add(MainR.avions.get(i).name);
				indexAv[k]=i;
				k=k+1;
			}
		}
		contentPane.add(Avion);
		
		l=0;
		
		Button Confirm = new Button("Reacheminer");
		Confirm.setBounds(179, 116, 94, 22);
		contentPane.add(Confirm);
		Confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<MainR.avions.size();i++) {
					if(MainR.avions.get(i).name.equals(Avion.getSelectedItem())) {
						if(MainR.avions.get(i).restant<800) {
							double min =10000000;
							int indexMin=-1;
							for(int j=0;j<MainR.aeroports.size();j++) {
								if((MainR.avions.get(i).position.distance(MainR.aeroports.get(j).localisation)<min)&&MainR.aeroports.get(j).avions.size()<MainR.aeroports.get(j).capaciteAv){
									min=MainR.avions.get(i).position.distance(MainR.aeroports.get(j).localisation);
									indexMin=j;
								}
							}
							for(int j=0;j<MainR.vols.size();j++) {
								if(MainR.vols.get(j).avion.equals(Avion.getSelectedItem())) {
									MainR.vols.get(j).aeroportVisite.add(0,MainR.aeroports.get(indexMin));
									MainR.avions.get(i).setEtat(Etat.Standby);
								}
								}
						}else {
						for(int j=0;j<MainR.vols.size();j++) {
							if(MainR.vols.get(j).avion.equals(Avion.getSelectedItem())) {
								Point tempP=new Point(MainR.avions.get(i).getPosition().x,MainR.avions.get(i).getPosition().y);
								boolean b=false;
								if(MainR.avions.get(i).getPosition().x<MainR.vols.get(j).aeroportVisite.get(0).localisation.x) {
									tempP.y=tempP.y+40;
								
								}else {
									tempP.y=tempP.y-40;
									
								}
								
								if(MainR.avions.get(i).getPosition().y<MainR.vols.get(j).aeroportVisite.get(0).localisation.y) {
										tempP.x=tempP.x-40;
								}else {
										tempP.x=tempP.x+40;
								
								}
								
								MainR.vols.get(j).aeroportVisite.add(0,new Aeroport("temp",tempP,1));
								MainR.avions.get(i).setEtat(Etat.Standby);
							}
						}
						}}
				}
				
			c();}});
	}
	public void c() {
		this.setVisible(false);
		this.dispose();
	}
}
