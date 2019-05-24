/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.modele;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi.metier.API_TAXI1;
import taxi.DAO.API_TAXI1DAO;

/**
 *
 * @author Clive
 */
public class SupTaxi extends javax.swing.JPanel {

    /**
     * Creates new form SupTaxi
     */
    API_TAXI1DAO taxiDAO = null;
    DefaultTableModel dftm = new DefaultTableModel();

    public SupTaxi() {
        initComponents();
        dftm.addColumn("Id_taxi");
        dftm.addColumn("Immatriculation");
        dftm.addColumn("Carburant");
        dftm.addColumn("Prix au km");
        dftm.addColumn("Description");
        jTable1.setModel(dftm);
    }

    public void setTaxiDAO(API_TAXI1DAO taxiDAO) {
        this.taxiDAO = taxiDAO;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        valeur = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 3, 24)); // NOI18N
        jLabel1.setText("Auto Rent");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Filtre: ");

        valeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valeurActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 51, 51));
        delete.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        delete.setText("Supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setText("Rech Desc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setText("Rech Imma");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton3.setText("Les Taxis");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButton4.setText("Accueil");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton3)
                        .addGap(60, 60, 60)
                        .addComponent(delete)
                        .addGap(69, 69, 69)
                        .addComponent(jButton2)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addGap(49, 49, 49)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valeur, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(396, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(valeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(delete)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void valeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valeurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valeurActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String Immatriculation = valeur.getText();
            API_TAXI1 t = taxiDAO.readstring(Immatriculation);
            taxiDAO.delete(t);
            JOptionPane.showMessageDialog(this,"Taxi supprimé!","succès!!",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Impossible de supprimer ce Taxi il est déjà reservé ", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String Description = valeur.getText();
            List<API_TAXI1> l = taxiDAO.rechp(Description);
            int nr = dftm.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dftm.removeRow(i);
            }
            for (API_TAXI1 vt : l) {
                Vector v = new Vector();
                v.add(vt.getIdtaxi());
                v.add(vt.getImmatriculation());
                v.add(vt.getCarburant());
                v.add(vt.getPrixkm());
                v.add(vt.getDescription());
                dftm.addRow(v);
            }
            taxiDAO.readstring(Description);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Taxi inexistant", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String Immatriculation = valeur.getText();
            API_TAXI1 vt = ((API_TAXI1DAO) taxiDAO).readstring(Immatriculation);
            int nr = dftm.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dftm.removeRow(i);
            }
            Vector v = new Vector();
            v.add(vt.getIdtaxi());
            v.add(vt.getImmatriculation());
            v.add(vt.getCarburant());
            v.add(vt.getPrixkm());
            v.add(vt.getDescription());
            dftm.addRow(v);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Taxi inexistant Vérifiez la valeur entrée!", "ERREUR!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            List<API_TAXI1> l = taxiDAO.Affiche();
            int nr = dftm.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dftm.removeRow(i);
            }
            for (API_TAXI1 vt : l) {
                Vector v = new Vector();
                v.add(vt.getIdtaxi());
                v.add(vt.getImmatriculation());
                v.add(vt.getCarburant());
                v.add(vt.getPrixkm());
                v.add(vt.getDescription());
                dftm.addRow(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        Principale p = new Principale();
        p.setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField valeur;
    // End of variables declaration//GEN-END:variables
}
