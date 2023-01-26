package org.example;
import java.sql.*;

public class Task {
    private String name;
    private String owner;
    private boolean isComplete;

    public Task(String name, String owner,boolean isComplete){
        this.name = name;
        this.owner=owner;
        this.isComplete = isComplete;

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void insertTask(){
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            PreparedStatement insertStmt =
                    dbConnection.prepareStatement("INSERT INTO todotable (task,owner ,done) VALUES (?, ?,?);");
            insertStmt.setString(1, this.name);
            insertStmt.setString(2, this.owner);
            insertStmt.setBoolean(3, (this.isComplete));
            int rows = insertStmt.executeUpdate();
            System.out.println("Rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveTasks(){
        try {
            Connection dbConnection = DBConnection.getInstance().getConnection();
            Statement stmt = dbConnection.createStatement();
            String query = "SELECT id,owner ,task, done FROM todotable";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                //Display values
                String row = "ID: " + rs.getInt("id") +
                        " owner: " + rs.getString("owner") +
                        " Task: " + rs.getString("task") +
                        " Done: " + rs.getBoolean("done") + "\n";
                System.out.print(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateTask(){

    }

    public String toString(){
        return "Task: " + this.name +"owner"+this.name+ "\nDone: " + (this.isComplete ? "1": "0");
    }
}
