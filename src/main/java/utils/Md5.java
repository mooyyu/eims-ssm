package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密
 */
public class Md5 {
    /**
     * 创建给定字符串对应的加密后的字符串
     * @param str
     * @return
     */
    public String createMD5(String str){
        str = str + "mooyyu's md5";

        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] b=md.digest();

            int temp;
            StringBuffer sb=new StringBuffer("");
            for ( int offset = 0; offset <b.length ; offset++ ) {
                temp=b[offset];
                if(temp<0) temp+=256;
                if(temp<16) sb.append("0");
                sb.append(Integer.toHexString(temp));
            }
            str=sb.toString();

        } catch ( NoSuchAlgorithmException e ) {
            e.printStackTrace();
        }
        return str;
    }
}
