/**
 * projectName: GZ
 * fileName: FileDownloadController.java
 * packageName: com.gzsys.common.web
 * date: 2018-03-01 15:08
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.web;

import com.gzsys.common.base.controller.BaseController;
import com.gzsys.common.util.CustomPage;
import com.gzsys.common.util.JSONResult;
import com.gzsys.common.util.SimpleResult;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.service.UserBaseService;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: FileDownloadController
 * @packageName: com.gzsys.common.web
 * @description: 获取文件
 * @data: 2018-03-01 15:08
 **/
@RestController
@RequestMapping(value = "/api/v1/fileDownload")
@Api(value = "文件下载操作接口",description = "fendo")
public class FileDownloadController extends BaseController {

    @Autowired
    private UserBaseService userBaseService;

    /**
     *  根据用户ID获取用户头像
     * @param userid
     * @param request
     * @param response
     */
    @GetMapping(value = "/downloadImage")
    @ResponseBody
    @ApiOperation("用户头像获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户ID", required = false, dataType = "String", paramType = "query"),
    })
    @ApiResponses(value = {@ApiResponse(code = 405, message = "invalid input")})
    public SimpleResult downloadImage(String userid, HttpServletRequest request, HttpServletResponse response){
        SimpleResult simpleResult;
        UserBase userBase = null;
        if(StringUtils.isNotBlank(userid)){
            try {
                userBase = userBaseService.selectById(userid);
            } catch (Exception e) {
                logger.error("{}",e);
                e.printStackTrace();
            }
        }
        simpleResult = SimpleResult.success();
        simpleResult.putData("imagePath", userBase.getSrcface() + "");
        return simpleResult;
    }

}
