package br.com.batch.studybatchprocessing.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaJobConfig {

    @Bean
    public Job arquivoLarguraFixaJob(JobRepository jobRepository,Step leituraArquivolarrguraFixaStep){
        return new JobBuilder("arquivoLarguraFixaJob",jobRepository)
                .start(leituraArquivolarrguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
