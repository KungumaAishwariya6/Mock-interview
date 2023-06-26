package com.mocker.interview.service;

import com.mocker.interview.model.Interviewer;

import java.util.List;

public interface InterviewerService {

    public Interviewer addInterviewer(Interviewer interviewer);

    public Interviewer updateInterviewer(Integer interviewerId, Interviewer interviewer);
    public List<Interviewer> findAllInterviewer();
    public Interviewer findInterviewerById(Integer id);

    public Interviewer deleteInterviewer(Integer interviewerId);
}
