(ns euler.core-test
   (:use [midje.sweet]
         [clojure.string :as str])
   (:require
            
            [euler.core :refer :all]))

(facts "All about splitting"
    (facts "about `split` one"
           (str/split "a/b/c" #"/") => ["a" 1 "b" "c"]
           (str/split "" #"irrelvant") => [""]
           (str/split "no regexp matches" #"a+\s+[ab]") => ["no regexp matches"])
     (facts "about `split` two"
            (str/split "a/b/c" #"/") => ["a" "b" "c"]
            (str/split "" #"irrelvant") => [""]
            (str/split "no regexp matches" #"a+\s+[ab]") => ["no regexp matches"])  
)
