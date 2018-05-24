package reseausocial;

import java.sql.Connection;

public abstract class DAO<T> {
	
	
	public DAO() {
		
	}
	
	/**
	  * Méthode de création
	  * @param obj
	  * @return boolean 
	  */
	public abstract boolean create(T obj); // T = Type 
	
	/**
	  * Méthode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	public abstract boolean delete(T obj);

	/**
	  * Méthode de mise à jour
	  * @param obj
	  * @return boolean
	  */
	public abstract boolean update(T obj);
		
	/**
	* Méthode de mise à jour
	* @param obj
	* @return boolean
	*/
	public abstract T find(int id);

	
}
