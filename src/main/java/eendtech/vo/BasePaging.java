package eendtech.vo;

import eendtech.po.Links;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ author Seale
 * @ Description:VO层->基本的分页基VO层
 * @ QQ:1801157108
 * @ Date 2019/5/12 20:49
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Accessors(chain = true)
public class BasePaging<T> {
    //总条数
    private int total;
    //每页显示的条数
    private int pageTotalSize;
    //分页总数
    private int totalPage;
    //当前页数
    private int currentPage;
    //内容信息
    private List<T> content ;
    //链接信息
    private Links links;
}
