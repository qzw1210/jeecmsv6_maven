package com.jeecms.cms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeecms.common.file.FileNameUtils;
import com.jeecms.common.upload.UploadUtils;
import com.jeecms.common.web.springmvc.RealPathResolver;

/**
 * @author Tom
 */
public class ImageSvcImpl implements ImageSvc {
	public String crawlImg(String imgUrl,String contextPath,String uploadPath) {
		HttpClient client = new DefaultHttpClient();
		String outFileName="";
		try{
			HttpGet httpget = new HttpGet(new URI(imgUrl));
			HttpResponse response = client.execute(httpget);
			InputStream is = null;
			OutputStream os = null;
			HttpEntity entity = null;
			entity = response.getEntity();
			is = entity.getContent();
			outFileName=UploadUtils.generateFilename(uploadPath, FileNameUtils.getFileSufix(imgUrl));
			File outFile=new File(realPathResolver.get(outFileName));
			UploadUtils.checkDirAndCreate(outFile.getParentFile());
			os = new FileOutputStream(outFile);
			IOUtils.copy(is, os);
		}catch (Exception e) {
		}
		return contextPath+outFileName;
	}
	@Autowired
	private RealPathResolver realPathResolver;
}
