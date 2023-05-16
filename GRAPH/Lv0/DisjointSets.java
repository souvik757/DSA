import java.util.List ;
import java.util.ArrayList ;

// Disjoint - Sets
// ---- > 1 . Union By Rank()
// ---- > 1 . Union By Size()

class UnionByRank {
    private List<Integer> rank   = new ArrayList<>() ;
    private List<Integer> parent = new ArrayList<>() ;
    public UnionByRank(int NoOfVertex){
        for(int i = 0 ; i <= NoOfVertex ; i ++){
            rank.add(0) ;
            parent.add(i) ;
        }
    }
    public int Parent(int Vertex){
        if(Vertex == parent.get(Vertex))
            return Vertex ;
        int ulp = Parent(parent.get(Vertex)) ;
        parent.add(Vertex , ulp) ;
        return parent.get(Vertex) ;
    }
    public void GetUnion(int v1 , int v2){
        int ulp_v1 = Parent(v1) ;
        int ulp_v2 = Parent(v2) ;
        if(ulp_v1 == ulp_v2)
            return ;
        if(rank.get(ulp_v1) < rank.get(ulp_v2))
            parent.add(ulp_v1 , ulp_v2) ;
        else if(rank.get(ulp_v1) > rank.get(ulp_v2))
            parent.add(ulp_v2 , ulp_v1) ;
        else{
            parent.add(ulp_v2 , ulp_v1) ;
            rank.add(ulp_v1 , rank.get(ulp_v1)+1);
        }
    }
}
class UnionBySize{
    private List<Integer> size   = new ArrayList<>() ;
    private List<Integer> parent = new ArrayList<>() ;

    public UnionBySize(int NoOfVertex) {
        for(int i = 0 ; i <= NoOfVertex ; i ++){
            size.add(1) ;
            parent.add(i) ;
        }
    }
    public int Parent(int Vertex){
        if(Vertex == parent.get(Vertex))
            return Vertex ;
        int ulp = Parent(parent.get(Vertex)) ;
        parent.add(Vertex , ulp) ;
        return parent.get(Vertex) ;
    }
    public void GetUnion(int v1 , int v2){
        int ulp_v1 = Parent(v1) ;
        int ulp_v2 = Parent(v2) ;
        if(ulp_v1 == ulp_v2)
            return ;
        if(size.get(ulp_v1) < size.get(ulp_v2))
        {
            parent.add(ulp_v1 , ulp_v2) ;
            size.add(ulp_v2 ,size.get(ulp_v2)+size.get(ulp_v1));
        }
        else
        {
            parent.add(ulp_v2 , ulp_v1) ;
            size.add(ulp_v1 ,size.get(ulp_v1)+size.get(ulp_v2));
        }
    }
}
public class DisjointSets {
    public static void main(String[] args) {
        // UnionByRank()
        UnionByRank object = new UnionByRank(7) ;
        object.GetUnion(1 , 2);
        object.GetUnion(4 , 5);
        object.GetUnion(5 , 6);
        System.out.println(object.Parent(3));
        System.out.println(object.Parent(7));
        object.GetUnion(3 , 7);
        System.out.println(object.Parent(3));
        System.out.println(object.Parent(7));
        // UnionBySize()
        UnionBySize object1 = new UnionBySize(7) ;
        object1.GetUnion(1 , 2);
        object1.GetUnion(4 , 5);
        object1.GetUnion(5 , 6);
        System.out.println(object1.Parent(3));
        System.out.println(object1.Parent(7));
        object1.GetUnion(3 , 7);
        System.out.println(object1.Parent(3));
        System.out.println(object1.Parent(7));
    }
}
