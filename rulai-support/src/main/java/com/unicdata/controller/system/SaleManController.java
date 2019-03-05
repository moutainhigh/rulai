package com.unicdata.controller.system;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.order.SaleOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create by zhang
 */
@Controller
@RequestMapping("/rulai/saleMan")
@Api("获取销售人员列表")
public class SaleManController extends HomeBaseController {

    @Autowired
    private SaleOrderService saleOrderService;

    @ApiOperation("获取销售人员列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ApiReturnInfo list(HttpServletRequest request, @ApiIgnore ApiReturnInfo<List<Employee>> apiReturnInfo) {
        Integer storeId = getMember(request).getStoreId();
        List<Employee> employees = saleOrderService.saleManList(storeId);
        apiReturnInfo.setData(employees);
        return apiReturnInfo;
    }
}
