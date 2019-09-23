package com.how2java.mapper;

import java.util.List;

import com.how2java.CategoryDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import com.how2java.pojo.Category;

public interface CategoryMapper {

    //手写SQL语句的写法
    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int add(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    public Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category category);

   // 普通查询,无法查询出products
    @Select(" select * from category_ ")
    public List<Category> list();


    @Select(" select count(*) from category_ ")
    public int count();


    //一对多查询，可以查询出products
//    @Select(" select * from category_ ")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "products", column = "id", many = @Many(select = "com.how2java.mapper.ProductMapper.listByCategory"))
//    })
//    public List<Category> list();


    //xml方法写分页
    //  public List<Category> listByPage(@Param("start") int start, @Param("count")int count);

    //注解方法写分页
    @Select(" select * from category_ limit #{start},#{count}")
    public List<Category> listByPage(@Param("start") int start, @Param("count") int count);

//
//    //@InsertProvider配合CategoryDynaSqlProvider
//
//    @InsertProvider(type = CategoryDynaSqlProvider.class, method = "add")
//    public int add(Category category);
//
//    @DeleteProvider(type = CategoryDynaSqlProvider.class, method = "delete")
//    public void delete(int id);
//
//    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "get")
//    public Category get(int id);
//
//    @UpdateProvider(type = CategoryDynaSqlProvider.class, method = "update")
//    public int update(Category category);

//    @SelectProvider(type=CategoryDynaSqlProvider.class,method="list")
//    public List<Category> list();


}