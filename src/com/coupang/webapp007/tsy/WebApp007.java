/*
 * @Classname : webapp007_tsy
 *
 * @Version information
 *
 * @Date      : 2016-09-01
 *
 * @Copyright : tsy
 */

package com.coupang.webapp007.tsy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class WebApp007 {

	/**
	 * 최종 결과보관 List
	 */
	private static List<ResultMap> resultList = new ArrayList<ResultMap>();

	static PrintWork pw = new PrintWork();

	public static void resetList(){
		resultList.clear();
	}

	public static List<ResultMap> getList(){
		return resultList;
	}


	/**
	 * 검색어 입력
	 * @param keyWord
	 * @return
	 */
	public static String getKeyWord(String keyWord ) {

		if( keyWord.equals(null) || keyWord.length() == 0 ){
			System.out.println("=====================") ;
			System.out.println(" 검색어를 입력하세요.") ;
			System.out.println("=====================") ;

			// 검색어 입력받는 부분.
			Scanner sc = new Scanner(System.in);
			keyWord    = sc.nextLine();
	        sc.close();
		}

		pw.printConsole("입력된 검색어 :  "+ keyWord );
		//System.out.println("입력된 검색어 :  "+ keyWord );

		return keyWord ;
	}

	/**
	 * 입력된 검색어 Encoding
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public static String encodeKeyWord(String keyWord ) throws Exception{

		String encodeKeyWord = URLEncoder.encode(keyWord , "UTF-8") ;

		return encodeKeyWord;
	}

	/**
	 * Parsing 실행
	 * @param keyWord    Encoding된 검색어
	 * @param siteName   검색Site 출처표시
	 * @param siteUrl    Site 검색 URL
	 * @param divId      검색결과를 가져올 HTML내 DIV ID
	 * @param titleClass HTML내 상품명 Class
	 * @param priceClass HTML내 가격명 Class
	 * @param saleClass  HTML내 판매량 Class
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static int runParsing(String keyWord ,String siteName ,String siteUrl ,String divId ,String titleClass ,String priceClass ,String saleClass) throws MalformedURLException, IOException {

        // Site Parsing
        WebParser site = new WebParser();
        site.setKeyWord   (keyWord   ); /* 검색어 저장 변수 */
        site.setSiteName  (siteName  ); /* 검색Site 출처표시 */
        site.setSiteUrl   (siteUrl   ); /* 각 Site 검색 주소 */
        site.setDivId     (divId     ); /* 소스내 검색결과 DIV 의 ID */
        site.setTitleClass(titleClass); /* 소스내 검색결과 DIV 의 ID 안에서 가져올 상품의 제목 */
        site.setPriceClass(priceClass); /* 소스내 검색결과 DIV 의 ID 안에서 가져올 상품의 가격 */
        site.setSaleClass (saleClass ); /* 소스내 검색결과 DIV 의 ID 안에서 가져올 상품의 판매수량 */

        List<ResultMap> subList = new ArrayList<ResultMap>();

        while((subList.size() == 0) && ( site.getRunCnt() <  site.getMaxCnt() ) ){
    		pw.printConsole( site.getSiteName() + "(" + site.getRunCnt() + "/" + site.getMaxCnt() + ") : " + " 실패 => " + site.getSiteUrl() + site.getKeyWord() );
    		subList = site.getList();
    	}
        pw.printConsole( site.getSiteName() + "(" + site.getRunCnt() + "/" + site.getMaxCnt() + ") : " + " 성공 => " + subList.size() + "건" );

        resultList.addAll( subList);

        return resultList.size();

	}

	/**
	 * 결과출력
	 */
	public static void printReport(){

		String lsDeli = " | ";

        Collections.sort(resultList ,new CompareDesc() );

        Iterator<ResultMap> resultSort = resultList.iterator();

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" 판매수량 순.(총 " + resultList.size() + ")");

        while(resultSort.hasNext()){
            ResultMap list = (ResultMap)resultSort.next();
            System.out.println( " * "+ list.getSite() + lsDeli + list.getCnt() + lsDeli + list.getPrice() + lsDeli + list.getTitle() );
        }
        System.out.println("--------------------------------------------------------------------------------");
	}

	/**
	 * 쿠팡,티몬,위메프 에서 검색 & 출력
	 * @param arg 검색어
	 * @throws Exception
	 */
	public static void run(String arg) throws Exception {

        //출력에 사용할 Site 명
		String namePang   = "쿠팡  ";
		String nameMon    = "티몬  ";
		String nameWeMap  = "위메프";

		//각 Site 검색 URL
		String urlPang    = "http://www.coupang.com/np/search?q=";
		String urlMon     = "http://search.ticketmonster.co.kr/search?keyword=";
		String urlWeMap   = "http://wemakeprice.com/search?search_cate=top&search_keyword=";

		// 쿠팡 Parsing Value
		String divPang    = "productList";
		String titlePang  = "name";
		String pricePang  = "price-value";
		String cntPang    = "condition";

		// 티몬 Parsing Value
		String divMon     = "_dealArea";
		String titleMon   = "deal_item_title";
		String priceMon   = "deal_item_price";
		String cntMon     = "deal_item_purchase";

		// 위메프 Parsing Value
		String divWeMap   = "search_deal_area";
		String titleWeMap = "tit_desc";
		String priceWeMap = "sale";
		String cntWeMap   = "txt_num";

		resetList();

		// 1. 입력
		String keyWord = encodeKeyWord(getKeyWord( arg ));

		runParsing( keyWord ,namePang  ,urlPang  ,divPang  ,titlePang  ,pricePang  ,cntPang);
		runParsing( keyWord ,nameMon   ,urlMon   ,divMon   ,titleMon   ,priceMon   ,cntMon );
		runParsing( keyWord ,nameWeMap ,urlWeMap ,divWeMap ,titleWeMap ,priceWeMap ,cntWeMap);

        // Report 출력
        printReport();

	}

	/**
	 * Main함수
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String excuteWord = "";
		run(excuteWord);

    }




}

