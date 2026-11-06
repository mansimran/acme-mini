package com.acme.mini;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello from mini-app");

    AuthService auth = new AuthService();
    System.out.println("Login ok: " + auth.login("admin", "SuperSecret123!"));
    System.out.println("Session token: " + auth.generateSessionToken());

    FileService files = new FileService();
    System.out.println("Ping result ready: " + (files.pingHost("localhost") != null));
  }
}
