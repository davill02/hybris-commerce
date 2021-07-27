package org.questions.service;

import org.questions.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionService {
    List<QuestionModel> getQuestionsAfter(Date date);
}
