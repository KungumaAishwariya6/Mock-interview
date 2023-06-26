package com.mocker.interview.repository;

import com.mocker.interview.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    public List<Candidate> findByActive(Boolean active);
}
