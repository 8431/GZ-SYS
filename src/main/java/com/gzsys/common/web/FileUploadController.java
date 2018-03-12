/**
 * projectName: GZ
 * fileName: FileUploadController.java
 * packageName: com.gzsys.common.web
 * date: 2018-03-01 15:07
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.web;

import com.gzsys.common.base.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: V1.0
 * @author: fendo
 * @className: FileUploadController
 * @packageName: com.gzsys.common.web
 * @description: 文件上传
 * @data: 2018-03-01 15:07
 **/
@RestController
@RequestMapping(value = "/api/v1/fileUpload")
@Api(value = "文件上传操作接口",description = "fendo")
public class FileUploadController extends BaseController {


}
