package cn.baidu.regex;

public class Regex {

	public static void main(String[] args) {

		String regex = "^http://[a-zA-Z_0-9]+>$";
		String str = "<script type='textjavascript src=http://gss0_baidu_com>/70cFsjip0QIZ8tyhnq/hunter/baike.js?st=17521 defer></script><script type=text/javascript>alog('speed.set', 'drt', +new Date)";

		System.out.println(str.matches(regex));
		
		
	}

}
