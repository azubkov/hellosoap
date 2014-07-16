package github.com.azubkov.hellosoap.document;

import javax.jws.WebService;

@WebService(endpointInterface = "github.com.azubkov.hellosoap.document.PhraseService")
public class PhraseServiceImpl implements PhraseService {
    @Override
    public String getLoremIpsum(int worldsCount) {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    }

    @Override
    public String getFarFarAway(int linesCount) {
        return "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.";
    }

    @Override
    public String getPunOfTheDay() {
        return "Do birds know where they're going when they fly south for the winter or do they just wing it every time?";
    }
}
