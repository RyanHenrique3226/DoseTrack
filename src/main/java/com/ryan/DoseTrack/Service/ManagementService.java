package com.ryan.DoseTrack.Service;

import com.ryan.DoseTrack.Model.MedicationManagement;
import com.ryan.DoseTrack.Model.MedicationModel;
import com.ryan.DoseTrack.Repository.ManagementRepository;
import com.ryan.DoseTrack.Repository.MedicationRepository;
import com.ryan.DoseTrack.Rules.MedicationRules;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ManagementService {

    private final ManagementRepository repository;
    private final MedicationRules rules;
    private final MedicationRepository medicationRepository;

    public ManagementService(ManagementRepository repository, MedicationRules rules, MedicationRepository medicationRepository) {
        this.repository = repository;
        this.rules = rules;
        this.medicationRepository = medicationRepository;
    }

    public void markAsTaken(int id){
        MedicationModel medication =  medicationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication Not Found"));

        if (!rules.isMedicationDay(medication)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Today is not the day to take that medication.");
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

    public void deleteByMedicationId(long id){
        repository.deleteByMedicationModelId(id);
    }

    public boolean wasTaken(MedicationModel model){
        LocalDate today = LocalDate.now();
        Optional<MedicationManagement> existing = repository.findByMedicationModelAndDate(model, today);
        return existing.isPresent() && existing.get().isStatus();
    }

}
