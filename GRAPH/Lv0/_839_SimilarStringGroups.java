public class _839_SimilarStringGroups {
    public static void main(String[] args) {
        SOLVE839 object = new SOLVE839() ;
        System.out.println(object.Groups(new String[]{
                "tars","rats","arts","star"})
        );
        System.out.println(object.Groups(new String[]{
                "jvhpg","jhvpg","hpvgj","hvpgj","vhgjp"})
        );
        System.out.println(object.Groups(new String[]{
                "omv","ovm"})
        );
    }
}
class SOLVE839 {
    public int Groups(String[] copy) {
        int N = copy.length;
        int NoOfComponents = 0 ;
        boolean[] visited = new boolean[N];
        for (int i = 0 ; i < N ; i ++){
            if(!visited[i]){
                dfs(i,copy,visited);
                NoOfComponents++;
            }
        }
        return NoOfComponents;
    }
    private void dfs(int src , String[] copy , boolean[] visited){
        visited[src] = true ;
        for (int i = 0 ; i < copy.length ; i ++){
            if(!visited[i] && CanGroups(copy[src] , copy[i]))
                dfs(i,copy,visited);
        }
    }
    private boolean CanGroups(String s1 , String s2){
        int MaxDiff = 0 ; // -- exact 2 unit or ZERO unit difference is allowed --
        for (int i = 0 ; i < s1.length() ; i ++){
            if(s1.charAt(i) != s2.charAt(i))
                MaxDiff++ ;
        }
        return (MaxDiff <= 2) ;
    }
}
