//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         String[] validCases = {
                "",     // пустая строка
                "()",   // простые валидные
                "{}",
                "[]",
                "({[]})",  // вложенные валидные
                "[{()}]",
                "({})[]",
                "(){}[]",  // сложные валидные
                "({[]})[{}]",
                "{[()]}"
        };

        String[] invalidCases = {
                "(",   // незакрытые
                ")",
                "[",
                "]",
                "{",
                "}",
                "(]",   // несоответствующие типы
                "{)",
                "[}",
                "{(})",  // неправильная вложенность
                "({[}])",
                "([)]",
                "{[}]",
                ")(",   // неправильный порядок
                "][",
                "}{",
                "()[]{)",  // смешанные невалидные
                "({[}])",
                "{([]})"
        };
        for (String s: validCases) {
            System.out.println(check(s)); //Все тесты должны быть true
        }
        System.out.println();
        for (String s: invalidCases) {
            System.out.println(check(s)); //Все тесты должны быть false
        }
    }

    public static boolean check(String s) {
        Stack stack = new Stack();
        for(int pos = 0; pos < s.length(); pos++) {
            if (s.charAt(pos) != ']' && s.charAt(pos) != '}' && s.charAt(pos) != ')') {
                stack.add(s.charAt(pos));
            } else {
                if (stack.take() == null
                        || (s.charAt(pos) == '}' && stack.take().getValue() != '{')
                        || (s.charAt(pos) == ')' && stack.take().getValue() != '(')
                        || (s.charAt(pos) == ']' && stack.take().getValue() != '[')) {
                    return false;
                }
                stack.delete();
            }
        }
        return stack.take() == null;
    }
}