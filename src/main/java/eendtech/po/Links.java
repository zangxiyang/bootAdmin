package eendtech.po;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ author Seale
 * @ Description: Links 持久层
 * @ QQ:1801157108
 * @ Date 2019/5/12 20:53
 */

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Links implements Serializable {
    private static final long serialVersionUID = -4641523160652463695L;
    //第一页链接
    private String firstPage ;
    //下一页链接
    private String nextPage ;
    //上一页链接
    private String prePage ;
    //最后一页链接
    private String lastPage ;


}
