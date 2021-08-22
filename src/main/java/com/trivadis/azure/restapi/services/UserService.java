package com.trivadis.azure.restapi.services;


import com.trivadis.azure.restapi.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

/*    @Autowired
    private UserRepository userRepository;*/

    private static List<Person> personList = new ArrayList<>();
    private static long idCounter = 0;

    static {
        personList.add(new Person(++idCounter,"Mohammed Amine","Grioui","amine@"));
        personList.add(new Person(++idCounter,"Mohammed Amine","Grioui","amine@"));
        personList.add(new Person(++idCounter,"Mohammed Amine","Grioui","amine@"));
        personList.add(new Person(++idCounter,"Mohammed Amine","Grioui","amine@"));
    }


    public List<Person> getAllUsers(){
        return personList;
    }

    public Person saveUser(Person user){
        if (user.getId() == -1 || user.getId() == 0) {
            user.setId(++idCounter);
            personList.add(user);
        } else {
            deleteById(user.getId());
            personList.add(user);
        }
        return user;
    }

 /*   public Person getPerson(long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee Not exist with id "+id));
    }*/

/*    public Person updatePerson(long id, Person person){
        Person p=this.getPerson(id);
        p.setEmail(person.getEmail());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        return  this.saveUser(p);
    }*/

   /* public  void deleteById(Person person){
         userRepository.delete(person);
    }*/


  /*  public Person getPersonByFirstName(String name){
        return userRepository.findByFirstName(name);
    }*/
    public Person deleteById(long id) {
        Person person = findById(id);

        if (person == null)
            return null;

        if (personList.remove(person)) {
            return person;
        }

        return null;
    }

    public Person findById(long id) {
        for (Person course : personList) {
            if (course.getId() == id) {
                return course;
            }
        }

        return null;
    }
}
