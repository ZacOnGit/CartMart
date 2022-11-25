/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author dcsv4
 */
public class ItemList {

    private int listCount;
    protected ArrayList<Item> itemList;

    public ItemList(String json) {
        itemList = new ArrayList<>();
        listCount = 0;
        createList(json);
    }

    ItemList() {
        itemList = new ArrayList<>();
        listCount = 0;
    }

    //SETTER
    public void setItem(Item newItem, int index) {
        itemList.set(index, newItem);
    }

    //GETTERS
    public int getCount() {
        return this.itemList.size();
    }

    public Item getItem(int value) {
        if (value < 0 || value > this.itemList.size()) {
            return null;
        } else {
            return this.itemList.get(value);
        }
    }
    
    public Item getItem(String name){
        if(name == null){
            return null;
        }
        for(int i = 0; i < itemList.size(); i++){
            Item temp = itemList.get(i);
            if(temp.getItemName().equals(name)){
                return temp;
            }
        }
        return null;
    }
    
    public void addItem(Item item) {
        this.itemList.add(item);
        listCount++;
    }
    
    public void removeItem(int index){
        this.itemList.remove(index);
    }

    private void createList(String json) {
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = json.indexOf("itemID", lastIndex);
            if (lastIndex != -1) {
                String id = "";
                String name = "";
                String category = "";
                String price = "";
                String qty = "";
                String desc = "";
                int temp = lastIndex + 8;
                char c = json.charAt(temp);
                while (c != ',') {
                    id = id + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemName", lastIndex);
                temp = lastIndex + 12;
                c = json.charAt(temp);
                while (c != '"') {
                    name = name + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemCategory", lastIndex);
                temp = lastIndex + 16;
                c = json.charAt(temp);
                while (c != '"') {
                    category = category + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemPrice", lastIndex);
                temp = lastIndex + 11;
                c = json.charAt(temp);
                while (c != ',') {
                    price = price + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemQty", lastIndex);
                temp = lastIndex + 9;
                c = json.charAt(temp);
                while (c != ',') {
                    qty = qty + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex = json.indexOf("itemDesc", lastIndex);
                temp = lastIndex + 12;
                c = json.charAt(temp);
                while (c != '"') {
                    desc = desc + String.valueOf(c);
                    temp++;
                    c = json.charAt(temp);
                }
                lastIndex += "itemDesc".length();
                id = id.replace(" ", "");
                price = price.replace(" ", "");
                qty = qty.replace(" ", "");
                Item newItem = new Item(Integer.valueOf(id), name, category, Integer.valueOf(price), Integer.valueOf(qty), desc);
                itemList.add(newItem);
                listCount++;
            }
        }
    }

    public void saveList() /*throws MalformedURLException, IOException*/ {
        String inventoryString = "{\"record\":[{\"";
        for (int i = 0; i < this.itemList.size(); i++) {
            inventoryString = inventoryString + "itemID\":";
            inventoryString = inventoryString + itemList.get(i).getItemId();
            inventoryString = inventoryString + ",\"itemName\":\"";
            inventoryString = inventoryString + itemList.get(i).getItemName();
            inventoryString = inventoryString + "\",\"itemCategory\":\"";
            inventoryString = inventoryString + itemList.get(i).getItemCategory();
            inventoryString = inventoryString + "\",\"itemPrice\":";
            inventoryString = inventoryString + itemList.get(i).getItemPrice();
            inventoryString = inventoryString + ",\"itemQty\":";
            inventoryString = inventoryString + itemList.get(i).getItemQuantity();
            inventoryString = inventoryString + ",\"itemDesc\":\"";
            inventoryString = inventoryString + itemList.get(i).getItemDescription();
            inventoryString = inventoryString + "\",\"itemImage\":";
            inventoryString = inventoryString + itemList.get(i).getItemId();
            if (i == this.itemList.size() - 1) {
                inventoryString = inventoryString + "}],\"metadata\":\n";
                inventoryString = inventoryString + "{\"id\":\"63406cdf2b3499323bd6971c\",\"private\":false,\"createdAt\":";
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
                String formattedDate = time.format(formatTime);
                inventoryString = inventoryString + "\"" + formattedDate + "\"}}";
            } else {
                inventoryString = inventoryString + "},\n";
            }
        }
        System.out.println(inventoryString);
    }
}
