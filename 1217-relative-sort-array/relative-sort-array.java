class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> rem = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int num : arr2){
            countMap.put(num,0);
        }
        for(int num : arr1){
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num) + 1);
            }
            else{
                rem.add(num);
            }
        }
Collections.sort(rem);
for(int num : arr2){
    for(int j = 0; j < countMap.get(num); j++){
        res.add(num);
    }
}
        res.addAll(rem);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}