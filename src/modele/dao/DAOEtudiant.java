package modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modele.entite.Etudiant;


public class DAOEtudiant extends DAO<Etudiant> {

	@Override
	public void create(Etudiant o) {
		Connection conn =super.connect();
		String requet = "insert into etudiant (idCIN,nom,login,mot_de_passe,prenom,photo) "
				+ "values('"+o.getIdCIN()+"','"+o.getNom()+"','"+o.getLogin()+"','"
				+o.getMotPasse()+"','"+o.getPrenom()+"','"+o.getPhoto()+"')";
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.execute(requet);
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Etudiant o) {
		Connection conn =super.connect();
		String requet = "update etudiant"+"idCIN = '"+o.getIdCIN()
				+ "' , nom = '"+o.getNom()+"', login = '"+o.getLogin()+"',mot_de_passe = '"
				+o.getMotPasse()+"', prenom = '"+o.getPrenom()+"', photo = '"+o.getPhoto()+"'"
				+ "where 'idChapitre' = "+o.getIdCIN();
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.executeUpdate(requet);
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Etudiant find(Etudiant o) {
		Connection conn =super.connect();
		String requet = "select * from etudiant where idChapitre = "+o.getIdCIN();
		Statement ps= null;
		ResultSet rs = null;
		Etudiant E =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				E=new Etudiant(rs.getInt("idCIN"),rs.getString("nom"),rs.getString("prenom"),
						rs.getString("login"),rs.getString("mot_de_passe"),rs.getString("photo"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return E; 
	}

	@Override
	public void delete(Etudiant o) {
		Connection conn =super.connect();
		String requet = "delete from 'etudiant' where 'idChapitre' = "+o.getIdCIN();
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.execute(requet);
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Etudiant> findAll() {
		Connection conn =super.connect();
		String requet = "select * from etudiant";
		Statement ps= null;
		ResultSet rs = null;
		List<Etudiant> lisEtudiant = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				lisEtudiant.add(new Etudiant(rs.getInt("idCIN"),rs.getString("nom"),rs.getString("prenom"),
						rs.getString("login"),rs.getString("mot_de_passe"),rs.getString("photo")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lisEtudiant;
	}

}
