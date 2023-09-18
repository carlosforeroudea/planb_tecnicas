/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package front;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.Client;
import model.Transaction;
import model.Transaction.Transactiontype;
import process.BankProcess;
import process.extract;

/**
 *
 * @author carlosforero
 */
public class InternalTransactions extends javax.swing.JInternalFrame {
private HashMap<String,Client> clients_import;
private HashMap<String,Account> acounts_import;
    /**
     * Creates new form Transactions
     */
    public InternalTransactions() {
        initComponents();
        clients_import = process.BankProcess.get_Clients();
        acounts_import = process.BankProcess.get_Accounts();
        
        get_accounts();
        refresh();
    }
    private void refresh(){
        cleanJtable();
        writeJtable();
    }
    
    private void cleanJtable(){
        DefaultTableModel model = (DefaultTableModel) jTableAccounts.getModel();
        model.getDataVector().removeAllElements();
        revalidate();
    }
    private void writeJtable(){
        DefaultTableModel model = (DefaultTableModel) jTableAccounts.getModel();
        HashMap<String,Transaction> transactions = process.BankProcess.get_Transactions();
        for (Map.Entry<String, Transaction> entry : transactions.entrySet()) {
            model.addRow(new Object[]{entry.getValue().get_uuid(),entry.getValue().get_type(),entry.getValue().get_datetime(),entry.getValue().get_amount(),entry.getValue().get_account().get_client().get_id(),entry.getValue().get_account().get_client().get_first_name(),entry.getValue().get_account().get_client().get_last_name(),entry.getValue().get_account().get_numberAccount()});
        }
        
        revalidate();
    }
    
    public void get_accounts(){
        
        HashMap<String,Account> accounts = process.BankProcess.get_Accounts();
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            jComboBoxClient.addItem(entry.getValue().get_numberAccount());
            
        }
        
    }
    public void get_info(String client_id){
        jLabelwithdrawal_in_day.setText(BankProcess.count_withdrawal_in_day(client_id)+" ");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelAddFirstName = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jTextFieldAddamount = new javax.swing.JTextField();
        jLabelAddLastName = new javax.swing.JLabel();
        Identification = new javax.swing.JLabel();
        jComboBoxClient = new javax.swing.JComboBox<>();
        jComboBoxType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAccounts = new javax.swing.JTable();
        jPanelInfo = new javax.swing.JPanel();
        jLabelBalance = new javax.swing.JLabel();
        jLabelClientName = new javax.swing.JLabel();
        jLabelwithdrawal_in_day = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserFirstDate = new com.toedter.calendar.JDateChooser();
        jDateChooserSecondDate = new com.toedter.calendar.JDateChooser();
        jButtonGenerateExtract = new javax.swing.JButton();

        jLabelAddFirstName.setText("Tipo");

        jButtonAdd.setText("Registrar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jLabelAddLastName.setText("Cantidad");

        Identification.setText("Cuenta");

        jComboBoxClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientActionPerformed(evt);
            }
        });

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "consignment", "withdrawal" }));
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddFirstName)
                    .addComponent(jLabelAddLastName)
                    .addComponent(Identification))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxClient, 0, 268, Short.MAX_VALUE)
                    .addComponent(jTextFieldAddamount)
                    .addComponent(jComboBoxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jButtonAdd)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Identification)
                    .addComponent(jComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddFirstName)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdd)
                .addContainerGap())
        );

        jTableAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "uuid", "type", "datetime", "amount", "id_client", "first_name", "numberAccount"
            }
        ));
        jScrollPane1.setViewportView(jTableAccounts);

        jPanelInfo.setBackground(new java.awt.Color(1, 207, 143));

        jLabelBalance.setText("Balance");

        jLabelClientName.setText("Client_name");

        jLabelwithdrawal_in_day.setText("withdrawal_in_day");

        jLabel2.setText("Saldo");

        jLabel3.setText("Cliente");

        jLabel4.setText("retiros al dia");

        jButtonGenerateExtract.setText("Generar Extracto");
        jButtonGenerateExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateExtractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18))
                    .addGroup(jPanelInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBalance)
                    .addComponent(jLabelClientName)
                    .addComponent(jLabelwithdrawal_in_day))
                .addGap(24, 24, 24))
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooserFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDateChooserSecondDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGenerateExtract)
                .addGap(41, 41, 41))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClientName)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBalance)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelwithdrawal_in_day)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserSecondDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGenerateExtract)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try{
            
            int amount =Integer.parseInt(jTextFieldAddamount.getText());
            String id_account = jComboBoxClient.getSelectedItem().toString();
            Account account = acounts_import.get(id_account);
            String type= jComboBoxType.getSelectedItem().toString();
            int balance = BankProcess.get_balence_by_account(id_account);
            int max_amount = acounts_import.get(id_account).get_limit_per_amount();
            int overdraft = acounts_import.get(id_account).get_overdraft();
            if((balance+overdraft)<amount && type=="withdrawal")
            {
                JOptionPane.showMessageDialog(null,"Dispone de un saldo de "+balance+" el cual es insuficiente!");
                
            }
            else{
                int account_limit = acounts_import.get(id_account).get_limit_per_day();
                int twd = BankProcess.count_withdrawal_in_day(id_account);
                if(twd<account_limit){
                    if(max_amount<amount && type=="withdrawal")
                    {
                        JOptionPane.showMessageDialog(null,"Excede el valor maximo de retiro!");
                        
                    }
                    else{
                        BankProcess.Create_transaction(id_account,type,amount);
                        JOptionPane.showMessageDialog(null,"Transaccion realizada!");
                        refresh();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Excede el numero maximo de transacciones por dia!");
                }
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Validar cantidad ingresada");
            
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientActionPerformed
        jLabelClientName.setText(acounts_import.get(jComboBoxClient.getSelectedItem().toString()).get_client().get_first_name()+ " "+acounts_import.get(jComboBoxClient.getSelectedItem().toString()).get_client().get_last_name());
        jLabelBalance.setText("$ "+BankProcess.get_balence_by_account(jComboBoxClient.getSelectedItem().toString()));
        get_info(jComboBoxClient.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxClientActionPerformed

    private void jButtonGenerateExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateExtractActionPerformed
        Date date1 = jDateChooserFirstDate.getDate();
        Date date2 = jDateChooserSecondDate.getDate();
        String account_id=jComboBoxClient.getSelectedItem().toString();
        extract.exportReportByAccount("extract.csv",date1,date2,account_id);
        JOptionPane.showMessageDialog(null, "Extracto Generado Exitosamente!");
    }//GEN-LAST:event_jButtonGenerateExtractActionPerformed

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Identification;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonGenerateExtract;
    private javax.swing.JComboBox<String> jComboBoxClient;
    private javax.swing.JComboBox<String> jComboBoxType;
    private com.toedter.calendar.JDateChooser jDateChooserFirstDate;
    private com.toedter.calendar.JDateChooser jDateChooserSecondDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAddFirstName;
    private javax.swing.JLabel jLabelAddLastName;
    private javax.swing.JLabel jLabelBalance;
    private javax.swing.JLabel jLabelClientName;
    private javax.swing.JLabel jLabelwithdrawal_in_day;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAccounts;
    private javax.swing.JTextField jTextFieldAddamount;
    // End of variables declaration//GEN-END:variables
}
