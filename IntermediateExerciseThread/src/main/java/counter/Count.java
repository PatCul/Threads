package counter;

public class Count implements Runnable{
	
	private int begin = 0;
	private int end = 0;
	private int[] array = null;
	private int sum = 0;
	
	public Count(int begin, int end, int[] array) {
		this.begin = begin;
		this.end = end;
		this.array = array;
	}
	
	public void run() {
		for(int i=begin; i<end; i++) {
			sum += array[i];
		}
	}
	
	public int getSum() {
		return sum;
	}
}
