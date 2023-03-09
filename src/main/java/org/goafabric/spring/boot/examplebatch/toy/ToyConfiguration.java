package org.goafabric.spring.boot.examplebatch.toy;

import org.goafabric.spring.boot.examplebatch.toy.Reader;
import org.goafabric.spring.boot.examplebatch.toy.Writer;
import org.goafabric.spring.boot.examplebatch.toy.Processor;
import org.goafabric.spring.boot.examplebatch.toy.MyJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ToyConfiguration {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager ptm;

    @Bean
    public Job toyJob(@Qualifier("toyStep") Step toyStep ) {
        return new JobBuilder("toyJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener()).flow(toyStep).end()
                .build();
    }

    @Bean(name = "toyStep")
    public Step toyStep() {
        return new StepBuilder("toyStep", jobRepository)
                .<String, String>chunk(2, ptm)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Reader reader(){
        return new Reader();
    }

    @Bean
    public Writer writer() {
        return new Writer();
    }

    @Bean
    @StepScope
    public Processor processor() {
        return new Processor();
    }

    @Bean
    public MyJobListener listener() {
        return new MyJobListener();
    }

}
