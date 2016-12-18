package com.momo.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import com.momo.util.CreationHtml;
import com.momo.util.IO;
import com.momo.zip.Zip4JUtil;

/**
 * PDF转换工具类 1.PDF文档转图片
 * 
 */
public class PDFConvertUtil {
	/**
	 * PDF文档转图片
	 * 
	 * @param pdfFilePath
	 *            需要转换的PDF文件
	 * @param outFilePath
	 *            图片输出目录
	 * @param imageType
	 *            输出的图片类型
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String PDFConvertImage(String pdfFilePath, String outFilePath, String imageType) {
		try {
			File pdfFile = new File(pdfFilePath);
			String pdfName = pdfFile.getName();
			File outFile = new File(outFilePath);
			if (!outFile.exists()) {
				outFile.mkdirs();
			}
			if (pdfFile.exists()) {
				PDDocument document = PDDocument.load(pdfFile); // 加载PDF文档
				PDFRenderer renderer = new PDFRenderer(document); // 创建渲染器

				int pages = document.getNumberOfPages();// 获取页码
				for (int i = 0; i < pages; i++) {
					BufferedImage renderImage = renderer.renderImage(i, 2f);
					// BufferedImage srcImage = resize(renderImage,
					// 240,240);//产生缩略图
					File file = new File(outFilePath + (i + 1) + "." + imageType);
					boolean imageWrite = ImageIO.write(renderImage, imageType, file);
					if (imageWrite) {
						System.out.println("总页数：" + pages + " 第" + (i + 1) + "页创建成功！");
					}
				}
				
				String creationHtml = CreationHtml.creationHtml(pdfName, pages);
				return creationHtml;
			} else {
				System.out.println("File Not Found！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
