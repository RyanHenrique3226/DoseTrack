package com.ryan.DoseTrack.Service;

import com.ryan.DoseTrack.Model.MedicationManagement;
import com.ryan.DoseTrack.Model.MedicationModel;
import com.ryan.DoseTrack.Repository.MedicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    private final MedicationRepository repository;
    private final ManagementService service;

    public MedicationService(MedicationRepository repository, ManagementService service) {
        this.repository = repository;
        this.service = service;
    }

    public MedicationModel createMedication(MedicationModel medicationModel){
        medicationModel.setStartDate(LocalDate.now());
        medicationModel.setEndDate(LocalDate.now().plusDays(medicationModel.getTermDays() - 1));

        return repository.save(medicationModel);
    }

    public List<MedicationModel> findAll(){
        return repository.findAll();
    }

    public MedicationModel findById(int id){
        Optional<MedicationModel> medication = repository.findById(id);
        return medication.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication not found"));
    }

    @Transactional
    public void deleteById(int id){
        MedicationModel medicationModel = findById(id);
        service.deleteByMedicationId(id);
        repository.delete(medicationModel);
    }

    public MedicationModel updateById(int id, MedicationModel update){
        MedicationModel medicationModel = findById(id);

        medicationModel.setName(update.getName());
        medicationModel.setFrequency(update.getFrequency());
        medicationModel.setTermDays(update.getTermDays());
        medicationModel.setEndDate(LocalDate.now().plusDays(medicationModel.getTermDays() - 1));

        return repository.save(medicationModel);
    }

}
