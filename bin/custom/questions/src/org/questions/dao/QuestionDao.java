package org.questions.dao;

import org.questions.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionDao {
    List<QuestionModel> getQuestionsCreatedAfter(Date date);
}
