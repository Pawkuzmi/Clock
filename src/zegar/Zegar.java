package zegar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Paweł
 */
public class Zegar extends javax.swing.JDialog {

    
    
    public Zegar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();           // starting window dimension 351, 175; second win dim 351, 500; start point 1000, 35;
        
        extendCounter = 0;
              
        createDayLabels();
       
        myCalendar = new DayWindows(labelArray, CalendarInternalFrame); 
        myCalendar.setupCalendar();         // starting calendar day-by-day view in extension
        
        myClock = new Clock(dateTextField, hourTextField);
        
        myClock.start();
        
      /*  new Thread(){
            
            @Override
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
                        godz += dodanieSpacji(sec);
                    
                    else if(sec % 10 == 1) 
                        godz += dodanieZera(sec); // dodanie spacji między cyfry liczby konczącej się na '1'
                    
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
        }.start();  */
  
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        extendButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        dateTextField = new javax.swing.JTextField();
        hourTextField = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        CalendarInternalFrame = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        mondayLabel = new javax.swing.JLabel();
        tuesdayLabel = new javax.swing.JLabel();
        wednesdayLabel = new javax.swing.JLabel();
        thursdayLabel = new javax.swing.JLabel();
        fridayLabel = new javax.swing.JLabel();
        saturdayLabel = new javax.swing.JLabel();
        sundayLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        backgroundInternal = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(1000, 35));
        setMinimumSize(new java.awt.Dimension(345, 175));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(351, 175));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        extendButton.setBackground(new java.awt.Color(102, 255, 102));
        extendButton.setForeground(new java.awt.Color(255, 51, 51));
        extendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obrazy/down.png")));
        //extendButton.setBorderPainted(true);

        //extendButton.setContentAreaFilled(false);
        extendButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        extendButton.setName("extendButton"); // NOI18N
        extendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                extendButtonMouseReleased(evt);
            }
        });
        getContentPane().add(extendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 70, 17));

        exitButton.setToolTipText("Exit");
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setName("exitButton"); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButtonMouseReleased(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 2, 26, 26));

        dateTextField.setBackground(new java.awt.Color(0, 0, 0));
        dateTextField.setFont(new java.awt.Font("Digital-7", 0, 56)); // NOI18N
        dateTextField.setForeground(new java.awt.Color(51, 255, 0));
        dateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateTextField.setText("22.12.2022 pon");
        dateTextField.setBorder(null);
        dateTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dateTextField.setFocusable(false);
        getContentPane().add(dateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 310, 60));

        hourTextField.setBackground(new java.awt.Color(0, 0, 0));
        hourTextField.setFont(new java.awt.Font("Digital-7", 0, 56)); // NOI18N
        hourTextField.setForeground(new java.awt.Color(51, 255, 0));
        hourTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hourTextField.setBorder(null);
        hourTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hourTextField.setFocusable(false);
        getContentPane().add(hourTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 290, 60));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obrazy/zegar.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 352, 175));

        CalendarInternalFrame.setTitle("month");
        CalendarInternalFrame.setPreferredSize(new java.awt.Dimension(351, 329));
        CalendarInternalFrame.setVisible(true);
        CalendarInternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 7, 22, 0));

        mondayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        mondayLabel.setText("Mon");
        jPanel1.add(mondayLabel);

        tuesdayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        tuesdayLabel.setText("Tue");
        jPanel1.add(tuesdayLabel);

        wednesdayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        wednesdayLabel.setText("Wed");
        jPanel1.add(wednesdayLabel);

        thursdayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        thursdayLabel.setText("Thu");
        jPanel1.add(thursdayLabel);

        fridayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        fridayLabel.setText("Fri");
        jPanel1.add(fridayLabel);

        saturdayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        saturdayLabel.setText("Sat");
        jPanel1.add(saturdayLabel);

        sundayLabel.setFont(new java.awt.Font("High Tower Text", 2, 14)); // NOI18N
        sundayLabel.setText("Sun");
        jPanel1.add(sundayLabel);

        CalendarInternalFrame.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(340, 270));
        jPanel2.setLayout(new java.awt.GridLayout(5, 7));
        CalendarInternalFrame.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 24, -1, -1));

        backgroundInternal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obrazy/dayWindow.png"))); // NOI18N
        CalendarInternalFrame.getContentPane().add(backgroundInternal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, 333, 267));

        getContentPane().add(CalendarInternalFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, -1, 325));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseReleased
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseReleased

    private void extendButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extendButtonMouseReleased
        if(extendCounter % 2 == 0){
            
            this.setBounds(1000, 35, 351, 500);
            
            extendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obrazy/up.png")));
            
            extendCounter += 1;
        }
        else {
            
            this.setBounds(1000, 35, 351, 175);
            
            extendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/obrazy/down.png")));
            
            extendCounter += 1;
        }
        
    }//GEN-LAST:event_extendButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Zegar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zegar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zegar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zegar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Zegar dialog = new Zegar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame CalendarInternalFrame;
    private javax.swing.JLabel background;
    private javax.swing.JLabel backgroundInternal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton extendButton;
    private javax.swing.JLabel fridayLabel;
    private javax.swing.JTextField hourTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mondayLabel;
    private javax.swing.JLabel saturdayLabel;
    private javax.swing.JLabel sundayLabel;
    private javax.swing.JLabel thursdayLabel;
    private javax.swing.JLabel tuesdayLabel;
    private javax.swing.JLabel wednesdayLabel;
    // End of variables declaration//GEN-END:variables
    private int extendCounter;
    private javax.swing.JLabel[] labelArray;
    private DayWindows myCalendar;
    private Thread myClock;
    
    
    private void createDayLabels() {

        labelArray = new javax.swing.JLabel[35];
        
        for(int i = 0; i < 35; i++){
            labelArray[i] = new javax.swing.JLabel();
            
            labelArray[i].setFont(new java.awt.Font("High Tower Text", 3, 30));
            
            labelArray[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            labelArray[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);

            labelArray[i].setMaximumSize(new java.awt.Dimension(48, 61));

            labelArray[i].setMinimumSize(new java.awt.Dimension(48, 61));

            labelArray[i].setName(""); // NOI18N

            labelArray[i].setPreferredSize(new java.awt.Dimension(48, 61));

            jPanel2.add(labelArray[i]);
        }
    }
}