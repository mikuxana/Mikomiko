package cn.xana.controller;

import cn.xana.pojo.UpUser;
import cn.xana.pojo.User;
import cn.xana.service.UserService;
import cn.xana.utils.Page;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private HttpSession session;

    @RequestMapping("/user/{id}")
    public ModelAndView findById(@PathVariable("id") int id) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.html");
        User user = userService.findById(id);
        String userJson = objectMapper.writeValueAsString(user);
        modelAndView.addObject("user", user);
        System.out.println(user);
        return modelAndView;
    }

    @GetMapping("/user/findAll")
    @ResponseBody
    public String findAll() throws JsonProcessingException {
        List<User> userList = userService.findAll();

        String userListJson = objectMapper.writeValueAsString(userList);
        return userListJson;
    }


    @PostMapping("/user/login")
    @ResponseBody
    public String login(User user){

        User sel = userService.login(user.getUsername(), user.getPassword());
        if(sel!=null)
            session.setAttribute("userInfo", sel);
        return sel==null ? "0": "1";
    }

    @PostMapping("/user/signUp")
    @ResponseBody
    public String signUp(User user){
        System.out.println(user);
        Integer ins = userService.insert(user);
        if(ins>0)
            session.setAttribute("userInfo", user);
        return ins+"";
    }

    @GetMapping("/user/findUser")
    @ResponseBody
    public String findUser(User user){
        System.out.println(user);
        User userX = userService.findUser(user);
        return userX==null? "0": "1";
    }

    @GetMapping("/user/isLogin")
    @ResponseBody
    public String cherkLogin() throws JsonProcessingException {

        Object userInfo = session.getAttribute("userInfo");
        if(userInfo==null)
            return "";
        return objectMapper.writeValueAsString(userInfo);
    }

    @GetMapping(value="/user/findPage")
    @ResponseBody
    public String findPage(PageRequest pageQuery) throws JsonProcessingException {

        System.out.println(pageQuery);
        PageResult page = userService.selectPage(pageQuery);
        return objectMapper.writeValueAsString(page);
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "user/login.html";
    }
    @GetMapping("/signUp")
    public String signUp(Model model){
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "user/signUp.html";
    }

    @GetMapping("/logout")
    public String logout(){
        session.removeAttribute("userInfo");
        return "redirect:/";
    }

    @GetMapping("/up/{aid}")
    @ResponseBody
    public String selectUp(@PathVariable String aid) throws JsonProcessingException {
        System.out.println(aid);
        UpUser upUser = userService.selectByAid("bangumis", aid);
        return objectMapper.writeValueAsString(upUser);
    }
}
