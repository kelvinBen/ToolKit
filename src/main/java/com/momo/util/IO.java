package com.momo.util;

import static org.apache.commons.io.IOUtils.closeQuietly;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class IO {
	/**
	 * Read a properties file with the utf-8 encoding
	 * 
	 * @param is
	 *            Stream to properties file
	 * @return The Properties object
	 */
	public static Properties readUtf8Properties(InputStream is) {
		Properties properties = new Properties();
		try {
			properties.load(is);
			return properties;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeQuietly(is);
		}
	}

	/**
	 * Read the Stream content as a string (use utf-8)
	 * 
	 * @param is
	 *            The stream to read
	 * @return The String content
	 */
	public static String readContentAsString(InputStream is) {
		return readContentAsString(is, "utf-8");
	}

	/**
	 * Read the Stream content as a string
	 * 
	 * @param is
	 *            The stream to read
	 * @return The String content
	 */
	public static String readContentAsString(InputStream is, String encoding) {
		try {
			return IOUtils.toString(is, encoding);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Read file content to a String (always use utf-8)
	 * 
	 * @param file
	 *            The file to read
	 * @return The String content
	 */
	public static String readContentAsString(File file) {
		if (!file.isFile())
			return "";
		return readContentAsString(file, "utf-8");
	}

	public static String readContentAsStrings(File file) {
		if (!file.isFile()) {
			return "";
		}
		String osName = System.getProperties().getProperty("os.name").toLowerCase();
		if (osName.contains("window")) {
			return readContentAsString(file, "gbk");
		} else {
			return readContentAsString(file, "utf-8");
		}
	}

	/**
	 * Read file content to a String
	 * 
	 * @param file
	 *            The file to read
	 * @return The String content
	 */
	public static String readContentAsString(File file, String encoding) {
		try {
			return FileUtils.readFileToString(file, encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	public static List<String> readLines(InputStream is) {
		List<String> lines = null;
		try {
			lines = IOUtils.readLines(is);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		return lines;
	}

	public static List<String> readLines(File file, String encoding) {
		try {
			return FileUtils.readLines(file, encoding);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static List<String> readLines(File file) {
		return readLines(file, "utf-8");
	}

	/**
	 * Read binary content of a file (warning does not use on large file !)
	 * 
	 * @param file
	 *            The file te read
	 * @return The binary data
	 */
	public static byte[] readContent(File file) {
		try {
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void appendTextToFile(File file, String text) {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(text);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			// exception handling left as an exercise for the reader
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (Exception e) {
				e.printStackTrace();
				// exception handling left as an exercise for the reader
			}
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
				// exception handling left as an exercise for the reader
			}
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
				// exception handling left as an exercise for the reader
			}
		}
	}

	/**
	 * Read binary content of a stream (warning does not use on large file !)
	 * 
	 * @param is
	 *            The stream to read
	 * @return The binary data
	 */
	public static byte[] readContent(InputStream is) {
		try {
			return IOUtils.toByteArray(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Write String content to a stream (always use utf-8)
	 * 
	 * @param content
	 *            The content to write
	 * @param os
	 *            The stream to write
	 */
	public static void writeContent(CharSequence content, OutputStream os) {
		writeContent(content, os, "utf-8");
	}

	/**
	 * Write String content to a stream (always use utf-8)
	 * 
	 * @param content
	 *            The content to write
	 * @param os
	 *            The stream to write
	 */
	public static void writeContent(CharSequence content, OutputStream os, String encoding) {
		try {
			IOUtils.write(content, os, encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			closeQuietly(os);
		}
	}

	/**
	 * Write String content to a file (always use utf-8)
	 * 
	 * @param content
	 *            The content to write
	 * @param file
	 *            The file to write
	 */
	public static void writeContent(CharSequence content, File file) {
		writeContent(content, file, "utf-8");
	}

	/**
	 * Write String content to a file (always use utf-8)
	 * 
	 * @param content
	 *            The content to write
	 * @param file
	 *            The file to write
	 */
	public static void writeContent(CharSequence content, File file, String encoding) {
		try {
			FileUtils.write(file, content, encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Write binay data to a file
	 * 
	 * @param data
	 *            The binary data to write
	 * @param file
	 *            The file to write
	 */
	public static void write(byte[] data, File file) {
		try {
			FileUtils.writeByteArrayToFile(file, data);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Copy an stream to another one.
	 */
	public static void copy(InputStream is, OutputStream os) {
		try {
			IOUtils.copyLarge(is, os);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			closeQuietly(is);
		}
	}

	/**
	 * Copy an stream to another one.
	 */
	public static void write(InputStream is, OutputStream os) {
		try {
			IOUtils.copyLarge(is, os);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			closeQuietly(is);
			closeQuietly(os);
		}
	}

	/**
	 * Copy an stream to another one.
	 */
	public static void write(InputStream is, File f) {
		try {
			OutputStream os = new FileOutputStream(f);
			try {
				IOUtils.copyLarge(is, os);
			} finally {
				closeQuietly(is);
				closeQuietly(os);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// If targetLocation does not exist, it will be created.
	public static void copyDirectory(File source, File target) {
		if (source.isDirectory()) {
			if (!target.exists()) {
				target.mkdir();
			}
			for (String child : source.list()) {
				copyDirectory(new File(source, child), new File(target, child));
			}
		} else {
			try {
				write(new FileInputStream(source), new FileOutputStream(target));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void inputstreamtofile(InputStream ins, File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
