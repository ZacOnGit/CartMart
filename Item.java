/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;
/**
 *
 * @author dcsv4
 */
public class Item {
    private final int itemId;
    private final String itemName;
    private final String itemCategory;
    private final int itemPrice;
    private int itemQuantity;
    private final String itemDescription;
    private final String itemImage;

    //CONSTRUCTOR
    public Item(int id, String name, String category, int price, int qty, String desc){
        this.itemId = id;
        this.itemName = name;
        this.itemCategory = category;
        this.itemPrice = price;
        this.itemQuantity = qty;
        this.itemDescription = desc;
        String fileName = String.valueOf(id) + ".jpg";
        this.itemImage = fileName;
    }
    //SETTERS
    public void decreaseQty(int qty){
        this.itemQuantity -= qty;
    }
    
    //GETTERS
    public int getItemId(){
        return this.itemId;
    }
    public String getItemName(){
        return this.itemName;
    }
    public String getItemCategory(){
        return this.itemCategory;
    }
    public int getItemPrice(){
        return this.itemPrice;
    }
    public int getItemQuantity(){
        return this.itemQuantity;
    }
    public String getItemDescription(){
        return this.itemDescription;
    }
    public String getItemImage(){
        return this.itemImage;
    }
}
