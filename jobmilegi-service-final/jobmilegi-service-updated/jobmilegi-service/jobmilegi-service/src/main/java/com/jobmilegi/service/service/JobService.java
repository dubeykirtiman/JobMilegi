
package com.jobmilegi.service.service;

import com.jobmilegi.service.entity.Job;
import com.jobmilegi.service.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job job) {
        if (jobRepository.existsById(id)) {
            job.setId(id);
            return jobRepository.save(job);
        } else {
            throw new RuntimeException("Job not found");
        }
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
