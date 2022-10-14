/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dcsv4
 */
public class ItemList {
    // future changes: make list length variable
    private final Item[] item;
    private final int invCount;
    
    ItemList(int numItems){
        item = new Item[numItems];
        invCount = numItems;
    }
    ItemList(String json, int numItems){
        item = new Item[numItems];
        invCount = numItems;
        createList(json);
    }

    //SETTER
    public void setItem(Item newItem, int index){
        //int temp = item.length;
        item[index] = newItem;
    }
    //GETTER
    public int getCount(){
        return this.invCount;
    }
    public Item getItem(int value){
        int temp = item.length;
        if (value < 0 || value > temp)
            return null;
        else
            return item[value];
    }
    private void createList(String json){
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1){
            lastIndex = json.indexOf("itemID",lastIndex);
            if (lastIndex != -1){
                String id = "";
                String name = "";
                String category = "";
                String price = "";
                String qty = "";
                String desc = "";
                int temp = lastIndex+8;
                char c = json.charAt(temp);
                while (c != ','){
                    
                    id = id + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemName",lastIndex);
                temp = lastIndex+11;
                c = json.charAt(temp);
                while (c != '"'){
                    
                    name = name + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemCategory",lastIndex);
                temp = lastIndex+15;
                c = json.charAt(temp);
                while (c != '"'){
                    
                    category = category + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemPrice",lastIndex);
                temp = lastIndex+11;
                c = json.charAt(temp);
                while (c != ','){
                    
                    price = price + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemQty",lastIndex);
                temp = lastIndex+9;
                c = json.charAt(temp);
                while (c != ','){
                    
                    qty = qty + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemDesc",lastIndex);
                temp = lastIndex+11;
                c = json.charAt(temp);
                while (c != '"'){
                    
                    desc = desc + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }                
                //System.out.println(desc);
                lastIndex += "itemDesc".length();
                //System.out.println(count);
                Item newItem = new Item(Integer.valueOf(id), name, category,Integer.valueOf(price), Integer.valueOf(qty), desc);
                item[count] = newItem;
                count++;
            }   
        }
    }
    
    public void saveList() throws MalformedURLException, IOException{
        String inventoryString = "{\"record\":[{\"";
        for (int i = 0; i < invCount; i++){
            //System.out.println(i);
            inventoryString = inventoryString + "itemID\":";
            inventoryString = inventoryString + item[i].getItemId();
            inventoryString = inventoryString + ",\"itemName\":\"";
            inventoryString = inventoryString + item[i].getItemName();
            inventoryString = inventoryString + "\",\"itemCategory\":\"";
            inventoryString = inventoryString + item[i].getItemCategory();
            inventoryString = inventoryString + "\",\"itemPrice\":";
            inventoryString = inventoryString + item[i].getItemPrice();
            inventoryString = inventoryString + ",\"itemQty\":";
            inventoryString = inventoryString + item[i].getItemQuantity();
            inventoryString = inventoryString + ",\"itemDesc\":\"";
            inventoryString = inventoryString + item[i].getItemDescription();
            inventoryString = inventoryString + "\",\"itemImage\":";
            inventoryString = inventoryString + item[i].getItemId();
            if (i == invCount - 1){
                inventoryString = inventoryString + "}],\"metadata\":\n";
                inventoryString = inventoryString + "{\"id\":\"63406cdf2b3499323bd6971c\",\"private\":false,\"createdAt\":";
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
                String formattedDate = time.format(formatTime);
                inventoryString = inventoryString + "\"" + formattedDate + "\"}}";
            }
            else
                inventoryString = inventoryString + "},\n";            
        }
        //https://jsonkeeper.com/b/WG83
        URL url = new URL("https://api.jsonbin.io/v3/b/63406cdf2b3499323bd6971c");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        
        
        
        httpCon.setRequestMethod("PUT");
        httpCon.setRequestProperty("Content-Type", "application/json");
        httpCon.setRequestProperty("Accept","application/json");
        httpCon.setRequestProperty("X-Master-Key", "$2b$10$znh4cRlANS3MjSaIkS5yjOER6G1SdDjc845mvuEOBj/uakWSTFBFG");
        //httpCon.setDoInput(true);
        httpCon.setDoOutput(true);
        
        //System.out.println(inventoryString.length());
        
        
        //httpCon.setRequestProperty("X-Bin-Versioning", "true");
        //httpCon.setRequestProperty("X-Bin-Name", "test"); 
        OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
        out.write(inventoryString);
        out.flush();
        out.close();
       
        httpCon.connect();
        int code = httpCon.getResponseCode();
        String msg = httpCon.getRequestMethod();
        System.out.println(code + " " + msg);
        System.out.println(inventoryString);
    }
    

}
