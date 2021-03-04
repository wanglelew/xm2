package com.wang.articleservice.controller.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wang.articleservice.dto.ResultVo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Exception implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws java.lang.Exception {
        String msg = null;
        if (e instanceof FlowException) { //限流异常
            msg = "接口已被限流";
        } else if (e instanceof DegradeException) { //熔断异常
            msg = "接口已被熔断,请稍后再试";
        } else if (e instanceof ParamFlowException) { //热点参数限流
            msg = "热点参数限流";
        } else if (e instanceof SystemBlockException) { //系统规则异常
            msg = "系统规则(负载.../不满足要求)";
        } else if (e instanceof AuthorityException) { //授权规则异常
            msg = "接口授权不通过";
        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //ObjectMapper是内置Jackson的序列化工具类,这用于将对象转为json为字符串
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(httpServletResponse.getWriter(), new ResultVo(e.getClass().getSimpleName(), msg));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);


    }
}
