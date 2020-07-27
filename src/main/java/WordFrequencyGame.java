import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    public static final String SPACE_STRING = " ";
    public static final int COUNT_INITIAL_VALUE = 1;
    public static final String COUNT_INITIAL_STRING = " 1";
    public static final String CALCULATE_ERROR = "Calculate Error";
    private static final String ENTER_STRING = "\n";

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

                List<WordCountInfo> wordCountInfos1 = new ArrayList<>();
                for (Map.Entry<String, List<WordCountInfo>> entry : wordCountInfoMap.entrySet()) {
                    WordCountInfo input = new WordCountInfo(entry.getKey(), entry.getValue().size());
                    wordCountInfos1.add(input);
                }
                wordCountInfos = wordCountInfos1;

                wordCountInfos.sort((firstWordCountInfo, secondWordCountInfo) -> secondWordCountInfo.getWordCount() - firstWordCountInfo.getWordCount());

                return generateWordCountInfoResult(wordCountInfos);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
        }
    }

    private String generateWordCountInfoResult(List<WordCountInfo> wordCountInfos) {
        StringJoiner sentenceToWordCountResult = new StringJoiner(ENTER_STRING);
        for (WordCountInfo wordCountInfo : wordCountInfos) {
            String wordCountInfoResult = wordCountInfo.getWord() + SPACE_STRING + wordCountInfo.getWordCount();
            sentenceToWordCountResult.add(wordCountInfoResult);
        }
        return sentenceToWordCountResult.toString();
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
