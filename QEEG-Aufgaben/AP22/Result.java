
public class Result {

    public boolean getResult(char[] a, String b) {
        boolean first = true;
        String c = "";
        String d = "";
        char operation = '+';
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '+' || a[i] == '-' || a[i] == '/' || a[i] == '*' || a[i] == '?' || a[i] == '=') {
                if (a[i] == '+') {
                    operation = a[i];
                    first = false;
                }
                if (a[i] == '-') {
                    operation = a[i];
                    first = false;
                }
                if (a[i] == '/') {
                    operation = a[i];
                    first = false;
                }
                if (a[i] == '*') {
                    operation = a[i];
                    first = false;
                }
            } else if (first) {
                c += a[i];

            } else {
                d += a[i];
            }


        }
        Boolean result = false;
        switch (operation) {
            case '+':
                result = Integer.parseInt(c) + Integer.parseInt(d) == Integer.parseInt(b);
                break;
            case '-':
                result = Integer.parseInt(c) - Integer.parseInt(d) == Integer.parseInt(b);
                break;
            case '/':
                result = Integer.parseInt(c) / Integer.parseInt(d) == Integer.parseInt(b);
                break;
            case '*':
                result = Integer.parseInt(c) * Integer.parseInt(d) == Integer.parseInt(b);
                break;
        }
        return result;

    }
}
