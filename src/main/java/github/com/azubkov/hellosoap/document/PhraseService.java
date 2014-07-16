package github.com.azubkov.hellosoap.document;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface PhraseService {
    /**
     * <a href="http://www.lipsum.com/feed/html">http://www.lipsum.com/feed/html</a>
     */
    @WebMethod
    String getLoremIpsum(int worldsCount);


    /**
     * <a href="http://www.blindtextgenerator.com/lorem-ipsum">http://www.blindtextgenerator.com/lorem-ipsum</a>
     */
    @WebMethod
    String getFarFarAway(int sentenceCount);

    /**
     * <a href="http://www.punoftheday.com/">http://www.punoftheday.com/</a>
     */
    @WebMethod
    String getPunOfTheDay();
}
