
package javaalgorithms;

import java.util.List;

/**
 *
 * @author Borgella
 * @param <K>
 */
public class QuickSortB <K extends Comparable <? super K >> {
    
    private List<K> list;

    public QuickSortB(List<K> list) {
        this.list = list;
    }
    
    
    public void quicksort(int left, int right) {
        if(right == list.size() - 1)
            System.out.println("THE RIGHT VALUE IS :" + right + " THE LEFT VALUE: "+ left);
        
        if (right - left <= 0) {
            return;
        } else {
            K pivotElement = (K) list.get(right);
            System.out.println("THE PIVOT ELEMENT IS : "+ pivotElement);
            
            System.out.println("START LOOKING FOR THE PIVOT LOCATION.");
            printTheList(list);
            System.out.println();
            int pivot = partitionning(pivotElement, left, right);
            System.out.println("THE PIVOT LOCATION IS: " + pivot);
            System.out.println();
            
            System.out.println("START QUICKSORT OF THE LEFT SIDE OF THE LIST:");
            System.out.println("THE LEFT VALUE IS :" + left + " THE RIGHT VALUE: "+ (pivot - 1));
            quicksort(left, pivot - 1);
            System.out.println("END QUICKSORT OF THE LEFT SIDE OF THE LIST:");
            System.out.println();
            
            System.out.println("START QUICKSORT THE RIGHT SIDE OF THE LIST:");
            System.out.println("THE LEFT VALUE IS :" + (pivot + 1) + " THE RIGHT VALUE: "+ right);
            quicksort(pivot + 1, right);
            System.out.println("END QUICKSORT OF THE RIGHT SIDE OF THE LIST:");
            System.out.println();
        }

    }

    private int partitionning(K pivotElement, int left, int right) {
        
        int left_pointer = left - 1;
        int right_pointer = right;

        while (true) {
            while (list.get(++left_pointer).compareTo(pivotElement) < 0);
            while (right_pointer > 0 && list.get(--right_pointer).compareTo(pivotElement) > 0);
            if (left_pointer >= right_pointer) {
                break;
            } else {
                System.out.println("VALUES TO BE SWAPPED ARE : INDEX LEFT_POINTER= "+ left_pointer + " VALUE ["+list.get(left_pointer) + 
                        "] AND INDEX RIGHT_POINTER= " + right_pointer + " VALUE ["+list.get(right_pointer) +"]");
                Swap.swapValues(list, left_pointer, right_pointer);
                printTheList(list);
            }
        }
        System.out.println("THE VALUES TO BE SWAPPED AFTER THE WHILE TRUE : INDEX LEFT_POINTER= "+ left_pointer + " VALUE ["+list.get(left_pointer) + 
                        "] AND INDEX RIGHT= " + right + " VALUE ["+list.get(right) +"]");
        Swap.swapValues(list, left_pointer, right);
        printTheList(list);
        return left_pointer;
    }
    
    public static <K extends Comparable <? super K >> void printTheList(List <K> list){
       System.out.print("[ ");
        for(int i = 0 ; i < list.size(); ++i){
            System.out.print(list.get(i));
            if(i < list.size()-1)
                System.out.print(", ");
        }
        System.out.println(" ]");
        
   }
    
}
