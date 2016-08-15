; ways to make executable from the CL:
; lein exec    https://koodo.wordpress.com/2013/11/09/shell-scripting-with-clojure/
; inlein http://inlein.org/
; lein bin

(ns log.core
  (:gen-class))

(require
    ; '[clj-time.core :as time]
         ; '[clj-time.coerce :as tc]
         '[clj-time.format :as f]
         '[clj-time.local :as l]
         ; '[clojure.tools.cli :refer [cli]]
         '[clojure.java.io :as io])

(def date (f/unparse (f/formatter "yyyy-MM-dd") (l/local-now)))
(def logfile (str "log/" date ".txt"))


(defn -main
    "Write to log file. New file for each day"
    [& args]
    (def message (clojure.string/join " " args))

    (if (not (and (.exists (io/file "log")) (.isDirectory (io/file "log"))) )
        (.mkdir (io/file "log"))
    )
    (spit logfile (str message "\n") :append true)

    ; (if (.exists (io/file logfile))
    ;   (spit logfile (str "\n" message) :append true)
    ;   (spit logfile args)
    ; )
)
