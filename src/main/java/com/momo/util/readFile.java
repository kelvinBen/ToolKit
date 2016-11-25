package com.momo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class readFile {
	/**
	 * 读配置文件
	 * 
	 * @param filePath
	 */
	public static Map<String, String> readProFile(String filePath) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			FileReader fr = new FileReader(new java.io.File(filePath));
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			try {
				while ((s = br.readLine()) != null) {
					if (!s.isEmpty()) {
						// System.out.println(s);
						String[] split = s.split("=");
						map.put(split[1].trim(), split[0].trim());
						// System.out.println("LangUtil.lang(\""+split[0].trim()+"\")");
//						System.out.println(split[1].trim() + "\t\t" + "LangUtil.lang(\"" + split[0].trim() + "\")");
					}
				}
				for (Entry<String, String> entry : map.entrySet()) {

//					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					System.out.println(entry.getKey());
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 替换文件
	 * 
	 * @param args
	 */
	public static List<String> readFile(String filePath) {
		List<String> list = new ArrayList<String>();
		FileReader fr;
		try {
			fr = new FileReader(new java.io.File(filePath));
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			while ((s = br.readLine()) != null) {
				Pattern compile = Pattern.compile("\"(.+)\"");
				Matcher matcmatcherher = compile.matcher(s);
				if (matcmatcherher.find()) {
					String group = matcmatcherher.group();
					if(!group.equals("\"微软雅黑\"")){
						System.out.println(group);
						boolean containsChinese = containsChinese(group);
						if (containsChinese) {
							String trim = group.replace("\"", "").trim();
							list.add(trim);
						}
					}
//					 Pattern compile1 = Pattern.compile("[0x4e00-0x952f]+");
//					 Matcher matcmatcherher2 = compile.matcher(group);
//					 if (matcmatcherher2.find()) {
//					 System.out.println(matcmatcherher2.group());
//					 }
				}
			}
//			HashSet<String> hashSet = new HashSet<String>(list);
//			list.clear();
//			list.addAll(hashSet);
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
    public static List<String> getNewList(List<String> li){
        List<String> list = new ArrayList<String>();
        for(int i=0; i<li.size(); i++){
            String str = li.get(i);  //获取传入集合对象的每一个元素
            if(!list.contains(str)){   //查看新集合中是否有指定的元素，如果没有则加入
                list.add(str);
            }
        }
        return list;  //返回集合
    }

	public static List<String> traverseFolder2(String path) {
		List<String> readFile = new ArrayList<String>();
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				return null;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						// System.out.println("文件夹:" + file2.getAbsolutePath());
						traverseFolder2(file2.getAbsolutePath());
					} else {
						// System.out.println("文件:" + file2.getAbsolutePath());
						String absolutePath = file2.getAbsolutePath();

						if (absolutePath.contains("com\\bangcle")) {
							readFile.addAll(readFile(file2.getAbsolutePath()));
						}
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
		return readFile;
	}

	public static boolean containsChinese(String s) {
		if (null == s || "".equals(s.trim()))
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (isChinese(s.charAt(i)))
				return true;
		}
		return false;
	}

	public static boolean isChinese(char a) {
		int v = (int) a;
		return (v >= 19968 && v <= 38191);
	}

	public static void main(String[] args) {
//		readProFile("C:\\Users\\tom\\Desktop\\zh_NN.properties");
		
//		 Map<String, String> readProFile = readProFile("C:\\Users\\tom\\Desktop\\zh_NNC.properties");
		 
		 
		 List<String> traverseFolder = traverseFolder2("D:\\DevelopTool\\git\\client\\PekingeseSystem");
		 
		 for(int i=0;i<traverseFolder.size();i++){
			 System.out.println(traverseFolder.get(i));
		 }
		 
		 
		// for (int i = 0; i <=9999; i++) {
		// if(i<10){
		// System.out.println("/");
		// }else if(i<100){
		//
		// }else if(i<1000){
		//
		// }else if(i<10000){
		//
		// }
		// }
//		File file = new File("C:\\Users\\tom\\Desktop\\ff.txt");
//		BufferedWriter out ;
//		try {
//			out= new BufferedWriter(new FileWriter(file));  
//			for (int i = 19968; i < 38191; i++) {
//				char a =(char) i;
//				out.write(i+"--"+a+"\r\n");
//				out.flush();
//			}
//			out.close();
//			
//			System.out.println("执行完毕"+(int)(0x4e00)+"--"+(int)(0x952f));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
