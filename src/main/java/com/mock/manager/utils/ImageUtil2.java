package com.mock.manager.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil2 {
	public static final String BASEUSL = Thread.currentThread().getContextClassLoader().getResource("").getPath();

	public static String generateThumbnail(File thumbnail, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		System.out.print("realFileName: " + realFileName+" \n");
		String extension = getFileExtension(thumbnail);
		System.out.print("extension: " + extension+" \n");
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		System.out.print("dest path: " + FileUtil.getImgBasePath() + relativeAddr+" \n");
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail).size(200, 200).outputQuality(0.25f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}


	public static void main(String ares[]) throws IOException {
		File file = new File("J:\\springCloud\\dest.jpeg");
		String imageShop = "J:\\springCloud\\dest_new2.jpg";
		String targetAddr ="123";
		if(file.exists()){
			System.out.print("图片存在");
		}else {
			System.out.print("图片不存在");
		}
		//获取上传图片的宽高
		BufferedImage bi =ImageIO.read(file);
		System.out.print("图片的信息： "+bi.getWidth()+ "      "+bi.getHeight()+"\n");
		generateThumbnail(file,targetAddr);

		//测试添加 水印
		System.out.print("BASEUSL: "+ BASEUSL);
//		Thumbnails.of(file).size(1920, 1080).
//				watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(BASEUSL+"/watermark.jpg")),0.25f).
//				outputQuality(0.25f).toFile("J:\\springCloud\\target_new.jpg");
	}

	public static String generateNormalImg( File thumbnail, String targetAddr) {
		String realFileName = FileUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail).size(337, 640).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}

	public static List<String> generateNormalImgs(List<File> imgs, String targetAddr) {
		int count = 0;
		List<String> relativeAddrList = new ArrayList<String>();
		if (imgs != null && imgs.size() > 0) {
			makeDirPath(targetAddr);
			for (File img : imgs) {
				String realFileName = FileUtil.getRandomFileName();
				String extension = getFileExtension(img);
				String relativeAddr = targetAddr + realFileName + count + extension;
				File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
				count++;
				try {
					Thumbnails.of(img).size(600, 300).outputQuality(0.5f).toFile(dest);
				} catch (IOException e) {
					throw new RuntimeException("创建图片失败：" + e.toString());
				}
				relativeAddrList.add(relativeAddr);
			}
		}
		return relativeAddrList;
	}

	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = FileUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	private static String getFileExtension(File cFile) {
		String originalFileName = cFile.getName();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}
}
