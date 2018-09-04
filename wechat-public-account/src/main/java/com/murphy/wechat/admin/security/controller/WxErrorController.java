package com.murphy.wechat.admin.security.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WxErrorController implements ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(WxErrorController.class);
	private final static String ERROR_PATH = "/error";
	private static WxErrorController appErrorController;

	@Autowired
	private ErrorAttributes errorAttributes;

	/**
	 * Controller for the Error Controller
	 *
	 * @param errorAttributes
	 */

	public WxErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	public WxErrorController() {
		if (appErrorController == null) {
			appErrorController = new WxErrorController(this.errorAttributes);
		}
	}

	/**
	 * Supports the HTML Error View
	 *
	 * @param request
	 */
	@RequestMapping(value = ERROR_PATH, produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request) {
		return new ModelAndView("error", this.getErrorAttributes(request, false));
	}

	/**
	 * Supports other formats like JSON, XML
	 *
	 * @param request
	 */
	@RequestMapping(value = ERROR_PATH)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = this.getErrorAttributes(request, this.getTraceParameter(request));
		HttpStatus status = this.getStatus(request);
		return new ResponseEntity<>(body, status);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}

		return !"false".equals(parameter.toLowerCase());
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		Map<String, Object> map = this.errorAttributes.getErrorAttributes(servletWebRequest, true);
		logger.error("map is [{}]", map);
		String url = request.getRequestURL().toString();
		map.put("URL", url);
		logger.error("[error info]: status-{}, request url-{}", map.get("status"), url);
		return map;
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode != null) {
			return HttpStatus.valueOf(statusCode);
		}

		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}