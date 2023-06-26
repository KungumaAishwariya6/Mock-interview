package com.mocker.interview.service;

import com.mocker.interview.model.Interviewer;
import com.mocker.interview.repository.InterviewerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewerServiceImpl implements InterviewerService{

    @Autowired
    InterviewerRepo interviewerRepo;
    @Override
    public Interviewer addInterviewer(Interviewer interviewer) {
        Interviewer interviewerAdded =interviewerRepo.save(interviewer);
        return interviewerAdded;
    }

    @Override
    public Interviewer updateInterviewer(Integer interviewerId, Interviewer interviewer) {
        Interviewer interviewerFromDb =interviewerRepo.findById(interviewerId).get();
        if(interviewerFromDb!=null && interviewerFromDb.isActive()){
            interviewerFromDb.setFirstName(interviewer.getFirstName());
            interviewerFromDb.setLastName(interviewer.getLastName());
            interviewerFromDb.setEducation(interviewer.getEducation());
            interviewerFromDb.setYearsOfExperience(interviewer.getYearsOfExperience());
            interviewerFromDb.setSelfIntro(interviewer.getSelfIntro());
            Interviewer addedinterviewer =interviewerRepo.save(interviewerFromDb);
            return addedinterviewer;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Interviewer> findAllInterviewer() {
        List<Interviewer> interviewerList =interviewerRepo.findByActive(Boolean.TRUE);
        return interviewerList;
    }

    @Override
    public Interviewer findInterviewerById(Integer interviewerId) {
        Interviewer interviewerFromDb =interviewerRepo.findById(interviewerId).get();
        if(interviewerFromDb!=null && interviewerFromDb.isActive()){
            return interviewerFromDb;
        }else{
            return null;
        }

    }

    @Override
    public Interviewer deleteInterviewer(Integer interviewerId) {
        Interviewer interviewerFromDb =interviewerRepo.findById(interviewerId).get();
        if(interviewerFromDb!=null && interviewerFromDb.isActive()){
            interviewerFromDb.setActive(Boolean.FALSE);
            Interviewer deletedinterviewer =interviewerRepo.save(interviewerFromDb);
            return deletedinterviewer;
        }else{
            return null;
        }

    }
}
