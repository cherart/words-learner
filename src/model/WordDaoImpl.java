package model;

import java.sql.*;
import java.util.ArrayList;

public class WordDaoImpl implements WordDao {

    private Statement statement;
    private Connection connection;

    public WordDaoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:words.db");
        connection.setAutoCommit(false);
        statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS WORDS " +
                "(ID INT PRIMARY KEY NOT NULL," +
                "ENGLISH_TRANSLATE TEXT NOT NULL," +
                "RUSSIAN_TRANSLATE TEXT NOT NULL );";
        statement.executeUpdate(sql);
    }

    @Override
    public void createWord(String english, String russian) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM WORDS");
        resultSet.next();
        int count = resultSet.getInt("rowcount");
        String sql = "INSERT OR REPLACE INTO WORDS (ID,ENGLISH_TRANSLATE,RUSSIAN_TRANSLATE) VALUES (" +
                count + "," +
                "'" + english + "'," +
                "'" + russian + "' );";
        statement.executeUpdate(sql);
        connection.commit();
    }

    @Override
    public Word getWordById(int wordId) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM WORDS WHERE ID = " + wordId);
        resultSet.next();
        String englishTranslate = resultSet.getString("english_translate");
        String russianTranslate = resultSet.getString("russian_translate");
        return new Word(wordId, englishTranslate, russianTranslate);
    }

    @Override
    public ArrayList<Word> getAllWords() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM WORDS ORDER BY ID");
        ArrayList<Word> words = new ArrayList<>();
        while (resultSet.next()) {
            Word word = new Word(
                    resultSet.getInt("id"),
                    resultSet.getString("english_translate"),
                    resultSet.getString("russian_translate"));
            words.add(word);
        }
        return words;
    }

    @Override
    public void updateWord(Word word) throws SQLException {
        String sql = "UPDATE WORDS set ENGLISH_TRANSLATE = " + word.getEnglishTranslate() + "" +
                ", RUSSIAN_TRANSLATE = " + word.getRussianTranslate() +
                "WHERE ID = " + word.getId() + ";";
        statement.executeUpdate(sql);
        connection.commit();
    }

    @Override
    public void deleteWordById(int id) throws SQLException {
        String sql = "DELETE from WORDS where ID = " + id + ";";
        statement.executeUpdate(sql);
        connection.commit();
    }
}
