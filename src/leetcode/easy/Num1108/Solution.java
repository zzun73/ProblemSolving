package leetcode.easy.Num1108;

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}