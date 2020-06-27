import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Client {
	
	static Connection conn = Utilitaire.getConnection();
	
	
	public static void AjouterClient(String nom, String prenom, String adresse, String tel)
	{
		try {
			CallableStatement clientexisteS = conn.prepareCall("{? = call Client_existe(?,?,?,?)}");
			clientexisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			clientexisteS.setString(2, nom);
			clientexisteS.setString(3, prenom);
			clientexisteS.setString(4, adresse);
			clientexisteS.setString(5, tel);
			clientexisteS.execute();
			int existe = clientexisteS.getInt(1);
			if(existe == 0)
			{
				CallableStatement addClientS = conn.prepareCall("{call AjouterClient(?,?,?,?)}");
				addClientS.setString(1, nom);
				addClientS.setString(2, prenom);
				addClientS.setString(3, adresse);
				addClientS.setString(4, tel);
				addClientS.execute();
				JOptionPane.showMessageDialog(CAAN.App, nom + " " + prenom + " est devenu un client");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Ce client deja existe");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
	}
	
	public static void updateClient(int id, int type, String var)
	{
		try {
			CallableStatement clientexisteS = conn.prepareCall("{? = call Client_existeID(?)}");
			clientexisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			clientexisteS.setInt(2, id);
			clientexisteS.execute();
			int existe = clientexisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement st = conn.prepareCall("{call updateClient(?,?,?)}");
				st.setInt(1, id);
				st.setInt(2, type);
				st.setString(3, var);
				st.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation echoue");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
		
	}
	
	public static void deleteClient(int id)
	{
		try {
			CallableStatement clientexisteS = conn.prepareCall("{? = call Client_existeID(?)}");
			clientexisteS.registerOutParameter(1,java.sql.Types.INTEGER);
			clientexisteS.setInt(2, id);
			clientexisteS.execute();
			int existe = clientexisteS.getInt(1);
			if(existe == 1)
			{
				CallableStatement st = conn.prepareCall("{call supprimerClient(?)}");
				st.setInt(1, id);
				st.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "L\'operation echoue");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
	}

}
