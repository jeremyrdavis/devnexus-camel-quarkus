package com.redhat;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FTPRoute extends RouteBuilder {

    final String DESTINATION_FOLER = "output";

    @Override
    public void configure() {

        from("ftp://devnexusftpuser@40.90.237.221/?username=devnexusftpuser&password=DevNexus23IsAwesome!")
                .log(LoggingLevel.INFO, "processing file ${file:name}")
                .split(body().convertToString().tokenize("\n"))
                .setHeader(Exchange.FILE_NAME, body())
                .to("kafka:greetings")
                .log(LoggingLevel.INFO, "written to Kafka");

    }
}
