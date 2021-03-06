package pkginterface;

import control.BusDetailsControl;
import control.BusScheduleControl;
import control.LocationControl;
import domain.BusDetailsDomain;
import domain.BusScheduleDomain;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Student
 */
public class BusSchedule extends javax.swing.JFrame {

    /**
     * Creates new form BusSchedule
     */
    BusScheduleControl bsControl = new BusScheduleControl();
    LocationControl lctControl = new LocationControl();
    BusDetailsControl bdControl = new BusDetailsControl();
    BusDetailsDomain bd;
    ResultSet rs;
    Date today = new Date();

    public BusSchedule() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        /*This Part is to make the BusStatus to Available if the Date is expired
         -------------------------------------------------------------------------------------------*/
        ResultSet bsrs = bsControl.retrieveRecord(); //bsrs = BusScheduleResultSet

        try {
            SimpleDateFormat df = new SimpleDateFormat("d-M-yyyy");
            while (bsrs.next()) {
                Date date1 = df.parse(bsrs.getString(2));
                if (date1.after(today) || date1.equals(today)) {
                    BusDetailsDomain bd = bdControl.getRecord(bsrs.getString(8));
                    bd.setBusStatus("Not Available");
                    bdControl.updateRecord(bd);
                } else {
                    BusDetailsDomain bd = bdControl.getRecord(bsrs.getString(8));
                    bd.setBusStatus("Available");
                    bdControl.updateRecord(bd);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*------------------------------------------------------------------------------------------*/
        setBusIDCBItem();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ScheduleIDTF = new javax.swing.JTextField();
        SearchBTN = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        UpdateBTN = new javax.swing.JButton();
        ViewAllBTN = new javax.swing.JButton();
        AddBTN = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        BusIDCB = new javax.swing.JComboBox();
        Price = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ScheduleTimeCB = new javax.swing.JComboBox();
        DepartLocationCB = new javax.swing.JComboBox();
        ArriveLocationCB = new javax.swing.JComboBox();
        BackBTN = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Pristina", 3, 48)); // NOI18N
        Title.setText("Bus Schedule Maintenance System");

        jLabel3.setText("Schedule Date*");

        jLabel4.setText("Schedule ID");

        jLabel5.setText("Schedule Time*");

        jLabel6.setText("Departure Location*");

        jLabel7.setText("Arrival Location*");

        ScheduleIDTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ScheduleIDTFCaretUpdate(evt);
            }
        });
        ScheduleIDTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ScheduleIDTFKeyTyped(evt);
            }
        });

        SearchBTN.setText("Search");
        SearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBTNActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("* means compulsory to fill in");

        UpdateBTN.setText("Update Schedule");
        UpdateBTN.setEnabled(false);
        UpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTNActionPerformed(evt);
            }
        });

        ViewAllBTN.setText("View All");
        ViewAllBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAllBTNActionPerformed(evt);
            }
        });

        AddBTN.setText("Add Schedule");
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });

        jLabel9.setText("Bus ID*");

        Price.setText("Price*");

        jLabel12.setText("Available Seat*");

        ScheduleTimeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00" }));

        BackBTN.setText("Back");
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ScheduleIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchBTN))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ScheduleTimeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BusIDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DepartLocationCB, 0, 134, Short.MAX_VALUE)
                                    .addComponent(ArriveLocationCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AddBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(ViewAllBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScheduleIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBTN))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleTimeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepartLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(ArriveLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(BusIDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewAllBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBTNActionPerformed
        if (ScheduleIDTF.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert Schedule ID to search.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            BusScheduleDomain bs = bsControl.selectRecord(ScheduleIDTF.getText());
            if (bs == null) {
                JOptionPane.showMessageDialog(null, "Record not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                SimpleDateFormat df = new SimpleDateFormat("d-M-yyyy");
                Date date1 = null;
                try {
                    date1 = df.parse(bs.getScheduleDate());
                } catch (ParseException ex) {
                    Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Remove All Items on BusIDCB
                BusIDCB.removeAllItems();

                //Add Bus ID and Type for Current search into BusIDCB
                BusIDCB.addItem(bs.getBusId().getBusId() + " (" + bs.getBusId().getBusType() + ")");

                //Add Bus ID that are available for user choose
                try {
                    rs = bdControl.retrieveRecord();
                    while (rs.next()) {
                        if (rs.getString(4).equals("Available")) {
                            BusIDCB.addItem(rs.getString(1) + " (" + rs.getString(7) + ")");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }

                BusIDCB.setSelectedItem(bs.getBusId().getBusId());
                ScheduleDatePicker.setDate(date1);
                AvailableSeatTF.setText("" + bs.getAvailableSeat());
                PriceTF.setText("" + bs.getPrice());
                ScheduleTimeCB.setSelectedItem(bs.getScheduleTime());
                DepartLocationCB.setSelectedItem(bs.getDepartLocation());
                ArriveLocationCB.setSelectedItem(bs.getArriveLocation());
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBTNActionPerformed

    private void ScheduleIDTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ScheduleIDTFCaretUpdate
        if (!ScheduleIDTF.getText().equals("")) {
            AddBTN.setEnabled(false);
        } else {
            UpdateBTN.setEnabled(false);
            AddBTN.setEnabled(true);
            //Remove BusIDCB all Items and Add only "Available" item into BusIDCB
            BusIDCB.removeAllItems();
            try {
                rs = bdControl.retrieveRecord();
                while (rs.next()) {
                    if (rs.getString(4).equals("Available")) {
                        BusIDCB.addItem(rs.getString(1) + " (" + rs.getString(7) + ")");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
            }
            ScheduleTimeCB.setSelectedIndex(0);
            ScheduleDatePicker.setDate(null);
            if (BusIDCB.getItemCount() > 0) {
                BusIDCB.setSelectedIndex(0);
            }
            AvailableSeatTF.setText("");
            DepartLocationCB.setSelectedIndex(0);
            ArriveLocationCB.setSelectedIndex(0);
            PriceTF.setText("");
        }


    }//GEN-LAST:event_ScheduleIDTFCaretUpdate

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
        SimpleDateFormat formater = new SimpleDateFormat("d-M-yyyy");
        BusScheduleDomain bs = null;
        today = new Date();
        try {
            bs = bsControl.getLastRow();
            if (bs != null) {
                int tempIntScheduleID = Integer.parseInt(bs.getScheduleId());
                tempIntScheduleID += 1;
                String tempStrScheduleID = null;
                if (tempIntScheduleID <= 9) {
                    tempStrScheduleID = "0000" + tempIntScheduleID;
                } else if (tempIntScheduleID <= 99) {
                    tempStrScheduleID = "000" + tempIntScheduleID;
                } else if (tempIntScheduleID <= 999) {
                    tempStrScheduleID = "00" + tempIntScheduleID;
                } else if (tempIntScheduleID <= 9999) {
                    tempStrScheduleID = "0" + tempIntScheduleID;
                } else if (tempIntScheduleID <= 99999) {
                    tempStrScheduleID = "" + tempIntScheduleID;
                }
                String priceValidation = "[0-9]{1,2}+.+[0-9]{1,2}";
                if (Integer.parseInt(AvailableSeatTF.getText()) <= 0 || Integer.parseInt(AvailableSeatTF.getText()) > 30 || !PriceTF.getText().matches(priceValidation) || Double.parseDouble(PriceTF.getText()) <= 00.00) {
                    JOptionPane.showMessageDialog(null, "Invalid Input\n\nAvailable Seat : >0 ; <=30\nPrice : 00.00 ; > 0", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (ScheduleDatePicker.getDate().before(today)) {
                    JOptionPane.showMessageDialog(null, "The date you choose is not available.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (DepartLocationCB.getSelectedItem().equals(ArriveLocationCB.getSelectedItem())) {
                    JOptionPane.showMessageDialog(null, "Depart Location cannot be same with Arrive Location.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else if(Integer.parseInt(AvailableSeatTF.getText())>getSelectedBusIDTotalSeat()){
                    JOptionPane.showMessageDialog(null, "The Bus Total Seat is "+getSelectedBusIDTotalSeat()+" only.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else {
                    String tempBusID = (String) BusIDCB.getSelectedItem();
                    tempBusID = tempBusID.substring(0, 5);
                    bd = bdControl.getRecord(tempBusID);
                    bs = new BusScheduleDomain(tempStrScheduleID, formater.format(ScheduleDatePicker.getDate()), (String) ScheduleTimeCB.getSelectedItem(), Integer.parseInt(AvailableSeatTF.getText()), Double.parseDouble(PriceTF.getText()), (String) DepartLocationCB.getSelectedItem(), (String) ArriveLocationCB.getSelectedItem(), bd);
                    bsControl.addRecord(bs);
                    JOptionPane.showMessageDialog(null, "The New Bus Schedule is added!\nSchedule ID : "+tempStrScheduleID);
                    bd.setBusStatus("No Available");
                    bdControl.updateRecord(bd);

                    //Change Bus Status
                    bd.setBusStatus("No Available");
                    bdControl.updateRecord(bd);

                    //Clear and Refresh Bus ID combo box
                    BusIDCB.removeAllItems();
                    try {
                        rs = bdControl.retrieveRecord();
                        while (rs.next()) {
                            if (rs.getString(4).equals("Available")) {
                                BusIDCB.addItem(rs.getString(1) + " (" + rs.getString(7) + ")");
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Clear input
                    ScheduleTimeCB.setSelectedIndex(0);
                    ScheduleDatePicker.setDate(null);
                    if (BusIDCB.getItemCount() > 0) {
                        BusIDCB.setSelectedIndex(0);
                    }
                    AvailableSeatTF.setText("");
                    DepartLocationCB.setSelectedItem("JOHOR BAHRU");
                    ArriveLocationCB.setSelectedItem("JOHOR BAHRU");
                    PriceTF.setText("");
                }
            } else {
                String tempStrScheduleID = "00001";
                String priceValidation = "[0-9]{1,2}+.+[0-9]{1,2}";
                if (Integer.parseInt(AvailableSeatTF.getText()) <= 0 || Integer.parseInt(AvailableSeatTF.getText()) > 30 || !PriceTF.getText().matches(priceValidation) || Double.parseDouble(PriceTF.getText()) <= 00.00) {
                    JOptionPane.showMessageDialog(null, "Invalid Input\n\nAvailable Seat : >0 ; <=30\nPrice : 00.00 ; > 0", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (ScheduleDatePicker.getDate().before(today)) {
                    JOptionPane.showMessageDialog(null, "The date you choose is not available.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (DepartLocationCB.getSelectedItem().equals(ArriveLocationCB.getSelectedItem())) {
                    JOptionPane.showMessageDialog(null, "Depart Location cannot be same with Arrive Location.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if(Integer.parseInt(AvailableSeatTF.getText())>getSelectedBusIDTotalSeat()){
                    JOptionPane.showMessageDialog(null, "The Bus Total Seat is "+getSelectedBusIDTotalSeat()+" only.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else {
                    String tempBusID = (String) BusIDCB.getSelectedItem();
                    tempBusID = tempBusID.substring(0, 5);
                    bd = bdControl.getRecord(tempBusID);
                    bs = new BusScheduleDomain(tempStrScheduleID, formater.format(ScheduleDatePicker.getDate()), (String) ScheduleTimeCB.getSelectedItem(), Integer.parseInt(AvailableSeatTF.getText()), Double.parseDouble(PriceTF.getText()), (String) DepartLocationCB.getSelectedItem(), (String) ArriveLocationCB.getSelectedItem(), bd);
                    bsControl.addRecord(bs);
                    JOptionPane.showMessageDialog(null, "The New Bus Schedule is added!\nSchedule ID : "+tempStrScheduleID);

                    //Change Bus Status
                    bd.setBusStatus("No Available");
                    bdControl.updateRecord(bd);

                    //Clear and Refresh Bus ID combo box
                    BusIDCB.removeAllItems();
                    try {
                        rs = bdControl.retrieveRecord();
                        while (rs.next()) {
                            if (rs.getString(4).equals("Available")) {
                                BusIDCB.addItem(rs.getString(1) + " (" + rs.getString(7) + ")");
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //Clear input
                    ScheduleTimeCB.setSelectedIndex(0);
                    ScheduleDatePicker.setDate(null);
                    if (BusIDCB.getItemCount() > 0) {
                        BusIDCB.setSelectedIndex(0);
                    }
                    AvailableSeatTF.setText("");
                    DepartLocationCB.setSelectedItem("JOHOR BAHRU");
                    ArriveLocationCB.setSelectedItem("JOHOR BAHRU");
                    PriceTF.setText("");

                }
            }
            setBusIDCBItem();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Input\n\nAvailable Seat : >0 ; <=30\nPrice : 00.00", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
//            JOptionPane.showMessageDialog(null, "Please fill in all the required field.", "ERROR", JOptionPane.ERROR_MESSAGE);
            setBusIDCBItem();
        }


    }//GEN-LAST:event_AddBTNActionPerformed

    private void UpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTNActionPerformed
        SimpleDateFormat formater = new SimpleDateFormat("d-M-yyyy");
        Date today = new Date();

        //Get the Bus ID without Type from BusIDCB
        String tempBusID = (String) BusIDCB.getSelectedItem();
        tempBusID = tempBusID.substring(0, 5);

        bd = bdControl.getRecord(tempBusID);

        String priceValidation = "[0-9]{1,2}+.+[0-9]{1,2}";
        if (Integer.parseInt(AvailableSeatTF.getText()) <= 0 || Integer.parseInt(AvailableSeatTF.getText()) > 30 || !PriceTF.getText().matches(priceValidation) || Double.parseDouble(PriceTF.getText()) <= 00.00) {
            JOptionPane.showMessageDialog(null, "Invalid Input\n\nAvailable Seat : >0 ; <=30\nPrice : 00.00 ; > 0", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (ScheduleDatePicker.getDate().before(today)) {
            JOptionPane.showMessageDialog(null, "The date you choose is not available.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (DepartLocationCB.getSelectedItem().equals(ArriveLocationCB.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Depart Location cannot be same with Arrive Location.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            BusScheduleDomain bs = new BusScheduleDomain(ScheduleIDTF.getText(), formater.format(ScheduleDatePicker.getDate()), (String) ScheduleTimeCB.getSelectedItem(), Integer.parseInt(AvailableSeatTF.getText()), Double.parseDouble(PriceTF.getText()), (String) DepartLocationCB.getSelectedItem(), (String) ArriveLocationCB.getSelectedItem(), bd);
            bsControl.updateRecord(bs);
            JOptionPane.showMessageDialog(null, "The Bus Schedule is updated!");

            if (BusIDCB.getSelectedIndex() != 0) {
                //Change status to Not Available for the bus choosed by user
                bd.setBusStatus("Not Available");
                bdControl.updateRecord(bd);

                //Change status to Available if user choosed another bus
                tempBusID = (String) BusIDCB.getItemAt(0);
                tempBusID = tempBusID.substring(0, 5);
                bd = bdControl.getRecord(tempBusID);
                bd.setBusStatus("Available");
                bdControl.updateRecord(bd);
            }

            //Clear Input
            ScheduleIDTF.setText("");
            ScheduleDatePicker.setDate(null);
            ScheduleTimeCB.setSelectedIndex(0);
            AvailableSeatTF.setText("");
            PriceTF.setText("");
            DepartLocationCB.setSelectedItem("JOHOR BAHRU");
            ArriveLocationCB.setSelectedItem("JOHOR BAHRU");
            if (BusIDCB.getItemCount() > 0) {
                BusIDCB.setSelectedIndex(0);
            }
        }

    }//GEN-LAST:event_UpdateBTNActionPerformed

    private void AvailableSeatTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_AvailableSeatTFCaretUpdate
        if (!ScheduleIDTF.getText().equals("") && !AvailableSeatTF.getText().equals("") && !PriceTF.getText().equals("")) {
            UpdateBTN.setEnabled(true);
        } else {
            UpdateBTN.setEnabled(false);
        }
    }//GEN-LAST:event_AvailableSeatTFCaretUpdate

    private void ViewAllBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAllBTNActionPerformed
        new ViewAllSche();
    }//GEN-LAST:event_ViewAllBTNActionPerformed

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        dispose();
        new MainMenu();// TODO add your handling code here:
    }//GEN-LAST:event_BackBTNActionPerformed

    private void AvailableSeatTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AvailableSeatTFKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) || AvailableSeatTF.getText().length() >= 2) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_AvailableSeatTFKeyTyped

    private void ScheduleIDTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ScheduleIDTFKeyTyped
        if (ScheduleIDTF.getText().length() >= 5) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ScheduleIDTFKeyTyped

    private void PriceTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceTFKeyTyped
        if (PriceTF.getText().length() >= 5) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTFKeyTyped

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
            java.util.logging.Logger.getLogger(BusSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusSchedule().setVisible(true);
            }
        });
    }

    private void setBusIDCBItem() {
        BusIDCB.removeAllItems();
        try {
            rs = lctControl.retrieveRecord();
            while (rs.next()) {
                DepartLocationCB.addItem(rs.getString(2));
                ArriveLocationCB.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = bdControl.retrieveRecord();
            while (rs.next()) {
                if (rs.getString(4).equals("Available")) {
                    BusIDCB.addItem(rs.getString(1) + "--(" + rs.getString(7) + ")--"+rs.getString(2));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int getSelectedBusIDTotalSeat(){
        String tempBusID = (String) BusIDCB.getSelectedItem();
        tempBusID = tempBusID.substring(0, 5);
        BusDetailsDomain AS = bdControl.getRecord(tempBusID);
        return AS.getTotalSeat();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBTN;
    private javax.swing.JComboBox ArriveLocationCB;
    private javax.swing.JButton BackBTN;
    private javax.swing.JComboBox BusIDCB;
    private javax.swing.JComboBox DepartLocationCB;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField ScheduleIDTF;
    private javax.swing.JComboBox ScheduleTimeCB;
    private javax.swing.JButton SearchBTN;
    private javax.swing.JLabel Title;
    private javax.swing.JButton UpdateBTN;
    private javax.swing.JButton ViewAllBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
