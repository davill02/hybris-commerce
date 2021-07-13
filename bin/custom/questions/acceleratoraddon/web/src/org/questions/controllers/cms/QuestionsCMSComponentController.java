package org.questions.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.questions.data.QuestionData;
import org.questions.facades.ProductWithQuestionsFacade;
import org.questions.model.components.QuestionsCMSComponentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value = "/view/QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
    @Resource
    private ProductWithQuestionsFacade productWithQuestionsFacade;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        model.addAttribute("fontSize", component.getFontSize());
        String productCode = (String) request.getAttribute("productCode");
        List<QuestionData> questions = productWithQuestionsFacade.getProductDataWithQuestions(productCode).getQuestions();
        int countQuestions = getCountOfQuestions(component, questions);
        model.addAttribute("questions", questions.subList(0, countQuestions));
        model.addAttribute("countQuestions", countQuestions);
    }

    private int getCountOfQuestions(QuestionsCMSComponentModel component, List<QuestionData> questions) {
        return (component.getNumberOfQuestionsToShow() > questions.size()) ? questions.size() : component.getNumberOfQuestionsToShow();
    }
}
