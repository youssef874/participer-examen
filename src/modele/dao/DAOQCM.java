package modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.entite.QCM;
import modele.entite.Question;

public class DAOQCM extends DAO<QCM> {

	@Override
	public void create(QCM o) {
		Connection conn =super.connect();
		String requet = "insert into qcm"
				+ "(idQuestion,proposition1,proposition2,proposition3,propositionCorrecte1,"
				+ "propositionCorrecte2,propositionCorrecte3) "
				+ "values('"+o.getIdQuation()+"','"+o.getProposition()[0]
				+"','"+o.getProposition()[1]+"','"+o.getProposition()[2]+"','"+
				convertBooleanIntoBinary(o.getPropositionCorrect()[0])+"','"+
				convertBooleanIntoBinary(o.getPropositionCorrect()[1])+"','"+
				convertBooleanIntoBinary(o.getPropositionCorrect()[2])+"')";
		Statement ps= null;
		
		try {
			ps = conn.createStatement();
			ps.execute(requet);
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(QCM o) {
		Connection conn =super.connect();
		String requet = "update qcm"
				+ "idQuestion = '"+o.getIdQuation()+"',"
						+ " ennoncee = '"+o.getEnoonce()+"'"
						+ "', isChapitre = '"+o.getIdChaptre()+"',"
						+ " proposition1 = '"+o.getProposition()[0]+"',"
								+ " proposition2 = '"+o.getProposition()[1]+"',"
										+ " proposition3 = '"+o.getProposition()[2]+
						"', propositionCorrecte = '"+o.getPropositionCorrect()
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
	public QCM find(QCM o) {
		Connection conn =super.connect();
		String requet = "select * from qcm where idQuestion = "+o.getIdQuation();
		Statement ps= null;
		ResultSet rs = null;
		QCM Q =null;
		DAOQuestion dQ = new DAOQuestion();
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			
			while (rs.next()) {
				String[] p = {rs.getString("proposition1")		
				,rs.getString("proposition2"),rs.getString("proposition3")};
				boolean[] pC = {rs.getBoolean("propositionCorrcte1")
						,rs.getBoolean("propositionCorrecte2"),
						rs.getBoolean("propositionCorrecte3")};
				Question q = dQ.findWitId(rs.getInt("idQuestion"));
				Q=new QCM(rs.getInt("idQuestion"),
						q.getIdChaptre(),q.getEnoonce(),p,pC);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Q; 
	}

	@Override
	public void delete(QCM o) {
		Connection conn =super.connect();
		String requet = "delete from 'qcm' where 'idQuestion' = "+o.getIdQuation();
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
	public List<QCM> findAll() {
		Connection conn =super.connect();
		String requet = "select * from qcm";
		Statement ps= null;
		ResultSet rs = null;
		List<QCM> listQCM = new ArrayList<>();
		DAOQuestion dQ = new DAOQuestion();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				String[] p = {rs.getString("proposition1")		
						,rs.getString("proposition2"),rs.getString("proposition3")};
						boolean[] pC = {rs.getBoolean("propositionCorrcte1")
								,rs.getBoolean("propositionCorrecte2"),
								rs.getBoolean("propositionCorrecte3")};
						Question q = dQ.findWitId(rs.getInt("idQuestion"));
				listQCM.add(new QCM(rs.getInt("idQuestion"),q.getIdChaptre()
						,q.getEnoonce(),p,pC));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listQCM;
	}

	private int convertBooleanIntoBinary(Boolean b) {
		if(b) {
			return 1;
		}
		return 0;
	}
	
	public QCM findWithId(int o) {
		Connection conn =super.connect();
		String requet = "select * from qcm where idQuestion = "+o;
		DAOQuestion dQ = new DAOQuestion();
		Statement ps= null;
		ResultSet rs = null;
		QCM Q =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			
			while (rs.next()) {
				String[] p = {rs.getString("proposition1")		
				,rs.getString("proposition2"),rs.getString("proposition3")};
				boolean[] pC = {rs.getBoolean("propositionCorrecte1")
						,rs.getBoolean("propositionCorrecte2"),
						rs.getBoolean("propositionCorrecte3")};
				Question q = dQ.findWitId(rs.getInt("idQuestion"));
				Q=new QCM(rs.getInt("idQuestion"),
						q.getIdChaptre(),q.getEnoonce(),p,pC);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Q; 
	}
}
