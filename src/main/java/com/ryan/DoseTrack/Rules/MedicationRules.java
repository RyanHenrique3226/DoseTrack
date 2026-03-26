package com.ryan.DoseTrack.Rules;

import com.ryan.DoseTrack.Model.MedicationModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class MedicationRules {

    public boolean isMedicationDay(MedicationModel model){
        LocalDate today = LocalDate.now();
        long validation = ChronoUnit.DAYS.between(model.getStartDate(), today);

        if (today.isBefore(model.getStartDate()) || today.isAfter(model.getEndDate())){
            return false;
        }

        return validation % model.getFrequency() == 0;
    }


}
