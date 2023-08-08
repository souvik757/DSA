import java.util.Stack ;
public class _71_SimplifyPath {
    public static void main(String[] args) {
        System.out.println(solve_71.simplifyPath("/home/"));
        System.out.println(solve_71.simplifyPath("/../"));
        System.out.println(solve_71.simplifyPath("/home//foo/"));
        System.out.println(solve_71.simplifyPath("/home//foo/....//user//.."));
    }
}
class solve_71 {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>() ;
        String[] directories = path.split("/") ;
        for (String str : directories){
            if(str.equals(".") || str.isEmpty())
                continue ;
            else if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop() ;
            }
            else
                stack.push(str) ;
        }
        return "/"+String.join("/",stack) ;
    }
}