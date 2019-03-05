package com.unicdata.controller.system;


import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.CommonCode;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Distributor;
import com.unicdata.service.system.DistributorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rulai/Information")
@Api(value = "集团信息维护", tags = { "集团信息维护相关接口" }) // swagger控制器说明注解
public class DistributorController extends HomeBaseController {

	@Autowired
	private DistributorService distributorService;

	// 图片格式
	@Value(value = "${upload.picture.type}")
	private String uploadPictureType;
	// 文件上传路径
	@Value(value = "${upload.file.path}")
	private String uploadFilePath;


	/**
	 * 
	 * 获取集团信息维护
	 */
	@ApiOperation(value = "获取集团信息维护", notes = "获取集团信息维护")
	@ResponseBody
	@RequestMapping(value = "/info", method = { RequestMethod.POST })
	public ApiReturnInfo<Distributor> info(Distributor distributor, HttpServletRequest request) {
		ApiReturnInfo<Distributor> result = new ApiReturnInfo<Distributor>();
		result.setCode(CommonCode.RESULT_CODE_SUCC);
		result.setMessage(CommonCode.map.get(CommonCode.RESULT_CODE_SUCC));
		result.setData(distributorService.selectByDistributor(distributor));
		return result;
	}
	/**
	 * 保存集团信息
	 */
	@ApiOperation(value = "保存集团信息", notes = "保存集团信息")
	@ApiImplicitParam(name = "distributorArticle", value = "集团实体(修改需传id)", required = true, dataType = "DistributorArticle")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ApiReturnInfo<Integer> save(@RequestBody Distributor distributor, HttpServletRequest request) {
		ApiReturnInfo<Integer> result = new ApiReturnInfo<Integer>();
		int num = 0;
		if (null != distributor.getId() && distributor.getId() > 0) {
			// 修改
			num = distributorService.updateByPrimaryKeySelective(distributor);
		}
		if (num > 0) {
			result.setCode(CommonCode.RESULT_CODE_SUCC);
			result.setMessage(CommonCode.map.get(CommonCode.RESULT_CODE_SUCC));
		} else {
			result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
			result.setMessage(CommonCode.map.get(CommonCode.RESULT_CODE_EXCEPTION));
		}
		result.setMessage("保存成功");
		return result;
	}
}
