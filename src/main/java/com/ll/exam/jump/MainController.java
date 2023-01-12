package com.ll.exam.jump;

import com.ll.exam.jump.question.entity.Question;
import com.ll.exam.jump.question.service.QuestionService;
import com.ll.exam.jump.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@RequiredArgsConstructor
@Controller
public class MainController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question/list";
    }
}
