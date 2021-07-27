package org.questions.facades.process.email.context;

import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.questions.data.EmailQuestionData;
import org.questions.facades.QuestionFacade;
import org.questions.model.processengine.SendQuestionEmailProcessModel;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsSendEmailContext extends AbstractEmailContext<SendQuestionEmailProcessModel> {
    public static final String QUESTIONS = "questions";

    @Resource
    private QuestionFacade questionFacade;

    @Override
    protected BaseSiteModel getSite(SendQuestionEmailProcessModel businessProcessModel) {
        put(EMAIL, businessProcessModel.getEmail());
        put(DISPLAY_NAME, businessProcessModel.getEmail());
        put(QUESTIONS, getEmailQuestionDataList(businessProcessModel));
        return businessProcessModel.getSite();
    }

    private List<EmailQuestionData> getEmailQuestionDataList(SendQuestionEmailProcessModel businessProcessModel) {
        return questionFacade.getEmailQuestionsDataAfter(businessProcessModel.getDateBound())
                .getQuestions().stream()
                .sorted(Comparator.comparing(EmailQuestionData::getProductCode))
                .collect(Collectors.toList());
    }

    @Override
    protected CustomerModel getCustomer(SendQuestionEmailProcessModel businessProcessModel) {
        return null;
    }

    @Override
    protected LanguageModel getEmailLanguage(SendQuestionEmailProcessModel businessProcessModel) {
        return null;
    }
}
