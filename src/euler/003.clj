(ns euler.core
  (:gen-class))

;The prime factors of 13195 are 5, 7, 13 and 29.

;What is the largest prime factor of the number 600851475143 ?

;===========================================================
;Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).

;Initially, let p equal 2, the first prime number.

;Starting from p, enumerate its multiples by counting to n in increments of p, and mark them in the list (these will be 2p, 3p, 4p, etc.; the p itself should not be marked).
;Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.

;===========================================================

(defn primes [n]
  (loop [p 2 coll (range 2 n)] 
    (if (> p (Math/sqrt n))
      coll
      (let [new-seq (filter #(or (= % p) (not= 0 (mod % p))) coll)
            new-p (first (filter #(> % p) new-seq))]
        (recur new-p new-seq)))))

(defn euler-3 [] "not implemented")
