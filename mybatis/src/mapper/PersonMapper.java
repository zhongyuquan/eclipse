package mapper;



import java.util.List;

import mybatis.Person;

public interface PersonMapper {
	Person queryPerson(Person person);
	int addPerson(Person person);
	int updatePersonByname(Person person);
	int DeletePersonByname(String name);
	List<Person> queryAllPerson();
}
