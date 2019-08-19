/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.modele;
import taxi.metier.API_CLIENT1;
import taxi.metier.API_LOCATION1;
import taxi.metier.API_TAXI1;
import taxi.metier.API_ADRESSE1;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi.DAO.ClientDAO;
import taxi.DAO.API_LOCATION1DAO;
import taxi.DAO.API_TAXI1DAO;
import taxi.DAO.AdresseDAO;
/**
 *
 * @author CASHCONVERTERS
 */
public class RechLoc extends javax.swing.JPanel {

    /**
     * Creates new form RechLoc
     */
    DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    API_LOCATION1DAO locationDAO = null;
    API_TAXI1DAO taxiDAO = null;
    ClientDAO clientDAO = null;
    AdresseDAO adresseDAO = null;
    DefaultTableModel dtml = new DefaultTableModel();
    List<API_TAXI1> t1;
    public RechLoc() {
        initComponents();
        dtml.addColumn("idloc");
        dtml.addColumn("DateLoc");
        dtml.addColumn("Kmtotal");
        dtml.addColumn("acompte");
        dtml.addColumn("total");
        dtml.addColumn("taxi");
        dtml.addColumn("client");
        dtml.addColumn("adresse départ");
        dtml.addColumn("adresse arrivé");
        jTable2.setModel(dtml);
    }

    public void setLocationDAO(API_LOCATION1DAO locationDAO) {
        this.locationDAO = locationDAO;
    }
    public void setTaxiDAO(API_TAXI1DAO taxiDAO) {
        this.taxiDAO = taxiDAO;
    }
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
     public void setAdresseDAO(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }
    
    public void AddTaxi() {
        try {
            t1 = taxiDAO.Affiche();
            if (jComboBox1 != null) {
                jComboBox1.removeAllItems();
            }
            Iterator<API_TAXI1> itt = t1.iterator();
            while (itt.hasNext()) {
                API_TAXI1 v = itt.next();
                dcbm.addElement(v.toString());
            }
            
            jComboBox1.setModel(dcbm);

        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setBackground(new java.awt.Color(51, 0, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setText("Auto Rent");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setText("Taxi:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 3, 10)); // NOI18N
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int id = jComboBox1.getSelectedIndex();
            API_TAXI1 t = t1.get(id);
            System.out.println(t.getIdtaxi());
            List<API_LOCATION1> loc = locationDAO.AfficheLocTaxi(t.getIdtaxi());
            System.out.println(loc);
            int n = dtml.getRowCount();
            for (int i = n - 1; i >= 0; i--) {
                dtml.removeRow(i);
            }

            for (API_LOCATION1 l : loc) {
                Vector v = new Vector();
                v.add(l.getIdloc());
                System.out.println(v);
                v.add(l.getDateloc());
                System.out.println(v);
                v.add(l.getKmtotal());
                System.out.println(v);
                v.add(l.getAcompte());
                System.out.println(v);
                v.add(l.getTotal());
                System.out.println(v);
                v.add(l.getId_taxi());
               /* t = taxiDAO.read(l.getId_taxi());
                v.add(t.getImmatriculation());
                System.out.println(v);*/
                API_CLIENT1 cl = clientDAO.read(l.getId_client());
                v.add(cl.getNom());
                System.out.println(v);
                API_ADRESSE1 deb = adresseDAO.read(l.getId_deb());
                v.add("Rue " + deb.getRue()+ ", " + deb.getLocalite());
                API_ADRESSE1 fin = adresseDAO.read(l.getId_fin());
                v.add("Rue" + fin.getRue() + ", " + fin.getLocalite());
                System.out.println(v);
                dtml.addRow(v);
            }
        } catch (SQLException e) {
            System.out.println("Exception " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
