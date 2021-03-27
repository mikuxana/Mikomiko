package cn.xana.controller;
import cn.xana.pojo.Bangumi;
import cn.xana.pojo.Statistic;
import cn.xana.service.ACGService;
import cn.xana.service.BangumiService;
import cn.xana.service.StatisticService;
import cn.xana.service.UserService;
import cn.xana.utils.BangumiRequest;
import cn.xana.utils.PageRequest;
import cn.xana.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bangumi")
public class BangumiController {

    @Autowired
    private BangumiService bangumiService;
    @Autowired
    private PageRequest pageRequest;
    @Autowired
    private HttpSession session;
    @Autowired
    private StatisticService statisticService;
    @Autowired
    private UserService userService;
    @Autowired
    private ACGService acgService;

    @GetMapping({"/{id}", "/{id}/{cv}"})
    public String selectById(@PathVariable String id, @PathVariable(required = false) String cv, Model model){
        Bangumi bangumi = bangumiService.selectById(id);
        Statistic statistic = statisticService.selectByid(id);
        model.addAttribute("sta", statistic);
        model.addAttribute("res", bangumi);
        model.addAttribute("cv", cv);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        model.addAttribute("upUser", userService.selectByAid("bangumis", id));
        model.addAttribute("acgList", acgService.selectBangumi(30));
        return "cv.html";
    }

    @GetMapping({"", "/"})
    public String select(BangumiRequest bangumiRequest, @RequestParam(defaultValue = "1") Integer page, Model model){
        pageRequest.setPageNum(page);
        PageResult pageResult = bangumiService.selectPage(bangumiRequest, pageRequest);
        model.addAttribute("res", pageResult);
        model.addAttribute("req", bangumiRequest);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "bangumi.html";
    }
}
