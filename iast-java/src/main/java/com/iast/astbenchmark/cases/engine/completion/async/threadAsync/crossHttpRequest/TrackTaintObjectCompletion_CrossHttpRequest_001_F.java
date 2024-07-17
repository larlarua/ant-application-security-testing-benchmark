package com.iast.astbenchmark.cases.engine.completion.async.threadAsync.crossHttpRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iast.astbenchmark.analyser.Category;
import com.iast.astbenchmark.analyser.cache.IastTestCaseDescriptor;
import com.iast.astbenchmark.analyser.cache.IastTestCasePayloadProvider;
import com.iast.astbenchmark.common.CommonConsts;

import cn.hutool.http.HttpRequest;

/**
* Introduction X
* Level X  
* Date 2024-07-16
* @author CC11001100 
*/
@RestController

// assession information start
// real vulnerability = false
// assession project = IAST引擎能力评估体系(JAVA) -> 完整度 -> 异步跟踪能力 -> 跨进程跟踪能力 -> 调用方式 -> http -> 跨多层进程调用
// compose = 
// bind_url = /case00124
// assession information end
public class TrackTaintObjectCompletion_CrossHttpRequest_001_F
    implements IastTestCaseDescriptor, IastTestCasePayloadProvider {

    /**
     * aTaintCase00124 跨进程跟踪能力->调用方式->http->跨多个应用http触发sink
     */
    @PostMapping(value = "case00124")
    public Map<String, Object> aTaintCase00124(@RequestParam String cmd, @RequestParam String auto_check_start_time) {
        Map<String, Object> modelMap = new HashMap<>();
        // TODO 2024-06-18 11:44:25 这里的地址和端口不应该写死
        HttpRequest.post(
            "http://localhost:39100/ataint/case00124/2?cmd=" + cmd + "&auto_check_start_time=" + auto_check_start_time)
            .execute();
        modelMap.put("status", CommonConsts.SUCCESS_STR);
        return modelMap;
    }

    @Override
    public Boolean hasVul() {
        return false;
    }

    @Override
    public String caseNo() {
        return "aTaintCase00124";
    }

    @Override
    public String[] category() {
        return new String[] {
            //
            Category.LEVEL1_IAST_JAVA_ENGINE,
            //
            Category.LEVEL2_完整度,
            //
            Category.LEVEL3_异步跟踪能力,
            //
            "跨进程跟踪能力",
            //
            "调用方式",
            //
            "http",
            //
            "跨多层进程调用",
            //
        };
    }

}
