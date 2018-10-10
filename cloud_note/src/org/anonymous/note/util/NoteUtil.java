package org.anonymous.note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import com.sun.mail.util.BASE64EncoderStream;
/**
 * 	对用户的密码进行加密处理
 * <p>Title:ItemSericeImpl</p>
 * <p>Description</p>
 * <p>Company: www.itcast.com</p>
 * @author     ROSE
 * @date       2018年3月18日14:30:41
 * @version    1.0
 */
public class NoteUtil {
	public static String md5_base64(String message) throws Exception{
		//对消息信息加密处理
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] input = message.getBytes();
		byte[] inputString = md.digest(input);
		//将加密的字节转换为字符串
		String base64String = Base64.encodeBase64String(inputString);
		return base64String;
	}
	
	/**
	 * 生成cn_user表中id
	 * @return randomUUID
	 */
	public static String create_UserId(){
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString();
	}
	//测试
	public static void main(String[] args) throws Exception {
		System.out.println(md5_base64("1234"));
		System.out.println(create_UserId());
	}
}
