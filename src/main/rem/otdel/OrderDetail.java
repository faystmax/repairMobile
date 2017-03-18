/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.rem.otdel;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tigler
 */
public class OrderDetail extends javax.swing.JFrame {

    ArrayList<String> pkDetails;
    ArrayList<String> valueDetails;
    ArrayList<String> pkModel;
    ArrayList<String> valueModel;
    ArrayList<String> pkProizv;
    ArrayList<String> valueProizv;
    ArrayList<String> pkTypeDevice;
    ArrayList<String> valueTypeDevice;
    ArrayList<String> pkPostav;
    ArrayList<String> valuePostav;
    
    private ListenerCloseForm listenerCloseForm;

    /**
     * Creates new form Manager
     */
    public OrderDetail() {
        initComponents();
        ResultSet resSet = null;
        ResultSet resSetProizv = null;
        pkProizv = new ArrayList<String>();
        valueProizv = new ArrayList<String>();

        ResultSet resTypeDevice = null;
        pkTypeDevice = new ArrayList<String>();
        valueTypeDevice = new ArrayList<String>();

        pkDetails = new ArrayList<String>();
        valueDetails = new ArrayList<String>();

        pkModel = new ArrayList<String>();
        valueModel = new ArrayList<String>();

        pkPostav = new ArrayList<String>();
        valuePostav = new ArrayList<String>();

        try {

            //был replace
            jComboBoxModel.setEnabled(false);

            //производитель
            resSetProizv = RepairMobile.st.executeQuery("select * from manufacturer");
            TableModel tableModel = DbUtils.resultSetToTableModel(resSetProizv);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                pkProizv.add(tableModel.getValueAt(i, 0).toString());
                valueProizv.add(tableModel.getValueAt(i, 1).toString());
            }
            jComboBoxManufacturer.setModel(new DefaultComboBoxModel(valueProizv.toArray()));

            //тип устройства
            resSetProizv = RepairMobile.st.executeQuery("select * from typeofdevice");
            tableModel = DbUtils.resultSetToTableModel(resSetProizv);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                pkTypeDevice.add(tableModel.getValueAt(i, 0).toString());
                valueTypeDevice.add(tableModel.getValueAt(i, 1).toString());
            }
            jComboBoxTypeDevice.setModel(new DefaultComboBoxModel(valueTypeDevice.toArray()));

            resSetProizv = RepairMobile.st.executeQuery("select * from detail");
            tableModel = DbUtils.resultSetToTableModel(resSetProizv);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                pkDetails.add(tableModel.getValueAt(i, 0).toString());
                valueDetails.add(tableModel.getValueAt(i, 1).toString());
            }
            jComboBoxDetails.setModel(new DefaultComboBoxModel(valueDetails.toArray()));

            resSetProizv = RepairMobile.st.executeQuery("select pk_postavshik,nazv from postavshik");
            tableModel = DbUtils.resultSetToTableModel(resSetProizv);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                pkPostav.add(tableModel.getValueAt(i, 0).toString());
                valuePostav.add(tableModel.getValueAt(i, 1).toString());
            }
            jComboBoxPostav.setModel(new DefaultComboBoxModel(valuePostav.toArray()));

            jComboBoxDetails.setSelectedIndex(-1);
            jComboBoxPostav.setSelectedIndex(-1);
            jComboBoxTypeDevice.setSelectedIndex(-1);
            jComboBoxManufacturer.setSelectedIndex(-1);

        } catch (SQLException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setListenerCloseForm(ListenerCloseForm listenerCloseForm) {
        this.listenerCloseForm = listenerCloseForm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinnerAmount = new javax.swing.JSpinner();
        jComboBoxPostav = new javax.swing.JComboBox<>();
        jButtonOrder = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxDetails = new javax.swing.JComboBox<>();
        jComboBoxTypeDevice = new javax.swing.JComboBox<>();
        jComboBoxManufacturer = new javax.swing.JComboBox<>();
        jComboBoxModel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Заказ деталей");

        jButtonOrder.setText("Заказать");
        jButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderActionPerformed(evt);
            }
        });

        jLabel3.setText("Поставщик");

        jLabel4.setText("Количество");

        jLabel2.setText("Деталь");

        jLabel5.setText("Тип устройства");

        jLabel6.setText("Производитель");

        jLabel7.setText("Модель");

        jComboBoxManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxManufacturerActionPerformed(evt);
            }
        });

        jLabel8.setText("Стоимость");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxDetails, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTypeDevice, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxManufacturer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxModel, 0, 216, Short.MAX_VALUE)
                            .addComponent(jComboBoxPostav, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinnerAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jSpinner1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOrder)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxTypeDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPostav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jButtonOrder)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxManufacturerActionPerformed
        // TODO add your handling code here:
        if (jComboBoxManufacturer.getSelectedIndex() != -1) {
            jComboBoxModel.setEnabled(true);
            ResultSet resSetModel = null;
            pkModel = new ArrayList<String>();
            valueModel = new ArrayList<String>();
            try {
                // TODO add your handling code here:
                resSetModel = RepairMobile.st.executeQuery("select pk_modeldevice,nameofmodel"
                        + " from modeldevice where pk_manufacturer =" + pkProizv.get(jComboBoxManufacturer.getSelectedIndex()));
                TableModel tableModel = DbUtils.resultSetToTableModel(resSetModel);
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    pkModel.add(tableModel.getValueAt(i, 0).toString());
                    valueModel.add(tableModel.getValueAt(i, 1).toString());
                }
                jComboBoxModel.setModel(new DefaultComboBoxModel(valueModel.toArray()));
                jComboBoxModel.setSelectedIndex(-1);
            } catch (SQLException ex) {
                Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBoxManufacturerActionPerformed

    private void jButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ResultSet resSet = RepairMobile.st.executeQuery("select pk_concretedetail from concretedetail"
                    + " inner join modeldevice on modeldevice.PK_modeldevice=concretedetail.PK_modeldevice"
                    + " inner join manufacturer on manufacturer.PK_manufacturer=modeldevice.PK_manufacturer"
                    +" where "
                    + " concretedetail.pk_detail=" + pkDetails.get(jComboBoxDetails.getSelectedIndex())
                    + "and concretedetail.pk_modelDevice=" + pkModel.get(jComboBoxModel.getSelectedIndex())
                    + "and concretedetail.pk_typeofdevice=" + pkTypeDevice.get(jComboBoxTypeDevice.getSelectedIndex())
                    + "and manufacturer.pk_manufacturer=" + pkProizv.get(jComboBoxManufacturer.getSelectedIndex())
            );
            String pkConcretDetail = "";
            if (resSet.next()) {
                pkConcretDetail = resSet.getString(1);
            } else {
                int costOneDetail = Integer.parseInt(jSpinner1.getValue().toString()) / Integer.parseInt(jSpinnerAmount.getValue().toString());
                RepairMobile.st.executeQuery("insert into concretedetail (pk_detail,pk_modeldevice,pk_typeofdevice,costofdetail)"
                        + "values('" + pkDetails.get(jComboBoxDetails.getSelectedIndex())
                        + "','" + pkModel.get(jComboBoxModel.getSelectedIndex())
                        + "','" + pkTypeDevice.get(jComboBoxTypeDevice.getSelectedIndex()) + "','" + costOneDetail + "')"
                );
                resSet = RepairMobile.st.executeQuery("select SEQConcretedetail.currval from dual");
                if (resSet.next()) {
                    pkConcretDetail = resSet.getString(1);
                }
            }
            RepairMobile.st.executeQuery("insert into zakazdetails (pk_concretedetail,amount,cena,pk_postavshik) values"
                    + "('" + pkConcretDetail + "','" + jSpinnerAmount.getValue().toString() + "','" + jSpinner1.getValue().toString() + "','" + pkPostav.get(jComboBoxPostav.getSelectedIndex()) + "')"
            );
            JOptionPane.showMessageDialog(this, "Заказ успешно добавлен");
            listenerCloseForm.event();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ошибка: Невозможно добавить заказ");
        }
    }//GEN-LAST:event_jButtonOrderActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOrder;
    private javax.swing.JComboBox<String> jComboBoxDetails;
    private javax.swing.JComboBox<String> jComboBoxManufacturer;
    private javax.swing.JComboBox<String> jComboBoxModel;
    private javax.swing.JComboBox<String> jComboBoxPostav;
    private javax.swing.JComboBox<String> jComboBoxTypeDevice;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinnerAmount;
    // End of variables declaration//GEN-END:variables
}
