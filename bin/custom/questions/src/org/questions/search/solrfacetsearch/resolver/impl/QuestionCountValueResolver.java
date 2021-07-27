package org.questions.search.solrfacetsearch.resolver.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.ValueResolver;

import java.util.Collection;

public class QuestionCountValueResolver implements ValueResolver<ProductModel> {
    @Override
    public void resolve(InputDocument inputDocument, IndexerBatchContext indexerBatchContext, Collection<IndexedProperty> collection,
                        ProductModel productModel) throws FieldValueProviderException {
        for (IndexedProperty indexedProperty : collection) {
            inputDocument.addField(indexedProperty, getQuestionCount(productModel));
        }
    }

    private int getQuestionCount(ProductModel productModel) {
        return productModel.getQuestions() == null ? 0 : productModel.getQuestions().size();
    }
}
