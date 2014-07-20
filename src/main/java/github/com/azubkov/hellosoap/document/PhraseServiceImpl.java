package github.com.azubkov.hellosoap.document;

import github.com.azubkov.hellosoap.utils.Utils;

import javax.jws.WebService;
import java.util.Collections;
import java.util.List;

@WebService(endpointInterface = "github.com.azubkov.hellosoap.document.PhraseService")
public class PhraseServiceImpl implements PhraseService {
    @Override
    public String getLoremIpsum(int worldsCount) {
        if (worldsCount == 0) {
            worldsCount = 2;/*yeah wonderful magic here*/
        }
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    }

    @Override
    public String getFarFarAway(int sentenceCount) {
        if (sentenceCount == 0) {
            sentenceCount = 1;
        }
        String resource = Utils.getResource("github/com/azubkov/hellosoap/document/FarFarAway.txt");
        List<String> list = Utils.toSentences(resource);
        Collections.shuffle(list);
        sentenceCount = Math.abs(sentenceCount);
        sentenceCount = Math.min(sentenceCount, list.size());
        list = list.subList(0, sentenceCount);
        String result = Utils.toParagraph(list);
        return result;
    }

    @Override
    public String getPunOfTheDay() {
        return "Do birds know where they're going when they fly south for the winter or do they just wing it every time?";
    }
}
