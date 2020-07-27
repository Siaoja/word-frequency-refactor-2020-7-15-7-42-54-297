import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    public static final String SPACE_STRING = " ";
    public static final int COUNT_INITIAL_VALUE = 1;
    public static final String COUNT_INITIAL_STRING = " 1";
    public static final String CALCULATE_ERROR = "Calculate Error";
    private String ENTER_STRING;

    public String getResult(String inputStr) {


        if (inputStr.split(SPACE_PATTERN).length == COUNT_INITIAL_VALUE) {
            return inputStr + COUNT_INITIAL_STRING;
        } else {

            try {

                String[] arr = inputStr.split(SPACE_PATTERN);

                List<Input> inputList = new ArrayList<>();
                for (String s : arr) {
                    Input input = new Input(s, COUNT_INITIAL_VALUE);
                    inputList.add(input);
                }

                Map<String, List<Input>> map = getListMap(inputList);

                List<Input> list = new ArrayList<>();
                for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
                    Input input = new Input(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                ENTER_STRING = "\n";
                StringJoiner joiner = new StringJoiner(ENTER_STRING);
                for (Input w : inputList) {
                    String s = w.getValue() + SPACE_STRING + w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
        }
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {

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
