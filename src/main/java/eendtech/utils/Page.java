package eendtech.utils;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ author Seale
 * @ Description: 分页工具,目前不建议使用
 * @ QQ:1801157108
 * @ Date 2019/5/10 19:13
 */
@Deprecated
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Page<T> {
    private int total ; // 总条数
    private int page ; //当前页
    private int size ; //每页显示的条数
    private int totalPages ;//总页数
    private List<T> rows ; //结果集

    public int getTotalPages() {
        return total % size == 0?total/size:total/size+1;
    }

}
