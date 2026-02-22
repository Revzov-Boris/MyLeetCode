import java.util.ArrayList;
import java.util.List;

public class Task71 {
    public static String simplifyPath(String path) {
        if (path.equals("/")) {
            return path;
        }

        List<String> list = new ArrayList();
        for (String s : path.split("/")) {
            switch (s) {
                case ".", "" -> {
                    break;
                }
                case ".." -> {
                    if (list.size() > 0) {
                        list.removeLast();
                    }
                    break;
                }
                default -> {
                    list.add(s);
                    break;
                }
            }
        }
        if (list.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("/"+s);
        }
        return sb.toString();
    }
}
