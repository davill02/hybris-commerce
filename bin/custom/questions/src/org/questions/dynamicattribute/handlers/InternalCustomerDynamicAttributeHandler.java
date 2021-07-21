package org.questions.dynamicattribute.handlers;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

public class InternalCustomerDynamicAttributeHandler implements DynamicAttributeHandler<Boolean, CustomerModel> {

    private static final String HYBRIS_INTERNAL_EMAILS_END_PART = "@hybris.com";

    @Override
    public Boolean get(CustomerModel model) {
        if (model.getContactEmail() == null) {
            return false;
        }
        return model.getContactEmail().endsWith(HYBRIS_INTERNAL_EMAILS_END_PART);
    }

    @Override
    public void set(CustomerModel model, Boolean aBoolean) {

    }
}
