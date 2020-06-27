import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class livre {

	static Connection conn = Utilitaire.getConnection();
	
	public static void AjouterLivre(String name, int idCat, int idAut)
	{
		
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call livre_existe(?,?,?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setString(2, name);
			livreExisteS.setInt(3, idCat);
			livreExisteS.setInt(4, idAut);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 0)
			{
				CallableStatement addLivreS = conn.prepareCall("{call AjouterLivre(?,?,?)}");
				addLivreS.setString(1, name);
				addLivreS.setInt(2, idCat);
				addLivreS.setInt(3, idAut);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "Livre "+ name + " est ajouter");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Ce livre deja existe");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
		
	}
	
	public static int CategorieNomToId(String nom)
	{
		
		try {
			
			CallableStatement St = conn.prepareCall("{? = CALL categorieNomToID(?)}");
			St.registerOutParameter(1, java.sql.Types.INTEGER);
			St.setString(2, nom);
			St.execute();
			int id = St.getInt(1);
			return id;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
			return 0;
		}
		
	}
	
	public static void updateLivreNomLivre(int id, String nom)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call livre_existeID(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setInt(2, id);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement addLivreS = conn.prepareCall("{call updateLivre(?,?,?)}");
				addLivreS.setInt(1, id);
				addLivreS.setInt(2, 1);
				addLivreS.setString(3, nom);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Ce livre n\'existe pas");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in updateLivreNomLivre");
			e1.printStackTrace();
		}
	}
	
	public static void updateLivreIdAuteur(int id, int IDA)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call livre_existeID(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setInt(2, id);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement addLivreS = conn.prepareCall("{call updateLivre(?,?,?)}");
				addLivreS.setInt(1, id);
				addLivreS.setInt(2, 3);
				addLivreS.setInt(3, IDA);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Ce livre n\'existe pas");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in updateLivreIdAuteur");
			e1.printStackTrace();
		}
	}
	
	public static void updateLivreCat(int id, int idC)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call livre_existeID(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setInt(2, id);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement addLivreS = conn.prepareCall("{call updateLivre(?,?,?)}");
				addLivreS.setInt(1, id);
				addLivreS.setInt(2, 2);
				addLivreS.setInt(3, idC);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Ce livre n\'existe pas");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in updateLivreCat");
			e1.printStackTrace();
		}
	}
	
	public static void deleteLivre(int id)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call livre_existeID(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setInt(2, id);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement addLivreS = conn.prepareCall("{call supprimerLivre(?)}");
				addLivreS.setInt(1, id);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Ce livre n\'existe pas");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in deleteLivre");
			e1.printStackTrace();
		}
	}
	
	public static void AjouterCat(String nom)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call categorie_existe(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setString(2, nom);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 0)
			{
				CallableStatement addLivreS = conn.prepareCall("{call AjouterCategorie(?)}");
				addLivreS.setString(1, nom);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "Categorie  "+ nom + " est ajouter");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Cette categorie deja existe");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in AjouterCat");
			e1.printStackTrace();
		}
	}
	
	public static void SupprimerCat(int idC)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call categorie_existeID(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setInt(2, idC);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement addLivreS = conn.prepareCall("{call supprimerCategorie(?)}");
				addLivreS.setInt(1, idC);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Cette categorie n\'existe pas");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in SupprimerCat");
			e1.printStackTrace();
		}
	}
	
	public static void AjouterAuteur(String nom)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call auteur_existe(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setString(2, nom);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 0)
			{
				CallableStatement addLivreS = conn.prepareCall("{call AjouterAuteur(?)}");
				addLivreS.setString(1, nom);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "Auteur  "+ nom + " est ajouter");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Auteur deja existe");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in AjouterAuteur");
			e1.printStackTrace();
		}
	}
	
	public static void SupprimerAuteur(int idA)
	{
		try {
			CallableStatement livreExisteS = conn.prepareCall("{? = call auteur_existeID(?)}");
			livreExisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			livreExisteS.setInt(2, idA);
			livreExisteS.execute();
			int existe = livreExisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement addLivreS = conn.prepareCall("{call supprimerAuteur(?)}");
				addLivreS.setInt(1, idA);
				addLivreS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
			{
				JOptionPane.showMessageDialog(CAAN.App, "Auteur n\'existe pas");
				return;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur in SupprimerAuteur");
			e1.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
