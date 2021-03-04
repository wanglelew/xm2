package com.wang.articleservice.controller;

import com.alibaba.csp.sentinel.slots.block.Rule;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.wang.articleservice.dto.ResultVo;
import com.wang.articleservice.entity.Article;
import com.wang.articleservice.feignclient.VideoFeignClient;
import com.wang.articleservice.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王乐乐 WLL
 * @Classname ArticleController
 * @Describe:
 * @date 2021/2/26 15:05
 */
@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private VideoFeignClient videoFeignClient;
    @GetMapping("/getArticle")
    public ResultVo list(){
        return new ResultVo("0","成功",articleService.list()) ;
    }
    public static void main(String [] args){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new LinkedList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("限购听");
        }
    }

    @GetMapping("/rule_setting")
    //代码配置Sentinel限流规则
    public String initFlowRule(){
        //规则集合
        List<FlowRule> list=new ArrayList<>();
        //创建新的规则对象  getArticle是资源名
        FlowRule rule=new FlowRule("/getArticle");
        //限流规则 策略 -->直接策略
        rule.setStrategy(RuleConstant.STRATEGY_DIRECT);
        //限流模式  -->QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //限制QPS为100
        rule.setCount(100);
        //限流效果设置为预热模式
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_WARM_UP);
        //预热时间限制20s
        rule.setWarmUpPeriodSec(20);
        //来源设置为所有 默认所有  (也可限制另外服务调用)
        rule.setLimitApp("default");
        //添加到规则集合里
        list.add(rule);
        //FlowRuleManager是Sentinel规则管理器 设置加载这条规则
        FlowRuleManager.loadRules(list);

        return "success";
    }
}
