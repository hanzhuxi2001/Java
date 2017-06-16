package javaCore;

import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionRelated {
	public void FileInputStream(File file) throws FileNotFoundException {
		String name = (file != null ? file.getPath() : null);
		SecurityManager security = System.getSecurityManager();
		try {
			if (security != null) {
				security.checkRead(name);
			}
		} catch (Exception e) {
			throw new NullPointerException();
		}
		if (name == null) {
			throw new NullPointerException();
		}
	}
}
