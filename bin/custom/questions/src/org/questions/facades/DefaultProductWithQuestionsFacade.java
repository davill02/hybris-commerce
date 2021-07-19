package org.questions.facades;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.questions.data.ProductData;

import javax.annotation.Resource;

public class DefaultProductWithQuestionsFacade implements ProductWithQuestionsFacade {
    @Resource
    private ProductService productService;
    @Resource
    private Converter<ProductModel, ProductData> productWithQuestionsConverter;

    @Override
    public ProductData getProductDataWithQuestions(String productCode) {
        ProductModel productModel = productService.getProductForCode(productCode);
        return productWithQuestionsConverter.convert(productModel);
    }
}
