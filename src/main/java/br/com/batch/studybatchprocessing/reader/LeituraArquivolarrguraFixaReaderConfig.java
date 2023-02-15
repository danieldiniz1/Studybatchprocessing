package br.com.batch.studybatchprocessing.reader;

import br.com.batch.studybatchprocessing.model.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivolarrguraFixaReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> leituraArquivolarguraFixaReader(
            @Value("#{jobParameters['arquivoClientes']}" )String arquivoClientes){
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("leituraArquivolarguraFixaReader")
                .resource(new PathResource(arquivoClientes))
                .fixedLength()
                .columns(new Range[]{new Range(1,10),new Range(11,20),new Range(21,23), new Range(24)})
                .names(new String[] {"nome","sobrenome","idade","email"})
                .targetType(Cliente.class)
                .build();
    }
}
