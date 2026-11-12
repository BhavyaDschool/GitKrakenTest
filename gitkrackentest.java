import java.util.concurrent.*;
import java.util.*;
public class gitkrackentest {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        final int nums = 1000000000;
        int count = 0;
        		long startTime = System.currentTimeMillis();
        for (int number = 1; number <= nums; number++) {
            count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total numbers counted: " + count);
        long elapsedTime = endTime - startTime;
System.out.println("Time taken: " + elapsedTime + " milliseconds\n\n");
System.out.println("Now for the Multithread Method: ");
        multithreadMethod();
    }
    public static void multithreadMethod() throws InterruptedException, ExecutionException{
		int nums = 1000000000;
		int numthreads = 1000;
		int numsperthread = nums/numthreads;
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Integer>> futures = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numthreads; i++) {
		    final int start = (i * numsperthread) + 1;
		    final int end = (i + 1) * numsperthread;
		Callable<Integer> task = () -> {
			int count = 0;
			for (int number = start; number <= end; number++) {
			    count++;
		}
		return count;
		};
		Future<Integer> future = executor.submit(task);
		futures.add(future);
		}
		int total = 0;
		for (Future<Integer> future : futures) {
		    total += future.get();
		}
		long endTime = System.currentTimeMillis();
		executor.shutdown();
		System.out.println("Total numbers counted: " + total);
		long elapsedTime = endTime - startTime;
System.out.println("Time taken: " + elapsedTime + " milliseconds");

	}
}