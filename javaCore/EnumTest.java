package javaCore;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class EnumTest {
	public static void main(String[] args) throws Exception {
		EnumDay[] eds = EnumDay.values(); // 将EnumDay中的枚举值转换为EnumDay数组
		int i = 0;
		for (EnumDay ed : eds) {
			System.out.println("EnumDay[" + i + "]：" + ed.toString()); // 返回枚举常量的名称
			i++;
		}
		System.out.println();

		System.out.println("Enum<EnumDay>.compareTo()：" + eds[0].compareTo(eds[1])); // 比较此枚举与指定枚举的顺序，被比较对象小于、等于、大于比较对象时，分别返回负整数、0、正整数，只能和相同枚举类型相比较
		System.out.println("Enum<EnumDay>.equals()：" + eds[0].equals(eds[1])); // 比较指定两个枚举类型是否相同
		System.out.println("Enum<EnumDay>.getDeclaringClass()：" + eds[0].getDeclaringClass()); // 获取指定枚举值的枚举类型对应的Class对象
		System.out.println("Enum<EnumDay>.hashCode()：" + eds[0].hashCode()); // 获取指定枚举值对应的hashCode
		System.out.println("Enum<EnumDay>.name()：" + eds[0].name()); // 获取指定枚举值的名称
		System.out.println("Enum<EnumDay>.ordinal()：" + eds[0].ordinal()); // 获取指定枚举值对应的序数
		System.out.println();

		for (EnumDay ed : eds) {
			System.out.println(ed.name() + "：" + ed.getValue());
		}
		
		EnumSet<EnumDay> es = EnumSet.allOf(EnumDay.class);
	    for (EnumDay ed : es)
	        System.out.println(ed.name() + "：" + ed.ordinal());
	        
	    System.out.println("\n-----EnumSet和EnumMap之间的分隔线-----\n");
	        
	    EnumMap<EnumDay, String> em = new EnumMap<EnumDay, String>(EnumDay.class);
	    em.put(EnumDay.SUNDAY, "星期天");
	    em.put(EnumDay.MONDAY, "星期一");
	    em.put(EnumDay.TUESDAY, "星期二");
	    em.put(EnumDay.WEDNESDAY, "星期三");
	    em.put(EnumDay.THRUSDAY, "星期四");
	    em.put(EnumDay.FRIDAY, "星期五");
	    em.put(EnumDay.SATURDAY, "星期六");
	        
	    Iterator<Entry<EnumDay, String>> iterator = em.entrySet().iterator();
	    while (iterator.hasNext())
	    {
	        Entry<EnumDay, String> entry = iterator.next();
	        System.out.println(entry.getKey().name() + "：" + entry.getValue());
	    }
	    //注意一下EnumSet和EnumMap都是线程非安全的。


	}
}
