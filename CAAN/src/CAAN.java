import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Vector;
import java.security.acl.Group;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;


public class CAAN extends JFrame {

	static Connection conn = Utilitaire.getConnection();
	static JFrame App = new JFrame("Bibliotheque CAAN");
	ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
	
	
	//methods
	private JTable table;
	
	public void Clients(int type, String val) {
		
		
			try {
				String query = "{CALL ChercherClient(?,?)}";
				CallableStatement stm = conn.prepareCall(query);
				stm.setInt(1, type);
				stm.setString(2, val);
				ResultSet rs = stm.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			   }
				catch(Exception exe) {
					exe.printStackTrace();
				}
			
	}
	
	public void ClientsId(int id) {
		
		
		try {
			String query = "{CALL ChercherClientId(?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
		
}
	
	public void afficherClient(){
		try {
			String query = "{CALL AfficherClients()}";
			CallableStatement stm = conn.prepareCall(query);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}

	
	public void chercherExemplaireParIDE(int id)
	{
		try {
			String query = "{CALL ChercherExemplaire(?,?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, 1);
			stm.setInt(2, id);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public void chercherExemplaireParIDL(int id)
	{
		try {
			String query = "{CALL ChercherExemplaire(?,?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, 2);
			stm.setInt(2, id);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	public void chercherExemplairePardispo(int dispo)
	{
		try {
			String query = "{CALL ChercherExemplaire(?,?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, 3);
			stm.setInt(2, dispo);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	public void chercherExemplaireParIDLetDispo(int id, int dispo)
	{
		try {
			String query = "{CALL ChercherExemplaireLD(?,?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, id);
			stm.setInt(2, dispo);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	

	
	
	public void afficherExemplaire()
	{
		try {
			String query = "{CALL AfficherExemplaires()}";
			CallableStatement stm = conn.prepareCall(query);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public void afficherLesOffres() {
			
			try {
				Connection conn = Utilitaire.getConnection();
				CallableStatement ps =conn.prepareCall("{call afficherOffre()} ");
				ResultSet rs = ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			   }
				catch(Exception exe) {
					exe.printStackTrace();
				}
		}
	
	public void chercherLivreParID(int type, int id)
	{
		try {
			String query = "{CALL ChercherLivre(?,?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, type);
			stm.setInt(2, id);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public void chercherLivreParNom(String nom)
	{
		try {
			String query = "{CALL ChercherLivre(?,?)}";
			CallableStatement stm = conn.prepareCall(query);
			stm.setInt(1, 2);
			stm.setString(2, nom);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public void AfficherLivre()
	{
		try {
			String query = "{CALL AfficherLivre()}";
			CallableStatement stm = conn.prepareCall(query);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public void AfficherCategorie()
	{
		try {
			String query = "{CALL AfficherCategorie()}";
			CallableStatement stm = conn.prepareCall(query);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public void AfficherAuteur()
	{
		try {
			String query = "{CALL AfficherAuteur()}";
			CallableStatement stm = conn.prepareCall(query);
			ResultSet rs = stm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		   }
			catch(Exception exe) {
				exe.printStackTrace();
			}
	}
	
	public CAAN() {
		App.setIconImage(icon.getImage());
		App.setSize(1034, 700);
		App.getContentPane().setLayout(null);
		App.setVisible(true);
		
		// ------------- MENU BAR --------------------
		
		JMenuBar mbar = new JMenuBar();
		JMenu File = new JMenu("File");
		JMenuItem Li = new JMenuItem("Livre");
		JMenu Emp = new JMenu("Emprunt");
		JMenuItem Emp1 = new JMenuItem("Emprunt");
		JMenuItem Cl = new JMenuItem("Client");
		JMenuItem Ex = new JMenuItem("Exemplaire");
		JMenuItem Of = new JMenuItem("Offre");
		JMenuItem Exit = new JMenuItem("Exit");
		
		
		mbar.setBackground(Color.WHITE);
		mbar.add(File);
		mbar.add(Emp);
		File.add(Cl);
		File.add(Ex);
		File.add(Li);
		File.add(Of);
		File.add(Exit);
		Emp.add(Emp1);
		
	
		
		
		
		
		App.setJMenuBar(mbar);
		
		// --------------------------------------------
		
		// -------- INSTALLING ALL PANELS ----------------
		
		JPanel Home = new JPanel();
		Home.setBounds(0, 0, 1034, 640);
		App.getContentPane().add(Home);
		GroupLayout gl_Home = new GroupLayout(Home);
		gl_Home.setHorizontalGroup(
			gl_Home.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_Home.setVerticalGroup(
			gl_Home.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		Home.setLayout(gl_Home);
		Home.setVisible(true);
		
		
		JPanel Client = new JPanel();
		Client.setBounds(0, 0, 1034, 640);
		Client.setBackground(Color.white);
		Client.setVisible(false);
		App.getContentPane().add(Client);
		GroupLayout gl_Client = new GroupLayout(Client);
		gl_Client.setHorizontalGroup(
			gl_Client.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_Client.setVerticalGroup(
			gl_Client.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		Client.setLayout(gl_Client);
		
		
		JPanel Exemplaire = new JPanel();
		Exemplaire.setBounds(0, 0, 1034, 640);
		Exemplaire.setBackground(Color.white);
		App.getContentPane().add(Exemplaire);
		GroupLayout gl_Exemplaire = new GroupLayout(Exemplaire);
		gl_Exemplaire.setHorizontalGroup(
			gl_Exemplaire.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_Exemplaire.setVerticalGroup(
			gl_Exemplaire.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		Exemplaire.setLayout(gl_Exemplaire);
		Exemplaire.setVisible(false);
		
		JPanel Offre = new JPanel();
		Offre.setBounds(0, 0, 1034, 640);
		Offre.setBackground(Color.white);
		App.getContentPane().add(Offre);
		GroupLayout gl_Offre = new GroupLayout(Offre);
		gl_Offre.setHorizontalGroup(
				gl_Offre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_Offre.setVerticalGroup(
				gl_Offre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		Offre.setLayout(gl_Offre);
		Offre.setVisible(false);
		
		JPanel Emprunt = new JPanel();
		Emprunt.setBounds(0, 0, 1034, 640);
		Emprunt.setBackground(Color.white);
		App.getContentPane().add(Emprunt);
		GroupLayout gl_Emprunt = new GroupLayout(Emprunt);
		gl_Emprunt.setHorizontalGroup(
				gl_Emprunt.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_Emprunt.setVerticalGroup(
				gl_Emprunt.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		Emprunt.setLayout(gl_Emprunt);
		Emprunt.setVisible(false);
		
		
		JPanel CLE = new JPanel();
		CLE.setBounds(0, 0, 1034, 640);
		CLE.setBackground(Color.white);
		App.getContentPane().add(CLE);
		GroupLayout gl_CLE = new GroupLayout(CLE);
		gl_CLE.setHorizontalGroup(
				gl_CLE.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_CLE.setVerticalGroup(
				gl_CLE.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		CLE.setLayout(gl_CLE);
		CLE.setVisible(false);
		
		JPanel Livre = new JPanel();
		Livre.setBounds(0, 0, 1034, 640);
		Livre.setBackground(Color.white);
		App.getContentPane().add(Livre);
		GroupLayout gl_Livre = new GroupLayout(Livre);
		gl_Livre.setHorizontalGroup(
				gl_Livre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 864, Short.MAX_VALUE)
		);
		gl_Livre.setVerticalGroup(
				gl_Livre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		Livre.setLayout(gl_Livre);
		Livre.setVisible(false);
		
		// -------------------------------------------------
		
		// ------------- HOME PAGE ----------------
		
		JLabel homeImage = new JLabel();
		homeImage.setBounds(0,0,1049,700);
		homeImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("home.png")));
		Home.add(homeImage);		
		
		JButton GestionButton = new JButton();
		GestionButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Gestion.png")));
		GestionButton.setBounds(100,300,200,250);
		GestionButton.setOpaque(false);
		GestionButton.setContentAreaFilled(false);
		GestionButton.setBorderPainted(false);
		homeImage.add(GestionButton);		
		
		JButton EmprButton = new JButton();
		EmprButton.setBounds(425,300,169,260);
		EmprButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("emprunt1.png")));
		EmprButton.setOpaque(false);
		EmprButton.setContentAreaFilled(false);
		EmprButton.setBorderPainted(false);
		homeImage.add(EmprButton);	
		
		JButton chercheButton = new JButton();
		chercheButton.setBounds(750,300,170,287);
		chercheButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("chercher1.png")));
		chercheButton.setOpaque(false);
		chercheButton.setContentAreaFilled(false);
		chercheButton.setBorderPainted(false);
		homeImage.add(chercheButton);
		

		// -----------Gestion biblio-------------------
		
		JButton homeback = new JButton();
		homeback.setBounds(45,10,65,65);
		homeback.setIcon(new ImageIcon(getClass().getClassLoader().getResource("back.png")));
		homeback.setOpaque(false);
		homeback.setContentAreaFilled(false);
		homeback.setBorderPainted(false);
		homeback.setVisible(false);
		homeImage.add(homeback);
		
		
		JButton glogoB = new JButton();
		glogoB.setBounds(500,270,77,80);
		glogoB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gestion-logo.png")));
		glogoB.setOpaque(false);
		glogoB.setContentAreaFilled(false);
		glogoB.setBorderPainted(false);
		glogoB.setVisible(false);
		homeImage.add(glogoB);
		
		JButton ClientB = new JButton();
		ClientB.setBounds(100,350,126,200);
		ClientB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("client.png")));
		ClientB.setOpaque(false);
		ClientB.setContentAreaFilled(false);
		ClientB.setBorderPainted(false);
		ClientB.setVisible(false);
		homeImage.add(ClientB);
		
		JLabel ClientL = new JLabel("Client");
		ClientL.setBounds(125,550,150,50);
		ClientL.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		ClientL.setForeground(Color.white);
		ClientL.setVisible(false);
		homeImage.add(ClientL);
		
		
		JButton LivreB = new JButton();
		LivreB.setBounds(350,375,114,160);
		LivreB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("livre.png")));
		LivreB.setOpaque(false);
		LivreB.setContentAreaFilled(false);
		LivreB.setBorderPainted(false);
		LivreB.setVisible(false);
		homeImage.add(LivreB);
		
		JLabel LivreL = new JLabel("Livre");
		LivreL.setBounds(375,550,150,50);
		LivreL.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		LivreL.setForeground(Color.white);
		LivreL.setVisible(false);
		homeImage.add(LivreL);
		
		JButton ExemplaireB = new JButton();
		ExemplaireB.setBounds(570,380,114,160);
		ExemplaireB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exemplaire.png")));
		ExemplaireB.setOpaque(false);
		ExemplaireB.setContentAreaFilled(false);
		ExemplaireB.setBorderPainted(false);
		ExemplaireB.setVisible(false);
		homeImage.add(ExemplaireB);
		
		JLabel ExemplaireL = new JLabel("Exemplaires");
		ExemplaireL.setBounds(570,550,150,50);
		ExemplaireL.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		ExemplaireL.setForeground(Color.white);
		ExemplaireL.setVisible(false);
		homeImage.add(ExemplaireL);
		
		JButton OffreB = new JButton();
		OffreB.setBounds(800,380,126,160);
		OffreB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("offre.png")));
		OffreB.setOpaque(false);
		OffreB.setContentAreaFilled(false);
		OffreB.setBorderPainted(false);
		OffreB.setVisible(false);
		homeImage.add(OffreB);
		
		JLabel OffreL = new JLabel("Offre");
		OffreL.setBounds(840,550,150,50);
		OffreL.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		OffreL.setForeground(Color.white);
		OffreL.setVisible(false);
		homeImage.add(OffreL);
		
	
	
		GestionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GestionButton.setVisible(false);
				EmprButton.setVisible(false);
				chercheButton.setVisible(false);
				
				homeback.setVisible(true);
				glogoB.setVisible(true);
				ClientB.setVisible(true);
				ClientL.setVisible(true);
				ExemplaireB.setVisible(true);
				ExemplaireL.setVisible(true);
				LivreB.setVisible(true);
				LivreL.setVisible(true);
				OffreB.setVisible(true);
				OffreL.setVisible(true);
				
			}
		});
		
		homeback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GestionButton.setVisible(true);
				EmprButton.setVisible(true);
				chercheButton.setVisible(true);
				
				homeback.setVisible(false);
				glogoB.setVisible(false);
				ClientB.setVisible(false);
				ClientL.setVisible(false);
				ExemplaireB.setVisible(false);
				ExemplaireL.setVisible(false);
				LivreB.setVisible(false);
				LivreL.setVisible(false);
				OffreB.setVisible(false);
				OffreL.setVisible(false);
				
			}
		});
		
		
		// -------------------------- Page Client ----------------------------
		
		JLabel ClientImage = new JLabel();
		ClientImage.setBounds(0,0,1049,700);
		ClientImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("background.png")));
		Client.add(ClientImage);
		
		JLabel clientTtitleLabel = new JLabel("CLIENT");
		clientTtitleLabel.setFont(new Font("Liberation Serif", Font.BOLD, 26));
		clientTtitleLabel.setBounds(460, 10, 200, 30);
		ClientImage.add(clientTtitleLabel);
		
		JButton startClient = new JButton(new ImageIcon(getClass().getClassLoader().getResource("go.png")));
		startClient.setBounds(970,585,50,50);
		startClient.setOpaque(false);
		startClient.setContentAreaFilled(false);
		startClient.setBorderPainted(false);
		startClient.setEnabled(false);
		ClientImage.add(startClient);
		
		JButton backClient = new JButton(new ImageIcon(getClass().getClassLoader().getResource("back2.png")));
		backClient.setBounds(10,585,50,50);
		backClient.setOpaque(false);
		backClient.setContentAreaFilled(false);
		backClient.setBorderPainted(false);
		ClientImage.add(backClient);
		
		backClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Home.setVisible(true);
				
			}
		});
		
		// Ajouter Client
		
		JRadioButton addClientRB = new JRadioButton("Ajouter un Client");
		addClientRB.setBounds(5,30,250,30);
		addClientRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		addClientRB.setSelected(true);
		addClientRB.setOpaque(false);
		addClientRB.setContentAreaFilled(false);
		addClientRB.setBorderPainted(false);
		ClientImage.add(addClientRB);
		
		JLabel nomClientL = new JLabel("Nom :");
		nomClientL.setBounds(20, 70, 50, 30);
		nomClientL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(nomClientL);
		
		JTextField nomClientT = new JTextField();
		nomClientT.setBounds(120, 70, 250, 30);
		nomClientT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(nomClientT);
		
		JLabel prenomClientL = new JLabel("Prenom :");
		prenomClientL.setBounds(20, 110, 80, 30);
		prenomClientL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(prenomClientL);
		
		JTextField prenomClientT = new JTextField();
		prenomClientT.setBounds(120, 110, 250, 30);
		prenomClientT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(prenomClientT);
		
		JLabel adresseClientL = new JLabel("Adresse :");
		adresseClientL.setBounds(20, 150, 80, 30);
		adresseClientL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(adresseClientL);
		
		JTextField adresseClientT = new JTextField();
		adresseClientT.setBounds(120, 150, 250, 30);
		adresseClientT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(adresseClientT);
		
		JLabel teleClientL = new JLabel("Telephone :");
		teleClientL.setBounds(20, 190, 100, 30);
		teleClientL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(teleClientL);
		
		JTextField teleClientT = new JTextField();
		teleClientT.setBounds(120, 190, 250, 30);
		teleClientT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(teleClientT);
		
		JButton applyClientB = new JButton();
		applyClientB.setBounds(445,95,96,96);
		applyClientB.setIcon(new ImageIcon(getClass().getClassLoader().getResource("right-arrow.png")));
		applyClientB.setOpaque(false);
		applyClientB.setContentAreaFilled(false);
		applyClientB.setBorderPainted(false);
		ClientImage.add(applyClientB);
		
		JLabel Clientinfo = new JLabel("-- verification des informations --");
		Clientinfo.setBounds(650,30,300,30);
		Clientinfo.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(Clientinfo);
		
		JLabel nomClientLV = new JLabel("Nom :");
		nomClientLV.setBounds(600, 70, 50, 30);
		nomClientLV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(nomClientLV);
		
		JTextField nomClientTV = new JTextField();
		nomClientTV.setBounds(700, 70, 250, 30);
		nomClientTV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		nomClientTV.setEnabled(false);
		ClientImage.add(nomClientTV);
		
		JLabel prenomClientLV = new JLabel("Prenom :");
		prenomClientLV.setBounds(600, 110, 80, 30);
		prenomClientLV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(prenomClientLV);
		
		JTextField prenomClientTV = new JTextField();
		prenomClientTV.setBounds(700, 110, 250, 30);
		prenomClientTV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		prenomClientTV.setEnabled(false);
		ClientImage.add(prenomClientTV);
		
		JLabel adresseClientLV = new JLabel("Adresse :");
		adresseClientLV.setBounds(600, 150, 80, 30);
		adresseClientLV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(adresseClientLV);
		
		JTextField adresseClientTV = new JTextField();
		adresseClientTV.setBounds(700, 150, 250, 30);
		adresseClientTV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		adresseClientTV.setEnabled(false);
		ClientImage.add(adresseClientTV);
		
		JLabel teleClientLV = new JLabel("Telephone :");
		teleClientLV.setBounds(600, 190, 100, 30);
		teleClientLV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(teleClientLV);
		
		JTextField teleClientTV = new JTextField();
		teleClientTV.setBounds(700, 190, 250, 30);
		teleClientTV.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		teleClientTV.setEnabled(false);
		ClientImage.add(teleClientTV);
		
		
		applyClientB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean done = false;
				String nom = nomClientT.getText().toString();
				String prenom = prenomClientT.getText().toString();
				String adresse = adresseClientT.getText().toString();
				String tele = teleClientT.getText().toString();
				try {
					int telephone = Integer.parseInt(tele);
				if(!nom.equals("") && !prenom.equals("") && !adresse.equals("") && !tele.equals(""))
				{
					nomClientTV.setText(nom);
					prenomClientTV.setText(prenom);
					adresseClientTV.setText(adresse);
					teleClientTV.setText(tele);
					done = true;
				}
				else
				{
					JOptionPane.showMessageDialog(App, "Il y\' une ou plusieur zone(s) vide, verifer les inputes");
					done = false;
				}
				if(done == true)
					startClient.setEnabled(true);
				else
					startClient.setEnabled(false);
			}catch (Exception q) {
				JOptionPane.showMessageDialog(App, "Telephone accepte juste les entiers");
				startClient.setEnabled(false);
			}
			}
		});
		
		//Chercher Client
				
		JRadioButton chercherClientRB = new JRadioButton("Chercher un Client");
		chercherClientRB.setBounds(5,230,250,30);
		chercherClientRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		chercherClientRB.setOpaque(false);
		chercherClientRB.setContentAreaFilled(false);
		chercherClientRB.setBorderPainted(false);
		ClientImage.add(chercherClientRB);
		
		JLabel chercher = new JLabel("Chercher par :");
		chercher.setBounds(20, 270, 150, 30);
		chercher.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(chercher);
		
		JComboBox<String> typeRecherche = new JComboBox<>();
		typeRecherche.addItem("");
		typeRecherche.addItem("Id");
		typeRecherche.addItem("Nom");
		typeRecherche.addItem("Prenom");
		typeRecherche.addItem("Adresse");
		typeRecherche.addItem("Telephone");
		typeRecherche.setBounds(150, 270, 100, 30);
		typeRecherche.setBackground(Color.white);
		typeRecherche.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		ClientImage.add(typeRecherche);
		
		JLabel chercher1 = new JLabel("Chercher :");
		chercher1.setBounds(300, 270, 150, 30);
		chercher1.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(chercher1);
		
		JTextField sercheVal = new JTextField();
		
		JTextField textserchT = new JTextField();
		textserchT.setBounds(400, 270, 250, 30);
		textserchT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(textserchT);
		
		JButton ApplyserchB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyserchB.setBounds(660, 270, 50, 30);
		ApplyserchB.setOpaque(false);
		ApplyserchB.setContentAreaFilled(false);
		ApplyserchB.setBorderPainted(false);
		ClientImage.add(ApplyserchB);
		
		ApplyserchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String type = typeRecherche.getSelectedItem().toString();
				String text = textserchT.getText().toString();
				try {
					if(type.equals("Id") || type.equals("Telephone"))
					{
						int entier = Integer.parseInt(text);
						
						done += 1;
						sercheVal.setText(text);
					}else
					{
						done += 1;
						sercheVal.setText(text);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Inserer des entiers");
					done = 0;
				}
				if(type.equals(""))
					JOptionPane.showMessageDialog(App, "Selectionner une type de recherche");
				else
					done += 1;
					
				if(text.equals(""))
					JOptionPane.showMessageDialog(App, "La zone de recherche est vide");
				else
					done += 1;
				if(done == 3)
					startClient.setEnabled(true);
				else
					startClient.setEnabled(false);
			}
		});
		
		// Modifier un Client
		
		JRadioButton updateClientRB = new JRadioButton("Modifier les informations d\'un Client");
		updateClientRB.setBounds(5,310,450,30);
		updateClientRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		updateClientRB.setOpaque(false);
		updateClientRB.setContentAreaFilled(false);
		updateClientRB.setBorderPainted(false);
		ClientImage.add(updateClientRB);
		
		JLabel updateIdL = new JLabel("L\'Id du Client: ");
		updateIdL.setBounds(20, 350, 150, 30);
		updateIdL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(updateIdL);
		
		JTextField updateIdT = new JTextField();
		updateIdT.setBounds(150, 350, 100, 30);
		updateIdT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(updateIdT);
		
		JButton ApplyUpdateIdB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyUpdateIdB.setBounds(260, 350, 50, 30);
		ApplyUpdateIdB.setOpaque(false);
		ApplyUpdateIdB.setContentAreaFilled(false);
		ApplyUpdateIdB.setBorderPainted(false);
		ClientImage.add(ApplyUpdateIdB);
		
		JLabel modifer = new JLabel("Modifier :");
		modifer.setBounds(20, 390, 80, 30);
		modifer.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(modifer);
		
		JComboBox<String> typeupdate = new JComboBox<>();
		typeupdate.addItem("");
		typeupdate.addItem("Nom");
		typeupdate.addItem("Prenom");
		typeupdate.addItem("Adresse");
		typeupdate.addItem("Telephone");
		typeupdate.setBounds(110, 390, 100, 30);
		typeupdate.setBackground(Color.white);
		typeupdate.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		ClientImage.add(typeupdate);
		
		JLabel newValueL = new JLabel("La nouvelle valeur :");
		newValueL.setBounds(240, 390, 170, 30);
		newValueL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(newValueL);
		
		JTextField newValueT = new JTextField();
		newValueT.setBounds(415, 390, 250, 30);
		newValueT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(newValueT);
		
		JButton ApplyUpdateIdB2 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyUpdateIdB2.setBounds(675, 390, 50, 30);
		ApplyUpdateIdB2.setOpaque(false);
		ApplyUpdateIdB2.setContentAreaFilled(false);
		ApplyUpdateIdB2.setBorderPainted(false);
		ClientImage.add(ApplyUpdateIdB2);
		
		// Jtextfileds pour stocker des variables.
		JTextField updateIdClient = new JTextField();
		JTextField idInserted = new JTextField();
		JTextField newValupdate = new JTextField(); 
		ApplyUpdateIdB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idText = updateIdT.getText().toString();
				try {
				int id = Integer.parseInt(idText);
				//System.out.println(id);
				try {
					CallableStatement idStatement = conn.prepareCall("{? = call Client_existeID(?)}");
					idStatement.registerOutParameter(1,java.sql.Types.BOOLEAN);
					idStatement.setInt(2, id);
					idStatement.execute();
					Boolean CleintExiste = idStatement.getBoolean(1);
					if(CleintExiste == true)
					{
						updateIdClient.setText(idText);
						idInserted.setText("done");
						JOptionPane.showMessageDialog(App, "Id Client valide");
					}
					else
					{
						updateIdClient.setText("");
						idInserted.setText("");
						startClient.setEnabled(false);
						JOptionPane.showMessageDialog(App, "Id Client n\'est pas valide");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				}catch (Exception q) {
					JOptionPane.showMessageDialog(App, "Inserer un entier sur la zone ID");
					idInserted.setText("");
					startClient.setEnabled(false);
				}
			//	System.out.println(idText);
					
				}
				
		});
		
		ApplyUpdateIdB2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String typeUp = typeupdate.getSelectedItem().toString();
				String val = newValueT.getText().toString();
				String idInsert = idInserted.getText().toString();
				
				if(idInsert.equals("done"))
					done += 1;
				else
					done = 0;
				
				if(!typeUp.equals(""))
				{
					done += 1;
				}
				else{
					JOptionPane.showMessageDialog(App, "Selectionner un type de modification!");
					done = 0;
				}
				if(!val.equals(""))
				{
					newValupdate.setText(val);
					done += 1;
				}
				else
				{
					JOptionPane.showMessageDialog(App, "La zone \'nouvelle valeur\' est vide!");
					done = 0;
				}
				if(done == 3)
					startClient.setEnabled(true);
				else
					startClient.setEnabled(false);
			}
		});
		
		// Supprimer Client
		
		JRadioButton deleteClientRB = new JRadioButton("Supprimer un Client");
		deleteClientRB.setBounds(5,430,250,30);
		deleteClientRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		deleteClientRB.setOpaque(false);
		deleteClientRB.setContentAreaFilled(false);
		deleteClientRB.setBorderPainted(false);
		ClientImage.add(deleteClientRB);
		
		JLabel deleteIdL = new JLabel("L\'Id du Client: ");
		deleteIdL.setBounds(20, 470, 150, 30);
		deleteIdL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(deleteIdL); 
		
		JTextField deleteIdT = new JTextField();
		deleteIdT.setBounds(150, 470, 100, 30);
		deleteIdT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ClientImage.add(deleteIdT);
		
		JButton ApplyDeleteIdB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyDeleteIdB.setBounds(260, 470, 50, 30);
		ApplyDeleteIdB.setOpaque(false);
		ApplyDeleteIdB.setContentAreaFilled(false);
		ApplyDeleteIdB.setBorderPainted(false);
		ClientImage.add(ApplyDeleteIdB);
		
		JTextField deleteID = new JTextField();
		
		ApplyDeleteIdB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idText = deleteIdT.getText().toString();
				try {
				int id = Integer.parseInt(idText);
				//System.out.println(id);
				try {
					CallableStatement idStatement = conn.prepareCall("{? = call Client_existeID(?)}");
					idStatement.registerOutParameter(1,java.sql.Types.BOOLEAN);
					idStatement.setInt(2, id);
					idStatement.execute();
					Boolean CleintExiste = idStatement.getBoolean(1);
					if(CleintExiste == true)
					{
						deleteID.setText(idText);
						idInserted.setText("done");
						JOptionPane.showMessageDialog(App, "Id Client valide");
						
						startClient.setEnabled(true);
					}
					else
					{
						deleteID.setText("");
						startClient.setEnabled(false);
						JOptionPane.showMessageDialog(App, "Id Client n\'est pas valide");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				}catch (Exception q) {
					JOptionPane.showMessageDialog(App, "Inserer un entier sur la zone ID");
					idInserted.setText("");
					startClient.setEnabled(false);
				}
			}
		});
		
		// Afficher Clients
		
		JRadioButton showClientRB = new JRadioButton("Afficher tous les Clients");
		showClientRB.setBounds(5,510,300,30);
		showClientRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		showClientRB.setOpaque(false);
		showClientRB.setContentAreaFilled(false);
		showClientRB.setBorderPainted(false);
		ClientImage.add(showClientRB);
		
		JLabel ShowClientL = new JLabel("Cliquer sur \'Go\' pour afficher tous les clients");
		ShowClientL.setBounds(350, 550, 400, 30);
		ShowClientL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ShowClientL.setVisible(true);
		ClientImage.add(ShowClientL); 
		
		ButtonGroup GB = new ButtonGroup();
		GB.add(addClientRB);
		GB.add(chercherClientRB);
		GB.add(updateClientRB);
		GB.add(deleteClientRB);
		GB.add(showClientRB);
		
		nomClientL.setEnabled(true);
		nomClientT.setEnabled(true);
		
		prenomClientT.setEnabled(true);
		prenomClientL.setEnabled(true);
		
		adresseClientL.setEnabled(true);
		adresseClientT.setEnabled(true);
		
		teleClientL.setEnabled(true);
		teleClientT.setEnabled(true);

		
		applyClientB.setEnabled(true);
		Clientinfo.setEnabled(true);
		
		chercher.setEnabled(false);
		typeRecherche.setEnabled(false);
		chercher1.setEnabled(false);
		textserchT.setEditable(false);
		ApplyserchB.setEnabled(false);
		
		updateIdL.setEnabled(false);
		updateIdT.setEnabled(false);
		ApplyUpdateIdB.setEnabled(false);
		modifer.setEnabled(false);
		typeupdate.setEnabled(false);
		newValueL.setEnabled(false);
		newValueT.setEnabled(false);
		ApplyUpdateIdB2.setEnabled(false);
		
		deleteIdL.setEnabled(false);
		deleteIdT.setEnabled(false);
		ApplyDeleteIdB.setEnabled(false);
		
		ShowClientL.setVisible(false);
		
		addClientRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomClientL.setEnabled(true);
				nomClientT.setEnabled(true);
				
				prenomClientT.setEnabled(true);
				prenomClientL.setEnabled(true);
				
				adresseClientL.setEnabled(true);
				adresseClientT.setEnabled(true);
				
				teleClientL.setEnabled(true);
				teleClientT.setEnabled(true);
				
				nomClientLV.setEnabled(true);
				prenomClientLV.setEnabled(true);
				adresseClientLV.setEnabled(true);
				teleClientLV.setEnabled(true);
				
				applyClientB.setEnabled(true);
				Clientinfo.setEnabled(true);
				
				chercher.setEnabled(false);
				typeRecherche.setEnabled(false);
				chercher1.setEnabled(false);
				textserchT.setEditable(false);
				ApplyserchB.setEnabled(false);
				
				updateIdL.setEnabled(false);
				updateIdT.setEnabled(false);
				ApplyUpdateIdB.setEnabled(false);
				modifer.setEnabled(false);
				typeupdate.setEnabled(false);
				newValueL.setEnabled(false);
				newValueT.setEnabled(false);
				ApplyUpdateIdB2.setEnabled(false);
				
				deleteIdL.setEnabled(false);
				deleteIdT.setEnabled(false);
				ApplyDeleteIdB.setEnabled(false);
				
				ShowClientL.setVisible(false);	
				startClient.setEnabled(false);
			}
		});
		
		chercherClientRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomClientL.setEnabled(false);
				nomClientT.setEnabled(false);

				
				prenomClientT.setEnabled(false);
				prenomClientL.setEnabled(false);

				
				adresseClientL.setEnabled(false);
				adresseClientT.setEnabled(false);

				
				teleClientL.setEnabled(false);
				teleClientT.setEnabled(false);
				
				nomClientLV.setEnabled(false);
				prenomClientLV.setEnabled(false);
				adresseClientLV.setEnabled(false);
				teleClientLV.setEnabled(false);
				
				applyClientB.setEnabled(false);
				Clientinfo.setEnabled(false);
				
				chercher.setEnabled(true);
				typeRecherche.setEnabled(true);
				chercher1.setEnabled(true);
				textserchT.setEditable(true);
				ApplyserchB.setEnabled(true);
				
				updateIdL.setEnabled(false);
				updateIdT.setEnabled(false);
				ApplyUpdateIdB.setEnabled(false);
				modifer.setEnabled(false);
				typeupdate.setEnabled(false);
				newValueL.setEnabled(false);
				newValueT.setEnabled(false);
				ApplyUpdateIdB2.setEnabled(false);
				
				deleteIdL.setEnabled(false);
				deleteIdT.setEnabled(false);
				ApplyDeleteIdB.setEnabled(false);
				
				ShowClientL.setVisible(false);
				startClient.setEnabled(false);
				
			}
		});
	
		updateClientRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomClientL.setEnabled(false);
				nomClientT.setEnabled(false);
				
				prenomClientT.setEnabled(false);
				prenomClientL.setEnabled(false);
				
				adresseClientL.setEnabled(false);
				adresseClientT.setEnabled(false);
				
				teleClientL.setEnabled(false);
				teleClientT.setEnabled(false);
				
				nomClientLV.setEnabled(false);
				prenomClientLV.setEnabled(false);
				adresseClientLV.setEnabled(false);
				teleClientLV.setEnabled(false);

				applyClientB.setEnabled(false);
				Clientinfo.setEnabled(false);
				
				chercher.setEnabled(false);
				typeRecherche.setEnabled(false);
				chercher1.setEnabled(false);
				textserchT.setEditable(false);
				ApplyserchB.setEnabled(false);
				
				updateIdL.setEnabled(true);
				updateIdT.setEnabled(true);
				ApplyUpdateIdB.setEnabled(true);
				modifer.setEnabled(true);
				typeupdate.setEnabled(true);
				newValueL.setEnabled(true);
				newValueT.setEnabled(true);
				ApplyUpdateIdB2.setEnabled(true);
				
				deleteIdL.setEnabled(false);
				deleteIdT.setEnabled(false);
				ApplyDeleteIdB.setEnabled(false);
				
				ShowClientL.setVisible(false);
				startClient.setEnabled(false);
				
			}
		});
		
		deleteClientRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomClientL.setEnabled(false);
				nomClientT.setEnabled(false);
				
				prenomClientT.setEnabled(false);
				prenomClientL.setEnabled(false);
				
				adresseClientL.setEnabled(false);
				adresseClientT.setEnabled(false);
				
				teleClientL.setEnabled(false);
				teleClientT.setEnabled(false);

				nomClientLV.setEnabled(false);
				prenomClientLV.setEnabled(false);
				adresseClientLV.setEnabled(false);
				teleClientLV.setEnabled(false);
				
				applyClientB.setEnabled(false);
				Clientinfo.setEnabled(false);
				
				chercher.setEnabled(false);
				typeRecherche.setEnabled(false);
				chercher1.setEnabled(false);
				textserchT.setEditable(false);
				ApplyserchB.setEnabled(false);
				
				updateIdL.setEnabled(false);
				updateIdT.setEnabled(false);
				ApplyUpdateIdB.setEnabled(false);
				modifer.setEnabled(false);
				typeupdate.setEnabled(false);
				newValueL.setEnabled(false);
				newValueT.setEnabled(false);
				ApplyUpdateIdB2.setEnabled(false);
				
				deleteIdL.setEnabled(true);
				deleteIdT.setEnabled(true);
				ApplyDeleteIdB.setEnabled(true);
				
				ShowClientL.setVisible(false);
				startClient.setEnabled(false);
			}
		});
		
		showClientRB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nomClientL.setEnabled(false);
				nomClientT.setEnabled(false);
				
				prenomClientT.setEnabled(false);
				prenomClientL.setEnabled(false);
				
				adresseClientL.setEnabled(false);
				adresseClientT.setEnabled(false);
				
				teleClientL.setEnabled(false);
				teleClientT.setEnabled(false);
				
				nomClientLV.setEnabled(false);
				prenomClientLV.setEnabled(false);
				adresseClientLV.setEnabled(false);
				teleClientLV.setEnabled(false);
				
				applyClientB.setEnabled(false);
				Clientinfo.setEnabled(false);
				
				chercher.setEnabled(false);
				typeRecherche.setEnabled(false);
				chercher1.setEnabled(false);
				textserchT.setEditable(false);
				ApplyserchB.setEnabled(false);
				
				updateIdL.setEnabled(false);
				updateIdT.setEnabled(false);
				ApplyUpdateIdB.setEnabled(false);
				modifer.setEnabled(false);
				typeupdate.setEnabled(false);
				newValueL.setEnabled(false);
				newValueT.setEnabled(false);
				ApplyUpdateIdB2.setEnabled(false);
				
				deleteIdL.setEnabled(false);
				deleteIdT.setEnabled(false);
				ApplyDeleteIdB.setEnabled(false);
				
				ShowClientL.setVisible(true);
				startClient.setEnabled(true);
				
			}
		});
		
		startClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client C = new Client();
				if(addClientRB.isSelected())
				{
					
					String nom = nomClientTV.getText().toString();
					String prenom = prenomClientTV.getText().toString();
					String adresse = adresseClientTV.getText().toString();
					String tele = teleClientTV.getText().toString();
					
					C.AjouterClient(nom, prenom, adresse, tele);
					
					
				}
				else if(chercherClientRB.isSelected())
				{
					String type = typeRecherche.getSelectedItem().toString();
					
					if(type.equals("Id"))
					{
						int id = Integer.parseInt(sercheVal.getText().toString());
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						ClientsId(id);
						D.add(scrollPane);
						D.setVisible(true); 
					}
					else if (type.equals("Nom"))
					{
						String nom = sercheVal.getText().toString();
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						Clients(1,nom);
						D.add(scrollPane);
						D.setVisible(true); 
						
					}
					else if (type.equals("Prenom"))
					{
						String prenom = sercheVal.getText().toString();
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						Clients(2,prenom);
						D.add(scrollPane);
						D.setVisible(true); 
						
					}
					else if (type.equals("Adresse"))
					{
						String adresse = sercheVal.getText().toString();
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						Clients(3,adresse);
						D.add(scrollPane);
						D.setVisible(true); 
						
					}
					else if (type.equals("Telephone"))
					{
						String tele = sercheVal.getText().toString();
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						Clients(4,tele);
						D.add(scrollPane);
						D.setVisible(true); 
						
					}
				}
				
				else if(updateClientRB.isSelected())
				{
					int id = Integer.parseInt(updateIdClient.getText());
					String type = typeupdate.getSelectedItem().toString();
					String text = newValupdate.getText().toString();
					if(type.equals("Nom"))
					{
						C.updateClient(id, 1, text);
					}
					else if(type.equals("Prenom"))
					{
						C.updateClient(id, 2, text);
					}
					else if(type.equals("Adresse"))
					{
						C.updateClient(id, 3, text);
					}
					else if(type.equals("Telephone"))
					{
						C.updateClient(id, 4, text);
					}
				}
				else if(deleteClientRB.isSelected())
				{
					int id = Integer.parseInt(deleteID.getText());
					C.deleteClient(id);
				}
				else if(showClientRB.isSelected())
				{
					
					JDialog D = new JDialog(App, "C.A.A.N");
					D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					D.setSize(700, 250);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(0, 0, 700, 250);
					table = new JTable();
					scrollPane.setViewportView(table);
					afficherClient();
					D.add(scrollPane);
					D.setVisible(true); 
				}
				
			}
		});
		
	// -----------------------------------------------------------------------------
		
	// -------------------------- Page Exemplaire ----------------------------
		
		JLabel ExemplaireImage = new JLabel();
		ExemplaireImage.setBounds(0,0,1049,700);
		ExemplaireImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("background.png")));
		Exemplaire.add(ExemplaireImage);
		
		JLabel exTtitleLabel = new JLabel("EXEMPLAIRE");
		exTtitleLabel.setFont(new Font("Liberation Serif", Font.BOLD, 26));
		exTtitleLabel.setBounds(455, 10, 200, 30);
		ExemplaireImage.add(exTtitleLabel);
		
		JButton startEx = new JButton(new ImageIcon(getClass().getClassLoader().getResource("go.png")));
		startEx.setBounds(970,585,50,50);
		startEx.setOpaque(false);
		startEx.setContentAreaFilled(false);
		startEx.setBorderPainted(false);
		startEx.setEnabled(false);
		ExemplaireImage.add(startEx);
		
		JButton backEx = new JButton(new ImageIcon(getClass().getClassLoader().getResource("back2.png")));
		backEx.setBounds(10,585,50,50);
		backEx.setOpaque(false);
		backEx.setContentAreaFilled(false);
		backEx.setBorderPainted(false);
		ExemplaireImage.add(backEx);
		
		backEx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Home.setVisible(true);
				
			}
		});
		
	// Ajouter exemplaire
	JRadioButton addExemplaireRB = new JRadioButton("Ajouter un Exemplaire");
	addExemplaireRB.setBounds(5,30,250,30);
	addExemplaireRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
	addExemplaireRB.setSelected(true);
	addExemplaireRB.setOpaque(false);
	addExemplaireRB.setContentAreaFilled(false);
	addExemplaireRB.setBorderPainted(false);
	ExemplaireImage.add(addExemplaireRB);
	
	JLabel idLivreEL = new JLabel("Id de livre :");
	idLivreEL.setBounds(20, 70, 100, 30);
	idLivreEL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	ExemplaireImage.add(idLivreEL);
	
	JTextField idLivreET = new JTextField();
	idLivreET.setBounds(120, 70, 100, 30);
	idLivreET.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	ExemplaireImage.add(idLivreET);
	
	JButton addExB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
	addExB.setBounds(230, 70, 50, 30);
	addExB.setOpaque(false);
	addExB.setContentAreaFilled(false);
	addExB.setBorderPainted(false);
	ExemplaireImage.add(addExB);
	
	addExB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean done = false;
			try {
				int id = Integer.parseInt(idLivreET.getText());
				System.out.println(id);
				done = true;
				try {
					CallableStatement st = conn.prepareCall("{? = call livre_existeID(?)}");
					st.registerOutParameter(1,java.sql.Types.BOOLEAN);
					st.setInt(2, id);
					st.execute();
					Boolean livreExiste = st.getBoolean(1);
					if(livreExiste == true)
					{
						JOptionPane.showMessageDialog(App, "ID livre valide");
						done = true;
					}
					else {
						JOptionPane.showMessageDialog(App, "Il n\'y a pas de livre pour cette ID");
						done = false;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(App, "Erreur");
					done = false;
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(App, "Inserer un entier");
				done = false;
			}
			if(done == true)
				startEx.setEnabled(true);
			else
				startEx.setEnabled(false);
		}
	});
	
	
	// chercher exemplaire
	
	JRadioButton chercherExemplaireRB = new JRadioButton("Chercher un Exemplaire");
	chercherExemplaireRB.setBounds(5,120,350,30);
	chercherExemplaireRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
	chercherExemplaireRB.setOpaque(false);
	chercherExemplaireRB.setContentAreaFilled(false);
	chercherExemplaireRB.setBorderPainted(false);
	ExemplaireImage.add(chercherExemplaireRB);
	
	JLabel chercher2L = new JLabel("Chercher par:");
	chercher2L.setBounds(20, 150, 150, 30);
	chercher2L.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	ExemplaireImage.add(chercher2L);
	chercher2L.setEnabled(false);
	
	JComboBox<String> typeChercheEx = new JComboBox<>();
	typeChercheEx.addItem("");
	typeChercheEx.addItem("Id Exemplaire");
	typeChercheEx.addItem("Id Livre");
	typeChercheEx.addItem("Disponible");
	typeChercheEx.addItem("Livre et dispo");
	typeChercheEx.setBounds(140,150,150,30);
	typeChercheEx.setBackground(Color.white);
	typeChercheEx.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
	typeChercheEx.setEnabled(false);
	ExemplaireImage.add(typeChercheEx);
	
	JLabel chercheValL = new JLabel("Inserer un ID :");
	chercheValL.setBounds(20, 190, 150, 30);
	chercheValL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//	chercheValL.setForeground(Color.white);
	chercheValL.setEnabled(false);
	ExemplaireImage.add(chercheValL);
	
	JTextField IdELT = new JTextField();
	IdELT.setBounds(140, 190, 100, 30);
	IdELT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	IdELT.setEnabled(false);
	ExemplaireImage.add(IdELT);
	
	JLabel cherchedispoL = new JLabel("disponible:");
	cherchedispoL.setBounds(20, 230, 150, 30);
	cherchedispoL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//	cherchedispoL.setForeground(Color.white);
	cherchedispoL.setEnabled(false);
	ExemplaireImage.add(cherchedispoL);
	
	JComboBox<String> ChDispoEx = new JComboBox<String>();
	ChDispoEx.addItem("");
	ChDispoEx.addItem("OUI");
	ChDispoEx.addItem("NON");
	ChDispoEx.setBounds(140,230,70,30);
	ChDispoEx.setBackground(Color.white);
	ChDispoEx.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
	ChDispoEx.setEnabled(false);
	ExemplaireImage.add(ChDispoEx);
	
	JButton applyrecherche = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
	applyrecherche.setBounds(220, 230, 50, 30);
	applyrecherche.setOpaque(false);
	applyrecherche.setContentAreaFilled(false);
	applyrecherche.setBorderPainted(false);
	applyrecherche.setEnabled(false);
	ExemplaireImage.add(applyrecherche);
	
	
	applyrecherche.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int done = 0;
			String type = typeChercheEx.getSelectedItem().toString();
			if(type.equals(""))
			{
				
				JOptionPane.showMessageDialog(App, "Selectioner le type du recherche");
				done = 0;
			}
			else if(type.equals("Id Exemplaire"))
			{
				try {
					int idE = Integer.parseInt(IdELT.getText().toString());
					try {
						CallableStatement st = conn.prepareCall("{? = call Exemplaire_existe(?)}");
						st.registerOutParameter(1,java.sql.Types.BOOLEAN);
						st.setInt(2, idE);
						st.execute();
						Boolean exemplaireExiste = st.getBoolean(1);
						if(exemplaireExiste == true)
						{
							JOptionPane.showMessageDialog(App, "ID Exemplaire valide");
							done +=1;
						}
						else {
							JOptionPane.showMessageDialog(App, "Il n\'y a pas d\'exemplaire pour cette ID");
							done = 0;
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(App, "Erreur");
						done = 0;
						e1.printStackTrace();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Inserer un entier");
				}
			}
			else if(type.equals("Id Livre"))
			{
				try {
					int idL = Integer.parseInt(IdELT.getText().toString());
					done += 1;
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Inserer un entier");
					done = 0;
				}
			}
			else if(type.equals("Disponible"))
			{
				String dispo = ChDispoEx.getSelectedItem().toString();
				if(dispo.equals(""))
				{
					JOptionPane.showMessageDialog(App, "selectioner la disponibilite");
					done = 0;
				}
				else
				{
					done += 1;
				}
			}
			else if(type.equals("Livre et dispo"))
			{
				try {
					int idL = Integer.parseInt(IdELT.getText().toString());
					String dispo = ChDispoEx.getSelectedItem().toString();
					if(dispo.equals(""))
					{
						JOptionPane.showMessageDialog(App, "selectioner la disponibilite");
						done = 0;
					}
					else
					{
						done += 1;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Inserer un entier");
					done = 0;
				}
			}
			if(done == 1)
				startEx.setEnabled(true);
			else
				startEx.setEnabled(false);
				
				
		}
	});
	
	
	// modifier exemplaire
	
	JRadioButton updateExemplaireRB = new JRadioButton("Modifier un Exemplaire");
	updateExemplaireRB.setBounds(5,280,350,30);
	updateExemplaireRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
//	updateExemplaireRB.setForeground(Color.white);
	updateExemplaireRB.setOpaque(false);
	updateExemplaireRB.setContentAreaFilled(false);
	updateExemplaireRB.setBorderPainted(false);
	ExemplaireImage.add(updateExemplaireRB);
	
	JRadioButton updateExemplaireIdlRB = new JRadioButton("Modifier ID de livre");
	updateExemplaireIdlRB.setBounds(30,320,350,30);
	updateExemplaireIdlRB.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//	updateExemplaireIdlRB.setForeground(Color.white);
	updateExemplaireIdlRB.setOpaque(false);
	updateExemplaireIdlRB.setContentAreaFilled(false);
	updateExemplaireIdlRB.setBorderPainted(false);
	updateExemplaireIdlRB.setSelected(true);
	updateExemplaireIdlRB.setEnabled(false);
	ExemplaireImage.add(updateExemplaireIdlRB);
	
	JLabel updateEXidL = new JLabel("ID de l\'exemplaire :");
	updateEXidL.setBounds(40, 360, 150, 30);
	updateEXidL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	updateEXidL.setEnabled(false);
	ExemplaireImage.add(updateEXidL);
	
	JTextField updateEXidT = new JTextField();
	updateEXidT.setBounds(195, 360, 100, 30);
	updateEXidT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	updateEXidT.setEnabled(false);
	ExemplaireImage.add(updateEXidT);
	
	JLabel newEXidL = new JLabel("nouvel ID de livre:");
	newEXidL.setBounds(40, 400, 150, 30);
	newEXidL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	newEXidL.setEnabled(false);
	ExemplaireImage.add(newEXidL);
	
	JTextField newEXidT = new JTextField();
	newEXidT.setBounds(195, 400, 100, 30);
	newEXidT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	newEXidT.setEnabled(false);
	ExemplaireImage.add(newEXidT);
	
	JButton applyNewIdlEx = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
	applyNewIdlEx.setBounds(305, 400, 50, 30);
	applyNewIdlEx.setOpaque(false);
	applyNewIdlEx.setContentAreaFilled(false);
	applyNewIdlEx.setBorderPainted(false);
	applyNewIdlEx.setEnabled(false);
	ExemplaireImage.add(applyNewIdlEx);
		
	applyNewIdlEx.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int done = 0;
			try {
				int idE = Integer.parseInt(updateEXidT.getText().toString());
				int idL = Integer.parseInt(newEXidT.getText().toString());
				done += 1;
				try {
					CallableStatement st = conn.prepareCall("{? = call Exemplaire_existe(?)}");
					st.registerOutParameter(1,java.sql.Types.BOOLEAN);
					st.setInt(2, idE);
					st.execute();
					Boolean exemplaireExiste = st.getBoolean(1);
					if(exemplaireExiste == true)
					{
						JOptionPane.showMessageDialog(App, "ID Exemplaire valide");
						done += 1;
					}
					else {
						JOptionPane.showMessageDialog(App, "Il n\'y a pas d\'exemplaire pour cette ID");
						done = 0;
						}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(App, "Erreur");
					done = 0;
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(App, "Inserer des entiers");
				done = 0;
			}
			if(done == 2)
				startEx.setEnabled(true);
			else
				startEx.setEnabled(false);
		}
	});
	
	JRadioButton updateExemplairedispolRB = new JRadioButton("Modifier la dsponibite");
	updateExemplairedispolRB.setBounds(30,440,350,30);
	updateExemplairedispolRB.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//	updateExemplairedispolRB.setForeground(Color.white);
	updateExemplairedispolRB.setOpaque(false);
	updateExemplairedispolRB.setContentAreaFilled(false);
	updateExemplairedispolRB.setRolloverEnabled(false);
	updateExemplairedispolRB.setEnabled(false);
	updateExemplairedispolRB.setBorderPainted(false);
	
	ExemplaireImage.add(updateExemplairedispolRB);
	
	JLabel updateEXidL2 = new JLabel("ID de l\'exemplaire :");
	updateEXidL2.setBounds(40, 480, 150, 30);
	updateEXidL2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	updateEXidL2.setEnabled(false);
	ExemplaireImage.add(updateEXidL2);
	
	JTextField updateEXidT2 = new JTextField();
	updateEXidT2.setBounds(195, 480, 100, 30);
	updateEXidT2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	updateEXidT2.setEnabled(false);
	ExemplaireImage.add(updateEXidT2);
	
	JLabel updateEXdispoL = new JLabel("Disponible:");   
	updateEXdispoL.setBounds(40, 520, 150, 30);
	updateEXdispoL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	updateEXdispoL.setEnabled(false);
	ExemplaireImage.add(updateEXdispoL);
	
	JComboBox<String> newdispoEx = new JComboBox<String>();
	newdispoEx.addItem("");
	newdispoEx.addItem("OUI");
	newdispoEx.addItem("NON");
	newdispoEx.setBounds(195,520,70,30);
	newdispoEx.setBackground(Color.white);
	newdispoEx.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
	newdispoEx.setEnabled(false);
	ExemplaireImage.add(newdispoEx);
	
	
	JButton applyNewdispolEx = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
	applyNewdispolEx.setBounds(275, 520, 50, 30);
	applyNewdispolEx.setOpaque(false);
	applyNewdispolEx.setContentAreaFilled(false);
	applyNewdispolEx.setBorderPainted(false);
	applyNewdispolEx.setEnabled(false);
	ExemplaireImage.add(applyNewdispolEx);
	
	applyNewdispolEx.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int done = 0;
			try {
				int idE = Integer.parseInt(updateEXidT2.getText().toString());
				try {
					CallableStatement st = conn.prepareCall("{? = call Exemplaire_existe(?)}");
					st.registerOutParameter(1,java.sql.Types.BOOLEAN);
					st.setInt(2, idE);
					st.execute();
					Boolean exemplaireExiste = st.getBoolean(1);
					if(exemplaireExiste == true)
					{
						JOptionPane.showMessageDialog(App, "ID Exemplaire valide");
						done += 1;
					}
					else {
						JOptionPane.showMessageDialog(App, "Il n\'y a pas d\'exemplaire pour cette ID");
						done = 0;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(App, "Erreur");
					done = 0;
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(App, "Inserer des entiers");
				done = 0;
			}
			String dispo = newdispoEx.getSelectedItem().toString();
			if(dispo.equals(""))
			{
				JOptionPane.showMessageDialog(App, "Selectionner la disponibilite");
				done = 0;
			}
			else
				done += 1;
			
			if(done == 2)
				startEx.setEnabled(true);
			else
				startEx.setEnabled(false);
			
		}
	});
	
	ButtonGroup GB1 = new ButtonGroup();
	GB1.add(updateExemplaireIdlRB);
	GB1.add(updateExemplairedispolRB);
	
	updateExemplaireIdlRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			updateEXidL.setEnabled(true);
			updateEXidT.setEnabled(true);
			newEXidL.setEnabled(true);
			newEXidT.setEnabled(true);
			applyNewIdlEx.setEnabled(true);
			
			updateEXidL2.setEnabled(false);
			updateEXidT2.setEnabled(false);
			updateEXdispoL.setEnabled(false);
			newdispoEx.setEnabled(false);
			applyNewdispolEx.setEnabled(false);
		}
	});
	
	updateExemplairedispolRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			updateEXidL.setEnabled(false);
			updateEXidT.setEnabled(false);
			newEXidL.setEnabled(false);
			newEXidT.setEnabled(false);
			applyNewIdlEx.setEnabled(false);
			
			updateEXidL2.setEnabled(true);
			updateEXidT2.setEnabled(true);
			updateEXdispoL.setEnabled(true);
			newdispoEx.setEnabled(true);
			applyNewdispolEx.setEnabled(true);
			
		}
	});
	
	
	// Supprimer un exemplaire
	
	JRadioButton deleteExemplaireRB = new JRadioButton("Supprimer un Exemplaire");
	deleteExemplaireRB.setBounds(550,150,350,30);
	deleteExemplaireRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
//	deleteExemplaireRB.setForeground(Color.white);
	deleteExemplaireRB.setOpaque(false);
	deleteExemplaireRB.setContentAreaFilled(false);
	deleteExemplaireRB.setBorderPainted(false);
	ExemplaireImage.add(deleteExemplaireRB);
	
	JLabel deleteEXidL2 = new JLabel("ID de l\'exemplaire :");
	deleteEXidL2.setBounds(560, 190, 150, 30);
	deleteEXidL2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	deleteEXidL2.setEnabled(false);
	ExemplaireImage.add(deleteEXidL2);
	
	JTextField deleteEXidT2 = new JTextField();
	deleteEXidT2.setBounds(720, 190, 100, 30);
	deleteEXidT2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	deleteEXidT2.setEnabled(false);
	ExemplaireImage.add(deleteEXidT2);
	
	JButton applydeleteEx = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
	applydeleteEx.setBounds(830, 190, 50, 30);
	applydeleteEx.setOpaque(false);
	applydeleteEx.setContentAreaFilled(false);
	applydeleteEx.setBorderPainted(false);
	applydeleteEx.setEnabled(false);
	ExemplaireImage.add(applydeleteEx);
	
	applydeleteEx.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int done = 0;
			try {
				int idE = Integer.parseInt(deleteEXidT2.getText().toString());
				try {
					CallableStatement st = conn.prepareCall("{? = call Exemplaire_existe(?)}");
					st.registerOutParameter(1,java.sql.Types.BOOLEAN);
					st.setInt(2, idE);
					st.execute();
					Boolean exemplaireExiste = st.getBoolean(1);
					if(exemplaireExiste == true)
					{
						JOptionPane.showMessageDialog(App, "ID Exemplaire valide");
						done += 1;
					}
					else {
						JOptionPane.showMessageDialog(App, "Il n\'y a pas d\'exemplaire pour cette ID");
						done = 0;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(App, "Erreur");
					done = 0;
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(App, "Inserer des entiers");
				done = 0;
			}
			if(done == 1)
				startEx.setEnabled(true);
			else
				startEx.setEnabled(false);
			
		}
	});
	
	JRadioButton afficherExemplaireRB = new JRadioButton("Afficher tous les Exemplaires");
	afficherExemplaireRB.setBounds(550,290,450,30);
	afficherExemplaireRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
//	afficherExemplaireRB.setForeground(Color.white);
	afficherExemplaireRB.setOpaque(false);
	afficherExemplaireRB.setContentAreaFilled(false);
	afficherExemplaireRB.setBorderPainted(false);
	ExemplaireImage.add(afficherExemplaireRB);
	
	JLabel EXmessage = new JLabel("Cliquer sur \'GO\' pour afficher tous les exemplaires");
	EXmessage.setBounds(600, 340, 800, 30);
	EXmessage.setFont(new Font("Liberation Serif", Font.BOLD, 17));
	EXmessage.setVisible(false);
	ExemplaireImage.add(EXmessage);
	

		ButtonGroup GB2 = new ButtonGroup();
		
		GB2.add(addExemplaireRB);
		GB2.add(chercherExemplaireRB);
		GB2.add(updateExemplaireRB);
		GB2.add(deleteExemplaireRB);
		GB2.add(afficherExemplaireRB);
		
		
		addExemplaireRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//ajouter exemplaire
				idLivreEL.setEnabled(true);
				idLivreET.setEnabled(true);
				addExB.setEnabled(true);
				
				//chercher exemplaire
				typeChercheEx.setEnabled(false);
				chercheValL.setEnabled(false);
				IdELT.setEnabled(false);
				chercher2L.setEnabled(false);
				cherchedispoL.setEnabled(false);
				ChDispoEx.setEnabled(false);
				applyrecherche.setEnabled(false);
				
				
				//modifier exemplaire
				updateExemplaireIdlRB.setEnabled(false);
				updateEXidL.setEnabled(false);
				updateEXidT.setEnabled(false);
				newEXidL.setEnabled(false);
				newEXidT.setEnabled(false);
				applyNewIdlEx.setEnabled(false);
				updateExemplairedispolRB.setEnabled(false);
				updateEXidL2.setEnabled(false);
				updateEXidT2.setEnabled(false);
				updateEXdispoL.setEnabled(false);
				newdispoEx.setEnabled(false);
				applyNewdispolEx.setEnabled(false);
				
				//supprimer exemplaire
				deleteEXidL2.setEnabled(false);
				deleteEXidT2.setEnabled(false);
				applydeleteEx.setEnabled(false);
				
				//afficher exemplaires
				EXmessage.setVisible(false);
				startEx.setEnabled(false);
			}
		});
		
		chercherExemplaireRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ajouter exemplaire
				idLivreEL.setEnabled(false);
				idLivreET.setEnabled(false);
				addExB.setEnabled(false);
				
				//chercher exemplaire
				typeChercheEx.setEnabled(true);
				chercheValL.setEnabled(true);
				IdELT.setEnabled(true);
				chercher2L.setEnabled(true);
				cherchedispoL.setEnabled(true);
				ChDispoEx.setEnabled(true);
				applyrecherche.setEnabled(true);
				
				//modifier exemplaire
				updateExemplaireIdlRB.setEnabled(false);
				updateEXidL.setEnabled(false);
				updateEXidT.setEnabled(false);
				newEXidL.setEnabled(false);
				newEXidT.setEnabled(false);
				applyNewIdlEx.setEnabled(false);
				updateExemplairedispolRB.setEnabled(false);
				updateEXidL2.setEnabled(false);
				updateEXidT2.setEnabled(false);
				updateEXdispoL.setEnabled(false);
				newdispoEx.setEnabled(false);
				applyNewdispolEx.setEnabled(false);
				
				//supprimer exemplaire
				deleteEXidL2.setEnabled(false);
				deleteEXidT2.setEnabled(false);
				applydeleteEx.setEnabled(false);
				
				//afficher exemplaires
				EXmessage.setVisible(false);
				startEx.setEnabled(false);
			}
		});
		
		
		updateExemplaireRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ajouter exemplaire
				idLivreEL.setEnabled(false);
				idLivreET.setEnabled(false);
				addExB.setEnabled(false);
				
				//chercher exemplaire
				typeChercheEx.setEnabled(false);
				chercheValL.setEnabled(false);
				IdELT.setEnabled(false);
				chercher2L.setEnabled(false);
				cherchedispoL.setEnabled(false);
				ChDispoEx.setEnabled(false);
				applyrecherche.setEnabled(false);
				
				//modifier exemplaire
				updateExemplaireIdlRB.setEnabled(true);
				updateEXidL.setEnabled(true);
				updateEXidT.setEnabled(true);
				newEXidL.setEnabled(true);
				newEXidT.setEnabled(true);
				applyNewIdlEx.setEnabled(true);
				updateExemplairedispolRB.setEnabled(true);
				updateEXidL2.setEnabled(false);
				updateEXidT2.setEnabled(false);
				updateEXdispoL.setEnabled(false);
				newdispoEx.setEnabled(false);
				applyNewdispolEx.setEnabled(false);
				
				//supprimer exemplaire
				deleteEXidL2.setEnabled(false);
				deleteEXidT2.setEnabled(false);
				applydeleteEx.setEnabled(false);
				
				//afficher exemplaires
				EXmessage.setVisible(false);
				startEx.setEnabled(false);
			}
		});
		
		deleteExemplaireRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ajouter exemplaire
				idLivreEL.setEnabled(false);
				idLivreET.setEnabled(false);
				addExB.setEnabled(false);
				
				//chercher exemplaire
				typeChercheEx.setEnabled(false);
				chercheValL.setEnabled(false);
				IdELT.setEnabled(false);
				chercher2L.setEnabled(false);
				cherchedispoL.setEnabled(false);
				ChDispoEx.setEnabled(false);
				applyrecherche.setEnabled(false);
				
				//modifier exemplaire
				updateExemplaireIdlRB.setEnabled(false);
				updateEXidL.setEnabled(false);
				updateEXidT.setEnabled(false);
				newEXidL.setEnabled(false);
				newEXidT.setEnabled(false);
				applyNewIdlEx.setEnabled(false);
				updateExemplairedispolRB.setEnabled(false);
				updateEXidL2.setEnabled(false);
				updateEXidT2.setEnabled(false);
				updateEXdispoL.setEnabled(false);
				newdispoEx.setEnabled(false);
				applyNewdispolEx.setEnabled(false);
				
				//supprimer exemplaire
				deleteEXidL2.setEnabled(true);
				deleteEXidT2.setEnabled(true);
				applydeleteEx.setEnabled(true);
				
				//afficher exemplaires
				EXmessage.setVisible(false);
				startEx.setEnabled(false);
				
			}
		});
		
		
		afficherExemplaireRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ajouter exemplaire
				idLivreEL.setEnabled(false);
				idLivreET.setEnabled(false);
				addExB.setEnabled(false);
				
				//chercher exemplaire
				typeChercheEx.setEnabled(false);
				chercheValL.setEnabled(false);
				IdELT.setEnabled(false);
				chercher2L.setEnabled(false);
				cherchedispoL.setEnabled(false);
				ChDispoEx.setEnabled(false);
				applyrecherche.setEnabled(false);
				
				//modifier exemplaire
				updateExemplaireIdlRB.setEnabled(false);
				updateEXidL.setEnabled(false);
				updateEXidT.setEnabled(false);
				newEXidL.setEnabled(false);
				newEXidT.setEnabled(false);
				applyNewIdlEx.setEnabled(false);
				updateExemplairedispolRB.setEnabled(false);
				updateEXidL2.setEnabled(false);
				updateEXidT2.setEnabled(false);
				updateEXdispoL.setEnabled(false);
				newdispoEx.setEnabled(false);
				applyNewdispolEx.setEnabled(false);
				
				//supprimer exemplaire
				deleteEXidL2.setEnabled(false);
				deleteEXidT2.setEnabled(false);
				applydeleteEx.setEnabled(false);
				
				//afficher exemplaires
				EXmessage.setVisible(true);
				startEx.setEnabled(true);
				
			}
		});
		
		startEx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(addExemplaireRB.isSelected())
				{
					int id = Integer.parseInt(idLivreET.getText());
					exemplaire.AddExemplaire(id);
				}
				if(chercherExemplaireRB.isSelected())
				{
					String type = typeChercheEx.getSelectedItem().toString();
					if(type.equals("Id Exemplaire"))
					{
						int id = Integer.parseInt(IdELT.getText());
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						chercherExemplaireParIDE(id);
						D.add(scrollPane);
						D.setVisible(true);
					}
					else if(type.equals("Id Livre"))
					{
						int id = Integer.parseInt(IdELT.getText());
						JDialog D = new JDialog(App, "C.A.A.N");
						D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						D.setSize(700, 250);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(0, 0, 700, 250);
						table = new JTable();
						scrollPane.setViewportView(table);
						chercherExemplaireParIDL(id);
						D.add(scrollPane);
						D.setVisible(true);
					}
					else if(type.equals("Disponible"))
					{
						String dispo = ChDispoEx.getSelectedItem().toString();
						if(dispo.equals("OUI"))
						{
							JDialog D = new JDialog(App, "C.A.A.N");
							D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							D.setSize(700, 250);
							JScrollPane scrollPane = new JScrollPane(table);
							scrollPane.setBounds(0, 0, 700, 250);
							table = new JTable();
							scrollPane.setViewportView(table);
							chercherExemplairePardispo(1);
							D.add(scrollPane);
							D.setVisible(true);
						}
						else if(dispo.equals("NON"))
						{
							JDialog D = new JDialog(App, "C.A.A.N");
							D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							D.setSize(700, 250);
							JScrollPane scrollPane = new JScrollPane(table);
							scrollPane.setBounds(0, 0, 700, 250);
							table = new JTable();
							scrollPane.setViewportView(table);
							chercherExemplairePardispo(0);
							D.add(scrollPane);
							D.setVisible(true);
						}
						
					}
					else if(type.equals("Livre et dispo"))
					{
						int id = Integer.parseInt(IdELT.getText());
						
						String dispo = ChDispoEx.getSelectedItem().toString();
						if(dispo.equals("OUI"))
						{
							JDialog D = new JDialog(App, "C.A.A.N");
							D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							D.setSize(700, 250);
							JScrollPane scrollPane = new JScrollPane(table);
							scrollPane.setBounds(0, 0, 700, 250);
							table = new JTable();
							scrollPane.setViewportView(table);
							chercherExemplaireParIDLetDispo(id,1);
							D.add(scrollPane);
							D.setVisible(true);
						}
						else if(dispo.equals("NON"))
						{
							JDialog D = new JDialog(App, "C.A.A.N");
							D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							D.setSize(700, 250);
							JScrollPane scrollPane = new JScrollPane(table);
							scrollPane.setBounds(0, 0, 700, 250);
							table = new JTable();
							scrollPane.setViewportView(table);
							chercherExemplaireParIDLetDispo(id,0);
							D.add(scrollPane);
							D.setVisible(true);
						}
						
					}
				}
				if(updateExemplaireRB.isSelected())
				{
					if(updateExemplaireIdlRB.isSelected())
					{
						int idE = Integer.parseInt(updateEXidT.getText().toString());
						int idL = Integer.parseInt(newEXidT.getText().toString());
						exemplaire.updateExemplaireIdL(idE,idL);
					}
					else if(updateExemplairedispolRB.isSelected())
					{
						int idE = Integer.parseInt(updateEXidT2.getText().toString());
						String dispo = newdispoEx.getSelectedItem().toString();
						if(dispo.equals("OUI"))
						{
							exemplaire.updateExemplairedispo(idE, 1);
						}
						if(dispo.equals("NON"))
						{
							exemplaire.updateExemplairedispo(idE, 0);
						}
					}
				}
				if(deleteExemplaireRB.isSelected())
				{
					int id = Integer.parseInt(deleteEXidT2.getText().toString());
					exemplaire.deleteExemplaire(id);
				}
				else if(afficherExemplaireRB.isSelected())
				{
					JDialog D = new JDialog(App, "C.A.A.N");
					D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					D.setSize(700, 250);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(0, 0, 700, 250);
					table = new JTable();
					scrollPane.setViewportView(table);
					afficherExemplaire();
					D.add(scrollPane);
					D.setVisible(true); 
				}
				
				
			}
		});
		
		//---------------------------------------------------------------
		
		//------------------ Page Offre ------------------------
		
		JLabel offreImage = new JLabel();
		offreImage.setBounds(0,0,1049,700);
		offreImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("background.png")));
		Offre.add(offreImage);
		
		JLabel offreTtitleLabel = new JLabel("OFFRES");
		offreTtitleLabel.setFont(new Font("Liberation Serif", Font.BOLD, 26));
		offreTtitleLabel.setBounds(460, 10, 200, 30);
		offreImage.add(offreTtitleLabel);
		
		JButton startOffre = new JButton(new ImageIcon(getClass().getClassLoader().getResource("go.png")));
		startOffre.setBounds(970,585,50,50);
		startOffre.setOpaque(false);
		startOffre.setContentAreaFilled(false);
		startOffre.setBorderPainted(false);
		startOffre.setEnabled(false);
		offreImage.add(startOffre);
		
		JButton backoffre = new JButton(new ImageIcon(getClass().getClassLoader().getResource("back2.png")));
		backoffre.setBounds(10,585,50,50);
		backoffre.setOpaque(false);
		backoffre.setContentAreaFilled(false);
		backoffre.setBorderPainted(false);
		offreImage.add(backoffre);
		
		backoffre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Offre.setVisible(false);
				Home.setVisible(true);
				
			}
		});
		
		// Ajouter Offre
		
		
		JRadioButton addOffreRB = new JRadioButton("Ajouter une Offre");
		addOffreRB.setBounds(5,30,250,30);
		addOffreRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		addOffreRB.setSelected(true);
		addOffreRB.setOpaque(false);
		addOffreRB.setContentAreaFilled(false);
		addOffreRB.setBorderPainted(false);
		offreImage.add(addOffreRB);
		
		JLabel LNomOffre = new JLabel("Nom de l\'offre :");
		LNomOffre.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LNomOffre.setBounds(20, 70, 150, 30);
		offreImage.add(LNomOffre);
		
		JTextField TNomOffre = new JTextField();
		TNomOffre.setBounds(145, 70, 150, 30);
		TNomOffre.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		offreImage.add(TNomOffre);
		
		JLabel LnbrLivreOffre = new JLabel("Nombre de livres :");
		LnbrLivreOffre.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LnbrLivreOffre.setBounds(370, 70, 150, 30);
		offreImage.add(LnbrLivreOffre);
		
		JTextField TNbrLivres = new JTextField();
		TNbrLivres.setBounds(520, 70, 150, 30);
		TNbrLivres.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		offreImage.add(TNbrLivres);
		
		
		JLabel LTarif = new JLabel("Tarif :");
		LTarif.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LTarif.setBounds(745, 70, 100, 30);
		offreImage.add(LTarif);
		
		JTextField TTarif = new JTextField();
		TTarif.setBounds(800, 70, 100, 30);
		TTarif.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		offreImage.add(TTarif);
		
		JButton ApplyaddOfferB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyaddOfferB.setBounds(950, 70, 50, 30);
		ApplyaddOfferB.setOpaque(false);
		ApplyaddOfferB.setContentAreaFilled(false);
		ApplyaddOfferB.setBorderPainted(false);
		offreImage.add(ApplyaddOfferB);
		
		ApplyaddOfferB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String Noffre = TNomOffre.getText().toString();
				String Nlivre = TNbrLivres.getText().toString();
				String tarif = TTarif.getText().toString();
				try {
					int NlivreI = Integer.parseInt(Nlivre);
					done += 1;
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Nombre de livres est un entier");
					done = 0;
				}
				try {
					
					float tar = Float.parseFloat(tarif);
					done += 1;
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "le trif est un decimale");
					done = 0;
				}
				
				if(Noffre.equals("") || Nlivre.equals("") || tarif.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Il y\' a des cases vide");
					done = 0;
				}
				else
					done += 1;
				
				if (done == 3)
					startOffre.setEnabled(true);
				else
					startOffre.setEnabled(false);
			}
		});
		
		// Modifier Offre
		
		
		JRadioButton updateOffreRB = new JRadioButton("Modifier une Offre");
		updateOffreRB.setBounds(5,120,250,30);
		updateOffreRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		updateOffreRB.setOpaque(false);
		updateOffreRB.setContentAreaFilled(false);
		updateOffreRB.setBorderPainted(false);
		
		offreImage.add(updateOffreRB);
		
		
		JRadioButton updateOffreNomRB = new JRadioButton("Modifier le nom");
		updateOffreNomRB.setBounds(40,160,250,30);
		updateOffreNomRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		updateOffreNomRB.setOpaque(false);
		updateOffreNomRB.setContentAreaFilled(false);
		updateOffreNomRB.setBorderPainted(false);
		updateOffreNomRB.setSelected(true);
		updateOffreNomRB.setEnabled(false);
		offreImage.add(updateOffreNomRB);
		
		JRadioButton updateOffreNlivreRB = new JRadioButton("Modifier le nombre de livres");
		updateOffreNlivreRB.setBounds(340,160,300,30);
		updateOffreNlivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		updateOffreNlivreRB.setOpaque(false);
		updateOffreNlivreRB.setContentAreaFilled(false);
		updateOffreNlivreRB.setBorderPainted(false);
		updateOffreNlivreRB.setEnabled(false);
		offreImage.add(updateOffreNlivreRB);
		
		JRadioButton updateOffreTarifRB = new JRadioButton("Modifier le tarif");
		updateOffreTarifRB.setBounds(750,160,300,30);
		updateOffreTarifRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		updateOffreTarifRB.setOpaque(false);
		updateOffreTarifRB.setContentAreaFilled(false);
		updateOffreTarifRB.setBorderPainted(false);
		updateOffreTarifRB.setEnabled(false);
		offreImage.add(updateOffreTarifRB);
		
		
		JLabel updateOffreSelectOL = new JLabel("Choisir l'offre que vous voulez modifier :");
		updateOffreSelectOL.setBounds(30, 210, 350, 30);
		updateOffreSelectOL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		updateOffreSelectOL.setEnabled(false);
		offreImage.add(updateOffreSelectOL);
		
		
		JComboBox<String> selectedOffreupdateC = new JComboBox<String>();
		selectedOffreupdateC.setBounds(380, 210, 150, 30);
		selectedOffreupdateC.setBackground(Color.white);
		selectedOffreupdateC.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		selectedOffreupdateC.setEnabled(false);
		selectedOffreupdateC.addItem("");
		offreImage.add(selectedOffreupdateC);
		
		JLabel updateOffrenewValL = new JLabel("La nouvelle valeur :");
		updateOffrenewValL.setBounds(30, 250, 200, 30);
		updateOffrenewValL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		updateOffrenewValL.setEnabled(false);
		offreImage.add(updateOffrenewValL);
		
		JTextField updateOffrenewValT = new JTextField();
		updateOffrenewValT.setBounds(200, 250, 150, 30);
		updateOffrenewValT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		updateOffrenewValT.setEnabled(false);
		offreImage.add(updateOffrenewValT);
		
		JButton selectOffreupB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		selectOffreupB.setBounds(400, 250, 50, 30);
		selectOffreupB.setOpaque(false);
		selectOffreupB.setContentAreaFilled(false);
		selectOffreupB.setBorderPainted(false);
		selectOffreupB.setEnabled(false);
		offreImage.add(selectOffreupB);
		
		selectOffreupB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				if(updateOffreNlivreRB.isSelected())
				{
					String selectedItem = selectedOffreupdateC.getSelectedItem().toString();
					if(selectedItem.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Choisir l'offre que vous voulez modifier");
						done = 0;
					}
					else
					{
						try {
							int nbr = Integer.parseInt(updateOffrenewValT.getText().toString());
							done +=1;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(App, "Nombre de livres est un entier");
							done = 0;
							
						}
					}
				}
				else if(updateOffreTarifRB.isSelected())
				{
					String selectedItem = selectedOffreupdateC.getSelectedItem().toString();
					if(selectedItem.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Choisir l'offre que vous voulez modifier");
						done = 0;
					}
					else
					{
						try {
							float nbr = Float.parseFloat(updateOffrenewValT.getText().toString());
							done +=1;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(App, "Le tarif est un reel");
							done = 0;
							
						}
					}
				}
				else
				{
					String selectedItem = selectedOffreupdateC.getSelectedItem().toString();
					if(selectedItem.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Choisir l'offre que vous voulez modifier");
						done = 0;
					}
					else 
					{
						if(!updateOffrenewValT.getText().toString().equals(""))
							done +=1;
						else
						{
							done = 0;
							JOptionPane.showMessageDialog(App, "Il y\'a une case vide");
						}
					}
				}
				if(done == 1)
					startOffre.setEnabled(true);
				else
					startOffre.setEnabled(false);
			}
		});
		
		ButtonGroup updateOffreG = new ButtonGroup();
		updateOffreG.add(updateOffreNlivreRB);
		updateOffreG.add(updateOffreTarifRB);
		updateOffreG.add(updateOffreNomRB);
		
		
		// Supprimer une Offre
		
		
		JRadioButton deleteOffreRB = new JRadioButton("Supprimer une Offre");
		deleteOffreRB.setBounds(5,300,250,30);
		deleteOffreRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		deleteOffreRB.setOpaque(false);
		deleteOffreRB.setContentAreaFilled(false);
		deleteOffreRB.setBorderPainted(false);
		offreImage.add(deleteOffreRB);
		
		JLabel lblNewLabel = new JLabel("Choisir l'offre que vous voulez supprimer :");
		lblNewLabel.setBounds(30, 340, 350, 30);
		lblNewLabel.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		lblNewLabel.setEnabled(false);
		offreImage.add(lblNewLabel);
		
		JComboBox<String> selectedOffredeleteC = new JComboBox<String>();
		selectedOffredeleteC.setBounds(380, 340, 150, 30);
		selectedOffredeleteC.setBackground(Color.white);
		selectedOffredeleteC.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		selectedOffredeleteC.setEnabled(false);
		selectedOffredeleteC.addItem("");
		offreImage.add(selectedOffredeleteC);
		
		JButton applydeleteOffreB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		applydeleteOffreB.setBounds(550, 340, 50, 30);
		applydeleteOffreB.setOpaque(false);
		applydeleteOffreB.setContentAreaFilled(false);
		applydeleteOffreB.setBorderPainted(false);
		applydeleteOffreB.setEnabled(false);
		offreImage.add(applydeleteOffreB);
		
		applydeleteOffreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String selectToDeleteOffre = selectedOffredeleteC.getSelectedItem().toString();
				if(!selectToDeleteOffre.equals(""))
					done += 1;
				else
				{
					JOptionPane.showMessageDialog(App, "Choisir l'offre que vous voulez supprimer");
					done = 0;
				}
				if(done == 1)
					startOffre.setEnabled(true);
				else
					startOffre.setEnabled(false);
			}
		});
		
		
	// Afficher les Offres
		
		
		JRadioButton afficherOffreRB = new JRadioButton("Afficher tous les offres");
		afficherOffreRB.setBounds(5,390,250,30);
		afficherOffreRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		afficherOffreRB.setOpaque(false);
		afficherOffreRB.setContentAreaFilled(false);
		afficherOffreRB.setBorderPainted(false);
		offreImage.add(afficherOffreRB);
		
		JLabel OffreMessage = new JLabel("Cliquer sur \'GO\' pour afficher tous les Offres");
		OffreMessage.setBounds(400, 390, 800, 30);
		OffreMessage.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		OffreMessage.setVisible(false);
		offreImage.add(OffreMessage);
		
		JScrollPane scrollPaneOffre = new JScrollPane(table);
		scrollPaneOffre.setBounds(120, 440, 800, 150);
		scrollPaneOffre.setEnabled(false);
		offreImage.add(scrollPaneOffre);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPaneOffre.setViewportView(table);
		
		
		ButtonGroup GB3 = new ButtonGroup();
		
		GB3.add(addOffreRB);
		GB3.add(updateOffreRB);
		GB3.add(deleteOffreRB);
		GB3.add(afficherOffreRB);
		
		addOffreRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Ajouter offre
				LNomOffre.setEnabled(true);
				TNomOffre.setEnabled(true);
				LnbrLivreOffre.setEnabled(true);
				TNbrLivres.setEnabled(true);
				LTarif.setEnabled(true);
				TTarif.setEditable(true);
				ApplyaddOfferB.setEnabled(true);
				
				//modifier offre
				 updateOffreNomRB.setEnabled(false);
				 updateOffreNlivreRB.setEnabled(false);
				 updateOffreTarifRB.setEnabled(false);
				 updateOffreSelectOL.setEnabled(false);
				 selectedOffreupdateC.setEnabled(false);
				 updateOffrenewValL.setEnabled(false);
				 updateOffrenewValT.setEnabled(false);
				 selectOffreupB.setEnabled(false);
				 
				 //supprimer offre
				 lblNewLabel.setEnabled(false);
				 selectedOffredeleteC.setEnabled(false);
				 applydeleteOffreB.setEnabled(false);
				 
				 //afficher offres
				 OffreMessage.setVisible(false);
				 scrollPaneOffre.setEnabled(false);
				 startOffre.setEnabled(false);
				
			}
		});
		
		updateOffreRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nomOffreQuery = "SELECT nomOffre FROM offres";
				try {
					Statement stm = (Statement) conn.createStatement();
					ResultSet rs = stm.executeQuery(nomOffreQuery);
					while(rs.next()) {
						selectedOffreupdateC.addItem(rs.getString(1));
					}
				} catch (Exception e2) {}
				
				//Ajouter offre
				LNomOffre.setEnabled(false);
				TNomOffre.setEnabled(false);
				LnbrLivreOffre.setEnabled(false);
				TNbrLivres.setEnabled(false);
				LTarif.setEnabled(false);
				TTarif.setEditable(false);
				ApplyaddOfferB.setEnabled(false);
				
				//modifier offre
				 updateOffreNomRB.setEnabled(true);
				 updateOffreNlivreRB.setEnabled(true);
				 updateOffreTarifRB.setEnabled(true);
				 updateOffreSelectOL.setEnabled(true);
				 selectedOffreupdateC.setEnabled(true);
				 updateOffrenewValL.setEnabled(true);
				 updateOffrenewValT.setEnabled(true);
				 selectOffreupB.setEnabled(true);
				 
				 //supprimer offre
				 lblNewLabel.setEnabled(false);
				 selectedOffredeleteC.setEnabled(false);
				 applydeleteOffreB.setEnabled(false);
				 
				 //afficher offres
				 OffreMessage.setVisible(false);
				 scrollPaneOffre.setEnabled(false);
				 startOffre.setEnabled(false);
				
			}
		});
		
		deleteOffreRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nomOffreQuery = "SELECT nomOffre FROM offres";
					Statement stm = (Statement) conn.createStatement();
					ResultSet rs = stm.executeQuery(nomOffreQuery);
					while(rs.next()) {
						selectedOffredeleteC.addItem(rs.getString(1));
					}
				} catch (Exception e2) {}
				//Ajouter offre
				LNomOffre.setEnabled(false);
				TNomOffre.setEnabled(false);
				LnbrLivreOffre.setEnabled(false);
				TNbrLivres.setEnabled(false);
				LTarif.setEnabled(false);
				TTarif.setEditable(false);
				ApplyaddOfferB.setEnabled(false);
				
				//modifier offre
				 updateOffreNomRB.setEnabled(false);
				 updateOffreNlivreRB.setEnabled(false);
				 updateOffreTarifRB.setEnabled(false);
				 updateOffreSelectOL.setEnabled(false);
				 selectedOffreupdateC.setEnabled(false);
				 updateOffrenewValL.setEnabled(false);
				 updateOffrenewValT.setEnabled(false);
				 selectOffreupB.setEnabled(false);
				 
				 //supprimer offre
				 lblNewLabel.setEnabled(true);
				 selectedOffredeleteC.setEnabled(true);
				 applydeleteOffreB.setEnabled(true);
				 
				 //afficher offres
				 OffreMessage.setVisible(false);
				 scrollPaneOffre.setEnabled(false);
				 startOffre.setEnabled(false);
				
			}
		});
		
		afficherOffreRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Ajouter offre
				LNomOffre.setEnabled(false);
				TNomOffre.setEnabled(false);
				LnbrLivreOffre.setEnabled(false);
				TNbrLivres.setEnabled(false);
				LTarif.setEnabled(false);
				TTarif.setEditable(false);
				ApplyaddOfferB.setEnabled(false);
				
				//modifier offre
				 updateOffreNomRB.setEnabled(false);
				 updateOffreNlivreRB.setEnabled(false);
				 updateOffreTarifRB.setEnabled(false);
				 updateOffreSelectOL.setEnabled(false);
				 selectedOffreupdateC.setEnabled(false);
				 updateOffrenewValL.setEnabled(false);
				 updateOffrenewValT.setEnabled(false);
				 selectOffreupB.setEnabled(false);
				 
				 //supprimer offre
				 lblNewLabel.setEnabled(false);
				 selectedOffredeleteC.setEnabled(false);
				 applydeleteOffreB.setEnabled(false);
				 
				 //afficher offres
				 OffreMessage.setVisible(true);
				 scrollPaneOffre.setEnabled(true);
				 startOffre.setEnabled(true);
				
			}
		});
		
		
		startOffre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(addOffreRB.isSelected())
				{
					String nom = TNomOffre.getText();
					int nbrLivres = Integer.parseInt(TNbrLivres.getText());
					float tarif = Float.parseFloat(TTarif.getText());
					offre.AjouterOffre(nom, nbrLivres, tarif);
				}
				else if(updateOffreRB.isSelected())
				{
					String nomOffre = selectedOffreupdateC.getSelectedItem().toString();
					int id = offre.nomToId(nomOffre);
					if(id == 0)
					{
						JOptionPane.showMessageDialog(App, "Selectioner une offre");
					}
					else
					{
						if(updateOffreNomRB.isSelected())
						{
							String newName = updateOffrenewValT.getText().toString();
							offre.updatenomOffre(id,newName);
							
							// update offers in the comboBox.
							String nomOffreQuery = "SELECT nomOffre FROM offres";
							selectedOffreupdateC.removeAllItems();
							selectedOffreupdateC.addItem("");
							try {
								Statement stm = (Statement) conn.createStatement();
								ResultSet rs = stm.executeQuery(nomOffreQuery);
								while(rs.next()) {
									selectedOffreupdateC.addItem(rs.getString(1));
								}
							} catch (Exception e2) {}
						}
						else if(updateOffreNlivreRB.isSelected())
						{
							int NBL = Integer.parseInt(updateOffrenewValT.getText().toString());
							offre.updateNombreLivre(id, NBL);
						}
						else if(updateOffreTarifRB.isSelected())
						{
							float Tarif = Float.parseFloat(updateOffrenewValT.getText().toString());
							offre.updatetarif(id, Tarif);
						}
					}
				}
				else if(deleteOffreRB.isSelected())
				{
					String nomOffre = selectedOffredeleteC.getSelectedItem().toString();
					int id = offre.nomToId(nomOffre);
					if(id == 0)
					{
						JOptionPane.showMessageDialog(App, "Selectioner une offre");
					}
					else
					{
						offre.deleteOffre(id);
						
						// update offers in the comboBox.
						String nomOffreQuery = "SELECT nomOffre FROM offres";
						selectedOffredeleteC.removeAllItems();
						selectedOffredeleteC.addItem("");
						try {
							Statement stm = (Statement) conn.createStatement();
							ResultSet rs = stm.executeQuery(nomOffreQuery);
							while(rs.next()) {
								selectedOffredeleteC.addItem(rs.getString(1));
							}
						} catch (Exception e2) {}
					}
				}
				
				else if(afficherOffreRB.isSelected())
				{
					afficherLesOffres();
				}
				
			}
		});
	// ------------------------------------------------------------
		
	// ---------------- Page Emprunt -----------------------------
		
		JLabel EmprImage = new JLabel();
		EmprImage.setBounds(0,0,1049,700);
		EmprImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("background.png")));
		Emprunt.add(EmprImage);
		
		JLabel EmprTtitleLabel = new JLabel("EMPRUNT");
		EmprTtitleLabel.setFont(new Font("Liberation Serif", Font.BOLD, 26));
		EmprTtitleLabel.setBounds(460, 10, 200, 30);
		EmprImage.add(EmprTtitleLabel);
		
		JButton startEmpr = new JButton(new ImageIcon(getClass().getClassLoader().getResource("go.png")));
		startEmpr.setBounds(970,585,50,50);
		startEmpr.setOpaque(false);
		startEmpr.setContentAreaFilled(false);
		startEmpr.setBorderPainted(false);
		startEmpr.setEnabled(false);
		EmprImage.add(startEmpr);
		
		JButton backEmpr = new JButton(new ImageIcon(getClass().getClassLoader().getResource("back2.png")));
		backEmpr.setBounds(10,585,50,50);
		backEmpr.setOpaque(false);
		backEmpr.setContentAreaFilled(false);
		backEmpr.setBorderPainted(false);
		EmprImage.add(backEmpr);
		
		backEmpr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				Home.setVisible(true);
				
			}
		});
		
	// Emprunter Livre
		
		JRadioButton EmprunterRB = new JRadioButton("Emprunter un livre");
		EmprunterRB.setBounds(5,30,250,30);
		EmprunterRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		EmprunterRB.setSelected(true);
		EmprunterRB.setOpaque(false);
		EmprunterRB.setContentAreaFilled(false);
		EmprunterRB.setBorderPainted(false);
		EmprImage.add(EmprunterRB);
		
		JLabel EmprnameL = new JLabel("ID cleint :");
		EmprnameL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		EmprnameL.setBounds(20, 100, 150, 30);
		EmprImage.add(EmprnameL);
		
		JTextField EmprnameT = new JTextField();
		EmprnameT.setBounds(145, 100, 150, 30);
		EmprnameT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		EmprImage.add(EmprnameT);
	 
		JButton VerifierClientIdB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		VerifierClientIdB.setBounds(300, 100, 50, 30);
		VerifierClientIdB.setOpaque(false);
		VerifierClientIdB.setContentAreaFilled(false);
		VerifierClientIdB.setBorderPainted(false);
		EmprImage.add(VerifierClientIdB);
		
		JLabel ChoiOffreL = new JLabel("Choisi l'offre :");
		ChoiOffreL.setBounds(450, 100, 150, 30);
		ChoiOffreL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		EmprImage.add(ChoiOffreL);
		
		JComboBox<String> ChoiOffreCB = new JComboBox<String>();
		ChoiOffreCB.setBounds(600, 100, 150, 30);
		ChoiOffreCB.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		ChoiOffreCB.setBackground(Color.white);
		ChoiOffreCB.addItem("");
		EmprImage.add(ChoiOffreCB);
		
		VerifierClientIdB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idText = EmprnameT.getText().toString();
				try {
				int id = Integer.parseInt(idText);
				//System.out.println(id);
				try {
					CallableStatement idStatement = conn.prepareCall("{? = call Client_existeID(?)}");
					idStatement.registerOutParameter(1,java.sql.Types.BOOLEAN);
					idStatement.setInt(2, id);
					idStatement.execute();
					Boolean CleintExiste = idStatement.getBoolean(1);
					if(CleintExiste == true)
					{
						JOptionPane.showMessageDialog(App, "Id Client valide");
						try {
							String nomOffreQuery = "SELECT nomOffre FROM offres";
							Statement stm = (Statement) conn.createStatement();
							ResultSet rs = stm.executeQuery(nomOffreQuery);
							while(rs.next()) {
								ChoiOffreCB.addItem(rs.getString(1));
							}
						} catch (Exception e2) {}
						
					}
					else
					{
						startEmpr.setEnabled(false);
						JOptionPane.showMessageDialog(App, "Id Client n\'est pas valide");
						ChoiOffreCB.removeAllItems();
						ChoiOffreCB.addItem("");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				}catch (Exception q) {
					JOptionPane.showMessageDialog(App, "Inserer un entier sur la zone ID");
					
					startEmpr.setEnabled(false);
				}
				}
				
		});
		
		JLabel IDexemsL = new JLabel("Entrez les ids des exemplaires  :");
		IDexemsL.setBounds(20, 150, 300, 30);
		IDexemsL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		EmprImage.add(IDexemsL);
		
		JTextField IDexemsT = new JTextField("Ex : 1-2-3");
		IDexemsT.setBounds(300, 150, 160, 30);
		IDexemsT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		EmprImage.add(IDexemsT);
		
		JButton ApplyEmpruntB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyEmpruntB.setBounds(500, 150, 50, 30);
		ApplyEmpruntB.setOpaque(false);
		ApplyEmpruntB.setContentAreaFilled(false);
		ApplyEmpruntB.setBorderPainted(false);
		EmprImage.add(ApplyEmpruntB);
		
		JTextField NEXS = new JTextField();
		
		ApplyEmpruntB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String selected = ChoiOffreCB.getSelectedItem().toString();
				String Exemplaires = IDexemsT.getText().toString();
				
				if(selected.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Choisi une offre");
					done = 0;
				}
				else
					done +=1;
				
				if(Exemplaires.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Entrez les ids des exemplaires");
					done = 0;
				}
				else
				{
					NEXS.setText(IDexemsT.getText().toString());
					
					done +=1;
				}
				if(done == 2)
					startEmpr.setEnabled(true);
				else
					startEmpr.setEnabled(false);
				
			}
		});
				
		
		//Retouner un livre
		
		JRadioButton RetourRB = new JRadioButton("Retourner un livre");
		RetourRB.setBounds(5,300,250,30);
		RetourRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		RetourRB.setOpaque(false);
		RetourRB.setContentAreaFilled(false);
		RetourRB.setBorderPainted(false);
		EmprImage.add(RetourRB);
				
		
		JLabel IDCL = new JLabel("ID du Client :");
		IDCL.setBounds(20, 360, 200, 30);
		IDCL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		IDCL.setEnabled(false);
		EmprImage.add(IDCL);
		
		JTextField IDCT = new JTextField("");
		IDCT.setBounds(190, 360, 100, 30);
		IDCT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		IDCT.setEnabled(false);
		EmprImage.add(IDCT); 
		
		JLabel ExeRetourL = new JLabel("Entrez les ids des exemplaires  :");
		ExeRetourL.setBounds(20, 400, 300, 30);
		ExeRetourL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ExeRetourL.setEnabled(false);
		EmprImage.add(ExeRetourL);
		
		JTextField ExeRetourT = new JTextField("Ex : 1-2-3");
		ExeRetourT.setBounds(300, 400, 160, 30);
		ExeRetourT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		ExeRetourT.setEnabled(false);
		EmprImage.add(ExeRetourT); 
				
				
		JButton ApplyRetourB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyRetourB.setBounds(500, 400, 50, 30);
		ApplyRetourB.setOpaque(false);
		ApplyRetourB.setContentAreaFilled(false);
		ApplyRetourB.setBorderPainted(false);
		ApplyRetourB.setEnabled(false);
		EmprImage.add(ApplyRetourB);	
		
		JTextField EXR = new JTextField();
		
		ApplyRetourB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				try {
					int id = Integer.parseInt(IDCT.getText().toString());
					done += 1;
					CallableStatement idStatement = conn.prepareCall("{? = call Client_existeID(?)}");
					idStatement.registerOutParameter(1,java.sql.Types.BOOLEAN);
					idStatement.setInt(2, id);
					idStatement.execute();
					Boolean CleintExiste = idStatement.getBoolean(1);
					if(CleintExiste == true)
					{
						JOptionPane.showMessageDialog(App, "Id Client valide");
						try {
							String nomOffreQuery = "SELECT nomOffre FROM offres";
							Statement stm = (Statement) conn.createStatement();
							ResultSet rs = stm.executeQuery(nomOffreQuery);
							while(rs.next()) {
								ChoiOffreCB.addItem(rs.getString(1));
							}
						} catch (Exception e2) {}
						
					}
					else
					{
						startEmpr.setEnabled(false);
						JOptionPane.showMessageDialog(App, "Id Client n\'est pas valide");
						ChoiOffreCB.removeAllItems();
						ChoiOffreCB.addItem("");
						done = 0;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Id Client est un entier");
					done = 0;
				}
				String idEs = ExeRetourT.getText().toString();
				if(idEs.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Entrez les ids des exemplaires");
					done = 0;
					
				}
				else
				{
					done += 1;
					EXR.setText(ExeRetourT.getText().toString());
				}
				
				if(done == 2)
					startEmpr.setEnabled(true);
				else
					startEmpr.setEnabled(false);
				
			}
		});
		
		ButtonGroup GB4 = new ButtonGroup();
		GB4.add(EmprunterRB);
		GB4.add(RetourRB);
		
		EmprunterRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Emtprunt
				EmprnameL.setEnabled(true);
				EmprnameT.setEnabled(true);
				VerifierClientIdB.setEnabled(true);
				ChoiOffreL.setEnabled(true);
				ChoiOffreCB.setEnabled(true);
				IDexemsL.setEnabled(true);
				IDexemsT.setEnabled(true);
				ApplyEmpruntB.setEnabled(true);
				
				//Retour
				ExeRetourL.setEnabled(false);
				ExeRetourT.setEnabled(false);
				ApplyRetourB.setEnabled(false);
				IDCT.setEnabled(false);
				IDCL.setEnabled(false);
				
				startEmpr.setEnabled(false);
				
			}
		});
		
		RetourRB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Emtprunt
				EmprnameL.setEnabled(false);
				EmprnameT.setEnabled(false);
				VerifierClientIdB.setEnabled(false);
				ChoiOffreL.setEnabled(false);
				ChoiOffreCB.setEnabled(false);
				IDexemsL.setEnabled(false);
				IDexemsT.setEnabled(false);
				ApplyEmpruntB.setEnabled(false);
				
				//Retour
				ExeRetourL.setEnabled(true);
				ExeRetourT.setEnabled(true);
				ApplyRetourB.setEnabled(true);
				IDCT.setEnabled(true);
				IDCL.setEnabled(true);
				
				startEmpr.setEnabled(false);
				
			}
		});
		
		
		
		startEmpr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(EmprunterRB.isSelected())
				{
					int idClient = Integer.parseInt(EmprnameT.getText().toString());
					String idEs = NEXS.getText().toString();
					String nomOffre = ChoiOffreCB.getSelectedItem().toString();
					String[] tempArray;
			        Vector<Integer> lesExem =new Vector<Integer>();
			        try {
			        	tempArray = idEs.split("-");
			        	for (int i = 0; i < tempArray.length; i++) {
			        		
					        lesExem.add(Integer.parseInt(tempArray[i]));
					        if(emprunt.verifierExemDispo(Integer.parseInt(tempArray[i])) == 0){
					        	JOptionPane.showMessageDialog(App, "L\'exemplaire de l\'ID " + tempArray[i] + " n\'est pas disponible");
					        }
			        	
					    }
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(App, "verifier les exemplaires que vous avez saisi");
						return;
					}
//		        
			        int idOffre = offre.nomToId(nomOffre);
			        Boolean status_client = emprunt.status_client(idClient);
			        System.out.println(status_client);
			        int nombre = offre.nombreLivresOffre(idOffre);
			        System.out.println(lesExem.size());
			        if(lesExem.size() > nombre)
			        {
			        	JOptionPane.showMessageDialog(App, "vous avez entre un nombre d'exemplaires superieur \n au nombre correspondant a cette offre");
						return;
			        }
			        else if(status_client)
			        {
			        	try {
							emprunt.emprunterLivre(idClient, idOffre);
							for (int i = 0; i <lesExem.size() ; i++)
							{
								emprunt.ajouterExemplaireEmprunte(idClient, lesExem.elementAt(i));
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(App, "erruer rencontre");
							return;
						}
			        }
			        else {
						JOptionPane.showMessageDialog(App, "Ce client a deja un emprunt non retourne");
						return;
					}
			        
				}
				else if(RetourRB.isSelected())
				{
					int idClient = Integer.parseInt(IDCT.getText().toString());
					String tempArray[];
					Vector<Integer> lesExem =new Vector<Integer>();
					
					try {
					tempArray = EXR.getText().toString().split("-");
					for (int i = 0; i < tempArray.length; i++) {
				        lesExem.add(Integer.parseInt(tempArray[i]));
				        }
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(App, "verifier les infos que vous avez saisi dans le champ d'exempalire.");
						
					}
					try {
						emprunt.retournerLivre(idClient);
						for (int i = 0; i <lesExem.size() ; i++)
							emprunt.supprimerExemplaireRetourne(idClient, lesExem.elementAt(i));
						
					    JOptionPane.showMessageDialog(App, "Retourn a ete fait avec succe ");

					}catch (Exception e2) {
						JOptionPane.showMessageDialog(App, "erruer rencontre","erreur", JOptionPane.ERROR_MESSAGE);
					} 
					
					
				}
				
				
			}
		});
	//------------------------------------------------------
		
	//---------------------- Page CLE ----------------------
		
		JLabel CLEImage = new JLabel();
		CLEImage.setBounds(0,0,1049,700);
		CLEImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("background.png")));
		CLE.add(CLEImage);
		
		JLabel CTtitleLabel = new JLabel("CHERCHER LIVRE / EXEMPLAIRE");
		CTtitleLabel.setFont(new Font("Liberation Serif", Font.BOLD, 26));
		CTtitleLabel.setBounds(300, 10, 450, 30);
		CLEImage.add(CTtitleLabel);
		
		JButton startCLE = new JButton(new ImageIcon(getClass().getClassLoader().getResource("go.png")));
		startCLE.setBounds(970,585,50,50);
		startCLE.setOpaque(false);
		startCLE.setContentAreaFilled(false);
		startCLE.setBorderPainted(false);
		startCLE.setEnabled(false);
		CLEImage.add(startCLE);
		
		JButton backCLE = new JButton(new ImageIcon(getClass().getClassLoader().getResource("back2.png")));
		backCLE.setBounds(10,585,50,50);
		backCLE.setOpaque(false);
		backCLE.setContentAreaFilled(false);
		backCLE.setBorderPainted(false);
		CLEImage.add(backCLE);
		
		backCLE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Home.setVisible(true);
				
			}
		});
		
	// Chercher Exemplaire
		
		JRadioButton ChercherExemplaireRB = new JRadioButton("Chercher un exemplaire");
		ChercherExemplaireRB.setBounds(5,30,250,30);
		ChercherExemplaireRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		ChercherExemplaireRB.setSelected(true);
		ChercherExemplaireRB.setOpaque(false);
		ChercherExemplaireRB.setContentAreaFilled(false);
		ChercherExemplaireRB.setBorderPainted(false);
		CLEImage.add(ChercherExemplaireRB);
		
		
		JLabel ChercherParE = new JLabel("Chercher par:");
		ChercherParE.setBounds(20, 80, 150, 30);
		ChercherParE.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		CLEImage.add(ChercherParE);
		
		JComboBox<String> typeChercheEx2 = new JComboBox<>();
		typeChercheEx2.addItem("");
		typeChercheEx2.addItem("Id Exemplaire");
		typeChercheEx2.addItem("Id Livre");
		typeChercheEx2.addItem("Disponible");
		typeChercheEx2.addItem("id Livre et dispo");
		typeChercheEx2.setBounds(140,80,150,30);
		typeChercheEx2.setBackground(Color.white);
		typeChercheEx2.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		CLEImage.add(typeChercheEx2);
		
		JLabel chercheValEx2L = new JLabel("Inserer La valeur du Recherche :");
		chercheValEx2L.setBounds(310, 80, 300, 30);
		chercheValEx2L.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//		chercheValEx2L.setEnabled(false);
		CLEImage.add(chercheValEx2L);
		
		JTextField chercheValEx2T = new JTextField();
		chercheValEx2T.setBounds(580, 80, 150, 30);
		chercheValEx2T.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//		chercheValEx2T.setEnabled(false);
		CLEImage.add(chercheValEx2T);
		
		JLabel cherchedispoE2 = new JLabel("disponible : ");
		cherchedispoE2.setBounds(740, 80, 150, 30);
		cherchedispoE2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
//		cherchedispoE2.setEnabled(false);
		CLEImage.add(cherchedispoE2);
		
		JComboBox<String> ChDispoEx2 = new JComboBox<String>();
		ChDispoEx2.addItem("");
		ChDispoEx2.addItem("OUI");
		ChDispoEx2.addItem("NON");
		ChDispoEx2.setBounds(870,80,70,30);
		ChDispoEx2.setBackground(Color.white);
		ChDispoEx2.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
//		ChDispoEx2.setEnabled(false);
		CLEImage.add(ChDispoEx2);
		
		
		JButton ApplyChercherExB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyChercherExB.setBounds(950, 80, 50, 30);
		ApplyChercherExB.setOpaque(false);
		ApplyChercherExB.setContentAreaFilled(false);
		ApplyChercherExB.setBorderPainted(false);
//		ApplyChercherExB.setEnabled(false);
		CLEImage.add(ApplyChercherExB);	
		
		ApplyChercherExB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Selected = typeChercheEx2.getSelectedItem().toString();
				int done = 0;
				
				if(Selected.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Selectionne un type de recherche");
					done = 0;
				}
				else if(Selected.equals("Id Exemplaire") || Selected.equals("Id Livre"))
				{
					try {
						int testInt = Integer.parseInt(chercheValEx2T.getText().toString());
						done += 1;
					} catch (Exception e2) {
						done = 0;
						JOptionPane.showMessageDialog(App, "ID est un entier");
					}
				}
				else if(Selected.equals("Disponible"))
				{
					String dispo = ChDispoEx2.getSelectedItem().toString();
					if(dispo.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Selectioner la disponibilite");
						done = 0;
					}
					else
						done +=1;
				}
				else if(Selected.equals("id Livre et dispo"))
				{
					int test = 0;
					try {
						int testInt = Integer.parseInt(chercheValEx2T.getText().toString());
						test += 1;
					} catch (Exception e2) {
						test = 0;
						JOptionPane.showMessageDialog(App, "ID est un entier");
					}
					
					String dispo = ChDispoEx2.getSelectedItem().toString();
					if(dispo.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Selectioner la disponibilite");
						test = 0;
					}
					else
						test +=1;
					
					if(test == 2)
						done +=1;
					else
						done = 0;
				}
				System.out.println(done);
				if(done == 1)
					startCLE.setEnabled(true);
				else
					startCLE.setEnabled(false);
				
			}
		});
		
		
		
	// Chercher Livre
	
			JRadioButton ChercherLivreRB = new JRadioButton("Chercher un livre");
			ChercherLivreRB.setBounds(5,130,250,30);
			ChercherLivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
			ChercherLivreRB.setOpaque(false);
			ChercherLivreRB.setContentAreaFilled(false);
			ChercherLivreRB.setBorderPainted(false);
			CLEImage.add(ChercherLivreRB);
		
			JLabel ChercherParL = new JLabel("Chercher par:");
			ChercherParL.setBounds(20, 170, 150, 30);
			ChercherParL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			ChercherParL.setEnabled(false);
			CLEImage.add(ChercherParL);
			
			JComboBox<String> typeChercheLi = new JComboBox<>();
			typeChercheLi.addItem("");
			typeChercheLi.addItem("Id Livre");
			typeChercheLi.addItem("Nom Livre");
			typeChercheLi.addItem("Id Categorie");
			typeChercheLi.addItem("Id Auteur");
			typeChercheLi.setBounds(140,170,150,30);
			typeChercheLi.setBackground(Color.white);
			typeChercheLi.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
			typeChercheLi.setEnabled(false);
			CLEImage.add(typeChercheLi);
			
			JLabel chercheValL2 = new JLabel("Inserer La valeur du Recherche :");
			chercheValL2.setBounds(310, 170, 300, 30);
			chercheValL2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			chercheValL2.setEnabled(false);
			CLEImage.add(chercheValL2);
			
			JTextField IdELT2 = new JTextField();
			IdELT2.setBounds(580, 170, 250, 30);
			IdELT2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			IdELT2.setEnabled(false);
			CLEImage.add(IdELT2);
		
			JButton ApplyChercherLiB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
			ApplyChercherLiB.setBounds(850, 170, 50, 30);
			ApplyChercherLiB.setOpaque(false);
			ApplyChercherLiB.setContentAreaFilled(false);
			ApplyChercherLiB.setBorderPainted(false);
			ApplyChercherLiB.setEnabled(false);
			CLEImage.add(ApplyChercherLiB);	
			
			
		
			JScrollPane scrollPaneLE = new JScrollPane(table);
			scrollPaneLE.setBounds(108, 330, 800, 200);
			scrollPaneLE.setEnabled(false);
			CLEImage.add(scrollPaneLE);
			
			table = new JTable();
			scrollPaneLE.setViewportView(table);
			
			ApplyChercherLiB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String Selected = typeChercheLi.getSelectedItem().toString();
					int done = 0;
					 
					if(Selected.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Selectionne un type de recherche");
						done = 0;
					}
					else if(Selected.equals("Id Livre") || Selected.equals("Id Categorie") || Selected.equals("Id Auteur"))
					{
						try {
							int testInt = Integer.parseInt(IdELT2.getText().toString());
							done += 1;
						} catch (Exception e2) {
							done = 0;
							JOptionPane.showMessageDialog(App, "ID est un entier");
						}
					}
					else
					{
						String nom = IdELT2.getText().toString();
						if(nom.equals(""))
						{
							JOptionPane.showMessageDialog(App, "Inserer le nom de livre");
							done = 0;
						}
						else
							done +=1;
					}
					if(done == 1)
						startCLE.setEnabled(true);
					else
						startCLE.setEnabled(false);
					
					
				}
			});
		
			ButtonGroup GB5 = new ButtonGroup();
			GB5.add(ChercherExemplaireRB);
			GB5.add(ChercherLivreRB);
			
		
			ChercherExemplaireRB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ChercherParE.setEnabled(true);
					typeChercheEx2.setEnabled(true);
					chercheValEx2L.setEnabled(true);
					chercheValEx2T.setEnabled(true);
					cherchedispoE2.setEnabled(true);
					ChDispoEx2.setEnabled(true);
					ApplyChercherExB.setEnabled(true);
					
					ChercherParL.setEnabled(false);
					typeChercheLi.setEnabled(false);
					chercheValL2.setEnabled(false);
					IdELT2.setEnabled(false);
					ApplyChercherLiB.setEnabled(false);
					
					
				}
			});
			ChercherLivreRB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					ChercherParE.setEnabled(false);
					typeChercheEx2.setEnabled(false);
					chercheValEx2L.setEnabled(false);
					chercheValEx2T.setEnabled(false);
					cherchedispoE2.setEnabled(false);
					ChDispoEx2.setEnabled(false);
					ApplyChercherExB.setEnabled(false);
					
					ChercherParL.setEnabled(true);
					typeChercheLi.setEnabled(true);
					chercheValL2.setEnabled(true);
					IdELT2.setEnabled(true);
					ApplyChercherLiB.setEnabled(true);
					
				}
			});
		
			startCLE.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(ChercherExemplaireRB.isSelected())
					{
						String type = typeChercheEx2.getSelectedItem().toString();
						if(type.equals("Id Exemplaire"))
						{
							int id = Integer.parseInt(chercheValEx2T.getText());
							chercherExemplaireParIDE(id);
						}
						else if(type.equals("Id Livre"))
						{
							int id = Integer.parseInt(chercheValEx2T.getText());
							chercherExemplaireParIDL(id);
						}
						else if(type.equals("Disponible"))
						{
							String dispo = ChDispoEx2.getSelectedItem().toString();
							if(dispo.equals("OUI"))
							{
								chercherExemplairePardispo(1);
							}
							else if(dispo.equals("NON"))
							{
								chercherExemplairePardispo(0);
						}
							
						}
						else if(type.equals("id Livre et dispo"))
						{
							int id = Integer.parseInt(chercheValEx2T.getText());
							
							String dispo = ChDispoEx2.getSelectedItem().toString();
							if(dispo.equals("OUI"))
							{
								chercherExemplaireParIDLetDispo(id,1);
							}
							else if(dispo.equals("NON"))
							{
								chercherExemplaireParIDLetDispo(id,0);
							}
							
						}
					}
					if(ChercherLivreRB.isSelected())
					{
						String type = typeChercheLi.getSelectedItem().toString();
						if(type.equals("Id Livre"))
						{
							int id = Integer.parseInt(IdELT2.getText().toString());
							chercherLivreParID(1, id);
						}
						else if(type.equals("Nom Livre"))
						{
							String nom = IdELT2.getText().toString();
							chercherLivreParNom(nom);
						}
						else if(type.equals("Id Categorie"))
						{
							int id = Integer.parseInt(IdELT2.getText().toString());
							chercherLivreParID(3, id);
						}
						else if(type.equals("Id Auteur"))
						{
							int id = Integer.parseInt(IdELT2.getText().toString());
							chercherLivreParID(4, id);
						}
					}
					
					
				}
			});
	// -------------------------------------------------------
		
	//---------------------- Page Livre ------------------------
			
			JLabel LivreImage = new JLabel();
			LivreImage.setBounds(0,0,1049,700);
			LivreImage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("background.png")));
			Livre.add(LivreImage);
			
			JLabel LivretitleLabel = new JLabel("LIVRE - CATEGORIE - AUTEUR");
			LivretitleLabel.setFont(new Font("Liberation Serif", Font.BOLD, 26));
			LivretitleLabel.setBounds(300, 10, 400, 30);
			LivreImage.add(LivretitleLabel);
			
			JButton startLivre = new JButton(new ImageIcon(getClass().getClassLoader().getResource("go.png")));
			startLivre.setBounds(970,585,50,50);
			startLivre.setOpaque(false);
			startLivre.setContentAreaFilled(false);
			startLivre.setBorderPainted(false);
			startLivre.setEnabled(false);
			LivreImage.add(startLivre);
			
			JButton backLivre = new JButton(new ImageIcon(getClass().getClassLoader().getResource("back2.png")));
			backLivre.setBounds(10,585,50,50);
			backLivre.setOpaque(false);
			backLivre.setContentAreaFilled(false);
			backLivre.setBorderPainted(false);
			LivreImage.add(backLivre);
			
			backLivre.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Livre.setVisible(false);
					Home.setVisible(true);
					
				}
			});
		
		// Livre
			
			JRadioButton LivreRB = new JRadioButton("LIVRE");
			LivreRB.setBounds(5,40,100,30);
			LivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
			LivreRB.setSelected(true);
			LivreRB.setOpaque(false);
			LivreRB.setContentAreaFilled(false);
			LivreRB.setBorderPainted(false);
			LivreImage.add(LivreRB);
			
		// Ajouter Livre
			
			JRadioButton AddLivreRB = new JRadioButton("Ajouter un livre");
			AddLivreRB.setBounds(20,80,250,30);
			AddLivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
			AddLivreRB.setSelected(true);
			AddLivreRB.setOpaque(false);
			AddLivreRB.setContentAreaFilled(false);
			AddLivreRB.setBorderPainted(false);
			LivreImage.add(AddLivreRB);
			
			JLabel NomLivreL = new JLabel("Nom de livre :");
			NomLivreL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			NomLivreL.setBounds(40, 120, 150, 30);
			LivreImage.add(NomLivreL);
			
			JTextField NomLivreT = new JTextField();
			NomLivreT.setBounds(155, 120, 200, 30);
			NomLivreT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			LivreImage.add(NomLivreT);
			
			JLabel CatL = new JLabel("Categorie:");
			CatL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			CatL.setBounds(40, 160, 150, 30);
			LivreImage.add(CatL);
			
			JComboBox<String> CatCB = new JComboBox<String>();
			CatCB.setBounds(155,160,150,30);
			CatCB.setBackground(Color.white);
			CatCB.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
			CatCB.addItem("");
			String nomCatQuery = "SELECT nomCategorie FROM categorie";
			try {
				Statement stm = (Statement) conn.createStatement();
				ResultSet rs = stm.executeQuery(nomCatQuery);
				while(rs.next()) {
					CatCB.addItem(rs.getString(1));
				}
			} catch (Exception e2) {}
			LivreImage.add(CatCB);
			
			JLabel idAuteurL = new JLabel("Id Auteur :");
			idAuteurL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			idAuteurL.setBounds(40, 200, 150, 30);
			LivreImage.add(idAuteurL);
			
			JTextField idAuteurT = new JTextField();
			idAuteurT.setBounds(155, 200, 120, 30);
			idAuteurT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			LivreImage.add(idAuteurT);
		 
			JButton ApplyAddLivreB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
			ApplyAddLivreB.setBounds(285, 200, 50, 30);
			ApplyAddLivreB.setOpaque(false);
			ApplyAddLivreB.setContentAreaFilled(false);
			ApplyAddLivreB.setBorderPainted(false);
//			ApplyAddLivreB.setEnabled(false);
			LivreImage.add(ApplyAddLivreB);	
		
			ApplyAddLivreB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int done = 0;
					String Nom = NomLivreT.getText().toString();
					String Cat = CatCB.getSelectedItem().toString();
					if(Nom.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Inserer le nom de livre");
						done = 0;
					}
					else
						done +=1;
					if(Cat.equals(""))
					{
						JOptionPane.showMessageDialog(App, "Selectionner une categorie");
						done = 0;
					}
					else
						done += 1;
					try {
						int idAuteur = Integer.parseInt(idAuteurT.getText().toString());
						done +=1;
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(App, "Id Auteur est un entier");
						done = 0;
					}
					if (done == 3)
						startLivre.setEnabled(true);
					else
						startLivre.setEnabled(false);
				}
			});
		
	// modifier Livre
	
			JRadioButton updateLivreRB = new JRadioButton("Modifier un livre");
			updateLivreRB.setBounds(20,240,250,30);
			updateLivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
			updateLivreRB.setOpaque(false);
			updateLivreRB.setContentAreaFilled(false);
			updateLivreRB.setBorderPainted(false);
			LivreImage.add(updateLivreRB);
			
			JLabel IDLivreL = new JLabel("ID de livre :");
			IDLivreL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			IDLivreL.setBounds(40, 280, 150, 30);
		
			LivreImage.add(IDLivreL);
			
			JTextField IDLivreT = new JTextField();
			IDLivreT.setBounds(155, 280, 100, 30);
			IDLivreT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			
			LivreImage.add(IDLivreT);
			
			JLabel updateLL = new JLabel("modifier :");
			updateLL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			updateLL.setBounds(40, 320, 150, 30);
			
			LivreImage.add(updateLL);
			
			JComboBox<String> updateLCB = new JComboBox<String>();
			updateLCB.setBounds(155,320,150,30);
			updateLCB.setBackground(Color.white);
			updateLCB.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
			updateLCB.addItem("");
			updateLCB.addItem("Nom Livre");
			updateLCB.addItem("Categorie");
			updateLCB.addItem("ID Auteur");
			
			LivreImage.add(updateLCB);

	
			JLabel CatL2 = new JLabel("Categorie:");
			CatL2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			CatL2.setBounds(40, 360, 150, 30);
		
			LivreImage.add(CatL2);
			
			JComboBox<String> CatCB2 = new JComboBox<String>();
			CatCB2.setBounds(155,360,150,30);
			CatCB2.setBackground(Color.white);
			CatCB2.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
			CatCB2.addItem("");
			try {
				Statement stm = (Statement) conn.createStatement();
				ResultSet rs = stm.executeQuery(nomCatQuery);
				while(rs.next()) {
					CatCB2.addItem(rs.getString(1));
				}
			} catch (Exception e2) {}
			LivreImage.add(CatCB2);
		
			JLabel newIDNL = new JLabel("Nom livre ou ID Auteur:");
			newIDNL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			newIDNL.setBounds(40, 400, 250, 30);
			LivreImage.add(newIDNL);
		
			JTextField newIDNT = new JTextField();
			newIDNT.setBounds(250, 400, 100, 30);
			newIDNT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
			LivreImage.add(newIDNT);
			
			JButton ApplyuUpdateLivreB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
			ApplyuUpdateLivreB.setBounds(355, 400, 50, 30);
			ApplyuUpdateLivreB.setOpaque(false);
			ApplyuUpdateLivreB.setContentAreaFilled(false);
			ApplyuUpdateLivreB.setBorderPainted(false);
//			ApplyuUpdateLivreB.setEnabled(false);
			LivreImage.add(ApplyuUpdateLivreB);	

			ApplyuUpdateLivreB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int done = 0;
					
					try {
						int IdLivre = Integer.parseInt(IDLivreT.getText().toString());
						CallableStatement st = conn.prepareCall("{? = call livre_existeID(?)}");
						st.registerOutParameter(1,java.sql.Types.INTEGER);
						st.setInt(2, IdLivre);
						st.execute();
						int existe = st.getInt(1);
						if(existe == 1)
						{
							done +=1;
						}
						else
						{
							JOptionPane.showMessageDialog(App, "IdLivre n\'pas valide");
							done = 0;
						}
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(App, "IdLivre est un entier");
						done = 0;
					}
					
					String selected = updateLCB.getSelectedItem().toString();
					if(selected.equals(""))
					{
						done = 0;
						JOptionPane.showMessageDialog(App, "Selectioner le type de modification");
					}
					else if(selected.equals("Nom Livre"))
					{
						if(newIDNT.getText().toString().equals(""))
						{
							done = 0;
							JOptionPane.showMessageDialog(App, "Inserer le nouveau nom de livre");
						}
						else
							done +=1;
					}
					else if (selected.equals("ID Auteur"))
					{
						try {
							int IDL = Integer.parseInt(newIDNT.getText().toString());
							done +=1;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(App, "Nouveau Id Livre est un entier");
							done = 0;
						}
					}
					else if (selected.equals("Categorie"))
					{
						String Cat = CatCB2.getSelectedItem().toString();
						if(Cat.equals(""))
						{
							done = 0;
							JOptionPane.showMessageDialog(App, "Selectioner une categorie");
						}
						else
							done += 1;
			
					}
					if (done == 2)
						startLivre.setEnabled(true);
					else
						startLivre.setEnabled(false);
				}
			});
		
	// Supprimer Livre

		JRadioButton deleteLivreRB = new JRadioButton("Supprimer un livre");
		deleteLivreRB.setBounds(20,440,250,30);
		deleteLivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		deleteLivreRB.setOpaque(false);
		deleteLivreRB.setContentAreaFilled(false);
		deleteLivreRB.setBorderPainted(false);
		LivreImage.add(deleteLivreRB);
		
		JLabel IDLivreL2 = new JLabel("ID de livre :");
		IDLivreL2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		IDLivreL2.setBounds(40, 480, 150, 30);
		LivreImage.add(IDLivreL2);
		
		JTextField IDLivreT2 = new JTextField();
		IDLivreT2.setBounds(155, 480, 100, 30);
		IDLivreT2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LivreImage.add(IDLivreT2);
		
		JButton ApplyuDeleteLivreB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyuDeleteLivreB.setBounds(260, 480, 50, 30);
		ApplyuDeleteLivreB.setOpaque(false);
		ApplyuDeleteLivreB.setContentAreaFilled(false);
		ApplyuDeleteLivreB.setBorderPainted(false);
//		ApplyuDeleteLivreB.setEnabled(false);
		LivreImage.add(ApplyuDeleteLivreB);	
		
		ApplyuDeleteLivreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int done = 0;
				try {
					int idL = Integer.parseInt(IDLivreT2.getText().toString());
					done +=1;
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(App, "Inserer un entier");
					done = 0;
				}
				
				if(done == 1)
					startLivre.setEnabled(true);
				else
					startLivre.setEnabled(false);
			}
		});
		
	// Afficher Livre

		JRadioButton ShowLivreRB = new JRadioButton("Afficher les livres");
		ShowLivreRB.setBounds(20,520,250,30);
		ShowLivreRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		ShowLivreRB.setOpaque(false);
		ShowLivreRB.setContentAreaFilled(false);
		ShowLivreRB.setBorderPainted(false);
		LivreImage.add(ShowLivreRB);
		
		JLabel Lmessage = new JLabel("Cliquer sur \'GO\' pour afficher les lives");
		Lmessage.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		Lmessage.setBounds(40, 550, 500, 30);
		LivreImage.add(Lmessage);		
		
		// Categorie
		
		JRadioButton CategorieRB = new JRadioButton("CATEGORIE");
		CategorieRB.setBounds(600,75,200,30);
		CategorieRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		CategorieRB.setSelected(true);
		CategorieRB.setOpaque(false);
		CategorieRB.setContentAreaFilled(false);
		CategorieRB.setBorderPainted(false);
		LivreImage.add(CategorieRB);
		
	// Ajouter categorie
		
		JRadioButton AddCatRB = new JRadioButton("Ajouter une categorie");
		AddCatRB.setBounds(615,115,250,30);
		AddCatRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		AddCatRB.setSelected(true);
		AddCatRB.setOpaque(false);
		AddCatRB.setContentAreaFilled(false);
		AddCatRB.setBorderPainted(false);
		LivreImage.add(AddCatRB);		
		
		JLabel NomCatL = new JLabel("Nom :");
		NomCatL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		NomCatL.setBounds(640, 155, 100, 30);
		LivreImage.add(NomCatL);
		
		JTextField NomCatT = new JTextField();
		NomCatT.setBounds(720, 155, 150, 30);
		NomCatT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LivreImage.add(NomCatT);
		
		JButton ApplyuAddCatB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyuAddCatB.setBounds(875, 155, 50, 30);
		ApplyuAddCatB.setOpaque(false);
		ApplyuAddCatB.setContentAreaFilled(false);
		ApplyuAddCatB.setBorderPainted(false);
//		ApplyuAddCatB.setEnabled(false);
		LivreImage.add(ApplyuAddCatB);	
		
		ApplyuAddCatB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String Nom = NomCatT.getText().toString();
				
				if(Nom.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Inserer le nom du categotie");
					done = 0;
				}
				else
					done +=1;
				
				if(done == 1)
					startLivre.setEnabled(true);
				else
					startLivre.setEnabled(false);
			}
		});
		
		
	// Supprimer categorie

		JRadioButton DeleteCatRB = new JRadioButton("Supprimer une categorie");
		DeleteCatRB.setBounds(615,195,250,30);
		DeleteCatRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		DeleteCatRB.setOpaque(false);
		DeleteCatRB.setContentAreaFilled(false);
		DeleteCatRB.setBorderPainted(false);
		LivreImage.add(DeleteCatRB);
		
		JLabel NomCatL2 = new JLabel("Categorie :");
		NomCatL2.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		NomCatL2.setBounds(640, 235, 150, 30);
		LivreImage.add(NomCatL2);
		
		JComboBox<String> CatCB3 = new JComboBox<String>();
		CatCB3.setBounds(730,235,150,30);
		CatCB3.setBackground(Color.white);
		CatCB3.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		LivreImage.add(CatCB3);
		CatCB3.addItem("");
		try {
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = stm.executeQuery(nomCatQuery);
			while(rs.next()) {
				CatCB3.addItem(rs.getString(1));
			}
		} catch (Exception e2) {}
		
		
		
		JButton ApplyuDeleteCatB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyuDeleteCatB.setBounds(885, 235, 50, 30);
		ApplyuDeleteCatB.setOpaque(false);
		ApplyuDeleteCatB.setContentAreaFilled(false);
		ApplyuDeleteCatB.setBorderPainted(false);
//		ApplyuDeleteCatB.setEnabled(false);
		LivreImage.add(ApplyuDeleteCatB);	
		
		ApplyuDeleteCatB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String cat = CatCB3.getSelectedItem().toString();
				if(cat.equals(""))
				{
					done = 0;
					JOptionPane.showMessageDialog(App, "Selectioner une categorie");
				}
				else
					done +=1;
				
				if(done == 1)
					startLivre.setEnabled(true);
				else
					startLivre.setEnabled(false);
				
			}
		});

	// Afficher Categorie

		JRadioButton ShowCatRB = new JRadioButton("Afficher les categories");
		ShowCatRB.setBounds(615,275,250,30);
		ShowCatRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		ShowCatRB.setOpaque(false);
		ShowCatRB.setContentAreaFilled(false);
		ShowCatRB.setBorderPainted(false);
		LivreImage.add(ShowCatRB);
		
		JLabel Cmessage = new JLabel("Cliquer sur \'GO\' pour afficher les categorie");
		Cmessage.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		Cmessage.setBounds(630, 305, 500, 30);
		LivreImage.add(Cmessage);

		
	// AUTEUR
		
		JRadioButton AuteurRB = new JRadioButton("AUTEUR");
		AuteurRB.setBounds(600,345,200,30);
		AuteurRB.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		AuteurRB.setSelected(true);
		AuteurRB.setOpaque(false);
		AuteurRB.setContentAreaFilled(false);
		AuteurRB.setBorderPainted(false);
		LivreImage.add(AuteurRB);		
		
		
	//Ajouter Auteur
		
		JRadioButton AddAuteurRB = new JRadioButton("Ajouter un auteur");
		AddAuteurRB.setBounds(615,385,250,30);
		AddAuteurRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		AddAuteurRB.setSelected(true);
		AddAuteurRB.setOpaque(false);
		AddAuteurRB.setContentAreaFilled(false);
		AddAuteurRB.setBorderPainted(false);
		LivreImage.add(AddAuteurRB);
		
		JLabel NomAutL = new JLabel("Nom :");
		NomAutL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		NomAutL.setBounds(640, 425, 100, 30);
		LivreImage.add(NomAutL);
		
		JTextField NomAutT = new JTextField();
		NomAutT.setBounds(720, 425, 150, 30);
		NomAutT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LivreImage.add(NomAutT);
		
		JButton ApplyAddAutB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyAddAutB.setBounds(875, 425, 50, 30);
		ApplyAddAutB.setOpaque(false);
		ApplyAddAutB.setContentAreaFilled(false);
		ApplyAddAutB.setBorderPainted(false);
//		ApplyAddAutB.setEnabled(false);
		LivreImage.add(ApplyAddAutB);			
		
		ApplyAddAutB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int done = 0;
				String Nom = NomAutT.getText().toString();
				
				if(Nom.equals(""))
				{
					JOptionPane.showMessageDialog(App, "Inserer le nom du l\'auteur");
					done = 0;
				}
				else
					done +=1;
				
				if(done == 1)
					startLivre.setEnabled(true);
				else
					startLivre.setEnabled(false);
			}
		});
		
		
// Supprimer auteur

		JRadioButton DeleteAutRB = new JRadioButton("Supprimer un auteur");
		DeleteAutRB.setBounds(615,465,250,30);
		DeleteAutRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		DeleteAutRB.setOpaque(false);
		DeleteAutRB.setContentAreaFilled(false);
		DeleteAutRB.setBorderPainted(false);
		LivreImage.add(DeleteAutRB);
		
		JLabel IDAutL = new JLabel("Id Auteur :");
		IDAutL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		IDAutL.setBounds(640, 505, 150, 30);
		LivreImage.add(IDAutL);
		
		JTextField IDAutT = new JTextField();
		IDAutT.setBounds(725, 505, 150, 30);
		IDAutT.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		LivreImage.add(IDAutT);
				
		JButton ApplyDeleteAutB = new JButton(new ImageIcon(getClass().getClassLoader().getResource("correct.png")));
		ApplyDeleteAutB.setBounds(880, 505, 50, 30);
		ApplyDeleteAutB.setOpaque(false);
		ApplyDeleteAutB.setContentAreaFilled(false);
		ApplyDeleteAutB.setBorderPainted(false);
//		ApplyDeleteAutB.setEnabled(false);
		LivreImage.add(ApplyDeleteAutB);	
		
		ApplyDeleteAutB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int done = 0;
				try {
					int id = Integer.parseInt(IDAutT.getText().toString());
					done +=1;
				} catch (Exception e2) {
					done = 0;
					JOptionPane.showMessageDialog(App, "Inserer un entier");
				}
				
				if(done == 1)
					startLivre.setEnabled(true);
				else
					startLivre.setEnabled(false);
				
			}
		});
		
		
	// Afficher Auteur

		JRadioButton ShowAutRB = new JRadioButton("Afficher les Auteurs");
		ShowAutRB.setBounds(615,545,250,30);
		ShowAutRB.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		ShowAutRB.setOpaque(false);
		ShowAutRB.setContentAreaFilled(false);
		ShowAutRB.setBorderPainted(false);
		LivreImage.add(ShowAutRB);
		
		JLabel Amessage = new JLabel("Cliquer sur \'GO\' pour afficher les auteurs");
		Amessage.setFont(new Font("Liberation Serif", Font.BOLD, 17));
		Amessage.setBounds(630, 575, 500, 30);
		LivreImage.add(Amessage);		
		
		
		
	ButtonGroup GBL = new ButtonGroup();
	GBL.add(AddLivreRB);
	GBL.add(deleteLivreRB);
	GBL.add(updateLivreRB);
	GBL.add(ShowLivreRB);
	
	ButtonGroup GBC = new ButtonGroup();
	GBC.add(AddCatRB);
	GBC.add(DeleteCatRB);
	GBC.add(ShowCatRB);
	
	ButtonGroup GBA = new ButtonGroup();
	GBA.add(AddAuteurRB);
	GBA.add(DeleteAutRB);
	GBA.add(ShowAutRB);
	
	ButtonGroup GB6 = new ButtonGroup();
	GB6.add(LivreRB);
	GB6.add(CategorieRB);
	GB6.add(AuteurRB);
	
	
	AddLivreRB.setEnabled(true);
	deleteLivreRB.setEnabled(true);
	updateLivreRB.setEnabled(true);
	ShowLivreRB.setEnabled(true);
	
	AddCatRB.setEnabled(false);
	DeleteCatRB.setEnabled(false);
	ShowCatRB.setEnabled(false);

	AddAuteurRB.setEnabled(false);
	DeleteAutRB.setEnabled(false);
	ShowAutRB.setEnabled(false);
	
	//livre
	NomLivreL.setEnabled(true);
	NomLivreT.setEnabled(true);
	CatL.setEnabled(true);
	CatCB.setEnabled(true);
	idAuteurT.setEnabled(true);
	idAuteurL.setEnabled(true);
	ApplyAddLivreB.setEnabled(true);
	
	IDLivreL.setEnabled(false);
	IDLivreT.setEnabled(false);
	updateLL.setEnabled(false);
	updateLCB.setEnabled(false);
	CatL2.setEnabled(false);
	CatCB2.setEnabled(false);
	newIDNL.setEnabled(false);
	newIDNT.setEnabled(false);
	ApplyuUpdateLivreB.setEnabled(false);
	
	IDLivreL2.setEnabled(false);
	IDLivreT2.setEnabled(false);
	ApplyuDeleteLivreB.setEnabled(false);
	Lmessage.setVisible(false);
	
	//Categorie
	NomCatL.setEnabled(false);
	NomCatT.setEnabled(false);
	ApplyuAddCatB.setEnabled(false);
	
	NomCatL2.setEnabled(false);
	CatCB3.setEnabled(false);
	ApplyuDeleteCatB.setEnabled(false);
	
	Cmessage.setVisible(false);
	
	//Auteur
	
	NomAutL.setEnabled(false);
	NomAutT.setEnabled(false);
	ApplyAddAutB.setEnabled(false);
	IDAutL.setEnabled(false);
	IDAutT.setEnabled(false);
	ApplyDeleteAutB.setEnabled(false);
	
	Amessage.setVisible(false);
	
	LivreRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(true);
			deleteLivreRB.setEnabled(true);
			updateLivreRB.setEnabled(true);
			ShowLivreRB.setEnabled(true);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(true);
			NomLivreT.setEnabled(true);
			CatL.setEnabled(true);
			CatCB.setEnabled(true);
			idAuteurT.setEnabled(true);
			idAuteurL.setEnabled(true);
			ApplyAddLivreB.setEnabled(true);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
	
	CategorieRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(true);
			DeleteCatRB.setEnabled(true);
			ShowCatRB.setEnabled(true);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(true);
			NomCatT.setEnabled(true);
			ApplyuAddCatB.setEnabled(true);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	AuteurRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(true);
			DeleteAutRB.setEnabled(true);
			ShowAutRB.setEnabled(true);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(true);
			NomAutT.setEnabled(true);
			ApplyAddAutB.setEnabled(true);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	AddLivreRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			deleteLivreRB.setEnabled(true);
			updateLivreRB.setEnabled(true);
			ShowLivreRB.setEnabled(true);
			AddLivreRB.setEnabled(true);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(true);
			NomLivreT.setEnabled(true);
			CatL.setEnabled(true);
			CatCB.setEnabled(true);
			idAuteurT.setEnabled(true);
			idAuteurL.setEnabled(true);
			ApplyAddLivreB.setEnabled(true);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			CatCB.removeAllItems();
			CatCB.addItem("");
			String nomCatQuery = "SELECT nomCategorie FROM categorie";
			try {
				Statement stm = (Statement) conn.createStatement();
				ResultSet rs = stm.executeQuery(nomCatQuery);
				while(rs.next()) {
					CatCB.addItem(rs.getString(1));
				}
			} catch (Exception e2) {}
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	deleteLivreRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(true);
			deleteLivreRB.setEnabled(true);
			updateLivreRB.setEnabled(true);
			ShowLivreRB.setEnabled(true);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(true);
			IDLivreT2.setEnabled(true);
			ApplyuDeleteLivreB.setEnabled(true);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	updateLivreRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(true);
			deleteLivreRB.setEnabled(true);
			updateLivreRB.setEnabled(true);
			ShowLivreRB.setEnabled(true);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(true);
			IDLivreT.setEnabled(true);
			updateLL.setEnabled(true);
			updateLCB.setEnabled(true);
			CatL2.setEnabled(true);
			CatCB2.setEnabled(true);
			newIDNL.setEnabled(true);
			newIDNT.setEnabled(true);
			ApplyuUpdateLivreB.setEnabled(true);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			CatCB2.removeAllItems();
			CatCB2.addItem("");
			String nomCatQuery = "SELECT nomCategorie FROM categorie";
			try {
				Statement stm = (Statement) conn.createStatement();
				ResultSet rs = stm.executeQuery(nomCatQuery);
				while(rs.next()) {
					CatCB2.addItem(rs.getString(1));
				}
			} catch (Exception e2) {}
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	ShowLivreRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(true);
			deleteLivreRB.setEnabled(true);
			updateLivreRB.setEnabled(true);
			ShowLivreRB.setEnabled(true);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(true);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(true);
			
		}
	});	
	
	AddCatRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(true);
			DeleteCatRB.setEnabled(true);
			ShowCatRB.setEnabled(true);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(true);
			NomCatT.setEnabled(true);
			ApplyuAddCatB.setEnabled(true);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
	
	DeleteCatRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(true);
			DeleteCatRB.setEnabled(true);
			ShowCatRB.setEnabled(true);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(true);
			CatCB3.setEnabled(true);
			ApplyuDeleteCatB.setEnabled(true);
			
			Cmessage.setVisible(false);
			
			CatCB3.removeAllItems();
			CatCB3.addItem("");
			String nomCatQuery = "SELECT nomCategorie FROM categorie";
			try {
				Statement stm = (Statement) conn.createStatement();
				ResultSet rs = stm.executeQuery(nomCatQuery);
				while(rs.next()) {
					CatCB3.addItem(rs.getString(1));
				}
			} catch (Exception e2) {}
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	ShowCatRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(true);
			DeleteCatRB.setEnabled(true);
			ShowCatRB.setEnabled(true);

			AddAuteurRB.setEnabled(false);
			DeleteAutRB.setEnabled(false);
			ShowAutRB.setEnabled(false);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(true);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(true);
			
		}
	});
	
	AddAuteurRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(true);
			DeleteAutRB.setEnabled(true);
			ShowAutRB.setEnabled(true);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(true);
			NomAutT.setEnabled(true);
			ApplyAddAutB.setEnabled(true);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
	
	DeleteAutRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(true);
			DeleteAutRB.setEnabled(true);
			ShowAutRB.setEnabled(true);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(true);
			IDAutT.setEnabled(true);
			ApplyDeleteAutB.setEnabled(true);
			
			Amessage.setVisible(false);
			
			startLivre.setEnabled(false);
			
		}
	});
		
	ShowAutRB.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			AddLivreRB.setEnabled(false);
			deleteLivreRB.setEnabled(false);
			updateLivreRB.setEnabled(false);
			ShowLivreRB.setEnabled(false);
			
			AddCatRB.setEnabled(false);
			DeleteCatRB.setEnabled(false);
			ShowCatRB.setEnabled(false);

			AddAuteurRB.setEnabled(true);
			DeleteAutRB.setEnabled(true);
			ShowAutRB.setEnabled(true);
			
			//livre
			NomLivreL.setEnabled(false);
			NomLivreT.setEnabled(false);
			CatL.setEnabled(false);
			CatCB.setEnabled(false);
			idAuteurT.setEnabled(false);
			idAuteurL.setEnabled(false);
			ApplyAddLivreB.setEnabled(false);
			
			IDLivreL.setEnabled(false);
			IDLivreT.setEnabled(false);
			updateLL.setEnabled(false);
			updateLCB.setEnabled(false);
			CatL2.setEnabled(false);
			CatCB2.setEnabled(false);
			newIDNL.setEnabled(false);
			newIDNT.setEnabled(false);
			ApplyuUpdateLivreB.setEnabled(false);
			
			IDLivreL2.setEnabled(false);
			IDLivreT2.setEnabled(false);
			ApplyuDeleteLivreB.setEnabled(false);
			Lmessage.setVisible(false);
			
			//Categorie
			NomCatL.setEnabled(false);
			NomCatT.setEnabled(false);
			ApplyuAddCatB.setEnabled(false);
			
			NomCatL2.setEnabled(false);
			CatCB3.setEnabled(false);
			ApplyuDeleteCatB.setEnabled(false);
			
			Cmessage.setVisible(false);
			
			//Auteur
			
			NomAutL.setEnabled(false);
			NomAutT.setEnabled(false);
			ApplyAddAutB.setEnabled(false);
			
			IDAutL.setEnabled(false);
			IDAutT.setEnabled(false);
			ApplyDeleteAutB.setEnabled(false);
			
			Amessage.setVisible(true);
			
			startLivre.setEnabled(true);
			
		}
	});
	
	startLivre.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(LivreRB.isSelected())
			{
				if(AddLivreRB.isSelected())
				{
					String nom = NomLivreT.getText().toString();
					String categorie = CatCB.getSelectedItem().toString();
					int idAuteur = Integer.parseInt(idAuteurT.getText().toString());
					int idCat = livre.CategorieNomToId(categorie);
					System.out.println(idCat);
					livre.AjouterLivre(nom, idCat, idAuteur);
				}
				else if(updateLivreRB.isSelected())
				{
					int idL = Integer.parseInt(IDLivreT.getText().toString());
					String type = updateLCB.getSelectedItem().toString();
					if(type.equals("Nom Livre"))
					{
						String nom = newIDNT.getText().toString();
						livre.updateLivreNomLivre(idL, nom);
					}
					else if(type.equals("ID Auteur"))
					{
						int idA = Integer.parseInt(newIDNT.getText().toString());
						livre.updateLivreIdAuteur(idL, idA);
					}
					else if(type.equals("Categorie"))
					{
						String Cat = CatCB2.getSelectedItem().toString();
						int idC = livre.CategorieNomToId(Cat);
						livre.updateLivreCat(idL, idC);
					}
				}
				else if(deleteLivreRB.isSelected())
				{
					int idL = Integer.parseInt(IDLivreT2.getText().toString());
					livre.deleteLivre(idL);
				}
				else if(ShowLivreRB.isSelected())
				{

					JDialog D = new JDialog(App, "C.A.A.N");
					D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					D.setSize(700, 250);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(0, 0, 500, 250);
					table = new JTable();
					scrollPane.setViewportView(table);
					AfficherLivre();
					D.add(scrollPane);
					D.setVisible(true); 
				}
			}
			else if(CategorieRB.isSelected())
			{
				if(AddCatRB.isSelected())
				{
					String nom = NomCatT.getText().toString();
					livre.AjouterCat(nom);
				}
				else if(DeleteCatRB.isSelected())
				{
					String cat = CatCB3.getSelectedItem().toString();
					int idC = livre.CategorieNomToId(cat);
					livre.SupprimerCat(idC);
					CatCB3.removeAllItems();
					CatCB3.addItem("");
					String nomCatQuery = "SELECT nomCategorie FROM categorie";
					try {
						Statement stm = (Statement) conn.createStatement();
						ResultSet rs = stm.executeQuery(nomCatQuery);
						while(rs.next()) {
							CatCB3.addItem(rs.getString(1));
						}
					} catch (Exception e2) {}
				}
				else if(ShowCatRB.isSelected())
				{
					JDialog D = new JDialog(App, "C.A.A.N");
					D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					D.setSize(700, 250);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(0, 0, 500, 250);
					table = new JTable();
					scrollPane.setViewportView(table);
					AfficherCategorie();
					D.add(scrollPane);
					D.setVisible(true); 
				}
			}
			else if(AuteurRB.isSelected())
			{
				if(AddAuteurRB.isSelected())
				{
					String nom = NomAutT.getText().toString();
					livre.AjouterAuteur(nom);
				}
				else if(DeleteAutRB.isSelected())
				{
					int idA = Integer.parseInt(IDAutT.getText().toString());
					livre.SupprimerAuteur(idA);
				}
				else if(ShowAutRB.isSelected())
				{
					JDialog D = new JDialog(App, "C.A.A.N");
					D.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					D.setSize(700, 250);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(0, 0, 500, 250);
					table = new JTable();
					scrollPane.setViewportView(table);
					AfficherAuteur();
					D.add(scrollPane);
					D.setVisible(true); 
				}
				
			}
			
		}
	});
		
	//----------------------------------------------------------------------------
	
	//----------------- HANDLING HOME PAGE ---------------------
		ClientB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(true);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
				
			}
		});
		ExemplaireB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Exemplaire.setVisible(true);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});	
		
		OffreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(true);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});
		
		EmprButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(true);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});
		
		chercheButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(true);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});
		
		LivreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(true);
				Home.setVisible(false);
				
			}
		});
		

		
		Cl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(true);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});
		Ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Client.setVisible(false);
				Exemplaire.setVisible(true);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});
		
		Li.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(true);
				Home.setVisible(false);
				
				
			}
		});
		
		Of.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(true);
				Emprunt.setVisible(false);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
			}
		});
		
		Emp1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Client.setVisible(false);
				Exemplaire.setVisible(false);
				Offre.setVisible(false);
				Emprunt.setVisible(true);
				CLE.setVisible(false);
				Livre.setVisible(false);
				Home.setVisible(false);
				
			}
		});
		

		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if (JOptionPane.showConfirmDialog( App,"Fermer l'application ?","C.A.A.N",
				            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				            System.exit(0);
			}
		});
		


		
		
		
	}

}
