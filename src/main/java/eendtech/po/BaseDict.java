package eendtech.po;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ author Seale
 * @ Description:
 * @ QQ:1801157108
 * @ Date 2019/5/10 15:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@ToString
@Accessors(chain = true)
public class BaseDict implements Serializable {
    private static final long serialVersionUID = -6882245409848059352L;
    private String dict_id ; //数据字典id
    private String dict_type_code ; //数据字典类别代码
    private String dict_type_name ; //数据字典类别名称
    private String dict_item_name ; //数据字典项目名称
    private String dict_item_code ; //数据字典项目代码
    private Integer dict_sort ; //排序字段
    private String dict_enable ;//是否可用
    private String dict_memo ; //备注

}
