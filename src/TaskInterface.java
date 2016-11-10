
public interface TaskInterface<T> {
	/**
	 * 需要加分布式锁的业务逻辑 
	 * 
	 * @return
	 */
	public T task();
	
    /**
     * 得到分布式锁名称 
     * 
     * @return
     */
	public String getLockName();

}
