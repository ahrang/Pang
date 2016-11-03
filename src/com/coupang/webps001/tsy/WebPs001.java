/*
 * @Classname : webapp007_tsy
 *
 * @Version information
 *
 * @Date      : 2016-09-01
 *
 * @Copyright : tsy
 */

package com.coupang.webps001.tsy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.coupang.webapp007.tsy.Util;

public class WebPs001 {

	/**
	 * 기업A 투자대비 수익 리스트
	 */
	private static List<BaseModel> bmla = new ArrayList<BaseModel>();

	/**
	 * 기업B 투자대비 수익 리스트
	 */
	private static List<BaseModel> bmlb = new ArrayList<BaseModel>();

	/**
	 * 기업C 투자대비 수익 리스트
	 */
	private static List<BaseModel> bmlc= new ArrayList<BaseModel>();

	/**
	 * 3개 기업의 출력용 리스트
	 */
	private static List<BaseCoModel> allcolist = new ArrayList<BaseCoModel>();


	public static List<BaseModel> getBmla() {
		return bmla;
	}

	public static void setBmla(List<BaseModel> bmla) {
		WebPs001.bmla = bmla;
	}

	public static List<BaseModel> getBmlb() {
		return bmlb;
	}

	public static void setBmlb(List<BaseModel> bmlb) {
		WebPs001.bmlb = bmlb;
	}

	public static List<BaseModel> getBmlc() {
		return bmlc;
	}

	public static void setBmlc(List<BaseModel> bmlc) {
		WebPs001.bmlc = bmlc;
	}

	public	static List<BaseCoModel> getAllcolist() {
		return allcolist;
	}

	public	static void setAllcolist(List<BaseCoModel> allcolist) {
		WebPs001.allcolist = allcolist;
	}

	/**
	 * 기업A 수익 리스트 초기화
	 */
	public static void resetListA(){
		bmla.clear();
	}

	/**
	 * 기업B 수익 리스트 초기화
	 */
	public static void resetListB(){
		bmlb.clear();
	}

	/**
	 * 기업C 수익 리스트 초기화
	 */
	public static void resetListC(){
		bmlc.clear();
	}

	/**
	 * 3개 기업의 출력용 리스트 초기화
	 * @return
	 */
	private static void resetListAll(){
		allcolist.clear();
	}

	private static final int    liPadSize = 5;
	private static final String lsEmpty    = " ";
	private static final String lsTempLine = "-------------------------------";
	private static final String lsDeli     = " | ";

	/**
	 * 3개 회사의 투자금 대비 수익리스트 무작위 생성
	 * @param amt
	 */
	public static void makeCoData(int amt ){

		// 기존 리스트 초기화
		resetListA();
		resetListB();
		resetListC();

		// 각 회사별 초기 데이타 생성
		GainList a = new GainList( amt ,"A Co" );
		GainList b = new GainList( amt ,"B Co" );
		GainList c = new GainList( amt ,"C Co" );

		// 리스트 셋팅
		setBmla( a.getBm() );
		setBmlb( b.getBm() );
		setBmlc( c.getBm() );

		PrintWork.showCoDataTemp( getBmla() );
		PrintWork.showCoDataTemp( getBmlb() );
		PrintWork.showCoDataTemp( getBmlc() );

	}

	/**
	 * 3개 회사의 투자금 대비 수익리스트 출력
	 */
	public static void printCoData(){

		resetListAll();
		String lsTemp = "";
		List<BaseCoModel> list = new ArrayList<BaseCoModel>();

		for(int i = 0; i < bmla.size(); i++){
			BaseCoModel  data = new BaseCoModel();
			data.setAmt  ( bmla.get(i).getInvestAmt());
			data.setAmtA ( bmla.get(i).getGainAmt()  );
			data.setAmtB ( bmlb.get(i).getGainAmt()  );
			data.setAmtC ( bmlc.get(i).getGainAmt()  );
			data.setNameA( bmla.get(i).getCoName()   );
			data.setNameB( bmlb.get(i).getCoName()   );
			data.setNameC( bmlc.get(i).getCoName()   );
			list.add(data);
		}
		setAllcolist(list);

		System.out.println("");
		System.out.println( "출력1" );
		System.out.println( "* 회사별 투자금대비 수익 테이블" );
		lsTemp  = Util.LPAD( "Money" ,liPadSize ,lsEmpty ) + lsDeli;
		lsTemp += Util.LPAD( list.get(0).getNameA(),liPadSize ,lsEmpty ) + lsDeli;
		lsTemp += Util.LPAD( list.get(0).getNameB(),liPadSize ,lsEmpty ) + lsDeli;
		lsTemp += Util.LPAD( list.get(0).getNameC(),liPadSize ,lsEmpty ) + lsDeli;

		System.out.println( lsTempLine );
		System.out.println( lsTemp );
		System.out.println( lsTempLine );

		Iterator<BaseCoModel> listiter = allcolist.iterator();
		BaseCoModel bcm;

		while(listiter.hasNext()){
			bcm = (BaseCoModel)listiter.next();
			lsTemp  = Util.LPAD( Integer.toString( bcm.getAmt() ), liPadSize, lsEmpty) + lsDeli;
			lsTemp += Util.LPAD( Integer.toString( bcm.getAmtA()), liPadSize, lsEmpty) + lsDeli;
			lsTemp += Util.LPAD( Integer.toString( bcm.getAmtB()), liPadSize, lsEmpty) + lsDeli;
			lsTemp += Util.LPAD( Integer.toString( bcm.getAmtC()), liPadSize, lsEmpty) + lsDeli;
			System.out.println( lsTemp );

		}
		System.out.println( lsTempLine );


	}

	/**
	 * 단일 회사 투자가 최대이익보다 클경우 최종리스트에 추가.
	 * @param argMax 3개회사 조합 최대수익 금액
	 * @return
	 */
	private static List<BaseCoMaxModel> findMaxElse(int argMax){
		List<BaseCoMaxModel> basecomax = new ArrayList<BaseCoMaxModel>();

		for(int i = 0; i < bmla.size(); i++){
			if( argMax <= bmla.get(i).getGainAmt() ){
				BaseCoMaxModel data = new BaseCoMaxModel();
				data.setAmt      ( bmla.get(i).getInvestAmt() );
				data.setNameA    ( bmla.get(i).getCoName()   );
				data.setAmtA     ( bmla.get(i).getInvestAmt());
				data.setAmtMaxA  ( bmla.get(i).getGainAmt()  );
				data.setNameB    ( bmlb.get(0).getCoName()   );
				data.setAmtB     ( 0 );
				data.setAmtMaxB  ( 0 );
				data.setNameC    ( bmlc.get(0).getCoName()   );
				data.setAmtC     ( 0 );
				data.setAmtMaxC  ( 0 );
				data.setAmtMaxSum( bmla.get(i).getGainAmt() );
				basecomax.add(data);
			}
		}

		for(int i = 0; i < bmlb.size(); i++){
			if( argMax <= bmlb.get(i).getGainAmt() ){
				BaseCoMaxModel data = new BaseCoMaxModel();
				data.setAmt      ( bmlb.get(i).getInvestAmt() );
				data.setNameA    ( bmla.get(0).getCoName()   );
				data.setAmtA     ( 0);
				data.setAmtMaxA  ( 0);
				data.setNameB    ( bmlb.get(i).getCoName()   );
				data.setAmtB     ( bmlb.get(i).getInvestAmt() );
				data.setAmtMaxB  ( bmlb.get(i).getGainAmt() );
				data.setNameC    ( bmlc.get(0).getCoName()   );
				data.setAmtC     ( 0 );
				data.setAmtMaxC  ( 0 );
				data.setAmtMaxSum( bmlb.get(i).getGainAmt() );
				basecomax.add(data);
			}
		}

		for(int i = 0; i < bmlc.size(); i++){
			if( argMax <= bmlc.get(i).getGainAmt() ){
				BaseCoMaxModel data = new BaseCoMaxModel();
				data.setAmt      ( bmlc.get(i).getInvestAmt() );
				data.setNameA    ( bmla.get(0).getCoName()   );
				data.setAmtA     ( 0 );
				data.setAmtMaxA  ( 0 );
				data.setNameB    ( bmlb.get(0).getCoName()   );
				data.setAmtB     ( 0 );
				data.setAmtMaxB  ( 0 );
				data.setNameC    ( bmlc.get(i).getCoName()   );
				data.setAmtC     ( bmlc.get(i).getInvestAmt());
				data.setAmtMaxC  ( bmlc.get(i).getGainAmt()  );
				data.setAmtMaxSum( bmlc.get(i).getGainAmt() );
				basecomax.add(data);
			}
		}

		if( basecomax.size() > 0 ){
			PrintWork.printConsole( "분산투자 최대이익 " + argMax + "보다 같거나 큰 단일투자 회사 건수 추가!" );
			PrintWork.showCoMaxDataTemp( basecomax );
		}
		return basecomax;
	}


	/**
	 * 최대 수익금액 찾기
	 * @param argList List<BaseCoMaxModel>
	 * @return 최대 수익금액
	 */
	private static int findMax(List<BaseCoMaxModel> argList){
		int rtn = 0;

        Iterator<BaseCoMaxModel> resultFind = argList.iterator();
        while(resultFind.hasNext()){
        	BaseCoMaxModel list = (BaseCoMaxModel)resultFind.next();
        	if( list.getAmtMaxSum() > rtn ){
        		rtn = list.getAmtMaxSum();
        	}
        }
		return rtn;
	}

	/**
	 * 3개 회사의 투자금 대비 최대 수익 출력
	 * @param money
	 */
	public static void printMaxData(int money){
		int liSum = 0;
		List<BaseCoMaxModel> list = new ArrayList<BaseCoMaxModel>();

		for(int i = 0; i < bmla.size(); i++){
			for(int j = 0; j < bmlb.size(); j++){
				for(int k = 0; k < bmlc.size(); k++){

					liSum = bmla.get(i).getInvestAmt() + bmlb.get(j).getInvestAmt() + bmlc.get(k).getInvestAmt();

					if(liSum == money){
						BaseCoMaxModel data = new BaseCoMaxModel();
						data.setAmt      ( liSum );
						data.setNameA    ( bmla.get(i).getCoName()   );
						data.setAmtA     ( bmla.get(i).getInvestAmt());
						data.setAmtMaxA  ( bmla.get(i).getGainAmt()  );
						data.setNameB    ( bmlb.get(j).getCoName()   );
						data.setAmtB     ( bmlb.get(j).getInvestAmt());
						data.setAmtMaxB  ( bmlb.get(j).getGainAmt()  );
						data.setNameC    ( bmlc.get(k).getCoName()   );
						data.setAmtC     ( bmlc.get(k).getInvestAmt());
						data.setAmtMaxC  ( bmlc.get(k).getGainAmt()  );
						data.setAmtMaxSum( bmla.get(i).getGainAmt() + bmlb.get(j).getGainAmt() + bmlc.get(k).getGainAmt() );
						list.add(data);
					} // if End.
				} // for k End.
			} // for j End.
		} // for k End.

		int iMax = findMax( list );
		PrintWork.printConsole("");
		PrintWork.printConsole( iMax + " : " + list.size() + "Row" );

		list.addAll( findMaxElse( iMax ) );
		iMax = findMax( list );
		PrintWork.printConsole( iMax + " : " + list.size() + "Row" );
		PrintWork.printConsole("");
		PrintWork.printConsole("Sort 전 List");
		PrintWork.showCoMaxDataTemp(list);

        Collections.sort(list ,new CompareMaxDesc() );
        PrintWork.printConsole("Sort 후 List");
    	PrintWork.showCoMaxDataTemp(list);

        Iterator<BaseCoMaxModel> resultFind = list.iterator();

        System.out.println();
        System.out.println( "출력2" );
        System.out.println( "*투자 최대 이익 " + iMax + "만원");

        String lsTxt = "";

        while(resultFind.hasNext()){
        	BaseCoMaxModel find = (BaseCoMaxModel)resultFind.next();
        	if( iMax == find.getAmtMaxSum() ){
        		System.out.println();

        		lsTxt  = Util.LPAD( find.getNameA() ,liPadSize ,lsEmpty) + " : ";
        		lsTxt += Util.LPAD( Integer.toString( find.getAmtA()    ) ,liPadSize ,lsEmpty) + "만원 투자";
        		lsTxt += Util.LPAD( Integer.toString( find.getAmtMaxA() ) ,liPadSize ,lsEmpty) + "만원 수익";
        		System.out.println( lsTxt );

        		lsTxt  = Util.LPAD( find.getNameB() ,liPadSize ,lsEmpty) + " : ";
        		lsTxt += Util.LPAD( Integer.toString( find.getAmtB()    ) ,liPadSize ,lsEmpty) + "만원 투자";
        		lsTxt += Util.LPAD( Integer.toString( find.getAmtMaxB() ) ,liPadSize ,lsEmpty) + "만원 수익";
        		System.out.println( lsTxt );

        		lsTxt  = Util.LPAD( find.getNameC() ,liPadSize ,lsEmpty) + " : ";
        		lsTxt += Util.LPAD( Integer.toString( find.getAmtC()    ) ,liPadSize ,lsEmpty) + "만원 투자";
        		lsTxt += Util.LPAD( Integer.toString( find.getAmtMaxC() ) ,liPadSize ,lsEmpty) + "만원 수익";
        		System.out.println( lsTxt );

        	}
        }
	}

	/**
	 * Main 함수
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		int money = 200;

//		PrintWork.debugYn = true;

		// 3개 회사의 투자금 대비 수익리스트 생성
		makeCoData( money );

		// 3개 회사의 투자금 대비 수익리스트 출력
		printCoData();

		// 3개 회사의 투자금 대비 최대 수익 출력
		printMaxData( money );

    }


}
