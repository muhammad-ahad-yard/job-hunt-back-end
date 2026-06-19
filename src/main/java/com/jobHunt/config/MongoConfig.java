package com.jobHunt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "jobHunt"; // Explicitly names your database
    }

    @Override
    protected boolean autoIndexCreation() {
        return true; // Overrides the framework default and FORCES index creation
    }
}
