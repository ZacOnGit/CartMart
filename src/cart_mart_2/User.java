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
public class User {

    private String name;
    private String userName;
    private String passWord;
    private String address = "no address";
    private ArrayList<ItemList> orderHistory;
    private static int outputFileLine;

    public void createUser() {

    }

    public void saveToHistory() {

    }
    public static void setLine(int number){
        outputFileLine = number;
    }
    public static int getLine(){
        return outputFileLine;
    }
}
