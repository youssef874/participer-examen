package modele.dao;

import java.sql.Connection;
import java.util.List;

/*
 * This generic abstract class to allow all of entity to implement all the CROD methods
 */
public abstract class DAO <T> {

	/*
	 *This method responsible of connecting to the database .
	 *we just calling throw super in all classes inherit this class to get the connection  
	 *and return it
	 */
	 Connection connect() {
		MySingleton ms = MySingleton.getInstance();
		return ms.getConn();
	}
	 
	 /*
	  * this class to create a row in the table of the database 
	  * Which is have column same as the class attributes who inherit this class
	  */
	 public abstract void create(T o);
	 
	 /*
	  * this class to update the row in the table of the database 
	  * Which is have id same as the class id attribute who inherit this class
	  */
	 public abstract void update(T o);
	 
	 /*
	  * this class to find the row in the table of the database 
	  * Which is have id same as the class id attribute who inherit this class
	  */
	 public abstract T find(T o);
	 
	 /*
	  * this class to delete the row in the table of the database 
	  * Which is have id same as the class id attribute who inherit this class
	  */
	 public abstract void delete(T o);
	 
	 /*
	  * this class to find all rows in the table of the database 
	  * Which is have column same as the class attributes who inherit this class
	  */
	 public abstract List<T> findAll();
}
