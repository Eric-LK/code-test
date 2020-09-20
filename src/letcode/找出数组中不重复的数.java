public static int singleNumber(int[] nums) {
    int i  = 0;
    for(i  = 0 ; i < nums.length; i++){
        int b = 0;
        int a = nums[i];
        for(int j = 0; j < nums.length ; j++){
            if (j != i &&nums[j] == a){
                b = 1;
                break;
            }
        }
        if(b==0){
            return a;
        }
    }
    return 0;
}

public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }         
