package com.kang.springboot.simple.core.util.coder;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.lang3.Validate;

import com.kang.springboot.simple.core.Exception.Exceptions;

public class Digests
{
  private static final String SHA1 = "SHA-1";
  private static final String MD5 = "MD5";
  private static SecureRandom random = new SecureRandom();
  
  public Digests() {}
  
  public static byte[] md5(byte[] input)
  {
    return digest(input, "MD5", null, 1);
  }
  
  public static byte[] md5(byte[] input, int iterations) { return digest(input, "MD5", null, iterations); }
  



  public static byte[] sha1(byte[] input)
  {
    return digest(input, "SHA-1", null, 1);
  }
  
  public static byte[] sha1(byte[] input, byte[] salt) {
    return digest(input, "SHA-1", salt, 1);
  }
  
  public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
    return digest(input, "SHA-1", salt, iterations);
  }
  

  private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations)
  {
    try
    {
      MessageDigest digest = MessageDigest.getInstance(algorithm);
      
      if (salt != null) {
        digest.update(salt);
      }
      
      byte[] result = digest.digest(input);
      
      for (int i = 1; i < iterations; i++) {
        digest.reset();
        result = digest.digest(result);
      }
      return result;
    } catch (GeneralSecurityException e) {
      throw Exceptions.unchecked(e);
    }
  }
  




  public static byte[] generateSalt(int numBytes)
  {
    Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);
    
    byte[] bytes = new byte[numBytes];
    random.nextBytes(bytes);
    return bytes;
  }
  

  public static byte[] md5(InputStream input)
    throws IOException
  {
    return digest(input, "MD5");
  }
  

  public static byte[] sha1(InputStream input)
    throws IOException
  {
    return digest(input, "SHA-1");
  }
  
  private static byte[] digest(InputStream input, String algorithm) throws IOException {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
      int bufferLength = 8192;
      byte[] buffer = new byte[bufferLength];
      int read = input.read(buffer, 0, bufferLength);
      
      while (read > -1) {
        messageDigest.update(buffer, 0, read);
        read = input.read(buffer, 0, bufferLength);
      }
      
      return messageDigest.digest();
    } catch (GeneralSecurityException e) {
      throw Exceptions.unchecked(e);
    }
  }
  




  public static String md5(String str)
    throws Exception
  {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.reset();
      messageDigest.update(str.getBytes("UTF-8"));
      byte[] byteArray = messageDigest.digest();
      StringBuffer md5StrBuff = new StringBuffer();
      for (int i = 0; i < byteArray.length; i++) {
        if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
          md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
        } else
          md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
      }
      return md5StrBuff.toString();

    }
    catch (NoSuchAlgorithmException e) {}catch (UnsupportedEncodingException e)
    {
      e.printStackTrace();
    }
    throw new Exception("md5 failed!");
  }
  
  public static void main(String[] args) throws Exception
  {
    String str = "hahaha";
    System.out.println(md5(str));
  }
}
