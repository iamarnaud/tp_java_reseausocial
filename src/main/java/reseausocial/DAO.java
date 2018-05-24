package reseausocial;

import java.sql.Connection;

public abstract class DAO<T> {
	
	
	public DAO() {
		
	}
	
	/**
	  * M�thode de cr�ation
	  * @param obj
	  * @return boolean 
	  */
	public abstract boolean create(T obj); // T = Type 
	
	/**
	  * M�thode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	public abstract boolean delete(T obj);

	/**
	  * M�thode de mise � jour
	  * @param obj
	  * @return boolean
	  */
	public abstract boolean update(T obj);
		
	/**
	* M�thode de mise � jour
	* @param obj
	* @return boolean
	*/
	public abstract T find(int id);

	
}
