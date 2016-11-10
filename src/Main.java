import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		final DistributedLock dl = new DistributedLock(RedissonUtil.redisson);
		final TaskInterface<?> task1 = new Task1();
		final TaskInterface<?> task2 = new Task2();
		final TaskInterface<?> task3 = new Task3();
		new Thread("m1"){
			public void run(){
				System.out.println("m1 get lock");
				dl.lock(task1, 10, TimeUnit.SECONDS);
				System.out.println("m1 get lock success");
			}
		}.start();
		
		new Thread("m2"){
			public void run(){
				System.out.println("m2 get lock");
				dl.lock(task2, 1, TimeUnit.SECONDS);
				System.out.println("m2 get lock success");
			}
		}.start();
		
		new Thread("m3"){
			public void run(){
				System.out.println("m3 get lock");
				dl.lock(task3, 10, TimeUnit.SECONDS);
				System.out.println("m3 get lock success");
			}
		}.start();
		
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RedissonUtil.destroy();

	}

}
