package com.mocker.interview.controller;

import com.mocker.interview.model.Candidate;
import com.mocker.interview.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<Object> addCandidate(@RequestBody Candidate candidate)
    {
        System.out.println("In POST");
        Candidate candidateAdded=candidateService.addCandidate(candidate);
        return new ResponseEntity<>(candidateAdded, HttpStatus.OK);
    }

    @PutMapping("/update/{candidateId}")
    public ResponseEntity<Object> updateCandidate(@PathVariable String candidateId,@RequestBody Candidate candidate)
    {
        System.out.println("In UPDATE");
        Candidate candidateAdded=candidateService.updateCandidate(Integer.valueOf(candidateId), candidate);
        return new ResponseEntity<>(candidateAdded, HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public ResponseEntity<Object> getCandidate()
    {
        System.out.println("In GET");
        List<Candidate> candidateList=candidateService.findAllCandidate();
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }

    @GetMapping("/find/{candidateId}")
    public ResponseEntity<Object> getCandidate(@PathVariable String candidateId)
    {
        System.out.println("In GET BY ID");
        Candidate candidate=candidateService.findCandidateById(Integer.valueOf(candidateId));
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{candidateId}")
    public ResponseEntity<Object> deleteCandidate(@PathVariable String candidateId)
    {
        System.out.println("In DELETE");
        Candidate deletedcandidate=candidateService.deleteCandidate(Integer.valueOf(candidateId));
        return new ResponseEntity<>(deletedcandidate, HttpStatus.OK);
    }
}
