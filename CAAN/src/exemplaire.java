import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class exemplaire {
	
	
	
	
	static Connection conn = Utilitaire.getConnection();
	
	public static void AddExemplaire(int id)
	{
		try {
			CallableStatement st1 = conn.prepareCall("{? = call livre_existeID(?)}");
			st1.registerOutParameter(1,java.sql.Types.INTEGER);
			st1.setInt(2, id);
			st1.execute();
			int existe = st1.getInt(1);
			if(existe == 1)
			{
				CallableStatement addClientS = conn.prepareCall("{call AjouterExemplaire(?)}");
				addClientS.setInt(1, id);
				addClientS.execute();
				JOptionPane.showMessageDialog(CAAN.App, "L\'exemplaire est ajoute");
			}
				
			else
				JOptionPane.showMessageDialog(CAAN.App, "Il n\'y a pas de livre pour cette exemplaire");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
	}
	
	public static void updateExemplaireIdL(int idE, int idL)
	{
		try {
			CallableStatement st = conn.prepareCall("{call updateExemplaireIdLivre(?,?)}");
			st.setInt(1, idE);
			st.setInt(2, idL);
			st.execute();
			
			JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
	}
	
	public static void updateExemplairedispo(int idE, int dispo)
	{
		try {
			CallableStatement st = conn.prepareCall("{ call updateExemplaireDispo(?,?)}");
			
			st.setInt(1, idE);
			st.setInt(2, dispo);
			st.execute();
			JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
	}
	
	
	public static void deleteExemplaire(int id)
	{
		try {
			CallableStatement st = conn.prepareCall("{? = call dispo_exemplaire(?)}");
			st.registerOutParameter(1,java.sql.Types.INTEGER);
			st.setInt(2, id);
			st.execute();
			int existe = st.getInt(1);
			if(existe == 0)
			{
				JOptionPane.showMessageDialog(null, "Cet exmplaire n\'est pas disponible, vous ne pouvez pas le supprimer");
				return;
			}
			
			CallableStatement st1 = conn.prepareCall("{call supprimerExemplaire(?)}");
			st1.setInt(1, id);
			st1.execute();
			JOptionPane.showMessageDialog(CAAN.App, "L\'operation reussit");
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(CAAN.App, "Erreur");
			e1.printStackTrace();
		}
	}

}
