
package com.mycompany.etapa2.visao;

import com.mycompany.etapa2.controle.UsuarioDaoBanco;
import com.mycompany.etapa2.excecoes.CadastroException;
import com.mycompany.etapa2.excecoes.EmailException;
import com.mycompany.etapa2.modelo.Movimentacao;
import com.mycompany.etapa2.modelo.Usuario;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Tela do gerenciador de movimentações, onde o usuário pode alterar uma movimentação
 * existente, visualizar as movimentações presentes dentro de um intervalo de tempo 
 * e exibir um gráfico demonstrando a diferença dos valores para cada categoria.
 * @author Flavio
 */
public class Gerenciador extends javax.swing.JFrame {


    private Usuario atual;
    private UsuarioDaoBanco dao;
    private DefaultTableModel table;

    /**
     * Construtor de Gerenciador
     */
    public Gerenciador() {
        try {
            dao = new UsuarioDaoBanco();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se");

        } catch (SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocation(500, 110);
        this.setIconImage(new ImageIcon("icone.jpg").getImage());

        initComponents();
        table = (DefaultTableModel) tabela.getModel();
    }

    /**
     * Determina qual é o usuário logado no sistema.
     * @param u O usuário que está logado.
     */
    public void setUsuario(Usuario u) {
        atual = u;
    }
    
    /**
     * Determina quem é o usuário atual
     * @return retorna o usuário atual do sistema.
     */
    private Usuario getUsuario() {
        return this.atual;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dataInicial = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        btCalcular = new javax.swing.JButton();
        btGrafico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciador de finanças");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        try {
            dataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btCalcular.setBackground(new java.awt.Color(51, 102, 0));
        btCalcular.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        btGrafico.setBackground(new java.awt.Color(51, 102, 0));
        btGrafico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGrafico.setForeground(new java.awt.Color(255, 255, 255));
        btGrafico.setText("Gráfico");
        btGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGraficoActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Tipo", "Categoria", "Valor", "Data"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Data inicial");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Data final");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                                .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCalcular)
                                .addGap(73, 73, 73)
                                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btGrafico)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCalcular))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btGrafico)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Atualiza o usuário com suas movimentações e abre uma nova tela Inicial.
     * @param evt Clique do mouse no 'X' 
     */
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        try {
            dao.atualizar(atual);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        } catch (EmailException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (CadastroException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inicial inicial = new Inicial();
        inicial.setVisible(true);
        inicial.setUsuario(this.getUsuario());
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked
    /**
     * Calcula quais movimentações o usuário realizou naquele intervalo de datas.
     * @param evt Clique do mouse no botão Calcular.
     */
    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        List<Movimentacao> movs = atual.getMovimentacoes();
        if (movs.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma movimentação!");
        } else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataf = dataFinal.getText();
                LocalDate dFinal = LocalDate.parse(dataf, formatter);
                String datai = dataInicial.getText();
                LocalDate dInicial = LocalDate.parse(datai, formatter);
                while (table.getRowCount() > 0) {
                    table.removeRow(0);
                }
                for (Movimentacao m : movs) {
                    if (m.getData().compareTo(dInicial) >= 0 && m.getData().compareTo(dFinal) <= 0) {
                        Object[] array = new Object[]{m.getDescricao(), m.getTipo(),
                            m.getCategoria(), m.getValor(), m.getData().format(formatter)};
                        table.addRow(array);
                    }
                }
                dataInicial.setText("");
                dataFinal.setText("");
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Preencha corretamente as datas!");
            }
        }
    }//GEN-LAST:event_btCalcularActionPerformed
    /**
     * Permite que o usuário altere a movimentação selecionada.
     * @param evt Clique do mouse sobre uma movimentação na tabela.
     */
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        CadastroMov cad = new CadastroMov();
        cad.setVisible(true);
        cad.setUsuario(atual);
        String descricao = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
        String tipo = (String) tabela.getValueAt(tabela.getSelectedRow(), 1);
        String categoria = (String) tabela.getValueAt(tabela.getSelectedRow(), 2);
        float valor = (float) tabela.getValueAt(tabela.getSelectedRow(), 3);
        String data = (String) tabela.getValueAt(tabela.getSelectedRow(), 4);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        Movimentacao m = new Movimentacao(descricao, categoria, valor, tipo, 
                date, atual.getEmail());
        cad.setMov(m, "Alterar movimentação");
        cad.setAnterior(2);
        dispose();
    }//GEN-LAST:event_tabelaMouseClicked
    /**
     * Demonstra um gráfico com a diferença de valores de cada categoria das 
     * movimentações do usuário.
     * @param evt Clique do mouse no botão Gráfico.
     */
    private void btGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGraficoActionPerformed

        String[] opcoes = {"Entrada", "Saída"};
        String opcao = (String) JOptionPane.showInputDialog(null, "Selecione o "
                + "tipo de gráfico que você deseja:", "Tipo de gráfico", HEIGHT, null,
                opcoes, DISPOSE_ON_CLOSE);
        DefaultCategoryDataset dt = new DefaultCategoryDataset();

        float pessoal = 0;
        float cartao = 0;
        float despesa = 0;
        float alimentacao = 0;
        float outros = 0;
        float saude = 0;

        for (int k = 0; k < table.getRowCount(); k++) {
            if (table.getValueAt(k, 1).equals(opcao)) {
                switch ((String) table.getValueAt(k, 2)) {
                    case "Pessoal": {
                        pessoal = pessoal + (float) table.getValueAt(k, 3);
                        break;
                    }
                    case "Outros": {
                        outros = outros + (float) table.getValueAt(k, 3);
                        break;
                    }
                    case "Alimentação": {
                        alimentacao = alimentacao + (float) table.getValueAt(k, 3);
                        break;
                    }
                    case "Cartão de crédito": {
                        cartao = cartao + (float) table.getValueAt(k, 3);
                        break;
                    }
                    case "Despesa doméstica": {
                        despesa = despesa + (float) table.getValueAt(k, 3);
                        break;
                    }
                    case "Saúde": {
                        saude = saude + (float) table.getValueAt(k, 3);
                        break;
                    }
                }
            }
        }
        dt.setValue(cartao, "x", "Cartão de crédito");
        dt.setValue(pessoal, "x", "Pessoal");
        dt.setValue(alimentacao, "x", "Alimentação");
        dt.setValue(despesa, "x", "Despesa doméstica");
        dt.setValue(saude, "x", "Saúde");
        dt.setValue(outros, "x", "Outros");

        JFreeChart grafico = ChartFactory.createBarChart3D("Gráfico", "categorias",
                "valores", dt, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot plot = grafico.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setOutlinePaint(Color.black);

        for (int k = 0; k < 6; k++) {
            plot.getRenderer().setSeriesPaint(k, Color.GREEN);
        }

        ChartPanel panGrafico = new ChartPanel(grafico);

        JFrame frame = new JFrame();
        frame.add(panGrafico);
        frame.pack();
        frame.setTitle("Gráfico ");
        frame.setIconImage(new ImageIcon("icone.jpg").getImage());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btGraficoActionPerformed

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
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerenciador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcular;
    private javax.swing.JButton btGrafico;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}