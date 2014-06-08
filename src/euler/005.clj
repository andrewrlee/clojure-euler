(in-ns 'euler.core)

;2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

;What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

;An implementation of the table algorithm from here: 
;    http://en.wikipedia.org/wiki/Least_common_multiple#A_method_using_a_table

;===========================================================

(defn evenly-divisible-numerator [numerator, denominator]
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
            next-results (map #(evenly-divisible-numerator % this-prime) results)]
      (if (= next-results results)
        (recur next-results top-row (rest primes)) 
        (recur next-results (conj top-row this-prime) primes))))))   


(defn euler-5 []
   (lcm (range 1 21)))
