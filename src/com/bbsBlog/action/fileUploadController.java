package com.bbsBlog.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.Friend;
import com.bbsBlog.entity.Message;
import com.bbsBlog.entity.UserAlbum;
import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BlogService;
import com.bbsBlog.service.FriendService;
import com.bbsBlog.service.MessageService;
import com.bbsBlog.service.UserAlbumPhotoService;
import com.bbsBlog.service.UserAlbumService;
import com.bbsBlog.service.UserInfoService;
import com.bbsBlog.util.ImageUtils;
import com.bbsBlog.util.PageModel;
import com.bbsBlog.util.Pages;
import com.bbsBlog.util.Password;

@Controller
public class fileUploadController {

	@Resource
	private UserAlbumService userAlbumService;

	@Resource
	private UserAlbumPhotoService userAlbumPhotoService;

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private BlogService blogService;

	@Resource
	private MessageService messageService;

	private List<UserAlbumPhoto> listPhoto;

	@Resource
	private FriendService friendService;

	public UserAlbumService getUserAlbumService() {

		return userAlbumService;
	}

	public void setUserAlbumService(UserAlbumService userAlbumService) {

		this.userAlbumService = userAlbumService;

	}

	public UserAlbumPhotoService getUserAlbumPhotoService() {

		return userAlbumPhotoService;
	}

	public void setUserAlbumPhotoService(
			UserAlbumPhotoService userAlbumPhotoService) {

		this.userAlbumPhotoService = userAlbumPhotoService;

	}

	/**
	 * 
	 * @author 乐风
	 * 
	 * @date 2014-8-26
	 * 
	 * @param
	 */
	@RequestMapping(value = "fileupload.do", method = RequestMethod.GET)
	public String fileUpload0(HttpServletRequest request,
			HttpServletResponse response) {
		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		UserInfo uploadUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 查看是否登录
		if (uploadUser == null) {

			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数
			request.getSession().setAttribute("strBackUrl", strBackUrl);
			return "redirect:/login.html";
		}

		String sql = "from UserAlbum where userInfo.id='"+uploadUser.getId()+"' and albumName <> 'Qualification Proof'";
		List<UserAlbum> listAlbum = userAlbumService
				.listBySql(sql);
		request.setAttribute("listAlbum", listAlbum);

		return "/web/album/addAlbum";

	}

	/**
	 * 
	 * @author 乐风
	 * 
	 * @date 2014-8-26
	 * 
	 * @param
	 * @throws IOException
	 */
	@RequestMapping(value = "fileUpload.do", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file)
			throws IOException {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		// 查看是否登录
		if (loginUser == null) {
			String strBackUrl = "http://" + request.getServerName() // 服务器地址
					+ ":" + request.getServerPort() // 端口号
					+ request.getContextPath() // 项目名称
					+ request.getServletPath(); // 请求页面或其他地址
			/* + "?" + (request.getQueryString()) */// 参数

			return "redirect:../../login.html";
		}

		try {

			UserAlbum userAlbum = new UserAlbum();
			UserAlbumPhoto userAlbumPhoto = new UserAlbumPhoto();

			// 获取当期时间，作为文件名，避免重复
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fileTime = sdf.format(new Date());

			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("time now:" + df.format(date));
			String nowTime = df.format(date);

			String albumDesc = request.getParameter("albumDesc");

			/*
			 * userAlbum.setAlbumName(fileTime);
			 * userAlbum.setAlbumDesc(albumDesc);
			 * userAlbum.setUserInfo(userInfo);
			 */

			String fileName = file.getOriginalFilename();
			String type = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileName.length() > 0) {
				if (!type.equals("jpg") && !type.equals("bmp")
						&& !type.equals("gif") && !type.equals("png")
						&& !type.equals("jpeg")) {
					request.setAttribute("result", "Picture format error");
					return "web/ERROR/result";
				}
			}

			// 判断是否已建该相册
			String albumName = request.getParameter("albumName");
			String selectAlbum = request.getParameter("selectAlbum");

			if (albumName.equals("")) {
				albumName = selectAlbum;

			}

			if (albumName.equals("please") || albumName.equals("")) {
				request.setAttribute("result0", "Select album you want");
				request.setAttribute("result1", "or");
				request.setAttribute("result2", "输入相册名");
				return "/web/ERROR/result";
			} else if (userAlbumService.findByUserAndId(loginUser.getId(),
					albumName).size() <= 0) {
				userAlbum.setAlbumDate(nowTime);
				userAlbum.setAlbumName(albumName);
				userAlbum.setAlbumDesc(albumDesc);
				userAlbum.setUserInfo(loginUser);
				userAlbumService.saveUserAlbum(userAlbum);
			} else {
				userAlbum = userAlbumService.findByUserAndId(loginUser.getId(),
						albumName).get(0);
				userAlbum.setAlbumDesc(albumDesc);
				userAlbum.setUserInfo(loginUser);
				userAlbumService.updateUserAlbum(userAlbum);
			}

			// 上传的文件放在“realPath”目录下
			String realPath1 = request.getSession().getServletContext()
					.getRealPath("web/album/" + fileTime);
			if ((new File(realPath1).isDirectory())) {
				System.out.println("文件夹已存在！创建失败！");

			} else {
				new File(realPath1).mkdir();
				System.out.println("创建文件夹成功！");

			}

			request.setAttribute("userAlbum", userAlbum);
			System.out.println("realPath:" + realPath1);

			if (fileName.length() > 0) {
				// 存入照片
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(realPath1, fileName));
				// 相片路径
				String realPath = realPath1 + "\\" + fileName;
				// 水印图片路径
				String waterPath = request.getSession().getServletContext()
						.getRealPath("web/album/" + "pressImage.jpg");
				// 对照片进行水印处理
				String pressText = "@Unionjoyers";
				String fontName = "serif";
				ImageUtils.pressImage(waterPath, realPath, 270, 130);
				ImageUtils.pressText(pressText, realPath, fontName, 1, 18, 100,
						0);

				// String upload=request.getParameter("upload");

				/*
				 * BufferedImage originalImage = ImageIO.read(new
				 * FileInputStream( realPath)); int imageWidth =
				 * originalImage.getWidth(); int imageHeight =
				 * originalImage.getHeight(); System.out.println("相片原长像素：" +
				 * imageWidth + "  " + "相片原宽像素：" + imageHeight);
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
				 * picture.getGraphics().drawImage(originalImage, 0, 0,
				 * imageWidth, imageHeight, null); FileOutputStream out = null;
				 * out = new FileOutputStream(realPath); JPEGImageEncoder
				 * encoder = JPEGCodec.createJPEGEncoder(out);
				 * encoder.encode(picture);
				 */

				/*
				 * FileUtils.copyInputStreamToFile(file.getInputStream(), new
				 * File( realPath1,fileName));
				 */

				System.out.println("========================================");

				// 将文件名存入数据库
				// realPath=realPath+"\\"+fileName;
				int beginIndex = realPath.lastIndexOf("web");
				realPath = realPath.substring(beginIndex, realPath.length());
				userAlbumPhoto.setPhoto(realPath.replace("\\", "/"));
				userAlbumPhoto.setZzzm("0");
				userAlbumPhoto.setRoot("0");
				System.out.println("fileUrl:" + userAlbumPhoto.getPhoto());
				System.out.println("========================================");

				String albumPhotoDesc = request.getParameter("albumPhotoDesc");
				userAlbumPhoto.setUserAlbum(userAlbum);
				userAlbumPhoto.setPhotoTime(nowTime);
				userAlbumPhoto.setPhotoDesc(albumPhotoDesc);
				userAlbumPhoto.setUp("0");
				userAlbumPhoto.setNormal("0");
				userAlbumPhoto.setDown("0");

				userAlbumPhotoService.saveUserAlbumPhoto(userAlbumPhoto);
				if (userAlbumService
						.findByUserAndId(loginUser.getId(), albumName).get(0)
						.getUserAlbumPhoto().getId() == 1) {
					userAlbum.setUserAlbumPhoto(userAlbumPhoto);
					userAlbumService.updateUserAlbum(userAlbum);

				}
				userAlbumService.updateUserAlbum(userAlbum);
				request.setAttribute("result", "Uploaded Photos ");
				return "redirect:http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/web/album/result.jsp";
			} else {
				if (userAlbumService
						.findByUserAndId(loginUser.getId(), albumName).get(0)
						.getUserAlbumPhoto() == null) {
					UserAlbumPhoto photo = userAlbumPhotoService.findByPhotoId(
							1).get(0);
					userAlbum.setUserAlbumPhoto(photo);
					userAlbumService.updateUserAlbum(userAlbum);
					request.setAttribute("result", "Album already existed or created ");
					return "redirect:fileupload.do";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "error");
			return "/web/ERROR/result";
			// return "error";
		}
		return "redirect:fileupload.do";
	}

	/**
	 * 
	 * @author 乐风
	 * 
	 * @date 2014-8-27
	 * 
	 * @param
	 * @throws IOException
	 * @throws ServletException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "listAlbum.do", method = RequestMethod.GET)
	public String listAlbum(HttpServletRequest request,
			HttpServletResponse response, long id) throws ServletException,
			IOException {
		// id对应的user
					UserInfo blogUser = userInfoService.findById(id);
		// 私信

				int newMsg = 0;
				UserInfo loginUser = (UserInfo) request.getSession().getAttribute("userInfo");
				if (loginUser != null) {

					String messageSql = "from Message where userInfo1.id = '"
							+ loginUser.getId() + "' and isRead = '0'";
					List<Message> messageList = messageService
							.listMessageBySql(messageSql);
					newMsg = messageList.size();
					//更新session
					request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
					
					//判断登陆者与博主是不是好友
					boolean isFriend=this.friendService.isFriend(loginUser.getId(),blogUser.getId());
					request.setAttribute("isFriend",isFriend);
				}
				request.setAttribute("newMsgCount", newMsg);

		try {
			
			String albumName = "Qualification Proof";

			List<UserAlbum> listUserAlbum = userAlbumService
					.listByUserAndNoName(id, albumName);
			List<UserAlbum> albumdt = null;
			if (listUserAlbum.size() < 1) {
				request.setAttribute("blogUser", blogUser);
				return "/web/PersonalInfo/personalAlbum";
			}
			UserAlbum userAlbum = listUserAlbum.get(0);

			int totalPage = listUserAlbum.size();

			// 分页
			int page = 1;

			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {

				page = 1;
			}
			int pageSize = 12;
			// 最后一页
			int lastPage = 1;
			if (totalPage % pageSize == 0) {
				lastPage = totalPage / pageSize;
			} else
				lastPage = totalPage / pageSize + 1;

			if (page > lastPage) {
				page = lastPage;
			}
			if (page <= 0) {
				page = 1;
			}
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("page", page);

			// 当前页第一个的位置
			int firstSet = (page - 1) * pageSize;
			// 下方排序
			if (listUserAlbum.size() > pageSize) {
				if ((firstSet + pageSize) < (totalPage - 1)) {
					albumdt = listUserAlbum.subList(firstSet, firstSet
							+ pageSize);
				} else {
					albumdt = listUserAlbum.subList(firstSet, totalPage);
				}
			} else {
				albumdt = listUserAlbum;
			}
			request.setAttribute("albumdt", albumdt);
			request.setAttribute("blogUser", blogUser);

			return "/web/PersonalInfo/personalAlbum";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("value", "No albums");
			return "/web/PersonalInfo/personalAlbum";
			// return "/web/ERROR/error";
		}
	}

	/*
	 * @RequestMapping(value = "zzzmAlbum.html") public String
	 * zzzmAlbum(HttpServletRequest request, HttpServletResponse response, long
	 * id) { // 私信 UserInfo loginUser = (UserInfo)
	 * request.getSession().getAttribute( "userInfo"); int newMsg = 0; if
	 * (loginUser != null) {
	 * 
	 * String messageSql = "from Message where userInfo1.id = '" +
	 * loginUser.getId() + "' and isRead = '0'"; List<Message> messageList =
	 * messageService .listMessageBySql(messageSql); newMsg =
	 * messageList.size(); // 更新session
	 * request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId())); }
	 * request.setAttribute("newMsgCount", newMsg);
	 * 
	 * try { // id对应的user UserInfo blogUser = userInfoService.findById(id);
	 * String albumName = "Qualification Proof";
	 * 
	 * UserAlbum zzzmAlbum = userAlbumService.listByUserAndAlbumName(id,
	 * albumName).get(0);
	 * 
	 * List<UserAlbumPhoto> listZzzm = userAlbumPhotoService
	 * .findByUserAlbumId(zzzmAlbum.getId()); List<UserAlbumPhoto> photodt =
	 * null;
	 * 
	 * int totalPage = listZzzm.size();
	 * 
	 * // 分页 int page = 1;
	 * 
	 * try { page = Integer.parseInt(request.getParameter("page")); } catch
	 * (Exception e) {
	 * 
	 * page = 1; } int pageSize = 12; // 最后一页 int lastPage = 1; if (totalPage %
	 * pageSize == 0) { lastPage = totalPage / pageSize; } else lastPage =
	 * totalPage / pageSize + 1;
	 * 
	 * if (page > lastPage) { page = lastPage; } if (page <= 0) { page = 1; }
	 * request.setAttribute("lastPage", lastPage); request.setAttribute("page",
	 * page);
	 * 
	 * // 当前页第一个的位置 int firstSet = (page - 1) * pageSize; // 下方排序 if
	 * (listZzzm.size() > pageSize) { if ((firstSet + pageSize) < (totalPage -
	 * 1)) { photodt = listZzzm.subList(firstSet, firstSet + pageSize); } else {
	 * photodt = listZzzm.subList(firstSet, totalPage); } } else { photodt =
	 * listZzzm; } request.setAttribute("photodt", photodt);
	 * request.setAttribute("blogUser", blogUser); request.setAttribute("zzzm",
	 * "1");
	 * 
	 * return "/web/PersonalInfo/zzzmAlbum"; } catch (Exception e) { // TODO:
	 * handle exception e.printStackTrace(); request.setAttribute("value",
	 * "No photo"); return "/web/PersonalInfo/zzzmAlbum"; // return
	 * "/web/ERROR/error"; } }
	 */

	// 判断当前用户是否有权限访问资质相册
	@RequestMapping(value = "permission.do", method = RequestMethod.GET)
	public String Permission(HttpServletRequest request,
			HttpServletResponse response, long blId) throws IOException,
			Exception {

		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		UserInfo blogUser = userInfoService.findById(blId);
		
		// 私信

		int newMsg = 0;
		
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			//更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
			
			//判断登陆者与博主是不是好友
			boolean isFriend=this.friendService.isFriend(loginUser.getId(),blogUser.getId());
			request.setAttribute("isFriend",isFriend);
		}
		request.setAttribute("newMsgCount", newMsg);
		request.setAttribute("blogUser", blogUser);
		String albumName = "Qualification Proof";

		// 分页
		int page = 1;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

			page = 1;
		}
		// 比较是不是本人
		if (userAlbumService.listByUserAndAlbumName(blId, albumName).size() > 0) {
			UserAlbum album = userAlbumService.listByUserAndAlbumName(blId,
					albumName).get(0);
			long id = album.getId();

			if (album.getIslocked().equals("0")) {
				if (loginUser != null) {
					if (loginUser.getId() == blogUser.getId()) {
						return "redirect:listAlbumPhoto.do?id=" + id + "&page="
								+ page + "&blId=" + blId;
					} else {
						List<Friend> listFriend = friendService
								.listFriendById(blId);

						String album_level = album.getLevelLimit();
						String user_level = loginUser.getUserLevel();
						int albumLevel = Integer.parseInt(album_level);// 相册对级别的限制
						int userLevel = Integer.parseInt(user_level);// 用户级别

						if (userLevel >= albumLevel) {
							return "redirect:listAlbumPhoto.do?id=" + id
									+ "&page=" + page + "&blId=" + blId;
						} else if (album.getIsConcern().equals("1")) {
							for (Friend f : listFriend) {
								if (f.getUserInfo1().getId() == loginUser
										.getId()) {
									return "redirect:listAlbumPhoto.do?id="
											+ id + "&page=" + page + "&blId="
											+ blId;
								}
							}
							if (album.getIsPass().equals("1")) {
								// 返回输密码页面
								request.setAttribute("clickPass", "1");
								request.setAttribute("page", page);
								return "/web/PersonalInfo/personalAlbum";
							} else {
								request.setAttribute("result", "No right to access this album");
								return "/web/ERROR/result";
							}
						} else {
							if (album.getIsPass().equals("1")) {
								// 返回输密码页面
								request.setAttribute("clickPass", "1");
								request.setAttribute("page", page);
								return "/web/PersonalInfo/personalAlbum";
							} else {
								request.setAttribute("result", "No right to access this album");
								return "/web/ERROR/result";
							}
						}
					}
				} else {
					if (album.getIsPass().equals("1")) {
						// 返回输密码页面
						request.setAttribute("clickPass", "1");
						request.setAttribute("page", page);
						return "/web/PersonalInfo/personalAlbum";
					} else {
						request.setAttribute("result", "No right to access this album");
						return "/web/ERROR/result";
					}
				}
			} else {
				return "redirect:listAlbumPhoto.do?id=" + id + "&page=" + page
						+ "&blId=" + blId;
			}
		} else {
			request.setAttribute("value", "No photo");
			return "/web/PersonalInfo/zzzmAlbum";
		}

	}

	// 判断查看资质相片用户的输入密码是否正确
	@RequestMapping(value = "/confirmPass.html")
	public String confirmPass(HttpServletRequest request,
			HttpServletResponse response) {

		String clickPass = request.getParameter("clickPass");
		String page = request.getParameter("page");
		String blId = request.getParameter("blId");

		// 当前查看的相册
		String albumName = "Qualification Proof";
		UserAlbum album = userAlbumService.listByUserAndAlbumName(
				Long.valueOf(blId), albumName).get(0);
		long id = album.getId();

		if (album.getAlbumPassword().equals(Password.createPassword(clickPass))) {

			return "redirect:listAlbumPhoto.do?id=" + id + "&page=" + page
					+ "&blId=" + blId;
		}

		request.setAttribute("result", "Password you entered is incorrect");
		return "/web/ERROR/result";
	}

	/**
	 * 
	 * @author 乐风
	 * 
	 * @date 2014-8-29
	 * 
	 * @param
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "listAlbumPhoto.do", method = RequestMethod.GET)
	public String listAlbumPhoto(HttpServletRequest request,
			HttpServletResponse response, long id, long blId) throws Exception,
			IOException {
		// 私信
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		int newMsg = 0;
		if (loginUser != null) {

			String messageSql = "from Message where userInfo1.id = '"
					+ loginUser.getId() + "' and isRead = '0'";
			List<Message> messageList = messageService
					.listMessageBySql(messageSql);
			newMsg = messageList.size();
			// 更新session
			request.getSession().setAttribute("userInfo",this.userInfoService.findById(loginUser.getId()));
		}
		request.setAttribute("newMsgCount", newMsg);

		try {

			String clickPass = (String) request.getAttribute("clickPass");
			request.setAttribute("clickPass", clickPass);
			// id对应的user
			UserInfo blogUser = userInfoService.findById(blId);
			request.setAttribute("blogUser", blogUser);

			UserAlbum album = userAlbumService.listUserAlbumById(id).get(0);
			List<UserAlbumPhoto> listPhoto = new ArrayList<UserAlbumPhoto>();

			if (loginUser != null) {
				if (album.getAlbumName().equals("Qualification Proof")
						&& (loginUser.getId() != blogUser.getId())) {
					String sql = "from UserAlbumPhoto u where u.userAlbum.id = '"
							+ id
							+ "' and u.zzzm = '2' order by photoTime desc";
					listPhoto = userAlbumPhotoService.listBySql(sql);

				} else {
					listPhoto = userAlbumPhotoService.findByUserAlbumId(id);

				}
			}else{
				String sql = "from UserAlbumPhoto u where u.userAlbum.id = '"
						+ id
						+ "' and u.zzzm = '2' order by photoTime desc";
				listPhoto = userAlbumPhotoService.listBySql(sql);
			}
				

			List<UserAlbumPhoto> photodt = null;

			int totalPage = listPhoto.size();

			// 分页
			int page = 1;

			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (Exception e) {

				page = 1;
			}
			int pageSize = 12;
			// 最后一页
			int lastPage = 1;
			if (totalPage % pageSize == 0) {
				lastPage = totalPage / pageSize;
			} else
				lastPage = totalPage / pageSize + 1;

			if (page > lastPage) {
				page = lastPage;
			}
			if (page <= 0) {
				page = 1;
			}
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("page", page);

			// 当前页第一个的位置
			int firstSet = (page - 1) * pageSize;
			// 下方排序
			if (listPhoto.size() > pageSize) {
				if ((firstSet + pageSize) < (totalPage - 1)) {
					photodt = listPhoto.subList(firstSet, firstSet + pageSize);
				} else {
					photodt = listPhoto.subList(firstSet, totalPage);
				}
			} else {
				photodt = listPhoto;
			}

			request.setAttribute("album", album);
			request.setAttribute("photodt", photodt);

			return "/web/PersonalInfo/zzzmAlbum";
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("value", "No photo");
			return "/web/PersonalInfo/zzzmAlbum";
		}

	}

	/**
	 * 
	 * @author 曦风
	 * 
	 * @date 2014-9-14
	 * 
	 * @param
	 */
	@RequestMapping(value = "photo.do", method = RequestMethod.GET)
	public String photo(HttpServletRequest req, HttpServletResponse res,
			long id, long blId) {
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

		UserInfo blogUser = userInfoService.findById(blId);

		List<UserAlbumPhoto> listUserAlbumPhoto = userAlbumPhotoService
				.findByPhotoId(id);
		UserAlbumPhoto userAlbumPhoto = new UserAlbumPhoto();
		userAlbumPhoto = listUserAlbumPhoto.get(0);
		req.setAttribute("userAlbumPhoto", userAlbumPhoto);
		req.setAttribute("blogUser", blogUser);
		req.setAttribute("zzzm", "0");

		return "/web/album/photo";

	}

	
	 /** // 设置相片为博客相册封面
	 * 
	 * @RequestMapping(value = "blogAlbum.do") public String
	 * blogAlbum(HttpServletRequest req, HttpServletResponse res, long photoId)
	 * throws UnsupportedEncodingException {
	 * 
	 * UserAlbumPhoto userPhoto = userAlbumPhotoService.findByPhotoId(photoId)
	 * .get(0); UserAlbum userAlbum = userPhoto.getUserAlbum();
	 * 
	 * UserInfo user = userAlbum.getUserInfo(); String blogUNickname =
	 * user.getNickName();
	 * 
	 * Blog blog = user.getBlog(); blog.setBlog_Album(userPhoto.getPhoto());
	 * 
	 * // 保存更新 blogService.updateBlog(blog);
	 * 
	 * return "redirect:/web/Blog/" + URLEncoder.encode(blogUNickname, "UTF-8");
	 * }*/
	 
	// 设置相片为相册的封面
	@RequestMapping(value = "photoAlbum.do")
	public String photoAlbum(HttpServletRequest req, HttpServletResponse res,
			long photoId) {

		UserAlbumPhoto userPhoto = userAlbumPhotoService.findByPhotoId(photoId)
				.get(0);
		UserAlbum userAlbum = userPhoto.getUserAlbum();

		userAlbum.setUserAlbumPhoto(userPhoto);
		userAlbumService.updateUserAlbum(userAlbum);

		return "redirect:listAlbum.do?id="
				+ userAlbum.getUserInfo().getId();
	}

	// 删除相册
	@RequestMapping(value = "deleteAlbum.do")
	public String deleteAlbum(HttpServletRequest req, HttpServletResponse res,
			long id, int page, long blId) {

		// 判断是否登录
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

		UserInfo blogUser = userInfoService.findById(blId);
		req.setAttribute("blogUser", blogUser);

		try {
			UserAlbum album = userAlbumService.listUserAlbumById(id).get(0);

			album.setUserAlbumPhoto(null);
			userAlbumService.updateUserAlbum(album);
			List<UserAlbumPhoto> listPhoto = userAlbumPhotoService
					.findByUserAlbumId(id);
			for (UserAlbumPhoto photo : listPhoto) {
				userAlbumPhotoService.delete(photo.getId());
			}
			UserInfo user = album.getUserInfo();
			userAlbumService.delete(album.getId());

			return "redirect:listAlbum.do?id=" + user.getId();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("result", "Album not found");
			return "/web/ERROR/result";
			// return "/web/ERROR/error";
		}

	}

	// 删除相片
	@RequestMapping(value = "deletePhoto.do")
	public String deletePhoto(HttpServletRequest req, HttpServletResponse res,
			long id, int page, long blId) throws Exception, IOException {
		try {
			// 判断是否登录
			UserInfo userInfo = (UserInfo) req.getSession().getAttribute(
					"userInfo");
			if (userInfo == null) {
				req.setAttribute("result", "Has been dropped, please re-login");
				return "/web/ERROR/result";
			}
			UserAlbumPhoto photo = userAlbumPhotoService.findByPhotoId(id).get(
					0);
			UserAlbum album = photo.getUserAlbum();
			req.setAttribute("album", album);
			// 判断该相册是否还有照片
			List<UserAlbumPhoto> listPhoto = userAlbumPhotoService
					.findByUserAlbumId(album.getId());
			if (listPhoto.size() > 1) {
				userAlbumPhotoService.delete(id);
			} else {
				UserAlbumPhoto cover = userAlbumPhotoService.findByPhotoId(1)
						.get(0);
				album.setUserAlbumPhoto(cover);
				userAlbumService.updateUserAlbum(album);

				List<UserAlbumPhoto> listPhoto0 = userAlbumPhotoService
						.findByUserAlbumId(album.getId());
				/*
				 * for (UserAlbumPhoto photo0 : listPhoto0) {
				 * userAlbumPhotoService.delete(photo0.getId()); }
				 */
				userAlbumPhotoService.delete(listPhoto0.get(0).getId());
				return "redirect:listAlbum.do?id=" + userInfo.getId()
						+ "&page=" + page;

			}

			/*
			 * // 进行分页 String albumName = "Qualification Proof";
			 * 
			 * // 相片分页 int pageSize = 12; PageModel pm =
			 * userAlbumPhotoService.listPhotoByAlbum(offset, pageSize,
			 * album.getId()); req.setAttribute("pm", pm);
			 * 
			 * boolean value =
			 * userAlbumService.checkExistByUserAndAlbumName(blId, albumName);
			 * if (value) { // 资质单独放一个list List<UserAlbum> listZzzm =
			 * userAlbumService.findByUserAndId( blId, albumName); UserAlbum
			 * zzzm = listZzzm.get(0); req.setAttribute("zzzm", zzzm); }
			 * 
			 * // 相册分页 List<UserAlbum> listUserAlbum = userAlbumService
			 * .findByUserInfoId(blId);
			 * 
			 * if (listUserAlbum.size() < 1) { req.setAttribute("blogUser",
			 * userInfo); return "redirect:listAlbumPhoto.do?pager.offset=" +
			 * offset + "&record=" + record + "&id=" + album.getId() + "&blId="
			 * + blId; }
			 */
			return "redirect:listAlbumPhoto.do?&id=" + album.getId() + "&blId="
					+ blId + "&page=" + page;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("result", "The pic has been used as album cover, or finally delete");
			return "/web/ERROR/result";
			// return "/web/ERROR/error";
		}

	}
}
