import java.util.ArrayList;
import java.lang.Object;

class Test {
  public static int compter(char a, String phrase) {
    int out = 0;
    for(int i = 0; i < phrase.length(); i ++) {
      if(a == phrase.charAt(i)) {
        out ++;
      }
    }
    return out;
  }

  public static ArrayList<Noeud> occurences(String phrase) {
    String s = new String(phrase);
    ArrayList<Noeud> out = new ArrayList<Noeud>();
    while (s.length() > 0) {
      Noeud n = new Noeud(s.charAt(0), compter(s.charAt(0), s));
      out.add(n);
      StringUtils.remove(s, s.charAt(0));
    }
    return out;
  }
}
