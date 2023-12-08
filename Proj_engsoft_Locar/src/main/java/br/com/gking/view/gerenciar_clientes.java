/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.gking.view;

import br.com.gking.controller.database;
import br.com.gking.model.Cliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gking
 */
public class gerenciar_clientes extends javax.swing.JFrame {
    private static Cliente cliente;
    /**
     * Creates new form gerenciar_clientes
     * 
     * @param cliente
     */
    public gerenciar_clientes(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.cpfText.setText(Long.toString(cliente.getCpf()));
        this.nomeText.setText(cliente.getNome());
        this.telefoneText.setText(Long.toString(cliente.getTelefone()));
        this.emailText.setText(cliente.getEmail());
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
        jLabel1 = new javax.swing.JLabel();
        nomeText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpfText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefoneText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        editarBotao = new javax.swing.JButton();
        excluirBotao = new javax.swing.JToggleButton();
        salvarBotao = new javax.swing.JToggleButton();
        cadastrarBotao = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nome:");

        nomeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF:");

        cpfText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfTextActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefone:");

        telefoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTextActionPerformed(evt);
            }
        });

        jLabel4.setText("E-mail:");

        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });

        editarBotao.setText("Editar");
        editarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBotaoActionPerformed(evt);
            }
        });

        excluirBotao.setText("Excluir");
        excluirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBotaoActionPerformed(evt);
            }
        });

        salvarBotao.setText("Salvar");
        salvarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBotaoActionPerformed(evt);
            }
        });

        cadastrarBotao.setText("Cadastrar");
        cadastrarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfText, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(editarBotao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(excluirBotao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salvarBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastrarBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBotao)
                    .addComponent(excluirBotao)
                    .addComponent(salvarBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrarBotao)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nomeTextActionPerformed

    private void cpfTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfTextActionPerformed

    private void telefoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneTextActionPerformed

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextActionPerformed

    private void excluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBotaoActionPerformed
        var deletarSucesso = database.deletarCliente(cliente.getCpf());
        if(!deletarSucesso){
            JOptionPane.showMessageDialog(rootPane, "Cliente deletado!");
            var telaInicialScreen = new tela_inicial();
            
            telaInicialScreen.show();
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao deletar cliente!");
        }
    }//GEN-LAST:event_excluirBotaoActionPerformed

    private void salvarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBotaoActionPerformed
        try {
            cliente.setCpf(Long.parseLong(cpfText.getText()));
            cliente.setNome(nomeText.getText());
            cliente.setTelefone(Long.parseLong(telefoneText.getText()));
            cliente.setEmail(emailText.getText());
            
            var atualizarSucesso = database.atualizarCliente(cliente.getCpf(), cliente);
            
            if(!atualizarSucesso){
                JOptionPane.showMessageDialog(rootPane, "Cliente atualizado!");
                modoConsulta();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro ao deletar cliente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gerenciar_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarBotaoActionPerformed

    private void editarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBotaoActionPerformed
        // TODO add your handling code here:
        modoEdicao();
    }//GEN-LAST:event_editarBotaoActionPerformed

    private void cadastrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBotaoActionPerformed
        try {
            cliente.setCpf(Long.parseLong(cpfText.getText()));
            cliente.setNome(nomeText.getText());
            cliente.setTelefone(Long.parseLong(telefoneText.getText()));
            cliente.setEmail(emailText.getText());
            
            var cadastroSucesso = database.cadastrarCliente(cliente);
            
            if(!cadastroSucesso){
                JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado!");
                modoConsulta();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar cliente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gerenciar_clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cadastrarBotaoActionPerformed

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
            java.util.logging.Logger.getLogger(gerenciar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gerenciar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gerenciar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gerenciar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new gerenciar_clientes(cliente).setVisible(true);
        });
    }
    
    public void modoConsulta(){
        cpfText.setEnabled(false);
        nomeText.setEnabled(false);
        telefoneText.setEnabled(false);
        emailText.setEnabled(false);

        excluirBotao.setVisible(false);
        editarBotao.setVisible(true);
        salvarBotao.setVisible(false);
        cadastrarBotao.setVisible(false);
    }
    
    public void modoCadastro(){
        cpfText.setEnabled(false);
        nomeText.setEnabled(true);
        telefoneText.setEnabled(true);
        emailText.setEnabled(true);
        
        excluirBotao.setVisible(false);
        editarBotao.setVisible(false);
        salvarBotao.setVisible(false);
        cadastrarBotao.setVisible(true);
        
        telefoneText.setText("");
    }
    
    public void modoEdicao(){
        cpfText.setEnabled(false);
        nomeText.setEnabled(true);
        telefoneText.setEnabled(true);
        emailText.setEnabled(true);
        
        excluirBotao.setVisible(true);
        editarBotao.setVisible(false);
        salvarBotao.setVisible(true);
        cadastrarBotao.setVisible(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton cadastrarBotao;
    private javax.swing.JTextField cpfText;
    private javax.swing.JButton editarBotao;
    private javax.swing.JTextField emailText;
    private javax.swing.JToggleButton excluirBotao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomeText;
    private javax.swing.JToggleButton salvarBotao;
    private javax.swing.JTextField telefoneText;
    // End of variables declaration//GEN-END:variables

}
