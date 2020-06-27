import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.swing.JOptionPane;

public class offre {
	
	static Connection conn = Utilitaire.getConnection();
	
	public static void AjouterOffre(String nom, int nbrLivres, float tarif)
	{
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call testerOffre(?,?,?)} ");
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setString(2, nom);
			cs2.setInt(3, nbrLivres);
			cs2.setFloat(4, tarif);
			cs2.execute();
			int existe = cs2.getInt(1);
			if(existe == 1)
			{
				CallableStatement ajouterOffreS = conn.prepareCall("{call ajouterOffre(?,?,?)}");
				ajouterOffreS.setString(1, nom);
				ajouterOffreS.setInt(2, nbrLivres);
				ajouterOffreS.setFloat(3, tarif);
				ajouterOffreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'offre est ajoutee");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Cette offre deja existe");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static int nomToId(String nom)
	{
		int id = 0;
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call nomToId(?)} ");
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setString(2, nom);
			cs2.execute();
			id = cs2.getInt(1);
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
		return id;
	}
	
	public static void updatenomOffre(int id, String nom)
	{
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call memeNomOffre(?,?)} ");
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setInt(2, id);
			cs2.setString(3, nom);
			cs2.execute();
			int existe = cs2.getInt(1);
			if(existe == 0)
			{
				CallableStatement updateOffreS = conn.prepareCall("{call modifierNomOffre(?,?)}");
				updateOffreS.setInt(1, id);
				updateOffreS.setString(2, nom);
				updateOffreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'offre est modifie");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Cette nom d'offre deja existe");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static void updateNombreLivre(int id, int NBL)
	{
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call memeNbrLivres(?,?)} ");
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setInt(2, id);
			cs2.setInt(3, NBL);
			cs2.execute();
			int existe = cs2.getInt(1);
			if(existe == 0)
			{
				CallableStatement updateOffreS = conn.prepareCall("{call modifierNbrLivres(?,?)}");
				updateOffreS.setInt(1, id);
				updateOffreS.setInt(2, NBL);
				updateOffreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'offre est modifie");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Le nombre de livres existe sur une autre offre");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void updatetarif(int id, float tarif)
	{
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call memeTarif(?,?)} ");
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setInt(2, id);
			cs2.setFloat(3, tarif);
			cs2.execute();
			int existe = cs2.getInt(1);
			if(existe == 0)
			{
				CallableStatement updateOffreS = conn.prepareCall("{call modifierTarif(?,?)}");
				updateOffreS.setInt(1, id);
				updateOffreS.setFloat(2, tarif);
				updateOffreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'offre est modifie");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Tarif existe sur une autre offre");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void deleteOffre(int id)
	{
		try {	
				CallableStatement updateOffreS = conn.prepareCall("{call supprimerOffre(?)}");
				updateOffreS.setInt(1, id);
				updateOffreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'offre est supprime");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static int nombreLivresOffre(int idOffre)
	{
		int NbL = 0;
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call nombreLivresOffre(?)} ");
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setInt(2, idOffre);
			cs2.execute();
			NbL = cs2.getInt(1);
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erreur rencontre ","erreur", JOptionPane.ERROR_MESSAGE);
		}
		return NbL;
	}
	

}
