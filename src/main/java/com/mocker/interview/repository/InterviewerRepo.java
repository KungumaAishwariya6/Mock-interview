package com.mocker.interview.repository;

import com.mocker.interview.model.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewerRepo extends JpaRepository<Interviewer, Integer> {

    public List<Interviewer> findByActive(Boolean active);
}
