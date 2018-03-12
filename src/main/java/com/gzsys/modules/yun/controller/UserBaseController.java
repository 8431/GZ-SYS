package com.gzsys.modules.yun.controller;

import com.google.gson.Gson;
import com.gzsys.common.util.*;
import com.gzsys.modules.yun.service.DictionaryBaseService;
import com.gzsys.modules.yun.service.HealthDictEnteryService;
import com.gzsys.modules.yun.service.impl.DictionaryBaseServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.plugins.Page;
import com.gzsys.common.base.controller.BaseController;
import com.gzsys.common.exception.BaseException;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.request.UserBaseRequest;
import com.gzsys.modules.yun.response.HealthDictEnteryRespones;
import com.gzsys.modules.yun.service.UserBaseService;

/**
 * @author zhao
 */
@RestController
@RequestMapping(value = "/api/v1/userbase")
@Api("用户操作接口")
public class UserBaseController extends BaseController {

    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private HealthDictEnteryService healthDictEnteryService;
    @Autowired
    private DictionaryBaseService dictionarybaseservice;
    @Autowired
    Validator validator;

    /**
     * 查询医生列表
     *
     * @return
     */
    @RequestMapping(value = "/queryPageDoctorList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation("查询医生列表-zlp")
    public JSONResult<CustomPage<UserBase>> queryPageDoctorList(@RequestBody(required = false) FrontPage<UserBaseRequest> frontPage) {
        JSONResult<CustomPage<UserBase>> result = null;
        CustomPage<UserBase> customPage = new CustomPage<UserBase>();
        try {
            Page<UserBase> pageList = userBaseService.queryPageDoctorList(frontPage.getPagePlus(), frontPage.getParam());
            customPage = new CustomPage<UserBase>(pageList);
        } catch (BaseException e) {
            result = new JSONResult<CustomPage<UserBase>>(SimpleCode.ERROR);
        }
        result = new JSONResult<CustomPage<UserBase>>(SimpleCode.SUCCESS, customPage);
        return result;
    }

    /**
     * 查询医生详情
     *
     * @return
     */
    @RequestMapping(value = "/queryDoctorByID", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation("查询医生详情-zlp")
    public JSONResult<UserBase> queryDoctorByID(@ApiParam(value = "医生ID", required = true) @RequestParam String docId) {
        JSONResult<UserBase> result = null;
        UserBase userBase = null;
        FrontPage<UserBaseRequest> page = new FrontPage<UserBaseRequest>();
        try {
            UserBaseRequest user = new UserBaseRequest();
            user.setId(docId);
            Page<UserBase> pageList = userBaseService.queryPageDoctorList(page.getPagePlus(), user);
            List<UserBase> doctorList = pageList.getRecords();
            if (doctorList != null && doctorList.size() > 0) {
                userBase = doctorList.get(0);
            }
        } catch (BaseException e) {
            result = new JSONResult<UserBase>(SimpleCode.ERROR);
        }
        result = new JSONResult<UserBase>(SimpleCode.SUCCESS, userBase);
        return result;
    }

    @RequestMapping(value = "/queryDictEntery", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation("查询医生职称列表或科室(000001科室，000002医生职称)-zlp")
    public JSONResult<List<HealthDictEnteryRespones>> queryDictEntery(@ApiParam(value = "查询类型(000001科室，000002医生职称)", required = true) @RequestParam String code) {
        JSONResult<List<HealthDictEnteryRespones>> result = null;
        List<HealthDictEnteryRespones> dictEnteryList = new ArrayList<HealthDictEnteryRespones>();
        try {
        	dictEnteryList = healthDictEnteryService.queryDictEnteryByTypeCode(code);
        } catch (BaseException e) {
            result = new JSONResult<List<HealthDictEnteryRespones>>(SimpleCode.ERROR);
        }
        result = new JSONResult<List<HealthDictEnteryRespones>>(SimpleCode.SUCCESS, dictEnteryList);
        return result;
    }
    
    /**
     * 更新医生在线状态
     *
     * @return
     */
    @RequestMapping(value = "/updateDoctorInPost", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation("更新医生在线状态-zlp")
    public JSONResult<Boolean> updateDoctorInPost(@ApiParam(value = "医生ID", required = true) @RequestParam String docId,
                                                  @ApiParam(value = "在线状态 0不在线1在线2离开", required = true) @RequestParam String inPost) {
        JSONResult<Boolean> result = null;
        boolean result2 = false;
        UserBase userBase = new UserBase();
        try {
            userBase.setId(docId);
            userBase.setInPost(inPost);//在线状态
            userBase.setLastInlineTime(new Date());
            result2 = userBaseService.updateById(userBase);
        } catch (BaseException e) {
            result = new JSONResult<Boolean>(SimpleCode.ERROR);
        }
        result = new JSONResult<Boolean>(SimpleCode.SUCCESS, result2);
        return result;
    }

    ///////////////////////////////////////////////////////by dlf 对单表统一的动态增删改查 for 2018-02-26/////////////////////////////////////////////////////////////////
    @GetMapping(value = "/getColumn")
    @ApiOperation("查询表列和注释")
    public JSONResult<List> getColumn(@ApiParam(value = "表名", required = true) @RequestParam String table) {
        JSONResult<List> result = null;
        List<Map<String, Object>> result2 = new ArrayList<>();
        if (StringUtils.isEmpty(table)) {
            return result = new JSONResult(SimpleCode.ERROR, "table不能为空");
        }
        String tableName = (String) DictionaryBaseServiceImpl.TABLENAME.get(table);
        if (StringUtils.isEmpty(tableName)) {
            return result = new JSONResult(SimpleCode.ERROR, "该table编号不存在");
        }
        result2 = dictionarybaseservice.getColumn(tableName);
        result = new JSONResult<List>(SimpleCode.SUCCESS, result2);
        return result;
    }


    @PostMapping(value = "/queryPage")
    @ApiOperation("分页查询")
    public JSONResult<CustomPage<Map>> queryPage(@RequestBody(required = false) FrontPage<Map> frontPage) {
        JSONResult<CustomPage<Map>> result = null;
        CustomPage<Map> customPage = new CustomPage<Map>();
        Page<Map> pageList = null;
        //参数校验
        result = checkTableName(frontPage.getParam());
        if (result != null) {
            return result;
        }
        //参数校验
        pageList = dictionarybaseservice.queryPage(frontPage.getPagePlus(), frontPage.getParam());
        customPage = new CustomPage<Map>(pageList);
        result = new JSONResult<CustomPage<Map>>(SimpleCode.SUCCESS, customPage);
        return result;
    }

    @PostMapping(value = "/insert")
    @ApiOperation("批量新增")
    public JSONResult<String> insert(@RequestBody(required = false) Map insertParam) {
        JSONResult<String> result = null;
        Page<Map> pageList = null;
        //表名参数校验start--
        result = checkTableName(insertParam);
        if (result != null) {
            return result;
        }
        //表名参数校验end
        //逻辑参数校验（包括值的校验以及数据类型转换）------------------start-------------------------------
        List<Map<String, Object>> param = (List<Map<String, Object>>) insertParam.get("data");
        if (param == null || param.size() < 1) {
            return result = new JSONResult(SimpleCode.ERROR, "data不能为空");
        }
        result= checkValue(insertParam);
        if (result != null) {
            return result;
        }
        //逻辑参数校验------------------end-------------------------------
        int insertRe=dictionarybaseservice.insert(insertParam);
        result = new JSONResult(SimpleCode.SUCCESS, insertRe);
        return result;
    }

    @PostMapping(value = "/update")
    @ApiOperation("批量修改")
    public JSONResult<String> update(@RequestBody(required = false) Map insertParam) {
        JSONResult<String> result = null;
        Page<Map> pageList = null;
        //表名参数校验start--
        result = checkTableName(insertParam);
        if (result != null) {
            return result;
        }
        //表名参数校验end
        //逻辑参数校验（包括值的校验以及数据类型转换）------------------start-------------------------------
        List<Map<String, Object>> param = (List<Map<String, Object>>) insertParam.get("data");
        if (param == null || param.size() < 1) {
            return result = new JSONResult(SimpleCode.ERROR, "data不能为空");
        }
        result= checkValue(insertParam);
        if (result != null) {
            return result;
        }
        //逻辑参数校验------------------end-------------------------------
        int insertRe=dictionarybaseservice.update(insertParam);
        result = new JSONResult(SimpleCode.SUCCESS, insertRe);
        return result;
    }


    private JSONResult checkTableName(Map param) {
        JSONResult jt = null;
        String table = (String) param.get("table");
        if (StringUtils.isEmpty(table)) {
            return jt = new JSONResult(SimpleCode.ERROR, "table不能为空");
        }
        String tableName = (String) DictionaryBaseServiceImpl.TABLENAME.get(table);
        if (StringUtils.isEmpty(tableName)) {
            return jt = new JSONResult(SimpleCode.ERROR, "该table编号不存在");
        }
        //赋值真实表名
        param.put("table", tableName);
        return jt;

    }

    /**
     * 数据类型转换以及格式校验
     * 先处理时间格式，后续需求在添加
     * 第一版本做简单处理
     *
     * @param insertParam
     * @return
     */
    private JSONResult checkValue(Map insertParam)  {
        JSONResult jt = null;
        List<Map<String, Object>> param = (List<Map<String, Object>>) insertParam.get("data");
        String table=(String) insertParam.get("table");
        List<Map<String, Object>> rsLi = dictionarybaseservice.getColumn(table);
        //校验传过来的key是否存在，并替换数据格式
        List<String> gsLi = new ArrayList<>();
        for (Map<String, Object> m : rsLi) {
             String column = (String) m.get("COLUMN_NAME");
//            String length = (String) m.get("DATA_LENGTH");
            String type = (String) m.get("DATA_TYPE");
            if ("DATE".equals(type) || "TIMESTAMP".equals(type)) {
                gsLi.add(column);
            }
        }
        if(gsLi.size()>0)
        for (Map<String, Object> n : param) {
            Set s = n.keySet();
            Iterator it = s.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (gsLi.contains(key)) {
                    String time = (String) n.get(key);
                    //时间类型转换,格式配置文件配置
                    boolean re = RegexUtils.checkDate(time);
                    if (re) {
                        String format="";
                        String columnformat=PropertyUtil.getPropery("columnformat");
                        if(!StringUtils.isEmpty(columnformat)){
                            Gson gn=new Gson();
                            Map<String,Object> mp=gn.fromJson(columnformat,Map.class);
                            Map<String,Object>  column= (Map<String, Object>) mp.get(table);
                            if(column!=null&&column.size()>0){
                               String columnFormat= (String) column.get(key);
                               if(!StringUtils.isEmpty(columnFormat)){
                                   format=columnFormat;
                               }else{
                                   //没有规定数据格式
                                   return jt = new JSONResult(SimpleCode.ERROR, "时间格式没有设置");
                               }
                            }
                        }
                        Date date = null;
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat(format);
                            date = sdf.parse(time);
                        } catch (ParseException e) {
                            return jt = new JSONResult(SimpleCode.ERROR, "时间格式转换错误"+e.getMessage());
                        }
                        n.put(key, date);
                    } else {
                        //时间格式错误
                        return jt = new JSONResult(SimpleCode.ERROR, "时间格式错误");
                    }

                }
            }
        }

        return jt;

    }

}
