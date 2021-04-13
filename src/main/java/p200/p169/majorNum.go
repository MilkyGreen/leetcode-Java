package main

func main() {
	
}


func majorityElement(nums []int) int {
	majorNum := len(nums)/2
	countMap := make(map[int]int)
	for _,v range : nums{
		count,ok := countMap[v]
		if !ok {
			countMap[v] = 1
		}else {
			if count + 1 > majorNum {
				return v
			}
			countMap[v] = count+1
		}
	}
	return nums[0]
}