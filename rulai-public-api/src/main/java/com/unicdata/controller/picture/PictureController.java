package com.unicdata.controller.picture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.base.util.FileUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/picture")
@Api(value = "图片上传", tags = { "图片上传相关接口" }) // swagger控制器说明注解
public class PictureController {

	// 文件上传路径
	@Value("${upload.file.path}")
	private String uploadFilePath;
	// 图片上传路后缀
	@Value("${upload.picture.type}")
	private String uploadPictureType;

	/**
	 * 上传图片
	 * 
	 * @param activityId
	 * @return
	 */
	@ApiOperation(value = "保存图片", notes = "保存图片")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "file", value = "图片", required = true, paramType = "form", dataType = "MultipartFile"),
			@ApiImplicitParam(name = "size", value = "图片大小（单位byte）", required = true, paramType = "form", dataType = "long"),
			@ApiImplicitParam(name = "width", value = "图片  宽", required = false, paramType = "form", dataType = "Integer"),
			@ApiImplicitParam(name = "height", value = "图片  高", required = false, paramType = "form", dataType = "Integer") })
	@ResponseBody
	@RequestMapping(value = "/savePic", method = { RequestMethod.POST })
	public ApiReturnInfo<String> savePicture(@RequestParam(value = "file", required = false) MultipartFile file,
			Long size, Integer width, Integer height) {
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		if (null != file) {
			// 上传图片
			try {
				// 验证图片格式
				// 原始的文件名
				String filename = file.getOriginalFilename();
				// 获取扩展名
				String extensionName = StringUtils.substringAfterLast(filename, ".").toLowerCase();
				if (uploadPictureType.indexOf(extensionName) < 0) {
					result.setCode(ConstantEnumStatus.FAIL.getCode());
					result.setMessage("图片请上传后缀为'" + uploadPictureType + "'文件");
					return result;
				}
				// 限制图片大小 long getSize()获取文件的字节大小，单位byte
				if (null != size && file.getSize() > size) {
					result.setCode(ConstantEnumStatus.FAIL.getCode());
					result.setMessage("图片大小请限制在" + FormetFileSize(size) + "以内");
					return result;
				}
				if (null != width && width > 0 && null != height && height > 0) {
					// 限制图片的尺寸
					BufferedImage image = ImageIO.read(file.getInputStream());
					if (image.getWidth() != width || image.getHeight() != height) {
						result.setCode(ConstantEnumStatus.FAIL.getCode());
						result.setMessage("图片尺寸请限制为" + width + "*" + height + "px");
						return result;
					}
				}
				String fileName = FileUtil.uploadFile(file.getInputStream(), file.getOriginalFilename(), null,
						"/picture/" + DateUtil.dateFormat(new Date(), DateUtil.sdf5), uploadFilePath);
				result.setData(fileName);
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 转换文件大小
	 * 
	 * @param fileS
	 * @return
	 */
	public static String FormetFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}
	
	/**
	 * 多图片上传图片
	 * @param activityId
	 * @return
	 */
	@ApiOperation(value = "保存图片", notes = "保存图片")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "file", value = "图片", required = true, paramType = "form", dataType = "MultipartFile"),
			@ApiImplicitParam(name = "size", value = "图片大小（单位byte）", required = true, paramType = "form", dataType = "long"),
			@ApiImplicitParam(name = "width", value = "图片  宽", required = true, paramType = "form", dataType = "Integer"),
			@ApiImplicitParam(name = "height", value = "图片  高", required = true, paramType = "form", dataType = "Integer") })
	@ResponseBody
	@RequestMapping(value = "/savePicMore", method = { RequestMethod.POST })
	public ApiReturnInfo<String> savePictureMore(@RequestParam(value = "file", required = false) MultipartFile [] file,
			Long size, Integer width, Integer height) {
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		String fileNameString="";
		if (null != file) {
			// 上传图片
			try {
				// 验证图片格式
				// 原始的文件名
				for (MultipartFile multipartFile : file) {
				String filename = multipartFile.getOriginalFilename();
				// 获取扩展名
				String extensionName = StringUtils.substringAfterLast(filename, ".").toLowerCase();
				if (uploadPictureType.indexOf(extensionName) < 0) {
					result.setCode(ConstantEnumStatus.FAIL.getCode());
					result.setMessage("图片请上传后缀为'" + uploadPictureType + "'文件");
					return result;
				}
				// 限制图片大小 long getSize()获取文件的字节大小，单位byte
				if (multipartFile.getSize() > size) {
					result.setCode(ConstantEnumStatus.FAIL.getCode());
					result.setMessage("图片大小请限制在" + FormetFileSize(size) + "以内");
					return result;
				}
				if (null != width && width > 0 && null != height && height > 0) {
					// 限制图片的尺寸
					BufferedImage image = ImageIO.read(multipartFile.getInputStream());
					if (image.getWidth() != width || image.getHeight() != height) {
						result.setCode(ConstantEnumStatus.FAIL.getCode());
						result.setMessage("图片尺寸请限制为" + width + "*" + height + "px");
						return result;
					}
				}
				String fileName = FileUtil.uploadFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), null,
						"/picture/" + DateUtil.dateFormat(new Date(), DateUtil.sdf5), uploadFilePath);
				fileNameString=fileNameString+fileName+",";
			  }
				if (fileNameString.length()>1) {
				    fileNameString=fileNameString.substring(0,fileNameString.lastIndexOf(","));
				}
				result.setData(fileNameString);
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
