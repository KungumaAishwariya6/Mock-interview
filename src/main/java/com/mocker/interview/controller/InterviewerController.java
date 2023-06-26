package com.mocker.interview.controller;

import com.mocker.interview.model.Interviewer;
import com.mocker.interview.service.InterviewerService;
import org.hibernate.dialect.pagination.SQLServer2005LimitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/interviewer")
public class InterviewerController {

    @Autowired
    private InterviewerService interviewerService;

    @PostMapping("/add")
    public ResponseEntity<Object> addInterviewer(@RequestBody Interviewer interviewer)
    {
        System.out.println("In POST");
        Interviewer interviewerAdded=interviewerService.addInterviewer(interviewer);
        return new ResponseEntity<>(interviewerAdded, HttpStatus.OK);
    }

    @PutMapping("/update/{interviewerId}")
    public ResponseEntity<Object> updateInterviewer(@PathVariable String interviewerId,@RequestBody Interviewer interviewer)
    {
        System.out.println("In UPDATE");
        Interviewer interviewerAdded=interviewerService.updateInterviewer(Integer.valueOf(interviewerId), interviewer);
        return new ResponseEntity<>(interviewerAdded, HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public ResponseEntity<Object> getInterviewer()
    {
        System.out.println("In GET");
        List<Interviewer> interviewerList=interviewerService.findAllInterviewer();
        return new ResponseEntity<>(interviewerList, HttpStatus.OK);
    }

    @GetMapping("/find/{interviewerId}")
    public ResponseEntity<Object> getInterviewer(@PathVariable String interviewerId)
    {
        System.out.println("In GET BY ID");
        Interviewer interviewer=interviewerService.findInterviewerById(Integer.valueOf(interviewerId));
        return new ResponseEntity<>(interviewer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{interviewerId}")
    public ResponseEntity<Object> deleteInterviewer(@PathVariable String interviewerId)
    {
        System.out.println("In DELETE");
        Interviewer deletedinterviewer=interviewerService.deleteInterviewer(Integer.valueOf(interviewerId));
        return new ResponseEntity<>(deletedinterviewer, HttpStatus.OK);
    }
}
