package com.study.controller.cnu;

import com.study.domain.cnu.CnuPost;
import com.study.repository.mybatis.CnuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by rokim on 2016. 5. 15..
 */
@Controller
@RequestMapping("/post")
public class CnuPostController {
    @Value("${application.security.salt}") private String securityKey;
    CnuRepository cnuRepository;
    @RequestMapping("")
    public String index() {
    	List<CnuPost> cnuPostList = cnuRepository.selectCnuPostList();
        return "post/index";
    }

    @RequestMapping(value= "/write",method = RequestMethod.GET)
    public String write() {
        return "post/write";
    }
    @RequestMapping(value= "/write",method = RequestMethod.POST)
    public String doWrite(String title, String content, String author, String password) {
        CnuPost cnuPost = new CnuPost();
        cnuPost.setTitle(title);
        cnuPost.setAuthor(author);
        cnuPost.setContent(content);
        cnuPost.setPassword(password);
    	
    	
    	return "redirect:/post";
    }
    @RequestMapping("/view")
    public String view() {
        return "post/view";
    }
}
