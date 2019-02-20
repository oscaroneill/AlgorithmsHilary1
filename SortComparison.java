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
    private static int partition(double[] a, int lo, int hi) {
    	double pivot = a[lo];
    	int i = lo;
    	int j = hi + 1;
    	
    	while (true) {
    		while (a[++i] < pivot) {
    			if (i == hi) {
    				break;
    			}
    		}
    		
    		while (pivot < a[--j]) {
    			if (j == lo) {
    				break;
    			}
    		}
    		
    		if (i >= j) {
    			break;
    		}
    		
    		double temp = a[i];
    		a[i] = a[j];
    		a[j] = temp;
    	}
    	
    	a[lo] = a[j];
    	a[j] = pivot;
    	
    	return j;
    }
    
    public static void quickSort(double[] a, int lo, int hi) {
    	if (hi <= lo) {
    		return;
    	}
    	
    	int pivot = partition(a, lo, hi);
    	
    	quickSort(a, lo, pivot - 1);
    	quickSort(a, pivot + 1, hi);
    }
    
    static double[] quickSort (double a[]) {
    	quickSort(a, 0, a.length - 1);
    	
		return a;
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
    	if (a == null) { 
            return a; 
        } else if (a.length > 1) {	    	
	    	int mid = a.length / 2;
	    	
	        double[] left = new double[mid]; 
	        double[] right = new double[a.length - mid];
	        
	        for (int i = 0; i < mid; i++) { 
	            left[i] = a[i]; 
	        } 
	        for (int i = mid; i < a.length; i++) { 
	            right[i - mid] = a[i]; 
	        } 
	        
	        mergeSortIterative(left); 
	        mergeSortIterative(right); 
	
	        int i = 0, j = 0, k = 0; 

	        while (i < left.length && j < right.length) { 
	            if (left[i] < right[j]) { 
	                a[k] = left[i]; 
	                i++; 
	            } else { 
	                a[k] = right[j]; 
	                j++; 
	            } 
	            
	            k++; 
	        } 
	        
	        while (i < left.length) { 
	            a[k] = left[i]; 
	            i++; 
	            k++; 
	        } 
	        
	        while (j < right.length) { 
	            a[k] = right[j]; 
	            j++; 
	            k++; 
	        }
        }
    	
    	return a;
    } // end mergesortIterative
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    
    public static void merge(double[] a, double[] aux, int lo, int mid, int hi) { 
        for (int k = lo; k <= hi; k++) {
        	aux[k] = a[k];
        }
        
        int i = lo;
        int j = mid+1;
        
        for (int k = lo; k <= hi; k++) {
        	if (i > mid) {
        		a[k] = aux[j++];
        	} else if (j > hi) {
        		a[k] = aux[i++];
        	} else if (aux[j] < aux[i]) {
        		a[k] = aux[j++];
        	} else {
        		a[k] = aux[i++];
        	}
        }
    } 
    
    private static void mergeSortRecursive(double[] a, double[] aux, int lo, int hi) { 
    	if (hi <= lo) {
    		return;
    	}
    	
    	int mid = lo + (hi - lo) / 2;
    	
    	mergeSortRecursive(a, aux, lo, mid);
    	mergeSortRecursive(a, aux, mid + 1, hi);
    	
    	merge(a, aux, lo, mid, hi);
    }
    
    static double[] mergeSortRecursive (double a[]) {
    	double[] aux = new double[a.length];
    	
        mergeSortRecursive(a, aux, 0, a.length - 1);
        
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
    	for (int i = 0; i < a.length-1; i++) {
	    	int minimum = i;
	    	
	    	for (int j = i + 1; j < a.length; j++) {
		    	if (a[j] < a[minimum]) {
		    		minimum = j;
		    	}
	    	}
	    	
	    	double temp = a[minimum];
	    	a[minimum] = a[i];
	    	a[i] = temp;
    	}    	
    	
    	return a;
    } // end selectionsort

    public static void main(String[] args) {
    	// TODO: do experiments as per assignment instructions
    	//double[] a = new double[]{62, 83, 18, 53, 07, 17, 95, 86, 42, 69, 25};
    	//double[] a = new double[]{5, 2, 6, 1, 3, 4};
    	//SortComparison.quickSort(a);
    }
} // end class