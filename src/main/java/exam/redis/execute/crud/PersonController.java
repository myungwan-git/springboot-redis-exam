package exam.redis.execute.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class PersonController {
  //  private Person person;
//
//  public PersonController(Person person) {
//    this.person = person;
//  }
  private final RepositorySave repositorySave;

  public PersonController(RepositorySave repositorySave) {
    this.repositorySave = repositorySave;
  }

  @ResponseBody
  @PostMapping("/save")
  public String save() {
    Person person = new Person();
    person.setName("KMW");
    person.setAge(30);
    person.setCompany("YES");
    person.setHome("Seoul");

    log.info(">>> Redis -> save person. name={}, age={}, company={}, home={}",
        person.getName(), person.getAge(), person.getCompany(), person.getHome());

    repositorySave.savePerson(person);

    return "OK";
  }
}
