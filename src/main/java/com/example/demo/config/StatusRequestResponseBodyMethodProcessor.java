package com.example.demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.Map;

public class StatusRequestResponseBodyMethodProcessor implements HandlerMethodReturnValueHandler {

    private HandlerMethodReturnValueHandler handlerMethodReturnValueHandler;

    public StatusRequestResponseBodyMethodProcessor(HandlerMethodReturnValueHandler handlerMethodReturnValueHandler){
        this.handlerMethodReturnValueHandler = handlerMethodReturnValueHandler;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return handlerMethodReturnValueHandler.supportsReturnType(methodParameter);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        System.out.println(o instanceof String);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("statusCode", 200);
        resultMap.put("errorMessage", "测试状态");
        resultMap.put("data", o);

        handlerMethodReturnValueHandler.handleReturnValue(resultMap, methodParameter, modelAndViewContainer, nativeWebRequest);
    }
}
