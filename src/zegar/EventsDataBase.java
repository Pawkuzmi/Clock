package zegar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        
        algorithmForDeleteingAllEventsInNewMonth();
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
    
    private void algorithmForDeleteingAllEventsInNewMonth(){
        createPreviousMonthTable();
        insertCurrentMonth();
        checkIfDeleteAllEventsBecauseNewMonth();
    }
    
    private void createPreviousMonthTable(){
        String createEventsTable = "CREATE TABLE IF NOT EXISTS previousMonth (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "month INTEGER)";
        
        try {
            stat.execute(createEventsTable);
        } 
        catch (SQLException ex) {
            System.err.println("Creating previousMonth table in DB failed");
            ex.printStackTrace();
        }
    }
    
    private void insertCurrentMonth() {
        String insertion = "INSERT INTO previousMonth VALUES(NULL, ?)";
        
        try {
            PreparedStatement prepStat = conn.prepareStatement(insertion);
            
            prepStat.setInt(1, new GregorianCalendar().get(Calendar.MONTH) + 1);
            
            prepStat.execute();
        } 
        catch (SQLException ex) {
            System.err.println("insertion to previousMonth failed");
            ex.printStackTrace();
            return;
        }
    }
    
    private void checkIfDeleteAllEventsBecauseNewMonth(){
        
        ArrayList<Integer> months;
        months = new ArrayList<>();
        
        try {
            String all = "SELECT * FROM previousMonth";
            
            ResultSet result = stat.executeQuery(all);
            int id, currentMonth;
            
            while(result.next()) {
                id = result.getInt("id");
                currentMonth = result.getInt("month");
                
                months.add(currentMonth);
                System.out.println(id + " "+ currentMonth);
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        
        if(months.size() > 1 && ( months.get(months.size()-1) != months.get(months.size()-2) ) ){
            deleteAllFrom("previousMonth");
        }
    }
    
    private void deleteAllFrom(String previousMonth) {
        String deletion = "DELETE FROM " +  previousMonth ;
                
        try {
            PreparedStatement prepStat = conn.prepareStatement(deletion);
            prepStat.execute();
        } 
        catch (SQLException ex) {
            System.err.println("unable to delete from " + previousMonth);
            ex.printStackTrace();
            return;
        }
        System.out.println("Deleted from " + previousMonth);
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
    
    public void deleteEventsIn( String day){
        String deletion = "DELETE FROM " + this.tblName + " WHERE dayOfMonth = '" + day +"'";
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
    
    public void showEverything(){
        try {
            String all = "SELECT * FROM " + this.tblName;
            
            ResultSet result = stat.executeQuery(all);
            int id;
            String name, hour, description, day;
            while(result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                day = result.getString("dayOfMonth");
                hour = result.getString("hour");
                description = result.getString("description");
                
                System.out.println(id + " "+ name + " " +day+ " "+ hour+ " "+ description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    ArrayList<Event> getEventsIn(String day) {
        String query = "SELECT * FROM " + this.tblName + " WHERE dayOfMonth = '" + day +"'";
        ArrayList<Event> events = new ArrayList<>();
        
        try {   
            ResultSet result = stat.executeQuery(query);
            int i=0, id;
            String n, d, h, desc;
            while(result.next()){ 
                id = result.getInt(1);
                n = result.getString(2);
                d = result.getString(3);
                h = result.getString(4);
                desc = result.getString(5);
                
                events.add(new Event(id, n, d, h, desc)) ;
                
                i++;
            }
        } 
        catch (SQLException ex) {
            System.err.println("Unable to get event acording to dayOfMonth");
            ex.printStackTrace();
        }
        
        events.trimToSize();
        return events;
    }
    
    public boolean[] daysWithEvent(){
        
        boolean[] tab = new boolean[32];
        
        try {
            String all = "SELECT * FROM " + this.tblName;
            
            ResultSet result = stat.executeQuery(all);
            
            while(result.next()) {
                
                int dayWithEvent = Integer.valueOf( result.getString("dayOfMonth") );
                
                tab[dayWithEvent] = true;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        return tab;
    }

    

    
}
