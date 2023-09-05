package com.DocDB.controller;

import com.DocDB.entities.LabResult;
import com.DocDB.service.LabResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class LabResultController {

    private final LabResultService service;

    @RequestMapping(value = "/lab", method = RequestMethod.POST)
    public LabResult insertLabResult(@RequestBody LabResult labResult) {
        return service.createResult(labResult);
    }

    @RequestMapping(value = "/lab", method = RequestMethod.GET)
    public LabResult findByLabResultId(@RequestParam(value = "id") Long id) {
        return service.findResultById(id);
    }

    @GetMapping(value = "/results")
    public List<LabResult> findPatientResults(@RequestParam(value = "id") Long id) {
        return service.findPatientLabResultsBytPatientId(id);
    }

}
