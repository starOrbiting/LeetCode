//package NEU.Week11;
//
//public class binary_FirstBadVersion_278 {
//    public int firstBadVersion(int n) {
//        // 思路：Binary二分查找
//        // 提前判断第一个bad
//        if (n == 1 || isBadVersiom(1)){
//            return 1;
//        }
//        int l = 1, r = n;
//        int mid;
//        while (l <= r){
//            mid = (r-l)/2+l;
//            // true
//            if (!isBadVersion(mid)){
//                l = mid + 1;
//            }
//            else {
//                // 都有mid-1
//                if (isBadVersion(mid-1)){
//                    r = mid - 1;
//                }
//                else return mid;
//            }
//        }
//        return mid;
//    }
//}
