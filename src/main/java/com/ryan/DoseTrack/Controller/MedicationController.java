package com.ryan.DoseTrack.Controller;

import com.ryan.DoseTrack.Model.MedicationModel;
import com.ryan.DoseTrack.Service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService service;

    public MedicationController(MedicationService service){this.service = service;}

    @PostMapping
    public ResponseEntity<MedicationModel> createMedication(@RequestBody MedicationModel medicationModel){
        MedicationModel create = service.createMedication(medicationModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @GetMapping
    public List<MedicationModel> getAllMedications(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationModel> getById(@PathVariable int id){
        MedicationModel medicationModel = service.findById(id);
        return ResponseEntity.ok(medicationModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById2(@PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationModel> updateById(@PathVariable int id, @RequestBody MedicationModel update){
        MedicationModel medicationModel = service.updateById(id, update);
        return ResponseEntity.ok().body(medicationModel);
    }

}
