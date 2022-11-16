/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author dcsv4
 */
public class ViewItems extends JPanel{
    public ViewItems(){
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
    }
    
    public void viewItemResults(ItemList inventory){
        for (int i = 0; i < inventory.getCount(); i++){
            int itemNum = inventory.getItem(i).getItemId();
            String itemName = inventory.getItem(i).getItemName();
            String itemDesc = inventory.getItem(i).getItemDescription();
            int itemPrice = inventory.getItem(i).getItemPrice();
            ItemPanel itemPanel = new ItemPanel(itemNum, itemName, itemDesc, itemPrice);
            add(itemPanel);
        }
        revalidate();
    }
}
