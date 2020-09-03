package com.yun.common.util;

//import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Pattern;

@Service("FashiongoStringUtil")
public class StringUtil {
	static Logger logger= LoggerFactory.getLogger(StringUtil.class);
	/**
	 * 문자열을 특정문자로 분리하여 사용
	 *
	 * @param str
	 *            str 분리될 원본 문자열
	 * @param delim
	 *            delim 구분자로 사용될 문자
	 * @return String[]
	 *
	 * @sample StringUtil.strSplit("aaa,bbb", "," )
	 */
	public static String[] strSplit(String str, String delim) {
		StringTokenizer st = new StringTokenizer(str, delim);
		Vector vec = new Vector();
		int cnt = st.countTokens();
		String[] tokens = null;

		if (cnt == 1) {
			tokens = new String[1];
			tokens[0] = str;
		} else {
			for (int i = 0; i < cnt; i++)
				vec.addElement(st.nextToken());
			tokens = new String[cnt];
			vec.copyInto(tokens);
			vec.clear();
			vec = null;
		}
		return tokens;
	}

	/**
	 * Character Set를 ISO-8859-1로 컨버전
	 *
	 * @param str
	 *            변환할 문자
	 * @return String 변환문자
	 */
	public static String convUs(String str) {
		String tmp = new String("");
		if (str == null || str.length() == 0)
			return "";
		try {
			tmp = new String(str.getBytes("EUC-KR"), "8859_1");
		} catch (Exception e) {

		}
		return tmp;
	}


	/**
	 * Character Set를 EUC-KR로 컨버전
	 *
	 * @param str
	 *            변환할 문자
	 * @return String 변환문자
	 */
	public static String convKor(String str) {
		String tmp = new String("");
		if (str == null || str.length() == 0)
			return "";
		try {
			tmp = new String(str.getBytes("8859_1"), "EUC-KR");
		} catch (Exception e) {

		}
		return tmp;

	}

	/**
	 * 입력된 문자열이 null 일경우 기본문자열을 리턴한다.
	 *
	 * @param str
	 *            문자열
	 * @param def
	 *            기본 문자열
	 * @return
	 */
	public static String convNull(String str, String def) {
		if (isNull(str))
			return def;
		return str;
	}

	/**
	 * Object가 null 일경우 기본문자열을 리턴한다.
	 * @author taz
	 * @param obj
	 * @param def 기본 문자열
	 * @return
	 */
	public static String convNullObj(Object obj, String def) {
		if (obj==null )
			return def;
		return obj.toString();
	}

	/**
	 * Object가 null 일경우 기본문자열을 리턴한다.
	 * @author taz
	 * @param obj
	 * @param def 기본 문자열
	 * @return
	 */
	public static String convNullObjKor(Object obj, String def) {
		if (obj==null)
			return def;
		return convKor(obj.toString());
	}

	/**
	 * null 또는 공백문자인지 확인한다.
	 *
	 * @param str
	 *            문자열
	 * @return
	 */
	public static boolean isNull(String str) {
		return (str == null || str.trim().length() < 1 || str == "null"  || str == "NULL" ||  str.equals("NULL"));
	}
	
	/**
	 * null 일 경우 공백을 리턴 한다.
	 *
	 * @param str
	 *            문자열
	 * @return
	 */
	public static String Null(String str) {
		if(str == null){
			return "";
		}
		
		return str;
	}
	/**
	 * null 일 경우 공백을 리턴 한다.
	 *
	 * @param str
	 *            문자열
	 * @return
	 */
	public static String NullStr(String str) {
		
		String rtnStr = "";
		if(str == null){
			return "";
		}else{
			rtnStr = str.toLowerCase();
			
			if("".equals(rtnStr)){
				return "";
			}else if("null".equals(rtnStr)){
				return "";
			}
		}
		
		return str;
	}
	
	/**
	 * null 일 경우 value를 리턴 한다.
	 *
	 * @param str
	 *            문자열
	 * @param value
	 *            문자열
	 * @return
	 */
	public static String Null(String str, String value) {
		if(str == null){
			return value;
		}
		
		return str;
	}
	
	/**
	 * null 이거나 값이 없을 때 value 리턴한다.
	 */
	public static String NVL(String str, String value) {
		if(str == null || "".equals(str)){
			return value;
		}
		
		return str;
	}
	
	
	
	/**
	 * 문자 열 속에 포함 된 특정 문자를 새로운 문자로 변경 -> 문제있음
	 *
	 * @param s1
	 *            s1 문자열
	 * @param s2
	 *            s2 이전문자
	 * @param s3
	 *            s3 바뀔문자
	 * @return String 변환 된 문자열
	 */
	public static String strReplace(String s1, String s2, String s3) {
		if (s1 == null)
			return "";
		String res = "";
		StringTokenizer str = new StringTokenizer(s1, s2);

		while (str.hasMoreTokens()) {
			res += str.nextToken() + s3;
		}

		return res;
	}

    /****************************************************************
    문자열 내의 특정 문자열을 다른 문자열로 바꾼다.
    in        : String [ abcde, ab, xy ]
    out    : String [ xycde ]
	****************************************************************/
	public static String replaceStr(String src, String oldstr, String newstr) {
	    if (src == null)
	        return null;
	    StringBuffer dest = new StringBuffer("");
	    int  len = oldstr.length();
	    int  srclen = src.length();
	    int  pos = 0;
	    int  oldpos = 0;
	    while ((pos = src.indexOf(oldstr, oldpos)) >= 0) {
	        dest.append(src.substring(oldpos, pos));
	        dest.append(newstr);
	        oldpos = pos + len;
	    }
	    if (oldpos < srclen)
	        dest.append(src.substring(oldpos, srclen));
	    return dest.toString();
	}

	/**
	 * 문자열에서 HTML 태그 제거
	 *
	 * @param s
	 * @return
	 */
	public static String removeTag(String s) {
		if (s == null)
			return "";
		final int NORMAL_STATE = 0;
		final int TAG_STATE = 1;
		final int START_TAG_STATE = 2;
		final int END_TAG_STATE = 3;
		final int SINGLE_QUOT_STATE = 4;
		final int DOUBLE_QUOT_STATE = 5;
		int state = NORMAL_STATE;
		int oldState = NORMAL_STATE;
		char[] chars = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		char a;
		for (int i = 0; i < chars.length; i++) {
			a = chars[i];
			switch (state) {
			case NORMAL_STATE:
				if (a == '<')
					state = TAG_STATE;
				else
					sb.append(a);
				break;
			case TAG_STATE:
				if (a == '>')
					state = NORMAL_STATE;
				else if (a == '\"') {
					oldState = state;
					state = DOUBLE_QUOT_STATE;
				} else if (a == '\'') {
					oldState = state;
					state = SINGLE_QUOT_STATE;
				} else if (a == '/')
					state = END_TAG_STATE;
				else if (a != ' ' && a != '\t' && a != '\n' && a != '\r'
						&& a != '\f')
					state = START_TAG_STATE;
				break;
			case START_TAG_STATE:
			case END_TAG_STATE:
				if (a == '>')
					state = NORMAL_STATE;
				else if (a == '\"') {
					oldState = state;
					state = DOUBLE_QUOT_STATE;
				} else if (a == '\'') {
					oldState = state;
					state = SINGLE_QUOT_STATE;
				} else if (a == '\"')
					state = DOUBLE_QUOT_STATE;
				else if (a == '\'')
					state = SINGLE_QUOT_STATE;
				break;
			case DOUBLE_QUOT_STATE:
				if (a == '\"')
					state = oldState;
				break;
			case SINGLE_QUOT_STATE:
				if (a == '\'')
					state = oldState;
				break;
			}
		}
		return sb.toString();

	}

	/**
	 * Method cropByte. 문자열 바이트수만큼 끊어주고, 생략표시하기
	 *
	 * @param str
	 *            문자열
	 * @param i
	 *            바이트수
	 * @param trail
	 *            생략 문자열. 예) "..."
	 * @return String
	 */
	public static String cropByte(String str, int i, String trail) {
		if (str == null)
			return "";
		String tmp = str;
		int slen = 0, blen = 0;
		char c;
		try {
			if(tmp.getBytes("MS949").length>i) {//2-byte character..
			//if (tmp.getBytes("UTF-8").length > i) {// 3-byte character..
				while (blen + 1 < i) {
					c = tmp.charAt(slen);
					blen++;
					slen++;
					if (c > 127)
						blen++;
				}
				tmp = tmp.substring(0, slen) + trail;
			}
		} catch (Exception e) {
		}
		return tmp;
	}

	

	/**
	 * 각 인덱스의 문자가 소문자라면 대문자로 변환
	 *
	 * @param str
	 *            문자열
	 * @return String
	 */
	public static String bigLetter(String str) {
		// String tmp = str;
		String convertStr = "";
		char[] charArray = str.toCharArray(); // Char[]로 변환

		for (int i = 0; i < str.length(); i++) {
			// logger.debug("Char["+i+"] = "+charArray[i]); //변환된 Char 출력
			if ((charArray[i] >= 97) && (charArray[i] <= 122)) {
				charArray[i] -= 32; // 각 인덱스의 문자가 소문자라면 대문자로 변환
				convertStr += charArray[i];
			}
		}

		return convertStr;
	}

	/**
	 * 각 인덱스의 문자가 대문자라면 소문자로 변환
	 *
	 * @param str
	 *            문자열
	 * @return String
	 */
	public static String smallLetter(String str) {
		// String tmp = str;
		String convertStr = "";
		char[] charArray = str.toCharArray(); // Char[]로 변환

		for (int i = 0; i < str.length(); i++) {
			// logger.debug("Char["+i+"] = "+charArray[i]); //변환된 Char 출력
			if ((charArray[i] >= 65) && (charArray[i] <= 90)) {
				charArray[i] += 32; // 각 인덱스의 문자가 대문자라면 소문자로 변환
				convertStr += charArray[i];
			}
		}

		return convertStr;
	}

	/**
	 * 파라미터값을 체크
	 * 한글이 넘어오면 URLEncoder
	 * @param str
	 *            변환할 문자
	 * @return String 변환문자
	 */
	public static String paramCheck(String str) {
		String tmp = new String("");
		if (str == null || str.length() == 0)
			return "";
		try {
			// 첫번째 문자값을 읽음..
	        int i = str != null && str.length() > 0 ? str.charAt(0) : -1;
	        // 만일 164(%A4)이상 200(%C8)이하라면 iso-8859-1로 인코딩 한것이므로,

	        // 이때는 다시 인코딩을 조정한다.
	        str = str != null ? (i >= 164 && i <= 200 ? new String (str.getBytes("iso-8859-1"), "euc-kr") : str) : null;

	        //tmp = URLEncoder.encode(str);
	        tmp = URLEncoder.encode(str, "euc-kr");

		} catch (Exception e) {

		}
		return tmp;
	}



	/**
	 * getParameterMap() 으로 받은 파라미터를 HashMap으로 치환
	 *
	 * @version
	 * @param requestMap
	 *            requestMap
	 * @return HashMap hm
	 * @throws Exception
	 *
	 */
	public static Map paramsToHashMap(Map requestMap) throws Exception {
		HashMap hm = new HashMap();

		try {
			Iterator it = requestMap.keySet().iterator();
			Object key = null;
			String[] value = null;

			while (it.hasNext()) {
				key = it.next();
				value = (String[]) requestMap.get(key);

				for (int i = 0; i < value.length; i++) {
					hm.put(key, value[i].toString());
				}
			}
		} catch (Exception e) {
			throw new Exception(e.toString());
		}

		return hm;
	}

	/**
	 * getParameterMap() 으로 받은 파라미터를 QueryString으로 치환
	 *
	 * @version
	 * @param requestMap
	 *            requestMap
	 * @return String (a=1&b=2&c=3....)
	 * @throws Exception
	 *
	 */
	public static String paramsToQueryString(Map requestMap) throws Exception {
		StringBuffer sp = new StringBuffer();
		int loopCnt = 0;

		try {
			Iterator it = requestMap.keySet().iterator();
			Object key = null;
			String[] value = null;

			while (it.hasNext()) {
				key = it.next();
				value = (String[]) requestMap.get(key);

				for (int i = 0; i < value.length; i++) {
					if (!"cmd".equals(key.toString())
							&& !"returnCmd".equals(key.toString())) {
						if (loopCnt > 0)
							sp.append("&");
						sp.append(key.toString() + "=" + value[i].toString());
					}
				}

				loopCnt++;
			}
		} catch (Exception e) {
			throw new Exception(e.toString());
		}

		return sp.toString();
	}

	/**
	 * getParameterMap() 으로 받은 파라미터를 QueryString으로 치환 cmd포함
	 *
	 * @version
	 * @param requestMap
	 *            requestMap
	 * @return String (a=1&b=2&c=3....)
	 * @throws Exception
	 *
	 */
	public static String paramsToQueryStringWithCmd(Map requestMap)
			throws Exception {
		StringBuffer sp = new StringBuffer();
		int loopCnt = 0;

		try {
			Iterator it = requestMap.keySet().iterator();
			Object key = null;
			String[] value = null;

			while (it.hasNext()) {
				key = it.next();
				value = (String[]) requestMap.get(key);

				for (int i = 0; i < value.length; i++) {
					if (loopCnt > 0)
						sp.append("&");
					sp.append(key.toString() + "=" + paramCheck(value[i].toString()));
					// logger.debug(key.toString() + " => " + value[i].toString());
					// sp.append(key.toString() + "=" + convEUCKR(value[i].toString()));

					// 파라미터명이 같은 것들이 반복해서 들어오면 &가 추가되지 않는다.
					// 즉, order라는 파라미터명으로 2개의 파라미터가 들어오면 order=2order=3 이렇게 파라미터가 넘어가게 된다.
					// for loop 안에서 loopCnt를 증가시켜야 한다. 2009.09.23 김지연
					loopCnt++;
				}

				//loopCnt++;
			}
		} catch (Exception e) {
			throw new Exception(e.toString());
		}

		return sp.toString();
	}

	/**
	 * 문자열을 토큰으로 구분해서 1차원 배열로 리턴한다.
	 *
	 * @param s -
	 *            토큰을 가진 문자열
	 * @param token -
	 *            구분자
	 * @return 구분자로 분리된 1차원배열
	 */
	public static String[] cutTokenToArray(String s, String token) {
		StringTokenizer stz = new StringTokenizer(s, token);
		String result[] = new String[stz.countTokens()];
		try {
			for (int j = 0; j < result.length; j++)
				result[j] = stz.nextToken();
		} catch (Exception exception) {
		}
		return result;
	}


	/**
	 * 휴대폰번호국번을 배열로 리턴
	 *
	 * @return 구분자로 분리된 1차원배열
	 */
	public static String[] getMobileNo() {
		String mobileNo = "010,011,016,017,018,019";

		return mobileNo.split(",");
	}

	/**
	 * 일반전화국번을 배열로 리턴
	 *
	 * @return 구분자로 분리된 1차원배열
	 */
	public static String[] getTelNo() {
		String telNo = "02,031,032,033,041,042,043,051,052,053,054,055,061,062,063,064";

		return telNo.split(",");
	}

	

	/**
	 * 가격을 ###,###,###,### 형태로 리턴
	 *
	 * @return ###,###,###,### 형태의 String
	 */
	public static String comma1(int aa) {
		DecimalFormat fmt1 = new DecimalFormat("###,###,###,###");
		String str = fmt1.format(aa);
		return str;
	}

	

	/**
	 * 특수 문자 제거
	 * ( , ., ?, /, ~, !, @, #, $, %, ^, &, *, (, ), _, +, =, |, }, ], {, [, \, ', :, ;, <, ,, >)를 삭제한다.
	 * @param str
	 * @return String str
	 * @sample StringUtil.StringReplace(str)
	 */
	public static String StringReplace(String str){
	    String str_imsi   = "";
	    String[] filter_word = {" ","\\.","\\?","\\/","\\~","\\!","\\@","\\#","\\$","\\%","\\^","\\&","\\*","\\(","\\)","\\_","\\+","\\=","\\|","\\}","\\]","\\{","\\[","\\\"","\\'","\\:","\\;","\\<","\\,","\\>"};

	    for(int i=0;i<filter_word.length;i++){
	        str_imsi = str.replaceAll(filter_word[i],"");
	        str = str_imsi;
	    }

	    return str;
	}

	/**
	 * 문자 cutting
	 * @param str
	 * @return String str
	 * @sample StringUtil.strCut(str)
	 */
	public static String strCut(String str, int len) {

		
		if(null != str){
			byte[] by = str.getBytes();
			int count = 0;
			if(by.length > len){
				
				try  {
					for(int i = 0; i < len; i++) {
						if((by[i] & 0x80) == 0x80) count++;
					}
					if((by[len - 1] & 0x80) == 0x80 && (count % 2) == 1) len--;
					return new String(by, 0, len);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					e.printStackTrace();
					return "";
				}
			}else{
				return str;
			}
		}else{
			return "";
		}
		
	}

	/**
	 * 문자열에 대한 MD5 암호화후 암호화된 Str을 리턴
	 * @param str
	 * @return String str
	 * @sample StringUtil.ciperMd5(str)
	 */
    public static String ciperMd5(String str)
    {
	    StringBuffer sb = new StringBuffer();

	    try{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte[] md5bytes = md5.digest();

			for(int i = 0;  i < md5bytes.length; i++){
				sb.append( Integer.toString( ( md5bytes[i] & 0xf0) >> 4, 16 ) );
			    sb.append( Integer.toString( md5bytes[i] & 0x0f, 16 ) );
			}

			return sb.toString();
	    }catch(Exception er){
	    	logger.debug(er.getMessage());
	    	return "";
	    }
    }

    /**
	 * HTML 문자열을 HTML에서 사용되는 특수문자로 변환한다.(XSS,SQL-INJECT 대응가능)
	 *
	 * @param str
	 * @return		변환된 문자열.
	 */
	public static String replaceSpecialChar(String str) {
        String str1 = null;

        str1 = str.replaceAll("[<]","&lt");
        str1 = str1.replaceAll("[>]","&gt");
        str1 = str1.replaceAll("[\"]","&#34;");
        str1 = str1.replaceAll("[|]","&#124;");
        str1 = str1.replaceAll("[$]","&#36;");
        str1 = str1.replaceAll("[']","&#39;");
        str1 = str1.replaceAll("[(]","&#40;");
        str1 = str1.replaceAll("[)]","&#41;");
        str1 = str1.replaceAll("-","&#39");
        str1 = str1.replaceAll(";","&#39");
        //str1 = str1.replaceAll("[%]","&#37;");
        //str1 = str1.replaceAll("[,]","&#44;");
        //str1 = str1.replaceAll("[/]","&#47;");
        //str1 = str1.replaceAll("[/]","&#47;");

        return str1;
    }


	/**
	 * String날짜형식을 변환값에 맞게 리턴
	 * @param str 변환할 문자
	 * @return String 구분문자
	 */
	public static String strDateFormat(String str,String dim) {
		String tmp = new String("");

		if (str == null || str.length() < 8)
			return "";
		try {
            tmp = str.substring(0,4) + dim;
			tmp += str.substring(4,6) + dim;
			tmp += str.substring(6,8);
		} catch (Exception e) {

		}
		return tmp;
	}

	/**
	 * String의 원하는 위치(전/후)에 0을 원하는 갯수만큼 추가한다.
	 *
	 * @author taz
	 * @param str
	 * @param size
	 * @param align
	 * @return String
	 * @throws Exception
	 *
	 */
	public static String fillingZero(String str, int size, int align) {
	    byte bts[] = str.getBytes();
	    int len = bts.length;
	    if (len >= size)
	        return str;

	    if (len < size) {
	        int cnt = size - len;
	        char values[] = new char[cnt];
	        for(int idx = 0; idx < cnt; idx++)
	            values[idx] = '0';

	        if (align == 1)
	            return (new StringBuilder(String.valueOf(String.copyValueOf(values)))).append(str).toString();
	        else
	            return (new StringBuilder(String.valueOf(str))).append(String.copyValueOf(values)).toString();
	    } else {
	        return str;
	    }
	}

	/**
	 * 패스워드에 대한 MD5 decoding
	 *
	 * @author taz
	 * @param pass
	 * @return String
	 * @throws Exception
	 *
	 */
	public static String decodePassword(String pass) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(pass.getBytes());
		byte[] md5bytes = md5.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < md5bytes.length; i++) {
			sb.append(Integer.toString((md5bytes[i] & 0xf0) >> 4, 16));
			sb.append(Integer.toString(md5bytes[i] & 0x0f, 16));
		}
		String resultPasswd = sb.toString();
		return resultPasswd;
	}

    /**
     * 기본 적인 xxs 외 추가   확인하면서 치환할게 생기면 추가
     */
 	public static String xxsReplace(String str) {
 		str = str.replace("<script", "[script");
 		str = str.replace("/script>", "/script]");
 		str = str.replace("&lt;script", "[script");
 		str = str.replace("/script&gt;", "/script]");
        str = str.replace( "eval\\((.*)\\)", "");
        str = str.replace( "[\\\"\\'][\\s]*javascript:(.*)[\\\"\\']", "\"\"");
        str = str.replace( "[\\\"\\'][\\s]*vbscript:(.*)[\\\"\\']", "\"\"");
        str = str.replace( "document.cookie", "&#100;&#111;&#99;&#117;&#109;&#101;&#110;&#116;&#46;&#99;&#111;&#111;&#107;&#105;&#101;");
        str = str.replace( "<script", "&lt;script");
        str = str.replace( "script>", "script&gt;");
        str = str.replace( "<object", "&lt;object");
        str = str.replace( "<embed", "&lt;embed");
        str = str.replace( "onload", "no_onload");
        str = str.replace( "expression", "no_expression");
        str = str.replace( "onmouseover", "no_onmouseover");
        str = str.replace( "onmouseout", "no_onmouseout");
        str = str.replace( "onclick", "no_onclick");
        return str;
 	}
 	
	public static String escapeDB(String str){
		StringBuffer sb = new StringBuffer();
		int n = str.length();
		for (int i = 0; i < n; i++) 
		{
			 char c = str.charAt(i);
			 switch (c) 
			{
				case '"': sb.append(""); break;
				case '\'': sb.append("");break;
				default:  sb.append(c); break;
			}
		
		}
		return sb.toString();
	}
	
	public static String cutFirstStrInByte(String str, int endIndex, boolean ellipsisFlag){
		StringBuffer sbStr = new StringBuffer(endIndex);
		int iTotal = 0;
		
		for(char c: str.toCharArray()){
			iTotal += String.valueOf(c).getBytes().length;
			
			if(iTotal > endIndex){
				break;
			}
			sbStr.append(c);
		}
		
		if((iTotal > endIndex) && (ellipsisFlag) ){
			sbStr.append("...");
		}
		
		
		return sbStr.toString();
	 }
	
	public static String getRealFileName(String str){
		
		 String _name = str;
		 int idx = _name.lastIndexOf('/');
		 String fileNameReal = _name.substring((idx+1),_name.lastIndexOf('.'));
		
		 return fileNameReal;
	}
	
	/**
	 * 문자열 Byte 체크
	 * @param str
	 * @return int
	 */
	
	public static int strByteLengthCheck(String str){
		int strLength = 0 ;
		byte[] bytes;
		try {
			bytes = str.getBytes("UTF-8");
			strLength = bytes.length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strLength;
	}
	
	/**
	 * 문자열 길이 체크
	 * @param str
	 * @return int
	 */
	
	public static boolean strLengthCheck(String str, int max){
		boolean rtnFlag = false;
		int strLength = 0 ;
		
		if(null != str){
			strLength = str.length();
			
			if(strLength > max){
				rtnFlag = true;
			}
		}
		
		return rtnFlag;
	}
	
	/**
	 * 문자열 Byte 자르기 
	 * @param str		: 문자열
	 * @param nByte
	 * @param isNotag
	 * @param isAdddot
	 * @return
	 */
	public static String strByteCut(String str, int nByte, boolean isNotag, boolean isAdddot ,boolean isExt) {
		String rtnStr = str;
		
		int oL = 0, rF = 0, rL = 0;
		Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE); // 태그제거 패턴

		if (isNotag) {// 태그 제거
			rtnStr = p.matcher(rtnStr).replaceAll("");
		}
		
		rtnStr = rtnStr.replaceAll("&amp;", "&").replaceAll("(!/|\r|\n|&nbsp;)", ""); // 공백제거

		try {
			byte[] bytes = rtnStr.getBytes("UTF-8"); // 바이트로 보관
			int byteLen = bytes.length;
			
			if(byteLen > nByte){
				
				
				int j = 0;
				while (j < byteLen) {
					if ((bytes[j] & 0x80) != 0) {
						if (oL + 2 > nByte) {
							break;
						}
						oL += 2;
						rL += 3;
						j += 3;
					} else {
						if (oL + 1 > nByte) {
							break;
						}
						++oL;
						++rL;
						++j;
					}
				}
				rtnStr = new String(bytes, rF, rL, "UTF-8"); // charset 옵션
				
				// ...을 붙일지말지 옵션
				if (isAdddot) {
					rtnStr += "...";
					
				}
				
				
			}else{
			}
		} catch (Exception e) {
			logger.debug("strByteCut Exception Str : "+ rtnStr);
			//e.printStackTrace();
		}

		return rtnStr;
	}
	
	/**
	 * 문자열 Byte 자르기 
	 * @param str		: 문자열
	 * @param nByte
	 * @param isNotag
	 * @param isAdddot
	 * @return
	 */
	public static String strByteCut(String str, int nByte, boolean isNotag, boolean isAdddot) {

		
		String rtnStr = "";
		String ext = "";
				
		
		if(str.lastIndexOf(".") > -1){
			rtnStr = str.substring(0,str.lastIndexOf("."));
			ext = str.substring(str.lastIndexOf("."),str.length());
		}else{
			rtnStr = str;
			
		}
		
		
		int oL = 0, rF = 0, rL = 0;
		Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE); // 태그제거 패턴

		if (isNotag) {// 태그 제거
			rtnStr = p.matcher(rtnStr).replaceAll("");
		}
		
		rtnStr = rtnStr.replaceAll("&amp;", "&").replaceAll("(!/|\r|\n|&nbsp;)", ""); // 공백제거

		try {
			byte[] bytes = rtnStr.getBytes("UTF-8"); // 바이트로 보관
			int byteLen = bytes.length;
			
			if(byteLen > nByte){
				int j = 0;
				while (j < byteLen) {
					if ((bytes[j] & 0x80) != 0) {
						if (oL + 2 > nByte) {
							break;
						}
						oL += 2;
						rL += 3;
						j += 3;
					} else {
						if (oL + 1 > nByte) {
							break;
						}
						++oL;
						++rL;
						++j;
					}
				}
				rtnStr = new String(bytes, rF, rL, "UTF-8"); // charset 옵션
				
				// ...을 붙일지말지 옵션
				if (isAdddot) {
					rtnStr += "...";
					rtnStr += ext;
					
					
				}
				
			}else{
				rtnStr += ext;
			}
		} catch (Exception e) {
			logger.debug("strByteCutWithExt Exception Str : "+ rtnStr);
		}

		return rtnStr;
	}
	
	public static String bytecv(double fileSize) {
		String fileSizeText = "";
		String displayCapacity = "";
		if (fileSize >= 1024) {
			fileSize = fileSize / 1024;
			if (fileSize >= 1024) {
				fileSize = fileSize / 1024;
				if (fileSize >= 1024) {
					fileSize = fileSize / 1024;
					displayCapacity = "GB";
				} else {
					displayCapacity = "MB";
				}
			} else {
				displayCapacity = "KB";
			}
			fileSizeText = (new DecimalFormat("0.0")).format(fileSize)
					+ displayCapacity;
		} else {
			fileSizeText = (double) fileSize + "Byte";
		}
		return fileSizeText;
	}
	
	
	/**
	 * 출력 문자열 길이를 기준으로 원본 스트링 왼쪽부터 특정 문자로 padding 한다.
	 * @param src
	 * @param ch
	 * @param num
	 * @return
	 */
	public static String lpad(String src, String ch, int num) {
		String result = "";
		if (src == null || src.length() >= num) {
			return src;
		}

		int cnt = num - src.length();
		for (int i = 0; i < cnt; i++) {
			result += ch;
		}
		return result + src;
	}


	/**
	 * 출력 문자열 길이를 기준으로 원본 스트링 오른쪽부터 특정 문자로 padding 한다.
	 * @param src
	 * @param ch
	 * @param num
	 * @return
	 */
	public static String rpad(String src, String ch, int num) {
		String result = "";
		if (src == null || src.length() >= num) {
			return src;
		}
		int cnt = num - src.length();
		for (int i = 0; i < cnt; i++) {
			result += ch;
		}
		return src + result;
	}	
	
//	public static String toGetUrlString(HashMap<String, Object> paramMap){
//
//		StringBuffer getURL = new StringBuffer();
//
//			// 파라미터를 기준으로 URL 정보에서 '?' 이 후의 URL을 생성
//		if (paramMap != null && !paramMap.isEmpty()) {
//				boolean isFirst = true;
//				for (String key : paramMap.keySet()) {
//					String value = "";
//
//					Object obj = paramMap.get(key);
//					if (obj == null) {
//						continue;
//					} else if (obj instanceof String) {
//						value = (String) obj;
//						if (StringUtils.isEmpty(value)) {
//							continue;
//						}
//					} else if (obj instanceof List) {
//						@SuppressWarnings("unchecked")
//						List<Object> lst = (List<Object>) obj;
//						if (lst.isEmpty()) {
//							continue;
//						}
//
//						value = StringUtils.join(lst.toArray(), ",");
//					} else if (obj instanceof String[]) {
//						String[] array = (String[]) obj;
//						if (array.length == 0) {
//							continue;
//						}
//
//						value = StringUtils.join(array, ",");
//					} else if (obj instanceof Object[]) {
//						Object[] array = (Object[]) obj;
//						if (array.length == 0) {
//							continue;
//						}
//
//						value = StringUtils.join(array, ",");
//					} else {
//						value = obj.toString();
//					}
//
//					if (isFirst) {
//						isFirst = false;
//
//						getURL.append("?");
//					} else {
//						getURL.append("&");
//					}
//
//					getURL.append(key).append("=").append(value);	//getURL.append(key).append("=").append(URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20")); // 인코딩
//				}
//
//
//			return getURL.toString();
//		}
//
//		return null;
//	}

	/**
	 * 파일 확장자 가져오기
	 * @param fileName
	 * @return
     */
	public static String getExt(String fileName){

		String ext = "";

		if(!"".equals(isNull(fileName))){
			int index = fileName.lastIndexOf(".");
			ext = fileName.substring(index+1);
		}

		return ext;

	}


    /**
     * 파일 업로드 보안을 위한 체크
     * @param fileName
     * @return
     */
	public static String getFileNameCheck(String fileName){
	    String retStr = fileName;

        if(!"".equals(isNull(fileName))){
            retStr = retStr.replaceAll("/","");
            retStr = retStr.replaceAll("\\\\","");
            retStr = retStr.replaceAll("&","");
        }

        return retStr;

    }

    /**
     * 램덤 UUID 생성
     * @return
     */
    public static String getUuid(){
	    String retUuid = "";

	    retUuid = UUID.randomUUID().toString();

	    return retUuid;

    }

    /**
     * 바이트 체크
     * @param txt  체크할 text
     * @param standardByte  체크 바이트
     * @return boolean
     */
    public static boolean byteCheck(String txt, int standardByte) {
        if (StringUtil.isNull(txt)) { return true; }

        int txtByte = checkByteForSms(txt);

        if (txtByte > standardByte) {
            return false;
        } else {
            return true;
        }

    }
    /**
     * SMS 바이트 체크
     * @param txt  체크할 text
     * @return string ERR / SMS / LMS
     */
    public static String isSmsbyteType(String txt) {
        if (StringUtil.isNull(txt)) { return "ERR"; }

        int smsByte = 80;

        int txtByte = checkByteForSms(txt);

        if (txtByte > smsByte) {
            return "LMS";
        } else {
            return "SMS";
        }

    }

    public static int checkByteForSms(String txt){
        // 바이트 체크 (영문 1, 한글 2, 특문 1)
        int en = 0;
        int ko = 0;
        int etc = 0;

        char[] txtChar = txt.toCharArray();
        for (int j = 0; j < txtChar.length; j++) {
            if (txtChar[j] >= 'A' && txtChar[j] <= 'z') {
                en++;
            } else if (txtChar[j] >= '\uAC00' && txtChar[j] <= '\uD7A3') {
                ko++;
                ko++;
            } else {
                etc++;
            }
        }

        int txtByte = en + ko + etc;

        return txtByte;
    }

    /**
     *  numberic check
     * @param strNum
     * @return
     */
    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }




}