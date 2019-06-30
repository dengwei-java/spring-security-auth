package com.dengwei.springsecuritybasic.model;


/**
 * @Author
 * @Description //TODO 用户角色类
 * @Date 2019/6/26 23:08
 * @return
 */

public class Role  {
    private Integer id;
    private String roleName;
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
