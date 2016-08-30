; ways to make executable from the CL:
; lein exec  https://koodo.wordpress.com/2013/11/09/shell-scripting-with-clojure/
; inlein http://inlein.org/
; lein bin

(ns log.core
  (:gen-class)
  (require [clj-time.format :as f]
           [clj-time.local :as l]
           [clojure.java.io :as io]))

(def date (f/unparse (f/formatter "yyyy-MM-dd") (l/local-now)))
(def logfile (str "log/" date ".txt"))

(defn log
  "Write text to a file in the 'log' directory. New file for each day."
  [text]
  (if-not (and (.exists (io/file "log")) (.isDirectory (io/file "log")))
    (.mkdir (io/file "log")))
  (spit logfile (str text "\n") :append true))

(defn -main
  [text]
  (log text))