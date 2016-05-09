package com.jeecms.cms.service;
/**
 * @author Tom
 */
public interface ImageSvc {
	/**
	 * 抓取远程图片返回本地地址
	 * @param imgUrl 远程图片URL
	 * @param contextPath 部署路径
	 * @param uploadPath 上传路径
	 * @return
	 */
	public String crawlImg(String imgUrl,String contextPath,String uploadPath);
}
