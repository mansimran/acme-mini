package com.acme.mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchFeature20261106130129 {

  private static final String DB_URL = "jdbc:h2:mem:minidb";

  // CWE-89: SQL Injection via string concatenation
  public ResultSet findUserByPhone(String phone) throws Exception {
    Connection conn = DriverManager.getConnection(DB_URL);
    Statement stmt = conn.createStatement();
    String query = "SELECT * FROM users WHERE phone = '" + phone + "'";
    return stmt.executeQuery(query);
  }
}
