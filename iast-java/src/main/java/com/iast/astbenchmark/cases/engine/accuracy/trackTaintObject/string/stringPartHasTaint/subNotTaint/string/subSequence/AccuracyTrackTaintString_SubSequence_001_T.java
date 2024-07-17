package com.iast.astbenchmark.cases.engine.accuracy.trackTaintObject.string.stringPartHasTaint.subNotTaint.string.subSequence;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iast.astbenchmark.analyser.Category;
import com.iast.astbenchmark.analyser.cache.IastTestCaseDescriptor;
import com.iast.astbenchmark.analyser.cache.IastTestCasePayloadProvider;
import com.iast.astbenchmark.analyser.cache.RequestPayloadConstant;
import com.iast.astbenchmark.common.CommonConsts;

/**
* Introduction X
* Level X  
* Date 2024-07-16
* @author CC11001100 
*/
@RestController

// assession information start
// real vulnerability = true
// assession project = IAST引擎能力评估体系(JAVA) -> 准确度 -> 污点对象跟踪粒度 -> 字符串级别 -> 字符串部分存在污点 -> 截取非污点部分 -> String操作 -> subSequence
// compose = 
// bind_url = /case00943
// assession information end
public class AccuracyTrackTaintString_SubSequence_001_T implements IastTestCaseDescriptor, IastTestCasePayloadProvider {

    @PostMapping(value = "case00943")
    public Map<String, Object> aTaintCase00943(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            String hardcode = "abc";
            String cmdfull = hardcode + cmd;
            CharSequence data = cmdfull.subSequence(hardcode.length(), cmdfull.length());
            Runtime.getRuntime().exec(data.toString());
            modelMap.put("status", CommonConsts.SUCCESS_STR);
        } catch (IOException e) {
            modelMap.put("status", CommonConsts.ERROR_STR);
        }
        return modelMap;
    }

    @Override
    public String[] category() {
        return new String[] {
            //
            Category.LEVEL1_IAST_JAVA_ENGINE,
            //
            Category.LEVEL2_准确度,
            //
            Category.LEVEL3_污点对象跟踪粒度,
            //
            Category.LEVEL4_字符串级别,
            //
            "字符串部分存在污点",
            //
            "截取非污点部分",
            //
            "String操作",
            //
            "subSequence",
            //
        };
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String caseNo() {
        return "aTaintCase00943";
    }

    @Override
    public Map<String, String> params() {
        return RequestPayloadConstant.DEFAULT_COMMAND_REQUEST_PARAMS;
    }

}
