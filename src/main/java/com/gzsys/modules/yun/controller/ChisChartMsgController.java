/**
 * projectName: gz-sys
 * fileName: ChisChartMsgController.java
 * packageName: com.gzsys.yun.controller
 * date: 2018-01-31 22:10
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.controller;

import com.gzsys.common.base.controller.BaseController;
import com.gzsys.modules.yun.entity.ChisChartMsg;
import com.gzsys.modules.yun.entity.HealthDictEntery;
import com.gzsys.modules.yun.service.ChisChartMsgService;
import com.gzsys.modules.yun.service.HealthDictEnteryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ChisChartMsgController
 * @packageName: com.gzsys.yun.controller
 * @description:
 * @data: 2018-01-31 22:10
 **/

@RestController
@RequestMapping(value = "/api/v1/chartMsg")
@Api("消息操作接口")
public class ChisChartMsgController extends BaseController {

    @Autowired
    private ChisChartMsgService chisChartMsgService;

    @Autowired
    private HealthDictEnteryService healthDictEnteryService;


    @RequestMapping("/getCharMsg")
    @ApiOperation("获取消息")
    public Object getCharMsg(@ApiParam(name="id",value="消息id",required=true) String id, @ApiParam(name="usrname",value="用户名") String username){
        List<HealthDictEntery> chisChartMsgList = healthDictEnteryService.selectList(null);
        HealthDictEntery healthDictEntery = healthDictEnteryService.selectById("123456");
        ChisChartMsg chisChartMsg =  chisChartMsgService.selectById("5DB1754B03A6E533E050007F010069CE");
        return  chisChartMsg;
    }

}
