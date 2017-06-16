package javaCore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public final class MyUtil {

	// 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
	private MyUtil() {
		throw new AssertionError();
	}

	/**
	 * 统计给定文件中给定字符串的出现次数
	 * 
	 * @param filename
	 *            文件名
	 * @param word
	 *            字符串
	 * @return 字符串在文件中出现的次数
	 * @throws IOException
	 */
	public static int countWordInFile(String filename, String word) throws IOException {
		int counter = 0;
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			int index = -1;
			while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
				counter++;
				line = line.substring(index + word.length());
			}
		}

		return counter;

	}

	public static void listFileName(String filePath) {
		File f = new File(filePath);
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	public static void listFileNameSubFolder(String filePath) {
		long start = System.currentTimeMillis();
		File f = new File(filePath);
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println(file.getName());
			} else if (file.isDirectory()) {
				listFileNameSubFolder(file.getPath());
			}
		}
		System.out.println("end time" + (System.currentTimeMillis() - start));
	}

	public static void main(String[] args) throws IOException {
		System.out.println(countWordInFile("/Users/hd/test/a.txt", "line"));
		listFileName("/Users/hd");
		//listFileNameSubFolder("/Users/hd/doc");
		listFileNameSubNIO("/Users/hd/doc");
	}

	private static void listFileNameSubNIO(String pathStr) throws IOException {
		long start = System.currentTimeMillis();

		Path initPath = Paths.get(pathStr);
		Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName().toString());
				return FileVisitResult.CONTINUE;
			}

		});
		System.out.println("end time" + (System.currentTimeMillis() - start));

	}

}