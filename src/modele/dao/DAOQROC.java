package modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.entite.QROC;
import modele.entite.Question;


public class DAOQROC extends DAO<QROC> {

	@Override
	public void create(QROC o) {
		Connection conn =super.connect();
		String requet = "insert into qroc(idQuestion,motCle1,motCle2,motCle3) values('"+o.getIdQuation()
		+"','"+o.getMotCle()[0]+"','"+o.getMotCle()[1]+"','"+o.getMotCle()[2]+"')";
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
	public void update(QROC o) {
		Connection conn =super.connect();
		String requet = "update qcm"
				+ "idQuestion = '"+o.getIdQuation()+"',"
						+ " ennoncee = '"+o.getEnoonce()+"'"
						+ "', isChapitre = '"+o.getIdChaptre()+"',"
						+ " motCle1 = '"+o.getMotCle()[0]+"',"
								+ " motCle2 = '"+o.getMotCle()[1]+
								"',"
								+ " motCle3 = '"+o.getMotCle()[2]+
						 "' where 'idQuestion' = "+o.getIdQuation();
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
	public QROC find(QROC o) {
		Connection conn =super.connect();
		String requet = "select * from qroc where idQuestion = "+o.getIdQuation();
		Statement ps= null;
		ResultSet rs = null;
		QROC Q =null;
		DAOQuestion dQ = new DAOQuestion();
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			
			while (rs.next()) {
				String[] p = {rs.getString("motCle1")		
				,rs.getString("motCle2"),rs.getString("motCle3")};
				Question q = dQ.findWitId(rs.getInt("idQuestion"));
				Q=new QROC(rs.getInt("idQuestion"),
						q.getIdChaptre(),q.getEnoonce(),p);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Q; 
	}

	@Override
	public void delete(QROC o) {
		Connection conn =super.connect();
		String requet = "delete from 'qroc' where 'idQuestion' = "+o.getIdQuation();
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
	public List<QROC> findAll() {
		Connection conn =super.connect();
		String requet = "select * from qroc";
		Statement ps= null;
		ResultSet rs = null;
		DAOQuestion dQ = new DAOQuestion();
		List<QROC> listQROC = new ArrayList<>();
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			while (rs.next()) {
				String[] p = {rs.getString("motCle1")		
						,rs.getString("motCle2"),rs.getString("motCle3")};
				Question q = dQ.findWitId(rs.getInt("idQuestion"));
				listQROC.add(new QROC(rs.getInt("idQuestion"),q.getIdChaptre(),
						q.getEnoonce(),p));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listQROC;
	}

	public QROC findWithId(int o) {
		Connection conn =super.connect();
		String requet = "select * from qroc where idQuestion = "+o;
		Statement ps= null;
		ResultSet rs = null;
		DAOQuestion dQ = new DAOQuestion();
		QROC Q =null;
		
		try {
			ps = conn.createStatement();
			rs =ps.executeQuery(requet);
			
			while (rs.next()) {
				String[] p = {rs.getString("motCle1")		
				,rs.getString("motCle2"),rs.getString("motCle3")};
				Question q = dQ.findWitId(rs.getInt("idQuestion"));
				Q=new QROC(rs.getInt("idQuestion"),
						q.getIdChaptre(),q.getEnoonce(),p);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Q; 
	}
}
