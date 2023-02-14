package br.com.batch.studybatchprocessing.job;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BatchConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("job", jobRepository)
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }

//    @Bean
//    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager){
//        return new StepBuilder("step",jobRepository)
//                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
//                    LOGGER.info("Olá Mundo");
//                    return RepeatStatus.FINISHED;
//                },transactionManager)
//                .build();
//    }

//    @Bean
//    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager){
//        return new StepBuilder("step",jobRepository)
//                .<Integer,String> chunk(5)
//                .reader(contaAteDezReader())
//                .processor(parOuImparProcessor())
//                .writer(imprimeWreiter())
//                .transactionManager(transactionManager)
//                .build();
//    }

//    private ItemWriter<String> imprimeWreiter() {
//        return itens -> itens.forEach(i -> LOGGER.info(i));
//
//    }

//    private FunctionItemProcessor<Integer,String> parOuImparProcessor() {
//        return new FunctionItemProcessor<Integer,String>
//                (item -> item % 2 == 0 ? String.format("item %s é par",item) : String.format("item %s é impar",item));
//    }

//    private IteratorItemReader<Integer> contaAteDezReader() {
//        return new IteratorItemReader<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
//    }


}
