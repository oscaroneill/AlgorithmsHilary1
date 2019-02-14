import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Oscar O'Neill (17330989)
 *  @version HT 2019
 */

class SortComparison {
    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     */
    static double[] insertionSort (double a[]) {
        int unsortedElement = 1;
        int currentElement = 1;
        for (int j = unsortedElement; j < a.length; j++) {
        	for (int i = unsortedElement-1; i >= 0; i--) {
            	if (a[i] > a[currentElement]) {
            		double temp = a[currentElement];
            		a[currentElement] = a[i];
            		a[i] = temp;
            		currentElement--;
            	}
            }
            unsortedElement++;
            currentElement = unsortedElement;
        }
        return a;
    } // end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] quickSort (double a[]) {
    	if (a.length == 0 || a.length == 1) {
    		return a;
    	} else {
    		int pivot = 0;
    		int left = 0;
    		int right = a.length-1;
    		boolean finished = false;
    		
    		while (!finished) {
    			if (left == right) {
    				System.out.print("a: ");
    				for (int i = 0; i < a.length; i++) {
    					System.out.print(a[i] + ", ");
    				}
    				System.out.print("\n");
    				
    				double[] b = Arrays.copyOfRange(a, 0, pivot);
    				
    				System.out.print("b: ");
    				for (int j = 0; j < b.length; j++) {
    					System.out.print(b[j] + ", ");
    				}
    				System.out.print("\n");
    				
    				double[] c = Arrays.copyOfRange(a, pivot+1, a.length);
    				
    				System.out.print("c: ");
    				for (int k = 0; k < c.length; k++) {
    					System.out.print(c[k] + ", ");
    				}
    				System.out.print("\n");
    				
    				quickSort(b);
    				quickSort(c);
    			} else if (pivot == left) {
    				if (a[pivot] < a[right]) {
        				right--;
        			} else {
        				double tmp = a[pivot];
        				a[pivot] = a[right];
        				a[right] = tmp;
        				pivot = right;
        			}
        		} else if (pivot == right) {
        			if (a[pivot] > a[left]) {
        				left++;
        			} else {
        				double tmp = a[pivot];
        				a[pivot] = a[left];
        				a[left] = tmp;
        				pivot = left;
        			}
        		}
    		}
    		return a;
    	}
    } // end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	return a;
    } // end mergesortIterative
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	return a;
    } // end mergeSortRecursive
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double[] selectionSort (double a[]) {
    	return a;
    } // end selectionsort

    public static void main(String[] args) {
    	// TODO: do experiments as per assignment instructions
    	//double[] a = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	double[] a = new double[]{5, 2, 6, 1, 3, 4};
    	SortComparison.quickSort(a);
    }
} // end class