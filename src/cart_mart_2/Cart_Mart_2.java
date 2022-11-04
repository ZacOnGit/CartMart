/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cart_mart_2;

import java.awt.Color;


/**
 * Cart Mart main
 * @author david
 */
public class Cart_Mart_2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        
        final String file = "inventoryList.json";
        //url for the database
        final String url = "https://api.jsonbin.io/v3/b/63406cdf2b3499323bd6971c";
        //create a string from the depository
        //var json = JsonReader.readJsonFromUrl(url);
        //create a string from a file - if we go that route        
        var json = JsonReader.readJsonFromFile(file);
        //the replaceAll function call is needed to remove whitespaces from the string
        json = json.replaceAll("\\s+", "");
        //generate the array of items from the database
        ItemList inventory = new ItemList(json);
        //inventory.getItem(2).decreaseQty(3);
        MainGUIFrame frame = new MainGUIFrame(inventory);
        frame.getContentPane().setBackground(Color.black);
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
        //Item testItem = newList.getItem(1);
    }
}
