import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Luke Feely
 *  @version HT 2019
 */
/*` 
 * 
 *      Performance Analysis: In Milliseconds                  
 *                        			Insert  			Quick   		Merge Recursive  		Merge Iterative    		Selection
136	  	
      *     10 random         		0 ms   	  		0 ms            0ms        				0ms                    0ms
137	  	
            100 random       		0 ms   	  		0 ms            0ms         				0.333ms             0.333ms
138	  	
            1000 random          	10.333 ms  		1.333 ms       1.333ms                     1ms                 5.666ms
139	  	
            1000 few unique      	8.33 ms   		1.33 ms         2.66ms         			2.33ms                 8ms
140	  	
            1000 nearly ordered  	9.666 ms   		0.333 ms        1.666ms         			1.333ms                 5ms
141	  	
            1000 reverse order   	7ms   			6 ms            1ms         				1.333ms                 5.333ms
142	  	
            1000 sorted          	6.333ms    		11.333 ms       1.333ms         			1.333ms                 7ms
143	  	
     * 
144	  	a. Which of the sorting algorithms does the order of input have an impact on? Why?
			Merge and selection sorts were most prone to this as they rely on segmenting arrays, meaning if they have to repeatedly reorder them
			running time can increase exponetially.
			
		b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
		Insertion Sort because it is very fast when ordered but can be a lot slower when unsorted.
		
		c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
		Selection Sort has the worst scalabilty as it is quite fast with a small input but because it has a time complexity of (O^N^2) it can
		become a lot slower quite quickly.
		
		d. Did you observe any difference between iterative and recursive implementations of merge
sort?
		Iterative was usually considerably slower than recursive
		
	e. Which algorithm is the fastest for each of the 7 input files? 
	10 numbers - insertSort
	100 - QuickSort
	1000 - MergeSort-Recursive
	unique - MergeSort-Recursive
	NearlyOrdered - MergeSort-Recursive
	ReversedMerge-Recursive
	SortedMerge-Recursive


     */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    		if( a == null) {
    			return a;
    		}
    		double temp;
    		for (double i = 1; i < a.length; i++) {
    			for(int j = (int) i ; j > 0 ; j--){ 
    				if(a[j] < a[j-1]){
    					temp = a[j];
    					a[j] = a[j-1];
    					a[j-1] = temp;
    				}
    			}   
    		}   
    		return a; 
    	}

        
    //end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	if( a == null) {
			return a;
		}
    		int low = 0;
    		int high = a.length-1;
    		sort(a, low, high);
    		return a;
    	}
    static void sort(double arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 

    	
    static int partition(double arr[], int low, int high) 
    { 
        double pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        double temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	if( a == null) {
			return a;
		}
    		double aux[] = new double[a.length];
    		sort(a, aux, 0, a.length - 1);
    		return a;
    	}
    public static void sort(double[] orig, double[] aux, int start, int end) {
        int N = orig.length;
        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(orig, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N-1));
            }
        }
    }
    public static void merge(double[] orig, double[] aux, int start, int mid, int end) {
        int i, j, z = start; 
        
        if(orig[mid] <= orig[mid+1])return; 
        
        for(i=start, j = mid+1; i!=mid+1 || j!=end+1;){
            if(i==mid+1)               while(j!=end+1){ aux[z++] = orig[j++]; }
            else if(j==end+1)          while(i!=mid+1){ aux[z++] = orig[i++]; }
            else if(orig[i]<=orig[j])  aux[z++] = orig[i++];
            else                       aux[z++] = orig[j++];
        }    
    }
    static double[] read(String link, int size) throws IOException
    {
    	//TODO: implement this method
    	FileReader theFile = new FileReader(link);
    	BufferedReader buffered = new BufferedReader(theFile);
    	boolean end = false;
    	double[] numberArray = new double[size];
    	int i =0;
    	while(!end)
    	{
    		String numbersList = buffered.readLine();
    		if(numbersList == null)
    		{
    			end = true;
    		}
    		else
    		{
    			numberArray[i] = Double.parseDouble(numbersList);
    			i++;
    		}
    	}

    	return numberArray;


    }
    
    
    static int countFile(String link) throws IOException
    {
    	FileReader theFile = new FileReader(link);
    	BufferedReader buffered = new BufferedReader(theFile);
    	boolean end = false;
    	int count = 0;
    	while(!end)
    	{
    		String numbersList = buffered.readLine();
    		if(numbersList == null)
    		{
    			end = true;
    		}
    		else
    		{
    			count++;
    		}
    	}

    	return count;

    }

 //end class
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    
	 static double[] mergeSortRecursive(double[] array) {
		 if( array == null) {
 			return array;
 		}	
		if (array.length > 1) {
			int mid = array.length / 2;
			double[] left = new double[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = array[i];
			}
			double[] right = new double[array.length - mid];
			for (int i = mid; i < array.length; i++) {
				right[i - mid] = array[i];
			}
			mergeSortRecursive(left);
			mergeSortRecursive(right);
			int i = 0;
			int j = 0;
			int k = 0;
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					array[k] = left[i];
					i++;
				} else {
					array[k] = right[j];
					j++;
				}
				k++;
			}
			while (i < left.length) {
				array[k] = left[i];
				i++;
				k++;
			}
			while (j < right.length) {
				array[k] = right[j];
				j++;
				k++;
			}
		}
		return array;
	}
    
    public static double[] leftHalf(double[] array) {
        int size1 = array.length / 2;
        double[] left = new double[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    
    public static double[] rightHalf(double[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        double[] right = new double[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    
    public static void merge2(double[] result, 
                             double[] left, double[] right) {
        int i1 = 0;   
        int i2 = 0;   
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1]; 
                i1++;
            } else {
                result[i] = right[i2];   
                i2++;
            }
        }
    }
 

   
   
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	if( a == null) {
			return a;
		}
        {
        	if (a != null) {
        		for(int i=0; i < a.length - 1; i++) {
        			int minimum = i;
        			for(int j=i+1; j < a.length; j++) {
        				if(a[j] < a[minimum]) {
        					minimum = j;
        				}
        			}
        			double temp = a[i];
        			a[i]=a[minimum];
        			a[minimum]= temp;
        		}
        		return a;
        	}
        	else
        	{
        		return null;
        	}
        }

    }

   


    

 }//end class
