/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cart_mart_2;
// get info: resources/filename
// JSONReader read from file function
// cartmart2 read from file

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.ImageIcon;

/**
 *
 * @author drew
 */
public class AccountView extends javax.swing.JFrame {

    /**
     * Creates new form AccountView
     */
    public static String orderNumber;
    public static String orderDetails;

    /**
     * the function AccountView() will show the account view, in which it will
     * show all the past order histories, a way to start a new order, and
     * username and name of customer
     */
    public AccountView() {
        ImageIcon logo = new ImageIcon(Cart_Mart_2.class.getResource("images/cartLogo.png"));
        this.setIconImage(logo.getImage());
        this.setTitle("Cart Mart");
        initComponents();
        Cart_Mart_2.inAccount = true;
        Cart_Mart_2.inReceipt = false;
        Cart_Mart_2.inCart = false;
        String delimiter = ":";
        String currentLine;
        String data[];
        ViewItems itemPanel = new ViewItems();
        try {
            File input = new File("src/cart_mart_2/resources/" + User.userName + ".txt");
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(delimiter);
                orderNumber = data[0];
                orderDetails = data[1];
                itemPanel.viewItemResults(Item.inventory);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        viewPanel.setBackground(Color.GREEN);
        viewPanel.setViewportView(itemPanel);
        viewPanel.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoLabel = new javax.swing.JLabel();
        navPanel = new javax.swing.JPanel();
        logoLabel2 = new javax.swing.JLabel();
        page_title = new javax.swing.JLabel();
        Welcome_Page = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        name_display = new javax.swing.JTextArea();
        username_display = new javax.swing.JTextArea();
        not_logged_in_label = new javax.swing.JLabel();
        not_logged_in_button = new javax.swing.JButton();
        noAccount_label = new javax.swing.JLabel();
        createAccount_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewPanel = new javax.swing.JScrollPane();

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cart_mart_2/images/cartLogo100.png"))); // NOI18N
        logoLabel.setText("jLabel1");
        logoLabel.setMaximumSize(new java.awt.Dimension(100, 100));
        logoLabel.setMinimumSize(new java.awt.Dimension(100, 100));
        logoLabel.setPreferredSize(new java.awt.Dimension(100, 100));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        navPanel.setBackground(new java.awt.Color(255, 255, 255));
        navPanel.setLayout(null);

        logoLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cart_mart_2/images/cartLogo100.png"))); // NOI18N
        logoLabel2.setText("jLabel1");
        logoLabel2.setMaximumSize(new java.awt.Dimension(100, 100));
        logoLabel2.setMinimumSize(new java.awt.Dimension(100, 100));
        logoLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        navPanel.add(logoLabel2);
        logoLabel2.setBounds(0, 0, 100, 100);

        page_title.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 24)); // NOI18N
        page_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        page_title.setText("Account");
        navPanel.add(page_title);
        page_title.setBounds(110, 10, 270, 30);

        Welcome_Page.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        Welcome_Page.setText("Start New Order");
        Welcome_Page.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Welcome_Page.setMaximumSize(new java.awt.Dimension(130, 30));
        Welcome_Page.setMinimumSize(new java.awt.Dimension(130, 30));
        Welcome_Page.setPreferredSize(new java.awt.Dimension(130, 30));
        Welcome_Page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Welcome_PageActionPerformed(evt);
            }
        });
        navPanel.add(Welcome_Page);
        Welcome_Page.setBounds(470, 30, 160, 30);

        name_label.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        name_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name_label.setText("Name:");
        navPanel.add(name_label);
        name_label.setBounds(120, 40, 70, 14);

        username_label.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        username_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username_label.setText("Username:");
        navPanel.add(username_label);
        username_label.setBounds(120, 60, 70, 14);

        name_display.setColumns(20);
        name_display.setFont(new java.awt.Font("Franklin Gothic Demi", 3, 12)); // NOI18N
        name_display.setForeground(new java.awt.Color(153, 153, 153));
        name_display.setRows(5);
        name_display.setText(User.firstName);
        navPanel.add(name_display);
        name_display.setBounds(200, 40, 150, 15);

        username_display.setColumns(20);
        username_display.setFont(new java.awt.Font("Franklin Gothic Demi", 3, 12)); // NOI18N
        username_display.setForeground(new java.awt.Color(153, 153, 153));
        username_display.setRows(5);
        username_display.setText(User.userName);
        username_display.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                username_displayPropertyChange(evt);
            }
        });
        navPanel.add(username_display);
        username_display.setBounds(200, 60, 150, 14);

        not_logged_in_label.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        not_logged_in_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        not_logged_in_label.setText("Not logged in?");
        navPanel.add(not_logged_in_label);
        not_logged_in_label.setBounds(100, 90, 131, 14);

        not_logged_in_button.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        not_logged_in_button.setText("Log in");
        not_logged_in_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        not_logged_in_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                not_logged_in_buttonActionPerformed(evt);
            }
        });
        navPanel.add(not_logged_in_button);
        not_logged_in_button.setBounds(100, 110, 131, 22);

        noAccount_label.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 12)); // NOI18N
        noAccount_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noAccount_label.setText("Don't have account?");
        navPanel.add(noAccount_label);
        noAccount_label.setBounds(240, 90, 131, 14);

        createAccount_button.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 14)); // NOI18N
        createAccount_button.setText("Create Account");
        createAccount_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccount_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccount_buttonActionPerformed(evt);
            }
        });
        navPanel.add(createAccount_button);
        createAccount_button.setBounds(240, 110, 133, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewPanel)
                    .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(161, Short.MAX_VALUE))
                    .addComponent(viewPanel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAccount_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccount_buttonActionPerformed
        // TODO add your handling code here:
        Cart_Mart_2.changeView(4, 9);
    }//GEN-LAST:event_createAccount_buttonActionPerformed

    private void not_logged_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_not_logged_in_buttonActionPerformed
        // TODO add your handling code here:
        Cart_Mart_2.changeView(5, 9);
    }//GEN-LAST:event_not_logged_in_buttonActionPerformed

    private void username_displayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_username_displayPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_username_displayPropertyChange

    private void Welcome_PageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Welcome_PageActionPerformed
        // TODO add your handling code here:
        Cart_Mart_2.changeView(6, 9);
    }//GEN-LAST:event_Welcome_PageActionPerformed

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
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Welcome_Page;
    private javax.swing.JButton createAccount_button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoLabel2;
    private javax.swing.JTextArea name_display;
    private javax.swing.JLabel name_label;
    private javax.swing.JPanel navPanel;
    private javax.swing.JLabel noAccount_label;
    private javax.swing.JButton not_logged_in_button;
    private javax.swing.JLabel not_logged_in_label;
    private javax.swing.JLabel page_title;
    private javax.swing.JTextArea username_display;
    private javax.swing.JLabel username_label;
    private javax.swing.JScrollPane viewPanel;
    // End of variables declaration//GEN-END:variables
}
