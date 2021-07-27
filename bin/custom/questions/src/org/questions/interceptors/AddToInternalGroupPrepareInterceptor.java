package org.questions.interceptors;

import de.hybris.platform.core.model.security.PrincipalGroupModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.user.daos.UserGroupDao;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashSet;
import java.util.Set;

public class AddToInternalGroupPrepareInterceptor implements PrepareInterceptor<CustomerModel> {
    public static final String INTERNAL_GROUP_UID = "internalgroup";

    private UserGroupDao userGroupDao;

    @Override
    public void onPrepare(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        PrincipalGroupModel internalGroup = userGroupDao.findUserGroupByUid(INTERNAL_GROUP_UID);
        if (Boolean.TRUE.equals(customerModel.getInternal())) {
            addGroupIfNotContains(customerModel, internalGroup);
        } else {
            removeGroupIfContains(customerModel, internalGroup);
        }
    }

    private void removeGroupIfContains(CustomerModel customerModel, PrincipalGroupModel internalGroup) {
        if (customerModel.getGroups().contains(internalGroup)) {
            final Set<PrincipalGroupModel> customerGroups = new HashSet<>(customerModel.getGroups());
            customerGroups.remove(internalGroup);
            customerModel.setGroups(customerGroups);
        }
    }

    private void addGroupIfNotContains(CustomerModel customerModel, PrincipalGroupModel internalGroup) {
        if (!customerModel.getGroups().contains(internalGroup)) {
            final Set<PrincipalGroupModel> customerGroups = new HashSet<>(customerModel.getGroups());
            customerGroups.add(internalGroup);
            customerModel.setGroups(customerGroups);
        }
    }

    @Required
    public void setUserGroupDao(UserGroupDao userGroupDao) {
        this.userGroupDao = userGroupDao;
    }
}
