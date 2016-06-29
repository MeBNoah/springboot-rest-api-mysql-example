package app.controller;

import app.model.User;
import app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private BookRepository userRepository;
  
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createUser(@RequestBody Map<String, Object> userMap){
    User user = new User(userMap.get("firstname").toString(), userMap.get("lastname").toString(), (Integer) userMap.get("age"));
    
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("message", "User created successfully");
    response.put("user", userRepository.save(user));
    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{userId}")
  public User getUserDetails(@PathVariable("userId") Long userId){
    return userRepository.findOne(userId);
  }

  @RequestMapping(method = RequestMethod.PUT, value="/{userId}")
  public Map<String, Object> editUser(@PathVariable("userId") Long bookId, @RequestBody Map<String, Object> userMap){
    User user = new User(userMap.get("firstname").toString(), userMap.get("firstname").toString(), (Integer) userMap.get("age"));
    user.setId(bookId);

    Map<String, Object> response = new LinkedHashMap<>();
    response.put("message", "User Updated successfully");
    response.put("user", userRepository.save(user));
    return response;
  }

  @RequestMapping(method = RequestMethod.DELETE, value="/{userId}")
  public Map<String, String> deleteUser(@PathVariable("userId") Long userId){
    userRepository.delete(userId);
    Map<String, String> response = new HashMap<>();
    response.put("message", "User deleted successfully");
    
    return response;
  }
  
  @RequestMapping(method = RequestMethod.GET)
  public Map<String, Object> getAllUsers(){
    List<User> users = (List<User>) userRepository.findAll();
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("totalUsers", users.size());
    response.put("users", users);
    return response;
  }
}
