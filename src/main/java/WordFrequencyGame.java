import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    public static final String SPACE_STRING = " ";
    public static final int COUNT_INITIAL_VALUE = 1;
    public static final String COUNT_INITIAL_STRING = " 1";
    public static final String CALCULATE_ERROR = "Calculate Error";
    private String ENTER_STRING;

    public String getResult(String sentence) {


        if (sentence.split(SPACE_PATTERN).length == COUNT_INITIAL_VALUE) {
            return sentence + COUNT_INITIAL_STRING;
        } else {

            try {

                String[] words = sentence.split(SPACE_PATTERN);

                List<WordCountInfo> wordCountInfos = new ArrayList<>();
                for (String word : words) {
                    WordCountInfo wordCountInfo = new WordCountInfo(word, COUNT_INITIAL_VALUE);
                    wordCountInfos.add(wordCountInfo);
                }

                Map<String, List<WordCountInfo>> wordCountInfoMap = getListMap(wordCountInfos);

                List<WordCountInfo> list = new ArrayList<>();
                for (Map.Entry<String, List<WordCountInfo>> entry : wordCountInfoMap.entrySet()) {
                    WordCountInfo input = new WordCountInfo(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                wordCountInfos = list;

                wordCountInfos.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                ENTER_STRING = "\n";
                StringJoiner joiner = new StringJoiner(ENTER_STRING);
                for (WordCountInfo w : wordCountInfos) {
                    String s = w.getWord() + SPACE_STRING + w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
        }
    }

    private Map<String, List<WordCountInfo>> getListMap(List<WordCountInfo> inputList) {
        Map<String, List<WordCountInfo>> map = new HashMap<>();
        for (WordCountInfo input : inputList) {

            if (!map.containsKey(input.getWord())) {
                List<WordCountInfo> arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getWord(), arr);
            } else {
                map.get(input.getWord()).add(input);
            }
        }
        return map;
    }
}
