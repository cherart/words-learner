package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WordDao {

    public void createWord(String english, String russian) throws SQLException;

    public Word getWordById(int wordId) throws SQLException;

    public ArrayList<Word> getAllWords() throws SQLException;

    public void updateWord(Word word) throws SQLException;

    public void deleteWordById(int id) throws SQLException;
}
