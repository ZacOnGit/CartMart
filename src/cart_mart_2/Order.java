/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.util.ArrayList;

/**
 *
 * @author dcsv4
 */
public class Order extends ItemList{
    public static ArrayList<Integer> qtyList;
    public static ArrayList<Integer> itemIdList;
    
    public Order(){
        qtyList = new ArrayList<>();
        itemIdList = new ArrayList<>();
    }
    
    public void addItem(int itemNum, int qty){
        //itemList.add(item);
        qtyList.add(qty);
    }
    
    public Item getItem(int index){
        return itemList.get(index);
    }
    
    public int getQty(int index){
        return qtyList.get(index);
    }
    
    public static void saveOrder(){
        ReceiptPanel.orderForHistory = ReceiptPanel.orderForHistory.substring(0, ReceiptPanel.orderForHistory.length() - 1);
        System.out.println(ReceiptPanel.orderForHistory);
    }
}
