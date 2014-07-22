package github.com.azubkov.hellosoap.document;

import github.com.azubkov.hellosoap.utils.Utils;

import javax.jws.WebService;
import java.util.Collections;
import java.util.List;

@WebService(endpointInterface = "github.com.azubkov.hellosoap.document.PhraseService")
public class PhraseServiceImpl implements PhraseService {

    /**
     * @param count wordCount
     */
    @Override
    public String getLoremIpsum(int count) {
        if (count == 0) {
            count = 2;/*yeah wonderful magic here*/
        }
        String resource = Utils.getResource("github/com/azubkov/hellosoap/document/LoremIpsum.txt");
        List<String> list = Utils.toWords(resource);
        Collections.shuffle(list);
        count = Math.abs(count);
        count = Math.min(count, list.size());
        list = list.subList(0, count);
        String result = Utils.toParagraph(list);
        return result;
    }

    /**
     * @param count sentenceCount
     */
    @Override
    public String getFarFarAway(int count) {
        if (count == 0) {
            count = 1;
        }
        String resource = Utils.getResource("github/com/azubkov/hellosoap/document/FarFarAway.txt");
        List<String> list = Utils.toSentences(resource);
        Collections.shuffle(list);
        count = Math.abs(count);
        count = Math.min(count, list.size());
        list = list.subList(0, count);
        String result = Utils.toParagraph(list);
        return result;
    }

    @Override
    public String getPunOfTheDay() {
        String resource = Utils.getResource("github/com/azubkov/hellosoap/document/PunOfTheDay.txt");
        List<String> list = Utils.toLines(resource);
        if (list.isEmpty()) {
            throw new RuntimeException();
        }
        Collections.shuffle(list);
        return list.get(0);
    }
}
