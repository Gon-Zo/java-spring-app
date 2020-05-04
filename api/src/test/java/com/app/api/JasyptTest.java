package java.com.app.api;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptTest {
    public static void main(String[] args) {

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("");
        jasypt.setAlgorithm("PBEWithMD5AndDES");

        String encryptedText = jasypt.encrypt("");
        String plainText = jasypt.decrypt(encryptedText);

        System.out.println("encryptedText:  " + encryptedText);
        System.out.println("plainText:  " + plainText);
    }

}
