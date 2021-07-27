package org.questions.facades;

import org.questions.data.EmailQuestionData;
import org.questions.data.EmailQuestionsData;
import org.questions.model.QuestionModel;
import org.questions.service.QuestionService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultQuestionFacade implements QuestionFacade {
    @Resource
    private QuestionService questionService;

    @Override
    public EmailQuestionsData getEmailQuestionsDataAfter(Date date) {
        EmailQuestionsData emailQuestionsData = new EmailQuestionsData();
        List<EmailQuestionData> emailQuestionDataList = questionService.getQuestionsAfter(date).stream()
                .map(this::createEmailQuestionData).collect(Collectors.toList());
        emailQuestionsData.setQuestions(emailQuestionDataList);
        return emailQuestionsData;
    }

    private EmailQuestionData createEmailQuestionData(QuestionModel questionModel) {
        EmailQuestionData emailQuestionData = new EmailQuestionData();
        emailQuestionData.setQuestion(questionModel.getQuestion());
        emailQuestionData.setAnswer(questionModel.getAnswer());
        emailQuestionData.setQuestionCode(questionModel.getCode());
        emailQuestionData.setProductCode(questionModel.getProduct().getCode());
        return emailQuestionData;
    }
}
