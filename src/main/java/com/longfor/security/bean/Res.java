package com.longfor.security.bean;

import lombok.Data;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/26 16:19.
 */
@Data
public class Res {
    private String title;
    private String content;
    private String extraInfo;


    public Res(String title, String content, String extraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }

}
