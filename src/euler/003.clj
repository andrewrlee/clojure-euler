(in-ns 'euler.core)

;The prime factors of 13195 are 5, 7, 13 and 29.

;What is the largest prime factor of the number 600851475143 ?

;===========================================================

(def target 600851475143)

(def max-number (int (Math/sqrt target)))

(def primes-from-sqrt-of-target
  "adapted from http://stackoverflow.com/questions/960980/fast-prime-number-generation-in-clojure"
  (filter prime? (range max-number 1 -1))) 

;===========================================================

(def target 600851475143)

(defn less-than-max? [n] (do (println n"<" max-number)(< n max-number)))

(defn is-even-divisor-of-target? [n] 
  (do 
  (= 0 (mod target n))))  

(defn euler-3 [] 
  (first (filter is-even-divisor-of-target? primes-from-sqrt-of-target))) 
