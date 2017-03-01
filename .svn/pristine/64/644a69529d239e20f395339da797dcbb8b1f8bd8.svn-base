/**
 * 
 */
package com.bbsBlog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.entity.FlagHi;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.FlagHiService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月13日
 *
 */
@Controller
@RequestMapping("/web/management/Flag")
public class FlagController {
	@Resource
	private FlagHiService  flagHiService;
	
	private final String LIST_ACTION = "redirect:/web/management/Flag/list";
	
	@RequestMapping(value="/new")
	public String saveFlag(FlagHi flagHi){
		return "newSuccess";
	}
	@RequestMapping(value="/list")
	public String listFlag(HttpServletRequest request){
		int offset = 0;
		int pageSize = 15;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
		}
		
		PageModel pm = flagHiService.listFlagHi(offset, pageSize);
		request.setAttribute("pm", pm);
		
		return "listFlag";
	}
	@RequestMapping(value="/delete_{id}")
	public String deleteFlagHi(HttpServletRequest request,@PathVariable long id){
		
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
		
		flagHiService.deleteFlagHi(id);
		return LIST_ACTION;
	}
}
