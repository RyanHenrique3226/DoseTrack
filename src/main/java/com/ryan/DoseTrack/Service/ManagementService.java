package com.ryan.DoseTrack.Service;

import com.ryan.DoseTrack.Model.MedicationManagement;
import com.ryan.DoseTrack.Model.MedicationModel;
import com.ryan.DoseTrack.Repository.ManagementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ManagementService {

    private final ManagementRepository repository;
    private final MedicationService service;

    public ManagementService(ManagementRepository repository, MedicationService service) {
        this.repository = repository;
        this.service = service;
    }

    public void markAsTaken(int id){
        MedicationModel medication =  service.findById(id);

        if (!service.isMedicationDay(medication)){
            throw new RuntimeException("Today is not the day to take that medication.");
        }

        LocalDate today = LocalDate.now();

        Optional<MedicationManagement> existing = repository.findByMedicationModelAndDate(medication, today);

        if (existing.isPresent()){
            MedicationManagement management = existing.get();
            management.setStatus(true);
            repository.save(management);
        }else {
            MedicationManagement management = new MedicationManagement();
            management.setMedicationModel(medication);
            management.setDate(today);
            management.setStatus(true);
            repository.save(management);
        }
    }

    public boolean wasTaken(MedicationModel model){
        LocalDate today = LocalDate.now();
        Optional<MedicationManagement> existing = repository.findByMedicationModelAndDate(model, today);
        return existing.isPresent() && existing.get().isStatus();
    }

}
