package ServiceImpl;

import Entity.SeeUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import Service.RedisBaiseTakes;
import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Component("seeUserRedisTakes")
public class SeeUserRedisTakes implements RedisBaiseTakes<String,String,SeeUser>{
    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(SeeUserRedisTakes.class));

    public void add(String key, String value) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForValue().set(key,value);
        }
    }

    public void addObj(String objectKey, String key, SeeUser object) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForHash().put(objectKey,key,object);
        }
    }

    public void delete(String key) {

    }

    public void delete(List<String> listKeys) {

    }

    public void deletObj(String objecyKey, String key) {

    }

    public void update(String key, String value) {

    }

    public void updateObj(String objectKey, String key, SeeUser object) {

    }

    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    public SeeUser getObj(String objectKey, String key) {
        SeeUser seeUser = (SeeUser) redisTemplate.opsForHash().get(objectKey,key);
        return seeUser;
    }
}
