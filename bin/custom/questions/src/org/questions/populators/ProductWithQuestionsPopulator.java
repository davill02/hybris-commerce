package org.questions.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.questions.data.ProductData;
import org.questions.data.QuestionData;
import org.questions.model.QuestionModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ProductWithQuestionsPopulator implements Populator<ProductModel, ProductData> {
    private Converter<QuestionModel, QuestionData> questionDataConverter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        List<QuestionData> questionsData = questionDataConverter.convertAll(productModel.getQuestions());
        productData.setQuestions(questionsData);
    }

    @Required
    public void setQuestionDataConverter(Converter<QuestionModel, QuestionData> questionDataConverter) {
        this.questionDataConverter = questionDataConverter;
    }
}
