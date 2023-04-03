package com.redhat;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FTPRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("ftp://devnexusftpuser@40.90.237.221/?username=devnexusftpuser&password=DevNexus23IsAwesome!")
                .log(LoggingLevel.INFO, "processing file ${file:name}")
                .to("file://Users/jeremyrdavis/Desktop/output/greetings_download.txt")
                .log(LoggingLevel.INFO, "written locally");
    }
}
