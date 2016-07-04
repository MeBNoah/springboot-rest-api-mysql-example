package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BlaUser")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String firstname;
  private String lastname;
  private int age;

  public User(){}
  
  public User(String firstname, String lastname, int age){
    this.firstname = firstname;
    this.lastname = lastname;
    this.age = age;
  }
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
