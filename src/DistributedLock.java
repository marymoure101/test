import java.util.concurrent.TimeUnit;

import org.redisson.RedissonClient;
import org.redisson.core.RLock;


public class DistributedLock implements DistributedLockTemplate{
	private long defaultLeaseTime = 5;
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	private RedissonClient redisson;
	
	public DistributedLock(){
		
	}
	
	public DistributedLock(RedissonClient redisson){
		this.redisson = redisson;
	}
	
	@Override
	public <T> T lock(TaskInterface<T> task) {
		return lock(task,defaultLeaseTime,timeUnit);
	}
	
	@Override
	public <T> T lock(TaskInterface<T> task, long leaseTime, TimeUnit timeUnit) {
		RLock lock = null;
//		try{
			lock = redisson.getLock(task.getLockName());
			lock.lock(leaseTime, timeUnit);
			System.out.println(Thread.currentThread().getName()+"  lock");
			return task.task();
//		}finally{
//			if(lock!=null){
//				lock.unlock();
//			}
//		}
	}
	
	public void setRedisson(RedissonClient redisson){
		this.redisson = redisson;
	}

}
