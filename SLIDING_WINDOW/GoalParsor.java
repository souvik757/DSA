public class GoalParsor {
    public static void main(String[] args) {
        System.out.println(interpret("G()()()()(al)"));
    }
    public static String interpret(String command) {
        char[] answer = new char[command.length()] ;
        int i = 0 ;
        int index = 0 ;
        while(i < command.length()){
            if(command.charAt(i) == 'G'){
                answer[index] = command.charAt(i) ;
                index++ ;
                i++ ;
            }
            else
            {
                if(command.charAt(i) == '('){
                    if(command.charAt(i+1) == ')')
                    {
                        answer[index] = 'o' ;
                        index++ ;
                        i += 2 ;
                    }
                    else
                    {
                        answer[index] = 'a' ;
                        index++ ;
                        answer[index] = 'l' ;
                        index++ ;
                        i += 4 ;
                    }
                }
            }
        }

        return new String(answer).trim() ;
    }
}
