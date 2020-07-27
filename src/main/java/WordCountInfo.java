public class WordCountInfo {
    private String word;
    private int wordFequency;

    public WordCountInfo(String word, int wordFequency) {
        this.word = word;
        this.wordFequency = wordFequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.wordFequency;
    }
}
