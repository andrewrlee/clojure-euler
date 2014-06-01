(ns euler.core
  (:gen-class))

;A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

;Find the largest palindrome made from the product of two 3-digit numbers.
;===========================================================


(def numbers 
  "range of numbers we are interested in"
  (range (* 999 999) (* 100 100) -1))

(defn palindrome? [number] 
  "Checks to see if this number is a palindrome"
  (= (str number) (clojure.string/reverse (str number))))

(defn has-a-3-digit-aliquot? [a b]
  "Checks if a is evenly divisibly by b, and the result is a 3 digit number" 
    (let [denominator (quot a b)
          remainder   (mod a b)
          result      (and (zero? remainder) (< 99 denominator 1000))] 
      result)) 

(defn product-of-a-pair-of-3-digit-numbers? [number] 
  "Checks to see if this number is a product of 2 3-digit numbers"
  (some #(has-a-3-digit-aliquot? number %)  (range 999 100 -1)))

(defn euler-4 []
  (first (filter product-of-a-pair-of-3-digit-numbers? (filter palindrome? numbers))))

