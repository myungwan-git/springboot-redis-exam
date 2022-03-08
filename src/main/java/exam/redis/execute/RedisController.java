package exam.redis.execute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RedisController {

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @PostMapping("/redis-post")
  public ResponseEntity<?> addRedisKey() {
    log.info(">>> redis add Key AND Value !");

    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    valueOperations.set("name", "KMW");
    valueOperations.set("age", "30");
    valueOperations.set("location", "Seoul");
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/redis-get/{key}")
  public ResponseEntity<?> getRedisValue(@PathVariable String key) {
    log.info(">>> redis get Value for Key({}) !", key);

    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    String value = valueOperations.get(key);
    return new ResponseEntity<>(value, HttpStatus.OK);
  }
}
