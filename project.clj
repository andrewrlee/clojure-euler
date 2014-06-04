(defproject euler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :repl-options { 
                      :prompt (fn [ns] (str "\u001B[35m[\u001B[34m" ns "\u001B[35m]\u001B[33mλ:\u001B[m " ))}
  :profiles {
             :dev {
                   :dependencies [[midje "1.5.1"]]
                   :plugins [[lein-midje "3.0.0"]]}})
  
