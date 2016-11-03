/**
 *
 */
package com.coupang.webapp007.tsy;

/**
 * @author TaeSung
 *
 */
public class Util {

	/**
	 * LPAD
	 * @param str
	 * @param len
	 * @param append
	 * @return
	 */
	public static String LPAD(String str ,int len ,String append ){
		String rtn = str;
		if (str.length() < len){
			for (int i = 0; i < (len - str.length()); i++){
				rtn = append + rtn;
			}
		}else{
//			rtn = str.substring(0, len);
		}
		return rtn;
	}

	/**
	 * RPAD
	 * @param str
	 * @param len
	 * @param append
	 * @return
	 */
	public static String RPAD(String str, int len, String append){
		String rtn = str;
		if (str.length() < len){
			for (int i = 0; i < (len - str.length()); i++){
				rtn += append;
			}
		}else{
//			rtn = str.substring(0, len);
		}
		return rtn;
	}
}
