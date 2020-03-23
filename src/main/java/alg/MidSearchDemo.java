package alg;

/**
 * 二分查找
 * Created by chen on 2020/3/12.
 */
public class MidSearchDemo {

    public int partSearch(int[] array, int value) {
        int low=0;
        int high=array.length-1;
        return part(array, low, high, value);
    }

    private int part(int[] array, int low, int high, int value) {
        int mid=low+((high-low)>>1);
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            high=mid-1;
            return part(array, low, high, value);
        } else if (array[mid] < value) {
            low=mid+1;
            return part(array, low, high, value);
        }
        return -1;
    }

    public int firstPartSearch(int[] array, int value) {
        int low=0;
        int high=array.length-1;
        String ss = "43213412";
        return firstPart(array, low, high, value);
    }

    private int firstPart(int[] array, int low, int high, int value) {
        if (low >= high) {
            return -1;
        }
        int mid=low+((high-low)>>1);
        if (array[mid] > value) {
            high=mid-1;
            return firstPart(array, low, high, value);
        } else if (array[mid] < value) {
            low=mid+1;
            return firstPart(array, low, high, value);
        }else {
            if(mid==0||array[mid-1]!=value) return mid;
            else high=mid-1;
            return firstPart(array, low, high, value);
        }
    }
        public int countCharacters(String[] words, String chars) {
          int res=0;
          String tem;
            for (int i = 0; i < words.length; i++) {
                tem=chars;
                for (int j = 0; j < words[i].length(); j++) {
                    if (tem.indexOf(words[i].charAt(j)) == -1) {
                        break;
                    }else {
                        tem=tem.replaceFirst(words[i].charAt(j)+"", "");
                    }
                    if (j == words[i].length() - 1) {
                        res+=words[i].length();
                    }
                }
            }
            return res;
        }
}
