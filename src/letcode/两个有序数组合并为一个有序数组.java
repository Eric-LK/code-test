 public void merge(int[] nums1, int m, int[] nums2, int n) {
    for(int i = 0; i < n; i++){
        int flag = 1;
        for(int j = 0; j < nums1.length; j++){
            if(nums2[i] < nums1[j]){
                for(int x = nums1.length - 1; x > j; x--){
                    nums1[x] = nums1[x-1];
                }
                nums1[j]=nums2[i];
                flag = 0;
                m++;
                break;
            } 
        }
        if(flag == 1){
            nums1[m] = nums2[i];
            m++;
        }
    }
}
