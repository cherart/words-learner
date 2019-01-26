package myvocabulary.model;

public class Word {

    private static int COUNTER;

    private int id;
    private String englishTranslate;
    private String russianTranslate;

    public Word(int id, String englishTranslate, String russianTranslate) {
        this.id = id;
        this.englishTranslate = englishTranslate;
        this.russianTranslate = russianTranslate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishTranslate() {
        return englishTranslate;
    }

    public void setEnglishTranslate(String englishTranslate) {
        this.englishTranslate = englishTranslate;
    }

    public String getRussianTranslate() {
        return russianTranslate;
    }

    public void setRussianTranslate(String russianTranslate) {
        this.russianTranslate = russianTranslate;
    }
}
