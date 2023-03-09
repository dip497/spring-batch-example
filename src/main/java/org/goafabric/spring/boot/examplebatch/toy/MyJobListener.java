package org.goafabric.spring.boot.examplebatch.toy;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class MyJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("job started");
        // TODO Auto-generated method stub
//		JobExecutionListener.super.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("job ended" + jobExecution.getStatus().toString());
        // TODO Auto-generated method stub
//		JobExecutionListener.super.afterJob(jobExecution);
    }


}

