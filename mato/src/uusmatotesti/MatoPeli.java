/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uusmatotesti;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author H3173
 */
public class MatoPeli extends javax.swing.JFrame {

    näyttö näyttö = new näyttö();
    private javax.swing.JButton AloitaNappi;
    private javax.swing.JButton HallOfFameNappi;
    private javax.swing.JButton LopetaNappi;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private JLabel label = new JLabel();
    private javax.swing.JLabel jLabel1;
    

    /**
     * Creates new form KorttiTesti
     */
    public MatoPeli() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);

        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
        requestFocusInWindow();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37) {
                    näyttö.siirräSuunta("vasen");
                }
                if (e.getKeyCode() == 38) {
                    System.out.println("TESTISEITSIETISETISIETSIS");
                    näyttö.siirräSuunta("ylos");
                }
                if (e.getKeyCode() == 39) {
                    näyttö.siirräSuunta("oikea");
                }
                if (e.getKeyCode() == 40) {
                    näyttö.siirräSuunta("alas");
                }
                if (e.getKeyCode() == 82) {
                    näyttö.UusiPeli();

                }
                if (e.getKeyCode() == 114) {
                    näyttö.UusiPeli();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        AloitaNappi = new javax.swing.JButton();
        LopetaNappi = new javax.swing.JButton();
        HallOfFameNappi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();       

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(706, 568));

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(700, 540));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AloitaNappi.setText("Aloita peli");
        AloitaNappi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AloitaNappiActionPerformed(evt);
            }
        });
        
        jPanel6.add(AloitaNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        LopetaNappi.setText("Lopeta peli");
        LopetaNappi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LopetaNappiActionPerformed(evt);
            }
        });
        
        jPanel6.add(LopetaNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        HallOfFameNappi.setText("Hall of Fame");
        HallOfFameNappi.setName(""); // NOI18N
        
        jPanel6.add(HallOfFameNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uusmatotesti/background.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.add(jPanel6, "card3");

        jPanel4.setName("Peli_Ikkuna"); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 540));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
//                .addContainerGap()
                .addComponent(näyttö, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
//                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(näyttö, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        jPanel3.add(jPanel4, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void AloitaNappiActionPerformed(java.awt.event.ActionEvent evt) {

        näyttö.Aloita();
        CardLayout cl = (CardLayout) (jPanel3.getLayout());
        cl.next(jPanel3);
    }

    private void LopetaNappiActionPerformed(java.awt.event.ActionEvent evt) {

        System.exit(1);
    }

    public static void main(String args[]) {

        MatoPeli matopeli = new MatoPeli();



//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KorttiTesti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KorttiTesti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KorttiTesti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KorttiTesti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//   
//
//
//     

    }
}
