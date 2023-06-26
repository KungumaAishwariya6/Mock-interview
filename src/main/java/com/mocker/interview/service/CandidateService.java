package com.mocker.interview.service;

import com.mocker.interview.model.Candidate;
import com.mocker.interview.model.Interviewer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CandidateService {

    public Candidate addCandidate(Candidate candidate);

    public Candidate updateCandidate(Integer candidateId, Candidate candidate);
    public List<Candidate> findAllCandidate();
    public Candidate findCandidateById(Integer candidateId);

    public Candidate deleteCandidate(Integer candidateId);
}
