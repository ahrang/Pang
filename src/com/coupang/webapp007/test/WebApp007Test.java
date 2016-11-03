/**
 *
 */
package com.coupang.webapp007.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.net.URLEncoder;

import org.junit.Test;

import com.coupang.webapp007.tsy.PrintWork;
import com.coupang.webapp007.tsy.WebApp007;

/**
 * @author TaeSung
 *
 */
public class WebApp007Test {

	/**
	 * 검색어 설정
	 */
	private final static String FIX_WORD = "레깅스";


	/**
	 * getKeyWord TEST
	 * @throws Exception
	 */
	@Test
	public void getKeyWordTest() throws Exception {
		assertEquals(WebApp007.getKeyWord(FIX_WORD),"레깅스");
	}

	/**
	 * encodeKeyWord TEST
	 * @throws Exception
	 */
	@Test
	public void encodeKeyWordTest() throws Exception {
		String a = WebApp007.encodeKeyWord( WebApp007.getKeyWord(FIX_WORD) );
		String b = URLEncoder.encode(FIX_WORD , "UTF-8") ;
		assertEquals(a,b);

		String c = URLEncoder.encode("레고" , "UTF-8") ;
		assertNotSame(a,c);
	}

	/**
	 * runCoupang TEST
	 * @throws Exception
	 */
	@Test
	public void runCoupangTest() throws Exception {
		PrintWork.debugYn = true;
		String name  = "쿠팡  ";
		String url   = "http://www.coupang.com/np/search?q=";
		String div   = "productList";
		String title = "name";
		String price = "price-value";
		String cnt   = "condition";

		WebApp007.resetList();
		String keyWord = WebApp007.encodeKeyWord(WebApp007.getKeyWord(FIX_WORD));
		int list =  WebApp007.runParsing( keyWord ,name ,url ,div ,title ,price ,cnt );
		System.out.println(name + " : " + list);

		assertNotSame(list,0);
	}


	/**
	 * runTimon TEST
	 * @throws Exception
	 */
	@Test
	public void runTimonTest() throws Exception {
		PrintWork.debugYn = true;
		String name  = "티몬  ";
		String url   = "http://search.ticketmonster.co.kr/search?keyword=";
		String div   = "_dealArea";
		String title = "deal_item_title";
		String price = "deal_item_price";
		String cnt   = "deal_item_purchase";

		WebApp007.resetList();
		String keyWord = WebApp007.encodeKeyWord(WebApp007.getKeyWord(FIX_WORD));
		int list =  WebApp007.runParsing( keyWord ,name ,url ,div ,title ,price ,cnt );
		System.out.println(name + " : " + list);

		assertNotSame(list,0);
	}

	/**
	 * runWemap TEST
	 * @throws Exception
	 */
	@Test
	public void runWemapTest() throws Exception {
		PrintWork.debugYn = true;
		String name  = "위메프";
		String url   = "http://wemakeprice.com/search?search_cate=top&search_keyword=";
		String div   = "search_deal_area";
		String title = "tit_desc";
		String price = "sale";
		String cnt   = "txt_num";

		WebApp007.resetList();
		String keyWord = WebApp007.encodeKeyWord(WebApp007.getKeyWord(FIX_WORD));
		int list =  WebApp007.runParsing( keyWord ,name ,url ,div ,title ,price ,cnt );
		System.out.println(name + " : " + list);

		assertNotSame(list,0);
	}

	/**
	 * 3개 사이트 전체실행 TEST
	 * @throws Exception
	 */
	@Test
	public void runAllTest() throws Exception {
		PrintWork.debugYn = true;
		WebApp007.run(FIX_WORD);

		assertNotNull( WebApp007.getList());
	}

}
