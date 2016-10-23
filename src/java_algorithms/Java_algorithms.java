
package java_algorithms;

import java.util.ArrayList;
import java.util.List;
import javaalgorithms.Algorithms;

/**
 *
 * @author Borgella
 */
public class Java_algorithms {

   public static void main(String [] args){
        List<Integer> list = new ArrayList();
        list.add(51);
        list.add(43);
        list.add(43);
        list.add(45);
        list.add(19);
        list.add(39);
        list.add(40);
        list.add(20);
        list.add(46);
        list.add(18);
        list.add(40);
        
        printTheList(list);  
        System.out.println("\n");
        
        Algorithms sort_list= new Algorithms(list);
        sort_list.quicksort(0, list.size()-1);
        //sort_list.bubblesort();
        sort_list.selection();
        //Algorithms.selection(list);
        
        printTheList(list);
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
