package org.questions.facades;

import org.questions.data.ProductData;

public interface ProductWithQuestionsFacade {
    ProductData getProductDataWithQuestions(String productCode);
}
