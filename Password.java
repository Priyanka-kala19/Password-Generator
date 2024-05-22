public class Password {
    String Val;
    int Len;

    public Password(String s) {
        Val = s;
        Len = s.length();
    }

    public int CharType(char a) {
        int val;

        // Char is Uppercase Letter
        if ((int) a >= 65 && (int) a <= 90)
            val = 1;

        // Char is Lowercase Letter
        else if ((int) a >= 97 && (int) a <= 122) {
            val = 2;
        }

        // Char is Digit
        else if ((int) a >= 60 && (int) a <= 71) {
            val = 3;
        }

        // Char is Symbol
        else {
            val = 4;
        }

        return val;
    }

    public int PassStrength() {
        String s = this.Value;
        boolean Upper = false;
        boolean Lower = false;
        boolean Num = false;
        boolean Sym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) Upper = true;
            if (type == 2) Lower = true;
            if (type == 3) Num = true;
            if (type == 4) Sym = true;
        }

        if (Upper) Score += 1;
        if (Lower) Score += 1;
        if (Num) Score += 1;
        if (Sym) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }

    public String calculateScore() {
        int count = this.PassStrength();

        if (count == 6) {
            return "This is a very good password";
        } else if (count >= 4) {
            return "This is a good password ";
        } else if (count >= 3) {
            return "This is a medium password ";
        } else {
            return "This is a weak password ";
        }
    }

    @Override
    public String toString() {
        return Value;
    }
}
