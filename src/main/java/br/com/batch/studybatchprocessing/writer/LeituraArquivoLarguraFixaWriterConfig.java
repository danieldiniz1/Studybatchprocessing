package br.com.batch.studybatchprocessing.writer;

import br.com.batch.studybatchprocessing.model.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public ItemWriter<Cliente> leituraArquivolarrguraFixaWriter(){
        return items -> items.forEach(i -> LOGGER.info(i.toString()));
    }
}
