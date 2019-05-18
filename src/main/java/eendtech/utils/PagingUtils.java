package eendtech.utils;

import eendtech.po.Links;
import eendtech.vo.BasePaging;

import javax.servlet.http.HttpServletRequest;

/**
 * @ author Seale
 * @ Description:分页工具类
 * @ QQ:1801157108
 * @ Date 2019/5/13 14:12
 */
public class PagingUtils {

    /**
     *
     * 处理链接PO层,包装进BasePaging对象中
     * @param basePaging 传入的BasePaging对象
     * @param request 传入请求request对象
     * @return 返回包装后的BasePaging
     */
    public static<T> BasePaging<T> dealsLinks(BasePaging<T> basePaging, HttpServletRequest request){
        //第一页链接
        String firstPage ;
        //下一页链接
        String nextPage ;
        //上一页链接
        String prePage ;
        //最后一页链接
        String lastPage ;
        //后缀
        final String SUFFIX_URL = "?page=";
        String baseURL = request.getRequestURL().toString();
        //设置第一页链接
        firstPage = baseURL+SUFFIX_URL+1;
        //设置下一页链接
        nextPage = baseURL+SUFFIX_URL+(basePaging.getCurrentPage()+1);
        //设置上一页链接
        if (basePaging.getCurrentPage() == 1){
            prePage = "none";
        }else {
            prePage = baseURL + SUFFIX_URL + (basePaging.getCurrentPage() - 1);
        }
        //设置最后一页链接
        lastPage = baseURL+SUFFIX_URL+(basePaging.getTotalPage());
        //生成Links对象
        Links links = new Links();
        links.setLastPage(lastPage)
             .setPrePage(prePage)
             .setNextPage(nextPage)
             .setFirstPage(firstPage);
        //装载BasePaging对象
        basePaging.setLinks(links);
        return basePaging;
    }

    /**
     * 计算分页总数
     * @param total 总条数
     * @param pageTotalSize 每页显示条数
     * @return Integer-> 分页总数
     */
    public static Integer getTotalPage (int total , int pageTotalSize){
        return (total % pageTotalSize == 0?total/pageTotalSize:total/pageTotalSize+1);
    }

}
