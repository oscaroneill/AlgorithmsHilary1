import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.Assert;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Oscar O'Neill (17330989)
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty() {
    	double[] emptyArray = new double[0];
    	double[] array = new double[0];
    	
    	assertTrue(Arrays.equals(emptyArray, SortComparison.insertionSort(array)));
    }

    // TODO: add more tests here. Each line of code and each decision in SortComparison.java should
    // be executed at least once from at least one test.
    /**
     * Check that insertion sort works for different arrays
     */
    @Test
    public void testInsertionSort() {
    	double[] unsortedArray = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	double[] sortedArray = new double[]{07, 17, 18, 25, 42, 53, 62, 69, 83, 86, 95};
    	
    	assertTrue(Arrays.equals(sortedArray, SortComparison.insertionSort(unsortedArray)));
    	
    	double[] unsortedArray2 = new double[]{83, 62};
    	double[] sortedArray2 = new double[]{62, 83};
    	
    	assertTrue(Arrays.equals(sortedArray2, SortComparison.insertionSort(unsortedArray2)));
    	
    	double[] unsortedArray3 = new double[]{83};
    	double[] sortedArray3 = new double[]{83};
    	
    	assertTrue(Arrays.equals(sortedArray3, SortComparison.insertionSort(unsortedArray3)));
    }
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args) {
        //TODO: implement this method
    }
}