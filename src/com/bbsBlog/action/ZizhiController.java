package com.bbsBlog.action;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.PhotoPJ;
import com.bbsBlog.entity.UserAlbum;
import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.PhotoPJService;
import com.bbsBlog.service.UserAlbumPhotoService;
import com.bbsBlog.service.UserAlbumService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.ImageUtils;
import com.bbsBlog.util.Pages;
import com.bbsBlog.util.Password;
import com.sun.image.codec.jpeg.ImageFormatException;

@Controller
public class ZizhiController {

	@Resource
	private UserAlbumService userAlbumService;

	@Resource
	private UserAlbumPhotoService userAlbumPhotoService;

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private PhotoPJService photoPJService;
	@Resource
	private MessageService messageService;

	@RequestMapping(value = "zizhi.do")
	public String Zizhi(HttpServletRequest request, HttpServletResponse resp) {
		// 私信
		int newMsg = 0;
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(

		"userInfo");
		// 查看是否登录
		if (loginUser == null) {

			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:/login.html";
		} else {
			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}

		request.setAttribute("newMsgCount", newMsg);
		String albumName = "Qualification Proof";
		// 判断是否设过权限
		String authority = null;
		// 判断是否设密码
		String exist = null;
		if (loginUser != null) {
			if (userAlbumService.findByUserAndId(loginUser.getId(), albumName)
					.size() > 0) {
				exist = "1";
				UserAlbum album = userAlbumService.findByUserAndId(
						loginUser.getId(), albumName).get(0);
				if (album.getIslocked() != null) {
					authority = "1";
				} else
					authority = "0";
			} else {
				exist = "0";
				authority = "0";
			}
		}

		request.setAttribute("exist", exist);
		request.setAttribute("authority", authority);
		return "/web/album/addZizhi";

	}

	/*
	 * @RequestMapping(value = "zzzm.html") public String
	 * Zzzm(HttpServletRequest req, HttpServletResponse resp) {
	 * 
	 * UserInfo uploadUser = (UserInfo) req.getSession().getAttribute(
	 * "userInfo"); if (uploadUser == null) { String strBackUrl = "http://" +
	 * req.getServerName() // 服务器地址 + ":" + req.getServerPort() // 端口号 +
	 * req.getContextPath() // 项目名称 + req.getServletPath(); // 请求页面或其他地址 + "?" +
	 * (request.getQueryString()) // 参数
	 * req.getSession().setAttribute("strBackUrl", strBackUrl); return
	 * "redirect:../../login.html"; }
	 * 
	 * return "/web/album/addZzzm"; }
	 */

	/*
	 * @RequestMapping(value = "zzzm.html") public String
	 * Zzzm(HttpServletRequest req, HttpServletResponse resp) { // 私信 UserInfo
	 * loginUser = (UserInfo) req.getSession().getAttribute( "userInfo"); int
	 * newMsg = 0; if (loginUser != null) {
	 * 
	 * String messageSql = "from Message where userInfo1.id = '" +
	 * loginUser.getId() + "' and isRead = '0'"; List<Message> messageList =
	 * messageService .listMessageBySql(messageSql); newMsg =
	 * messageList.size(); //更新session
	 * req.getSession().setAttribute("userInfo",loginUser); }
	 * req.setAttribute("newMsgCount", newMsg);
	 * 
	 * UserInfo uploadUser = (UserInfo) req.getSession().getAttribute(
	 * "userInfo"); if (uploadUser == null) { req.setAttribute("result",
	 * "还没登录"); return "/web/ERROR/result"; }
	 * 
	 * return "/web/album/addZzzm"; }
	 */

	// 资质照片用于系统验证
	@RequestMapping(value = "uploadZizhi.do")
	public String uploadZizhi(HttpServletRequest req, HttpServletResponse resp,
			MultipartFile file) throws ImageFormatException, IOException {

		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		UserAlbum userAlbum = new UserAlbum();
		UserAlbumPhoto userAlbumPhoto = new UserAlbumPhoto();

		UserInfo userInfo = (UserInfo) req.getSession()
				.getAttribute("userInfo");
		if (userInfo == null) {
			String strBackUrl = "http://" + req.getServerName() // 服务器地址
					+ ":" + req.getServerPort() // 端口号
					+ req.getContextPath() // 项目名称
					+ req.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			req.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:/login.html";
		}

		// 获取当期时间，作为文件名，避免重复
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String fileTime = sdf.format(new Date());

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime = df.format(date);

		String albumDesc = req.getParameter("albumDesc");
		String albumPass = req.getParameter("albumPass");
		String perss_hide = req.getParameter("perss_hide");
		// 1公开、 0不公开
		String isPub = req.getParameter("radio");
		String editor_pass = req.getParameter("editor_pass");
		String editor_concern = req.getParameter("editor_concern");
		String initialPass = req.getParameter("initialPass");
		String modiPass = req.getParameter("modiPass");
		String level = req.getParameter("level");

		String fileName = file.getOriginalFilename();
		String type = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (fileName.length() > 0) {
			if (!type.equals("jpg") && !type.equals("bmp")
					&& !type.equals("gif") && !type.equals("png")
					&& !type.equals("jpeg")) {
				req.setAttribute("result", "Picture format error");
				return "web/ERROR/result";
			}
		}
		String albumName = "Qualification Proof";
		
		// 上传的文件放在“realPath”目录下
		String realPath1 = req.getSession().getServletContext()
				.getRealPath("web/album/zzzm");
		if ((new File(realPath1).isDirectory())) {
			System.out.println("Folder already exists! Creation failed!");
			if (userAlbumService.findByUserAndId(userInfo.getId(), albumName)
					.size() > 0) {
				userAlbum = userAlbumService.findByUserAndId(userInfo.getId(),
						albumName).get(0);
				if (perss_hide.equals("1")) {
					if (editor_pass != null) {
						if (userAlbum.getAlbumPassword() != null) {
							if (!userAlbum.getAlbumPassword()
									.equals(Password.createPassword(initialPass
											.trim()))) {

								req.setAttribute("result", "The original password is incorrect,change failed");
								return "/web/ERROR/result";
							} else {
								userAlbum.setAlbumPassword(Password
										.createPassword(modiPass.trim()));
								userAlbum.setIsPass(editor_pass);
							}
						} else {
							if (!(modiPass == null || modiPass.trim()
									.equals(""))) {
								userAlbum.setAlbumPassword(Password
										.createPassword(modiPass.trim()));
								userAlbum.setIsPass(editor_pass);
							} else{
								userAlbum.setAlbumPassword(null);
								userAlbum.setIsPass("0");
							}
							
						}
					} else {
						userAlbum.setAlbumPassword(null);
						userAlbum.setIsPass("0");
					}
					if(editor_concern == null){
						userAlbum.setIsConcern("0");
					}else
						userAlbum.setIsConcern(editor_concern);
					
					if (isPub == null) {
						isPub = userAlbum.getIslocked();
					}
					userAlbum.setIslocked(isPub);
					userAlbum.setLevelLimit(level);
				}

				userAlbum.setAlbumDesc(albumDesc);
				userAlbum.setUserInfo(userInfo);
				userAlbumService.updateUserAlbum(userAlbum);
			} else {
				if (!(albumPass == null || albumPass.trim().equals(""))) {
					userAlbum.setIsPass(editor_pass);
					userAlbum.setAlbumPassword(Password
							.createPassword(albumPass.trim()));
				} else
					userAlbum.setIsPass("0");
				userAlbum.setIslocked(isPub);
				if(editor_concern == null){
					userAlbum.setIsConcern("0");
				}else
					userAlbum.setIsConcern(editor_concern);
				userAlbum.setLevelLimit(level);
				userAlbum.setAlbumDate(nowTime);
				userAlbum.setAlbumName(albumName);
				userAlbum.setAlbumDesc(albumDesc);
				userAlbum.setUserInfo(userInfo);
				userAlbumService.saveUserAlbum(userAlbum);
			}

		} else {
			new File(realPath1).mkdir();
			System.out.println("Creating a folder successfully！");
			if (!(albumPass == null || albumPass.trim().equals(""))) {
				userAlbum.setIsPass(editor_pass);
				userAlbum.setAlbumPassword(Password.createPassword(albumPass
						.trim()));
			} else
				userAlbum.setIsPass("0");
			userAlbum.setIslocked(isPub);
			if(editor_concern == null){
				userAlbum.setIsConcern("0");
			}else
				userAlbum.setIsConcern(editor_concern);

			userAlbum.setLevelLimit(level);
			userAlbum.setAlbumDate(nowTime);
			userAlbum.setAlbumName("Qualification Proof");
			userAlbum.setAlbumDesc(albumDesc);
			userAlbum.setUserInfo(userInfo);
			userAlbumService.saveUserAlbum(userAlbum);

		}

		req.setAttribute("userAlbum", userAlbum);
		System.out.println("realPath:" + realPath1);

		if (fileName.length() > 0) {
			// 存入照片
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath1, fileName));
			// 相片路径
			String realPath = realPath1 + "\\" + fileName;
			// 水印图片路径
			String waterPath = req.getSession().getServletContext()
					.getRealPath("web/album/" + "pressImage.jpg");
			// 对照片进行水印处理
			String pressText = "@Unionjoyers";
			String fontName = "serif";
			ImageUtils.pressImage(waterPath, realPath, 270, 130);
			ImageUtils.pressText(pressText, realPath, fontName, 1, 18, 100, 0);

			// String upload=request.getParameter("upload");

			/*
			 * BufferedImage originalImage = ImageIO.read(new FileInputStream(
			 * realPath)); int imageWidth = originalImage.getWidth(); int
			 * imageHeight = originalImage.getHeight();
			 * System.out.println("相片原长像素：" + imageWidth + "  " + "相片原宽像素：" +
			 * imageHeight);
			 * 
			 * if (imageWidth > 800) { imageWidth = 800; } if (imageHeight >
			 * 600) { imageHeight = 600; }
			 * 
			 * System.out.println("----------------相片经压缩--------------");
			 * System.out.println("相片长像素：" + imageWidth + "  " + "相片宽像素：" +
			 * imageHeight);
			 * 
			 * BufferedImage picture = new BufferedImage(imageWidth,
			 * imageHeight, originalImage.getType());
			 * 
			 * picture.getGraphics().drawImage(originalImage, 0, 0, imageWidth,
			 * imageHeight, null); FileOutputStream out = null; out = new
			 * FileOutputStream(realPath); JPEGImageEncoder encoder =
			 * JPEGCodec.createJPEGEncoder(out); encoder.encode(picture);
			 */
			/*
			 * FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
			 * realPath1,fileName));
			 */

			System.out.println("========================================");

			// 将文件名存入数据库
			// realPath=realPath+"\\"+fileName;
			int beginIndex = realPath.lastIndexOf("web");
			realPath = realPath.substring(beginIndex, realPath.length());
			userAlbumPhoto.setPhoto(realPath.replace("\\", "/"));

			// 此处的zzzm属性用于区分资质相片的状态：1 待审核 ；2 审核通过；3 审核未通过
			userAlbumPhoto.setZzzm("1");
			userAlbumPhoto.setRoot("0");

			System.out.println("fileUrl:" + userAlbumPhoto.getPhoto());
			System.out.println("========================================");

			String albumPhotoDesc = req.getParameter("albumPhotoDesc");
			userAlbumPhoto.setUserAlbum(userAlbum);
			userAlbumPhoto.setPhotoTime(nowTime);
			userAlbumPhoto.setPhotoDesc(albumPhotoDesc);
			userAlbumPhoto.setUp("0");
			userAlbumPhoto.setNormal("0");
			userAlbumPhoto.setDown("0");

			userAlbumPhotoService.saveUserAlbumPhoto(userAlbumPhoto);

			/*
			 * // 先上传的点赞相片，与验证的关联起来 List<UserAlbumPhoto> listPhoto =
			 * userAlbumPhotoService .listByAlbumNameAndRoot(albumName,
			 * userInfo.getId()); for (UserAlbumPhoto photo : listPhoto) {
			 * photo.setRoot(String.valueOf(userAlbumPhoto.getId()));
			 * userAlbumPhotoService.updateUserAlbumPhoto(photo); }
			 */
			/*if (userAlbumService.findByUserAndId(userInfo.getId(), albumName)
					.get(0).getUserAlbumPhoto() == null) {
				userAlbum.setUserAlbumPhoto(userAlbumPhoto);
				userAlbumService.updateUserAlbum(userAlbum);

			}*/
			userAlbumService.updateUserAlbum(userAlbum);
			req.setAttribute("result", "Upload Photos successfully");

			return "redirect:http://" + req.getServerName() + ":"
					+ req.getServerPort() + req.getContextPath()
					+ "/web/album/result_zi.jsp";
		} else {
			req.setAttribute("result", "Change the permissions of albums successfully");
			return "/web/ERROR/result";
		}

	}

	/*
	 * // 上传用于别人点赞的资质
	 * 
	 * @RequestMapping(value = "uploadZzzm.do") public String
	 * uploadZzzm(HttpServletRequest req, HttpServletResponse resp,
	 * MultipartFile file) throws ImageFormatException, IOException {
	 * 
	 * UserAlbum userAlbum = new UserAlbum(); UserAlbumPhoto userAlbumPhoto =
	 * new UserAlbumPhoto();
	 * 
	 * UserInfo userInfo = (UserInfo) req.getSession()
	 * .getAttribute("userInfo"); if (userInfo == null) {
	 * req.setAttribute("result", "Logout state,please login"); }
	 * 
	 * // 获取当期时间，作为文件名，避免重复 SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyyMMdd"); String fileTime = sdf.format(new Date());
	 * 
	 * Date date = new Date(); SimpleDateFormat df = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); System.out.println("time now:" +
	 * df.format(date)); String nowTime = df.format(date);
	 * 
	 * String albumDesc = req.getParameter("albumDesc"); String fileName =
	 * file.getOriginalFilename(); String albumName = "Qualification Proof";
	 * 
	 * // 上传的文件放在“realPath”目录下 String realPath1 =
	 * req.getSession().getServletContext() .getRealPath("web/album/zzzm"); if
	 * ((new File(realPath1).isDirectory())) {
	 * System.out.println("Folder already exists! Creation failed!"); userAlbum =
	 * userAlbumService.findByUserAndId(userInfo.getId(), albumName).get(0);
	 * userAlbum.setAlbumDesc(albumDesc); userAlbum.setUserInfo(userInfo);
	 * userAlbumService.updateUserAlbum(userAlbum);
	 * 
	 * } else { new File(realPath1).mkdir(); System.out.println("Creating a folder successfully！");
	 * userAlbum.setAlbumDate(nowTime); userAlbum.setAlbumName("Qualification Proof");
	 * userAlbum.setAlbumDesc(albumDesc); userAlbum.setUserInfo(userInfo);
	 * userAlbumService.saveUserAlbum(userAlbum);
	 * 
	 * }
	 * 
	 * req.setAttribute("userAlbum", userAlbum); System.out.println("realPath:"
	 * + realPath1);
	 * 
	 * if (fileName.length() > 0) { // 存入照片
	 * FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
	 * realPath1, fileName)); // 相片路径 String realPath = realPath1 + "\\" +
	 * fileName;
	 * 
	 * // String upload=request.getParameter("upload");
	 * 
	 * 
	 * BufferedImage originalImage = ImageIO.read(new FileInputStream(
	 * realPath)); int imageWidth = originalImage.getWidth(); int imageHeight =
	 * originalImage.getHeight(); System.out.println("相片原长像素：" + imageWidth +
	 * "  " + "相片原宽像素：" + imageHeight);
	 * 
	 * if (imageWidth > 800) { imageWidth = 800; } if (imageHeight > 600) {
	 * imageHeight = 600; }
	 * 
	 * System.out.println("----------------相片经压缩--------------");
	 * System.out.println("相片长像素：" + imageWidth + "  " + "相片宽像素：" +
	 * imageHeight);
	 * 
	 * BufferedImage picture = new BufferedImage(imageWidth, imageHeight,
	 * originalImage.getType());
	 * 
	 * picture.getGraphics().drawImage(originalImage, 0, 0, imageWidth,
	 * imageHeight, null); FileOutputStream out = null; out = new
	 * FileOutputStream(realPath); JPEGImageEncoder encoder =
	 * JPEGCodec.createJPEGEncoder(out); encoder.encode(picture);
	 * 
	 * 
	 * 
	 * FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
	 * realPath1,fileName));
	 * 
	 * 
	 * System.out.println("========================================");
	 * 
	 * // 将文件名存入数据库 // realPath=realPath+"\\"+fileName; int beginIndex =
	 * realPath.lastIndexOf("web"); realPath = realPath.substring(beginIndex,
	 * realPath.length()); userAlbumPhoto.setPhoto(realPath.replace("\\", "/"));
	 * 
	 * // 此处的zzzm属性用于区分资质相片的状态：1 待审核 ；2 审核通过；3 审核未通过;4用于点赞照片的待审核
	 * userAlbumPhoto.setZzzm("4");
	 * 
	 * // 用于资质相片关联 UserAlbum album = userAlbumService.findByUserAndId(
	 * userInfo.getId(), albumName).get(0); List<UserAlbumPhoto> listphoto =
	 * userAlbumPhotoService .listZzzmByAlbumAndRoot(album.getId()); if
	 * (listphoto.size() > 0) { for (UserAlbumPhoto photo : listphoto) { if
	 * (photo.getZzzm().equals("1") || photo.getZzzm().equals("2")) {
	 * userAlbumPhoto.setRoot(String.valueOf(photo.getId())); } } } else {
	 * userAlbumPhoto.setRoot("0"); }
	 * 
	 * System.out.println("fileUrl:" + userAlbumPhoto.getPhoto());
	 * System.out.println("========================================");
	 * 
	 * String albumPhotoDesc = req.getParameter("albumPhotoDesc");
	 * userAlbumPhoto.setUserAlbum(userAlbum);
	 * userAlbumPhoto.setPhotoTime(nowTime);
	 * userAlbumPhoto.setPhotoDesc(albumPhotoDesc); userAlbumPhoto.setUp("0");
	 * userAlbumPhoto.setNormal("0"); userAlbumPhoto.setDown("0");
	 * 
	 * userAlbumPhotoService.saveUserAlbumPhoto(userAlbumPhoto); if
	 * (userAlbumService.findByUserAndId(userInfo.getId(), albumName)
	 * .get(0).getUserAlbumPhoto() == null) {
	 * userAlbum.setUserAlbumPhoto(userAlbumPhoto);
	 * userAlbumService.updateUserAlbum(userAlbum);
	 * 
	 * } userAlbumService.updateUserAlbum(userAlbum); req.setAttribute("result",
	 * "Upload Photos successfully"); return "/web/ERROR/result"; } else {
	 * req.setAttribute("result", "Album already exists or create successfully"); return "/web/ERROR/result"; }
	 * }
	 */

	// 上传用于别人点赞的资质
	@RequestMapping(value = "uploadZzzm.do")
	public String uploadZzzm(HttpServletRequest req, HttpServletResponse resp,
			MultipartFile file) throws ImageFormatException, IOException {
		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		UserAlbum userAlbum = new UserAlbum();
		UserAlbumPhoto userAlbumPhoto = new UserAlbumPhoto();

		UserInfo userInfo = (UserInfo) req.getSession()
				.getAttribute("userInfo");
		if (userInfo == null) {
			req.setAttribute("result", "Logout state,please login");
		}

		// 获取当期时间，作为文件名，避免重复
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String fileTime = sdf.format(new Date());

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("time now:" + df.format(date));
		String nowTime = df.format(date);

		String albumDesc = req.getParameter("albumDesc");
		String fileName = file.getOriginalFilename();
		String albumName = "Qualification Proof";

		// 上传的文件放在“realPath”目录下
		String realPath1 = req.getSession().getServletContext()
				.getRealPath("web/album/zzzm");
		if ((new File(realPath1).isDirectory())) {
			System.out.println("Folder already exists! Creation failed!");
			userAlbum = userAlbumService.findByUserAndId(userInfo.getId(),
					albumName).get(0);
			userAlbum.setAlbumDesc(albumDesc);
			userAlbum.setUserInfo(userInfo);
			userAlbumService.updateUserAlbum(userAlbum);

		} else {
			new File(realPath1).mkdir();
			System.out.println("Creating a folder successfully！");
			userAlbum.setAlbumDate(nowTime);
			userAlbum.setAlbumName("Qualification Proof");
			userAlbum.setAlbumDesc(albumDesc);
			userAlbum.setUserInfo(userInfo);
			userAlbumService.saveUserAlbum(userAlbum);

		}

		req.setAttribute("userAlbum", userAlbum);
		System.out.println("realPath:" + realPath1);

		if (fileName.length() > 0) {
			// 存入照片
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath1, fileName));
			// 相片路径
			String realPath = realPath1 + "\\" + fileName;

			// String upload=request.getParameter("upload");

			/*
			 * BufferedImage originalImage = ImageIO.read(new FileInputStream(
			 * realPath)); int imageWidth = originalImage.getWidth(); int
			 * imageHeight = originalImage.getHeight();
			 * System.out.println("相片原长像素：" + imageWidth + "  " + "相片原宽像素：" +
			 * imageHeight);
			 * 
			 * if (imageWidth > 800) { imageWidth = 800; } if (imageHeight >
			 * 600) { imageHeight = 600; }
			 * 
			 * System.out.println("----------------相片经压缩--------------");
			 * System.out.println("相片长像素：" + imageWidth + "  " + "相片宽像素：" +
			 * imageHeight);
			 * 
			 * BufferedImage picture = new BufferedImage(imageWidth,
			 * imageHeight, originalImage.getType());
			 * 
			 * picture.getGraphics().drawImage(originalImage, 0, 0, imageWidth,
			 * imageHeight, null); FileOutputStream out = null; out = new
			 * FileOutputStream(realPath); JPEGImageEncoder encoder =
			 * JPEGCodec.createJPEGEncoder(out); encoder.encode(picture);
			 */

			/*
			 * FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
			 * realPath1,fileName));
			 */

			System.out.println("========================================");

			// 将文件名存入数据库
			// realPath=realPath+"\\"+fileName;
			int beginIndex = realPath.lastIndexOf("web");
			realPath = realPath.substring(beginIndex, realPath.length());
			userAlbumPhoto.setPhoto(realPath.replace("\\", "/"));

			// 此处的zzzm属性用于区分资质相片的状态：1 待审核 ；2 审核通过；3 审核未通过;4用于点赞照片的待审核
			userAlbumPhoto.setZzzm("4");

			// 用于资质相片关联
			UserAlbum album = userAlbumService.findByUserAndId(
					userInfo.getId(), albumName).get(0);
			List<UserAlbumPhoto> listphoto = userAlbumPhotoService
					.listZzzmByAlbumAndRoot(album.getId());
			if (listphoto.size() > 0) {
				for (UserAlbumPhoto photo : listphoto) {
					if (photo.getZzzm().equals("1")
							|| photo.getZzzm().equals("2")) {
						userAlbumPhoto.setRoot(String.valueOf(photo.getId()));
					}
				}
			} else {
				userAlbumPhoto.setRoot("0");
			}

			System.out.println("fileUrl:" + userAlbumPhoto.getPhoto());
			System.out.println("========================================");

			String albumPhotoDesc = req.getParameter("albumPhotoDesc");
			userAlbumPhoto.setUserAlbum(userAlbum);
			userAlbumPhoto.setPhotoTime(nowTime);
			userAlbumPhoto.setPhotoDesc(albumPhotoDesc);
			userAlbumPhoto.setUp("0");
			userAlbumPhoto.setNormal("0");
			userAlbumPhoto.setDown("0");

			userAlbumPhotoService.saveUserAlbumPhoto(userAlbumPhoto);
			if (userAlbumService.findByUserAndId(userInfo.getId(), albumName)
					.get(0).getUserAlbumPhoto() == null) {
				userAlbum.setUserAlbumPhoto(userAlbumPhoto);
				userAlbumService.updateUserAlbum(userAlbum);

			}
			userAlbumService.updateUserAlbum(userAlbum);
			req.setAttribute("result", "Upload Photos successfully");
			return "/web/ERROR/result";
		} else {
			req.setAttribute("result", "Album already exists or create successfully");
			return "/web/ERROR/result";
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listZzzm.do")
	public String listZzzm(HttpServletRequest req, HttpServletResponse res,
			int record) {

		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);
		try {
			List<UserAlbumPhoto> listPhoto = userAlbumPhotoService.listZzzm();

			int pageRecords = 16; // 每页显示的记录数,这个可以自己设定
			int allRecords = listPhoto.size(); // 总的记录
			int allPage = (allRecords - 1) / pageRecords + 1; // 总页数

			Pages pages = new Pages();
			listPhoto = pages.fenYe(listPhoto, pageRecords, record, allPage,
					allRecords);// 调用Pages的方法，进行分页
			req.setAttribute("record", record);// 当前页
			req.setAttribute("pageRecords", pageRecords);// 每页显示的记录数
			req.setAttribute("allPage", allPage);// 总的页数

			for (UserAlbumPhoto photo : listPhoto) {

				String photoName = photo.getPhoto();
				int beginIndex = photoName.lastIndexOf("zzzm");
				photo.setPhoto(photoName.substring(beginIndex + 5,
						photoName.length()));
			}
			req.setAttribute("listPhoto", listPhoto);

			return "web/management/album/listAlbum";
		} catch (Exception e) {
			req.setAttribute("result", "error");
			return "/web/ERROR/result";
		}
	}

	@RequestMapping(value = "apply.do")
	public String apply(HttpServletRequest req, HttpServletResponse res,
			long id, int record) {

		List<UserAlbumPhoto> listUserAlbumPhoto = userAlbumPhotoService
				.findByPhotoId(id);
		UserAlbumPhoto userAlbumPhoto = new UserAlbumPhoto();
		userAlbumPhoto = listUserAlbumPhoto.get(0);
		req.setAttribute("userAlbumPhoto", userAlbumPhoto);
		req.setAttribute("record", record);

		// 私信
		UserInfo loginUser = (UserInfo) req.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			req.getSession().setAttribute("userInfo", loginUser);
		}
		req.setAttribute("newMsgCount", newMsg);

		return "web/management/album/apply";
	}

	@RequestMapping(value = "pass.do")
	public String pass(HttpServletRequest req, HttpServletResponse res) {

		String ID = req.getParameter("id");
		String albumPhotoDesc = req.getParameter("albumPhotoDesc");
		String Record = req.getParameter("record");

		long id = Long.parseLong(ID);
		int record = Integer.parseInt(Record);

		UserAlbumPhoto userPhoto = userAlbumPhotoService.findByPhotoId(id).get(
				0);

		userPhoto.setPhotoDesc(albumPhotoDesc);
		userPhoto.setZzzm("2");
		userAlbumPhotoService.updateUserAlbumPhoto(userPhoto);

		/*
		 * List<UserAlbumPhoto> listPhoto = userAlbumPhotoService
		 * .listZzzmByRoot(String.valueOf(id)); if (listPhoto.size() > 0) {
		 * System.out.println("11111111111111111111111" + listPhoto.get(0)); for
		 * (UserAlbumPhoto photo : listPhoto) { photo.setZzzm("2");
		 * 
		 * userAlbumPhotoService.updateUserAlbumPhoto(photo); } }
		 */
		return listZzzm(req, res, record);
	}

	@RequestMapping(value = "unpass.do")
	public String unpass(HttpServletRequest req, HttpServletResponse res,
			long id, int record) {

		UserAlbumPhoto userPhoto = userAlbumPhotoService.findByPhotoId(id).get(
				0);
		userPhoto.setZzzm("3");
		userAlbumPhotoService.updateUserAlbumPhoto(userPhoto);

		/*
		 * List<UserAlbumPhoto> listPhoto = userAlbumPhotoService
		 * .listZzzmByRoot(String.valueOf(id)); for (UserAlbumPhoto photo :
		 * listPhoto) { photo.setZzzm("3");
		 * userAlbumPhotoService.updateUserAlbumPhoto(photo); }
		 */

		return listZzzm(req, res, record);
	}

	@RequestMapping(value = "mark.do")
	public @ResponseBody
	String blogYMXH(HttpServletRequest request, HttpServletResponse resp,
			String id, String marks) {

		// 判断是否用户是否已经评价过
		// loginUser 登录用户（操作人）
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {
			//

			return "login";
		}

		long realId = Long.parseLong(id);
		int markcount = Integer.parseInt(marks);

		UserAlbumPhoto photo = userAlbumPhotoService.findByPhotoId(realId).get(
				0);
		UserInfo user = photo.getUserAlbum().getUserInfo();
		String jinzhuan = user.getJinzhuan();
		double jinzhuanInt = Double.parseDouble(jinzhuan);

		// 评价限定 每个用户1次
		List<PhotoPJ> photoPJs = this.photoPJService.findPhotoPjByUserAndPhoto(
				loginUser.getId(), realId);
		if (photoPJs.size() < 1) {
			PhotoPJ photoPj = new PhotoPJ();
			photoPj.setTime(getNowTime());
			photoPj.setUserAlbumPhoto(photo);
			photoPj.setUserInfo(loginUser);

			photoPJService.savePhotoPj(photoPj);
		} else {
			return "error";
		}

		switch (markcount) {
		case 1:
			String up = photo.getUp();
			int upCount = Integer.parseInt(up);
			upCount++;
			photo.setUp(upCount + "");
			jinzhuanInt++;
			user.setJinzhuan(jinzhuanInt + "");

			break;
		case 2:
			String normal = photo.getNormal();
			int normalCount = Integer.parseInt(normal);
			normalCount++;
			photo.setNormal(normalCount + "");

			break;
		case 3:
			String down = photo.getDown();
			int downCount = Integer.parseInt(down);
			downCount++;
			photo.setDown(downCount + "");

			break;
		}

		userInfoService.updateUserInfo(user);
		userAlbumPhotoService.updateUserAlbumPhoto(photo);

		String count = null;
		switch (markcount) {
		case 1:
			String up = photo.getUp();
			count = up;

			break;
		case 2:
			String normal = photo.getNormal();
			count = normal;

			break;
		case 3:
			String down = photo.getDown();
			count = down;

			break;
		}

		return count;
	}

	// =====================================静态方法==================================
	// doubel保留2位小数
	public static double get2Double(double a) {
		DecimalFormat df = new DecimalFormat("0.00");
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
