package eendtech.dao;

import eendtech.po.Customer;

import java.util.List;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 12:11
 */
public interface CustomerDao {
    //查询客户列表
    List<Customer> selectCustomerList(Customer customer);
    //添加客户
    Integer insertCustomer(Customer customer);
    //删除客户
    Integer deleteCustomer(Customer customer);
    //修改客户
    Integer updateCustomer(Customer customer);
}
