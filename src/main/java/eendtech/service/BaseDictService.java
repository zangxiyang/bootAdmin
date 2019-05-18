package eendtech.service;

import eendtech.po.BaseDict;

import java.util.List;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 19:18
 */
public interface BaseDictService {
    //根据类别代码查询数据字典
    List<BaseDict> findBaseDictByTypeCode(String typecode);
}
