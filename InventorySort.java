/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;

/**
 *
 * @author dcsv4
 */
public class InventorySort {
    public ItemList list;
    public ItemList filteredList;
    InventorySort(ItemList itemList, int code){
        this.list = itemList;
        sortList(code);
    }
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
        String filter;
        switch (code){
            case 1:
                int count1 = 0;
                for (int i = 0; i < list.getCount(); i++){
                    if (list.getItem(i).getItemName().toLowerCase().contains(cond.toLowerCase()))
                        count1++;
                }
                //create list of size 'count2' here
                ItemList temp = list;
                filteredList = new ItemList(count1);
                int m = 0;
                int n = 0;
                System.out.println(filteredList.getCount());
                while (m < count1){
                    if (temp.getItem(n).getItemName().toLowerCase().contains(cond.toLowerCase())){
                        filteredList.setItem(temp.getItem(n),m);
                        
                        n++;
                        m++;
                    }
                    else
                        n++;
                        
                }
                //System.out.println(count1);
                break;
            case 2:
                int count2 = 0;
                for (int i = 0; i < list.getCount(); i++){
                    if(list.getItem(i).getItemCategory().compareTo(cond)==0)
                        count2++;
                }
                //create list of size 'count3' here             
                temp = list;
                filteredList = new ItemList(count2);
                m = 0;
                n = 0;
                System.out.println(filteredList.getCount());
                while (m < count2){
                    if (temp.getItem(n).getItemCategory().compareTo(cond)==0){
                        filteredList.setItem(temp.getItem(n),m);
                        //System.out.println(filteredList.getItem(m).getItemId());
                        n++;
                        m++;
                    }
                    else
                        n++;
                }
                break;
        }
        
        
        
    }
    
}
