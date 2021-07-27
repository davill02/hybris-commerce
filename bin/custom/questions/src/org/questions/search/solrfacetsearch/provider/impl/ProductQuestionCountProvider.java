package org.questions.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ProductQuestionCountProvider extends AbstractPropertyFieldValueProvider implements Serializable, FieldValueProvider {

    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object obj) throws FieldValueProviderException {
        if (obj instanceof ProductModel) {
            int questionCount = (((ProductModel) obj).getQuestions() != null) ? ((ProductModel) obj).getQuestions().size() : 0;
            return createFieldValuesCollection(indexedProperty, questionCount);
        }
        return Collections.emptyList();
    }

    private Collection<FieldValue> createFieldValuesCollection(IndexedProperty indexedProperty, int questionCount) {
        final Collection<FieldValue> fieldValues = new ArrayList<>();
        Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, null);
        for (String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, questionCount));
        }
        return fieldValues;
    }

    @Required
    public void setFieldNameProvider(FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }
}
