/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cart_mart_2;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Cart Mart main
 *
 * @author david
 */
public class Cart_Mart_2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        final String file = "src/cart_mart_2/resources/inventoryList.json";
        //url for the database
        //final String url = "https://api.jsonbin.io/v3/b/63406cdf2b3499323bd6971c";
        //create a string from the depository
        //var json = JsonReader.readJsonFromUrl(url);
        //create a string from a file - if we go that route        
        var json = JsonReader.readJsonFromFile(file);
        //the replaceAll function call is needed to remove whitespaces from the string
        json = json.replaceAll("\\s+", " ");
        //System.out.println(json);
        //json = json.replace("\n", "");
        //generate the array of items from the database
        ItemList inventory = new ItemList(json);
        Item.inventory = inventory;
        //inventory.getItem(2).decreaseQty(3);

        /*
        MainGUIFrame frame = new MainGUIFrame(inventory);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
         */
        //loginView frame = new loginView();
        MainGUIFrame frame = new MainGUIFrame();
        //JFrame frame = new JFrame();
        //ViewItems itemPanel = new ViewItems();
        //itemPanel.viewItemResults(inventory);
        //JScrollPane scrPane = new JScrollPane(itemPanel);
        //loginView frame = new loginView();
        //frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //frame.getContentPane().setBackground(Color.black);
        //frame.add(scrPane);
        //itemPanel.setVisible(true);
        frame.setVisible(true);
        //for sorting/filtering
        //constructor for sorting InventorySort(<ItemList>,<int>).list
        //constructor for filtering InventorySort(<ItemList>,<int>,"<String>").list
        //codes for <int>: 1: name, 2: category, 3: price
        //filtering <String>: "<category name>(is case sensitive)", "<search name>(not case sensitive)"

        //USE THIS TEMPLATE FOR FILTERING
        //ItemList newList = new InventorySort(inventory,1,"er").filteredList;
        //USE THIS TEMPLATE FOR SORTING
        //ItemList newList1 = new InventorySort(inventory,3).list;
        //saveList() will update the list on the server and print it to the screen 
        //newList.saveList();
        //inventory.saveList();
        //Item testItem = newList.getItem(1);
        //System.out.println(User.getLine());
    }
}
