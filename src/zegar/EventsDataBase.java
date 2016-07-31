package zegar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paweł Kuźmicki
 */
public class EventsDataBase {
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:DataBase.db";
    
    private Connection conn;
    private Statement stat;
    private String tblName = "events";

    public EventsDataBase() {
        
        try{
            Class.forName(DRIVER);
        } 
        catch (ClassNotFoundException ex) {
            System.err.println("Lack of JDBC Driver");
            ex.printStackTrace();
        }
        
        try{
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } 
        catch (SQLException ex) {
            System.err.println("Problem with establishing Connection");
            ex.printStackTrace();
        }
        
        createTable();
    }
    
    public void createTable(){
        String createEventsTable = "CREATE TABLE IF NOT EXISTS " + this.tblName + " (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(255), dayOfMonth VARCHAR(255), hour VARCHAR(255), description VARCHAR(255))";
        
        try {
            stat.execute(createEventsTable);
        } 
        catch (SQLException ex) {
            System.err.println("Creating events table in DB failed");
            ex.printStackTrace();
        }
    }
    
    public void insert(Event event){
        String insertion = "INSERT INTO " + this.tblName + " VALUES(NULL, ?, ?, ?, ?)";
        
        try {
            PreparedStatement prepStat = conn.prepareStatement(insertion);
            
            prepStat.setString(1, event.getName());
            prepStat.setString(2, event.getDayOfMonth());
            prepStat.setString(3, event.getHour());
            prepStat.setString(4, event.getDescription());
            
            prepStat.execute();
        } 
        catch (SQLException ex) {
            System.err.println("insertion failed");
            ex.printStackTrace();
            return;
        }
        
        System.out.println("Good insertion!");
    }
    
    public void deleteEverything(){
        String deletion = "DELETE FROM " + this.tblName ;
        System.out.println(deletion);
        
        try {
            PreparedStatement prepStat = conn.prepareStatement(deletion);
            prepStat.execute();
        } 
        catch (SQLException ex) {
            System.err.println("unable to delete *");
            ex.printStackTrace();
            return;
        }
        System.out.println("Deleted from " + this.tblName);
    }
    
}
