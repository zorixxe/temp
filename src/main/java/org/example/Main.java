package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> friendsList = fetchFriendsList("friends.txt");
            System.out.println("Unsorted Friends List: " + friendsList);
            List<String> sortedFriendsList = sortFriendsList(friendsList);
            System.out.println("Sorted Friends List: " + sortedFriendsList);
        } catch (IOException e) {
            System.err.println("Error reading the friends list: " + e.getMessage());
        }
    }

    public static List<String> fetchFriendsList(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    public static List<String> sortFriendsList(List<String> friendsList) {
        return friendsList.stream().sorted().collect(Collectors.toList());
    }
}