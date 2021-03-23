package modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.entite.Etudiant;
import modele.entite.EtudiantExamen;

public class DAOEtudiantExamen extends DAO<EtudiantExamen> {

	@Override
	public void create(EtudiantExamen o) {
		Connection conn =super.connect();
		String requet = "insert into etudiantexamen (idExamen,idEtudiant,score,date) "
				+ "values('"+o.getIdExamen()+"','"+o.getIdCIN()+"','"+o.getScore()+"','"
				+o.getDate()+"')";
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
	public void update(EtudiantExamen o) {
		Connection conn =super.connect();
		String requet = "UPDATE `etudiantexamen` SET `score` = '" + o.getScore() 
		+ "' WHERE `etudiantexamen`.`id` = " + o.getId();
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
	public EtudiantExamen find(EtudiantExamen o) {
		Connection conn =super.connect();
		String requet = "select * from etudiantexamen where id = "+o.getId();
		Statement ps= null;
		ResultSet rs = null;
		EtudiantExamen E =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				E=new EtudiantExamen(rs.getInt("id"),rs.getInt("idEtudiant"),rs.getInt("idExamen"),
						rs.getInt("score"),rs.getDate("date"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return E; 
	}

	@Override
	public void delete(EtudiantExamen o) {
		Connection conn =super.connect();
		String requet = "delete from 'etudiantexamen' where 'id' = "+o.getId();
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
	public List<EtudiantExamen> findAll() {
		Connection conn =super.connect();
		String requet = "select * from etudiantexamen";
		Statement ps= null;
		ResultSet rs = null;
		List<EtudiantExamen> lisEtudiantExamen = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				lisEtudiantExamen.add(new EtudiantExamen(rs.getInt("id"),rs.getInt("idEtudiant")
						,rs.getInt("idExamen"),rs.getInt("score"),rs.getDate("date")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lisEtudiantExamen;
	}

}
