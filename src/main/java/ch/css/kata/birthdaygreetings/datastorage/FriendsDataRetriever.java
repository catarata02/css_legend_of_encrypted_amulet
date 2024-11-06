package ch.css.kata.birthdaygreetings.datastorage;

import ch.css.kata.birthdaygreetings.greetingprocess.Friend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class FriendsDataRetriever {


    public List<Friend> getFriendsData(LocalDate birthday) {
        try{
            FileInputStream fileInputStream = new FileInputStream("notExisting.txt");
            return Collections.emptyList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Data storage file not found. No data of friends can be retrieved!", e);
        }
    }
}
