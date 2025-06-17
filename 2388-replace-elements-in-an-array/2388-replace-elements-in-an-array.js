/**
 * @param {number[]} nums
 * @param {number[][]} operations
 * @return {number[]}
 */
var arrayChange = function(nums, operations) {
    for (let i = 0; i < operations.length; i++) {
        let op1 = operations[i][0]
        let op2 = operations[i][1]

        let index = 0
        for (let j = 0; j < nums.length; j++) {
            if (nums[j] == op1) index = j
        }

        nums[index] = op2
    }
    return nums
};