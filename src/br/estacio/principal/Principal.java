package br.estacio.principal;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Principal extends javax.swing.JFrame {

    private ArrayList<CwTarefa> lstTarefas;
    private DefaultTableModel model;
    
    public Principal() {
        initComponents();
        customInit();
        model = prepararTabela();
        atualizarTabela();
    }

    private void customInit(){
        jbIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("../icones/salvar.png")));
        jlTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ToDo List");
        setLocationRelativeTo(null);
        lstTarefas = new ArrayList<CwTarefa>();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jtDescricaoItem = new javax.swing.JTextField();
        jbIncluir = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPrincipal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jlTitulo.setFont(new java.awt.Font("SimSun-ExtB", 2, 24)); // NOI18N
        jlTitulo.setText("ToDo List");
        jlTitulo.setToolTipText("");

        jbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIncluirActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir selecionados");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jtPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "Tarefa", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPrincipal);
        if (jtPrincipal.getColumnModel().getColumnCount() > 0) {
            jtPrincipal.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jbExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jtDescricaoItem)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jbIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtDescricaoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIncluirActionPerformed
        String item = jtDescricaoItem.getText();
        if (item.length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Insira um texto para a tarefa!");
        } else {
            CwTarefa cwTarefa = new CwTarefa();
            cwTarefa.setsDsTarefa(item);
            cwTarefa.setnCdTarefa(lstTarefas);
            lstTarefas.add(cwTarefa);
        }
        atualizarTabela();
    }//GEN-LAST:event_jbIncluirActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Object[] selecionados = new Object[3];

        for (int i = 0; i < 3; i++) {
            if ((boolean)jtPrincipal.getModel().getValueAt(i, 1) == true){
                //atualizar isto
                lstTarefas.remove((int)jtPrincipal.getModel().getValueAt(i, 0));
            }
        }
        atualizarTabela();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void atualizarTabela(){
        model.setRowCount(0);
        for (CwTarefa cwTarefaloop : lstTarefas) {
            model.addRow(new Object[]{cwTarefaloop.getnCdTarefa(), false, cwTarefaloop.getsDsTarefa(), "xxx"});
        }
    }
    
    private DefaultTableModel prepararTabela(){
        DefaultTableModel model = (DefaultTableModel) jtPrincipal.getModel();
        jtPrincipal.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtPrincipal.getColumnModel().getColumn(1).setPreferredWidth(10);
        jtPrincipal.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtPrincipal.getColumnModel().getColumn(3).setPreferredWidth(10);
        
        TableColumnModel tcm = jtPrincipal.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        
        return model;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbIncluir;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtDescricaoItem;
    private javax.swing.JTable jtPrincipal;
    // End of variables declaration//GEN-END:variables
}
