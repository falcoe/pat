import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class bfs{
    public static void main(String[] args) {
        Stack<Map<String,Object>> node = new Stack<Map<String,Object>>();
        Map<String,Object> nodep = new HashMap<String,Object>();
        node.add(nodep);
        while(!node.isEmpty()){
            nodep = node.pop();
            System.out.println(nodep);
        }
        List<Map<String,Object>> child = getChildren(nodep);
        if(child!=null && !child.isEmpty()){
            for (Map son : child) {
                node.push(son);
            }
        }
        System.out.println(is.pop());
    }
}