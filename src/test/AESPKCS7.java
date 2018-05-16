import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 *
 * @author ngh
 * AES128 算法
 *
 * CBC 模式
 *
 * PKCS7Padding 填充模式
 *
 * CBC模式需要添加一个参数iv
 *
 * 介于java 不支持PKCS7Padding，只支持PKCS5Padding 但是PKCS7Padding 和 PKCS5Padding 没有什么区别
 * 要实现在java端用PKCS7Padding填充，需要用到bouncycastle组件来实现
 */
public class AESPKCS7 {
    // 算法名称
    final String KEY_ALGORITHM = "AES";
    // 加解密算法/模式/填充方式
    final String algorithmStr = "AES/CBC/PKCS5Padding";
    private Key key;
    private Cipher cipher;

    byte[] iv = { 0x30, 0x31, 0x30, 0x32, 0x30, 0x33, 0x30, 0x34, 0x30, 0x35, 0x30, 0x36, 0x30, 0x37, 0x30, 0x38 };
    public void init(byte[] keyBytes) {

        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(algorithmStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 加密方法
     *
     * @param content
     *            要加密的字符串
     * @param keyBytes
     *            加密密钥
     * @return
     */
    public byte[] encrypt(byte[] content, byte[] keyBytes) {
        byte[] encryptedText = null;
        init(keyBytes);
        System.out.println("IV：" + new String(iv));
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            encryptedText = cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }
    /**
     * 解密方法
     *
     * @param encryptedData
     *            要解密的字符串
     * @param keyBytes
     *            解密密钥
     * @return
     */
    public byte[] decrypt(byte[] encryptedData, byte[] keyBytes) {
        return decrypt(encryptedData, keyBytes, iv);
    }

    public byte[] decrypt(byte[] encryptedData, byte[] keyBytes, byte[] iv) {
        byte[] encryptedText = null;
        init(keyBytes);
        System.out.println("IV：" + new String(iv));
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    public static void main(String[] args) throws Exception {
        String wechatAppId = "wx4f4bc4dec97d474b";
        String wechatSecret = "tiihtNczf5v6AKRyjwEUhQ==";

        String testEncryptData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZM" +
                                "QmRzooG2xrDcvSnxIMXFufNstNGTyaGS" +
                                "9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+" +
                                "3hVbJSRgv+4lGOETKUQz6OYStslQ142d" +
                                "NCuabNPGBzlooOmB231qMM85d2/fV6Ch" +
                                "evvXvQP8Hkue1poOFtnEtpyxVLW1zAo6" +
                                "/1Xx1COxFvrc2d7UL/lmHInNlxuacJXw" +
                                "u0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn" +
                                "/Hz7saL8xz+W//FRAUid1OksQaQx4CMs" +
                                "8LOddcQhULW4ucetDf96JcR3g0gfRK4P" +
                                "C7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB" +
                                "6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns" +
                                "/8wR2SiRS7MNACwTyrGvt9ts8p12PKFd" +
                                "lqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYV" +
                                "oKlaRv85IfVunYzO0IKXsyl7JCUjCpoG" +
                                "20f0a04COwfneQAGGwd5oa+T8yO5hzuy" +
                                "Db/XcxxmK01EpqOyuxINew==";
        String testIv = "r7BXXKkLb8qrSNn05n0qiA==";
        //Base64转码
        String sessionKey = new String(Base64.decode(wechatSecret));
        //sessionKey = hexStringToString(sessionKey);
        String encryptedData64Code = new String();
        //IV先使用base64转码
        String initVector = new String();

        //openssl_decrypt(encryptedData64Code, sessionKey, initVector);
        //开始解密
        AESPKCS7 testAes = new AESPKCS7();
        byte[] rsBytes = testAes.decrypt(Base64.decode(testEncryptData.getBytes()), Base64.decode(wechatSecret), Base64.decode(testIv.getBytes("UTF-8")));
        System.out.println(new String(rsBytes));
    }

    public static String stringToHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "gbk");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    private static String openssl_decrypt(String data, String strKey, String strIv) throws Exception{
        Base64 base64 = new Base64();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(strKey.getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec(strIv.getBytes(), 0 , cipher.getBlockSize());
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        return new String(cipher.doFinal(data.getBytes()));
    }
}