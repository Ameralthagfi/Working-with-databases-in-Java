package org.example;

import java.sql.SQLException;
public class App {
    public static void main(String[] args) {
    try {
        DBConnection db = DBConnection.getInstance();
        // Insert
        Task t = new Task("do the landry","amer",false);
        t.insertTask();
        // Retrieve all tasks
        t.retrieveTasks();
    } catch(
    SQLException e)

    {

        e.printStackTrace();
    }
}
}
