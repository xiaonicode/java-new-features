package com.xiaonicode.java16;

/**
 * 用户信息
 * <p>
 * Java 16 之前的数据载体类的定义方式
 *
 * @author xiaoni
 * @since 2022-06-25
 */
public final class User {

    private final String name;
    private final User partner;

    public User(String name, User partner) {
        this.name = name;
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public User getPartner() {
        return partner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        return partner.equals(user.partner);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + partner.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", partner=" + partner +
                '}';
    }

}
