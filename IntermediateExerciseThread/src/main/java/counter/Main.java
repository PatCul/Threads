package counter;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Random rand = new Random();
		int dim = 1000000;
		int[] array = new int[dim];
		
		for(int i=0; i<dim; i++) {
			array[i] = rand.nextInt(11);
		}
		
		Scanner scan = new Scanner(System.in);
		int nThreads = 0;
		System.out.println("Insert the number of threads that you want to use");
		nThreads = scan.nextInt();
		if(nThreads<=0) {
			System.out.println("Error with the number of Threads");
			scan.close();
			return;
		}
		
		int begin = 0;
		int end = dim/nThreads;
		int sum = 0;
		long before = System.currentTimeMillis();
		for(int i=0; i<nThreads; i++) {
			Count count = new Count(begin, end, array);
			Thread thread = new Thread(count);
			thread.start();
			begin = end;
			end += dim/nThreads;
			sum += count.getSum();
		}
		long after = System.currentTimeMillis();
		
		System.out.println("Time to calculate the average: " + (after-before) + " using " + nThreads + " threads");
		scan.close();
	}

}
