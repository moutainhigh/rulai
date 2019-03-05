package com.unicdata.controller.boutique;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.BoutiqueAnalysisCondition;
import com.unicdata.condition.BoutiqueInstallCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.InstallSupportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@Controller
@RequestMapping("/rulai/boutiqueInstall")
@Api(value="精品加装排程",tags={"精品加装排程相关接口"})
public class BoutiqueInstallController extends HomeBaseController{

	@Autowired
	private InstallSupportService installSupportService;
	
	/**
	 * 精品加装排程条件分页查询
	 */
	@ApiOperation(value = "精品加装排程条件分页查询", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code", value = "订单号", required = true,  dataType = "String"),
		@ApiImplicitParam(name = "name", value = "项目负责人名称", required = true,  dataType = "String"),
		@ApiImplicitParam(name = "departmentId", value = "部门ID", required = true,  dataType = "Id"),
		@ApiImplicitParam(name = "status", value = "工作状态", required = true,  dataType = "String"),
		@ApiImplicitParam(name = "actualDelivery", value = "实际完成时间", required = true,  dataType = "String"),
		@ApiImplicitParam(name = "expectedComplete", value = "安排施工时间", required = true,  dataType = "String"),
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectInstallByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectInstallByCondition(HttpServletRequest request,BoutiqueInstallCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		condition.setStoreId(member.getStoreId());
		PageInfo<Map<String, Object>> page = installSupportService.selectInstallByCondition(condition);
		result.setData(page);
		return result;
	}
	
	/**
	 * 精品加装排程条件分页查询
	 */
	@ApiOperation(value = "精品加装排程 - 开始、完成按钮", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "施工项目id", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "status", value = "状态( 1 - 未施工 ； 2- 施工中 ；3 - 已完工)", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/updateInstallByProjectId", method = { RequestMethod.POST })
	public ApiReturnInfo<String> updateInstallByProjectId(HttpServletRequest request,Integer id,Integer status){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		
		try {
			int update = installSupportService.updateInstallByProjectId(id,status);
			if(update >= 1){
				result.setData("success!");
			}else{
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
				result.setData("failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
			result.setData("failed!");
		}
		return result;
	}
	
	
//	/**
//	 * 精品项目加装分析
//	 */
//	@ApiOperation(value = "精品项目加装分析", notes = "")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "startTime", value = "付款时间（开始）", required = false,  dataType = "String"),
//		@ApiImplicitParam(name = "endTime", value = "付款时间（结束）", required = false,  dataType = "String"),
//		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
//		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number")
//	})
//	@ResponseBody
//	@RequestMapping(value = "/selectInstallAnalysisPage", method = { RequestMethod.POST })
//	public ApiReturnInfo selectInstallAnalysisPage(HttpServletRequest request,BoutiqueAnalysisCondition condition){
//		
//		
//		return null;
//	}
	
	
	
}
