import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }
    
    public static void main(String[] args) throws IOException
	{
    		for(int i = 0; i < args.length; i++)
		{	
			double[] a = SortComparison.read(args[i], SortComparison.countFile(args[i]));
			double start1 = System.nanoTime();
			double[] sorted = SortComparison.insertionSort(a);
			double end1 = System.nanoTime();
			double ans = (end1 - start1) * (Math.pow (10, -6));
			System.out.println ("\n" + args[i] + "\n" + "insertion sort:" + ans + " ms");


			double[] b = SortComparison.read(args[i], SortComparison.countFile(args[i]));
			double start2 = System.nanoTime();
			double[] sorted1 = SortComparison.quickSort(b);
			double end2 = System.nanoTime();
			double answ = (end2 - start2) * (Math.pow (10, -6));
			System.out.println ("quick sort:" + answ  + " ms");

			double[] c = SortComparison.read(args[i], SortComparison.countFile(args[i]));
			double start3 = System.nanoTime();
			double[] sorted4 = SortComparison.mergeSortRecursive(c);
			double end3 = System.nanoTime();
			double answer1 = (end3 - start3) * (Math.pow (10, -6));
			System.out.println ("merge sort recursive:" + answer1  + " ms");

			double[] d = SortComparison.read(args[i], SortComparison.countFile(args[i]));
			double start4 = System.nanoTime();
			double[] sorted3 = SortComparison.mergeSortIterative(d);
			double end4 = System.nanoTime();
			double answer = (end4 - start4) * (Math.pow (10, -6));
			System.out.println ("merge sort iterative:" + answer  + " ms");


			double[] e = SortComparison.read(args[i], SortComparison.countFile(args[i]));
			double start5 = System.nanoTime();
			double[] sort = SortComparison.selectionSort(e);
			double end5 = System.nanoTime();
			double answe = (end5 - start5) * (Math.pow (10, -6));
			System.out.println ("selection sort:" + answe + " ms");




		} 
	} 

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	SortComparison testSort = new SortComparison();
    	double a[]=null;
    	double result[] = null;
    	result = testSort.insertionSort(a);
    	assertEquals("Insertion Sort Test if Empty",a,result);	
    	testSort.quickSort(a);
    	assertEquals("Quick Sort Test if Empty",a,result);		
    	result = testSort.mergeSortIterative(a);
    	assertEquals("Merge Sort Iterative if Empty",a,result);
    	result = testSort.mergeSortRecursive(a);
    	assertEquals("Merge Sort Recursive if Empty",a,result);
    	result = testSort.selectionSort(a);
    	assertEquals("Selection Sort if Empty",a,result);		
    }

    @SuppressWarnings("deprecation")
	@Test
    public void testInsertion() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[] result = new double[]{1518.63, 1522.08, 1735.31, 1934.75, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14};

        Assert.assertThat(SortComparison.insertionSort(a), IsEqual.equalTo(result) );
        //Assert.assertEquals("Insertion sort on 10 elements", SortComparison.insertionSort(a), IsEqual.equalTo(result));
        //assertEquals("Insertion sort on 10 elements",SortComparison.insertionSort(a), IsEqual.equalTo(result));
        //Assert.assertArrayEquals(SortComparison.insertionSort(a), IsEqual.equalTo(result));
        

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result = new double[]{131.11, 141.639, 381.004, 398.718, 401.409, 483.631, 777.565, 782.337, 869.318, 1018.14,
                1044.55, 1051.9, 1080.22, 1197.52, 1209.76, 1518.63, 1522.08, 1584.62, 1600.44, 1612.96, 1735.31, 1934.75,
                1942.31, 1961.97, 2092.05, 2121.29, 2203.51, 2345.15, 2543.55, 2652.57, 2724.57, 2742.11, 2765.55, 2910.66,
                3193.47, 3242.55, 3321.58, 3669.57, 3769.34, 3776.63, 3978.32, 4211.62, 4373.9, 4482.08, 4500.86, 4538.89,
                4659.33, 4672.51, 4829.45, 4849.83, 4917.36, 4918.37, 5015.19, 5029.31, 5105.3, 5347.12, 5593.97, 5673.94,
                5710.77, 5855.37, 5860.52, 5991.63, 6317.98, 6386.02, 6393.96, 6766.97, 6869.2, 6888.98, 7054.32, 7080.34,
                7163.23, 7201.84, 7202.92, 7319.42, 7598.96, 7695.48, 7788.8, 7984.93, 8106.23, 8351.59, 8386.34, 8458.14,
                8541.65, 8557.19, 8663.13, 8740.03, 8931.88, 8967.82, 8997.56, 9041.07, 9076.23, 9100.94, 9286.11, 9350.69,
                9363.01, 9443.28, 9456.25, 9466.56, 9955.53};

        Assert.assertThat("Selection sort on 100 elements", SortComparison.insertionSort(a), IsEqual.equalTo(result));

        //assertNull("Null when null passed on Insertion Sort", SortComparison.insertionSort(null));
    }
    
    @Test
    public void testQuickSort() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[] result = new double[]{1518.63, 1522.08, 1735.31, 1934.75, 2910.66, 4849.83, 5855.37, 8106.23, 8458.14};

        Assert.assertThat("QuickSort on 10 elements", SortComparison.quickSort(a), IsEqual.equalTo(result));

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result = new double[]{131.11, 141.639, 381.004, 398.718, 401.409, 483.631, 777.565, 782.337, 869.318, 1018.14,
                1044.55, 1051.9, 1080.22, 1197.52, 1209.76, 1518.63, 1522.08, 1584.62, 1600.44, 1612.96, 1735.31, 1934.75,
                1942.31, 1961.97, 2092.05, 2121.29, 2203.51, 2345.15, 2543.55, 2652.57, 2724.57, 2742.11, 2765.55, 2910.66,
                3193.47, 3242.55, 3321.58, 3669.57, 3769.34, 3776.63, 3978.32, 4211.62, 4373.9, 4482.08, 4500.86, 4538.89,
                4659.33, 4672.51, 4829.45, 4849.83, 4917.36, 4918.37, 5015.19, 5029.31, 5105.3, 5347.12, 5593.97, 5673.94,
                5710.77, 5855.37, 5860.52, 5991.63, 6317.98, 6386.02, 6393.96, 6766.97, 6869.2, 6888.98, 7054.32, 7080.34,
                7163.23, 7201.84, 7202.92, 7319.42, 7598.96, 7695.48, 7788.8, 7984.93, 8106.23, 8351.59, 8386.34, 8458.14,
                8541.65, 8557.19, 8663.13, 8740.03, 8931.88, 8967.82, 8997.56, 9041.07, 9076.23, 9100.94, 9286.11, 9350.69,
                9363.01, 9443.28, 9456.25, 9466.56, 9955.53};


        Assert.assertThat("QuickSort on 100 elements", SortComparison.quickSort(a), IsEqual.equalTo(result));

        //assertNull("Null when null passed on QuickSort", SortComparison.quickSort(null));
    }
    
    
    @Test
	public void testMergeSortIterative()
	{
		double[] test= {2,9,1,7,};
		double []expected = {1,2,7,9};
		double result[]=SortComparison.mergeSortIterative(test);
		Assert.assertThat(SortComparison.quickSort(test), IsEqual.equalTo(result));
	}
    
    public static long testSelection(double[] arr) {
		long result = 0;
		double[]cpy1=new double[arr.length];
		System.arraycopy(arr,0,cpy1,0,arr.length);
		double[]cpy2=new double[arr.length];
		System.arraycopy(arr,0,cpy2,0,arr.length);
		double[]cpy3=new double[arr.length];
		System.arraycopy(arr,0,cpy3,0,arr.length);
			long start1=System.currentTimeMillis();
			SortComparison.selectionSort(cpy1);
			long end1=System.currentTimeMillis();
			result+=(end1-start1);
			long start2=System.currentTimeMillis();
			SortComparison.selectionSort(cpy2);
			long end2=System.currentTimeMillis();
			result+=(end2-start2);
			long start3=System.currentTimeMillis();
			SortComparison.selectionSort(cpy3);
			long end3=System.currentTimeMillis();
			result+=(end3-start3);
		return (result/3);

	}
    @Test
    public void testMergeSortRecursive() {
    	double [] a = new double[] {679.45, 444.44, 5678.23, 5679.11};
    	double [] ans = new double[] {444.44, 679.45, 5678.23, 5679.11};
    	
    	Assert.assertThat("test recursive merge", SortComparison.mergeSortRecursive(a), IsEqual.equalTo(ans));
    
    } 

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    

}
