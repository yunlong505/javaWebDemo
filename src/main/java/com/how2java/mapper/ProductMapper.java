package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.*;

import com.how2java.pojo.Product;

public interface ProductMapper {

    @Select(" select * from product_ where cid = #{cid}")
    public List<Product> listByCategory(int cid);

    @Select(" select * from product_ where id =#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "category", javaType = Category.class, column = "cid", one = @One(select = "com.how2java.mapper.CategoryMapper.get") )
    })
    public List<Product> list(int id);

    @Select("select * from product_ where id = #{id}")
    public Product get(int id);

}