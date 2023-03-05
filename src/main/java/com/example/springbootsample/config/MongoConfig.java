//package com.example.springbootsample.config;
//
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Configuration
//@ConditionalOnProperty(name = "spring.data.mongodb.uri")
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//    @Value("${spring.data.mongodb.uri}")
//    private String uri;
//
//    @Override
//    protected String getDatabaseName() {
//        return getMongoConnectionString().getDatabase();
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return MongoClients.create(getMongoClientSetting());
//    }
//
//    public ConnectionString getMongoConnectionString() {
//        ConnectionString connectionString = new ConnectionString(uri);
//        return connectionString;
//    }
//
//    public MongoClientSettings getMongoClientSetting() {
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(getMongoConnectionString())
//                .build();
//        return mongoClientSettings;
//    }
//
//    //    @Override
////    @Bean
////    public MappingMongoConverter mappingMongoConverter() throws Exception {
////        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(this.dbFactory());
////        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, this.mongoMappingContext());
////        List<Object> list = new ArrayList<>();
////        list.add(new BigDecimalToDecimal128Converter());//custom type converter
////        list.add(new Decimal128ToBigDecimalConverter());//custom type converter
////        //list.add(new DateLocalConvert());
////        converter.setCustomConversions(new CustomConversions(list));
////        return converter;
////    }
////    @Bean
////    public MongoDbFactory dbFactory() throws Exception {
////        return new SimpleMongoDbFactory(getMongoConnectionString());
////    }
//    @Override
//    public Collection getMappingBasePackages() {
//        return Collections.singleton("com.bizzan");
//    }
//
////    @Override
////    @Bean(name = "newMongoTemplate")
////    public MongoTemplate mongoTemplate() throws Exception {
////        return new MongoTemplate(this.dbFactory(), this.mappingMongoConverter());
////    }
//
//}
