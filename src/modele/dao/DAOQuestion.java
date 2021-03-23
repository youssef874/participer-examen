package modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.entite.QCM;
import modele.entite.Question;







public class DAOQuestion extends DAO<Question> {

	@Override
	public void create(Question o) {
		Connection conn =super.connect();
		String requet = "insert into question(ennocee,idChapitre) values('"
		+o.getEnoonce()+"','"+o.getIdChaptre()+"')";
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
	public void update(Question o) {
		Connection conn =super.connect();
		String requet = "update question"
				+ "idQuestion = '"+o.getIdQuation()+"', ennoncee = '"+o.getEnoonce()+"'"
						+ "', isChapitre = '"+o.getIdChaptre()
				+ "' where 'idQuestion' = "+o.getIdQuation();
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
	public Question find(Question o) {
		Connection conn =super.connect();
		String requet = "select * from question where idQuestion = "+o.getIdQuation();
		Statement ps= null;
		ResultSet rs = null;
		Question Q =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				Q=new QCM(rs.getInt("idQuestion"),
						rs.getInt("idChapitre"),rs.getString("ennoncee"),null,null);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Q; 
	}

	@Override
	public void delete(Question o) {
		Connection conn =super.connect();
		String requet = "delete from 'question' where 'idQuestion' = "+o.getIdQuation();
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
	public List<Question> findAll() {
		Connection conn =super.connect();
		String requet = "select * from question";
		Statement ps= null;
		ResultSet rs = null;
		List<Question> listQuestion = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				listQuestion.add(new QCM(rs.getInt("idQuestion"),rs.getInt("idChapitre")
						,rs.getString("ennocee"),null,null));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listQuestion;
	}

	public Question findWitId(int o) {
		Connection conn =super.connect();
		String requet = "select * from question where idQuestion = "+o;
		Statement ps= null;
		ResultSet rs = null;
		Question Q =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				Q=new QCM(rs.getInt("idQuestion"),
						rs.getInt("idChapitre"),rs.getString("ennocee"),null,null);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Q; 
	}
}
