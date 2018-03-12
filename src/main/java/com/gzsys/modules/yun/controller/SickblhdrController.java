/**
 * projectName: gz-sys
 * fileName: SickblhdrController.java
 * packageName: com.gzsys.modules.yun.controller
 * date: 2018-02-01 14:43
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.controller;

import com.gzsys.common.base.controller.BaseController;
import com.gzsys.common.exception.BussinessException;
import com.gzsys.common.util.SimpleCode;
import com.gzsys.common.util.SimpleResult;
import com.gzsys.common.util.UUIDTool;
import com.gzsys.modules.yun.entity.*;
import com.gzsys.modules.yun.request.SickbldtlRequest;
import com.gzsys.modules.yun.request.SickblhdrRequest;
import com.gzsys.modules.yun.service.ChisFollowupPanService;
import com.gzsys.modules.yun.service.DiagnosisRecordsService;
import com.gzsys.modules.yun.service.InspectionItemsService;
import com.gzsys.modules.yun.service.SickblhdrService;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SickblhdrController
 * @packageName: com.gzsys.modules.yun.controller
 * @description: 病历Controller
 * @data: 2018-02-01 14:43
 **/
@RestController
@RequestMapping(value = "/api/v1/sickblhdr")
@Api("病历操作接口")
public class SickblhdrController extends BaseController {


    @Autowired
    private SickblhdrService sickblhdrService;

    @Autowired
    private ChisFollowupPanService chisFollowupPanService;

    @Autowired
    private InspectionItemsService inspectionItemsService;

    @Autowired
    private DiagnosisRecordsService diagnosisRecordsService;

    @Autowired
    Validator validator;

    /**
     *
     *@Title create
     *@Description: 新建病历表-Map
     *@Author fendo
     *@Date 2017年12月22日 10时23分36秒 星期五
     *@param map
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/sickblhdr/create?xxx
     */
    @PostMapping("createSickblhdr")
    @ResponseBody
    public SimpleResult createSickblhdr(@RequestBody Map<String,Object> map){
        SimpleResult simpleResult;
        Sickblhdr sickblhdr = new Sickblhdr();
        InspectionItems inspectionItems = null;
        ChisFollowupPan chisFollowupPan = null;
        SickblhdrRequest sickblhdrRequest = null;
        SickbldtlRequest sickbldtlRequest = null;
        DiagnosisRecords diagnosisRecords = null;
        List<DiagnosisRecords> diagnosisRecordsList = new ArrayList<DiagnosisRecords>();
        StringBuffer stringBufferID = new StringBuffer();
        StringBuffer stringBufferName = new StringBuffer();
        Sickbldtl dTsickbldtl = new Sickbldtl();
        String docguid;
        String sickguid;
        JSONObject jsonObj = null;
        String sickUUID = null;
        logger.info("[/SickblhdrController/createSickblhdr]");
        try {
            simpleResult = SimpleResult.success();
            sickUUID = UUIDTool.getUUID();
            JSONObject jsonObject = JSONObject.fromObject(map);
            String userid = jsonObject.getString("userid");
            String docid = jsonObject.getString("docid");
            //医生或用户ID不为空
            if(StringUtils.isNotEmpty(userid)||StringUtils.isNotEmpty(docid)){
                sickblhdrRequest = new SickblhdrRequest();
                sickblhdrRequest.setGuid(sickUUID);
                sickblhdrRequest.setSickguid(userid); //患者ID
                sickblhdrRequest.setDocguid(docid); //医生ID
                sickblhdrRequest.setState("0"); //设置状态为0
                //新增病历
                BeanUtils.copyProperties(sickblhdrRequest,sickblhdr);
                sickblhdrService.insert(sickblhdr);
            }else {

                JSONArray sickList = (JSONArray)jsonObject.fromObject(map).get("sick");
                if(sickList.size()>0) {
                    //判断是自动还是手动保存
                    if(!"".equals(jsonObject.getString("flag")) && jsonObject.getString("flag")!=null){

                        jsonObj = JSONObject.fromObject(sickList.get(0));
                        sickblhdrRequest = (SickblhdrRequest)JSONObject.toBean(jsonObj, SickblhdrRequest.class);
                        //判断病历ID是否为空
                        if("".equals(sickblhdrRequest.getGuid()) || sickblhdrRequest.getGuid() == null ){
                            //设置主键
                            //sickUUID = UUIDTool.getUUID();
                        }else {
                            sickUUID = sickblhdrRequest.getGuid();
                            //先删除随访计划
                            chisFollowupPanService.deleteByFollowupPlan(sickUUID);
                            //检查项删除
                            inspectionItemsService.deleteByInspectionItems(sickUUID);
                            //先删除用药方案
                            sickblhdrService.deleteDTsickbldtl(sickUUID);
                            //先删除诊断
                            diagnosisRecordsService.deleteOK(sickUUID);
                            //先删除病历
                            sickblhdrService.deleteOK(sickUUID);
                        }

                        //1手动 做校验
                        if("1".equals(jsonObject.getString("flag"))){
                            //患者性别
                            if(jsonObj.get("sex")!=null){
                                String sex= jsonObj.get("sex").toString();
                                if(!"".equals(sex)&&sex!=null){
                                    if("男".equals(sex)){
                                        sex="1";
                                    }else if("女".equals(sex)){
                                        sex="2";
                                    }else {
                                        sickblhdrRequest.setSex(sex);
                                    }
                                }else {
                                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者性别不能为空！");
                                }
                            }else {
                                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者性别不能为空！");
                            }

                            //心率: 数字
                            if(jsonObj.get("xl") != null){
                                String xl = jsonObj.get("xl").toString();
                                if(!"".equals(xl) && xl != null){
                                    if(isNumeric(xl)){
                                        sickblhdrRequest.setXl(xl);
                                    }else {
                                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "心率只能是整数型,不能带小数点!");
                                    }

                                }
                            }
                            //血压上: 数字
                            if(jsonObj.get("xy1") != null){
                                String xy1 = jsonObj.get("xy1").toString();
                                if(!"".equals(xy1) && xy1 != null){
                                    if(isNumeric(xy1)){
                                        sickblhdrRequest.setXy1(xy1);
                                    }else {
                                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "血压上只能是整数型,不能带小数点!");
                                    }

                                }
                            }
                            //血压下: 数字
                            if(jsonObj.get("xy2") != null){
                                String xy2 = jsonObj.get("xy2").toString();
                                if(!"".equals(xy2) && xy2 != null){
                                    if(isNumeric(xy2)){
                                        sickblhdrRequest.setXy2(xy2);
                                    }else {
                                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "血压下只能是整数型,不能带小数点!");
                                    }

                                }
                            }
                            //体重: 数字
                            if(jsonObj.get("weight") != null){
                                String weight = jsonObj.get("weight").toString();
                                if(!"".equals(weight) && weight != null){
                                    if(isNumeric(weight)){
                                        sickblhdrRequest.setWeight(weight);
                                    }else {
                                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "体重只能是整数型,不能带小数点!");
                                    }

                                }
                            }
                            //血氧: 数字
                            if(jsonObj.get("glucose") != null){
                                String glucose = jsonObj.get("glucose").toString();
                                if(!"".equals(glucose) && glucose != null){
                                    if(isNumeric(glucose)){
                                        sickblhdrRequest.setGlucose(glucose);
                                    }else {
                                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "血氧只能是整数型,不能带小数点!");
                                    }

                                }
                            }

                            //预约时间
                            if(jsonObj.get("clinicaltime") != null){
                                String clinicaltime = jsonObj.get("clinicaltime").toString();
                                if(!"".equals(clinicaltime) && clinicaltime != null){
                                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                                    sickblhdrRequest.setClinicaltime(date.format(clinicaltime));
                                }
                            }

                            if(validates(validator, sickblhdrRequest)!=null){
                                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, sickblhdrRequest));
                            }

                            //2自动
                        }else if("2".equals(jsonObject.getString("flag"))){
                            //患者性别
                            if(jsonObj.get("sex")!=null){
                                String sex= jsonObj.get("sex").toString();
                                if(!"".equals(sex)&&sex!=null){
                                    if("男".equals(sex)){
                                        sex="1";
                                    }else if("女".equals(sex)){
                                        sex="2";
                                    }else {
                                        sickblhdrRequest.setSex(sex);
                                    }
                                }
                            }
                            //心率: 数字
                            if(jsonObj.get("xl") != null){
                                String xl = jsonObj.get("xl").toString();
                                if(!"".equals(xl) && xl != null){
                                    if(isNumeric(xl)){
                                        sickblhdrRequest.setXl(xl);
                                    }
                                }
                            }
                            //血压上: 数字
                            if(jsonObj.get("xy1") != null){
                                String xy1 = jsonObj.get("xy1").toString();
                                if(!"".equals(xy1) && xy1 != null){
                                    if(isNumeric(xy1)){
                                        sickblhdrRequest.setXy1(xy1);
                                    }
                                }
                            }
                            //血压下: 数字
                            if(jsonObj.get("xy2") != null){
                                String xy2 = jsonObj.get("xy2").toString();
                                if(!"".equals(xy2) && xy2 != null){
                                    if(isNumeric(xy2)){
                                        sickblhdrRequest.setXy2(xy2);
                                    }
                                }
                            }
                            //体重: 数字
                            if(jsonObj.get("weight") != null){
                                String weight = jsonObj.get("weight").toString();
                                if(!"".equals(weight) && weight != null){
                                    if(isNumeric(weight)){
                                        sickblhdrRequest.setWeight(weight);
                                    }
                                }
                            }
                            //血氧: 数字
                            if(jsonObj.get("glucose") != null){
                                String glucose = jsonObj.get("glucose").toString();
                                if(!"".equals(glucose) && glucose != null){
                                    if(isNumeric(glucose)){
                                        sickblhdrRequest.setGlucose(glucose);
                                    }

                                }
                            }

                            //预约时间
                            if(jsonObj.get("clinicaltime") != null){
                                String clinicaltime = jsonObj.get("clinicaltime").toString();
                                if(!"".equals(clinicaltime) && clinicaltime != null){
                                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                                    sickblhdrRequest.setClinicaltime(date.format(clinicaltime));
                                }
                            }
                            sickblhdrRequest.setState("0"); //设置状态为0
                        }else {
                            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入标志位:是手动还是自动");
                        }


                        docguid = jsonObj.get("docguid").toString();
                        sickguid = jsonObj.get("sickguid").toString();
                        //诊断
                        JSONArray diagnosisarray = (JSONArray)jsonObject.fromObject(map).get("diagnosis");
                        if(diagnosisarray.size()>0){
                            for (int i = 0; i < diagnosisarray.size(); i++) {
                                diagnosisRecords = new DiagnosisRecords();
                                diagnosisRecords.setSid(sickUUID);
                                diagnosisRecords.setId(UUIDTool.getUUID());
                                JSONObject jso = JSONObject.fromObject(diagnosisarray.get(i));
                                diagnosisRecords.setZid(jso.getString("zhand"));
                                diagnosisRecords.setZname(jso.getString("zdname"));
                                diagnosisRecordsList.add(diagnosisRecords);
                                if(i==0){
                                    stringBufferID.append(diagnosisRecords.getZid());
                                    stringBufferName.append(diagnosisRecords.getZname());
                                }else {
                                    stringBufferID.append(","+diagnosisRecords.getZid());
                                    stringBufferName.append(","+diagnosisRecords.getZname());
                                }

                            }
                            sickblhdrRequest.setZhand(stringBufferID.toString());
                            sickblhdrRequest.setZdnam(stringBufferName.toString());
                        }


                        sickblhdrRequest.setGuid(sickUUID);
                        //设置部门
                        sickblhdrRequest.setAcc("CHIS");
                        sickblhdrRequest.setOrg("CHIS");
                        //新增病历
                        BeanUtils.copyProperties(sickblhdrRequest,sickblhdr);
                        sickblhdrService.insertSelective(sickblhdr);

                        //新增诊断
                        diagnosisRecordsService.inserList(diagnosisRecordsList);

                        //检查项目
                        JSONArray checkarray = (JSONArray)jsonObject.fromObject(map).get("check");
                        if(checkarray.size()>0) {
                            for (int i = 0; i < checkarray.size(); i++) {
                                jsonObj = JSONObject.fromObject(checkarray.get(i));
                                inspectionItems = (InspectionItems) JSONObject.toBean(jsonObj, InspectionItems.class);
                                inspectionItems.setSickblhdrid(sickUUID); //设置关联关系
                                inspectionItems.setId(UUIDTool.getUUID());
                                //检查项目新增
                                inspectionItemsService.insertSelective(inspectionItems);  //TODO

                            }
                        }
                        //随访计划
                        JSONArray planarray = (JSONArray)jsonObject.fromObject(map).get("plan");
                        if(planarray.size()>0) {
                            for (int i = 0; i < planarray.size(); i++) {
                                jsonObj = JSONObject.fromObject(planarray.get(i));
                                chisFollowupPan = (ChisFollowupPan) JSONObject.toBean(jsonObj, ChisFollowupPan.class);
                                chisFollowupPan.setSicguid(sickUUID);//关联病历
                                chisFollowupPan.setDocguid(docguid);
                                chisFollowupPan.setUsrguid(sickguid);
                                //随访时间
                                if(jsonObj.get("followdatetime") != null){
                                    String followdatetime = jsonObj.get("followdatetime").toString();
                                    if(!"".equals(followdatetime) && followdatetime != null){
                                        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                        Date time = null;
                                        try {
                                            time = date.parse(followdatetime);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        chisFollowupPan.setFollowdatetime(time);
                                    }
                                }

                                //新增随访计划
                                chisFollowupPan.setGuid(UUIDTool.getUUID());
                                chisFollowupPanService.insertFollowupPlan(chisFollowupPan);

                            }
                        }
                        //用药方案
                        //将json格式的字符串转换为json数组对象
                        JSONArray dtsarray = (JSONArray)jsonObject.fromObject(map).get("dts");
                        if(dtsarray.size()>0){
                            for (int i = 0; i <dtsarray.size() ; i++) {
                                //取得json数组中的第一个对象
                                jsonObj = JSONObject.fromObject(dtsarray.get(i));
                                sickbldtlRequest = (SickbldtlRequest) JSONObject.toBean(jsonObj, SickbldtlRequest.class);

                                //1手动 做校验
                                if("1".equals(jsonObject.getString("flag"))){
                                    if(validates(validator, sickbldtlRequest)!=null){
                                        return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, sickbldtlRequest));
                                    }
                                }
                                sickbldtlRequest.setFormguid(sickUUID);
                                sickbldtlRequest.setGuid(UUIDTool.getUUID());
                                BeanUtils.copyProperties(sickbldtlRequest,dTsickbldtl);
                                sickblhdrService.insertDTsickbldtl(dTsickbldtl);

                            }
                        }
                    }
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "请代入病历相关数据!");
                }

            }
            simpleResult.putData("guid",sickUUID);
        }catch (BussinessException e){
            logger.error(e.getMessage());
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        return  simpleResult;
    }


    /**
     * 判断是否是整数
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj)
    {
        if (obj == null)
        {
            return true;
        }
        if ((obj instanceof List))
        {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String))
        {
            return ((String) obj).trim().equals("");
        }
        return false;
    }


}
