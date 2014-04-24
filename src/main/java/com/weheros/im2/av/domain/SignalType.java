/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.domain;

/**
 * @ClassName: Protocol
 * @author Yang
 * @date 2014年4月23日 下午2:02:03
 */
public class SignalType {
   public static final int HEART_BEAT=0;
   public static final int LOGIN_REQ=1;
   public static final int LOGIN_RES=1 << 4;
   public static final int START_CALL_REQ=2;
   public static final int START_CALL_RES=2 << 4;
   
   //these three signal does not need response.
   public static final int END_SESSION=403;
   public static final int ANSWER=402; //answer of calling
   public static final int CALL=401; //
   
   public static final int LOGOUT_REQ=5;
   public static final int LOGOUT_RES=5 << 4;
   
   public static final int NOT_NEED_RESPONSE=-100;
   
   public static void main(String[] arr){
	   System.out.println(Math.pow(16, 4));
	   System.out.println((LOGIN_REQ << 4));
	   System.out.println(LOGOUT_RES);
   }
}
