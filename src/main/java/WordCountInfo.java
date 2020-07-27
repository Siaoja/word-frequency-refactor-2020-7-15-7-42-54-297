public class WordCountInfo {
    private String value;
    private int count;

    public WordCountInfo(String word, int wordFequency) {
        this.value = word;
        this.count = wordFequency;
    }

    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }
}
