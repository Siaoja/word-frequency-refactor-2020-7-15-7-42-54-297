public class WordCountInfo {
    private String value;
    private int count;

    public WordCountInfo(String w, int i) {
        this.value = w;
        this.count = i;
    }

    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }
}
