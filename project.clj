(defproject log "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-time "0.9.0"]
                 [org.clojure/tools.cli "0.3.5"]]
  :plugins [[lein-bin "0.3.4"]]
  :bin {:name "log"}
  ; :main ^:skip-aot log.core
  :main log.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
