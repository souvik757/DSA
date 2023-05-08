import java.util.*;

public class _399_EvaluateDivision {
    public static void main(String[] args) {
        SOLVE399 object = new SOLVE399() ;
    }
}
class SOLVE399{
    private Map<String , Map<String,Double>> mapping ;
    private void MakeMapping(List<List<String>> eqn , double[] values) {
        for (int i = 0 ; i < eqn.size() ; i ++) {
            String u = eqn.get(i).get(0) ;
            String v = eqn.get(i).get(1) ;

            mapping.putIfAbsent(u , new HashMap<>()) ;
            mapping.get(u).put(v , values[i]) ;

            mapping.putIfAbsent(v , new HashMap<>()) ;
            mapping.get(v).put(u , 1/values[i]) ;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        MakeMapping(equations , values) ;
        double[] answer = new double[queries.size()] ;
        for (int i = 0 ; i < queries.size() ; i ++) {
            values[i] = getValueBydfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<>()) ;
        }
        return answer ;
    }
    private double getValueBydfs(String src , String dest , Set<String> visited) {
        if(!mapping.containsKey(src))
            return -1.0 ;
        if(mapping.get(src).containsKey(dest))
            return 1.0 ;

        visited.add(src) ;

        for (Map.Entry<String,Double> entry : mapping.get(src).entrySet()) {
            if(!visited.contains(entry.getKey())) {
                double val = getValueBydfs(entry.getKey(), dest , visited) ;
                if(val != -1)
                    return entry.getValue() * val ;
            }
        }
        return -1.0 ;
    }
}
