import java.util.concurrent.TimeUnit;


public interface DistributedLockTemplate {
	/**
	 * 使用默认超时时间
	 * 
	 * @param task
	 * @return
	 */
	public <T> T lock(TaskInterface<T> task);
	
	/**
	 * 使用自定义的超时时间
	 * 
	 * @param task
	 * @param leaseTime锁超时时间，超时后自动释放
	 * @param timeUnit
	 * @return
	 */
	public <T> T lock(TaskInterface<T> task,long leaseTime,TimeUnit timeUnit);

}
