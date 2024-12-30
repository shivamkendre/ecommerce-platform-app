package com.project.ecommerceplatform.util;

import com.project.ecommerceplatform.exceptions.NoAuditDataAvailableException;
import com.project.ecommerceplatform.exceptions.ProductSaveException;
import com.project.ecommerceplatform.models.AuditData;
import com.project.ecommerceplatform.models.BaseModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditDataUtils {
    public void setCreationData(BaseModel model){
        AuditData auditData = new AuditData();
        auditData.setCreateDateTime(LocalDateTime.now());
        auditData.setCreatedBy("System User");
        model.setAuditData(auditData);
    }

    public void setUpdationData(BaseModel model) throws NoAuditDataAvailableException {
        AuditData auditData = model.getAuditData();
        if(auditData == null)
            throw new NoAuditDataAvailableException("audit data is null");
        auditData.setLastUpdateDate(LocalDateTime.now());
        auditData.setLastUpdatedBy("System User");
        model.setAuditData(auditData);
    }


}
