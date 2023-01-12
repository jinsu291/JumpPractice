package com.ll.exam.jump.answer.service;

import com.ll.exam.jump.answer.entity.Answer;
import com.ll.exam.jump.answer.repository.AnswerRepository;
import com.ll.exam.jump.question.entity.Question;
import com.ll.exam.jump.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    // 답변 저장하기
    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
    }
}