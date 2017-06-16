package javaCore.array;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapRelated {
	static int i=1;

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);
		map.put("apple", "苹果");
		map.put("watermelon", "西瓜");
		map.put("banana", "香蕉");
		map.put("peach", "桃子");
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry e = (Entry) iter.next();
			System.out.println(e.getValue() + "=" + e.getKey());

		}
		printEnd();

		for (Map.Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getValue() + "=" + e.getKey());

		}
		printEnd();

		for (String s : map.keySet()) {
			String e = map.get(s);
			System.out.println(s + "=" + e);

		}
		printEnd();

		for (String v : map.values()) {
			System.out.println("can only get the value=" + v);
		}

	}

	private static void printEnd() {
		System.out.println("=======end========="+i++);
	}
}
