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

                List<WordCountInfo> inputList = new ArrayList<>();
                for (String s : words) {
                    WordCountInfo input = new WordCountInfo(s, COUNT_INITIAL_VALUE);
                    inputList.add(input);
                }

                Map<String, List<WordCountInfo>> map = getListMap(inputList);

                List<WordCountInfo> list = new ArrayList<>();
                for (Map.Entry<String, List<WordCountInfo>> entry : map.entrySet()) {
                    WordCountInfo input = new WordCountInfo(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                ENTER_STRING = "\n";
                StringJoiner joiner = new StringJoiner(ENTER_STRING);
                for (WordCountInfo w : inputList) {
                    String s = w.getValue() + SPACE_STRING + w.getWordCount();
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

            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
