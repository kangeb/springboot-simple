package com.kang.springboot.simple.core.util.coder;

public class PasswordUtils
{
  public static final String HASH_ALGORITHM = "SHA-1";
  
  public static final int HASH_INTERATIONS = 1024;
  public static final int SALT_SIZE = 8;
  
  public PasswordUtils() {}
  
  public static String entryptPassword(String plainPassword)
  {
    byte[] salt = Digests.generateSalt(8);
    byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, 1024);
    return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
  }
  


  public static String entryptPassword(String plainPassword, byte[] salt)
  {
    byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, 1024);
    return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
  }
}
