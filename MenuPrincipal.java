package jogodavelha2.pkg0;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
/**
 * Projeto jogo da velha.
 * @author Leonardo Pereira Alves.
 * @version 2.0 26/06/2015 - 27/06/2015
 */
public class MenuPrincipal extends JFrame {
    private final Interface velha;

    public MenuPrincipal(Interface inter) {
        super("Menu Principal Jogo Da Velha - 2.0 ");
        setResizable(false);
        setBounds(500,150,400,400);
        setVisible(true);
        setResizable(false);
        velha = inter;
        velha.setVisible(false);
        velha.setResizable(false);
        velha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Definido icone do programa
        URL url = this.getClass().getResource("logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        MenuPanel = new javax.swing.JPanel();
        jbVsMaquina = new javax.swing.JButton();
        meuLabel = new javax.swing.JLabel();
        jbSair = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuPanel.setBackground(new Color(128,255,0));

        jbVsMaquina.setText("Iniciar");
        jbVsMaquina.setBackground(Color.white);
        jbVsMaquina.setForeground(new Color(0,172,255));
        jbVsMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVsMaquinaActionPerformed(evt);
            }
        });

        meuLabel.setText("Jogo da Velha:");

        jbSair.setBackground(Color.white);
        jbSair.setForeground(new Color(255,0,0));
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(meuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVsMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(meuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbVsMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVsMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVsMaquinaActionPerformed

        velha.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jbVsMaquinaActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jbSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbVsMaquina;
    private javax.swing.JLabel meuLabel;
    // End of variables declaration//GEN-END:variables
}
