package cn.xana.controller;
import cn.xana.pojo.Game;
import cn.xana.service.*;
import cn.xana.utils.PageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private HttpSession session;
    @Autowired
    private ImgService imgService;
    @Autowired
    private ACGService acgService;
    @Autowired
    private UserService userService;
    @Autowired
    private StatisticService statisticService;

    @Autowired
    private ObjectMapper objectMapper;


/*    @GetMapping({"/tag/{tag}", "/key/{key}"})
    public String selelectByKey(@PathVariable(required = false) String tag, @PathVariable(required = false) String key, @RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("res", gameService.selectPage(tag, key, page));
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "galgame.html";
    }
    */
    @GetMapping("/tag/{tag}")
    public String selelectByTag(@PathVariable String tag, @RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("res", gameService.selectByKey(tag, page));
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "galgame.html";
    }
    @GetMapping("/key/{key}")
    public String selelectByKey(@PathVariable String key, @RequestParam(defaultValue = "1") Integer page, Model model){
        model.addAttribute("res", gameService.selectByKey(key, page));
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "galgame.html";
    }

    @GetMapping({"", "/"})
    public String select(@RequestParam(defaultValue = "1") Integer page, Model model){
        PageResult pageResult = gameService.select(page);
        model.addAttribute("res", pageResult);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "galgame.html";
    }

    @GetMapping("/gal/{id}")
    @ResponseBody
    public String selectById(@PathVariable("id") String id, Model model) throws JsonProcessingException {
        Game game = gameService.selectById(id);
        List<String> imgList = imgService.selectByAid(id);
        model.addAttribute("res", game);
        model.addAttribute("imgList", imgList);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        model.addAttribute("acgList", acgService.selectGame(30));
        model.addAttribute("upUser", userService.selectByAid("games", id));
        model.addAttribute("sta", statisticService.selectByid(id));
//        return "gal.html";
        return objectMapper.writeValueAsString(imgList);
    }
}
