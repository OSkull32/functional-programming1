(defproject functional-programming "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :profiles {:dev {:dependencies [,,, [lambdaisland/kaocha "1.91.1392"]]}}
  :plugins [[com.github.clj-kondo/lein-clj-kondo "0.2.5"], [dev.weavejester/lein-cljfmt "0.13.0"]]
  :aliases {"kaocha" ["run" "-m" "kaocha.runner"]}
  :repl-options {:init-ns functional-programming.core})

