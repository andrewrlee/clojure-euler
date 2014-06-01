(ns euler.core
  (:gen-class))

(def src-directory (clojure.java.io/file "./src/euler/"))

(defn extract-solution-number [name] (last (re-matches #"([\d]{3})\.clj" name)))

(def filenames (map  #(.getName %) (file-seq src-directory)))

(def solutions (sort (remove nil? (map extract-solution-number filenames))))

(defn load-solutions [] (doseq [i solutions] (println "loading solution: " i)(load i)))

(load-solutions)
