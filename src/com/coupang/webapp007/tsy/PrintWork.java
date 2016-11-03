/**
 *
 */
package com.coupang.webapp007.tsy;

/**
 * @author TaeSung
 *
 */
public class PrintWork {

	/**
	 * Console 확인 Flag
	 */
	static public boolean debugYn = false;

	public void printConsole( String msg ){
		if( debugYn ){
			System.out.println( msg );
		}
	}



}
