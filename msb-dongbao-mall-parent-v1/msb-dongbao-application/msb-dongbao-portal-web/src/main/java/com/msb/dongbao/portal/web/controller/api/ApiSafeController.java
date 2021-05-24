package com.msb.dongbao.portal.web.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
	 * 测试 参数防篡改
	 * @return
	 */
	@RequestMapping("/get-test")
	public String getTest(String appId, String name ,String sign){

		// 为了排序
		HashMap<String,Object> map= new HashMap<>();
		map.put("appId",appId);
		map.put("name",name);

		String s = CheckUtils.generatorSign(map);
		if (s.equals(sign)){
			return "校验通过";
		}else {
			return "校验 不通过";
		}


	}
}
