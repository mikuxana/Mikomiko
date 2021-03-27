package cn.xana.controller;

import cn.xana.pojo.Comment;
import cn.xana.service.CommentService;
import cn.xana.utils.CommentRequest;
import cn.xana.utils.PageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private HttpSession session;

    @GetMapping("/query/")
    @ResponseBody
    public String selectComment(String aid, @RequestParam(defaultValue = "1") Integer page) throws JsonProcessingException {
        PageResult pageResult = commentService.selectComment(aid, page);
        return objectMapper.writeValueAsString(pageResult);
    }


    @GetMapping("/query/{aid}")
    public String qComment(@PathVariable String aid, @RequestParam(defaultValue = "1") Integer page, Model model){
        PageResult pageResult = commentService.selectComment(aid, page);
        model.addAttribute("res", pageResult);
        model.addAttribute("userInfo", session.getAttribute("userInfo"));
        return "iframe/comment.html";
    }

    @GetMapping("/add")
    @ResponseBody
    public Integer aComment(CommentRequest commentRequest){
        System.out.println(commentRequest);
        return commentService.addComment(commentRequest);
    }

    @GetMapping("/del")
    @ResponseBody
    public Integer dComment(CommentRequest commentRequest){
        return commentService.delComment(commentRequest);
    }
    @GetMapping("/star")
    @ResponseBody
    public void sComment(CommentRequest commentRequest){
        commentService.starComment(commentRequest);
    }
}
