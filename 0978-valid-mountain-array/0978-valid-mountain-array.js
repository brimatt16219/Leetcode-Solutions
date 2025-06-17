/**
 * @param {number[]} arr
 * @return {boolean}
 */
var validMountainArray = function(arr) {
    let increase = true
    let decrease = true
    let hasIncrease = false
    let hasDecrease = false
    let direction = false
    for (let i = 0; i < arr.length - 1; i++) {
        if (arr[i] == arr[i + 1]) return false
        if (arr[i] < arr[i + 1]) hasIncrease = true
        if (arr[i] > arr[i + 1]) hasDecrease = true
        if (arr[i] > arr[i + 1]) direction = true
        if (!direction) {
            if (arr[i] >= arr[i + 1]) {
                increase = false
            }
        } else {
            if (arr[i] <= arr[i + 1]) {
                decrease = false
            }
        }
        
        
    }
    if (!hasIncrease || !hasDecrease) return false
   
    return increase && decrease
};