package com.isuperone.lining.common.helper;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public  class AesHelper {

    /**
     * @see
     * @param data 密文
     * @param key 密钥，长度16
     * @param iv 偏移量，长度16
     * @return 明文
     */
    public static String decryptAES(String data,String key,String iv) throws Exception {
        try
        {
            byte[] encrypted1 = Base64Helper.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
