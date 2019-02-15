package com.lazycece.sbac.validation.enums;

/**
 * @author lazycece
 * @date 2019/02/15
 */
public enum Role {

    ADMIN(1, "管理员"),
    TEST(2, "测试"),
    DEVELOP(3, "开发");

    private int value;
    private String desc;

    Role(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
