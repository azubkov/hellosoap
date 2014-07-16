package github.com.azubkov.hellosoap.document;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class PhraseServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/PhraseService?wsdl");
        QName qname = new QName("http://document.hellosoap.azubkov.com.github/", "PhraseServiceImplService");
        Service service = Service.create(url, qname);
        PhraseService hello = service.getPort(PhraseService.class);
        System.out.println(hello.getFarFarAway(5));
    }
}
