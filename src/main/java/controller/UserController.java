package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.UserServiseImpl;

import java.util.List;

@Controller
public class UserController {

    private final UserServiseImpl userServise;

    @Autowired
    public UserController(UserServiseImpl userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/users")
    public String getAllUser(Model model){
        List<User> user = userServise.getAllUsers();
        model.addAttribute("users", user);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String addUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String addUser(User user){
        userServise.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userServise.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model){
        User user = userServise.getById(id);
        model.addAttribute("user",user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userServise.updateUser(user);
        return "redirect:/users";
    }


}
