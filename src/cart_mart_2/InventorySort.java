/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

/**
 * InventorySort both filters and sorts a given ItemList
 * @author david
 */
public class InventorySort {
    
    public ItemList list;
    public ItemList filteredList;
    /**
     * Constructor for sorting
     * InventorySort takes a given ItemList and sorts it based on a given criteria
     * The calling function can then access the sorted list via public reference of list
     * @param itemList  an ItemList to be sorted
     * @param code      what Item parameter is used to sort by 1: name, 2: category, 3: price
     */
    InventorySort(ItemList itemList, int code){
        this.list = itemList;
        sortList(code);
    }
    /**
     * Constructor for filtering
     * InventorySort takes a given ItemList and filters it based on a given criteria
     * The calling function can then access the sorted list via public reference of filteredList
     * @param itemList  an ItemList to be sorted
     * @param code      what Item parameter is used to sort by 1: name, 2: category, 3: price
     * @param cond      the value used for filtering, i.e. search parameter
     */
    InventorySort(ItemList itemList, int code, String cond){
        this.list = itemList;
        filterList(code, cond);
    }
    
    private void sortList(int val){
        switch (val){
            case 1:
                for (int i = 0; i < list.getCount(); i++){
                    for (int j = i+1; j < list.getCount(); j++){
                        if (list.getItem(i).getItemName().compareTo(list.getItem(j).getItemName())>0){
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j),i);
                            list.setItem(temp,j);                     
                        }   
                    }   
                }
                break;
            case 2:
                for (int i = 0; i < list.getCount(); i++){
                    for (int j = i+1; j < list.getCount(); j++){
                        if (list.getItem(i).getItemCategory().compareTo(list.getItem(j).getItemCategory())>0){
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j),i);
                            list.setItem(temp,j);                     
                        }   
                    }   
                }
                break;
            case 3:
                for (int i = 0; i < list.getCount(); i++){
                    for (int j = i+1; j < list.getCount(); j++){
                        if (list.getItem(i).getItemPrice()>list.getItem(j).getItemPrice()){
                            Item temp = list.getItem(i);
                            list.setItem(list.getItem(j),i);
                            list.setItem(temp,j);                     
                        }   
                    }   
                }
                break;
        }
    }
    private void filterList(int code, String cond){
        switch (code){
            case 1:
                int count1 = 0;
                for (int i = 0; i < list.getCount(); i++){
                    if (list.getItem(i).getItemName().toLowerCase().contains(cond.toLowerCase()))
                        count1++;
                }
                ItemList temp = list;
                filteredList = new ItemList();
                int m = 0;
                int n = 0;
                //System.out.println(filteredList.getCount());
                while (m < count1){
                    if (temp.getItem(n).getItemName().toLowerCase().contains(cond.toLowerCase())){
                        filteredList.addItem(temp.getItem(n));
                        n++;
                        m++;
                    }
                    else
                        n++;
                }
                break;
            case 2:
                int count2 = 0;
                for (int i = 0; i < list.getCount(); i++){
                    if(list.getItem(i).getItemCategory().compareTo(cond)==0)
                        count2++;
                }      
                temp = list;
                filteredList = new ItemList();
                m = 0;
                n = 0;
                while (m < count2){
                    if (temp.getItem(n).getItemCategory().compareTo(cond)==0){
                        filteredList.addItem(temp.getItem(n));
                        n++;
                        m++;
                    }
                    else
                        n++;
                }
                break;
            case 3:
                //create list of size 'count3' here 
        }
    }
}
