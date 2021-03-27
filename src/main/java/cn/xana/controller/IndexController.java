package cn.xana.controller;

import cn.xana.pojo.ACGRec;
import cn.xana.service.ACGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private ACGService acgService;
    @Autowired
    private HttpSession session;


    @GetMapping({"/", "/index"})
    public String index(Model model){
        List<ACGRec> hot = acgService.selectBangumi(15);
        List<ACGRec> bangumi = acgService.selectBangumiLatest(8);
        List<ACGRec> game = acgService.selectGame(8);
        model.addAttribute("hot", hot);
        model.addAttribute("bangumi", bangumi);
        model.addAttribute("game", game);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "index.html";
    }
}
