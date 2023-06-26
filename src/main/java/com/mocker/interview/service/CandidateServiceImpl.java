package com.mocker.interview.service;

import com.mocker.interview.model.Candidate;
import com.mocker.interview.model.Interviewer;
import com.mocker.interview.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepo candidateRepo;
    @Override
    public Candidate addCandidate(Candidate candidate) {
        Candidate candidateAdded =candidateRepo.save(candidate);
        return candidateAdded;
    }

    @Override
    public Candidate updateCandidate(Integer candidateId, Candidate candidate) {
        Candidate candidateFromDb =candidateRepo.findById(candidateId).get();
        if(candidateFromDb!=null&&candidateFromDb.isActive()){
            candidateFromDb.setFirstName(candidate.getFirstName());
            candidateFromDb.setLastName(candidate.getLastName());
            candidateFromDb.setEducation(candidate.getEducation());
            candidateFromDb.setYearsOfExperience(candidate.getYearsOfExperience());
            candidateFromDb.setSelfIntro(candidate.getSelfIntro());
            Candidate addedCandidate =candidateRepo.save(candidateFromDb);
            return addedCandidate;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Candidate> findAllCandidate() {
        List<Candidate> candidateList =candidateRepo.findByActive(Boolean.TRUE);
        return candidateList;
    }

    @Override
    public Candidate findCandidateById(Integer candidateId) {
        Candidate candidateFromDb =candidateRepo.findById(candidateId).get();
        if(candidateFromDb!=null) {
            return candidateFromDb;
        }else{
            return null;
        }
    }

    @Override
    public Candidate deleteCandidate(Integer candidateId) {
        Candidate candidateFromDb =candidateRepo.findById(candidateId).get();
        if(candidateFromDb!=null){
            candidateFromDb.setActive(Boolean.FALSE);
            Candidate deletedCandidate =candidateRepo.save(candidateFromDb);
            return deletedCandidate;
        }else{
            return null;
        }

    }
}
