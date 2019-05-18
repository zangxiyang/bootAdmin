package eendtech.dao;

import eendtech.po.BaseDict;

import java.util.List;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 17:05
 */
public interface BaseDictDao {
    //根据类别代码查询数据字典
    List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
