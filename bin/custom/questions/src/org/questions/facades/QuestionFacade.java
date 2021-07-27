package org.questions.facades;

import org.questions.data.EmailQuestionsData;

import java.util.Date;

public interface QuestionFacade {
    EmailQuestionsData getEmailQuestionsDataAfter(Date date);
}
