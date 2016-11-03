/**
 *
 */
package com.coupang.webps001.tsy;

import java.util.Iterator;
import java.util.List;

import com.coupang.webapp007.tsy.Util;

/**
 * @author TaeSung
 *
 */
public class PrintWork {

	/**
	 * Console 확인 Flag
	 */
	static public boolean debugYn = false;

	public static void printConsole( String msg ){
		if( debugYn ){
			System.out.println( msg );
		}
	}

	/**
	 * Console 출력용 단락구분
	 */
	static String lsTempLine = "--------------------------------";

	/**
	 * Console 출력용 구분자
	 */
	private static final String lsDeli     = " | ";

	/**
	 * Console 출력용 - Cell Size
	 */
	private static final int    liPadSize = 5;

	/**
	 * Console 출력용 - 공백
	 */
	private static final String lsEmpty   = " ";


	/**
	 * 회사 투자 대비 수익 리스트 확인용 출력
	 * @param List<BaseModel> argList
	 */
	public static void showCoDataTemp( List<BaseModel> argList ){
		Iterator<BaseModel> list = argList.iterator();
		BaseModel bm ;

		printConsole("--------------------------------------");

		while(list.hasNext()){
			bm = (BaseModel)list.next();
			printConsole( Util.RPAD(bm.getCoName() ,liPadSize ,lsEmpty) + " : "
			            + Util.LPAD( Integer.toString( bm.getInvestAmt() ) ,liPadSize , lsEmpty) + " 만원투자 "
					    + Util.LPAD( Integer.toString( bm.getGainAmt() )   ,liPadSize , lsEmpty) + " 만원 수익" );
		}
	}

	/**
	 * BaseCoMaxModel 리스트 확인용 출력
	 * @param argList
	 */
	public static void showCoMaxDataTemp( List<BaseCoMaxModel> argList ){

		String lsTempLine = "----------------------------------------------";
		String lsTemp = "";
		lsTemp  = "";
		lsTemp += Util.LPAD( "MAX" ,liPadSize ,lsEmpty);
		lsTemp += lsDeli;
		lsTemp += Util.LPAD( argList.get(0).getNameA() ,liPadSize * 2 ,lsEmpty);
		lsTemp += lsDeli;
		lsTemp += Util.LPAD( argList.get(0).getNameB() ,liPadSize * 2 ,lsEmpty);
		lsTemp += lsDeli;
		lsTemp += Util.LPAD( argList.get(0).getNameC() ,liPadSize * 2 ,lsEmpty);
		lsTemp += lsDeli;

		printConsole(lsTempLine);
		printConsole(lsTemp);
		printConsole(lsTempLine);

		Iterator<BaseCoMaxModel> list = argList.iterator();
		BaseCoMaxModel bm ;

		while(list.hasNext()){
			bm = (BaseCoMaxModel)list.next();
			lsTemp  = "";
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtMaxSum() ) ,liPadSize ,lsEmpty);
			lsTemp += lsDeli;
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtA()      ) ,liPadSize ,lsEmpty);
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtMaxA()   ) ,liPadSize ,lsEmpty);
			lsTemp += lsDeli;
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtB()      ) ,liPadSize ,lsEmpty);
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtMaxB()   ) ,liPadSize ,lsEmpty);
			lsTemp += lsDeli;
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtC()      ) ,liPadSize ,lsEmpty);
			lsTemp += Util.LPAD( Integer.toString( bm.getAmtMaxC()   ) ,liPadSize ,lsEmpty);
			lsTemp += lsDeli;
			printConsole( lsTemp );

		} // while End.

		printConsole(lsTempLine);
		printConsole("");

	}




}
