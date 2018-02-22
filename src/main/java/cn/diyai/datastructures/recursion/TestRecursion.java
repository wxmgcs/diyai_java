package cn.diyai.datastructures.recursion;

public class TestRecursion {
    public static void main(String[] args){
        Recursion recursion = new Recursion();
        System.out.print(recursion.fact(3));

        System.out.println(recursion.isPalindrome(null) +" == false");
        System.out.println(recursion.isPalindrome("A man, a plan, a canal: Panama") +" == true");
        System.out.println(recursion.isPalindrome("race a car") +" == false");
        System.out.println(recursion.isPalindrome("") +" == true");
        System.out.println(recursion.isPalindrome(" ") +" == true");
        System.out.println(recursion.isPalindrome("  ") +" == true");
        System.out.println(recursion.isPalindrome("1a2") +" == false");
        System.out.println(recursion.isPalindrome("'") +" == false");
        System.out.println(recursion.isPalindrome2(null) +" == false");
        System.out.println(recursion.isPalindrome2("A man, a plan, a canal: Panama") +" == true");
        System.out.println(recursion.isPalindrome2("race a car") +" == false");
        System.out.println(recursion.isPalindrome2("") +" == true");
        System.out.println(recursion.isPalindrome2(" ") +" == true");
        System.out.println(recursion.isPalindrome2("  ") +" == true");
        System.out.println(recursion.isPalindrome2("1a2") +" == false");
        System.out.println(recursion.isPalindrome2("'") +" == false");
    }

}
