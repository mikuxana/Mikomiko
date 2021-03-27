package cn.xana.controller;


import cn.xana.pojo.Game;
import cn.xana.pojo.User;
import cn.xana.service.BangumiService;
import cn.xana.service.GameService;
import cn.xana.service.UserService;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private BangumiService bangumiService;
    @Autowired
    private GameService gameService;
    @Autowired
    private HttpSession session;

    @GetMapping({"/game"})
    public String game(@RequestParam(defaultValue = "") String key, @RequestParam(defaultValue = "1") Integer page, Model model){
        PageResult pageResult = gameService.selectByKey(key, page);
        model.addAttribute("res", pageResult);
        model.addAttribute("key", key);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "search/galgame.html";
    }

    @GetMapping({"/bangumi"})
    public String bangumi(@RequestParam(defaultValue = "") String key, @RequestParam(defaultValue = "1") Integer page, Model model){
        PageResult pageResult = bangumiService.selectByKey(key, page);
        model.addAttribute("res", pageResult);
        model.addAttribute("key", key);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "search/bangumi.html";
    }

}
