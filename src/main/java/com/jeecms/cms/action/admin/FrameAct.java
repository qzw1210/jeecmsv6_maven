package com.jeecms.cms.action.admin;

import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FrameAct {
	@RequiresPermissions("frame:config_main")
	@RequestMapping("/frame/config_main.do")
	public String configMain(ModelMap model) {
		return "frame/config_main";
	}

	@RequiresPermissions("frame:config_left")
	@RequestMapping("/frame/config_left.do")
	public String configLeft(ModelMap model) {
		return "frame/config_left";
	}

	@RequiresPermissions("frame:config_right")
	@RequestMapping("/frame/config_right.do")
	public String configRight(ModelMap model) {
		return "frame/config_right";
	}

	@RequiresPermissions("frame:user_main")
	@RequestMapping("/frame/user_main.do")
	public String userMain(ModelMap model) {
		return "frame/user_main";
	}

	@RequiresPermissions("frame:user_left")
	@RequestMapping("/frame/user_left.do")
	public String userLeft(ModelMap model) {
		return "frame/user_left";
	}

	@RequiresPermissions("frame:user_right")
	@RequestMapping("/frame/user_right.do")
	public String userRight(ModelMap model) {
		return "frame/user_right";
	}

	@RequiresPermissions("frame:maintain_main")
	@RequestMapping("/frame/maintain_main.do")
	public String maintainMain(ModelMap model) {
		return "frame/maintain_main";
	}

	@RequiresPermissions("frame:maintain_left")
	@RequestMapping("/frame/maintain_left.do")
	public String maintainLeft(ModelMap model) {
		model.addAttribute("db", db);
		return "frame/maintain_left";
	}

	@RequiresPermissions("frame:maintain_right")
	@RequestMapping("/frame/maintain_right.do")
	public String maintainRight(ModelMap model) {
		return "frame/maintain_right";
	}
	

	@RequiresPermissions("frame:content_main")
	@RequestMapping("/frame/content_main.do")
	public String contentMain(String source,ModelMap model) {
		model.addAttribute("source", source);
		return "frame/content_main";
	}
	
	@RequiresPermissions("frame:statistic_main")
	@RequestMapping("/frame/statistic_main.do")
	public String statisticMain(ModelMap model) {
		return "frame/statistic_main";
	}
	
	@RequiresPermissions("frame:statistic_left")
	@RequestMapping("/frame/statistic_left.do")
	public String statisticLeft(){
		return "frame/statistic_left";
	}
	
	@RequiresPermissions("frame:statistic_right")
	@RequestMapping("/frame/statistic_right.do")
	public String statisticRight(){
		return "frame/statistic_right";
	}
	
	
	@RequiresPermissions("frame:expand_main")
	@RequestMapping("/frame/expand_main.do")
	public String expandMain(ModelMap model) {
		return "frame/expand_main";
	}
	
	@RequiresPermissions("frame:expand_left")
	@RequestMapping("/frame/expand_left.do")
	public String expandLeft(ModelMap model){
		model.addAttribute("menus", getMenus());
		return "frame/expand_left";
	}
	
	@RequiresPermissions("frame:expand_right")
	@RequestMapping("/frame/expand_right.do")
	public String expandRight(){
		return "frame/expand_right";
	}
	private Map<String,String> menus;
	//数据库种类(mysql、oracle、sqlserver、db2)
	private String db;

	public Map<String, String> getMenus() {
		return menus;
	}

	public void setMenus(Map<String, String> menus) {
		this.menus = menus;
	}
	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}
	
	
}
