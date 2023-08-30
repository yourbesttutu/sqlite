package com.pxp.SQLite.demo.cassandra;

import java.util.Set;
import javax.net.ssl.SSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionBuilderConfigurer;

@Configuration
class CassandraConfig extends AbstractCassandraConfiguration {

  @Value("${spring.data.cassandra.contact-points}")
  private String contactPoints;

  @Value("${spring.data.cassandra.port}")
  private int port;

  @Value("${spring.data.cassandra.keyspace-name}")
  private String keySpace;

  @Value("${spring.data.cassandra.username}")
  private String username;

  @Value("${spring.data.cassandra.password}")
  private String password;

  @Value("${spring.data.cassandra.schema-action}")
  private String schemaAction;

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.valueOf(schemaAction);
  }

  @Bean
  @Override
  public CqlSessionFactoryBean cassandraSession() {
    CqlSessionFactoryBean cassandraSession = super.cassandraSession();//super session should be called only once
    cassandraSession.setUsername(username);
    cassandraSession.setPassword(password);
    return cassandraSession;
  }

  @Override
  protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
    return CassandraEntityClassScanner.scan("com.pxp.SQLite.demo.entity");
  }

  @Override
  protected SessionBuilderConfigurer getSessionBuilderConfigurer() {
    return (cqlSessionBuilder) -> {
      SSLContext sslContext = SSLUtils.createContextByCer();
      return cqlSessionBuilder.withSslContext(sslContext);
    };
  }

}