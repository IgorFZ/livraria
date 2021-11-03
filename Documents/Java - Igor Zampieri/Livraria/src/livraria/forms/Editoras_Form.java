package livraria.forms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import livraria.BancoMysql;
import livraria.classes.editoras;
import livraria.DAO.editorasDAO;

public class Editoras_Form extends javax.swing.JFrame {

    public Editoras_Form() {
        
        initComponents();
        carregaDados();
        
        // center the form
        this.setLocationRelativeTo(null);
    }
    
    
    public void carregaDados() {
        
        DefaultTableModel tabela = (DefaultTableModel) jTable_Editoras.getModel();
        editorasDAO dao = new editorasDAO();
        tabela.setNumRows(0);
        
        for (editoras a: dao.listar()) {
            tabela.addRow(new Object[]{
                a.getId(),
                a.getNome()
            });    
        }
    }

    public void pesquisaDados() {
        
        DefaultTableModel tabela = (DefaultTableModel) jTable_Editoras.getModel();
        editorasDAO dao = new editorasDAO();
        tabela.setNumRows(0);
        
        for (editoras a: dao.pesquisar((jTextField_Pesquisa.getText()))) {
            tabela.addRow(new Object[]{
                a.getId(),
                a.getNome()
            });    
        }
    }
    
    public void alteraNoBanco() throws SQLException{
        
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        DefaultTableModel tabela = (DefaultTableModel) jTable_Editoras.getModel();
        
       
        try{
            
            String contSql = "SELECT * FROM editoras";
            String sql = "UPDATE editoras SET id_editora = ?, nome = ?";
            
            stmt = conn.prepareStatement(sql); 
            stmt = conn.prepareStatement(contSql);
          
            int numeroChamados = 0;
            
            while(rs.next()){
                numeroChamados = rs.getInt("id_editora");
            }
          
            int linha=0;
            for (linha = 0; linha < numeroChamados; linha++) {
                //ps.setObject(1, tabela.getValueAt(linha, 1));
                //ps.setObject(2, tabela.getValueAt(linha, 2));
                //ps.executeUpdate();         
            }
            
            JOptionPane.showMessageDialog(null, "Registro alterado");
        } finally {
            conn.close();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Codigo = new javax.swing.JTextField();
        jTextField_Nome = new javax.swing.JTextField();
        jButton_Cadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Editoras = new javax.swing.JTable();
        jButton_Excluir = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jToggleButton_Pesquisar = new javax.swing.JToggleButton();
        jTextField_Pesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro Editoras"));

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jTextField_Codigo.setEditable(false);
        jTextField_Codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_Codigo.setEnabled(false);
        jTextField_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CodigoActionPerformed(evt);
            }
        });

        jTextField_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NomeActionPerformed(evt);
            }
        });

        jButton_Cadastrar.setText("Cadastrar");
        jButton_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastrarActionPerformed(evt);
            }
        });

        jTable_Editoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome da Editora"
            }
        ));
        jTable_Editoras.setColumnSelectionAllowed(true);
        jTable_Editoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_EditorasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Editoras);
        jTable_Editoras.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton_Excluir.setText("Excluir");
        jButton_Excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ExcluirMouseClicked(evt);
            }
        });
        jButton_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcluirActionPerformed(evt);
            }
        });

        jButton_Alterar.setText("Alterar");
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });

        jToggleButton_Pesquisar.setText("Pesquisar");
        jToggleButton_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_PesquisarActionPerformed(evt);
            }
        });

        jTextField_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Cadastrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jTextField_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton_Pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Excluir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton_Pesquisar)
                    .addComponent(jTextField_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Excluir)
                    .addComponent(jButton_Alterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NomeActionPerformed

    private void jButton_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastrarActionPerformed
        editoras e = new editoras();
        editorasDAO DAO = new editorasDAO();
        
        e.setNome(jTextField_Nome.getText());
        DAO.cadastrar(e);
        
        carregaDados();
    }//GEN-LAST:event_jButton_CadastrarActionPerformed

    private void jTextField_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CodigoActionPerformed

    private void jButton_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcluirActionPerformed
        editoras e = new editoras();
        editorasDAO DAO = new editorasDAO();
        
        e.setId(Integer.parseInt(jTextField_Codigo.getText()));
        DAO.excluir(e);
        
        carregaDados();
    }//GEN-LAST:event_jButton_ExcluirActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        editoras e = new editoras();
        editorasDAO DAO = new editorasDAO();
        
        e.setId(Integer.parseInt(jTextField_Codigo.getText()));
        e.setNome(jTextField_Nome.getText());
        DAO.alterar(e);
        
        carregaDados();
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_ExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ExcluirMouseClicked
       
    }//GEN-LAST:event_jButton_ExcluirMouseClicked

    private void jTable_EditorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_EditorasMouseClicked
        jTextField_Codigo.setText(jTable_Editoras.getValueAt(jTable_Editoras.getSelectedRow(), 0).toString());
        jTextField_Nome.setText(jTable_Editoras.getValueAt(jTable_Editoras.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTable_EditorasMouseClicked

    private void jToggleButton_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_PesquisarActionPerformed
        pesquisaDados();
    }//GEN-LAST:event_jToggleButton_PesquisarActionPerformed

    private void jTextField_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PesquisaActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editoras_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editoras_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Cadastrar;
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Editoras;
    private javax.swing.JTextField jTextField_Codigo;
    private javax.swing.JTextField jTextField_Nome;
    private javax.swing.JTextField jTextField_Pesquisa;
    private javax.swing.JToggleButton jToggleButton_Pesquisar;
    // End of variables declaration//GEN-END:variables
}