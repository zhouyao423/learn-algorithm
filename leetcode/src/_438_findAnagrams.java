import java.util.*;

public class _438_findAnagrams {
    public static void main(String[] args) {
        _438_findAnagrams a = new _438_findAnagrams();
        List<Integer> anagrams = a.findAnagrams2("cbaebabacd", "abc");
        System.out.println(anagrams);
    }
    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() > p.length()){
            return new ArrayList<>();
        }
        char[] chars = p.toCharArray();
        int[] pArray = new int[26];
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            pArray[index]++;
        }
        int[] sArray = new int[26];
        char[] sChars = s.toCharArray();
        int plenth = p.length();
        for (int i = 0; i < plenth; i++) {
            int index = sChars[i] - 'a';
            sArray[index]++;
        }
        List<Integer> list = new ArrayList<>();
        if (Arrays.equals(pArray,sArray)){
            list.add(0);
        }
        for (int i = plenth; i < sChars.length; i++) {
            int index = sChars[i] - 'a';
            sArray[index] ++;
            sArray[sChars[i-plenth] - 'a']--;
            if (Arrays.equals(pArray,sArray)){
                list.add(i-plenth+1);
            }
        }
        return list;
    }

        public List<Integer> findAnagrams1(String s, String p) {
        char[] chars = p.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer count = countMap.getOrDefault(chars[i], 0);
            countMap.put(chars[i], count + 1);
        }
        int length = p.length();
        int left = 0;
        int right = 0;
        char[] sChars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            if (countMap.containsKey(sChars[i])) {
                Integer integer = smap.getOrDefault(sChars[i], 0);
                smap.put(sChars[i], integer + 1);
                if (right - left + 1 > length) {
                    Integer leftCount = smap.get(sChars[left]);
                    smap.put(sChars[left], leftCount - 1);
                    left++;
                }
                if (right - left + 1 == length) {
                    if (check(countMap, smap)) {
                        list.add(left);
                    }
                }
            } else {
                left = i + 1;
                smap = new HashMap<>();
            }
            right++;
        }
        return list;
    }

    private boolean check(Map<Character, Integer> countMap, Map<Character, Integer> smap) {
        if (countMap.size() != smap.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!value.equals(smap.get(key))) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> findAnagrams(String s, String p) {
        char[] chars = p.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer count = countMap.getOrDefault(chars[i], 0);
            countMap.put(chars[i], count + 1);
        }
        char[] sChars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sChars.length; i++) {
            Integer sCount = countMap.get(sChars[i]);
            if (sCount == null || sCount == 0) {
                continue;
            } else {
                int check = check(sChars, i, countMap);
                if (check - i == p.length()) {
                    list.add(i);
                } else {
                    i = check;
                }
            }
        }
        return list;
    }

    private int check(char[] sChars, int i, Map<Character, Integer> countMap) {
        Map<Character, Integer> copyMap = new HashMap<>(Map.copyOf(countMap));
        for (int j = i; j < sChars.length; j++) {
            Integer sCount = copyMap.get(sChars[j]);
            if (sCount == null || sCount == 0) {
                return j;
            }
            sCount = sCount - 1;
            if (sCount == 0) {
                copyMap.remove(sChars[j]);
            } else {
                copyMap.put(sChars[j], sCount);
            }
            if (copyMap.size() == 0) {
                return j + 1;
            }
        }
        return sChars.length - 1;
    }

}
