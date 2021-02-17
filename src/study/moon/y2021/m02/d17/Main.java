package study.moon.y2021.m02.d17;
//https://programmers.co.kr/learn/courses/30/lessons/72410    [레벨2]    신규 아이디 추천
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("bat.y.abcdefghi");
        System.out.println(solution.solution("z-+.^."));
        System.out.println("z--");
        System.out.println(solution.solution("=.="));
        System.out.println("aaa");
        System.out.println(solution.solution("123_.def"));
        System.out.println("123_.def");
        System.out.println(solution.solution("abcdefghijklmn.p"));
        System.out.println("abcdefghijklmn");
    }
}

class Solution {
    public String solution(String new_id) {
        new_id = level1(new_id);
        new_id = level2(new_id);
        new_id = level3(new_id);
        new_id = level4(new_id);
        new_id = level5(new_id);
        new_id = level6(new_id);
        new_id = level7(new_id);
        return new_id;
    }

    private String level1(String id) {
        return id.toLowerCase();
    }

    private String level2(String id) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            if ((id.charAt(i)>='a' && id.charAt(i)<='z')
                || (id.charAt(i)>='0' && id.charAt(i)<='9')
                || id.charAt(i)=='.'
                || id.charAt(i)=='_'
                || id.charAt(i)=='-'
            ) {
                builder.append(id.charAt(i));
            }
        }
        return builder.toString();
    }

    private String level3(String id) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < id.length()-1; i++) {
            if (!(id.charAt(i)=='.' && id.charAt(i+1)=='.')) {
                builder.append(id.charAt(i));
            }
        }
        builder.append(id.charAt(id.length()-1));
        return builder.toString();
    }

    private String level4(String id) {
        StringBuilder builder = new StringBuilder(id);
        if (id.length()==0) {
            return "";
        }
        if (builder.charAt(0)=='.') {
            builder.deleteCharAt(0);
        }
        if (builder.length()==0) {
            return "";
        }
        if (builder.charAt(builder.length()-1)=='.') {
            builder.deleteCharAt(builder.length()-1);
        }
        return builder.toString();
    }

    private String level5(String id) {
        if (id.length()==0) {
            return "a";
        } else {
            return id;
        }
    }

    private String level6(String id) {
        if (id.length()>=16) {
            id = id.substring(0,15);
        }
        if (id.charAt(id.length()-1)=='.') {
            id = id.substring(0,id.length()-1);
        }
        return id;
    }

    private String level7(String id) {
        StringBuilder builder = new StringBuilder(id);
        if (id.length()<=2) {
            while(builder.length()!=3) {
                builder.append(id.charAt(id.length()-1));
            }
        }
        return builder.toString();
    }
}
