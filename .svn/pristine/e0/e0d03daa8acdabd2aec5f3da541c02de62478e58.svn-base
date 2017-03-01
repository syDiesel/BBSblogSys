/**
 * 
 */
package com.bbsBlog.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BoardService;

/**
 * @author Robust
 *
 * @date 2014年8月6日
 *
 */

@Controller
@RequestMapping("web/management/Board")
public class BoardController {

	private final String LIST_ACTION = "redirect:/web/management/Board/list";

	@Resource
	private BoardService boardService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addBoard(HttpServletRequest request,
			HttpServletResponse response, Board board, MultipartFile file)
			throws IOException {
		//这里开始为权限认证
		//loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute("userInfo");
		if(loginUser==null){

			return "redirect:../../../login.html";

		}
		

		else if (loginUser.getRole()==null||loginUser.getRole().getId()!=1){
			//return "redirect:/addBoard";			
			System.out.println("非管理员权限");		
			return LIST_ACTION;
		}
		
		

		
		
		if (file.getOriginalFilename().isEmpty()) {
			System.out.println("未上传图片");
			board.setBoardPic("web/management/upload/default.jpg");
			System.out.println("fileUrl:" + board.getBoardPic());
			System.out.println("========================================");
		} else {

			// 获取当期时间，作为文件名，避免重复
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSSS");
			String fileTime = sdf.format(new Date());

			// 1、当前时间替换文件名=======2、获取后缀名
			String fileName = file.getOriginalFilename();
			int beginIndex = fileName.lastIndexOf(".");
			String newFileName = file.getOriginalFilename().substring(0,
					beginIndex)
					+ "_"
					+ fileTime
					+ fileName.substring(beginIndex, fileName.length());

			// 上传的文件放在“realPath”目录下
			String realPath = request.getSession().getServletContext()
					.getRealPath("web/management/upload");
			if ((new File(realPath).isDirectory())) {
				System.out.println("文件夹已存在！创建失败！");
			} else {
				new File(realPath).mkdir();
				System.out.println("创建文件夹成功！");
			}
			System.out.println("realPath:" + realPath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath, newFileName));
			System.out.println("========================================");

			// 将文件名存入数据库
			board.setBoardPic("web/management/upload/" + newFileName);
			System.out.println("fileUrl:" + board.getBoardPic());
			System.out.println("========================================");
		}
		/*
		 * Date date = new Date(); SimpleDateFormat simpleDateFormat = new
		 * SimpleDateFormat("yyyy-MM-dd  HH:mm:ss"); String nowTime =
		 * simpleDateFormat.format(date).toString();
		 */
		try {
			this.boardService.saveBoard(board);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return LIST_ACTION;
		// return listBoard(request, response);
	}

	@RequestMapping(value = "/update")
	public String updateBoard(HttpServletRequest request,
			HttpServletResponse response, Board board, MultipartFile file)
			throws IOException {

		//这里开始为权限认证
		//loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute("userInfo");
		if(loginUser==null){

			return "redirect:../../../login.html";

		}
		

		else if (loginUser.getRole()==null||loginUser.getRole().getId()!=1){
			//return "redirect:/addBoard";			
			System.out.println("非管理员权限");		
			return LIST_ACTION;
		}
		
		
		
		
		
		if (file.getOriginalFilename().isEmpty()) {
			System.out.println("未上传图片");
			System.out.println("fileUrl:" + board.getBoardPic());
			System.out.println("========================================");
		} else {

			// 获取当期时间，作为文件名，避免重复
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSSS");
			String fileTime = sdf.format(new Date());

			// 1、当前时间替换文件名=======2、获取后缀名
			String fileName = file.getOriginalFilename();
			int beginIndex = fileName.lastIndexOf(".");
			String newFileName = file.getOriginalFilename().substring(0,
					beginIndex)
					+ "_"
					+ fileTime
					+ fileName.substring(beginIndex, fileName.length());

			// 上传的文件放在“realPath”目录下
			String realPath = request.getSession().getServletContext()
					.getRealPath("web/management/upload");
			if ((new File(realPath).isDirectory())) {
				System.out.println("文件夹已存在！创建失败！");
			} else {
				new File(realPath).mkdir();
				System.out.println("创建文件夹成功！");
			}
			System.out.println("realPath:" + realPath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath, newFileName));
			System.out.println("========================================");

			// 将文件名存入数据库
			board.setBoardPic("web/management/upload/" + newFileName);
			System.out.println("fileUrl:" + board.getBoardPic());
			System.out.println("========================================");
		}
		/*
		 * Date date = new Date(); SimpleDateFormat simpleDateFormat = new
		 * SimpleDateFormat("yyyy-MM-dd  HH:mm:ss"); String nowTime =
		 * simpleDateFormat.format(date).toString();
		 */
		try {

			boardService.updateBoard(board);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		return LIST_ACTION;
	}

	@RequestMapping(value = "/list")
	public String listBoard(HttpServletRequest request,
			HttpServletResponse response) {
		List<Board> boards = boardService.listBoard();

		request.setAttribute("boards", boards);

		return "listBoard";
	}

	@RequestMapping(value = "/delete_{id}")
	public String deleteBoard(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		
		//这里开始为权限认证
		//loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute("userInfo");
		if(loginUser==null){

			return "redirect:../../../login.html";

		}
		

		else if (loginUser.getRole()==null||loginUser.getRole().getId()!=1){
			//return "redirect:/addBoard";			
			System.out.println("非管理员权限");		
			return LIST_ACTION;
		}
		
		
		
		
		boardService.deleteBoard(id);

		return LIST_ACTION;
	}

	@RequestMapping(value = "/list_{id}")
	public String listBoard(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		Board board = boardService.listBoardById(id);
		request.setAttribute("board", board);

		return "modifyBoard";
	}

}
