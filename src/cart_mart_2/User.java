/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author dcsv4
 */
public class User {

    public static String receiptName = "";
    private static String firstName = "David";
    private static String lastName = "David";
    public static Boolean guest = true;
    public static String userName;
    private static String passWord;
    private static String address = "no address";
    private static String phone = "no phone";
    private static ArrayList<ItemList> orderHistory;
    private static int outputFileLine;
    public static Boolean delivery = false;

    public static void createUser(String fn, String ln, String un, String pw) {
        firstName = fn;
        lastName = ln;
        guest = false;
        userName = un;
        passWord = pw;
        if (!guest) 
            receiptName = firstName;
        try{
            
            File history = new File("src/cart_mart_2/resources/"+un+".txt");
            if (!history.exists())
                history.createNewFile();
        }
        catch(Exception e){
            
        }
    }

    public void saveToHistory() {

    }
    public static void setLine(int number){
        outputFileLine = number;
    }
    public static int getLine(){
        return outputFileLine;
    }
    public static void setContact(String a, String p){
        address = a;
        phone = p;
    }
}
