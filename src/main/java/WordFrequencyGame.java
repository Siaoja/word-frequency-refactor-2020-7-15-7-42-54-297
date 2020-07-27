import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    private static final String SPACE_STRING = " ";
    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final String ENTER_STRING = "\n";

    public String getResult(String sentence) {

        try {

            List<WordCountInfo> wordCountInfos = countWordFrequency(sentence);

            wordCountInfos.sort((firstWordCountInfo, secondWordCountInfo) -> secondWordCountInfo.getWordCount() - firstWordCountInfo.getWordCount());

            return generateWordCountInfoResult(wordCountInfos);
        } catch (Exception e) {
            return CALCULATE_ERROR;
        }
    }

    private List<WordCountInfo> countWordFrequency(String sentence) {

        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordCountInfo> wordCountInfos = new ArrayList<>();

        for (String uniqueWord : new HashSet<>(words)) {
            int count = (int) words.stream().filter(word -> word.equals(uniqueWord)).count();
            wordCountInfos.add(new WordCountInfo(uniqueWord, count));
        }

        return wordCountInfos;
    }

    private String generateWordCountInfoResult(List<WordCountInfo> wordCountInfos) {
        StringJoiner sentenceToWordCountResult = new StringJoiner(ENTER_STRING);
        for (WordCountInfo wordCountInfo : wordCountInfos) {
            String wordCountInfoResult = wordCountInfo.getWord() + SPACE_STRING + wordCountInfo.getWordCount();
            sentenceToWordCountResult.add(wordCountInfoResult);
        }
        return sentenceToWordCountResult.toString();
    }

}
