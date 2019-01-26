package menu.model;

public class Settings {

    private String startIndex;
    private String lastIndex;
    private String language;
    private String mode;

    public Settings(String startIndex, String lastIndex, String language, String mode) {
        this.startIndex = startIndex;
        this.lastIndex = lastIndex;
        this.language = language;
        this.mode = mode;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public String getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(String lastIndex) {
        this.lastIndex = lastIndex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
