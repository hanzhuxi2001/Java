package javaCore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * 
 * 3、简述正则表达式及其用途。
答：在编写处理字符串的程序时，经常会有查找符合某些复杂规则的字符串的需要。正则表达式就是用于描述这些规则的工具。换句话说，正则表达式就是记录文本规则的代码。

说明：计算机诞生初期处理的信息几乎都是数值，但是时过境迁，今天我们使用计算机处理的信息更多的时候不是数值而是字符串，正则表达式就是在进行字符串匹配和处理的时候最为强大的工具，绝大多数语言都提供了对正则表达式的支持。

84、Java中是如何支持正则表达式操作的？
答：Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作，请参考下面面试题的代码。

面试题： - 如果要从字符串中截取第一个英文左括号之前的字符串，例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市，那么正则表达式怎么写？
 * 
 * http://www.jb51.net/tools/zhengze.html
 * 
 */

class RegExpTest {

	public static void main(String[] args) {
		String str = "北京市(朝阳区)(西城区)(海淀区)天津市";
		Pattern p = Pattern.compile(".*?(?=\\()");
		Matcher m = p.matcher(str);
		if (m.find()) {
			System.out.println(m.group());
		}
		System.out.println(String.class);
	}
}