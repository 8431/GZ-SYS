/**
 * projectName: gz-sys
 * fileName: DoctorController.java
 * packageName: com.gzsys.modules.yun.controller
 * date: 2018-02-26 10:59
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.gzsys.common.base.controller.BaseController;
import com.gzsys.common.exception.BaseException;
import com.gzsys.common.util.*;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.entity.UserLogin;
import com.gzsys.modules.yun.request.DoctorRequest;
import com.gzsys.modules.yun.request.UserBaseRequest;
import com.gzsys.modules.yun.service.UserBaseService;
import com.gzsys.modules.yun.service.UserLoginService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DoctorController
 * @packageName: com.gzsys.modules.yun.controller
 * @description: 医生信息Controller
 * @data: 2018-02-26 10:59
 **/
@RestController
@RequestMapping(value = "/api/v1/doctor")
@Api(value = "医生信息操作接口",description = "fendo")
public class DoctorController extends BaseController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserBaseService userBaseService;

    /**
     * 查询医生信息列表
     * @return
     */
    @PostMapping(value = "/list")
    @ResponseBody
    @ApiOperation("查询医生列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名字", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "inPost", value = "在线状态", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "医生职称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "department", value = "科室筛选", required = false, dataType = "String", paramType = "query"),
    })
    @ApiResponses(value = {@ApiResponse(code = 405, message = "invalid input")})
    public JSONResult<CustomPage<Map<String,Object>>> list(@ApiParam(required = false, value = "分页参数") @RequestBody(required=false) FrontPage<DoctorRequest> frontPage){
        JSONResult<CustomPage<Map<String,Object>>> result = null;
        CustomPage<Map<String,Object>> customPage = new CustomPage<Map<String,Object>>();
        try {
            Page<Map<String,Object>> pageList = userBaseService.queryPageDoctorInformationList(frontPage.getPagePlus(),frontPage.getParam());
            customPage = new CustomPage<Map<String,Object>>(pageList);
        } catch (BaseException e) {
            result = new JSONResult<CustomPage<Map<String,Object>>>(SimpleCode.ERROR);
        }
        result = new JSONResult<CustomPage<Map<String,Object>>>(SimpleCode.SUCCESS,customPage);
        return result;
    }

    /**
     * 保存医生信息
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    @ApiOperation(value = "更新医生信息", notes = "更新医生信息")
    public JSONResult<SimpleResult> save(@ApiParam(required = true, value = "医生信息") @RequestBody(required=true) DoctorRequest doctorRequest){
        JSONResult<SimpleResult> result;
        UserBase userBase = new UserBase();
        UserLogin userLogin = new UserLogin();
        try {
            if(validates(this.validator, doctorRequest)!=null){
                return new JSONResult<SimpleResult>(SimpleCode.ERROR.getCode(),validates(validator, doctorRequest)) ;
            }
            BeanUtils.copyProperties(doctorRequest,userBase);
            BeanUtils.copyProperties(doctorRequest,userLogin);
            //为空 新增
            if(StringUtils.isNotEmpty(doctorRequest.getUserId())){
                String uuid =  UUIDTool.getUUID();
                userBase.setId(uuid);
                userLogin.setId(uuid);
                //userLoginService.insert(userLogin);
                //userBaseService.insert(userBase);
            }else {
                userBase.setId(doctorRequest.getUserId());
                userLogin.setId(doctorRequest.getUserId());
                //userLoginService.updateAllColumnById(userLogin);
                //userBaseService.updateAllColumnById(userBase);
            }
            //更新数据
            userLogin.insertOrUpdate();
            userBase.insertOrUpdate();
        } catch (BaseException e) {
            result = new JSONResult<SimpleResult>(SimpleCode.ERROR.getCode(),e.getMessage());
        }
        result = new JSONResult<SimpleResult>(SimpleCode.SUCCESS);
        return result;
    }
}
