/**
 * projectName: gz-sys
 * fileName: GlobalController.java
 * packageName: com.gzsys.modules.yun.controller
 * date: 2018-02-02 13:27
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version: V1.0
 * @author: fendo
 * @className: GlobalController
 * @packageName: com.gzsys.modules.yun.controller
 * @description: 全局Controller
 * @data: 2018-02-02 13:27
 **/
@Controller
public class GlobalController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
