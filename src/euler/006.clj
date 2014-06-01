(ns euler.core
  (:gen-class))

;The sum of the squares of the first ten natural numbers is,

;12 + 22 + ... + 102 = 385

;The square of the sum of the first ten natural numbers is,

;(1 + 2 + ... + 10)2 = 552 = 3025
;Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

;Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

;===========================================================

(defn square [x] (* x x))


(defn euler-6 []
(- 
  (square (reduce + (range 1 101))) 
  (reduce + (map square (range 1 101)))))