(ns euler.core
  (:gen-class))

;If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

;Find the sum of all the multiples of 3 or 5 below 1000.


(defn multiple-of-3-or-5 [number] 
  (or (zero? (mod number 3))(zero? (mod number 5))))  


(defn euler-1
  (reduce + (filter multiple-of-3-or-5 (range 1 101))))