package com.sast.astbenchmark.case_language_maturity.completeness.single_app_tracing.datatype.map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象中的简单类型对象，Map作为污点
 * Level 2
 * Date 2024-05-09
 */
// evaluation information start
// real case = false
// evaluation item = 完整度->基础跟踪能力->污点对象完整度->java原生对象->Map
// bind_url = completeness/base/object/javaNative/Base_Map_004_F
// evaluation information end

@RestController()
@RequestMapping("completeness/base/object/javaNative")
public class Base_Map_004_F {
    @PostMapping("Base_Map_004_F")
    public Map<String, Object> aTaintCase0140(@RequestBody Map<String, String> cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "_");
        try {
            Runtime.getRuntime().exec(String.valueOf(map));
            modelMap.put("status", "success");
        } catch (IOException e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
