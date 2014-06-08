(in-ns 'euler.core)

;A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;a2 + b2 = c2
;For example, 32 + 42 = 9 + 16 = 25 = 52.
;There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;Find the product abc.

;We generate pythagorean triples using Dickson's method as described here:
;http://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples#Dickson.27s_method

;===========================================================

(def positive-integers (range 1 Integer/MAX_VALUE))

(defn division-result-if-evenly-divisible [numerator, denominator]
    (let [result (quot numerator denominator)
          remainder (mod numerator denominator)]
      (if (zero? remainder) result nil)))


(defn factor-pairs [n]
  "returns a list of distinct maps of {r: n, s: smaller-factor, :t larger-factor}"
  (let [pairs (map (fn [x] [x (/ n x)])
                   (filter #(zero? (rem n %)) (range 1 (inc (Math/sqrt n)))) )]
    (distinct (map #(let [[a b] %
                          r (int (Math/sqrt (* n 2)))]
                      {:r r :s (Math/min a b) :t (Math/max a b)}) pairs))))

(defn create-triplet [m] (let [{r :r s :s t :t} m 
                              x (+ r s) 
                              y (+ r t) 
                              z (+ r s t) ] [x y z]) )

(def pythagorean-triplets 
  (map create-triplet 
       (mapcat identity
               (map factor-pairs 
                    (remove nil? (map #(division-result-if-evenly-divisible (* % %) 2) positive-integers))))))

(defn is-special? [[a b c]] (= (+ a b c ) 1000))      

(def special-pythagorean-triplet (first (filter is-special? pythagorean-triplets)))

(defn euler-9 [] (reduce * special-pythagorean-triplet))   

