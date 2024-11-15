public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] a = {3, 1, 2, 4, 5};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1, area =0;
        while(left<right)
        {
            area = Math.max(area,Math.min(height[left], height[right])*(right -left));
            if(height[left]<height[right])
                left+=1;
            else
                right-=1;
        }
        return area;
    }

//less running time solution
//    public int maxArea(int[] height) {
//        int left=0;
//        int right=height.length-1;
//        int max=0;
//        while(left<right){
//            int min=Math.min(height[left],height[right]);
//            max=Math.max(max,min*(right-left));
//            while(left < right && height[left]<=min)
//                left++;
//            while(left < right && height[right]<=min)
//                right--;
//        }
//        return max;
//    }
}
