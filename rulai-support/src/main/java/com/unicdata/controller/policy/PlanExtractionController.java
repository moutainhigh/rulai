package com.unicdata.controller.policy;

import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.policy.PlanExtraction;
import com.unicdata.entity.policy.PlanExtractionExample;
import com.unicdata.entity.policy.PlanExtractionRebate;
import com.unicdata.entity.policy.PlanExtractionRebateExample;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.policy.PlanExtractionRebateService;
import com.unicdata.service.policy.PlanExtractionService;
import com.unicdata.service.system.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by myMsi on 2018/6/8.
 */
@Api(value = "返利计提管理")
@RestController
@RequestMapping("/rulai/planExtraction")
public class PlanExtractionController extends HomeBaseController {

    @Autowired
    private PlanExtractionService planExtractionService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PlanExtractionRebateService planExtractionRebateService;

    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year" ,value = "返利计提-年份（默认当前年份）" , required = false, dataType = "Integer", paramType = "form" ),
            @ApiImplicitParam(name = "isDetail" ,value = "是否查询返利项目明细 1：是 ，不传或0：否 " , required = false, dataType = "Integer", paramType = "form" )
    })
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<List<PlanExtraction>> list(HttpServletRequest request ,Integer year ,Integer isDetail){
        ApiReturnInfo ar = new ApiReturnInfo();
        Integer thisMonth = Integer.valueOf(new SimpleDateFormat("yyyyMM").format(System.currentTimeMillis()));
        if(year == null ){
            year = Integer.parseInt(new SimpleDateFormat("yyyy").format(System.currentTimeMillis()));
        }
        Employee u = super.getMember(request);
        PlanExtractionExample pe = new PlanExtractionExample();
        PlanExtractionExample.Criteria criteria = pe.createCriteria();
        criteria.andPlanYearEqualTo(year);
        if(u.getStoreId()!= null && u.getStoreId() > 0){
            criteria.andStoreIdEqualTo(u.getStoreId());
        }
        pe.setOrderByClause(" plan_extraction_date desc ");
        List<PlanExtraction> planExtractions = planExtractionService.selectByExample(pe);
        for(PlanExtraction p : planExtractions){
            Employee employee = employeeService.selectByPrimaryKey(p.getEmployeeId());
            if(employee != null){
                p.setEmployeeName(employee.getFullName());
            }
            if(isDetail != null && isDetail == 1){
                PlanExtractionRebateExample pee = new PlanExtractionRebateExample();
                pee.createCriteria().andPlanExtractionIdEqualTo(p.getId());
                List<PlanExtractionRebate> planExtractionRebates = planExtractionRebateService.selectByExample(pee);
                p.setPlanExtractionRebates(planExtractionRebates);
            }
            p.setShow(2);
            if(p.getPlanExtractionDate() < thisMonth){
                p.setShow(1);
            }
        }
        ar.setData(planExtractions);
        return ar;
    }

    @ApiOperation(value = "计提审核")
    @ApiImplicitParam(name = "id" ,value = "返利计提id" , required = true, dataType = "Integer", paramType = "form" )
    @RequestMapping(value = "/planCheck" ,method = RequestMethod.POST)
    public ApiReturnInfo planCheck(HttpServletRequest request , Integer id) throws ParseException {
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee member = super.getMember(request);
        if(FINANCE_MANAGER.equals( member.getPostName())){
            planExtractionService.planCheck(id,member.getId());
        }else{
            ar.setCode(500);
            ar.setMessage("该审核只可由财务部经理操作！");
        }
        return ar;
    }




}
