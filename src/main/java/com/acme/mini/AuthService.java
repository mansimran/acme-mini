package com.acme.mini;

import java.security.MessageDigest;
import java.util.Random;

public class AuthService {

  // CWE-798: Use of Hard-coded Credentials
  private static final String ADMIN_USER = "admin";
  private static final String ADMIN_PASSWORD = "SuperSecret123!";

  public boolean login(String user, String password) {
    return ADMIN_USER.equals(user) && ADMIN_PASSWORD.equals(password);
  }

  // CWE-327: Use of a Broken or Risky Cryptographic Algorithm (MD5)
  public String hashPassword(String password) throws Exception {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] digest = md.digest(password.getBytes());
    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  // CWE-330: Use of Insufficiently Random Values (non-cryptographic Random for a session token)
  public String generateSessionToken() {
    Random random = new Random();
    return Long.toHexString(random.nextLong());
  }
}
