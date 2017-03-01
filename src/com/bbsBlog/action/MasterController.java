/**
 * 
 */
package com.bbsBlog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.entity.Master;
import com.bbsBlog.entity.MasterApply;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.MasterApplyService;
import com.bbsBlog.service.MasterService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月11日
 *
 */
@Controller
@RequestMapping("/web/management/Master")
public class MasterController {
	@Resource
	private MasterApplyService masterApplyService;
	@Resource
	private MasterService masterService;

	private final String List_APPLY = "redirect:/web/management/Master/listApply";

	private final String List_MASTER = "redirect:/web/management/Master/list";

	/**
	 * 
	 * @author Robust
	 *
	 * @date 2014年8月11日
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/listApply")
	public String listMasterApply(HttpServletRequest request) {

		int offset = 0;
		int pageSize = 15;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}

		PageModel pm = masterApplyService.listMasterApply(offset, pageSize);

		request.setAttribute("pm", pm);

		return "listMasterApply";
	}

	@RequestMapping(value = "/deleteApply_{id}")
	public String deleteMasterApply(HttpServletRequest request,@PathVariable long id) {
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
			return List_APPLY;
		}
		masterApplyService.deleteMasterApply(id);

		return List_APPLY;
	}

	@RequestMapping(value = "/listApply_{id}")
	public String listMasterApply(HttpServletRequest request,
			@PathVariable long id) {
		MasterApply masterApplys = masterApplyService.listMasterApplyById(id);
		request.setAttribute("masterApplys", masterApplys);
		return "addMaster";
	}

	@RequestMapping(value = "/new")
	public String saveMaster(Master master, long applyId,
			HttpServletRequest request) {
		applyId = Long.parseLong(request.getAttribute("applyId").toString());

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
			return List_MASTER;
		}
		masterApplyService.deleteMasterApply(applyId);

		masterService.saveMaster(master);

		return List_MASTER;
	}

	@RequestMapping(value = "/update")
	public String updateMaster(HttpServletRequest request,Master master) {
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
			return List_MASTER;
		}
		masterService.saveMaster(master);

		return List_MASTER;
	}

	@RequestMapping(value = "/delete_{id}")
	public String deleteMaster(HttpServletRequest request,@PathVariable long id) {

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
			return List_MASTER;
		}
		masterService.deleteMaster(id);
		return List_MASTER;
	}

	@RequestMapping(value = "/list_{id}")
	public String listMasterById(HttpServletRequest request,
			@PathVariable long id) {
		Master master = masterService.listMasterById(id);
		request.setAttribute("master", master);
		return "modifyMaster";

	}

	@RequestMapping(value = "/list")
	public String listMaster(HttpServletRequest request) {
		int offset = 0;
		int pageSize = 15;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}

		PageModel pm = masterService.listMaster(offset, pageSize);

		request.setAttribute("pm", pm);

		return "listMaster";

	}

}
