package leetcode.kotlin.array.easy

private fun subarraySum(nums: IntArray, k: Int): Int {
    var cnt = 0
    for (i in nums.indices) {
        var sum = 0
        for (j in i until nums.size) {
            sum += nums[j]
            if (sum == k) cnt++
        }
    }
    return cnt
}

private fun subarraySum2(nums: IntArray, k: Int): Int {
    var cnt = 0
    var sum = 0
    var map = mutableMapOf<Int, Int>()
    map.put(0, 1)
    for (i in 0 until nums.size) {
        sum += nums[i]
        if (map.contains(sum - k)) cnt += map.get(sum - k)!!
        map.put(sum, map.getOrDefault(sum, 0) + 1)
    }
    return cnt
}
