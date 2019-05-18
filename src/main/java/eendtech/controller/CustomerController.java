package eendtech.controller;

import eendtech.po.Customer;
import eendtech.service.CustomerService;
import eendtech.utils.*;
import eendtech.vo.BasePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ author Seale
 * @ Description:用户控制器
 * @ QQ:1801157108
 * @ Date 2019/5/13 15:55
 */

@Controller
@Transactional
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     * 显示客户的信息/查询客户的信息并进行分页
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/showCustomerInfo")
    @ResponseBody
    public ResultKit<BasePaging> showCustomer(Integer page, HttpServletRequest request){
        //判断page是否为空,否则默认为1
        if (page == null){
            page = 1;
        }
        BasePaging<Customer> customerPage = customerService.findCustomerList(page);
        customerPage = PagingUtils.dealsLinks(customerPage,request);
        System.out.println(customerPage);
        ResultKit<BasePaging> resultKit = new ResultKit<>();
        resultKit
                .setCode(ResultCode.SUCCESS.code())
                .setMessage(ResultMsg.SUCCESS_RESULT)
                .setData(customerPage);
        return resultKit;
    }

    /**
     * 修改客户信息
     * @param id 传入id包装成customer
     * @return 标准的返回对象 其中Data返回受到影响的行数
     */
    @PostMapping("/updateCustomer/{id}")
    @ResponseBody
    public ResultKit<Integer> updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        //初始化返回
        ResultKit<Integer> result = new ResultKit<>();
        //如果为空
        if (id == null){
            return result
                    .setCode(ResultCode.FAIL.code())
                    .setMessage("失败,没有查询到该客户")
                    .setData(0);
        }
        customer.setCust_id(id);
        int rows = customerService.updateCustomer(customer);
        if (rows>0){
            //成功
            return result
                    .setCode(ResultCode.SUCCESS.code())
                    .setMessage("修改成功")
                    .setData(rows);
        }else{
            return result
                    .setCode(ResultCode.FAIL.code())
                    .setMessage("未知错误")
                    .setData(rows);
        }

    }

    /**
     * 删除客户信息
     * @param id 传入需要删除的客户ID
     * @return 标准的返回对象 其中Data返回受到影响的行数
     */
    @PostMapping("/deleteCustomer/{id}")
    @ResponseBody
    public ResultKit<Integer> deleteCustomer(@PathVariable Integer id){
        //初始化返回
        ResultKit<Integer> result = new ResultKit<>();
        if (id == null){
            return result
                    .setCode(ResultCode.FAIL.code())
                    .setMessage("失败,没有查询到该客户")
                    .setData(0);
        }
        Customer customer = new Customer();
        customer.setCust_id(id);
        int rows = customerService.deleteCustomer(customer);
        if (rows > 0){
            //成功
            return result
                    .setCode(ResultCode.SUCCESS.code())
                    .setMessage("删除成功")
                    .setData(rows);
        }else{
            //失败
            return result
                    .setCode(ResultCode.FAIL.code())
                    .setMessage("未知错误")
                    .setData(rows);
        }
    }
    @PostMapping("/createCustomer")
    @ResponseBody
    public ResultKit<Integer> createCustomer(@RequestBody Customer customer){
        //初始化返回
        ResultKit<Integer> result = new ResultKit<>();
        //获取当前时间并包装进Customer中
        String date = EUtils.getCurrentDate(new Date());
        customer.setCust_createtime(date);
        //进行创建
        int rows = customerService.createCustomer(customer);
        if (rows > 0){
            //成功
            return result
                    .setCode(ResultCode.SUCCESS.code())
                    .setMessage("添加成功")
                    .setData(rows);
        }else{
            //失败
            return result
                    .setCode(ResultCode.FAIL.code())
                    .setMessage("未知错误")
                    .setData(rows);
        }
    }
    @PostMapping("/selectCustomer")
    @ResponseBody
    public ResultKit<BasePaging> selectCustomer(Integer page,@RequestBody Customer customer ,HttpServletRequest request){
        //判断page是否为空,否则默认为1
        if (page == null){
            page = 1;
        }
        BasePaging<Customer> customerPage = customerService.findCustomerList(page,customer);
        customerPage = PagingUtils.dealsLinks(customerPage,request);
        System.out.println(customerPage);
        ResultKit<BasePaging> resultKit = new ResultKit<>();
        resultKit
                .setCode(ResultCode.SUCCESS.code())
                .setMessage(ResultMsg.SUCCESS_RESULT)
                .setData(customerPage);
        return resultKit;
    }
    @GetMapping("/selectCustomer/{id}")
    @ResponseBody
    public ResultKit<BasePaging> selectCustomerById(@PathVariable Integer id,HttpServletRequest request){
        int page = 1;
        Customer customer = new Customer();
        customer.setCust_id(id);
        BasePaging<Customer> customerPage = customerService.findCustomerList(page,customer);
        customerPage = PagingUtils.dealsLinks(customerPage,request);
        System.out.println(customerPage);
        ResultKit<BasePaging> resultKit = new ResultKit<>();
        resultKit
                .setCode(ResultCode.SUCCESS.code())
                .setMessage(ResultMsg.SUCCESS_RESULT)
                .setData(customerPage);
        return resultKit;
    }
}
