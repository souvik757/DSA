import java.util.* ;
public class _721_Accounts_Merge {
    public static void main(String[] args) {
        //  run methods from object .....
        SOLVE721 object = new SOLVE721() ;
        List<List<String>> accounts = new ArrayList<>() ;
        int N = 0 ;
        String inputString = "" ;
//  *  ["John","johnsmith@mail.com","john_newyork@mail.com"],
//  *  ["John","johnsmith@mail.com","john00@mail.com"],
//  *  ["Mary","mary@mail.com"],
//  *  ["John","johnnybravo@mail.com"]
//  *  -- Input Style --
//  *  // * -- start
//  *  size : 3
//  *  John
//  *  johnsmith@mail.com
//  *  john_newyork@mail.com
//  *  // * -- start
//  *  size : 3
//  *  John
//  *  johnsmith@mail.com
//  *  john00@mail.com
//  *  // * -- start
//  *  size : 2
//  *  Mary
//  *  mary@mail.com
//  *  // * -- start
//  *  size : 2
//  *  John
//  *  johnnybravo@mail.com
//  *  // * -- ok
        while (!inputString.equals("ok")){
            System.out.print("// * -- ");
            inputString = new Scanner(System.in).nextLine() ;
            switch (inputString){
                case "stop" :

                    break ;
                case "start" :
                    List<String> input = new ArrayList<>() ;
                    String inputs;
                    System.out.print("size : ");
                    N = new Scanner(System.in).nextInt() ;
                    inputs = new Scanner(System.in).nextLine() ;
                    input.add(inputs) ;
                    int n = N-1 ;
                    while (n-->0){
                        inputs = new Scanner(System.in).nextLine() ;
                        input.add(inputs) ;
                    }
                    accounts.add(input) ;
                    break ;

            }
        }
        accounts = object.accountsMerge(accounts) ;
        System.out.println("// * -- Compressed accounts --");
        for (List<String> account : accounts) System.out.println(account);
    }
}
class SOLVE721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> answer = new ArrayList<>() ;
        int size = accounts.size() ;
        UnionFind obj = new UnionFind(size) ;
        Map<String , Integer> mailmap = new HashMap<>() ;
        for (int i = 0 ; i < size ; i ++){
            for (int j = 1 ; j < accounts.get(i).size() ; j ++){
                String mail = accounts.get(i).get(j) ;
                if (!mailmap.containsKey(mail))
                    mailmap.put(mail , i) ;
                else
                    obj.union(i, mailmap.get(mail)) ; // create union of mails with index :::
            }
        }
        List<String>[] mergemail = new ArrayList[size] ;
        for (int i = 0 ; i < size ; i ++)
            mergemail[i] = new ArrayList<>() ;
        for (Map.Entry<String,Integer> entry : mailmap.entrySet()){
            String mail = entry.getKey() ;
            int node = obj.find(entry.getValue()) ;
            mergemail[node].add(mail) ;
        }
        for (int i = 0 ; i < size ; i ++){
            if(mergemail[i].size() == 0)
                continue ;
            Collections.sort(mergemail[i]) ;
            List<String> temp = new ArrayList<>() ;
            temp.add(accounts.get(i).get(0)) ;
            for (String str : mergemail[i])
                temp.add(str) ;
            answer.add(temp) ;
        }
        return answer ;
    }
}
class UnionFind {
    private int[] root ;

    public UnionFind(int size) { // O(n)
        root = new int[size] ;
        for (int i = 0 ; i < size ; i ++)
            root[i] = i ;
    }
    public int find(int x){ // O(1)
        return root[x] ;
    }
    public void union(int x , int y){ // O(n)
        int rootX = root[x] ;
        int rootY = root[y] ;
        if(rootX != rootY) {
            for (int i = 0 ; i < root.length ; i ++) {
                if (root[i] == rootY)
                    root[i] = rootX ;
            }
        }
    }
    public boolean connected(int x , int y){ // O(1)
        return root[x] == root[y] ;
    }
}