package NEU.Week10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hashmap_EmployeeImportance_690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates; // is a list of the IDs
    };

    public int getImportance(List<Employee> employees, int id) {
        // 思路：HashMap + DFS
        // 为什么这样设计：要计算importance，必须拿到实例e，e必须通过索引拿，为了查找id对应的index，所以用hashmap
        // HashMap：<id,index> 通过id->index->e->e.id .importance .sub，再通过sub的id拿索引放队列
        // DFS：<index/id都可>
        int i = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer,Integer>();
        for (Employee e : employees) {
            hashmap.put(e.id, i++);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        // 放第一个父亲索引
        queue.add(hashmap.get(id));
        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int parentPos = queue.poll();
                // 得到父亲索引
                employees.get(parentPos);
                // 通过索引，拿到imp和sub
                Employee e = employees.get(parentPos);
                sum += e.importance;
                // 子节点索引入队列
                for (int subId : e.subordinates) {
                    queue.add(hashmap.get(subId));
                }
            }


        }
        return sum;
    }
}
