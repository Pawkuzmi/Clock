package zegar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
/**
 *
 * @author Paweł
 */
public class DayWindows {
    
    JLabel[] daysArray;
    JInternalFrame frame;
    
    public DayWindows(JLabel[] daysArray, JInternalFrame frame){
        
        this.daysArray = daysArray;  
        this.frame = frame;
        
       // setupCalendar();
    }
    
    public void setupCalendar(){
        Calendar tempDate = new GregorianCalendar(); 
        Calendar currentDate = new GregorianCalendar();
        
        setCalendarFrameTitle(currentDate);
        
        tempDate.add(Calendar.DAY_OF_MONTH, -tempDate.get(Calendar.DAY_OF_MONTH)+1); // set date to first date of current month
        
        int i = tempDate.get(Calendar.DAY_OF_WEEK); // check which day of week was first day of current month
        
        i -= 1; //because first day in week in class Calendar is Sunday ( in my project 1st is monday)
        
        for (int day = tempDate.get(Calendar.DAY_OF_MONTH); day <= tempDate.getActualMaximum(Calendar.DAY_OF_MONTH); day++){
            
            if(currentDate.get(Calendar.DAY_OF_MONTH) == day)
                daysArray[i-1].setFont(new java.awt.Font("High Tower Text", 3, 45));
            
            daysArray[i-1].setText(Integer.toString(day)); //i-1 because arrays are counting from 0, not 1;
            i++;
        }
    }
    
    public void setCalendarFrameTitle(Calendar date){
        int currentMonth = date.get(Calendar.MONTH) + 1;
        
        String title = "";
        
        switch (currentMonth) {
            case 1:
                title = "January";
                break;
            case 2:
                title = "February";
                break;
            case 3:
                title = "March";
                break;
            case 4:
                title = "April";
                break;
            case 5:
                title = "May";
                break;
            case 6:
                title = "June";
                break;
            case 7:
                title = "July";
                break;
            case 8:
                title = "August";
                break;
            case 9:
                title = "September";
                break;
            case 10:
                title = "October";
                break;
            case 11:
                title = "November";
                break;
            case 12:
                title = "December";
                break;
            default:
                break;
        }
        
        frame.setTitle(title + " " + date.get(Calendar.YEAR));        
    }
    
}