package exam.redis.execute.crud;

import org.springframework.stereotype.Service;

@Service
public class RepositorySave {

  private final PersonRepository person;

  public RepositorySave(PersonRepository person) {
    this.person = person;
  }

  public void savePerson(Person person) {
    this.person.save(person);
  }
}
