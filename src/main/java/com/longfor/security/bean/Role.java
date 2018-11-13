package com.longfor.security.bean;


import java.sql.Timestamp;

import lombok.Data;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/24 14:08.
 */
@Data
public class Role {
    private int roleid;
    private String rolename;
    private Timestamp version;
}
