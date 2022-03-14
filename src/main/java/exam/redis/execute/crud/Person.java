package exam.redis.execute.crud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@RedisHash("person-data")
public class Person {

  @Id
  private String name;

  private int age;
  private String home;
  private String company;

}
