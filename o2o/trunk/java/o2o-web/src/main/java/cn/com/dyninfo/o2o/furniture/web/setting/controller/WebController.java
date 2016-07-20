/*
 * Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 * All rights reserved.
 *
 * This file contains valuable properties of  SHENZHEN Eternal Dynasty
 * Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
 * confidential information, ideas and expressions.    No part of this
 * file may be reproduced or distributed in any form or by  any  means,
 * or stored in a data base or a retrieval system,  without  the prior
 * written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
 *
 */

package cn.com.dyninfo.o2o.furniture.web.setting.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import cn.com.dyninfo.o2o.furniture.web.framework.context.Context;
import cn.com.dyninfo.o2o.furniture.web.setting.model.Web;
import cn.com.dyninfo.o2o.furniture.web.setting.service.WebService;
/**
 * 网站设置
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/manage/web")
public class WebController {
	@Resource
	   private WebService webService;
	
	   
	   
	   /**
		 * 修改
		 * @param id
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/{id}/disUpdate")
		public ModelAndView disUpdate(@PathVariable String id,HttpServletRequest request){
			ModelAndView mav=new ModelAndView();
			try{
				Web info = (Web) webService.getObjById(id);
				mav.addObject("C_STATUS", request.getParameter("C_STATUS"));
				mav.addObject("info",info);
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.setViewName("/web/update");
			return mav;
		}
		
		
	   
	   
	  

		 
		 /**
		  * 更改
		  * @param request
		  * @param cardInfo
		  * @return
		  */
		 @RequestMapping(method=RequestMethod.PUT)
		 public ModelAndView endit(HttpServletRequest request,Web info){
			 ModelAndView mav=new ModelAndView();
			 try {
				 if(info.getBgColor()!=null&&info.getBgColor().length()>0)
					 Context.freeMakerData.put("bgColor", info.getBgColor());
				 if(info.getBgImage()!=null&&info.getBgImage().length()>0)
					 Context.freeMakerData.put("bgImage", info.getBgImage());
				 webService.updateObj(info);
				 mav.addObject("C_STATUS", 1);
				}catch(Exception e){
					e.printStackTrace();
					mav.addObject("C_STATUS", 0);
				}
				mav.setViewName("redirect:/html/manage/web/1/disUpdate");
			 return mav;
		 }
		
}