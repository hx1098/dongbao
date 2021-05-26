package com.msb.dongbao.portal.web.controller.api;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.msb.dongbao.portal.web.controller.api.posttest.SignDTO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2021/5/24
 */
@RestController
@RequestMapping("/api-safe")
public class ApiSafeController {

	@GetMapping("/hello")
	public String hello(){
		return  "hello api safe";
	}

	/**
	 * 测试 get 方法 参数防篡改
	 * @return
	 */
	@RequestMapping("/get-test")
	public String getTest(String appId, String name , String sign , long timestamp , HttpServletRequest httpServletRequest){

		// 为了排序
		HashMap<String,Object> map= new HashMap<>();

		// 参数写死
//		map.put("appId",appId);
//		map.put("name",name);
//		map.put("timestamp",timestamp);

		// 获取get中的参数
		Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
		while (parameterNames.hasMoreElements()){
			//获取 name
			String parametename = parameterNames.nextElement();

			// 获取值
			String parameterValue = httpServletRequest.getParameter(parametename);
			map.put(parametename,parameterValue);
		}

		// 让接口在有效期内访问
//		long time = System.currentTimeMillis() - timestamp;
//		if (time > 1000 * 30){
//			return "接口过期了";
//		}

		String s = CheckUtils.generatorSign(map);
		if (s.equals(sign)){
			return "校验通过";
		}else {
			return "校验 不通过";
		}


	}


	@PostMapping("/post-test")
	public String postTest(@RequestBody SignDTO signDTO){
		JSONObject obj = JSONUtil.parseObj(signDTO);

		// 参数转map
		Map<String, Object> stringObjectMap = Convert.toMap(String.class, Object.class, obj);
		// 排序
		Map<String, Object> stringObjectMap1 = CheckUtils.sortMapByKey(stringObjectMap);
		System.out.println(stringObjectMap1);

		// map生成签名
		// 客户端传来的
		Object signClient = stringObjectMap1.get("sign");
		String signServer = CheckUtils.generatorSign(stringObjectMap1);

		// 判断签名
		if (signServer.equals(signClient)){
			return "校验通过";
		}else {
			return "校验 不通过";
		}

	}
}