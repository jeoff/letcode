package mytest.hierarchy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
class Goal {
    private int Id;
    private int parentId;
    private String goalName;
    private List<Goal> listGoal;
}

public class TreeTest {

    public List<Goal> test(List<Goal> listGoal) {

        Map<Integer, Goal> goalMap = new HashMap<Integer, Goal>();
        for (Goal g : listGoal) {
            int id = g.getId();
            goalMap.put(id, g);
        }
        for (Goal g : listGoal) {
            int pid = g.getParentId();
            if (pid != 0) {
                Goal tempGoal = goalMap.get(pid);
                List<Goal> tempListGoal = tempGoal.getListGoal();
                if (tempListGoal == null) {
                    tempListGoal = new ArrayList<Goal>();
                }
                tempListGoal.add(g);
                tempGoal.setListGoal(tempListGoal);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Integer k : goalMap.keySet()) {
            Goal tempGoal = goalMap.get(k);
            if (tempGoal.getParentId() != 0) {
                list.add(k);
            }
        }
        for (int i : list) {
            goalMap.remove(i);
        }
        return new ArrayList<Goal>(goalMap.values());
    }

    public static void main(String[] args) {
        List<Goal> listGoal = new ArrayList<Goal>();
        Goal g1 = new Goal();
        g1.setId(1);
        g1.setParentId(0);
        g1.setGoalName("g1");
        Goal g2 = new Goal();
        g2.setId(2);
        g2.setParentId(1);
        g2.setGoalName("g2");
        Goal g3 = new Goal();
        g3.setId(3);
        g3.setParentId(2);
        g3.setGoalName("g3");
        Goal g4 = new Goal();
        g4.setId(4);
        g4.setParentId(2);
        g4.setGoalName("g4");
        Goal g5 = new Goal();
        g5.setId(5);
        g5.setParentId(3);
        g5.setGoalName("g5");
        Goal g6 = new Goal();
        g6.setId(6);
        g6.setParentId(0);
        g6.setGoalName("g6");
        Goal g7 = new Goal();
        g7.setId(7);
        g7.setParentId(3);
        g7.setGoalName("g7");
        Goal g8 = new Goal();
        g8.setId(8);
        g8.setParentId(7);
        g8.setGoalName("g8");
        Goal g9 = new Goal();
        g9.setId(9);
        g9.setParentId(7);
        g9.setGoalName("g9");
        Goal g10 = new Goal();
        g10.setId(10);
        g10.setParentId(4);
        g10.setGoalName("g10");
        Goal g11 = new Goal();
        g11.setId(11);
        g11.setParentId(10);
        g11.setGoalName("g1");
        Goal g12 = new Goal();
        g12.setId(12);
        g12.setParentId(7);
        g12.setGoalName("g12");
        Goal g13 = new Goal();
        g13.setId(13);
        g13.setParentId(0);
        g13.setGoalName("g13");
        listGoal.add(g1);
        listGoal.add(g2);
        listGoal.add(g3);
        listGoal.add(g4);
        listGoal.add(g5);
        listGoal.add(g6);
        listGoal.add(g7);
        listGoal.add(g8);
        listGoal.add(g9);
        listGoal.add(g10);
        listGoal.add(g11);
        listGoal.add(g12);
        listGoal.add(g13);
        TreeTest t = new TreeTest();
        List<Goal> listT = t.test(listGoal);
        System.out.println(listT);


    }
}
