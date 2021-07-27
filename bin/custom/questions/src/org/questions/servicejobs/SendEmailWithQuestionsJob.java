package org.questions.servicejobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.commons.lang.StringUtils;
import org.questions.model.SendEmailWithNewQuestionsCronJobModel;
import org.questions.model.processengine.SendQuestionEmailProcessModel;

import javax.annotation.Resource;

public class SendEmailWithQuestionsJob extends AbstractJobPerformable<SendEmailWithNewQuestionsCronJobModel> {
    @Resource
    private BusinessProcessService businessProcessService;

    @Override
    public PerformResult perform(SendEmailWithNewQuestionsCronJobModel sendEmailQuestionCronJobModel) {
        try {
            validateEmail(sendEmailQuestionCronJobModel);
            SendQuestionEmailProcessModel sendQuestionsProcessModel = businessProcessService.createProcess("SendQuestions-" + System.currentTimeMillis(), "sendQuestionEmailProcess");
            sendQuestionsProcessModel.setEmail(sendEmailQuestionCronJobModel.getEmail());
            sendQuestionsProcessModel.setSite(sendEmailQuestionCronJobModel.getBaseSite());
            sendQuestionsProcessModel.setLanguage(sendEmailQuestionCronJobModel.getBaseSite().getDefaultLanguage());
            sendQuestionsProcessModel.setDateBound(sendEmailQuestionCronJobModel.getLastExecutionTime());
            sendEmailQuestionCronJobModel.setEmail("");
            sendEmailQuestionCronJobModel.setLastExecutionTime(sendEmailQuestionCronJobModel.getStartTime());
            businessProcessService.startProcess(sendQuestionsProcessModel);
            modelService.save(sendEmailQuestionCronJobModel);
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        } catch (IllegalArgumentException exception) {
            return new PerformResult(CronJobResult.ERROR, CronJobStatus.FINISHED);
        }
    }

    private void validateEmail(SendEmailWithNewQuestionsCronJobModel sendEmailQuestionCronJobModel) {
        if (StringUtils.isBlank(sendEmailQuestionCronJobModel.getEmail())) {
            throw new IllegalArgumentException("E-mail is empty");
        }
    }
}
