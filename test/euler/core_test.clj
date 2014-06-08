(ns euler.core-test
   (:use [midje.sweet])
   (:require
         [euler.core :refer :all]))

  (facts "Euler Solutions"
    (fact "Euler Problem 1"
           (euler-1) => 233168)
     (facts "Euler Problem 2"
           (euler-2) => 4613732)
     (facts "Euler Problem 3"
           (euler-3) => 6857)
     (facts "Euler Problem 4"
           (euler-4) => 906609)
     (facts "Euler Problem 5"
           (euler-5) => 232792560)
     (facts "Euler Problem 6"
           (euler-6) => 25164150)
     (facts "Euler Problem 7"
           (euler-7) => 104743)
     (facts "Euler Problem 8"
           (euler-8) => 23514624000)
     (facts "Euler Problem 9"
           (euler-9) => 31875000)
)

