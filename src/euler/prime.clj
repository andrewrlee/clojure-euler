(ns euler.prime
    (:gen-class))

(defn prime? [n]
     (let [certainty 15]
               (.isProbablePrime (BigInteger/valueOf n) certainty)))

(def primes
    "adapted from http://stackoverflow.com/questions/960980/fast-prime-number-generation-in-clojure"
    (filter prime? (cons 2 (take-nth 2 (range 1 Integer/MAX_VALUE)))))


