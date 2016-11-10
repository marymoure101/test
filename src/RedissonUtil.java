import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;


public class RedissonUtil {
	//实现redisson实例共享
	public static RedissonClient redisson = null;
	
	static {
		Config config = new Config();
		config.useSingleServer().setAddress("127.0.0.1:6379");
		redisson = Redisson.create(config);
	}
	
	public static void destroy(){
		redisson.shutdown();
	}

}
