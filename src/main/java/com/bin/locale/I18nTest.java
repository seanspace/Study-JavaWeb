package com.bin.locale;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class I18nTest {

	/**
	 * Local:Java中表示国家和地区的类.JDK中提供了很多常量.
	 * 也可以通过Locale(languageCode,countryCode)的方式来创建.
	 * 在WEB应用中通过request.getLocale()方法来获取.
	 */
	@Test
	public void testLocale(){
		Locale locale = Locale.CHINA ;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		
		locale = new Locale("en","US") ;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
	}
	
	/**
	 * 把date格式化为时间格式字符串.
	 * DateFormate本身是一个抽象类.
	 * 1.若只希望通过DateFormate把一个对象转换为一个字符串,可以通过静态工厂方法获取对象.
	 * 2.可以获取只格式化Date的DateFormate对象:getDateInstance(int style,Locale aLocale)
	 * 3.可以只格式化Time的DateFormate对象:getTimeInstance(int style,Locale aLocale)
	 * 4.可以获取既格式化Date,也格式化Time的DateFormate对象:
	 * 		getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)
	 * 5.其中Style可以取值为:DateFormate的常量:SHORT(短格式),MEDIUM,LONG(长格式),FULL.Locle则为代表国家地区的Locale对象.
	 * 6.通过DateFormate的formate方法来格式化一个Date对象到字符串.
	 * 6.若有一个字符串如何解析为一个Date对象
	 *   > 先创建DateFormate对象:创建DateFormate的子类simpleDateFormate对象
	 *   	SimpleDateFormate(String pattern)其中pattern为日期,时间的字符串,如:yyyy-MM-dd hh:mm:ss
	 *   > 调用parse方法,来解析字符串到对象.
	 */
	@Test
	public void testDateFormate(){
		Date date = new Date() ;
		System.out.println(date);
		
		Locale locale = Locale.CHINA ;
		
		// 获取DateFormate对象.
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM, locale) ;
		String str = dateFormat.format(date) ;
		System.out.println(str);
	}
	
	/**
	 * 日期时间字符串转换为date
	 */
	@Test
	public void testDateFormate2() throws ParseException{
		String str = "1990-12-12 12:12:12" ;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
		
		Date date= dateFormat.parse(str) ;
		System.out.println(date);
	}
	
	/**
	 * NumberFormate:格式化数字到数字字符串,或货币字符串;
	 * 1.通过工厂方法获取NumberFormate类:
	 * 		NumberFormat.getNumberInstance(locale)
	 * 2.NumberFormat.getCurrencyInstance(locale)
	 * 3.通过formate()方法格式化为字符串.
	 * 4.通过parse方法把一个字符串转换为Number类型.
	 */
	@Test
	public void testNumberFormateTest() throws ParseException{
		double d = 123456789.123d ;
		Locale locale = Locale.CHINA ;
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale) ;
		String string = numberFormat.format(d) ;
		
		System.out.println(string);//123,456,789.123
		
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale) ;
		string = numberFormat.format(d) ;
		System.out.println(string);//￥123,456,789.12
		
		string = "123,456,789.123" ;
		d = (Double) numberFormat.parse(string) ;
		System.out.println(d);
		
		string = "￥123,456,789.123" ;
		d = (Double) numberFormat2.parse(string) ;
		System.out.println(numberFormat2);//java.text.DecimalFormat@774c1
		System.out.println(d);
	}
	
	/**
	 * 模式字符串与占位符.
	 * "Date:{0},Salary:{1}"
	 */
	@Test
	public void testMessageFormat(){
		String string = "Date:{0},Salary:{1}" ;
		
		Locale locale = Locale.CHINA ;
		Date date = new Date() ;
		double sal = 12345.12 ;
		
//		MessageFormat messageFormat = new MessageFormat(string) ;
		String result = MessageFormat.format(string, date,sal) ;
		System.out.println(result);//Date:14-9-15 下午10:35,Salary:12,345.12
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale) ;
		String dateString = dateFormat.format(date);
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale) ;
		String salString = numberFormat.format(sal) ;
		
		String result2 = MessageFormat.format(string, dateString,salString) ;
		System.out.println(result2);//Date:2014-9-15,Salary:￥12,345.12
	}
	/**
	 * ResourceBundle:资源包类.
	 * 1.在类路径下需要有对应的资源文件:baseName.properties.其中baseName是基名.
	 * 2.可以使用基名_语言代码_国家代码.properties 来添加不同国家和地区的资源文件.i18n_zh_CN.properties
	 * 3.要求所有资源文件的key必须相同.
	 * 4.可以使用native2ascii命令来得到汉字对应的asc码.Eclipse内置了工具;
	 * 5.可以调用ResourceBundle的getBundle(基名,Locale实例)获取ResuourceBundle对象.
	 * 6.通过ResourceBundle的getString(key)获取值.
	 * 7.通过MessageFormate的format方法格式化字符串.
	 */
	@Test
	public void testResourceBundle(){
		Locale locale = Locale.US;
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n",locale) ;
		
		System.out.println(resourceBundle.getString("date"));
		System.out.println(resourceBundle.getString("salary"));
		
		String dateLabel = resourceBundle.getString("date") ;
		String salLabel = resourceBundle.getString("salary") ;
		
		String string = "{0}:{1},{2}:{3}" ;
		
		Date date = new Date() ;
		double sal = 12345.12 ;
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale) ;
		String dateString = dateFormat.format(date);
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale) ;
		String salString = numberFormat.format(sal) ;
		
		String result2 = MessageFormat.format(string,dateLabel, dateString,salLabel,salString) ;
		System.out.println(result2);
	}
}
