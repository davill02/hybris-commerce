package org.questions.populators;

import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.commercefacades.product.data.ProductData;


public class SearchResultProductQuestionCountPopulator implements Populator<SearchResultValueData, ProductData> {
    @Override
    public void populate(SearchResultValueData searchResultValueData, ProductData productData) throws ConversionException {
        Integer questionCount = (Integer) searchResultValueData.getValues().getOrDefault("questionCount", 0);
        productData.setQuestionCount(questionCount);
    }
}
