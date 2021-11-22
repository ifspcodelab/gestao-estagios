package br.edu.ifsp.ifspcodelab.gestaoestagiosbackend.report;

import br.edu.ifsp.ifspcodelab.gestaoestagiosbackend.plan.ActivityPlan;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;

public interface MonthlyReportService {
    MonthlyReport create(LocalDate month, ActivityPlan activityPlan);
    MonthlyReport update(MonthlyReport monthlyReport);
    MonthlyReport sendAttachment(UUID internshipId, UUID monthlyReportId, MultipartFile file);
    MonthlyReport findById(UUID id);
}
