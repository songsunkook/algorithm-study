import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("  ___  ___  ___\n" + //
                "  | |__| |__| |\n" + //
                "  |           |\n" + //
                "   \\_________/\n" + //
                "    \\_______/\n" + //
                "     |     |\n" + //
                "     |     |\n" + //
                "     |     |\n" + //
                "     |     |\n" + //
                "     |_____|\n" + //
                "  __/       \\__\n" + //
                " /             \\\n" + //
                "/_______________\\");

        bw.close();
    }
}