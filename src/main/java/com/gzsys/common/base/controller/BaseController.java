/**
 * projectName: GZYUN
 * fileName: BaseController.java
 * packageName: com.gzsys.common.base
 * date: 2018-01-31 22:13
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.base.controller;

import com.gzsys.common.base.warpper.BaseControllerWarpper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @version: V1.0
 * @author: fendo
 * @className: BaseController
 * @packageName: com.gzsys.common.base
 * @description: Controller基类
 * @data: 2018-01-31 22:13
 **/
public abstract class BaseController {

    @Autowired
    public Validator validator;

    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 包装一个list，让list增加额外属性
     */
    protected Object warpObject(BaseControllerWarpper warpper) {
        return warpper.warp();
    }

    /**
     * 服务端参数有效性验证
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；严重失败：将错误信息添加到 flash message 中
     */
    @SuppressWarnings("rawtypes")
    public static  String validates(Validator validator, Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuffer sb=new StringBuffer();
            for (ConstraintViolation constraintViolation : constraintViolations) {
                sb.append(constraintViolation.getMessage());
            }
            return sb.toString();
        }
        return null;
    }


}
