package com.how2java;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.mapper.CategoryMapper;
import com.how2java.mapper.OrderMapper;
import com.how2java.mapper.ProductMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //增加
//        Category c = new Category();
//        c.setName("Category3");
//        session.insert("addCategory",c);

        //删除
//        Category c = new Category();
//        c.setId(3);
//        session.delete("deleteCategory",c);

        //获取
//        Category c= session.selectOne("getCategory",2);
//        System.out.println(c.getName());

        //修改
//        Category c= session.selectOne("getCategory",2);
//        c.setName("category22");
//        session.update("updateCategory",c);

        //模糊查询
//        List<Category> cs = session.selectList("listCategoryByName","cat");

        //多条件查询-map
//        Map<String,Object> params = new HashMap<>();
//        params.put("id", 1);
//        params.put("name", "cat");
//        List<Category> cs = session.selectList("listCategoryByIdAndName",params);

//        //一对多查询
//        List<Category> cs = session.selectList("listCategoryO2M");
//        for (Category c : cs) {
//            System.out.println(c);
//            List<Product> ps = c.getProducts();
//            for (Product p : ps) {
//                System.out.println("\t"+p);
//            }
//        }
        //多对一查询
//        List<Product> ps = session.selectList("listProduct");
//        for (Product p : ps) {
//            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
//        }

        //多对多查询
//         listOrder(session);
        //建立多对多关系
      //     addOrderItem(session);

        //删除多对多关系
  //      deleteOrderItem(session);

        //删除Order同时删除orderIterm
//        session.delete("deleteOrder",3);
//        listOrder(session);

        //测试if查询所有product
//        List<Product> ps = session.selectList("listProduct");
//        for (Product p : ps) {
//            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
//        }

        //测试if用name查询product
//        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
//        List<Product> ps = session.selectList("listProduct",params);
//        for (Product p : ps) {
//            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
//        }

        //测试where用name查询product
//        Map<String,Object> params = new HashMap<>();
//        params.put("price",89);
//        List<Product> ps = session.selectList("listProduct",params);
//        for (Product p : ps) {
//            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
//        }
        //测试set
//        Product p = new Product();
//        p.setId(6);
//        p.setName("product zz");
//        p.setPrice(99.99f);
//        session.update("updateProduct",p);
//        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
//        params.put("price","110");
//        List<Product> ps2 = session.selectList("listProduct",params);
//        for (Product pp : ps2) {
//            System.out.println(pp);
//        }

        //测试when otherwise
//        Map<String,Object> params = new HashMap<>();
////      params.put("name","a");
////      params.put("price","10");
//        List<Product> ps = session.selectList("listProduct",params);
//        for (Product p : ps) {
//            System.out.println(p);
//        }

        //测试foreach
//        List list = new ArrayList();
//        list.add(1);
//        list.add(3);
//        list.add(5);
//      //  int[] ids= new int[]{1,3,5};
//        List<Product> ps = session.selectList("foreachProduct",list);
//        for (Product p : ps) {
//            System.out.println(p);
//        }


//        List<Category> cs = session.selectList("listCategory");//也可以写成 session.selectList("com.how2java.pojo.listCategory");
//        for (Category cc : cs) {
//            System.out.println(cc.getName());
//        }

        //注解形式的crud
        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
 //       add(mapper);
//        delete(mapper);
//        get(mapper);
//        update(mapper);
        listAll(mapper);

        //注解形式的一对多
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        List<Category> cs = mapper.list();
//        for (Category c : cs) {
//            System.out.println(c.getName());
//            List<Product> ps = c.getProducts();
//            for (Product p : ps) {
//                System.out.println("\t"+p.getName());
//            }
//        }
        //注解形式的多对一
//        ProductMapper mapper = session.getMapper(ProductMapper.class);
//        List<Product> ps= mapper.list(1);
//        for (Product p : ps) {
//            System.out.println(p + "\t对应的分类是:\t" + p.getCategory().getName());
//        }

        //注解形式的多对多
//        OrderMapper mapper =session.getMapper(OrderMapper.class);
//        List<Order> os = mapper.list();
//        for (Order o : os) {
//            System.out.println(o.getCode());
//            List<OrderItem> ois = o.getOrderItems();
//            if (null != ois) {
//                for (OrderItem oi : ois) {
//                    System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(), oi.getProduct().getPrice(), oi.getNumber());
//                }
//            }
//        }

        //事务测试一个错全部错
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        Category c1 = new Category();
//        c1.setName("长度够短的名称");
//        mapper.add(c1);
//
//        Category c2 = new Category();
//        c2.setName("超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称超过最大长度30的名称");
//        mapper.add(c2);

        //延迟加载测试
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        List<Category> cs = mapper.list();
//        for (Category c : cs) {
//            System.out.println(c.getName());
////          List<Product> ps = c.getProducts();
////          for (Product p : ps) {
////              System.out.println("\t"+p.getName());
////          }
//        }
        //分页数据准备
//        List<Category> cs = session.selectList("listCategory");
//        for (Category c : cs) {
//            session.delete("deleteCategory", c);
//        }
//        for (int i = 0; i < 100; i++) {
//            Category c = new Category();
//            c.setName("category name " + i);
//            session.insert("addCategory", c);
//        }
//        List<Category> cs2 = session.selectList("listCategory");
//        for (Category c : cs2) {
//            System.out.println(c.getName());
//        }
        //分页xml方法
//        Map<String,Object> params = new HashMap<>();
//        params.put("start", 0);
//        params.put("count", 5);
//        List<Category>  cs =session.selectList("listCategory", params);
//        for (Category c : cs) {
//            System.out.println(c);
//        }

        //分页注解方法
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        List<Category>  cs =mapper.listByPage(0, 5);
//        for (Category c : cs) {
//            System.out.println(c);
//        }

        //PageHelper分页方法
//        PageHelper.offsetPage(0,5);
//        List<Category> cs = session.selectList("listCategory");
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//        //获取总数
//        PageInfo pageInfo = new PageInfo();
//        System.out.println("总数："+pageInfo.getTotal());
//        System.out.println(pageInfo);

        //在一个Session里查相同id的数据
//        SqlSession session1 = sqlSessionFactory.openSession();
//
//        Category c1 = session1.selectOne("getCategory", 10);
//        System.out.println(c1);
//        Category c2 = session1.selectOne("getCategory", 10);
//        System.out.println(c2);
//
//        session1.commit();
//        session1.close();
//
//        SqlSession session2 = sqlSessionFactory.openSession();
//        Category c3 = session2.selectOne("getCategory", 10);
//        System.out.println(c3);
//
//        session2.commit();
//        session2.close();
        //获取总数
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        System.out.println(mapper.count());
        //GENERATOR 用法


        session.commit();
        session.close();
    }

    private static void listAll(CategoryMapper mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }

    private static void update(CategoryMapper mapper) {
        Category c= mapper.get(8);
        c.setName("修改了的Category名稱");
        mapper.update(c);
        listAll(mapper);
    }

    private static void get(CategoryMapper mapper) {
        Category c= mapper.get(2);
        System.out.println(c.getName());
    }

    private static void delete(CategoryMapper mapper) {
        mapper.delete(2);
        listAll(mapper);
    }

    private static void add(CategoryMapper mapper) {
        Category c = new Category();
        c.setName("新增加的Category");
        mapper.add(c);
        listAll(mapper);
    }

    private static void listOrder(SqlSession session) {
        List<Order> os = session.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(), oi.getProduct().getPrice(),
                        oi.getNumber());
            }
        }
    }

    private static void addOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder", 1);
        Product p6 = session.selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        oi.setNumber(200);

        session.insert("addOrderItem", oi);
    }

    private static void deleteOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder",1);
        Product p6 = session.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);
        session.delete("deleteOrderItem", oi);
    }
}