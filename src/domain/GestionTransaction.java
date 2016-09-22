package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class GestionTransaction {
	
	
	String server = "oracle.ufr-info-p6.jussieu.fr";
    String port = "1521";
    String database = "ora10";
    String user = "anonyme";
    String password = "anonyme";

    Connection connexion;
    java.sql.Statement stmt;
    ResultSet resultSet;
    
    /**
     * methode qui sera appeler pour se connecter à la base 
     * @param server
     * @param port
     * @param database
     * @param user
     * @param passwrd
     * @return
     */
    public Connection connexion( String server, String port, String database,
    		String user, String passwrd ){
    	
    	 String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + database;
    	try {
			/* Chargement du pilote JDBC */
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		connexion = DriverManager.getConnection ( url, user, password);
    		return connexion;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connexion;
    	
    }
    
    /**
     * methode pour ajouter un contact en base
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @return  true si l'ajout a réussi, false sinon
     */
    public boolean addContact(String id,String firstName,String lastName,String email){
    	
    	String requete="insert into contact values(id,firstName,lastName,email)";
		try {
			connexion=connexion( server, port, database, user, password );
			stmt=connexion.createStatement();
			stmt.executeUpdate(requete);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
    }
}
