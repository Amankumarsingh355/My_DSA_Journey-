class Solution {
public:
    static int sum (int a){
        int ans=0;
        while(a>0){
            int rem=a%10;
            ans+=rem;
            a=a/10;
            

        }
        return ans;
    }

    static bool comp(int a, int b){
        int x=sum(a);
        int y=sum(b);
        if (x==y){
            if(a<b){
                return 1;
        
            }
            else{
                return 0;
            }
        }
        else{
            if(x<y){
                return 1;
            
            }
            else{
                return 0;
            
            }
        }

    }
    int minSwaps(vector<int>& arr) {


        int n=arr.size();
        map<int,int>mp;
        for(int i=0; i<n; i++){
            mp[arr[i]]=i;
        }
        vector<int>temp=arr;
        sort(temp.begin(),temp.end(),comp);
        
        int count=0;
        for (int i=0; i<n; i++){
            while(arr[i]!=temp[i]){
                int idx=mp[temp[i]];
                
                swap(temp[i],temp[idx]);
                count++;
            }
        }
        return count;
        
    }
};