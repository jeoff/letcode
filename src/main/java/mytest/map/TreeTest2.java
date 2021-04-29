package mytest.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeTest2 {
    //新建的一个map
    public Map<Integer, Entity> map = new HashMap<Integer, Entity>();

    //来写一个方法存放数据的
    public Map<Integer, Entity> GetMap() {
        //括号的参数 一参：id 二参：pid 三参：名字
        Entity entity0 = new Entity(1, 0, "公司");
        Entity entity1 = new Entity(2, 1, "部门1");
        Entity entity2 = new Entity(3, 1, "部门2");
        Entity entity4 = new Entity(4, 1, "部门2");
        Entity entity8 = new Entity(9, 3, "员工2");
        Entity entity10 = new Entity(10, 9, "员工2");

        map.put(entity0.getId(), entity0);
        map.put(entity1.getId(), entity1);
        map.put(entity2.getId(), entity2);
        map.put(entity8.getId(), entity8);

        return map;
    }

    public Set<Integer> getParent(Entity entity) {
        Set<Integer> parentIdSet = new HashSet<>();

        Integer id = entity.getId();
        Integer pid = entity.getPid();
        if (pid != 0) {
            parentIdSet.add(pid);
            parentIdSet.addAll(getParent(map.get(id)));
        }

        return parentIdSet;
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

        TreeTest2 tree = new TreeTest2();
        tree.GetMap();//初始化方法不然打印不出来

        Entity entity8 = new Entity(9, 3, "员工2");
        Entity entity4 = new Entity(4, 1, "员工2");

        List<Entity> entityList = new ArrayList<>();
        entityList.add(entity8);
        entityList.add(entity4);

        Set<Integer> parentIdSet = new HashSet<>();

        for (Entity entity: entityList) {
            parentIdSet.addAll(tree.getParent(entity));
        }
        System.out.println(parentIdSet);

    }

}
