package com.zeyakong.hw5.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Zeya Kong
 * On 4/5/2018 9:46 PM.
 */

@Service
public class EncryptService {


    private String getMD5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getSha1(String str){
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private String getSha512(String str){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(str.getBytes());
            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer hashCodeBuffer = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return hashCodeBuffer.toString();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getSha256(String str){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public String getEncrypt(String src , String algorithm){
        if(src==null){
            return "empty string!";
        }
        if(algorithm.equals("sha256")){
            return  getSha256(src);
        }else if (algorithm.equals("sha512")){
            return  getSha512(src);
        }else if (algorithm.equals("sha1")){
            return  getSha1(src);
        }else if (algorithm.equals("md5")){
            return  getMD5(src);
        }else{
            return "no such algorithm";
        }
    }
}
