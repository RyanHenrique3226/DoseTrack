package com.ryan.DoseTrack.Scheduler;

import com.ryan.DoseTrack.Model.MedicationModel;
import com.ryan.DoseTrack.Rules.MedicationRules;
import com.ryan.DoseTrack.Service.ManagementService;
import com.ryan.DoseTrack.Service.MedicationService;
import com.ryan.DoseTrack.Service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicationScheduler {

    private final ManagementService managementService;
    private final MedicationService medicationService;
    private final NotificationService notificationService;
    private final MedicationRules rules;

    public MedicationScheduler(ManagementService managementService, MedicationService medicationService, NotificationService notificationService, MedicationRules rules) {
        this.managementService = managementService;
        this.medicationService = medicationService;
        this.notificationService = notificationService;
        this.rules = rules;
    }

    @Scheduled(cron = "0 0 8-20 * * *", zone = "America/Recife")
    public void checkMedications() {
        List<MedicationModel> medications =  medicationService.findAll();
        for (MedicationModel medicationModel : medications) {
            boolean isToday = rules.isMedicationDay(medicationModel);
            boolean wasTaken = managementService.wasTaken(medicationModel);
            if (isToday && !wasTaken) {
                notificationService.create("Time to take: " + medicationModel.getName());
            }
        }
    }

}
