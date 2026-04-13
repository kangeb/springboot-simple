package com.example.simple.core.util.coder;

import com.example.simple.core.Exception.Exceptions;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 摘要算法工具类
 * 提供MD5和SHA-1等摘要算法的实现
 */
public class Digests {

    /**
     * SHA-1算法名称
     */
    private static final String SHA1 = "SHA-1";

    /**
     * MD5算法名称
     */
    private static final String MD5 = "MD5";

    /**
     * 安全随机数生成器
     */
    private static SecureRandom random = new SecureRandom();

    /**
     * 私有构造方法
     */
    public Digests() {
    }

    /**
     * 计算MD5摘要
     *
     * @param input 输入字节数组
     * @return MD5摘要字节数组
     */
    public static byte[] md5(byte[] input) {
        return digest(input, "MD5", null, 1);
    }

    /**
     * 计算MD5摘要（指定迭代次数）
     *
     * @param input      输入字节数组
     * @param iterations 迭代次数
     * @return MD5摘要字节数组
     */
    public static byte[] md5(byte[] input, int iterations) {
        return digest(input, "MD5", null, iterations);
    }

    /**
     * 计算SHA-1摘要
     *
     * @param input 输入字节数组
     * @return SHA-1摘要字节数组
     */
    public static byte[] sha1(byte[] input) {
        return digest(input, "SHA-1", null, 1);
    }

    /**
     * 计算SHA-1摘要（带盐值）
     *
     * @param input 输入字节数组
     * @param salt  盐值
     * @return SHA-1摘要字节数组
     */
    public static byte[] sha1(byte[] input, byte[] salt) {
        return digest(input, "SHA-1", salt, 1);
    }

    /**
     * 计算SHA-1摘要（带盐值和迭代次数）
     *
     * @param input      输入字节数组
     * @param salt       盐值
     * @param iterations 迭代次数
     * @return SHA-1摘要字节数组
     */
    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, "SHA-1", salt, iterations);
    }

    /**
     * 计算摘要
     *
     * @param input      输入字节数组
     * @param algorithm  算法名称
     * @param salt       盐值
     * @param iterations 迭代次数
     * @return 摘要字节数组
     */
    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
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

    /**
     * 生成随机盐值
     *
     * @param numBytes 盐值字节数
     * @return 盐值字节数组
     */
    public static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * 计算输入流的MD5摘要
     *
     * @param input 输入流
     * @return MD5摘要字节数组
     * @throws IOException IO异常
     */
    public static byte[] md5(InputStream input) throws IOException {
        return digest(input, "MD5");
    }

    /**
     * 计算输入流的SHA-1摘要
     *
     * @param input 输入流
     * @return SHA-1摘要字节数组
     * @throws IOException IO异常
     */
    public static byte[] sha1(InputStream input) throws IOException {
        return digest(input, "SHA-1");
    }

    /**
     * 计算输入流摘要
     *
     * @param input     输入流
     * @param algorithm 算法名称
     * @return 摘要字节数组
     * @throws IOException IO异常
     */
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

    /**
     * 计算字符串的MD5摘要（返回十六进制字符串）
     *
     * @param str 输入字符串
     * @return MD5摘要十六进制字符串
     * @throws Exception 异常
     */
    public static String md5(String str) throws Exception {
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

        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        throw new Exception("md5 failed!");
    }

    /**
     * 主方法（测试用）
     *
     * @param args 命令行参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        String str = "hahaha";
        System.out.println(md5(str));
    }
}
