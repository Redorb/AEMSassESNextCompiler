(defproject aem-sass-compiler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]

  :repositories [["Adobe" "https://repo.adobe.com/nexus/content/groups/public/"]]
  :plugin-repositories [["Adobe" "https://repo.adobe.com/nexus/content/groups/public/"]]

  :main ^:skip-aot aem-sass-compiler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
