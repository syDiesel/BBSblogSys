package com.bbsBlog.action;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.UserInfoService;

@Controller
public class ImageUpload {

	@Resource
	private UserInfoService userInfoService;

	@RequestMapping(value = "/uploadTest.do", method = RequestMethod.POST)
	public @ResponseBody String uploadImg(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) throws Throwable {
		// 用户设置图像

		if (file.getOriginalFilename() != null) {

			String fileName = file.getOriginalFilename();
			double fileSizeDouble = get2Double(((double) file.getSize() / 1024) / 1024);

			String fileSize = fileSizeDouble + "MB";

			if (fileSizeDouble > 20.0) {
				request.getSession().setAttribute("errorResult",
						"The uploaded file exceeds 20M, please re-upload");
				return "redirect:../ERROR/result";
			}
			String type = fileName.substring(fileName.lastIndexOf(".") + 1);
			String realName = fileName.substring(0, fileName.lastIndexOf("."));

			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileTime = f.format(date);

			/*
			 * fileName = URLEncoder.encode(realName, "utf-8") + fileTime +
			 * Math.round(Math.random() * 9) + "." + type;
			 */

			fileName =  fileTime + Math.round(Math.random() * 9)
					+ "." + type;
   
			System.out.println("----------------------------type:" + type
					+ "---------------------------");
			if (!type.equals("jpg") && !type.equals("bmp")
					&& !type.equals("gif") && !type.equals("png")
					&& !type.equals("jpeg")) {
				request.setAttribute("result", "Picture format error");
				return "web/ERROR/result";
			}
			String realPath1 = request.getSession().getServletContext()
					.getRealPath("web/home/head/temp");

			// 存入照片
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(realPath1, fileName));
				// 相片路径
				String realPath = realPath1 + "\\" + fileName;

				/*
				 * // 设置头像的长宽 BufferedImage originalImage = ImageIO.read(new
				 * FileInputStream( realPath)); int width =
				 * originalImage.getWidth(); int height =
				 * originalImage.getHeight(); if (originalImage.getWidth() >
				 * 300) width = 300; if (originalImage.getHeight() > 300) height
				 * = 300; BufferedImage picture = new BufferedImage(width,
				 * height, originalImage.getType());
				 * picture.getGraphics().drawImage(originalImage, 0, 0, width,
				 * height, null); FileOutputStream out1 = null; out1 = new
				 * FileOutputStream(realPath); JPEGImageEncoder encoder =
				 * JPEGCodec.createJPEGEncoder(out1); encoder.encode(picture);
				 */

				int beginIndex = realPath.lastIndexOf("web");
				realPath = realPath.substring(beginIndex, realPath.length());
				request.setAttribute("head", realPath.replace("\\", "/"));

				return realPath.replace("\\", "/");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("result", "error");
				return "web/ERROR/result";
			}
		} else {
			request.setAttribute("result", "error");
			return "web/ERROR/result";
		}
	}

	@RequestMapping(value = "/cut_face")
	public String cut_face(HttpServletRequest request, ModelMap map,
			HttpServletResponse response, HttpSession session)
			throws IOException {

		String image_name = request.getParameter("image_name");
		int x = (int) Double.parseDouble(request.getParameter("x"));
		int y = (int) Double.parseDouble(request.getParameter("y"));
		int width = (int) Double.parseDouble(request.getParameter("width"));
		int height = (int) Double.parseDouble(request.getParameter("height"));

		double zoom_rate = 1;
		try {
			zoom_rate = Double.parseDouble(request.getParameter("zoom_rate"));
		} catch (Exception e) {

		}
		/*
		 * x = (int) (x * zoom_rate); y = (int) (y * zoom_rate); width = (int)
		 * (width * zoom_rate); height = (int) (height * zoom_rate);
		 */

		System.out.println(x + "," + y + "," + width + "," + height + "," + ","
				+ image_name);
		/*
		 * ImageCutUtil.cutImageByXY(FileStorage.getDocumentItemStorage(request)+
		 * separator+"1"+separator+image_name,
		 * FileStorage.getDocumentItemStorage
		 * (request)+separator+"0"+separator+image_name, x, y, x2,y2, 120, 120);
		 */
		/*
		 * user.setHeadurl(image_name); userDao.attachDirty(user);
		 */

		FileInputStream is = null;
		ImageInputStream iis = null;
		String srcpath0 = request.getSession().getServletContext()
				.getRealPath("web/home/head/temp/head");
		String cutpath0 = request.getSession().getServletContext()
				.getRealPath("web/home/head/temp");

		String srcpath = srcpath0 + "\\"
				+ URLEncoder.encode(image_name, "utf-8");
		String cutpath = cutpath0 + "\\"
				+ URLEncoder.encode(image_name, "utf-8");

		System.out.println(srcpath);
		System.out.println(cutpath);
		try {

			// 读取图片文件
			is = new FileInputStream(srcpath);
			String imageType = srcpath.substring(srcpath.indexOf(".") + 1,
					srcpath.length());
			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName(imageType);
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);
			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);
			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();
			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(x, y, width, height);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, imageType, new File(cutpath));

		} catch (Exception e) {

			StringBuffer sb = new StringBuffer();
			StackTraceElement[] stackArray = e.getStackTrace();
			for (int i = 0; i < stackArray.length; i++) {
				StackTraceElement element = stackArray[i];
				sb.append(element.toString() + "\n");
			}

			System.out.println(sb.toString());

		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}

		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
				"userInfo");

		if (userInfo != null) {
			if (cutpath.length() > 0) {

				int beginIndex = cutpath.lastIndexOf("web");
				String realPath = cutpath.substring(beginIndex,
						cutpath.length());

				userInfo.setHeadImg(realPath.replace("\\", "/"));
				this.userInfoService.updateUserInfo(userInfo);

				request.getSession().setAttribute("updatehead",
						realPath.replace("\\", "/"));

				request.setAttribute("modifySuccess", "success");

			}
			return "redirect:/u/setting/portrait";
		} else {
			request.setAttribute("result", "error");
			return "web/ERROR/result";
		}

	}

	// =====================================静态方法==================================
	// doubel保留2位小数
	public static double get2Double(double a) {
		DecimalFormat df = new DecimalFormat("0.00");
		return new Double(df.format(a).toString());
	}

	// doubel保留2位小数
	public static double get1Double(double a) {
		DecimalFormat df = new DecimalFormat("0.0");
		return new Double(df.format(a).toString());
	}

	// 服务器时间
	public static String getNowTime() {
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = f.format(date);

		return nowTime;
	}
}