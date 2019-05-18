package eendtech.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import eendtech.dao.CustomerDao;
import eendtech.po.Customer;
import eendtech.service.CustomerService;
import eendtech.utils.PagingUtils;
import eendtech.vo.BasePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 19:52
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    //设置默认参数
    //  默认每页显示10条
    private final int TOTAL_SIZE = 10;

    @Autowired
    private CustomerDao customerDao ;

    @Override
    public BasePaging<Customer> findCustomerListAll() {
        return null;
    }

    @Override
    public BasePaging<Customer> findCustomerList(Integer page) {
        return findCustomerList(page,TOTAL_SIZE,null);
    }

    @Override
    public BasePaging<Customer> findCustomerList(Integer page, Integer totalSize) {
        return findCustomerList(page,totalSize,null);
    }

    @Override
    public BasePaging<Customer> findCustomerList(Integer page, Customer customer) {
        return findCustomerList(page,TOTAL_SIZE,customer);
    }

    @Override
    public BasePaging<Customer> findCustomerList(Integer page, Integer totalSize, Customer customer) {
        //初始化VO层和PO层
        BasePaging<Customer> customerBasePaging = new BasePaging<>();
        //初始化参数
        //总条数
        int total;
        //每页显示的条数
        int pageTotalSize = totalSize;
        //分页总数
        int totalPage;
        //当前页数
        int currentPage = page;
        //开启分页
        PageHelper.startPage(page,totalSize);
        //固定条件查询
        List<Customer> customers = customerDao.selectCustomerList(customer);
        PageInfo<Customer> customerPageInfo = new PageInfo<>(customers);
        //设置总条数
        total = (int) customerPageInfo.getTotal();
        //计算分页的总数
        totalPage = PagingUtils.getTotalPage(total,pageTotalSize);
        customerBasePaging
                .setContent(customers)
                .setCurrentPage(currentPage)
                .setPageTotalSize(pageTotalSize)
                .setTotalPage(totalPage)
                .setTotal(total);
        return customerBasePaging;
    }

    /**
     * 创建客户
     * @param customer POJO层
     * @return rows 受到影响的行数
     */
    @Override
    public Integer createCustomer(Customer customer) {
        //判断客户名是否为空,为空则结束
        String custName = customer.getCust_name();
        if (custName.isEmpty()){
            return 0;
        }
        return customerDao.insertCustomer(customer);
    }

    /**
     * 修改客户
     * @param customer POJO层
     * @return 受到影响的行数rows
     */
    @Override
    public Integer updateCustomer(Customer customer) {
        //如果没有id传入那么则修改失败
        if (customer.getCust_id()==null ){
            return 0;
        }
        return customerDao.updateCustomer(customer);
    }

    /**
     * 删除客户
     * @param customer POJO层
     * @return 受到影响的行数rows
     */
    @Override
    public Integer deleteCustomer(Customer customer) {
        if (customer.getCust_id() == null){
            return 0;
        }
        return customerDao.deleteCustomer(customer);
    }
}
