package org.questions.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.questions.dao.QuestionDao;
import org.questions.model.QuestionModel;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class DefaultQuestionDao implements QuestionDao {
    @Resource
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<QuestionModel> getQuestionsCreatedAfter(Date date) {
        final String queryString = //
                "SELECT {p:" + QuestionModel.PK + "}"
                        + "FROM {" + QuestionModel._TYPECODE + " AS p} "
                        + "WHERE " + "{p:" + QuestionModel.CREATIONTIME + "}>=?date ";
        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(queryString);
        flexibleSearchQuery.addQueryParameter("date", date);
        return flexibleSearchService.<QuestionModel>search(flexibleSearchQuery).getResult();
    }

}
