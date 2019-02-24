import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

/*
Results:
+---------------------+--------+-------+-----------------+-----------------+-----------+
|                     | Insert | Quick | Merge Recursive | Merge Iterative | Selection |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 10 random           |  0.67  |   0   |        0        |        0        |     0     |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 100 random          |    0   |  0.33 |        0        |        0        |     0     |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 1000 random         |  6.33  |  2.33 |        1        |       0.33      |    3.67   |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 1000 few unique     |    1   |  1.33 |        0        |       0.67      |     2     |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 1000 nearly ordered |  1.33  |  0.67 |       0.33      |        0        |     3     |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 1000 reverse order  |  0.67  |  0.67 |       0.33      |        0        |    0.33   |
+---------------------+--------+-------+-----------------+-----------------+-----------+
| 1000 sorted         |  0.33  |  1.33 |        0        |        0        |    0.33   |
+---------------------+--------+-------+-----------------+-----------------+-----------+

a. Which of the sorting algorithms does the order of input have an impact on? Why?
Insert, Quick and Selection are the most affected by the order of input.
Selection is impacted because it must go through the entire array

b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?


c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
Best: Merge Iterative
Worst: Insert

d. Did you observe any difference between iterative and recursive implementations of merge
sort?
Iterative was easier to debug as recursion can often cause infinite loops

e. Which algorithm is the fastest for each of the 7 input files?
Merge Iterative is the best overall. For each file:
- 10 random: Quick, Merge Recursive, Merge Iterative, Selection
- 100 random: Insert, Merge Recursive, Merge Iterative, Selection
- 1000 random: Merge Iterative
- 1000 few unique: Merge Recursive
- 1000 nearly ordered: Merge Iterative
- 1000 reverse order: Merge Iterative
- 1000 sorted: Merge Recursive, Merge Iterative
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
    
    /**
     * Check that quick sort works for different arrays
     */
    @Test
    public void testQuickSort() {
    	double[] unsortedArray = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	double[] sortedArray = new double[]{07, 17, 18, 25, 42, 53, 62, 69, 83, 86, 95};
    	
    	assertTrue(Arrays.equals(sortedArray, SortComparison.quickSort(unsortedArray)));
    	
    	double[] unsortedArray2 = new double[]{83, 62};
    	double[] sortedArray2 = new double[]{62, 83};
    	
    	assertTrue(Arrays.equals(sortedArray2, SortComparison.quickSort(unsortedArray2)));
    	
    	double[] unsortedArray3 = new double[]{83};
    	double[] sortedArray3 = new double[]{83};
    	
    	assertTrue(Arrays.equals(sortedArray3, SortComparison.quickSort(unsortedArray3)));
    }
    
    /**
     * Check that iterative merge sort works for different arrays
     */
    @Test
    public void testMergeSortIterative() {
    	double[] unsortedArray = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	double[] sortedArray = new double[]{07, 17, 18, 25, 42, 53, 62, 69, 83, 86, 95};
    	
    	assertTrue(Arrays.equals(sortedArray, SortComparison.mergeSortIterative(unsortedArray)));
    	
    	double[] unsortedArray2 = new double[]{83, 62};
    	double[] sortedArray2 = new double[]{62, 83};
    	
    	assertTrue(Arrays.equals(sortedArray2, SortComparison.mergeSortIterative(unsortedArray2)));
    	
    	double[] unsortedArray3 = new double[]{83};
    	double[] sortedArray3 = new double[]{83};
    	
    	assertTrue(Arrays.equals(sortedArray3, SortComparison.mergeSortIterative(unsortedArray3)));
    }
    
    /**
     * Check that recursive merge sort works for different arrays
     */
    @Test
    public void testMergeSortRecursive() {
    	double[] unsortedArray = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	double[] sortedArray = new double[]{07, 17, 18, 25, 42, 53, 62, 69, 83, 86, 95};
    	
    	assertTrue(Arrays.equals(sortedArray, SortComparison.mergeSortRecursive(unsortedArray)));
    	
    	double[] unsortedArray2 = new double[]{83, 62};
    	double[] sortedArray2 = new double[]{62, 83};
    	
    	assertTrue(Arrays.equals(sortedArray2, SortComparison.mergeSortRecursive(unsortedArray2)));
    	
    	double[] unsortedArray3 = new double[]{83};
    	double[] sortedArray3 = new double[]{83};
    	
    	assertTrue(Arrays.equals(sortedArray3, SortComparison.mergeSortRecursive(unsortedArray3)));
    }
    
    /**
     * Check that selection sort works for different arrays
     */
    @Test
    public void testSelectionSort() {
    	double[] unsortedArray = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	double[] sortedArray = new double[]{07, 17, 18, 25, 42, 53, 62, 69, 83, 86, 95};
    	
    	assertTrue(Arrays.equals(sortedArray, SortComparison.selectionSort(unsortedArray)));
    	
    	double[] unsortedArray2 = new double[]{83, 62};
    	double[] sortedArray2 = new double[]{62, 83};
    	
    	assertTrue(Arrays.equals(sortedArray2, SortComparison.selectionSort(unsortedArray2)));
    	
    	double[] unsortedArray3 = new double[]{83};
    	double[] sortedArray3 = new double[]{83};
    	
    	assertTrue(Arrays.equals(sortedArray3, SortComparison.selectionSort(unsortedArray3)));
    }
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws IOException 
     *
     */
    public static void main(String[] args) throws IOException {
    	System.out.println("numbers10.txt:");
    	File file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbers10.txt"); 
    	  
    	BufferedReader br = new BufferedReader(new FileReader(file)); 
    	
    	double[] nums = new double[10];
    	double[] numsSorted = new double[10];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    	
    	long startTime, stopTime, elapsedTime;
    	
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        System.out.print("Array: ");

        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);

        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);

        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);

        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);

        System.out.print("\n");
        System.out.println("numbers100.txt:");
    	file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbers100.txt"); 
    	  
    	br = new BufferedReader(new FileReader(file)); 
    	
    	nums = new double[100];
    	numsSorted = new double[100];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        
        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);
        
        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);
        
        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);
        
        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);
        
        System.out.print("\n");
        System.out.println("numbers1000.txt:");
    	file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbers1000.txt"); 
    	  
    	br = new BufferedReader(new FileReader(file)); 
    	
    	nums = new double[1000];
    	numsSorted = new double[1000];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        
        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);
        
        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);
        
        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);
        
        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);
        
        System.out.print("\n");
        System.out.println("numbers1000Duplicates.txt:");
    	file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbers1000Duplicates.txt"); 
    	  
    	br = new BufferedReader(new FileReader(file)); 
    	
    	nums = new double[1000];
    	numsSorted = new double[1000];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        
        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);
        
        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);
        
        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);
        
        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);
        
        System.out.print("\n");
        System.out.println("numbersNearlyOrdered1000.txt:");
    	file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbersNearlyOrdered1000.txt"); 
    	  
    	br = new BufferedReader(new FileReader(file)); 
    	
    	nums = new double[1000];
    	numsSorted = new double[1000];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        
        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);
        
        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);
        
        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);
        
        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);
        
        System.out.print("\n");
        System.out.println("numbersReverse1000.txt:");
    	file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbersReverse1000.txt"); 
    	  
    	br = new BufferedReader(new FileReader(file)); 
    	
    	nums = new double[1000];
    	numsSorted = new double[1000];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        
        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);
        
        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);
        
        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);
        
        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);
        
        System.out.print("\n");
        System.out.println("numbersSorted1000.txt:");
    	file = new File("C:\\Users\\Oscar\\Desktop\\assignment input data files\\numbersSorted1000.txt"); 
    	  
    	br = new BufferedReader(new FileReader(file)); 
    	
    	nums = new double[1000];
    	numsSorted = new double[1000];
    	
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = Double.parseDouble(br.readLine());
    	}
    
    	// Insertion
    	startTime = System.currentTimeMillis();
    	
    	numsSorted = SortComparison.insertionSort(nums);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Insertion time: " + elapsedTime);
        
        // Quick
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.quickSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Quick time: " + elapsedTime);
        
        // Iterative merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortIterative(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Iterative merge time: " + elapsedTime);
        
        // Recursive merge
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.mergeSortRecursive(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Recursive merge time: " + elapsedTime);
        
        // Selection
        startTime = System.currentTimeMillis();
        
        numsSorted = SortComparison.selectionSort(nums);
        
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        
        System.out.println("Selection time: " + elapsedTime);
        
        System.out.print("\n");
    }
}