public class MadLibsPlaceholder {

    private String type;
    private String word;

    public MadLibsPlaceholder() {
        type = "NOUN";
        word = Constants.PLACE_HOLDER_PHRASE;
    }

    public MadLibsPlaceholder(String type) {
        this.type = type;
        word = Constants.PLACE_HOLDER_PHRASE;
    }

    public String getType() {
        return type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String toString() {

        return String.format("%s (%s)", word, type);

        //Same just without the formating
        //return word + " (" + type + ")";
    }
}
