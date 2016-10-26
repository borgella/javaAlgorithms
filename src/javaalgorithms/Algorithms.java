package javaalgorithms;

import java.util.List;

/**
 *
 * @author Borgella
 * @param <K>
 * <K extends Comparable<? super K>> means
 */
public class Algorithms<K extends Comparable <? super K >> {

    private List<K> list;

    public Algorithms(List<K> list) {
        this.list = list;
    }
    
    
    public void quicksort(int left, int right) {
        
        if (right - left <= 0) {
            return;
        } else {
            K pivotElement = (K) list.get(right);
            int pivot = partitionning(pivotElement, left, right);
            quicksort(left, pivot - 1);
            quicksort(pivot + 1, right);
        }

    }

    private int partitionning(K pivotElement, int left, int right) {
        int left_pointer = left - 1;
        int right_pointer = right;

        while (true) {
            while (list.get(++left_pointer).compareTo(pivotElement) < 0);
            while (right_pointer > 0 && list.get(--right_pointer).compareTo(pivotElement) > 0);
            if (left_pointer >= right_pointer) 
                break;
            else 
                Swap.swapValues(list, left_pointer, right_pointer);
            
        }
        Swap.swapValues(list, left_pointer, right);
        return left_pointer;
    }
    
    public void bubblesort(){
        boolean next = true;
        while(next){
            next = false;
            for(int i = 0; i < list.size() - 1; ++i){
                if(list.get(i).compareTo(list.get(i+1)) > 0){
                    Swap.swapValues(list, i, i+1);
                    next = true;
                }
            }
        }
    }
    
    public void insertion(){
        
        for(int i = 0 ; i < list.size() ; ++i ){
            
            int j = i;
            while(j - 1 >= 0 && (list.get(j).compareTo(list.get(j - 1)) < 0 )){
               Swap.swapValues(list, j, j - 1);
               --j;
            }
        }
    }
    
    public void selection() {
        // int j = i, pour éviter de comparer les elements avec ceux qui ont déjà été triés dans la liste.
        for (int i = 0; i < list.size(); ++i) {
                K min = list.get(i);
                for (int j =  i ; j < list.size(); ++j) {
                    if (list.get(j).compareTo(min) < 0) {
                         min = list.get(j);
                         Swap.swapValues(list, i, j);
                    }
                }
        }
    }
    
    public static < K extends Comparable <? super K > > void bubblesort(List<K> list){
        boolean next = true;
        
        while(next){
            next = false;
            for(int i = 0; i < list.size() - 1; ++i){
                if(list.get(i).compareTo(list.get(i+1)) > 0){
                    Swap.swapValues(list, i, i+1);
                    next = true;
                }
            }
        }
    }
    
    public static <K extends Comparable <? super K > > void insertion(List< K > list){
        
        for(int i = 0 ; i < list.size() ; ++i ){
            int j = i;
            while(j - 1 >= 0 && (list.get(j).compareTo(list.get(j - 1)) < 0 )){
               Swap.swapValues(list, j, j - 1);
               --j;
            }
        }
    }
    
    public static < K extends Comparable<? super K>> void selection(List< K> list) {

        for (int i = 0; i < list.size(); ++i) {
            K min = list.get(i);
            for (int j = i; j < list.size(); ++j) {
                if (list.get(j).compareTo(min) < 0) {
                    min = list.get(j);
                    Swap.swapValues(list, i, j);
                }
            }
        }
    }
}
