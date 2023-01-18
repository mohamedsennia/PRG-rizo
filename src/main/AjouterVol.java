package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.Choice;
import java.awt.Scrollbar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Color;

public class AjouterVol extends JFrame implements ItemListener  {

	private JPanel contentPane;
	private JTextField id;
	Choice choiceAvion;
	Choice choiceArv;
	Choice choiceDpt;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AjouterVol() {
		
		JButton AjouterVol = new JButton("OK");
		JRadioButton escale = new JRadioButton("Escale");
		 choiceAvion = new Choice();
		 choiceArv = new Choice();
		
		AjouterVol.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 42, 28, 14);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(127, 39, 103, 20);
		contentPane.add(id);
		id.setColumns(10);
		
	
		choiceAvion.setBounds(127, 121, 103, 20);
		int i;
	
		for(int j=0;j<MainR.aeroports.get(0).avions.size();j++) {
		
			choiceAvion.add(MainR.aeroports.get(0).avions.get(j));
			
		}
		contentPane.add(choiceAvion);
		
		JLabel lblNewLabel_1 = new JLabel("Avion");
		lblNewLabel_1.setBounds(10, 121, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Aeroport de d\u00E9part");
		lblNewLabel_2.setBounds(10, 79, 111, 14);
		contentPane.add(lblNewLabel_2);
		
		 choiceDpt = new Choice();
		choiceDpt.setBounds(127, 79, 103, 20);
		for(i=0;i<MainR.aeroports.size();i++) {
			choiceDpt.add(MainR.aeroports.get(i).name);
		}
		choiceDpt.addItemListener(this);
		contentPane.add(choiceDpt);
		
		
		JLabel lblNewLabel_3 = new JLabel("Aeroport visit\u00E9");
		lblNewLabel_3.setBounds(10, 159, 93, 14);
		
		contentPane.add(lblNewLabel_3);
		
		
		choiceArv.setBounds(127, 159, 103, 20);
		/*for(i=0;i<MainR.aeroports.size();i++) {
			choiceArv.add(MainR.aeroports.get(i).name);
		}*/
		for(int j=0;j<MainR.aeroports.size();j++) {
			if(MainR.aeroports.get(j).capaciteAv>MainR.aeroports.get(j).avions.size()&&MainR.aeroports.get(j).name!=MainR.aeroports.get(0).name) {
				choiceArv.add(MainR.aeroports.get(j).name);
			}
		}
		contentPane.add(choiceArv);
		
		JLabel lblNewLabel_4 = new JLabel("Time");
		lblNewLabel_4.setBounds(10, 252, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		Choice choiceHeure = new Choice();
		choiceHeure.setBounds(122, 246, 46, 20);
		for(i=0;i<24;i++) {
			if(i<10) {
				choiceHeure.add("0"+Integer.toString(i));
			}else {
				choiceHeure.add(Integer.toString(i));
			}
		}
		contentPane.add(choiceHeure);
		
		JLabel lblNewLabel_5 = new JLabel("H");
		lblNewLabel_5.setBounds(174, 252, 14, 14);
		
		contentPane.add(lblNewLabel_5);
		
		Choice choiceMinute = new Choice();
		choiceMinute.setBounds(184, 246, 46, 20);
		for(i=0;i<60;i++) {
			if(i<10) {
				choiceMinute.add("0"+Integer.toString(i));
			}else {
				choiceMinute.add(Integer.toString(i));
			}
		}
		contentPane.add(choiceMinute);
		
		JLabel lblNewLabel_6 = new JLabel("M");
		lblNewLabel_6.setBounds(236, 252, 21, 14);
		contentPane.add(lblNewLabel_6);
		
	
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		
		list.setBackground(Color.WHITE);
		list.setBounds(385, 64, 166, 230);
		contentPane.add(list);
		
		JButton AjouterAero = new JButton("Ajouter");
		AjouterAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterVol.setEnabled(true);
				AjouterAero.setEnabled(MainR.b);
				model.addElement(choiceArv.getSelectedItem());
				if(model.size()>1) {
					escale.setEnabled(false);
				}
			}
		});
		AjouterAero.setBounds(251, 155, 89, 23);
		contentPane.add(AjouterAero);
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Aeroport visit\u00E9s");
		lblNewLabel_3_1.setBounds(386, 39, 93, 14);
		contentPane.add(lblNewLabel_3_1);

	
	
		escale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainR.b==false) {
					MainR.b=true;
					AjouterAero.setEnabled(MainR.b);
				}else {
					if(list.getModel().getSize()<2) {
						MainR.b=false;
						AjouterAero.setEnabled(MainR.b);
					}
				}
			}
		});
		escale.setBounds(127, 203, 103, 23);
		contentPane.add(escale);
		
		
		AjouterVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aeroport> aeroportVisite=new ArrayList<Aeroport>();
				for (int i=0;i<list.getModel().getSize();i++) {
					for(int j=0;j<MainR.aeroports.size();j++) {
						if(model.get(i)==MainR.aeroports.get(j).name) {
							
							aeroportVisite.add(MainR.aeroports.get(j));
						}
					}
				}
				
				
				//
				for(int i=0;i<MainR.aeroports.size();i++) {
					if(MainR.aeroports.get(i).name==choiceDpt.getSelectedItem()) {
						for(int j=0;j<MainR.avions.size();j++) {
							if(MainR.avions.get(j).name.equals(MainR.aeroports.get(i).avions.get(choiceAvion.getSelectedIndex()))) {
							MainR.avions.get(j).etat=Etat.Standby;}
						}
						MainR.addVol(new Vol(id.getText(),MainR.aeroports.get(i).avions.get(choiceAvion.getSelectedIndex()),MainR.aeroports.get(i),aeroportVisite,LocalTime.of(Integer.valueOf(choiceHeure.getSelectedItem()),Integer.valueOf(choiceMinute.getSelectedItem())),TypeVol.Direct));
					break;
					}
				}
				
				
			}
		});
		
		AjouterVol.setBounds(236, 314, 89, 23);
		contentPane.add(AjouterVol);
		
	}
	public void c() {
	this.setVisible(false);
		this.dispose();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		choiceAvion.removeAll();
		choiceArv.removeAll();
		for(int i=0;i<MainR.aeroports.size();i++) {
			
			if(MainR.aeroports.get(i).name==choiceDpt.getSelectedItem()) {
			
				for(int j=0;j<MainR.aeroports.get(i).avions.size();j++) {
					choiceAvion.add(MainR.aeroports.get(i).avions.get(j));
					choiceAvion.setEnabled(true);
					choiceArv.setEnabled(true);
				}
			}else {
				if(MainR.aeroports.get(i).capaciteAv>MainR.aeroports.get(i).avions.size()) {
					choiceArv.add(MainR.aeroports.get(i).name);
				}
				
			}
		}
	}
}
