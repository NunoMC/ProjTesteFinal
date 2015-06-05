/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import antlr.Parser;
import bll.LoteBLL;
import bll.ProdutoBLL;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Lote;
import model.Produto;

/**
 *
 * @author NunoM
 */
public class Lotes extends javax.swing.JPanel {

    private Lote l;
    private Produto prod;    
    List<Produto> list;
    public Lotes() {
        initComponents();
        List<Produto> list = ProdutoBLL.retrieveALL();
        l = new Lote();
        prod = new Produto();
     
        actualizaDados();
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
        jLabel6 = new javax.swing.JLabel();
        labelRecebeFunc1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLote = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboProd = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lotePrec = new javax.swing.JTextField();
        LoteProdEst = new javax.swing.JTextField();
        LoteQtd = new javax.swing.JTextField();
        btNovo2 = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btElim = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        QtdAtual = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Lotes");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Funcionário:");

        tabLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Data Chegada", "Produto Estragado(qtd)", "Preço", "Quantidade Lote", "Quantidade actual", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabLote);
        if (tabLote.getColumnModel().getColumnCount() > 0) {
            tabLote.getColumnModel().getColumn(6).setMinWidth(0);
            tabLote.getColumnModel().getColumn(6).setPreferredWidth(0);
            tabLote.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel2.setText("Produto:");

        comboProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Chegada:");

        jLabel4.setText("Preço:");

        jLabel5.setText("Produto Estragado (qtd):");

        jLabel7.setText("Quantidade Lote:");

        lotePrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lotePrecActionPerformed(evt);
            }
        });

        btNovo2.setText("Novo");
        btNovo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovo2ActionPerformed(evt);
            }
        });

        btEdit.setText("Editar");

        btElim.setText("Eliminar");

        jLabel8.setText("Quantidade Atual:");

        QtdAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtdAtualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRecebeFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(comboProd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(QtdAtual)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoteQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(lotePrec)
                            .addComponent(LoteProdEst))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNovo2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btElim, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRecebeFunc1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btEdit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lotePrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(comboProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btNovo2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LoteProdEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(LoteQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btElim))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(QtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lotePrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lotePrecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lotePrecActionPerformed

    private void btNovo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovo2ActionPerformed
        if (lotePrec.getText().isEmpty() || LoteProdEst.getText().isEmpty() || LoteQtd.getText().isEmpty()
                || QtdAtual.getText().isEmpty() || jDateChooser1.getDateFormatString().isEmpty()) {
            String messag = "Campos Vazios!!";
            String titl = "Insira Nome e Morada";
            int reply = JOptionPane.showConfirmDialog(null, messag, titl, JOptionPane.DEFAULT_OPTION);
        } else {
         
            
          //falta por os produtos a aparecer na combobox!!
            PreencheCombo();
            l.setPreco(Double.valueOf(lotePrec.getText()));
            l.setQtdcompra(Double.valueOf(LoteQtd.getText()));
            l.setQtdlixo(Double.valueOf(LoteProdEst.getText()));
            l.setQuantidade(Double.valueOf(QtdAtual.getText()));
            l.setIdProduto(prod);
            java.sql.Date JavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            Calendar calendar = new GregorianCalendar();
            calendar.set(Calendar.YEAR, 2014);
            calendar.set(Calendar.MONTH, 10 - 1);
            calendar.set(Calendar.DAY_OF_MONTH, 3);
            l.setDataChegada(calendar.getTime());

            LoteBLL.create(l);

            actualizaDados();

        }
    }//GEN-LAST:event_btNovo2ActionPerformed

    private void QtdAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtdAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtdAtualActionPerformed

    private void comboProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProdActionPerformed

    public void limparJTable() {
        javax.swing.table.DefaultTableModel model2 = (javax.swing.table.DefaultTableModel) tabLote.getModel();
        model2.setRowCount(0);
    }

    public void actualizaDados() {

        limparJTable();

        if (LoteBLL.retrieveAll() != null) {
            javax.swing.table.DefaultTableModel model1 = (javax.swing.table.DefaultTableModel) tabLote.getModel();
            for (Lote a : LoteBLL.retrieveAll()) {
                model1.addRow(new Object[]{a.getIdProduto().getDescricao(), a.getDataChegada(),
                    a.getQtdlixo(), a.getPreco(), a.getQtdcompra(), a.getQuantidade(), a.getIdLote()});
            }
        }

    }
    
     public void PreencheCombo() {
           
            for (Produto p : list) {
            
         
            comboProd.addItem(p.getDescricao());
           
            }
        

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LoteProdEst;
    private javax.swing.JTextField LoteQtd;
    private javax.swing.JTextField QtdAtual;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btElim;
    private javax.swing.JButton btNovo2;
    private javax.swing.JComboBox comboProd;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelRecebeFunc1;
    private javax.swing.JTextField lotePrec;
    private javax.swing.JTable tabLote;
    // End of variables declaration//GEN-END:variables

    
   
    
}
