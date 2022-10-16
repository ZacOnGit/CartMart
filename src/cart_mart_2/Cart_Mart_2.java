/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cart_mart_2;




/**
 * Test
 * @author dcsv4
 */
public class Cart_Mart_2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //url for the database
        final String url = "https://api.jsonbin.io/v3/b/63406cdf2b3499323bd6971c";
        //create a string from the depository
        var json = JsonReader.readJsonFromUrl(url);
        //get the total number of items in the repository
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1){
            lastIndex = json.indexOf("itemID",lastIndex);
            if (lastIndex != -1){
                count++;
                lastIndex += 1;            
            }
        }
        //generate the array of items from the database
        var inventory = new ItemList(json,count);
        //inventory.getItem(2).decreaseQty(3);
        //inventory.saveList();   
        //System.out.println(json);
        
        
        //for sorting/filtering
        //constructor for sorting InventorySort(<ItemList>,<int>).list
        //constructor for filtering InventorySort(<ItemList>,<int>,"<String>").list
        //codes for <int>: 1: name, 2: category, 3: price
        //filtering <String>: "<category name>(is case sensitive)", "<search name>(not case sensitive)"
        ItemList newList = new InventorySort(inventory,1,"a").filteredList;
        
        //saveList() will update the list on the server and print it to the screen 
        //System.out.println(newList.getCount());
        newList.saveList();
        
        
    }
    
}
