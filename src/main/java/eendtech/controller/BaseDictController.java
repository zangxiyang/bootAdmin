package eendtech.controller;

import eendtech.po.BaseDict;
import eendtech.service.BaseDictService;
import eendtech.utils.ResultCode;
import eendtech.utils.ResultKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/13 20:03
 */
@Controller
@RequestMapping("/api/dict")
public class BaseDictController {
    @Autowired
    BaseDictService baseDictService;

    /**
     * 查询数据字典 -> 客户来源
     * @return 一个标准的返回包装类
     */
    @RequestMapping("/dictSource")
    @ResponseBody
    public ResultKit<List> findCustomerSource(){
        //初始化包装类
        ResultKit<List> resultKit = new ResultKit<>();
        List<BaseDict> dictList = baseDictService.findBaseDictByTypeCode("002");
        //查询为空
        if (dictList.isEmpty()){
           return resultKit
                    .setData(dictList)
                    .setMessage("查询数据为空")
                    .setCode(ResultCode.NOT_FOUND.code());
        }
        return resultKit
                .setCode(ResultCode.SUCCESS.code())
                .setMessage("成功")
                .setData(dictList);
    }

    /**
     * 客户所属行业
     * @return 所属行业
     */
    @RequestMapping("/dictIndustry")
    @ResponseBody
    public ResultKit<List> findCustomerIndustry(){
        //初始化包装类
        ResultKit<List> resultKit = new ResultKit<>();
        List<BaseDict> dictList = baseDictService.findBaseDictByTypeCode("001");
        //查询为空
        if (dictList.isEmpty()){
            return resultKit
                    .setData(dictList)
                    .setMessage("查询数据为空")
                    .setCode(ResultCode.NOT_FOUND.code());
        }
        return resultKit
                .setCode(ResultCode.SUCCESS.code())
                .setMessage("成功")
                .setData(dictList);
    }

    /**
     * 客户级别
     * @return 客户级别
     */
    @RequestMapping("/dictLevel")
    @ResponseBody
    public ResultKit<List> findCustomerLevel(){
        //初始化包装类
        ResultKit<List> resultKit = new ResultKit<>();
        List<BaseDict> dictList = baseDictService.findBaseDictByTypeCode("006");
        //查询为空
        if (dictList.isEmpty()){
            return resultKit
                    .setData(dictList)
                    .setMessage("查询数据为空")
                    .setCode(ResultCode.NOT_FOUND.code());
        }
        return resultKit
                .setCode(ResultCode.SUCCESS.code())
                .setMessage("成功")
                .setData(dictList);
    }
}
