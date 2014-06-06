package phoenix.practise.fifthCentralPart.F21;

import java.io.File;

import javax.swing.filechooser.*;

public class MyFileFilter extends FileFilter {

	String ends;
	String description;

	public MyFileFilter(String ends, String description) {
		this.ends = ends;
		this.description = description;
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		String fileName = file.getName();
		if (fileName.toUpperCase().endsWith(ends.toUpperCase())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String getDescription() {
		return description;
	}

}
