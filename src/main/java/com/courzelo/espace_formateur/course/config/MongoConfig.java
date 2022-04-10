package com.courzelo.espace_formateur.course.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
/*
@EnableMongoRepositories(basePackages = "com.baeldung.repository")
public class MongoConfig extends AbstractMongoClientConfiguration{
	
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Autowired
    private MappingMongoConverter mongoConverter;

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mongoConverter);
    }
   
	@Override
	protected String getDatabaseName() {
		return database;
	}
}
*/