import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

public class emprunt {
	static Connection conn = Utilitaire.getConnection();
	
	public static int verifierExemDispo(int id) {
		try {
		CallableStatement cs1 =conn.prepareCall("{? = call dispo_exemplaire(?)} ");
		cs1.registerOutParameter(1, Types.INTEGER);
		cs1.setInt(2, id);
		cs1.execute();
		return cs1.getInt(1);
		}

		catch(Exception e) {
			return 2;
		}
	}
	
	public static boolean status_client(int idClient)
	{
		boolean state = false;
		try {
			CallableStatement cs2 =conn.prepareCall("{? = call status_client(?)} ");
			cs2.registerOutParameter(1, Types.BOOLEAN);
			cs2.setInt(2, idClient);
			cs2.execute();
			state = cs2.getBoolean(1);
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(CAAN.App, "erreur rencontre ");
		}
		return state;
	}
	
	public static void emprunterLivre(int idClient, int idOffre)
	{
		try {
			CallableStatement cs4 =conn.prepareCall("{call emprunterLivre(?,?)} ");
			cs4.setInt(1,idClient);
			cs4.setInt(2, idOffre);
			cs4.execute();
			JOptionPane.showMessageDialog(CAAN.App, "Emprunt a ete fait avec succe ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajouterExemplaireEmprunte(int idClient, int idExemplaire)
	{
		try {
		CallableStatement cs5 =conn.prepareCall("{call ajouterExemplaireEmprunte(?,?)} ");
		cs5.setInt(1, idClient);
		cs5.setInt(2, idExemplaire);
		cs5.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void retournerLivre(int idClient)
	{
		try {
			CallableStatement cs4 =conn.prepareCall("{call retournerLivre(?)} ");
			cs4.setInt(1,idClient);
			cs4.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void supprimerExemplaireRetourne(int idC, int idE)
	{
		try {
			CallableStatement cs5 =conn.prepareCall("{call supprimerExemplaireRetourne(?,?)} ");
			cs5.setInt(1, idC);
			cs5.setInt(2, idE);
			cs5.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

}
