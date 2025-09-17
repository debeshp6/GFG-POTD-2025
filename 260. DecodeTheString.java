class Solution {
    static class Pair {
        private String text;
        private int number;

        public Pair(String text, int number) {
            this.text = text;
            this.number = number;
        }

        public String getText() {
            return text;
        }

        public int getNumber() {
            return number;
        }
    }

    public static String decodeString(String s) {
        int currn = 0;
        String currs = "";
        Stack<Pair> mystack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currn = currn * 10 + (c - '0');
            } else if (c == '[') {
                mystack.push(new Pair(currs, currn));
                currn = 0;
                currs = "";
            } else if (c == ']') {
                Pair popelement = mystack.pop();
                currs = popelement.getText() + repeatString(currs, popelement.getNumber());
            } else {
                currs += c;
            }
            i++; 
        }
        return currs;
    }

    private static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}

