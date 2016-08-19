package zegar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;

/**
 *
 * @author Paweł
 */
public class MyClock extends Thread{
    
    private JTextField dateTextField;
    private JTextField hourTextField;
    
    public MyClock(JTextField dateTextField, JTextField hourTextField){
        
        this.dateTextField = dateTextField;
        this.hourTextField = hourTextField;
    }
    
    public void run(){
         while(true){
                Calendar cal = new GregorianCalendar();
                
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month  = cal.get(Calendar.MONTH) + 1;
                int year = cal.get(Calendar.YEAR);
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int sec = cal.get(Calendar.SECOND);
                
                String data = day+ "." + month + "." + year;//Integer.toString(day)+ ":" + Integer.toString(month)+ ":" + Integer.toString(year);
                switch(dayOfWeek){
                    case 1: data += " SUN"; break;
                    case 2: data += " MON"; break;
                    case 3: data += " TUE";  break;
                    case 4: data += " WED";  break;
                    case 5: data += " THU"; break;
                    case 6: data += " FRI";  break;
                    case 7: data += " SAT"; break;
                }
                 
                String godz;
                if(minute < 10){
                    
                    godz = Integer.toString(hour)+ ":0" + Integer.toString(minute)+ ":" ;
                }
                else godz = Integer.toString(hour)+ ":" + Integer.toString(minute)+ ":" ;
                
                if( sec == 1) 
                    godz += "0 " + Integer.toString(sec);      // dodanie zera przed sekundę 
                                                              //
                else if(sec < 10 && !(sec ==1))              //
                    godz += "0" + Integer.toString(sec);    //  mniejszą niz 10  
                
                else if(sec > 9 && sec < 20) 
                    godz += addSpace(sec);
                
                else if(sec % 10 == 1) 
                    godz += addZero(sec); // dodanie spacji między cyfry liczby konczącej się na '1'
                
                else 
                    godz += Integer.toString(sec);
                
                dateTextField.setText(data);
                hourTextField.setText(godz);
                
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){} // Do nothing, because there is no other thread
                
            }
        } 
        //add zero between cifres of numbers ending with "1" 
    public String addZero(int sec){
        String second = Integer.toString(sec);
        return second.charAt(0) + " " + second.charAt(1);
    }
    
    //add space before seconds between 10 & 19
    public String addSpace(int sec){ 
        String second = Integer.toString(sec);
        if(sec == 11) 
            return " " + second.charAt(0) + " " + second.charAt(1);
        return " " + second;
    }
}
