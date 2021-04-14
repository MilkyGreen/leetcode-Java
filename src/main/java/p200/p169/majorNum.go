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

/**
思路：记录第一个数为major，数量为一。遍历数组，如果和major相同，count加一，不同count减一，count为0的时候更新major，最后的major就是结果。
原理是一定存在major数，它一定能和其他所有的数抵消，还有剩余。
**/
func majorityElement2(nums []int) int {
	majorNum := nums[0]
	count := 1
	for index,v := range nums{
		if index >0 {
			if v == majorNum{
				count++
			}else {
				if count == 0{
					count = 1
					majorNum = v
				}else {
					count--
				}
			}
		}
	}
	return majorNum
}