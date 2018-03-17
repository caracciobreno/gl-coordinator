package coordinator.ui;

import javax.swing.JOptionPane;

/**
 * @author bcaraccio
 */
public class ConfigDialog extends javax.swing.JDialog {

  /**
   * Selected config.
   */
  private Configuration config;

  public ConfigDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    init();
  }

  /**
   * Init the f* up.
   */
  private void init() {
    buttonConfirm.addActionListener((e) -> confirm());

    setLocationRelativeTo(null);

    setTitle("Configuration");
    setResizable(false);
  }

  /**
   * Confirm action.
   */
  private void confirm() {
    if (numberInterval.getText() == null || numberInterval.getText().trim().length() == 0
        || !numberInterval.getText().matches("[0-9]+")) {

      JOptionPane.showMessageDialog(this,
          "Fill a valid interval to print the OpenGL instructions (> 0)", "Error",
          JOptionPane.WARNING_MESSAGE);

      return;
    }

    config = new Configuration();
    config.setPrintingInterval(Integer.valueOf(numberInterval.getText()));
    config.setShape((String) comboShape.getSelectedItem());

    dispose();
  }

  /**
   * Shows the Configuration Dialog.
   *
   * @return
   *   The selected config.
   */
  public Configuration showConfigurationDialog() {
    setVisible(true);

    return config;
  }

  /**
   * Defines a Configuration.
   */
  public static class Configuration {

    /**
     * Selected Printing Interval.
     */
    private int printingInterval;

    /**
     * Selected Shape.
     */
    private String shape;

    public int getPrintingInterval() {
      return printingInterval;
    }

    public void setPrintingInterval(int printingInterval) {
      this.printingInterval = printingInterval;
    }

    public String getShape() {
      return shape;
    }

    public void setShape(String shape) {
      this.shape = shape;
    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    comboShape = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    numberInterval = new javax.swing.JTextField();
    buttonConfirm = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setText("Shape");

    comboShape.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GL_POINTS", "GL_LINES", "GL_TRIANGLES", "GL_QUADS", "GL_POLYGON" }));

    jLabel2.setText("Print Interval");

    numberInterval.setText("2");

    buttonConfirm.setText("Confirm");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(buttonConfirm)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel2)
              .addComponent(jLabel1))
            .addGap(38, 38, 38)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(comboShape, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(numberInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(18, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(comboShape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(numberInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(buttonConfirm)
        .addContainerGap(14, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonConfirm;
  private javax.swing.JComboBox<String> comboShape;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JTextField numberInterval;
  // End of variables declaration//GEN-END:variables
}
