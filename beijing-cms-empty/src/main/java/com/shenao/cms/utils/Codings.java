package com.shenao.cms.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

import com.shenao.cms.core.CMSRuntimeException;

/**
 * 各种格式的编码加码工具类
 *
 * @author howsun(zjh@58.com)
 * @Date 2010-10-26
 * @version v0.1
 */
public abstract class Codings {

	public static final String GBK = "GBK";
	public static final String UTF8 = "UTF-8";
	public static final String UTF16 = "UTF-16";
	public static final String UTF16BE = "UTF-16BE";
	public static final String UTF16LE = "UTF-16LE";
	public static final String US_ASCII = "US-ASCII";
	public static final String ISO8859_1 = "ISO-8859-1";
	public static final Charset CHARSET_GBK = Charset.forName(GBK);
	public static final Charset CHARSET_UTF8 = Charset.forName(UTF8);
	public static final Charset CHARSET_ISO8859_1 = Charset.forName(ISO8859_1);

	/**
	 * 默认编码
	 * @return String
	 */
	public static String getDefaultEncoding(){
		return Charset.defaultCharset().name();
	}

	/**
	 * MD5加密
	 * @param origin
	 * @return 加密后的结果
	 */
	public static String MD5Encoding(String origin){
		return MD5.MD5Encoding(origin);
	}

	/**
	 * Base64编码
	 * @param input
	 * @return
	 */
	public static String base64Encode(byte[] input) {
		return new String(Base64.encodeBase64(input));
	}
	
	public static byte[] base64EncodeToBytes(byte[] input) {
		return Base64.encodeBase64(input);
	}
	 
	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符如+,/=转为其他字符, 见RFC3548).
	 * @param input
	 * @return
	 */
	public static String base64UrlSafeEncode(byte[] input) {
		return Base64.encodeBase64URLSafeString(input);
	}
	 
	/**
	 * Base64解码.
	 * @param input
	 * @return
	 */
	public static byte[] base64Decode(String input) {
		return Base64.decodeBase64(input);
	}
	 
	/**
	 * URL 编码, Encode默认为UTF-8. 
	 * @param input
	 * @return
	 */
	public static String urlEncode(String input) {
		try {
			return URLEncoder.encode(input, UTF8);
		} catch (Exception e) {
			throw new CMSRuntimeException("Unsupported Encoding CMSRuntimeException", e);
		}
	}
	 
	/**
	 * URL 解码, Encode默认为UTF-8. 
	 * @param input
	 * @return
	 */
	public static String urlDecode(String input) {
		try {
			return URLDecoder.decode(input, UTF8);
		} catch (Exception e) {
			throw new CMSRuntimeException("Unsupported Encoding CMSRuntimeException", e);
		}
	}
	 
	/**
	 * Hex编码.
	 * @param input
	 * @return
	 */
	public static String hexEncode(byte[] input) {
		return Hex.encodeHexString(input);
	}
	 
	/**
	 * Hex解码.
	 * @param input
	 * @return
	 *//*
	public static byte[] hexDecode(String input) {
		try {
			return Hex.decodeHex(input.toCharArray());
		} catch (Exception e) {
			throw new CMSRuntimeException("Hex Decoder exception", e);
		}
	}*/
	
	/**
	 * Html 转码.

	public static String htmlEscape(String html) {
		return StringEscapeUtils.escapeHtml(html);
	}
	 */
	/**
	 * Html 解码.

	public static String htmlUnescape(String htmlEscaped) {
		return StringEscapeUtils.unescapeHtml(htmlEscaped);
	}
	 */
	
	/**
	 * Xml 转码.

	public static String xmlEscape(String xml) {
		return StringEscapeUtils.escapeXml(xml);
	}
	 */
	/**
	 * Xml 解码.

	public static String xmlUnescape(String xmlEscaped) {
		return StringEscapeUtils.unescapeXml(xmlEscaped);
	}
	 */

	/**
	 * MD5加密算法
	 */
	static class MD5{

		private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
		private static MessageDigest md; 
		static {
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (Exception e) {}
		};
		public static String byteArrayToHexString(byte[] b) { 
			StringBuffer resultSb = new StringBuffer();

			for (int i = 0; i < b.length; ++i) {
				resultSb.append(byteToHexString(b[i]));
			}
			return resultSb.toString(); 
		}

		private static String byteToHexString(byte b){
			int n = b;
			if (n < 0)
				n += 256;
			int d1 = n / 16;
			int d2 = n % 16;
			return hexDigits[d1] + hexDigits[d2];
		}

		public static String MD5Encoding(String origin) {
			String resultString = null;
			try{
				resultString = new String(origin);
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			}
			catch (Exception localException) {
			}
			return resultString;
		}
	}


	static class Hex{

	    /**
	     * Used to build output as Hex
	     */
	    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	    /**
	     * Used to build output as Hex
	     */
	    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	    /**
	     * Converts an array of characters representing hexadecimal values into an array of bytes of those same values. The
	     * returned array will be half the length of the passed array, as it takes two characters to represent any given
	     * byte. An exception is thrown if the passed char array has an odd number of elements.
	     * 
	     * @param data
	     *            An array of characters containing hexadecimal digits
	     * @return A byte array containing binary data decoded from the supplied char array.
	     * @throws DecoderException
	     *             Thrown if an odd number or illegal of characters is supplied
	     */
	    public static byte[] decodeHex(char[] data) throws CMSRuntimeException {

	        int len = data.length;

	        if ((len & 0x01) != 0) {
	            throw new CMSRuntimeException("Odd number of characters.");
	        }

	        byte[] out = new byte[len >> 1];

	        // two characters form the hex value.
	        for (int i = 0, j = 0; j < len; i++) {
	            int f = toDigit(data[j], j) << 4;
	            j++;
	            f = f | toDigit(data[j], j);
	            j++;
	            out[i] = (byte) (f & 0xFF);
	        }

	        return out;
	    }

	    /**
	     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
	     * The returned array will be double the length of the passed array, as it takes two characters to represent any
	     * given byte.
	     * 
	     * @param data
	     *            a byte[] to convert to Hex characters
	     * @return A char[] containing hexadecimal characters
	     */
	    public static char[] encodeHex(byte[] data) {
	        return encodeHex(data, true);
	    }

	    /**
	     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
	     * The returned array will be double the length of the passed array, as it takes two characters to represent any
	     * given byte.
	     * 
	     * @param data
	     *            a byte[] to convert to Hex characters
	     * @param toLowerCase
	     *            <code>true</code> converts to lowercase, <code>false</code> to uppercase
	     * @return A char[] containing hexadecimal characters
	     * @since 1.4
	     */
	    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
	        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
	    }

	    /**
	     * Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
	     * The returned array will be double the length of the passed array, as it takes two characters to represent any
	     * given byte.
	     * 
	     * @param data
	     *            a byte[] to convert to Hex characters
	     * @param toDigits
	     *            the output alphabet
	     * @return A char[] containing hexadecimal characters
	     * @since 1.4
	     */
	    protected static char[] encodeHex(byte[] data, char[] toDigits) {
	        int l = data.length;
	        char[] out = new char[l << 1];
	        // two characters form the hex value.
	        for (int i = 0, j = 0; i < l; i++) {
	            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
	            out[j++] = toDigits[0x0F & data[i]];
	        }
	        return out;
	    }

	    /**
	     * Converts an array of bytes into a String representing the hexadecimal values of each byte in order. The returned
	     * String will be double the length of the passed array, as it takes two characters to represent any given byte.
	     * 
	     * @param data
	     *            a byte[] to convert to Hex characters
	     * @return A String containing hexadecimal characters
	     * @since 1.4
	     */
	    public static String encodeHexString(byte[] data) {
	        return new String(encodeHex(data));
	    }

	    /**
	     * Converts a hexadecimal character to an integer.
	     * 
	     * @param ch
	     *            A character to convert to an integer digit
	     * @param index
	     *            The index of the character in the source
	     * @return An integer
	     * @throws DecoderException
	     *             Thrown if ch is an illegal hex character
	     */
	    protected static int toDigit(char ch, int index) throws CMSRuntimeException {
	        int digit = Character.digit(ch, 16);
	        if (digit == -1) {
	            throw new CMSRuntimeException("Illegal hexadecimal charcter " + ch + " at index " + index);
	        }
	        return digit;
	    }

	    private final String charsetName;

	    
	    public Hex() {
	        this.charsetName = UTF8;
	    }

	    /**
	     * Creates a new codec with the given charset name.
	     * 
	     * @param csName
	     *            the charset name.
	     * @since 1.4
	     */
	    public Hex(String csName) {
	        this.charsetName = csName;
	    }

	    /**
	     * Converts an array of character bytes representing hexadecimal values into an array of bytes of those same values.
	     * The returned array will be half the length of the passed array, as it takes two characters to represent any given
	     * byte. An exception is thrown if the passed char array has an odd number of elements.
	     * 
	     * @param array
	     *            An array of character bytes containing hexadecimal digits
	     * @return A byte array containing binary data decoded from the supplied byte array (representing characters).
	     * @throws DecoderException
	     *             Thrown if an odd number of characters is supplied to this function
	     * @see #decodeHex(char[])
	     */
	    public byte[] decode(byte[] array) throws CMSRuntimeException {
	        try {
	            return decodeHex(new String(array, getCharsetName()).toCharArray());
	        } catch (Exception e) {
	            throw new CMSRuntimeException(e.getMessage(), e);
	        }
	    }

	    /**
	     * Converts a String or an array of character bytes representing hexadecimal values into an array of bytes of those
	     * same values. The returned array will be half the length of the passed String or array, as it takes two characters
	     * to represent any given byte. An exception is thrown if the passed char array has an odd number of elements.
	     * 
	     * @param object
	     *            A String or, an array of character bytes containing hexadecimal digits
	     * @return A byte array containing binary data decoded from the supplied byte array (representing characters).
	     * @throws DecoderException
	     *             Thrown if an odd number of characters is supplied to this function or the object is not a String or
	     *             char[]
	     * @see #decodeHex(char[])
	     */
	    public Object decode(Object object) throws CMSRuntimeException {
	        try {
	            char[] charArray = object instanceof String ? ((String) object).toCharArray() : (char[]) object;
	            return decodeHex(charArray);
	        } catch (ClassCastException e) {
	            throw new CMSRuntimeException(e.getMessage(), e);
	        }
	    }

	    /**
	     * Converts an array of bytes into an array of bytes for the characters representing the hexadecimal values of each
	     * byte in order. The returned array will be double the length of the passed array, as it takes two characters to
	     * represent any given byte.
	     * <p>
	     * The conversion from hexadecimal characters to the returned bytes is performed with the charset named by
	     * {@link #getCharsetName()}.
	     * </p>
	     * 
	     * @param array
	     *            a byte[] to convert to Hex characters
	     * @return A byte[] containing the bytes of the hexadecimal characters
	     * @throws IllegalStateException
	     *             if the charsetName is invalid. This API throws {@link IllegalStateException} instead of
	     *             {@link UnsupportedEnCMSRuntimeException} for backward compatibility.
	     * @see #encodeHex(byte[])
	     */
	    public byte[] encode(byte[] array) {
	        return StringCodes.getBytesUnchecked(encodeHexString(array), getCharsetName());
	    }

	    /**
	     * Converts a String or an array of bytes into an array of characters representing the hexadecimal values of each
	     * byte in order. The returned array will be double the length of the passed String or array, as it takes two
	     * characters to represent any given byte.
	     * <p>
	     * The conversion from hexadecimal characters to bytes to be encoded to performed with the charset named by
	     * {@link #getCharsetName()}.
	     * </p>
	     * 
	     * @param object
	     *            a String, or byte[] to convert to Hex characters
	     * @return A char[] containing hexadecimal characters
	     * @throws EncoderException
	     *             Thrown if the given object is not a String or byte[]
	     * @see #encodeHex(byte[])
	     */
	    public Object encode(Object object) throws CMSRuntimeException {
	        try {
	            byte[] byteArray = object instanceof String ? ((String) object).getBytes(getCharsetName()) : (byte[]) object;
	            return encodeHex(byteArray);
	        } catch (Exception e) {
	            throw new CMSRuntimeException(e.getMessage(), e);
	        }
	    }

	    /**
	     * Gets the charset name.
	     * 
	     * @return the charset name.
	     * @since 1.4
	     */
	    public String getCharsetName() {
	        return this.charsetName;
	    }

	    /**
	     * Returns a string representation of the object, which includes the charset name.
	     * 
	     * @return a string representation of the object.
	     */
	    public String toString() {
	        return super.toString() + "[charsetName=" + this.charsetName + "]";
	    }
	}
}
