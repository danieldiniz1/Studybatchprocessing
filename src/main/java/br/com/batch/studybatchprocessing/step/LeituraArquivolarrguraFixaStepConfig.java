package br.com.batch.studybatchprocessing.step;

import br.com.batch.studybatchprocessing.model.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivolarrguraFixaStepConfig {

    @Bean
    public Step leituraArquivolarrguraFixaStep(ItemReader<Cliente> leituraArquivolarguraFixaReader,
                                               ItemWriter<Cliente> leituraArquivolarrguraFixaWriter,
                                               JobRepository jobRepository,
                                               PlatformTransactionManager transactionManager) {
        return new StepBuilder("leituraArquivolarrguraFixaStep",jobRepository)
                .<Cliente,Cliente>chunk(1)
                .reader(leituraArquivolarguraFixaReader)
                .writer(leituraArquivolarrguraFixaWriter)
                .transactionManager(transactionManager)
                .build();

    }
}
