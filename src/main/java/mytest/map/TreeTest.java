package mytest.map;

import java.util.HashMap;
import java.util.Map;

//封装的一个类。
class Entity {
    private Integer id;
    private Integer pid;
    private String name;


    public Entity(Integer id, Integer pid, String name) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

public class TreeTest {
    //新建的一个map
    public Map<Integer, Entity> map = new HashMap<Integer, Entity>();

    //来写一个方法存放数据的
    public Map<Integer, Entity> GetMap() {
        //括号的参数 一参：id 二参：pid 三参：名字

        Entity entity1 = new Entity(2, 1, "部门1");
        map.put(entity1.getId(), entity1);

        Entity entity2 = new Entity(3, 1, "部门2");
        map.put(entity2.getId(), entity2);

        Entity entity8 = new Entity(9, 3, "员工2");
        map.put(entity8.getId(), entity8);

        Entity entity9 = new Entity(10, 3, "员工3");
        map.put(entity9.getId(), entity9);

        Entity entity10 = new Entity(11, 7, "员工4");
        map.put(entity10.getId(), entity10);

        Entity entity3 = new Entity(4, 2, "组长1");
        map.put(entity3.getId(), entity3);

        Entity entity4 = new Entity(5, 2, "组长2");
        map.put(entity4.getId(), entity4);

        Entity entity5 = new Entity(6, 3, "组长3");
        map.put(entity5.getId(), entity5);

        Entity entity6 = new Entity(7, 3, "组长4");
        map.put(entity6.getId(), entity6);

        Entity entity7 = new Entity(8, 4, "员工1");
        map.put(entity7.getId(), entity7);

        Entity entity0 = new Entity(1, 0, "公司");
        map.put(entity0.getId(), entity0);


        return map;
    }

    public void getChild(Entity entity) {
        // 新建一個新的容器
        Map<Integer, Entity> mapChild = new HashMap<Integer, Entity>();
        //进行遍历
        for (Entity en : mapChild.values()) {
            // 如果Pid==id那麼就是父子關係
            if (en.getPid().equals(entity.getId())) {
                //这里的打印只是一个测试
                System.out.println(en.getName());
                // 调用自己继续进行子类的查找
                getChild(en);
            }
        }
    }

    //测试：
    public static void main(String[] args) {

        TreeTest tree = new TreeTest();
        tree.GetMap();//初始化方法不然打印不出来

        for (Entity en : tree.map.values()) {
            System.out.println(en.getName());
            tree.getChild(en);
        }
    }

}
