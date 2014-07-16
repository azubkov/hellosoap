package github.com.azubkov.hellosoap.document;

import javax.xml.ws.Endpoint;

/**
 * http://localhost:9999/ws/PhraseService?wsdl
 */
public class PhaseServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/PhraseService", new PhraseServiceImpl());
    }
}
