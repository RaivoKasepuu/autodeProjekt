
import java.util.TreeSet;

public class IdGeneraator {


    private static  TreeSet<Integer> idSet = new TreeSet<Integer>();

    public static Integer getNextId() {
        System.out.println("küsiti IdGeneraatorilt Id");
        if(idSet.isEmpty()){
            idSet.add(1);
            return idSet.last();
        }
        idSet.add(idSet.last() + 1);
        return idSet.last();
    }


}

