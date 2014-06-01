(ns euler.core
  (:gen-class))

;2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

;What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

;===========================================================

(defn sieve [s]
  (cons (first s) (lazy-seq (sieve (filter #(not= 0 (mod % (first s))) (rest s))))))

(def primes (sieve (iterate inc 2)))

(defn division-result-if-evenly-divisible [numerator, denominator]
  "Returns the result of the division if evenly divisible, otherwise the numerator"
  (let [result    (quot numerator denominator)
        remainder (mod numerator denominator)]
    (if (zero? remainder) result numerator)))

(defn lcm [coll]
  "Calculate lcm of this collection"  
  (loop [results coll
         top-row []
         primes (take (apply max coll) primes)]
    (if (every? #(= % 1) results)
      (reduce * top-row)
      (let [this-prime (first primes)
            next-results (map #(division-result-if-evenly-divisible % this-prime) results)]
      (if (= next-results results)
        (recur next-results top-row (rest primes)) 
        (recur next-results (conj top-row this-prime) primes))))))   


(defn euler-5 []
   (lcm (range 1 21)))
