(in-ns 'euler.core)

;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

;Find the sum of all the primes below two million.

;===========================================================



(defn euler-10 []
 (let [target 2000000]
     ( + 2 (reduce + (filter prime? (filter odd? (range 1 target)))) )))

;"Elapsed time: 5311.515741 msecs"

