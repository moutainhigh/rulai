package com.unicdata.conditon;

import com.unicdata.entity.BaseEntity;
import com.unicdata.entity.policy.ArriveBillList;
import com.unicdata.entity.policy.ProofreaderList;
import com.unicdata.entity.policy.RebateProject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by myMsi on 2018/6/21.
 */
@ApiModel("返利项目详情")
public class RebateProjectCondition extends BaseEntity{

    @ApiModelProperty("核对单明细")
    List<ProofreaderList> proofreaderLists;
    @ApiModelProperty("到账单明细")
    List<ArriveBillList> arriveBillLists;
    @ApiModelProperty("调整明细")
    List<RebateProject> rebateProject;

    public List<ProofreaderList> getProofreaderLists() {
        return proofreaderLists;
    }

    public void setProofreaderLists(List<ProofreaderList> proofreaderLists) {
        this.proofreaderLists = proofreaderLists;
    }

    public List<ArriveBillList> getArriveBillLists() {
        return arriveBillLists;
    }

    public void setArriveBillLists(List<ArriveBillList> arriveBillLists) {
        this.arriveBillLists = arriveBillLists;
    }

    public List<RebateProject> getRebateProject() {
        return rebateProject;
    }

    public void setRebateProject(List<RebateProject> rebateProject) {
        this.rebateProject = rebateProject;
    }
}
