
package javaalgorithms;

import java.util.List;

/**
 *
 * @author Borgella
 */
public class Swap {
    
    public static <K extends Comparable <? super K> > void swapValues(List<K> liste, int i, int j){
        K temp = liste.get(i);
        liste.set(i,liste.get(j));
        liste.set(j, temp);
    }
    
}