package org.questions.service.impl;

import org.questions.dao.QuestionDao;
import org.questions.model.QuestionModel;
import org.questions.service.QuestionService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class DefaultQuestionService implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    @Override
    public List<QuestionModel> getQuestionsAfter(Date date) {
        return questionDao.getQuestionsCreatedAfter(date);
    }
}
