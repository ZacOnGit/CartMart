/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dcsv4
 */
public class ItemPanel extends JPanel{
    public ItemPanel(int itemNum, String itemName, String itemDesc, int itemPrice){
        JLabel image = new javax.swing.JLabel();
        JLabel name = new javax.swing.JLabel();
        JLabel description = new javax.swing.JLabel();
        JLabel price = new javax.swing.JLabel();
        JTextField quantity = new javax.swing.JTextField();
        JButton incButton = new javax.swing.JButton();
        JButton decButton = new javax.swing.JButton();
        JButton addToCart = new javax.swing.JButton();
        
        try{
            ImageIcon pic = new ImageIcon(Cart_Mart_2.class.getResource("images/"+String.valueOf(itemNum)+".jpg"));
            image.setIcon(pic);
        }
        catch (Exception e){
            ImageIcon pic = new ImageIcon(Cart_Mart_2.class.getResource("images/missing.jpg"));
            image.setIcon(pic);
        }
        image.setText("");
        image.setMaximumSize(new java.awt.Dimension(100, 100));
        image.setMinimumSize(new java.awt.Dimension(100, 100));
        image.setPreferredSize(new java.awt.Dimension(100, 100));
        
        name.setText(itemName);
        name.setMaximumSize(new java.awt.Dimension(160, 20));
        name.setMinimumSize(new java.awt.Dimension(160, 20));
        name.setPreferredSize(new java.awt.Dimension(160, 20));
        name.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        
        description.setText(itemDesc);
        description.setMaximumSize(new java.awt.Dimension(160, 20));
        description.setMinimumSize(new java.awt.Dimension(160, 20));
        description.setPreferredSize(new java.awt.Dimension(160, 20));
        description.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        price.setText("$"+String.format("%.2f", (float)itemPrice/100.0));
        quantity.setText("0");
        incButton.setText("+");
        decButton.setText("-");
        addToCart.setText("ADD");
        
        incButton.setPreferredSize(new java.awt.Dimension(41, 30));
        decButton.setPreferredSize(new java.awt.Dimension(41, 30));
        addToCart.setPreferredSize(new java.awt.Dimension(60, 30));
        quantity.setPreferredSize(new java.awt.Dimension(50, 30));
        quantity.setHorizontalAlignment(JTextField.CENTER);
        quantity.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        price.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18));
        
        incButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantity.setText(String.valueOf(incButtonMouseClicked(evt, Integer.valueOf(quantity.getText()))));
            }
        });
        decButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantity.setText(String.valueOf(decButtonMouseClicked(evt, Integer.valueOf(quantity.getText()))));
            }
        });
        
        javax.swing.GroupLayout itemPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(itemPanelLayout);
        itemPanelLayout.setHorizontalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(217, 217, 217))
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(incButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        itemPanelLayout.setVerticalGroup(
            itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(itemPanelLayout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(itemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(incButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(decButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        ); 
        
        
    }
    
    private int incButtonMouseClicked(java.awt.event.MouseEvent evt, int num){
        num++;
        return num;            
    }
    
    private int decButtonMouseClicked(java.awt.event.MouseEvent evt, int num){
        if (num == 0)
            return num;
        num--;
        return num;
    }
}
