package org.questions.populators;


import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.commercefacades.product.data.ProductData;

public class ProductQuestionCountPopulator implements Populator<ProductModel, ProductData> {
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        if (productModel.getQuestions() != null) {
            productData.setQuestionCount(productModel.getQuestions().size());
        } else {
            productData.setQuestionCount(0);
        }
    }
}
