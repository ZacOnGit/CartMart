/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author dcsv4
 */
public class Order extends ItemList{
    public static ArrayList<Integer> qtyList;
    public static ArrayList<Integer> itemIdList;
    public static String historyToSave;
    public static int orderNumber;
    
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
        historyToSave = ReceiptPanel.orderForHistory.substring(0, ReceiptPanel.orderForHistory.length() - 1);
        
        
        try(FileWriter fw = new FileWriter("src/cart_mart_2/resources/"+User.userName+".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(orderNumber + ":" + historyToSave);
        } catch (Exception e) {
            System.out.println("An unexpected error occured.");
        }
        //System.out.println(ReceiptPanel.orderForHistory);
    }
}
