/**
 * 
 */
package com.bbsBlog.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.entity.Board;
import com.bbsBlog.entity.Label;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BoardService;
import com.bbsBlog.service.LabelService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月8日
 *
 */
@Controller
@RequestMapping("web/management/Label")
public class LabelController {

	@Resource
	private LabelService labelService;
	@Resource
	private BoardService boardService;

	private final String LIST_ACTION = "redirect:/web/management/Label/list";

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月8日
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/toAddLabel")
	public String listBoard(HttpServletRequest request,
			HttpServletResponse response) {
		List<Board> boards = boardService.listBoard();

		request.setAttribute("boards", boards);

		return "addLabel";
	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月8日
	 *
	 * @param request
	 * @param response
	 * @param label
	 * @return
	 */
	@RequestMapping(value = "/new")
	public String saveLabel(HttpServletRequest request,
			HttpServletResponse response, Label label) {

		// label.setIsVerify("0");

		// 这里开始为权限认证
		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}

		labelService.saveLabel(label);

		return LIST_ACTION;
	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月8日
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String listLabel(HttpServletRequest request,
			HttpServletResponse response) {

		List<Label> labels = labelService.listLabel();
		
		int offset = 0;
		
				try{
					offset = Integer.parseInt(request.getParameter("pager.offset"));
				}catch(Exception e){
					
				}
				
		int pageSize = 10;
		PageModel pm = labelService.listLabel(offset, pageSize);

		request.setAttribute("pm", pm);
		request.setAttribute("offset", offset);

		return "listLabel";

	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月8日
	 *
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_{id}")
	public String deleteLabel(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {

		// 这里开始为权限认证
		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}
		
		int offset = 0;
		
		try{
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		}catch(Exception e){
			
		}
		

		labelService.deleteLabel(id);
		return LIST_ACTION+"?pager.offset="+offset;
	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月8日
	 *
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/list_{id}")
	public String listLabel(HttpServletRequest request,
			HttpServletResponse response, @PathVariable long id) {
		Label labels = labelService.listLabelById(id);
		this.listBoard(request, response);

		request.setAttribute("labels", labels);

		return "modifyLabel";
	}

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月10日
	 *
	 * @param label
	 * @return
	 */
	@RequestMapping(value = "/update")
	public String updateLabel(HttpServletRequest request, Label label) {

		// 这里开始为权限认证
		// loginUser
		UserInfo loginUser = (UserInfo) request.getSession().getAttribute(
				"userInfo");
		if (loginUser == null) {

			return "redirect:../../../login.html";

		}

		else if (loginUser.getRole() == null
				|| loginUser.getRole().getId() != 1) {
			// return "redirect:/addBoard";
			System.out.println("非管理员权限");
			return LIST_ACTION;
		}

		labelService.updateLabel(label);

		return LIST_ACTION;
	}

}
