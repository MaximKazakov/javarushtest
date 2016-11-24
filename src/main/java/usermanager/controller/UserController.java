package usermanager.controller;

import usermanager.model.User;
import usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private UserService userService;

    private User filter = new User();


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listUsers(@ModelAttribute("filter") User f, Model model)
    {
        if (f.getName() != null)
            filter.setName(f.getName());

        model.addAttribute("filter", filter);

        model.addAttribute("listUsers", userService.listUsers(filter, 1));
        model.addAttribute("countPages", userService.countPages(filter));




        return "list";
    }

    @RequestMapping(value = "list/{id}", method = RequestMethod.GET)
    public String listUsers(@PathVariable("id") int id, @ModelAttribute("filter") User f, Model model)
    {
        if (f.getName() != null)
            filter.setName(f.getName());

        model.addAttribute("filter", filter);


        model.addAttribute("listUsers", userService.listUsers(filter, id));
        model.addAttribute("countPages", userService.countPages(filter));
        return "list";
    }


    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/list";
    }


    @RequestMapping(value = "addPage", method = RequestMethod.GET)
    public String addPage(Model model)
    {
        model.addAttribute("user", new User());
        return"/addPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user)
    {
        if (user.getId() == 0)
            userService.addUser(user);
        else
            userService.updateUser(user);

        return"redirect:/list";
    }

    @RequestMapping("editPage/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "/addPage";
    }



    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
