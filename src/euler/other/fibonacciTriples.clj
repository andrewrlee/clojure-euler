

; Calculating pythagorean triplets using fibonaccis method:
; http://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples#Fibonacci.27s_method

(defn odd-numbers     
      ([] (odd-numbers 1))
      ([n] (cons n (lazy-seq (odd-numbers (+ 2 n))))))

(defn perfect-square? [n] 
    (let [root (Math/sqrt n)
                  floor-of-root (Math/floor root)]
          (= root floor-of-root)))

(def perfect-squares (filter perfect-square? (range 1 Integer/MAX_VALUE 2)))

(defn gather [s i]      
    (let [previous-sum (:previous-sum s)
                  triples      (:triples s     )              
                  this-sum     (+ i (:previous-sum s))
                  triple       [i  previous-sum this-sum]]                                  
          (println (Math/sqrt i) " > " (Math/sqrt previous-sum) ">" (Math/sqrt this-sum))
          (println (= (reduce + [ i  previous-sum])  this-sum))
          (assoc s :previous-sum this-sum :triples (conj triple triples))             
        ))  

(reduce gather {:previous-sum 0 :triples []}  (take-while (partial > 100000) perfect-squares))

