package com.acme.mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

  private static final String DB_URL = "jdbc:h2:mem:minidb";

  // CWE-89: SQL Injection via string concatenation
  public ResultSet findUserByName(String name) throws Exception {
    Connection conn = DriverManager.getConnection(DB_URL);
    Statement stmt = conn.createStatement();
    String query = "SELECT * FROM users WHERE name = '" + name + "'";
    return stmt.executeQuery(query);
  }
}
