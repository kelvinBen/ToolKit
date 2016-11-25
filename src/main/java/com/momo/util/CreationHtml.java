package com.momo.util;

public class CreationHtml {

	static StringBuilder sb = new StringBuilder();
	static String s = "\r\n";

	public static String creationHtml(String fileName, int pageNum) {
		String title = fileName.substring(0,fileName.lastIndexOf("."));
		
		sb.append("<!DOCTYPE html>").append(s);
		sb.append("<html>").append(s);
		sb.append("<head>").append(s);
		sb.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />").append(s);

		sb.append("<title>");
		sb.append(title);
		sb.append("</title>").append(s);

		sb.append("</head>").append(s);
		sb.append("<body>").append(s);

		for (int i = 1; i <= pageNum; i++) {
			sb.append("<div align=\"center\">").append(s);
			sb.append("<image src=\"./Image/" + i + ".png\" width=\"80%\" align=\"middle\">").append(s);
			sb.append("</div>").append(s);
		}

		sb.append("</body>").append(s);

		sb.append("</html>");
		return sb.toString();
	}
}
