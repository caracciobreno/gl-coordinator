package coordinator.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author bcaraccio
 */
public class MainDialog extends javax.swing.JDialog {

    /**
     * Map containing the points which were clicked.
     */
    private Map<Integer, Integer> pointsClicked;

    /**
     * Counter to aid on the printing algorithm.
     */
    private AtomicInteger counter;

    /**
     * The selected Config.
     */
    private static ConfigDialog.Configuration config;

    public MainDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    /**
     * Configures every f*ing thing.
     */
    private void init() {
        pointsClicked = new LinkedHashMap<>();
        counter = new AtomicInteger();

        panelCenter.addMouseListener(new MouseAdapter() {

            /**
             * {@inheritDoc}.
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();

                int x = (int) point.getX();
                int y = (int) point.getY();

                Graphics2D g2d = (Graphics2D) panelCenter.getGraphics();
                g2d.setColor(Color.BLACK);
                g2d.fillOval(x, y, 7, 7);

                pointsClicked.put(x, y);

                System.out.print("glVertex2i(" + x + ", " + Math.abs(y - 600) + "); ");

                if (counter.incrementAndGet() % config.getPrintingInterval() == 0) {
                    System.out.println();
                }
            }
        });

        addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}.
             */
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    fresh();
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {
                    System.out.println("");
                    System.out.println("// Separator");
                }
            }
        });

        setLocationRelativeTo(null);
        setTitle("OpenGL Coordinator - ESC reset the panel, S adds a separator comment");
        setResizable(false);

        // Initial printings
        System.out.println("glClear(GL_COLOR_BUFFER_BIT);");
        System.out.println("glColor3f(0.0, 0.0, 0.0);");
        System.out.println("glBegin(" + config.getShape() + ");");

        // LF
        System.out.println();
    }

    /**
     * Makes the UI fresh new.
     */
    private void fresh() {
        pointsClicked = new LinkedHashMap<>();
        counter = new AtomicInteger();

        panelCenter.setBackground(Color.WHITE);
        panelCenter.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCenter = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        panelCenter.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCenterLayout = new javax.swing.GroupLayout(panelCenter);
        panelCenter.setLayout(panelCenterLayout);
        panelCenterLayout.setHorizontalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelCenterLayout.setVerticalGroup(
            panelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                // First, get the desired configuration
                config = new ConfigDialog(new javax.swing.JFrame(), true)
                        .showConfigurationDialog();

                if (config == null) {
                    System.exit(1);
                }

                MainDialog dialog = new MainDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.out.println();
                        System.out.println("glEnd();");
                        System.out.println("glFlush();");
                        System.exit(0);
                    }
                });

                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelCenter;
    // End of variables declaration//GEN-END:variables

}
