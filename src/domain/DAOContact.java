package domain;

import java.beans.Statement;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class DAOContact {
	
	GestionTransaction transaction=new GestionTransaction();
	    
	/**
	 * methode qui permet d'ajouter un contact en base
	 * @param id   du contact
	 * @param firstName le nom
	 * @param lastName le prenom
	 * @param email l'email du contact
	 * @return true si l'ajout a réussi, false sinon
	 */
	public boolean addContact(String id,String firstName,String lastName,String email){
	
		if (transaction.addContact(id, firstName, lastName, email)){
			return true;
		}
		return false;
	
		
	}
	
	/**
	 * suppresion d'un contact
	 * @param id
	 */
	public void deleteContact(String id) {
		// TODO Auto-generated method stub
		
	}

}
