
package javaalgorithms;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Borgella
 */
public class AlgorithmsIT {
    List<Integer> list ; 
    public AlgorithmsIT() {
        list = new ArrayList();
    }
    
    @Before
    public void setUp() {
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of quicksort method, of class Algorithms.
     */
    @Test
    public void testQuicksort() {
        System.out.println("quicksort");
        int left = 0;
        int right = list.size() - 1;
        Algorithms quicksort = new Algorithms(list);
        quicksort.quicksort(left, right);
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        list.toArray(result);
        Assert.assertArrayEquals(expResult,result);
    }

    /**
     * Test of bubblesort method, of class Algorithms.
     */
    @Test
    public void testBubblesort_0args() {
        System.out.println("bubblesort");
        Algorithms bubblesort = new Algorithms(list);
        bubblesort.bubblesort();
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        list.toArray(result);
        Assert.assertArrayEquals(expResult,result);
    }

    /**
     * Test of insertion method, of class Algorithms.
     */
    @Test
    public void testInsertion_0args() {
        System.out.println("insertion");
        Algorithms insertion = new Algorithms(list);
        insertion.insertion();
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        list.toArray(result);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of selection method, of class Algorithms.
     */
    @Test
    public void testSelection_0args() {
        System.out.println("selection");
        Algorithms selection = new Algorithms(list);
        selection.selection();
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        list.toArray(result);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of bubblesort method, of class Algorithms.
     */
    @Test
    public void testBubblesort_List() {
        System.out.println("bubblesort 2");
        Algorithms.bubblesort(list);
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        list.toArray(result);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of insertion method, of class Algorithms.
     */
    @Test
    public void testInsertion_List() {
        System.out.println("insertion 2");
        Algorithms.insertion(list);
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        list.toArray(result);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of selection method, of class Algorithms.
     */
    @Test
    public void testSelection_List() {
        System.out.println("selection 2");
        Integer [] expResult = {18,19,20,39,40,40,43,43,45,46,51};
        Integer [] result = new Integer[list.size()];
        Algorithms.selection(list);
        list.toArray(result);
        Assert.assertArrayEquals(expResult, result);
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
