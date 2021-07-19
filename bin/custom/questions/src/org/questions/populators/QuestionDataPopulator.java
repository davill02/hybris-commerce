package org.questions.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.questions.data.QuestionData;
import org.questions.model.QuestionModel;

public class QuestionDataPopulator implements Populator<QuestionModel, QuestionData> {

    @Override
    public void populate(QuestionModel questionModel, QuestionData questionData) throws ConversionException {
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setQuestionCustomerName(questionModel.getQuestionCustomer().getName());
        questionData.setAnswer(questionModel.getAnswer());
        if (questionModel.getAnswerCustomer() != null) {
            questionData.setAnswerCustomerName(questionModel.getAnswerCustomer().getName());
        }
    }
}
