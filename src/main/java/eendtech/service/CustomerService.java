package eendtech.service;

import eendtech.po.Customer;
import eendtech.vo.BasePaging;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 19:20
 */
public interface CustomerService {

    //查询全部客户列表
    BasePaging<Customer> findCustomerListAll();
    BasePaging<Customer> findCustomerList(Integer page);
    BasePaging<Customer> findCustomerList(Integer page,Integer totalSize);
    BasePaging<Customer> findCustomerList(Integer page,Customer customer);
    /**
     * 查询客户列表
     * @param page 设置查询第几页
     * @param totalSize
     * @param customer
     * @return 返回基本的分页VO层
     */
    BasePaging<Customer> findCustomerList(Integer page,Integer totalSize,Customer customer);

    //添加客户

    /**
     * 添加客户
     * @param customer POJO层
     * @return 返回影响的行数rows
     */
    Integer createCustomer(Customer customer);

    /**
     * 修改客户
     * @param customer POJO层
     * @return 返回受影响的行数rows
     */
    Integer updateCustomer(Customer customer);

    /**
     * 删除客户
     * @param customer POJO层
     * @return 返回受影响的行数rows
     */
    Integer deleteCustomer(Customer customer);
}
