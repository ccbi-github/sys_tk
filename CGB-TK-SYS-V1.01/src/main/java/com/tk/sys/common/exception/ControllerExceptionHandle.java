package com.tk.sys.common.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tk.common.vo.JsonResult;

/**
 * 全局异常处理
 * 异常处理流程:控制层出现异常
 * 1)首先检测本类是否定义了异常处理方法
 * 2)本类没有异常处理方法，检测是否有全局异常处理方法
 * @author tarena
 *
 */
@ControllerAdvice
public class ControllerExceptionHandle {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleException(Exception e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
