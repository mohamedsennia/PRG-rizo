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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel a = new JLabel("Avion");
		a.setBounds(24, 52, 46, 14);
		contentPane.add(a);
		
		Choice Avion = new Choice();
	
		k=0;
		Avion.setBounds(76, 46, 111, 20);
		for(int i=0;i<MainR.avions.size();i++) {
			if(MainR.avions.get(i).etat==Etat.Active) {
				Avion.add(MainR.avions.get(i).name);
				indexAv[k]=i;
				k=k+1;
			}
		}
		contentPane.add(Avion);
		
		l=0;
		Choice Aeroport = new Choice();
		Aeroport.setBounds(76, 141, 111, 20);
		Aeroport.setEnabled(b);
		for(int i=0;i<MainR.aeroports.size();i++) {
			if(MainR.aeroports.get(i).avions.size()<MainR.aeroports.get(i).capaciteAv) {
				Aeroport.add(MainR.aeroports.get(i).name);
				indexAero[l]=i;
				l=l+1;
			}
		}
		contentPane.add(Aeroport);
		
		JRadioButton maneul = new JRadioButton("MANUEL");
		maneul.setBounds(78, 101, 109, 23);
		maneul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(b==false) {
					b=true;
					Aeroport.setEnabled(b);
					
				}else {
					b=false;
					Aeroport.setEnabled(b);
				}
				
			}
			
		});
		contentPane.add(maneul);
		
		JLabel s = new JLabel("Aeroport");
		s.setBounds(10, 141, 46, 14);
		contentPane.add(s);
		
		
		Button Confirm = new Button("Reacheminer");
		Confirm.setBounds(179, 205, 70, 22);
		contentPane.add(Confirm);
		Confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(b==true) {
				for(int i=0;i<MainR.vols.size();i++) {
					
					
					if(MainR.vols.get(i).avion.GetName()==Avion.getSelectedItem()) {
						
						for(int j=0;j<MainR.aeroports.size();j++) {
							if(MainR.aeroports.get(j).name==Aeroport.getSelectedItem()) {
								
								MainR.vols.get(i).change(MainR.aeroports.get(j));
							}
						}
						//
					}
				}
			}else {
				
				int index=-1;
				double min=600000;
				for(int i=0;i<l;i++) {
					
					double distance=MainR.aeroports.get(indexAero[i]).localisation.distance(MainR.avions.get(indexAv[Avion.getSelectedIndex()]).position);
			
					if(distance<min) {
						min=distance;
						index=indexAero[i];
					}
				}
				System.out.println(index);
				for(int i=0;i<MainR.vols.size();i++) {
					if(MainR.vols.get(i).avion.GetName()==Avion.getSelectedItem()) {
						MainR.vols.get(i).change(MainR.aeroports.get(index));
					}
				}
			}
		}});
	}
}
