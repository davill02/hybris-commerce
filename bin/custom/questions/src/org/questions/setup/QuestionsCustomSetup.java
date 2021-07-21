package org.questions.setup;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import org.springframework.beans.factory.annotation.Required;

import java.io.InputStream;

@SystemSetup(extension = "questions")
public class QuestionsCustomSetup {
    private ImportService importService;

    @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
    public boolean customPriceGroupsSetup() {
        impexImport("questions/import/productCatalogs/apparelProductCatalog/pricegroups.impex");
        return true;
    }

    protected boolean impexImport(final String filename) {
        try (final InputStream resourceAsStream = getClass().getResourceAsStream(filename)) {
            final ImportConfig importConfig = new ImportConfig();
            importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
            importConfig.setLegacyMode(Boolean.FALSE);
            final ImportResult importResult = importService.importData(importConfig);
            if (importResult.isError()) {
                return false;
            }
        } catch (final Exception e) {
            return false;
        }
        return true;
    }

    @Required
    public void setImportService(ImportService importService) {
        this.importService = importService;
    }
}
