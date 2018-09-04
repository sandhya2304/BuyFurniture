package com.home.buyfurniture.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUplaodUtility
{
	
	private static final String ABS_PAIH="C:\\Users\\dlc\\git\\BuyFurniture\\buyfurniture\\src\\main\\webapp\\assets\\images\\";
	
	private static String REAL_PAIH="";
	
	private static final Logger logger=LoggerFactory.getLogger(FileUplaodUtility.class);

	
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{
		//get the real path
		REAL_PAIH=request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PAIH);
		
		//to make sure all directory exists
		//create new directory
		
		if(!new File(ABS_PAIH).exists())
		{
			//create the directories			
			new File(ABS_PAIH).mkdirs();
		}
		
		if(!new File(REAL_PAIH).exists())
		{
			//create the directories			
			new File(REAL_PAIH).mkdirs();
		}
		
		try
		{
		    //server upload
			file.transferTo(new File(REAL_PAIH + code + ".jpg"));
			
			//project directory upload
			file.transferTo(new File(ABS_PAIH + code + ".jpg"));

			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
